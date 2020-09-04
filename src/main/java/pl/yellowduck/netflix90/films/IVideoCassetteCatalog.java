package pl.yellowduck.netflix90.resources;

import java.util.List;

public interface IVideoCassetteCatalog {
    void add(VideoCassette videoCassette) throws CatalogAddException;

    void addAll(VideoCassette... videoCassette) throws CatalogAddException;

    List<VideoCassette> getAll();
}
