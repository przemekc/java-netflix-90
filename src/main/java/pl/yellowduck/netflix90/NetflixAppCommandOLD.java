package pl.yellowduck.netflix90;

import pl.yellowduck.netflix90.clients.ConcreteFileSystemClientCatalog;
import pl.yellowduck.netflix90.commands.*;

import java.util.Optional;
import java.util.Scanner;

public class NetflixAppCommandOLD {

    public static void main(String[] args) {
        System.out.println("Welcome to NetflixApp.");
        System.out.println("Choose option:");
        System.out.println("1 - Clients");
        System.out.println("2 - Films");
        System.out.println("3 - Rentals");
        System.out.println("q");

        while (true) {
            Scanner scanner = new Scanner(System.in);
            System.out.print("?: ");
            String readOption = scanner.nextLine();
            getCommand(readOption).ifPresentOrElse(
                    command -> command.handle(),
                    () -> System.out.println("Bad option. Choose one more time.")
            );
        }
    }

    private static Optional<Command> getCommand(String readOption) {
        Command command = null;
        switch (readOption) {
            case "1":
                command = new ClientsCommnad(new ConcreteFileSystemClientCatalog());
                break;
            case "2":
                command = new FilmsCommand();
                break;
            case "3":
                command = new RentalsCommand();
                break;
            case "q":
                command = new ExitCommand();
                break;
        }
        return Optional.ofNullable(command);
    }

}
