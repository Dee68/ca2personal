package LibrarySystem;

import java.util.ArrayList;
import java.util.Scanner;

public class LibraryServiceImpl implements LibraryServiceInterface{
    static final String RESET = "\u001B[0m";
    static final String RED = "\u001B[31m";
    static final String BLUE = "\u001b[34m";
    static final String GREEN = "\u001B[32m";
    Scanner scan = new Scanner(System.in);
    Validator validate = new Validator();
    ArrayList<Author> authors = new ArrayList<>();
    @Override
    public void addAuthor() {
     int Id = validate.validateId();
     String name = validate.validateTitle("Name");
     Author author = new Author(Id,name);
     authors.add(author);
        System.out.println(GREEN+" Author successfully created"+RESET);
    }

    @Override
    public void addAsset() {

    }

    @Override
    public void adduser() {

    }

    @Override
    public void borrowAsset() {

    }

    @Override
    public void returnAsset() {

    }

    @Override
    public void showAvailableBooks() {

    }

    @Override
    public void showBorrowedAssetsByUser(int id) {

    }

    @Override
    public void showAssetsAuthoredByAuthor(String authorName) {

    }

    @Override
    public void showOverdueAssets() {

    }

    @Override
    public void printAuthors() {

    }

    @Override
    public void printUsers() {

    }

    @Override
    public void printAssets() {

    }
}
