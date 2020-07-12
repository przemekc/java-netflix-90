package pl.yellowduck.netflix90.resources;

import com.fasterxml.jackson.databind.ObjectMapper;
import pl.yellowduck.netflix90.exceptions.MojBladException;

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

    @Override
    public void add(VideoCassette videoCassette) throws CassetteAddException {
        super.add(videoCassette);
        try (BufferedWriter bufferedWriter = Files.newBufferedWriter(file, StandardOpenOption.CREATE, StandardOpenOption.APPEND)){
            String string = objectMapper.writeValueAsString(videoCassette);
            bufferedWriter.write(string);
        } catch (FileNotFoundException e) {
            throw new CassetteAddException(e.getMessage());
        } catch (IOException e) {
            System.out.println(e.getMessage());
            throw new CassetteAddException(e.getMessage());
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
