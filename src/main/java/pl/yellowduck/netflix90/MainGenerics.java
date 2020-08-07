package pl.yellowduck.netflix90;

import pl.yellowduck.netflix90.resources.Actor;
import pl.yellowduck.netflix90.resources.Gender;
import pl.yellowduck.netflix90.resources.Person;

import java.util.ArrayList;
import java.util.List;

public class MainGenerics {

    public static void main(String[] args) {
        MojaKlasa<String> mojaKlasa = new MojaKlasa<>();

        String mojObiekt = mojaKlasa.getMojObiekt();

        mojaKlasa.setMojObiekt("test");

        MojaKlasa<Integer> mojaKlasa1 = new MojaKlasa<>(10);
        Integer mojObiekt1 = mojaKlasa1.getMojObiekt();

        println("sss");
        println(new Actor("jan", "kowalski", Gender.MALE));
    }

    public static <T> void println(T s) {
        System.out.println(s);
    }

}

