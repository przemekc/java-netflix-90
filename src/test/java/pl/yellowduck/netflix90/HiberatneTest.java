package pl.yellowduck.netflix90;

import org.junit.Test;
import pl.yellowduck.netflix90.common.Gender;
import pl.yellowduck.netflix90.films.Actor;
import pl.yellowduck.netflix90.films.Director;
import pl.yellowduck.netflix90.films.VideoCassette;

import javax.persistence.EntityManager;
import javax.persistence.Persistence;
import javax.persistence.Query;
import java.math.BigDecimal;
import java.util.HashSet;
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
}
