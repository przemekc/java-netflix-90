package pl.yellowduck.netflix90;

public class MainEnums {

    public static void main(String[] args) {
        for (Direction value : Direction.values()) {
            value.go();
        }
    }
}

enum Direction implements Go {

    EAST {
        @Override
        public void go() {
            System.out.println("going east");
        }
    },
    WEST {
        @Override
        public void go() {
            System.out.println("going west");
        }
    },
    NORTH{
        @Override
        public void go() {
            System.out.println("going north");
        }
    },
    SOUTH {
        @Override
        public void go() {
            System.out.println("going south");
        }
    }
}

interface Go {

    void go();
}
