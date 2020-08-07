package pl.yellowduck.netflix90.resources;

import java.util.List;

public class ConcreteFileSystemVideoCatalog extends AbstractFileSystemCatalog<VideoCassette>
        implements IVideoCassetteCatalog {

    public ConcreteFileSystemVideoCatalog() {
        super("cassetts.txt", VideoCassette.class);
    }
}
