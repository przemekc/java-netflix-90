package pl.yellowduck.netflix90.resources;

import pl.yellowduck.netflix90.films.FileSystemVideoCatalog;

public class FileSystemVideoCatalogTest {

    public static void main(String[] args) {
        FileSystemVideoCatalog catalog = new FileSystemVideoCatalog();

        System.out.println("Katalog:" + catalog.getAll());

//        VideoCassette videoCassette1 = new VideoCassette(
//                "V001",
//                BigDecimal.valueOf(20),
//                "The room",
//                new Director("Tommy", "Wiseau", Gender.MALE),
//                Category.DRAMA,
//                Set.of(new Actor("Tommy", "Wiseau", Gender.MALE)));
//
//        VideoCassette videoCassette2 = new VideoCassette(
//                "V002",
//                BigDecimal.valueOf(20),
//                "The room",
//                new Director("Tommy", "Wiseau", Gender.MALE),
//                Category.DRAMA,
//                Set.of(new Actor("Tommy", "Wiseau", Gender.MALE)));
//
//        try {
//            catalog.addAll(videoCassette1, videoCassette2);
//            System.out.println("Katalog:" + catalog.getVideoCassettes());
//        } catch (CassetteAddException e) {
//            e.printStackTrace();
//        }
    }
}
