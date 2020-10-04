package pl.yellowduck.netflix90.gui;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Alert;
import javafx.scene.control.TableView;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;
import org.hibernate.query.Query;
import pl.yellowduck.netflix90.films.Category;

import javax.persistence.TypedQuery;

public class CategoriesController {
    @FXML
    TableView<Category> categoriesTable;

    public void loadData(ActionEvent actionEvent) {
        SessionFactory sessionFactory = new Configuration()
                .configure("hibernate.cfg.xml")
                .addAnnotatedClass(Category.class)
                .buildSessionFactory();

        try (Session session = sessionFactory.openSession()) {

            TypedQuery<Category> query = session.createQuery("select c from Category c", Category.class);
            categoriesTable.getItems().clear();
            categoriesTable.getItems().addAll(query.getResultList());

        }catch (Exception e){
            Alert alert = new Alert(Alert.AlertType.ERROR);
            alert.setContentText(e.getMessage());
            alert.show();




        }
}}
