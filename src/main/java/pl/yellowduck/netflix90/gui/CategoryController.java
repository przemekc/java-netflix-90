package pl.yellowduck.netflix90.gui;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Alert;
import javafx.scene.control.TextField;
import org.apache.commons.lang3.StringUtils;
import pl.yellowduck.netflix90.films.Category;

import javax.persistence.EntityManager;
import javax.persistence.Persistence;

public class CategoryController {

    @FXML
    TextField nameInput;

    @FXML
    TextField descriptionInput;

    public void save(ActionEvent event) {
        String name = nameInput.getText();
        String description = descriptionInput.getText();

        if (StringUtils.isNoneBlank(name) && StringUtils.isNoneBlank(description)) {
            save(name, description);
        } else {
            displayError();
        }
    }

    private void displayError() {
        Alert alert = new Alert(Alert.AlertType.ERROR);
        alert.setContentText("Fill in all fields");
        alert.show();
    }

    private void save(String name, String description) {
        try {
            Category category = new Category(name, description);

            // na skroty - NIE UZYWAC W DOBRYCH APLIKACJACH
            EntityManager entityManager = Persistence.createEntityManagerFactory("NETFLIX")
                    .createEntityManager();
            entityManager.getTransaction().begin();
            entityManager.persist(category); // SAVE
            entityManager.getTransaction().commit();
        } catch (Exception e) {
            System.out.println(e.getMessage()); // powinien byc logger
            Alert alert = new Alert(Alert.AlertType.ERROR);
            alert.setContentText(e.getMessage());
            alert.show();
        }
    }
}
