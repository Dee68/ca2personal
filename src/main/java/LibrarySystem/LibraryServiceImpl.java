package LibrarySystem;

//import java.util.ArrayList;
//import java.util.Scanner;

public class LibraryServiceImpl implements LibraryServiceInterface{
//    static final String RESET = "\u001B[0m";
//    static final String RED = "\u001B[31m";
//    static final String BLUE = "\u001b[34m";
//    static final String GREEN = "\u001B[32m";
//    Scanner scan = new Scanner(System.in);
//    ArrayList<Author> authors = new ArrayList<>();
//    @Override
//    public  Author addAuthor() {
//
//        String s = scan.nextLine();
//     int Id = Validator.validateId(s);
//     String name = Validator.validateTitle("Name", s);
//     return  new Author(Id,name);
//     //authors.add(author);
//     //System.out.println(GREEN+" Author successfully created"+RESET);
//    }
//
//    @Override
//    public Asset addAsset(String prompt) {
//        Scanner scan = new Scanner(System.in);
//        switch (prompt) {
//            case "book" -> {
//                System.out.println(" Create Library User: ");
//                String s = scan.nextLine();
//                int Id = Validator.validateId(s);
//                String name = Validator.validateTitle("Title", s);
//                String topic = Validator.validateTitle("Isbn", s);
//                String year = Validator.validateYear();
//                System.out.println(" Enter Id of author:");
//                int authId = Validator.validateId(s);
//                //get author from author list
//
//
//
//                //return new LibraryUser(Id, name);
//            }
//            case "cd" -> {
//                System.out.println(" Create Producer: ");
//                String s = scan.nextLine();
//                int Id = Validator.validateId(s);
//                String name = Validator.validateTitle("Name", s);
//                //return new Producer(Id, name);
//            }
//            case "dissertation" -> {
//                System.out.println(" Create Director: ");
//                String s = scan.nextLine();
//                int Id = Validator.validateId(s);
//                String name = Validator.validateTitle("Name", s);
//                //return new Director(Id, name);
//            }
//        }
//
//    return null;
//    }
//
//    @Override
//    public  Person adduser(String prompt) {
//        Scanner scan = new Scanner(System.in);
//        switch (prompt) {
//            case "user" -> {
//                System.out.println(" Create Library User: ");
//                String s = scan.nextLine();
//                int Id = Validator.validateId(s);
//                String name = Validator.validateTitle("Name", s);
//                return new LibraryUser(Id, name);
//            }
//            case "producer" -> {
//                System.out.println(" Create Producer: ");
//                String s = scan.nextLine();
//                int Id = Validator.validateId(s);
//                String name = Validator.validateTitle("Name", s);
//                return new Producer(Id, name);
//            }
//            case "director" -> {
//                System.out.println(" Create Director: ");
//                String s = scan.nextLine();
//                int Id = Validator.validateId(s);
//                String name = Validator.validateTitle("Name", s);
//                return new Director(Id, name);
//            }
//        }
//
//        return null;
//
//    }
//
//    @Override
//    public void borrowAsset() {
//
//    }
//
//    @Override
//    public void returnAsset() {
//
//    }
//
//    @Override
//    public void showAvailableBooks() {
//
//    }
//
//    @Override
//    public void showBorrowedAssetsByUser(int id) {
//
//    }
//
//    @Override
//    public void showAssetsAuthoredByAuthor(String authorName) {
//
//    }
//
//    @Override
//    public void showOverdueAssets() {
//
//    }
//
//    @Override
//    public void printAuthors() {
//
//    }
//
//    @Override
//    public void printUsers() {
//
//    }
//
//    @Override
//    public void printAssets() {
//
//    }
}
