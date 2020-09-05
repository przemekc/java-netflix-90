package pl.yellowduck.netflix90;

import java.util.Scanner;

public class NetflixAppOLD {

    public static void main(String[] args) {
        System.out.println("Welcome to NetflixApp.");
        System.out.println("Choose option:");
        System.out.println("1 - Clients");
        System.out.println("2 - Films");
        System.out.println("3 - Rentals");
        System.out.println("q");

        outter:
        while (true) {
            Scanner scanner = new Scanner(System.in);
            System.out.print("?: ");
            String readOption = scanner.nextLine();

            switch (readOption) {
                case "1":
                    System.out.println("Clients");
                    System.out.println("Choose option:");
                    System.out.println("s - search");
                    System.out.println("p - print");
                    System.out.println("a - add new");
                    System.out.println("b - back to previous");

                    readOption = scanner.nextLine();

                    inner:
                    while(true) {
                        switch (readOption) {
                            case "s":
                                System.out.println("search");

                                String keyword = scanner.nextLine();

                                System.out.println("search by " + keyword);
                                System.out.println("found " + 5);

                                break;
                            case "p":
                                System.out.println("print");
                                break;
                            case "a":
                                System.out.println("add new");
                                break;
                            case "b":
                                break inner;
                            case "q":
                                break outter;
                        }
                    }
                    break;

                case "2":
                    System.out.println("Films");
                    break;

                case "3":
                    System.out.println("Rentals");
                    break;

                case "q":
                    System.exit(0);
                    break;

                default:
                    System.out.println("Bad option. Choose one more time.");
                    break;
            }

        }
    }
}
