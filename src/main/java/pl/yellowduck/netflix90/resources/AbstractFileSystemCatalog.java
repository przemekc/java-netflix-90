package pl.yellowduck.netflix90.resources;

import com.fasterxml.jackson.databind.ObjectMapper;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.StandardOpenOption;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public abstract class AbstractFileSystemCatalog<T> {

    private final Set<T> elements = new HashSet<>();

    private final Path file;

    private final ObjectMapper objectMapper = new ObjectMapper();

    private final Class<T> clazz;

    // nie uzywc throws w konstruktorach - pewien skrot myslowy zeby nie wprowadzac wzorcow fabryki etc.
    public AbstractFileSystemCatalog(String path, Class<T> clazz) {
        this.file = Path.of(path);
        this.clazz = clazz;
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
                T cassette = objectMapper.readValue(line, clazz);
                // linia wyzej odpowiada mniej wiecejtemu
                // VideoCassette cassette = new VideoCassete()
                // ustawDaneNaPodstawieWartosciZLine(cassete)
                add(cassette);
            }
        } catch (IOException | CatalogAddException e) {
            System.out.println(e.getMessage());
            throw new CassettteReadException("Cannot read file");
        }
    }

    public void add(T obj) throws CatalogAddException {
        try (BufferedWriter bufferedWriter = Files.newBufferedWriter(file, StandardOpenOption.CREATE, StandardOpenOption.APPEND)){
            String string = objectMapper.writeValueAsString(obj);
            bufferedWriter.write(string);
            bufferedWriter.newLine();
        } catch (FileNotFoundException e) {
            throw new CatalogAddException(e.getMessage());
        } catch (IOException e) {
            System.out.println(e.getMessage());
            throw new CatalogAddException(e.getMessage());
        }
    }

    public void addAll(T... objs) throws CatalogAddException {
        try (BufferedWriter bufferedWriter = Files.newBufferedWriter(file, StandardOpenOption.CREATE, StandardOpenOption.APPEND)){
            for (T obj : objs) {
                add(obj);
                String string = objectMapper.writeValueAsString(obj);
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

    public List<T> getAll() {
        return new ArrayList<>(elements);
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
