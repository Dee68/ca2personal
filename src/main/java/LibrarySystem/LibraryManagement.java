package LibrarySystem;

import java.time.LocalDateTime;
import java.time.LocalTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.Scanner;

public class LibraryManagement {
    static final String RESET = "\u001B[0m";
    static final String RED = "\u001B[31m";
    static final String BLUE = "\u001b[34m";
    static final String GREEN = "\u001B[32m";
    static final String YELLOW = "\u001B[33m";

    public static void main(String[] args){
        ArrayList<Author> authors = new ArrayList<>();
        ArrayList<LibraryUser> users = new ArrayList<>();
        ArrayList<Producer> producers = new ArrayList<>();
        ArrayList<Asset> assets = new ArrayList<>();
        ArrayList<Asset> borrowedAssets = new ArrayList<>();
        ArrayList<Director> directors = new ArrayList<>();
        ArrayList<BookAudioBook> books = new ArrayList<>();
        ArrayList<CdDvd> cds = new ArrayList<>();
        LibraryServiceImpl service = new LibraryServiceImpl();
        ArrayList<ThesisDissertation> dissertations = new ArrayList<>();

        while (true){
            System.out.println(BLUE+"""
                =======================================
                    Welcome to LibraryManagement System
                =======================================
                """+RESET);
            System.out.println(BLUE+"  1. - Add Author"+RESET);
            System.out.println(BLUE+"  2. - Add Asset"+RESET);//meni menu
            System.out.println(BLUE+"  3. - Add User"+RESET);
            System.out.println(BLUE+"  4. - Add Producer*"+RESET);
            System.out.println(BLUE+"  5. - Add Director*"+RESET);
            System.out.println(BLUE+"  6. - Borrow Asset"+RESET);
            System.out.println(BLUE+"  7. - Return Asset*"+RESET);
            System.out.println(BLUE+"  8. - Display Available Books"+RESET);
            System.out.println(BLUE+"  9. - Display Assets Borrowed by a user*"+RESET);
            System.out.println(BLUE+"  10. - Display Overdue Assets*"+RESET);
            System.out.println(BLUE+"  11. - Display Assets Authored by an Author"+RESET);
            System.out.println(BLUE+"  12. - Print Authors to file"+RESET);
            System.out.println(BLUE+"  13. - Print Users to file*"+RESET);
            System.out.println(BLUE+"  14. - Print Assets to file"+RESET);
            System.out.println(BLUE+"  15. - Exit"+RESET);

            int choice = Validator.validateNumber(" Enter Choice:");
            label:
            switch (choice){
                case 1:
                    //add author
                    Author author = new Author();
                    System.out.println(GREEN+" Author with Id: " + author.getId() +" successfully created"+RESET);
                    authors.add(author);
                    break;
                case 2:
                    //check type of asset to add
                    String assetType = getAssetType("Add");
                    switch (assetType) {
                        case "Book":
                            System.out.println("Get author by Id and add book authored ...");
                            if (authors.isEmpty()) {
                                System.out.println(RED + " No author added to list, please add an author first!!" + RESET);
                                break label;
                            }
                            Scanner scanner = new Scanner(System.in);
                            String t = scanner.nextLine();
                            Author author1 = findAuthorById(authors, Validator.validateNumber(" Enter AuthorID: "));

                            if (author1 == null) {
                                System.out.println(RED + " Author with given Id not found!!!" + RESET);
                                break label;
                            }
                            int id = Validator.validateId(t);
                            String title = Validator.validateTitle("Title", t);
                            String regex = "^(?:ISBN(?:-10)?:? )?(?=[0-9X]{10}$|(?=(?:[0-9]+[- ]){3})[- 0-9X]{13}$)[0-9]{1,5}[- ]?[0-9]+[- ]?[0-9]+[- ]?[0-9X]$";
                            String isbn = Validator.validateIsbn(regex);
                            String year = Validator.validateYear();
                            while (Integer.parseInt(year) > 2023){
                                System.out.println(RED+" Publication year can not be in the future!!!"+RESET);
                                year = Validator.validateYear();
                            }
                            BookAudioBook book = new BookAudioBook(id, title, isbn, year, author1);
                            //add book to list of authored books
                            author1.getBooksAuthored().add(book);
                            books.add(book);
                            assets.add(book);
                            System.out.println(GREEN + " Book with Id: "+ book.getId()+" successfully created" + RESET);
                            break label;

                        case "Cd":
                            System.out.println(" Get producer by Id and add Cd produced ...");
                            System.out.println(" Get director by Id and add Cd directed ...");
                            break label;
                        case "Dissertation":
                            System.out.println("Get author by Id and add book authored ...");
                            break label;
                        default:
                            break label;

                    }

                case 3:
                    //add user
                    LibraryUser user = new LibraryUser();
                    System.out.println(GREEN+" User with Id: "+user.getId()+" successfully created"+RESET);
                    users.add(user);
                    break;
                case 4:
                    //
                    break;
                case 5:
                    //
                    break;
                case 6:
                    //get type of asset to borrow
                    String assetToBorrow = getAssetType("Borrow");
                    if (assetToBorrow.equals("Book")){
                        System.out.println(" Get user by Id ...");
                        if (users.isEmpty()){
                            System.out.println(RED+" No user added yet, please add user first"+RESET);
                            break;
                        }
                        LibraryUser user1 = findUserById(users, Validator.validateNumber("Enter UserId: "));
                        if (user1 == null){
                            System.out.println();
                            break;
                        }
                        if (books.isEmpty()){
                            System.out.println(RED+" No book added yet, add book first"+RESET);
                            break;
                        }
                        System.out.println(" Get book by Id to borrow ...");
                        int bookId = Validator.validateNumber("Enter bookId: ");
                        for (BookAudioBook book:books) {
                            if (book.getId() == bookId && book.getStatus().equals("available")){
                                book.setStatus("Not available");
                                //DateTimeFormatter dtf = DateTimeFormatter.ofPattern("yyyy/MM/dd HH:mm:ss");
                                book.setDateIssued(LocalTime.now());
                                book.setDateDue(LocalTime.now().plusHours(1));
                                //book.setDateIssued(LocalDateTime.parse(dtf.format(LocalDateTime.now())));
                                //book.setDateDue(LocalDateTime.parse(dtf.format(LocalDateTime.now().plusHours(1))));
                                user1.getBorrowedBooks().add(book);
                                borrowedAssets.add(book);
                                System.out.println(GREEN+" Book borrowed successfully!!!"+RESET);
                                break;
                            }
                            if (book.getStatus().equals("Not available")) System.out.println(" Book not available to borrow");
                            break;
                        }

                        break;
                    } else if (assetToBorrow.equals("Cd")) {
                        System.out.println(" Get user by Id ...");
                    } else if (assetToBorrow.equals("Dissertation")) {
                        System.out.println(" Get user by Id ...");
                    }
                    break;
                case 7:
                    //return asset borrowed
                    String returnAsset = getAssetType("Return");
                    if (returnAsset.equals("Book")){
                        System.out.println(" Get Id of book to return ...");
                        break;
                    } else if (returnAsset.equals("Cd")) {
                        System.out.println(" Get Id of cd to return ...");
                        break;
                    } else if (returnAsset.equals("Dissertation")) {
                        System.out.println(" Get Id of thesis to return ...");
                        break;
                    }

                case 8:
                    //display available books
                    if (books.isEmpty()){
                        System.out.println(RED+" No book yet in the catalogue!!!"+RESET);
                        break;
                    }
                    System.out.println("=======================================================================");
                    String str1 = String.format(" %-10s | %-10s | %-10s | %-10s | %-10s | %10s ","ISBN","Title","Year","Status","Author","OverDue");
                    System.out.println(str1);
                    System.out.println("=======================================================================");
                    for (BookAudioBook book:books) {
                        LocalTime now = LocalTime.now();
                        LocalTime dateDue = book.getDateDue();
                        System.out.println(now);
                        System.out.println(dateDue);
                        if (now.compareTo(dateDue) > 0){
                         book.setOverDue("Overdue");
                        }
                        String str = String.format(" %-10s  %-10s  %-10s  %-10s  %-10s %-10s",
                                book.getIsbn(),
                                book.getTitle(),
                                book.getPublishedYear(),
                                book.getStatus(),
                                book.getAuthor().getName(),
                                book.getOverDue());
                        System.out.println(str);
                    }

                    break;
                case 9:
                    //
                    break;
                case 10:
                    //

                    break;
                case 11:
                    //
                    break;
                case 12:
                    //
                    System.out.println(GREEN+" Printing author(s) result to file(authors.csv)..."+RESET);
                    if (authors.isEmpty()){
                        System.out.println(RED+" No authors added yet. Please add a author first."+RESET);
                        break;
                    }

                    authors.get(0).printToFile(authors,"authors.csv");
                    System.out.println(GREEN+" Author(s) results printed to file."+RESET);
                    authors.get(0).readFromCsv("authors.csv");
                    break;
                case 13:
                    //
                    break;
                case 14:
                    //
                    break;
                case 15:
                    //exit loop
                    System.out.println(GREEN+" \033[1mThank you for using the application."+RESET);
                    System.exit(0);
                default:
                    System.out.println(RED+" Invalid input: Please pay attention to instructions!!!"+RESET);
            }
        }
    }
    public static Person getPersonType(){
        return null;
    }

