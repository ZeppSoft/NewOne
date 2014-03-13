package Utils;

public  abstract class DAOFactory {
    public static final int DERBY =1;
    public static final int MySQL =2;
    public static final int Oracle =3;
    public static DAOFactory getDAOFactory(int whichFactory){
        switch (whichFactory){
            case DERBY:
                return new DerbyDAOFactory();

            default:
                return null;
        }

    }
}
