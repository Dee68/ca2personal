package LibrarySystem;

import java.io.*;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.StandardOpenOption;
import java.util.ArrayList;

import org.apache.commons.csv.CSVFormat;
import org.apache.commons.csv.CSVParser;
import org.apache.commons.csv.CSVPrinter;
import org.apache.commons.csv.CSVRecord;
import java.util.Scanner;

public class Author extends Person implements Printable<Author>{
    private ArrayList<BookAudioBook> booksAuthored;
    static final String GREEN = "\u001B[32m";
    static final String RESET = "\u001B[0m";


    public Author(){
        super();
        this.booksAuthored = new ArrayList<>();
    }
    public Author(int id, String name) {
        super(id, name);
        this.booksAuthored = new ArrayList<>();
    }

    public ArrayList<BookAudioBook> getBooksAuthored() {
        return booksAuthored;
    }

    public void setBooksAuthored(ArrayList<BookAudioBook> booksAuthored) {
        this.booksAuthored = booksAuthored;
    }

    @Override
    public String toString() {
        return String.format("AuthorId: %d, AuthorName: %s, Qty of Books %d", getId(), getName(), getBooksAuthored().size());
    }



    @Override
    public void printToFile(ArrayList<Author> objects,String csvFilePath) {

        StringBuilder sb = new StringBuilder();
        if (Files.notExists(Path.of(csvFilePath))){
            File file = new File(csvFilePath);
            sb.append("AuthorId");
            sb.append(",");
            sb.append("AuthorName");
            sb.append(",");
            sb.append("Number of Assets");
            sb.append(",");
            sb.append("\r\n");

        }


        try {
            FileWriter fr = new FileWriter(new File(csvFilePath), true);
            BufferedWriter br = new BufferedWriter(fr);
            PrintWriter writer = new PrintWriter(br);

            if (!objects.isEmpty()){

                for (Author object:objects) {
                    sb.append(object.getId());
                    sb.append(",");
                    sb.append(object.getName());
                    sb.append(",");
                    sb.append(((Author) object).getBooksAuthored().size());
                    sb.append(",");
                    sb.append("\n");
                }
                writer.write(sb.toString());
                writer.close();
                fr.close();
                br.close();
                System.out.println("done!");
            }
        } catch (IOException e) {
            throw new RuntimeException(e);
        }

    }


    @Override
    public ArrayList<Author> readFromCsv(String csvFile) {
        ArrayList<Author> authors = new ArrayList<>();
        try (FileReader fr = new FileReader(csvFile);
             CSVParser csvParser = CSVFormat.DEFAULT.withFirstRecordAsHeader().parse(fr)) {
            for (CSVRecord csvRecord : csvParser) {
                int authorId = Integer.parseInt(csvRecord.get("AuthorId"));
                String name = csvRecord.get("AuthorName");
                authors.add(new Author(authorId, name));
            }
        } catch (IOException e) {
            throw new RuntimeException(e);
        }

        return authors;
    }



}
