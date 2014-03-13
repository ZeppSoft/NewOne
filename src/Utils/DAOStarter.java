package Utils;

public class DAOStarter {
    public static final int DERBY =1;
    public static final int MySQL =2;
    public static final int Oracle =3;
    public static CarShopDAO getDAO(){
        DerbyDAOFactory derbyDAOFactory= (DerbyDAOFactory) DAOFactory.getDAOFactory(DERBY);
        CarShopDAODerby CarShopDAO= derbyDAOFactory.getCarShopDAODerby();
        return  CarShopDAO;
    }
}
