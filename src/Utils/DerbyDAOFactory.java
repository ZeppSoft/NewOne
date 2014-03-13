package Utils;

public class DerbyDAOFactory extends DAOFactory{
    public CarShopDAODerby getCarShopDAODerby(){
        return new CarShopDAODerby();
    }
}
