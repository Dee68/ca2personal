package LibrarySystem;

import java.util.ArrayList;
import java.util.Scanner;

public abstract class Person{
    private int id;
    private String name;

    public Person() {
        this.id = fetchId();
        this.name = fetchName();
    }
    public Person(int id, String name) {
        this.id = id;
        this.name = name;
    }

    public int fetchId(){
        Scanner scan = new Scanner(System.in);
        String s = scan.nextLine();
        return  Validator.validateId(s);
    }
    public String fetchName(){
        Scanner scan = new Scanner(System.in);
        String s = scan.nextLine();
        return Validator.validateTitle("Name", s);
    }
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
    public abstract String toString();

}
