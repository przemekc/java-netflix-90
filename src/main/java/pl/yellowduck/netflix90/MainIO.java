package pl.yellowduck.netflix90;

import java.io.*;
import java.nio.charset.Charset;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.StandardOpenOption;
import java.util.List;
import java.util.function.Predicate;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class MainIO {

    public static void main(String[] args) {
        // listFiles();

//        listFileContent();
        Path path = Paths.get("/home/przemek/test.txt"); // windows user "C:/Users/przemek/test.txt"

        // operacja zapisu z dolaczaniem zawartosci do istniejacego pliku dostepne opcje w java.nio.file.StandardOpenOption

        try (BufferedWriter bufferedWriter = Files.newBufferedWriter(path, StandardOpenOption.APPEND)){
            bufferedWriter.write("Jakis tekst 2");
        } catch (IOException e) {
            System.out.println(e.getMessage());
        }
    }

    // odczyt zawartosci pliku - linia po linii
    private static void listFileContent() {
        Path path = Paths.get("/home/przemek/test.txt"); // windows user "C:/Users/przemek/test.txt"

        try (BufferedReader bufferedReader = Files.newBufferedReader(path)) {
            String line;
            while((line = bufferedReader.readLine()) != null) {
                System.out.println(line);
            }

        } catch (IOException e) {
            System.out.println("Sorry plik nie istnieje");
        }
    }

    // wylistowac zawartosc katalogu uzytkownika np C:/Users/przemekc
    private static void listFiles() throws FileNotFoundException {
        File file = new File("/home/przemek"); // windows user "C:/Users/przemek"
        if(file.exists()) {
            for (File listFile : file.listFiles()) {
                System.out.println(listFile.getName());
            }
        } else {
            throw new FileNotFoundException("Plik (katalog) nie istnieje");
        }
    }
}
