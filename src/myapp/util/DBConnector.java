package myapp.util;

import java.io.InputStream;
import java.util.Properties;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;;

 
public class DBConnector {
 
    private static final SessionFactory sessionFactory;
 
    static {
        try {
        	InputStream inputStream = DBConnector.class.getClassLoader().getResourceAsStream( "/hibernate.properties" );
            Properties properties = new Properties();
                properties.load( inputStream );
                String hbcfg = properties.getProperty( "hiberNateCfgFileName" );
            sessionFactory =new Configuration().configure(hbcfg).buildSessionFactory();
        } catch (Throwable ex) {
            System.err.println("Initial SessionFactory creation failed." + ex);
            throw new ExceptionInInitializerError(ex);
        }
    }
 
    public static Session openSession() {
       Object a=new Object();
	synchronized( a)
       {
		return sessionFactory.openSession();
       }
    	
    }
}
