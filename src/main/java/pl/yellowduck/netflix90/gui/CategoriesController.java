package pl.yellowduck.netflix90.gui;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Alert;
import javafx.scene.control.TableView;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;
import pl.yellowduck.netflix90.films.Category;

import javax.persistence.EntityManager;
import javax.persistence.Persistence;
import javax.persistence.TypedQuery;
import java.util.List;

public class CategoriesController {

    @FXML
    TableView<Category> categoriesTable;

    public void loadData(ActionEvent event) {
        EntityManager session = Persistence.createEntityManagerFactory("NETFLIX")
                .createEntityManager();

//        SessionFactory sessionFactory = new Configuration()
//                .configure("hibernate.cfg.xml")
//                .addAnnotatedClass(Category.class)
//                .buildSessionFactory();
//        try (Session session = sessionFactory.openSession()) {
        try {
            /// wykonywanie zapytanie

            TypedQuery<Category> query = session.createQuery("select c from Category c", Category.class);
            categoriesTable.getItems().clear();

            List<Category> resultList = query.getResultList();
            categoriesTable.getItems().addAll(resultList);

        } catch (Exception e) {
            Alert alert = new Alert(Alert.AlertType.ERROR);
            alert.setContentText(e.getMessage());
            alert.show();
        }
    }
}
