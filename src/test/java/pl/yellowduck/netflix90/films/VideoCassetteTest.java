package pl.yellowduck.netflix90.films;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;
import org.junit.Test;

import java.math.BigDecimal;
import java.util.HashSet;
import java.util.Set;

import static pl.yellowduck.netflix90.common.Gender.FEMALE;
import static pl.yellowduck.netflix90.common.Gender.MALE;

public class VideoCassetteTest {

    @Test
    public void saveVideoCassette() {



        SessionFactory sessionFactory = new Configuration()
                .configure("hibernate.cfg.xml")
                .addAnnotatedClass(VideoCassette.class)
                .addAnnotatedClass(Category.class)
                .addAnnotatedClass(Actor.class)
                .addAnnotatedClass(Director.class)
                .buildSessionFactory();
        Director tommy = new Director("Tommy", "Wiseau", MALE);
        Actor tommyActor = new Actor("Tommy", "Wiseau", MALE);
        Actor julitette = new Actor("Juliette", "Danielle", FEMALE);
        Actor greg = new Actor("Greg", "Sestero", MALE);
        Category category  = new Category("Horror", "Scary movie");
        Set<Actor> actors = new HashSet<>();




        Transaction tx = null;
        try (Session session = sessionFactory.openSession()) {
            tx = session.beginTransaction();
            session.persist(category);
            session.persist(tommyActor);
            actors.add(tommyActor);
            session.persist(julitette);
            actors.add(julitette);
            session.persist(greg);
            actors.add(greg);
            VideoCassette theRoom = new VideoCassette(
                    1,
                    BigDecimal.valueOf(20),
                    "The Room",
                    tommy,
                    category,
                    actors);
            session.persist(theRoom);
            tx.commit();

        } catch (Exception ex) {
            if (tx != null) {
                tx.rollback();
            }
            throw ex;
        }
    }

}