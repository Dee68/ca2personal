package LibrarySystem;

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
        ArrayList<BookAudioBook> books = new ArrayList<>();
        ArrayList<CdDvd> cds = new ArrayList<>();
        LibraryServiceImpl service = new LibraryServiceImpl();
        Validator validate = new Validator();
        ArrayList<ThesisDissertation> dissertations = new ArrayList<>();
        while (true){
            System.out.println(BLUE+"""
                =======================================
                    Welcome to LibraryManagement System
                =======================================
                """+RESET);
            System.out.println(BLUE+"  1. - Add Author"+RESET);
            System.out.println(BLUE+"  2. - Add Asset"+RESET);
            System.out.println(BLUE+"  3. - Add User"+RESET);
            System.out.println(BLUE+"  4. - Borrow Asset"+RESET);
            System.out.println(BLUE+"  5. - Return Asset"+RESET);
            System.out.println(BLUE+"  6. - Display Available Books"+RESET);
            System.out.println(BLUE+"  7. - Display Assets Borrowed by a user"+RESET);
            System.out.println(BLUE+"  8. - Display Overdue Assets"+RESET);
            System.out.println(BLUE+"  9. - Display Assets Authored by an Author"+RESET);
            System.out.println(BLUE+"  10. - Print Authors to file"+RESET);
            System.out.println(BLUE+"  11. - Print Users to file"+RESET);
            System.out.println(BLUE+"  12. - Print Assets to file"+RESET);
            System.out.println(BLUE+"  13. - Exit"+RESET);
            int choice = validate.validateNumber();
            switch (choice){
                case 1:
                    //add author
                    service.addAuthor();
                    break;
                case 2:
                    //
                    break;
                case 3:
                    //
                    break;
                case 4:
                    //
                    break;
                case 5:
                    //
                    break;
                case 6:
                    //
                    break;
                case 7:
                    //
                    break;
                case 8:
                    //
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
                    break;
                case 13:
                    //exit loop
                    System.out.println(GREEN+" \033[1mThank you for using the application."+RESET);
                    System.exit(0);
                default:
                    System.out.println(RED+" Invalid input: Please pay attention to instructions!!!"+RESET);
            }
        }
    }

}
