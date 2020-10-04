package pl.yellowduck.netflix90.gui;


import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Alert;
import javafx.scene.control.TextField;
import org.apache.commons.lang3.StringUtils;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;
import pl.yellowduck.netflix90.films.Category;

public class CategoryController {
    @FXML
    TextField nameInput;
    @FXML
    TextField descriptionInput;

    public void save(ActionEvent actionEvent) {
        String name = nameInput.getText();
        String description = descriptionInput.getText();


        if (StringUtils.isNoneBlank(name) && StringUtils.isNoneBlank(description)) {

            Category category = new Category(name, description);
            SessionFactory sessionFactory = new Configuration()
                    .configure("hibernate.cfg.xml")
                    .addAnnotatedClass(Category.class)
                    .buildSessionFactory();

            Transaction tx = null;
            try (Session session = sessionFactory.openSession()) {
                tx = session.beginTransaction();
                session.persist(category);


                tx.commit();}
            }else{
                Alert alert = new Alert(Alert.AlertType.ERROR);
                alert.setContentText("Fill in all fields");
                alert.show();
            }

        }
    }

