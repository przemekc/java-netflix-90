package pl.yellowduck.netflix90.films;

import lombok.Getter;
import lombok.Setter;
import pl.yellowduck.netflix90.common.Gender;

import javax.persistence.*;

@Entity
@Getter
@Setter
@Table(name = "director")
public class Director {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    protected Integer id;
    @Column
    protected String lastname;
    @Column
    protected String firstname;
    @Column
    protected Gender gender;

    public Director() {
    }

    public Director(String firstname, String lastname, Gender gender) {
        this.firstname = firstname;
        this.lastname = lastname;
        this.gender = gender;
    }
}
