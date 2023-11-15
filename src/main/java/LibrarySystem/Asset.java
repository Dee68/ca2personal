package LibrarySystem;

import java.util.Scanner;

public abstract class Asset {
    private int id;
    private String title;

    public Asset() {
        this.id = fetchId();
        this.title = fetchName();
    }

    public Asset(int id, String title) {
        this.id = id;
        this.title = title;
    }

    public int fetchId(){
        Scanner scan = new Scanner(System.in);
        String s = scan.nextLine();
        return  Validator.validateId(s);
    }
    public String fetchName(){
        Scanner scan = new Scanner(System.in);
        String s = scan.nextLine();
        return Validator.validateTitle("Title", s);
    }
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }
    public abstract String toString();
}
