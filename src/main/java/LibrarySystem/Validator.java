package LibrarySystem;

import java.io.*;
import java.util.ArrayList;
import java.util.Scanner;
import java.util.regex.Pattern;

public abstract class Validator {
    public static final String RED="\u001B[31m";
    public static final String RESET="\u001B[0m";
    public static final String BLUE = "\u001b[34m";



    //validates all Id input fields
    public static int validateId(String s){
        Scanner input = new Scanner(System.in);
        int value = 0;
        int studId = 0;
        while (value == 0) {
            System.out.print(" Enter Id"+RED+"(only +numbers allowed): "+RESET);
            s = input.nextLine();
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
    public static String validateTitle(String input, String s){
        Scanner scan = new Scanner(System.in);
        boolean flag = false;
        String pattern = "[a-zA-Z -]+";
        do {
            switch (input) {
                case "Title" -> System.out.print(" Enter Title(only alphabets): ");
                case "Topic" -> System.out.print(" Enter Topic(only alphabets): ");
                case "Summary" -> System.out.print(" Enter Summary(only alphabets): ");
                default -> System.out.print(" Enter Name(only alphabets): ");
            }

            s = scan.nextLine();
            if (s.isEmpty()) {
                System.out.println(RED+" You did not enter a value!!"+RESET);
            } else if (!s.matches(pattern)) {

                System.out.println(RED+" Please enter a valid input!!!"+RESET);
            }else{
                flag = s.matches(pattern);
            }
            //name = s;
        }while (!flag);

        return s;
    }

    /*
    Valid ISBNs
    isbns.add("0-596-52068-9");
    isbns.add("0 512 52068 9");
    isbns.add("ISBN-10 0-596-52068-9");
    isbns.add("ISBN-10: 0-596-52068-9");
     */
    public static String validateIsbn(String pattern){
        Scanner scan = new Scanner(System.in);
        String prompt;
        boolean flag = false;
        do {
            System.out.println(" Enter ISBN: ");
            prompt = scan.nextLine();
            if (prompt.isEmpty()) {
                System.out.println(RED+" You did not enter a value!!"+RESET);
            } else if (!prompt.matches(pattern)) {

                System.out.println(RED+" Please enter a valid input!!!"+RESET);
            }else{
                flag = prompt.matches(pattern);
            }

        }while (!flag);
        return prompt;
    }

    //validate publishYear/date
    public static String validateYear(){
        Scanner input = new Scanner(System.in);
        String year;
        boolean flag = false;
        String pattern = "^\\d{4}";
        do {
            System.out.print(" Enter PublishYear: ");
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
    public static int validateNumber(String prompt){
        Scanner input = new Scanner(System.in);
        int value = 0;
        int choice = 0;
        while (value == 0) {
            System.out.print(BLUE+prompt+" "+RED+"(only +numbers allowed): "+RESET);
            String num = input.nextLine();
            if (num.isEmpty()) {
                System.out.println(RED + " You did not enter a value!!" + RESET);
            } else {
                try {
                    value = Integer.parseInt(num);
                    if (value < 0 || value == 0){
                        System.out.println(RED+" Please only positive numbers allowed!!"+RESET);
                        value = 0;
                    }
                    choice = value;

                } catch (NumberFormatException ex) {
                    System.out.println(RED + " Please enter a valid input!!!" + RESET);
                }

            }

        }
        return choice;
    }

    //gets assets type
    public static Asset getAssetType(){
        Scanner scan = new Scanner(System.in);
        String s = scan.nextLine();
        int select = 0;
        while(select == 0){
            System.out.println(" Select type of asset to add ");
            System.out.println(" Type 1 - Book");
            System.out.println(" Type 2 - Cd");
            System.out.println(" Type 3 - Dissertation");
            System.out.println(" Type 4 - Exit");
            select = validateId(s);
            switch (select){
                case 1:
                    //
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
                default:
                    System.out.println(RED+" Invalid input"+RESET);
                    break;
            }
        }

        return null;
    }

    public static void printToFile(ArrayList<Author> people, String filePath){
        StringBuilder sb = new StringBuilder();
        sb.append("AuthorId");
        sb.append(",");
        sb.append("AuthorName");
        sb.append(",");
        sb.append("Number of Books");
        sb.append(",");
        sb.append("\n");

            try {
                FileWriter fr = new FileWriter(new File(filePath), true);
                BufferedWriter br = new BufferedWriter(fr);
                PrintWriter writer = new PrintWriter(br);

                if (!people.isEmpty()){

                    for (Author object:people) {
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


}
