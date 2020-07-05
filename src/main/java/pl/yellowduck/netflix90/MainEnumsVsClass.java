package pl.yellowduck.netflix90;

public class MainEnumsVsClass {

    public static void main(String[] args) {
//        System.out.println(Direction2.EAST.getClass());
//        System.out.println(Direction2.EAST.getDeclaringClass());
//
//        System.out.println("===========");
//        System.out.println(new TestObject().getClass());
        for (Direction2 value : Direction2.values()) {
            value.go();
        }
    }
}

enum Direction2 implements Go2 {
    EAST {
        @Override
        public void go() {
            System.out.println("going east (local implementation)");
        }
    },
    WEST,
    NORTH,
    SOUTH;


    @Override
    public void go() {
        System.out.println("going " + name() + " (global implementation)");
    }
}

interface Go2 {
    void go();
}

class TestObject {

}