package pl.yellowduck.netflix90.resources;

import java.util.List;

public interface IVideoCassetteCatalog {
    void add(VideoCassette videoCassette) throws CassetteAddException;

    void addAll(VideoCassette... videoCassette) throws CassetteAddException;

    List<VideoCassette> getVideoCassettes();
}
