package pl.yellowduck.netflix90.resources;

import java.util.ArrayList;
import java.util.List;

/**
 * Katalog dodaje i zwraca liste dostepnych video cassete
 * @author przemek
 */
public class VideoCassetteCatalog implements IVideoCassetteCatalog {

    private final List<VideoCassette> cassettes = new ArrayList<>();

    @Override
    public void addVideoCassette(VideoCassette videoCassette) {
        cassettes.add(videoCassette);
    }

    @Override
    public void addVideoCassette(VideoCassette... videoCassette) {
        for (VideoCassette cassette : videoCassette) {
            addVideoCassette(cassette); // reuzycie metody addVideoCassette
        }
    }

    @Override
    public List<VideoCassette> getVideoCassettes() {
        return cassettes;
    }
}
