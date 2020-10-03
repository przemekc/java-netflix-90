package pl.yellowduck.netflix90.rentals;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.boot.MetadataSources;
import org.hibernate.boot.registry.StandardServiceRegistry;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;
import org.junit.Test;
import pl.yellowduck.netflix90.clients.Client;
import pl.yellowduck.netflix90.common.Gender;
import pl.yellowduck.netflix90.films.Actor;

import java.math.BigDecimal;
import java.time.LocalDate;

import static org.junit.Assert.*;

public class RentalTest {

    @Test
    public void shouldCreateSchemaRental(){
        StandardServiceRegistry registry = new StandardServiceRegistryBuilder()
                .configure("hibernate.cfg.xml")
                .build();

        try {
            SessionFactory sessionFactory = new MetadataSources(registry)
                    .addAnnotatedClass(Rental.class)
                    .addAnnotatedClass(Client.class)
                    .buildMetadata()
                    .buildSessionFactory();
            Session session = sessionFactory.openSession();
            Transaction transaction = session.beginTransaction();

            Client client = new Client("Helena","Styszyńska",Gender.FEMALE);
            session.persist(client);



            Rental rental = new Rental.RentalBuilder()
                    .withCasseteId("005")
                    .withRentDate(LocalDate.of(2020,05,16))
                    .withRentDays(5)
                    .withClientId(client)
                    .withRentCost(BigDecimal.valueOf(25.89))
                    .build();
            session.persist(rental);

//            actor = new Actor("Sandra","Bullock", Gender.FEMALE);
//            session.persist(actor);
//
//            actor = new Actor("Juliette","Binoche", Gender.FEMALE);
//            session.persist(actor);


            transaction.commit();


            session.close();


        } catch (Exception e) {
            fail("Error");
            e.printStackTrace();
            StandardServiceRegistryBuilder.destroy(registry);
        }
    }

}