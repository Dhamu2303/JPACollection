package xyz.com.JPACollection;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

public class App 
{
    public static void main( String[] args )
    {
    	EntityManagerFactory emf=Persistence.createEntityManagerFactory("Collection_Type");
    	EntityManager em=emf.createEntityManager();
    	em.getTransaction().begin();
    	
    	Address a1=new Address();
    	a1.setE_pincode(637015);
    	a1.setE_city("Namakkal");
    	a1.setE_state("TamilNadu");
    	
    	Employee e1=new Employee();
    	e1.setE_id(1001);
    	e1.setE_name("Vijay");
    	e1.getAddress().add(a1);
    	
    	em.merge(e1);
    	em.getTransaction().commit();
    	em.close();
    	emf.close();
    }
}
