package pl.yellowduck.netflix90.films;

import pl.yellowduck.netflix90.resources.CatalogAddException;

import java.util.List;

public interface IVideoCassetteCatalog {
    void add(VideoCassette videoCassette) throws CatalogAddException;

    void addAll(VideoCassette... videoCassette) throws CatalogAddException;

    List<VideoCassette> getAll();
}
