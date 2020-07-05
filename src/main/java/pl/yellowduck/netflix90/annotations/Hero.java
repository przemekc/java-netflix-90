package pl.yellowduck.netflix90.annotations;

import lombok.Getter;

import java.util.Collections;
import java.util.HashSet;
import java.util.Set;

public class Hero {

    @Getter
    private final String name;
    private Set<String> superpowers;

    public Hero(String name, String... powers) {
        this.name = name;
        this.superpowers = new HashSet<>();
        for (String power : powers) {
            this.superpowers.add(power);
        }
    }

    @Test
    public void saveWorld() {
        System.out.println("saving");
    }

    public Set<String> getSuperpowers() {
        return Collections.unmodifiableSet(superpowers);
    }

    public void addSuperPower(String... power) {
        for (String s : power) {
            System.out.println("ohh I got new power " + s);
            this.superpowers.add(s);
        }
    }
}