package LibrarySystem;

public class BookAudioBook extends Asset{
    private Author author;
    private String isbn;
    private String status;
    private String publishedYear;

    public BookAudioBook() {
        super();
    }

    public BookAudioBook(int id, String title, String isbn, String status, String publishedYear, Author author) {
        super(id, title);
        this.isbn = isbn;
        this.status = status;
        this.publishedYear = publishedYear;
        this.author = author;
    }

    public String getIsbn() {
        return isbn;
    }

    public void setIsbn(String isbn) {
        this.isbn = isbn;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public String getPublishedYear() {
        return publishedYear;
    }

    public void setPublishedYear(String publishedYear) {
        this.publishedYear = publishedYear;
    }

    public Author getAuthor() {
        return author;
    }

    public void setAuthor(Author author) {
        this.author = author;
    }

    @Override
    public String toString() {
        return null;
    }
}
