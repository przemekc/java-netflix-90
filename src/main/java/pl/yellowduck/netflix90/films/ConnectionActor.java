package pl.yellowduck.netflix90.films;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.boot.MetadataSources;
import org.hibernate.boot.registry.StandardServiceRegistry;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;
import org.hibernate.cfg.Configuration;
import pl.yellowduck.netflix90.common.Gender;

public class ConnectionActor {

    public static void main(String[] args) {


        StandardServiceRegistry registry = new StandardServiceRegistryBuilder()
                .configure("hibernate.cfg.xml")
                .build();

        try {
            SessionFactory sessionFactory = new MetadataSources(registry)
                    .addAnnotatedClass(Actor.class)
                    .buildMetadata()
                    .buildSessionFactory();
            Session session = sessionFactory.openSession();
            Transaction transaction = session.beginTransaction();

            Actor actor = new Actor("George", "Clooney", Gender.MALE);
            session.persist(actor);

            actor = new Actor("Sandra","Bullock", Gender.FEMALE);
            session.persist(actor);


            transaction.commit();


            session.close();


        } catch (Exception e) {
            e.printStackTrace();
            StandardServiceRegistryBuilder.destroy(registry);
        }
    }}