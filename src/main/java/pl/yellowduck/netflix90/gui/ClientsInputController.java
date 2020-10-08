package pl.yellowduck.netflix90.gui;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
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
import pl.yellowduck.netflix90.films.Category;

import java.util.ArrayList;
import java.util.List;

public class ClientsInputController {
    private Object ObservableList;
    //private Object Gender;
    @FXML
    ChoiceBox genderInput = new ChoiceBox();
    @FXML
    TextField firstNameInput;
    @FXML
    TextField lastNameInput;
    Gender gender;
    List<Gender> genders = new ArrayList<Gender>();


//    public ChoiceBox getGenderInput() {
//        genderInput.getItems().setAll(Gender.values());
//        //gender.add(Gender.FEMALE);
//        //gender.add(Gender.MALE);
//        //genderInput.setItems(FXCollections.observableList(Gender.values()));
//        return genderInput;
//    }

    public void saveClient() {
        String firstName = firstNameInput.getText();
        String lastName = lastNameInput.getText();
       // gender = genderInput.getValue();

        if (StringUtils.isNoneBlank(firstName) && StringUtils.isNoneBlank(lastName)) {

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


