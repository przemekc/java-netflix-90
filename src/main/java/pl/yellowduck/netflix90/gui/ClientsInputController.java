package pl.yellowduck.netflix90.gui;

import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Alert;
import javafx.scene.control.ChoiceBox;
import javafx.scene.control.TextField;
import org.apache.commons.lang3.StringUtils;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;
import pl.yellowduck.netflix90.clients.Client;
import pl.yellowduck.netflix90.common.Gender;

import java.net.URL;
import java.util.Objects;
import java.util.ResourceBundle;

public class ClientsInputController implements Initializable {

    @FXML
    ChoiceBox<Gender> genderInput = new ChoiceBox();

    @FXML
    TextField firstNameInput;

    @FXML
    TextField lastNameInput;


    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        this.genderInput.getItems().setAll(Gender.values());
    }

    public void saveClient() {
        String firstName = firstNameInput.getText();
        String lastName = lastNameInput.getText();
       Gender gender = this.genderInput.getValue();

        if (StringUtils.isNoneBlank(firstName) &&
            StringUtils.isNoneBlank(lastName) &&
            !Objects.isNull(gender)) {

            Client client = new Client(firstName, lastName, gender);
            SessionFactory sessionFactory = new Configuration()
                    .configure("hibernate.cfg.xml")
                    .addAnnotatedClass(Client.class)
                    .buildSessionFactory();

            Transaction tx = null;
            try (Session session = sessionFactory.openSession()) {
                tx = session.beginTransaction();
                session.persist(client);


                tx.commit();
            }
        } else {
            Alert alert = new Alert(Alert.AlertType.ERROR);
            alert.setContentText("Fill in all fields");
            alert.show();
        }

    }
}


