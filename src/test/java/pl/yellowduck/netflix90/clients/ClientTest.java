package pl.yellowduck.netflix90.clients;

import junit.framework.TestCase;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.boot.MetadataSources;
import org.hibernate.boot.registry.StandardServiceRegistry;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;
import org.junit.Test;
import pl.yellowduck.netflix90.common.Gender;

import static org.junit.Assert.fail;

public class ClientTest {


    @Test
    public void ShouldAddNewClientToDB() {
        StandardServiceRegistry registry = new StandardServiceRegistryBuilder()
                .configure("hibernate.cfg.xml")
                .build();

        try {
            SessionFactory sessionFactory = new MetadataSources(registry)
                    .addAnnotatedClass(Client.class)
                    .buildMetadata()
                    .buildSessionFactory();
            Session session = sessionFactory.openSession();
            Transaction transaction = session.beginTransaction();

            Client client = new Client( "Piotr", "Paweł", Gender.MALE);
            session.persist(client);

            client = new Client("Jacek", "Jacenty", Gender.FEMALE);
            session.persist(client);

            transaction.commit();

            session.close();


        } catch (Exception e) {
            fail("Error");
            e.printStackTrace();
            StandardServiceRegistryBuilder.destroy(registry);
        }
    }
}

