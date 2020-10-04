package pl.yellowduck.netflix90;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;
import org.junit.Test;
import pl.yellowduck.netflix90.clients.Client;
import pl.yellowduck.netflix90.common.Gender;
import pl.yellowduck.netflix90.films.Actor;
import pl.yellowduck.netflix90.films.Director;
import pl.yellowduck.netflix90.films.VideoCassette;
import pl.yellowduck.netflix90.rentals.Rental;

import javax.persistence.EntityManager;
import javax.persistence.Persistence;
import javax.persistence.Query;
import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.List;
import java.util.Set;

public class HiberatneTest {

    @Test
    public void saveTest() {
        EntityManager entityManager = Persistence.createEntityManagerFactory("NETFLIX")
                .createEntityManager();
        entityManager.getTransaction().begin();

        Actor jimCarry = new Actor("Jim", "Carry", Gender.MALE);
        entityManager.persist(jimCarry);

        Actor jimCarry2 = new Actor("Jim2", "Carry2", Gender.MALE);
        entityManager.persist(jimCarry2);

        Director director = new Director("Jim", "Carry", Gender.MALE);
        entityManager.persist(director);

        VideoCassette film = VideoCassette.builder()
                .withPrice(BigDecimal.valueOf(15))
                .withDirector(director)
                .withTitle("Men from the Moon")
                .withActors(Set.of(jimCarry, jimCarry2))
                .build();

        entityManager.persist(film);

        Client piotrNowak = Client.builder()
                .withFirstname("Piotr")
                .withLastname("Nowak")
                .withGender(Gender.MALE)
                .build();

//        entityManager.persist(piotrNowak);

        Rental rental1 = Rental.builder()
                .withCassete(film)
                .withClient(piotrNowak)
                .withRentDays(5)
                .withRentCost(BigDecimal.valueOf(10))
                .withRentDate(LocalDate.now())
                .build();

        entityManager.persist(rental1);

        entityManager.getTransaction().commit();
    }

    @Test
    public void read() {
        EntityManager entityManager = Persistence.createEntityManagerFactory("NETFLIX")
                .createEntityManager();
        Query query = entityManager.createQuery("select c from VideoCassette c");

        List<VideoCassette> resultList = query.getResultList();
        for(VideoCassette v : resultList) {
            System.out.println(v.getTitle());
            System.out.println(v.getActorsCollection());
        }
    }

    @Test
    public void saveClient() {
        EntityManager entityManager = Persistence.createEntityManagerFactory("NETFLIX")
                .createEntityManager();

        Client piotrNowak = Client.builder()
                .withFirstname("Piotr")
                .withLastname("Nowak")
                .withGender(Gender.MALE)
                .build();

        entityManager.getTransaction().begin();
        entityManager.persist(piotrNowak);
        entityManager.getTransaction().commit();
    }

//    @Test
    public void saveClientHibernate() {
        SessionFactory sessionFactory = new Configuration()
                // plik konfiguracyjny
                .addAnnotatedClass(Client.class)
                .buildSessionFactory();

        Client piotrNowak = Client.builder()
                .withFirstname("Piotr")
                .withLastname("Nowak")
                .withGender(Gender.MALE)
                .build();

        Session session = sessionFactory.openSession();
        session.getTransaction().begin();
        session.persist(piotrNowak);
        session.getTransaction().commit();
    }

    @Test
    public void saveTest_1() {
        EntityManager entityManager = Persistence.createEntityManagerFactory("NETFLIX")
                .createEntityManager();
        entityManager.getTransaction().begin();

//        Actor actor = saveActor(entityManager);

        Actor actor = entityManager.find(Actor.class, 13);

        Query actorQuery = entityManager.createQuery("select a from Actor a");
        List<Actor> resultList = actorQuery.getResultList();

        VideoCassette videoCassette = VideoCassette.builder()
                .withActors(Set.of(resultList.get(0)))
                .build();

        entityManager.getTransaction().commit();
    }

    private Actor saveActor(EntityManager entityManager) {
        Actor actor = new Actor("Jim", "Carry", Gender.MALE);
        entityManager.persist(actor);
        return actor;
    }
}
