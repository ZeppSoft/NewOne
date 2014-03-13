package Utils;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;


public class DerbySingleton {
    private static EntityManager em =null;
    static EntityManager getEntity(String UNIT_NAME){
        if (em!=null ){
            return em;
        }
        else {
            EntityManagerFactory factory = Persistence.createEntityManagerFactory(UNIT_NAME);
             em = factory.createEntityManager();
            return em;
        }
    }

    private DerbySingleton(String UNIT_NAME) {
        EntityManagerFactory factory = Persistence.createEntityManagerFactory(UNIT_NAME);
        EntityManager em = factory.createEntityManager();
    }
}
