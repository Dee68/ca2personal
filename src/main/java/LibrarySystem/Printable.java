package LibrarySystem;

import java.util.ArrayList;

public interface Printable <T>{

    void printToFile(ArrayList<T> objects, String filePath);
    ArrayList<T> readFromCsv(String csvFile);
}
