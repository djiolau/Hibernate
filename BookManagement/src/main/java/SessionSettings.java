import entities.AuthorModel;
import entities.BookModel;
import entities.ReviewModel;
import org.hibernate.SessionFactory;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;
import org.hibernate.cfg.Configuration;
import org.hibernate.cfg.Environment;
import org.hibernate.service.ServiceRegistry;

import java.util.Properties;


public class SessionSettings {
    private SessionFactory sessionFactory;

    public SessionSettings() {
        Configuration configuration = new Configuration();
        Properties properties = new Properties();
        properties.put(Environment.URL, "jdbc:mysql://localhost:3306/bookmanagement");
        properties.put(Environment.USER, "root");
        properties.put(Environment.PASS, "Locked004");
        properties.put(Environment.DRIVER, "com.mysql.jdbc.Driver");
        properties.put(Environment.SHOW_SQL, true);
        properties.put(Environment.HBM2DDL_AUTO, "update");

        configuration.setProperties(properties);
        configuration.addAnnotatedClass(AuthorModel.class);
        configuration.addAnnotatedClass(BookModel.class);
        configuration.addAnnotatedClass(ReviewModel.class);

        ServiceRegistry serviceRegistry = new StandardServiceRegistryBuilder()
                .applySettings(configuration.getProperties()).build();
        sessionFactory = configuration.buildSessionFactory(serviceRegistry);
    }

    public SessionFactory getSessionFactory() {
        return sessionFactory;
    }
}
