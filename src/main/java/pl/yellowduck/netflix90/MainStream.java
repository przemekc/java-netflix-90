package pl.yellowduck.netflix90;

import org.apache.commons.lang3.StringUtils;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.function.IntBinaryOperator;
import java.util.function.Predicate;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class MainStream {

    public static void main(String[] args) {
        List<String> capitals = List.of("Warsaw", "Berlin", "Amsterdam", "Lisbona",
                "Paris", "Rome", "London");

//        List<String> capitalsWithW = new ArrayList<>();
//        for (String capital : capitals) {
//            if(capital.startsWith("W")) {
//                capitalsWithW.add(capital);
//            }
//        }

//        Set<String> w = capitals.stream()
//                .filter(p -> p.startsWith("W"))
//                .collect(Collectors.toSet());
//        System.out.println(w);

        // na wyjsciu ma byc zbior stolic zaczynajacych sie na L pisany wielkimi litermai z odwrconymi literami
        // Lisbona -> ANOBSIL

//        Set<String> capitalWithLOldSchool = new HashSet<>();
//        for (String capital : capitals) {
//            if (capital.startsWith("L")) {
//                capitalWithLOldSchool.add(StringUtils.reverse(capital.toUpperCase()));
//            }
//        }
//        System.out.println(capitalWithLOldSchool);

//        Set<String> capitalWithLReversed = capitals.stream()
//                .filter(filterWithL())
//                .map(String::toUpperCase) // .map(p -> p.toUpperCase())
//                .map(StringUtils::reverse) // .map(p -> StringUtils.reverse(p)
//                .collect(Collectors.toSet());
//        System.out.println(capitalWithLReversed);

        // wyfiltruj stolice zaczynajace sie od litery O

        capitals.stream()
                .filter(p -> p.startsWith("O"))
                .findAny()
                .ifPresentOrElse(p -> System.out.println(p),
                        () -> { // to jest metoda run z Runnable
                            System.out.println("Nie znaleziono");
                            System.out.println("To moze byc blok kodu");
                        });
    }

    private static Predicate<String> filterWithL() {
        return p -> p.startsWith("L");
    }
}
