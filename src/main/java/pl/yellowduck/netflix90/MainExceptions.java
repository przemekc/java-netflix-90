package pl.yellowduck.netflix90;

public class MainExceptions {

    public static void main(String[] args) throws ValidationException {
        m1();
    }

    private static void m1() throws ValidationException {
//        try {
            m2();
//        } catch (ValidationException e) {
//            System.out.println("Error occured: " + e.getMessage());
//        }
    }

    private static void m2() throws ValidationException {
        m3();
    }

    private static void m3() throws ValidationException {
        throw new ValidationException("aa");
    }
}

class ValidationException extends Exception {

    public ValidationException(String msg) {
        super(msg);
    }
}
