package pl.yellowduck.netflix90.clients;

import pl.yellowduck.netflix90.resources.AbstractFileSystemCatalog;
import pl.yellowduck.netflix90.resources.CatalogAddException;

import java.io.BufferedWriter;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.StandardOpenOption;

public class ConcreteFileSystemClientCatalog extends AbstractFileSystemCatalog<Client> {

    public ConcreteFileSystemClientCatalog() {
        super("clients.txt", Client.class);
    }
}
