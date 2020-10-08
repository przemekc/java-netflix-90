package pl.yellowduck.netflix90.clients;

import javafx.scene.control.ChoiceBox;
import lombok.Getter;
import lombok.Setter;
import pl.yellowduck.netflix90.common.Gender;
import pl.yellowduck.netflix90.common.Person;

import javax.persistence.*;

@Entity
@Getter
@Setter
@Table(name = "client")
public class Client extends Person {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Integer id;

    public Client() {
    }

    public Client(String firstname, String lastname, Gender gender) {
        super(firstname, lastname, gender);
    }

    //public Client(String firstName, String lastName, ChoiceBox genderInput) {
    //}

    @Override
    public void introduce() {

    }

    public static ClientBuilder builder() {
        return new ClientBuilder();
    }

    public static final class ClientBuilder {
        protected Gender gender;
        private String firstname;
        private String lastname;

        private ClientBuilder() {
        }

        public ClientBuilder withFirstname(String firstname) {
            this.firstname = firstname;
            return this;
        }

        public ClientBuilder withLastname(String lastname) {
            this.lastname = lastname;
            return this;
        }

        public ClientBuilder withGender(Gender gender) {
            this.gender = gender;
            return this;
        }

        public Client build() {
            return new Client(firstname, lastname, gender);
        }
    }
}
