package pl.yellowduck.netflix90.commands;

import pl.yellowduck.netflix90.clients.Client;
import pl.yellowduck.netflix90.clients.ClientCatalog;
import pl.yellowduck.netflix90.clients.ConcreteFileSystemClientCatalog;
import pl.yellowduck.netflix90.common.Gender;
import pl.yellowduck.netflix90.resources.CatalogAddException;

import java.util.Scanner;

public class ClientsCommnad implements Command {

    private final ClientCatalog catalog;

    public ClientsCommnad(ClientCatalog catalog) {
        this.catalog = catalog;
    }

    @Override
    public boolean isHandle(String readOption) {
        return readOption.equalsIgnoreCase("1");
    }

    @Override
    public void handle() {
        Scanner scanner = new Scanner(System.in);
        String readOption;
        System.out.println("Clients");
        System.out.println("Choose option:");
        System.out.println("s - search");
        System.out.println("p - print");
        System.out.println("a - add new");
        System.out.println("b - back to previous");

        readOption = scanner.nextLine();

        inner:
        while (true) {
            switch (readOption) {
                case "s":
                    System.out.println("search");

                    String keyword = scanner.nextLine();

                    System.out.println("search by " + keyword);
                    System.out.println("found " + 5);

                    break;
                case "p":
                    catalog.getAll().stream()
                            .forEach(System.out::println);
                    break inner;
                case "a":
                    Client.ClientBuilder builder = Client.builder();

                    System.out.print("Fist name: ");
                    builder.withFirstname(scanner.nextLine());

                    System.out.print("Last name: ");
                    builder.withLastname(scanner.nextLine());

                    System.out.print("Gender : (" + Gender.MALE + " " + Gender.FEMALE +")");
                    builder.withGender(Gender.valueOf(scanner.nextLine()));

                    try {
                        catalog.add(builder.build());
                    } catch (CatalogAddException e) {
                        e.printStackTrace();
                    }
                    break inner;
                case "b":
                    break inner;
            }
        }
    }
}
