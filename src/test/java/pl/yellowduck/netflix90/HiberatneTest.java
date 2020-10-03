package pl.yellowduck.netflix90;

import org.junit.Test;
import pl.yellowduck.netflix90.common.Gender;
import pl.yellowduck.netflix90.films.Actor;
import pl.yellowduck.netflix90.films.Director;

import javax.persistence.EntityManager;
import javax.persistence.Persistence;

public class HiberatneTest {

    @Test
    public void saveTest() {
        EntityManager entityManager = Persistence.createEntityManagerFactory("NETFLIX")
                .createEntityManager();
        entityManager.getTransaction().begin();

        Actor jimCarry = new Actor("Jim", "Carry", Gender.MALE);
        entityManager.persist(jimCarry);

        Director director = new Director("Jim", "Carry", Gender.MALE);
        entityManager.persist(director);

        entityManager.getTransaction().commit();
    }
}
