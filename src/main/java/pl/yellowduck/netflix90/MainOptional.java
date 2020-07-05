package pl.yellowduck.netflix90;

import java.util.Optional;

public class MainOptional {


    public static void main(String[] args) {
        Optional<String> someString = getSomeString();
//        if(someString.isPresent()) { // if ( someString != null)
//            String s = someString.get();
//            char c = s.charAt(5);
//        }

        String myExpectedValue = someString.orElse("default");
        System.out.println(myExpectedValue);
    }

    private static Optional<String> getSomeString() {
//        return Optional.ofNullable(null);
        return Optional.empty();
    }
}
