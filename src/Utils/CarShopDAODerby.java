package Utils;

import javax.persistence.*;
import java.util.List;

public class CarShopDAODerby implements CarShopDAO{
    public static User currentUser =new User("","");
    public static Order currentOrder = new Order();
    public static Order cartOrder = new Order();
    public static EntityManager em = null;
    public static String connection = "EclipseLink";
     static  {
        em = DerbySingleton.getEntity(connection);

    }
    public  Order getCurrentOrder() {
        return currentOrder;
    }

    public  void setCurrentOrder(Order currentOrder) {
        CarShopDAODerby.currentOrder = currentOrder;
    }

    public  Order getCartOrder() {
        return cartOrder;
    }

    public  void setCartOrder(Order cartOrder) {
        CarShopDAODerby.cartOrder = cartOrder;
    }

    public  boolean SaveUser(String login, String password){
        User usr = new User(login,password);
        em.getTransaction().begin();
        em.persist(usr);
        em.getTransaction().commit();
        return true;
    }
    public  boolean ReadUser(String login, String password){
        TypedQuery<User> query = em.createQuery("SELECT u from User u where u.login like :login and u.password like :password", User.class);
        query.setParameter("login",login);
        query.setParameter("password",password);

        try {
           currentUser= query.getSingleResult();
            return true;
        }
        catch (javax.persistence.NoResultException e){
            return false;
        }
    }
    public  boolean addOrder(Car car){
        cartOrder.getCars().add(car);
        return  true;
    }
    public  User getCurrentUser() {
        return currentUser;
    }

    public  void setCurrentUser(User currentUser) {
        CarShopDAODerby.currentUser = currentUser;
    }

    public  String makeHTMLOrder(){
        String res = "<table border=\"1\" >";
        for (Car c: currentOrder.getCars()){
            res+="<tr> <td>"+c.getModelName()+" "+c.getColor()+" "+c.getHullType()+ " "+c.getIsHatch()+ "</td></tr>";
        }
        res+="</table>";

        return res;
    }
    public  String makeHTMLCartOrder(){
        String res = "<table border=\"1\" >";
        for (Car c: cartOrder.getCars()){
            res+="<tr> <td>"+c.getModelName()+" "+c.getColor()+" "+c.getHullType()+ " "+c.getIsHatch()+ "</td></tr>";
        }
        res+="</table>";

        return res;
    }
    public  boolean saveOrder(){
        if (cartOrder.getCars().isEmpty() || currentUser.equals(new User("","")))
            return false;

        cartOrder.setOwner(currentUser);
        em.getTransaction().begin();
        em.persist(cartOrder);
        for(Car c:cartOrder.getCars()){
            c.setOrder(cartOrder);
            em.persist(c);
        }
        em.getTransaction().commit();

        return true;
    }

    public  boolean loadOrder(){
          TypedQuery<Order> query = em.createQuery("select o from Order o where o.owner = :id ",Order.class);
            query.setParameter("id",currentUser);//currentUser.getId());
          List<Order> orderList = query.getResultList();
          for (Order o:orderList){
              for (Car c: o.getCars()){
                  currentOrder.getCars().add(c);
              }
          }
        return true;
    }
}
