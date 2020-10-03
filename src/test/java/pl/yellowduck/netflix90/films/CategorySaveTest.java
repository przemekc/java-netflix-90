package pl.yellowduck.netflix90.films;


import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;
import org.junit.Test;

public class CategorySaveTest {


    @Test
    public void saveCategory() {
        Category category = new Category("Horror", "Scary movie");
        Category category2 = new Category("Comedy", "Happy movie");
        Category category3 = new Category("Drama", "Sad movie");
        Category category4 = new Category("Document", "Movie based on facts");

        SessionFactory sessionFactory = new Configuration()
                .configure("hibernate.cfg.xml")
                .addAnnotatedClass(Category.class)
                .buildSessionFactory();

        Transaction tx = null;
        try (Session session = sessionFactory.openSession()) {
            tx = session.beginTransaction();
            session.persist(category);
            session.persist(category2);
            session.persist(category3);
            session.persist(category4);

            tx.commit();

        } catch (Exception ex) {
            if (tx != null) {
                tx.rollback();
            }
            throw ex;
        }
    }
}
