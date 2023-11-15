package LibrarySystem;

import java.io.*;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.ArrayList;
import java.util.Scanner;

public class Author extends Person implements Printable<Author>{
    private ArrayList<BookAudioBook> booksAuthored;


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
    public void printToFile(ArrayList<Author> objects, String filePath) {
        StringBuilder sb = new StringBuilder();
        if (Files.notExists(Path.of(filePath))){
            File file = new File(filePath);
            sb.append("AuthorId");
            sb.append(",");
            sb.append("AuthorName");
            sb.append(",");
            sb.append("Number of Books");
            sb.append(",");
            sb.append("\r\n");

        }


        try {
            FileWriter fr = new FileWriter(new File(filePath), true);
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
        String line = "";
        try {
            BufferedReader br = new BufferedReader(new FileReader(csvFile));
            br.readLine();//read headers
            while ((line = br.readLine()) != null){
                String [] tokens = line.split(",");
                if (tokens.length > 0){
                    Author author = new Author(Integer.parseInt(tokens[0]),tokens[1]);
                    authors.add(author);
                }
            }
            System.out.println("==============================================================");
            String str1 = String.format("%-10s %-10s %-10s","AuthorId","AuthorName","Qty Books");
            System.out.println(str1);
            System.out.println("==============================================================");
            for (Author auth:authors) {
                String str = String.format("%-10d %-10s %-10d", auth.getId(), auth.getName(),auth.getBooksAuthored().size());
                System.out.println(str);
            }
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
        return authors;
    }



}
