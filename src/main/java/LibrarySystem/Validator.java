package LibrarySystem;

import java.util.Scanner;
import java.util.regex.Pattern;

public class Validator {
    public final String RED="\u001B[31m";
    public final String RESET="\u001B[0m";
    public final String BLUE = "\u001b[34m";
    private static Pattern publishYear = Pattern.compile("^\\d{4}");
    //validates all Id input fields
    public int validateId(){
        Scanner input = new Scanner(System.in);
        int value = 0;
        int studId = 0;
        while (value == 0) {
            System.out.print(" Enter Id"+RED+"(only +numbers allowed): "+RESET);
            String s = input.nextLine();
            if (s.isEmpty()) {
                System.out.println(RED+" You did not enter a value!!" + RESET);
            } else {
                try {
                    value = Integer.parseInt(s);
                    if (value < 0){
                        value = 0;
                        System.out.println(RED+" Please only positive numbers allowed!!!"+RESET);
                    }

                    studId = value;
                    studId += (int)Math.floor(Math.random()*1000 + 1);


                } catch (NumberFormatException ex) {
                    System.out.println(" NumberFormatException: For input: "+RED + s + RESET);
                }
            }
        }
        return studId;
    }
    //validates all string input fields that requires only alphabets
    public String validateTitle(String input){
        Scanner scan = new Scanner(System.in);
        String name;
        boolean flag = false;
        String pattern = "[a-zA-Z ]+";
        do {
            switch (input) {
                case "Title" -> System.out.print(" Enter Title(only alphabets): ");
                case "Topic" -> System.out.print(" Enter Topic(only alphabets): ");
                case "ISBN" -> System.out.print(" Enter ISBN(only alphabets): ");
                case "Summary" -> System.out.print(" Enter Summary(only alphabets): ");
                default -> System.out.print(" Enter Name(only alphabets): ");
            }

            String s = scan.nextLine();
            if (s.isEmpty()) {
                System.out.println(RED+" You did not enter a value!!"+RESET);
            } else if (!s.matches(pattern)) {

                System.out.println(RED+" Please enter a valid input!!!"+RESET);
            }else{
                flag = s.matches(pattern);
            }
            name = s;
        }while (!flag);

        return name;
    }

    //validate publishYear/date
    public String validateYear(){
        Scanner input = new Scanner(System.in);
        String year;
        boolean flag = false;
        String pattern = "^\\d{4}";
        do {
            System.out.print(" Enter PublishYear(only alphabets): ");
            String s = input.nextLine();
            if (s.isEmpty()) {
                System.out.println(RED+" You did not enter a value!!"+RESET);
            } else if (!s.matches(pattern)) {

                System.out.println(RED+" Please enter a valid input!!!"+RESET);
            }else{
                flag = s.matches(pattern);
            }
            year = s;
        }while (!flag);

        return year;
    }

    //validate number choice input
    public int validateNumber(){
        Scanner input = new Scanner(System.in);
        int value = 0;
        int choice = 0;
        while (value == 0) {
            System.out.print(BLUE+"  Enter Choice: "+RED+"(only +numbers allowed): "+RESET);
            String s = input.nextLine();
            if (s.isEmpty()) {
                System.out.println(RED + " You did not enter a value!!" + RESET);
            } else {
                try {
                    value = Integer.parseInt(s);
                    if (value < 0){
                        value = 0;
                        System.out.println(RED+" Please only positive numbers allowed!!"+RESET);
                    }
                    choice = value;

                } catch (NumberFormatException ex) {
                    System.out.println(RED + " Please enter a valid input!!!" + RESET);
                }

            }

        }
        return choice;
    }

}
