package pl.yellowduck.netflix90;

import java.util.Collection;
import java.util.HashSet;
import java.util.Objects;
import java.util.Set;

public class MainSet {

    public static void main(String[] args) {
        Set<String> strings = new HashSet<>();

        String s1 = "1";
        String s2 = "1";

        boolean add = strings.add(s1);
        boolean add1 = strings.add(s2);
        System.out.println(add);
        System.out.println(add1);

        System.out.println(strings);

//        Set<LocalPerson> persons = new HashSet<>();
//
//        LocalPerson p1 = new LocalPerson("Jan", "Kowalski");
//        LocalPerson p2 = new LocalPerson("Jan", "Nowak");

//        persons.add(p1);
//        persons.add(p2);
//
//        System.out.println(persons);

//        System.out.println(p1.equals(p2));
//        System.out.println(p1.hashCode() + " " + p2.hashCode() + " " + (p1.hashCode() == p2.hashCode()));
    }
}

class LocalPerson {
    private String name;
    private String lastname;

    public LocalPerson(String name, String lastname) {
        this.name = name;
        this.lastname = lastname;
    }

    @Override
    public String toString() {
        return "LocalPerson{" +
                "name='" + name + '\'' +
                ", lastname='" + lastname + '\'' +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        LocalPerson that = (LocalPerson) o;
        return Objects.equals(name, that.name);
    }

    @Override
    public int hashCode() {
        return Objects.hash(name);
    }
}
