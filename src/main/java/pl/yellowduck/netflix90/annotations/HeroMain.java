package pl.yellowduck.netflix90.annotations;

import java.lang.annotation.Annotation;
import java.lang.reflect.AnnotatedType;
import java.lang.reflect.Method;

public class HeroMain {

    public static void main(String[] args) {
        Hero antman = new Hero("Antman", "power1", "power2");

        System.out.println(antman.getName());
        System.out.println(antman.getSuperpowers());

        antman.addSuperPower("power3");

        System.out.println("after add\n" + antman.getSuperpowers());

        antman.getSuperpowers().add("bad super power");

        System.out.println("after add\n" + antman.getSuperpowers());

//        Hero spiderman = new Hero("Spiderman");
//        Method[] methods = spiderman.getClass().getMethods();
//        for (Method method : methods) {
//            System.out.println(method.getName());
//            Test declaredAnnotations = method.getAnnotation(Test.class);
//            System.out.println(declaredAnnotations);
//        }

    }
}
