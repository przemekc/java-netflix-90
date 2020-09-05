package pl.yellowduck.netflix90.clients;

import pl.yellowduck.netflix90.common.Gender;
import pl.yellowduck.netflix90.common.Person;

public class Client extends Person {

    public Client(String firstname, String lastname, Gender gender) {
        super(firstname, lastname, gender);
    }

    @Override
    public void introduce() {

    }
}
