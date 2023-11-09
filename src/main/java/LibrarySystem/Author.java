package LibrarySystem;

import java.util.ArrayList;

public class Author extends Person{
    private ArrayList<BookAudioBook> booksAuthored;

    public Author() {
        super();
    }

    public Author(int id, String name, ArrayList<BookAudioBook> booksAuthored) {
        super(id, name);
        this.booksAuthored = booksAuthored;
    }

    public ArrayList<BookAudioBook> getBooksAuthored() {
        return booksAuthored;
    }

    public void setBooksAuthored(ArrayList<BookAudioBook> booksAuthored) {
        this.booksAuthored = booksAuthored;
    }

    @Override
    public String toString() {
        return String.format("AuthorId: %d, AuthorName: %s", getId(), getName());
    }
}
