package pl.yellowduck.netflix90.resources;

import com.fasterxml.jackson.databind.ObjectMapper;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.StandardOpenOption;

public class FileSystemVideoCatalog extends UniqueVideoCassetteCatalog {

    private final Path file = Paths.get("cassetts.txt");

    private final ObjectMapper objectMapper = new ObjectMapper();

    // nie uzywc throws w konstruktorach - pewien skrot myslowy zeby nie wprowadzac wzorcow fabryki etc.
    public FileSystemVideoCatalog() {
        // tworzy plik jesli nieistnieje
        try {
            if(!Files.exists(file)) { // sprawdza czy istnieje plik
                Files.createFile(file); // utworzenie pliku
            }
        } catch (IOException e) {
            throw new CassettteReadException("Cannot create file");
        }


        try (BufferedReader bufferedReader = Files.newBufferedReader(file)) {
            String line;
            while((line = bufferedReader.readLine()) != null) {
                VideoCassette cassette = objectMapper.readValue(line, VideoCassette.class);
                // linia wyzej odpowiada mniej wiecejtemu
                // VideoCassette cassette = new VideoCassete()
                // ustawDaneNaPodstawieWartosciZLine(cassete)
                super.add(cassette);
            }
        } catch (IOException | CatalogAddException e) {
            System.out.println(e.getMessage());
            throw new CassettteReadException("Cannot read file");
        }
    }

    @Override
    public void add(VideoCassette videoCassette) throws CatalogAddException {
        super.add(videoCassette);
        try (BufferedWriter bufferedWriter = Files.newBufferedWriter(file, StandardOpenOption.CREATE, StandardOpenOption.APPEND)){
            String string = objectMapper.writeValueAsString(videoCassette);
            bufferedWriter.write(string);
            bufferedWriter.newLine();
        } catch (FileNotFoundException e) {
            throw new CatalogAddException(e.getMessage());
        } catch (IOException e) {
            System.out.println(e.getMessage());
            throw new CatalogAddException(e.getMessage());
        }
    }

    @Override
    public void addAll(VideoCassette... videoCassette) throws CatalogAddException {
        try (BufferedWriter bufferedWriter = Files.newBufferedWriter(file, StandardOpenOption.CREATE, StandardOpenOption.APPEND)){
            for (VideoCassette cassette : videoCassette) {
                super.add(cassette);
                String string = objectMapper.writeValueAsString(cassette);
                bufferedWriter.write(string);
                bufferedWriter.newLine();
            }
        } catch (FileNotFoundException e) {
            throw new CatalogAddException(e.getMessage());
        } catch (IOException e) {
            System.out.println(e.getMessage());
            throw new CatalogAddException(e.getMessage());
        }
    }

    // old school ale nadal mozna spotkac i skladniowo jest poprawne
//    @Override
//    public void addVideoCassette(VideoCassette videoCassette) throws CassetteAddException {
//        super.addVideoCassette(videoCassette);
//        BufferedWriter bufferedWriter = null;
//        try {
//            bufferedWriter = Files.newBufferedWriter(file, StandardOpenOption.CREATE, StandardOpenOption.APPEND);
//            bufferedWriter.write("cos");
//        } catch (FileNotFoundException e) {
//            throw new CassetteAddException(e.getMessage());
//        } catch (IOException e) {
//            System.out.println(e.getMessage());
//            throw new CassetteAddException(e.getMessage());
//        } finally {
//            if(bufferedWriter != null) {
//                try {
//                    bufferedWriter.close();
//                } catch (IOException e) {
//                    e.printStackTrace();
//                }
//            }
//        }
//    }
}
