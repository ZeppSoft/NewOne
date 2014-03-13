package Utils;


import javax.servlet.http.HttpSession;

public interface CarShopDAO {
    public  boolean SaveUser(String login, String password);
    public  boolean ReadUser(String login, String password);
    public  boolean addOrder(Car car);
    public  String makeHTMLOrder();
    public  String makeHTMLCartOrder();
    public  boolean saveOrder();
    public  boolean loadOrder();
    public  Order getCurrentOrder();
    public  void setCurrentOrder(Order currentOrder);
    public  Order getCartOrder();
    public  void setCartOrder(Order cartOrder);
    public  User getCurrentUser();
    public  void setCurrentUser(User currentUser);
    public  void setSession(HttpSession session);
    public  HttpSession getSession();



}
