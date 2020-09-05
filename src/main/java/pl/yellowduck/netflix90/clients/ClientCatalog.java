package pl.yellowduck.netflix90.clients;

import pl.yellowduck.netflix90.films.VideoCassette;
import pl.yellowduck.netflix90.resources.CatalogAddException;

import java.util.List;

public interface ClientCatalog {

    void add(Client client) throws CatalogAddException;

    void addAll(Client... videoCassette) throws CatalogAddException;

    List<Client> getAll();
}
