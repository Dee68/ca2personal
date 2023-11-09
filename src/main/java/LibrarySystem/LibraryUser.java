package LibrarySystem;

import java.util.ArrayList;

public class LibraryUser extends Person{
    private ArrayList<Asset> borrowedBooks;


    public LibraryUser(int id, String name, ArrayList<Asset> borrowedBooks) {
        super(id, name);
        this.borrowedBooks = borrowedBooks;
    }

    public ArrayList<Asset> getBorrowedBooks() {
        return borrowedBooks;
    }

    public void setBorrowedBooks(ArrayList<Asset> borrowedBooks) {
        this.borrowedBooks = borrowedBooks;
    }

    @Override
    public String toString() {
        return String.format("UserId: %d, UserName: %s",getId(),getName());
    }
}