    public static BookAudioBook findBookById(ArrayList<BookAudioBook> books, int Id){
        for (BookAudioBook book:books) {
            if (book.getId() == Id){
                return book;
            }
        }
        return null;
    }
    public static Author findAuthorById(ArrayList<Author> authors, int Id){
        for (Author author:authors) {
            if (author.getId() == Id){
                return author;
            }
        }
        return null;
    }
    public static LibraryUser findUserById(ArrayList<LibraryUser> users, int Id){
        for (LibraryUser user:users) {
            if (user.getId() == Id){
                return user;
            }
        }
        return null;
    }

    public static String getAssetType(String prompt){
        int select = 0;
        while (select == 0){
            System.out.println(" Select type of asset you wish to "+YELLOW+prompt+": "+RESET);
            System.out.println(" Type 1 - Book");
            System.out.println(" Type 2 - Dissertation");
            System.out.println(" Type 3 - Cd");
            System.out.println(" Type 4 - Exit");
            select = Validator.validateNumber(" Enter Choice: ");
            switch (select){
                case 1:
                    return "Book";

                case 2:
                    //
                    return "Dissertation";
                case 3:
                    //
                    return "Cd";
                case 4:
                    //
                    System.out.println(RED+" Choose an asset type to add!!!"+RESET);
                    break;
                default:
                    System.out.println(RED+" Invalid input,follow instructions!!"+RESET);
                    break;
            }

        }
        return "";
    }

}
