package pl.yellowduck.netflix90.resources;

import java.util.List;

public interface IVideoCassetteCatalog {
    void addVideoCassette(VideoCassette videoCassette);

    void addVideoCassette(VideoCassette... videoCassette);

    List<VideoCassette> getVideoCassettes();
}
