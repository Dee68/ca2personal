package LibrarySystem;

import java.time.LocalDateTime;
import java.time.LocalTime;
import java.util.Date;

public class BookAudioBook extends Asset{
    private Author author;
    private String isbn;
    private String status;
    private String publishedYear;
    private LocalTime dateIssued;
    private LocalTime dateDue;
    private String overDue;

    public BookAudioBook(String isbn, String publishedYear, Author author) throws AssetException {
        super();
        this.isbn = isbn;
        this.status = "available";
        if (Integer.parseInt(publishedYear) > 2023){
            throw new AssetException(" Publication Year can not be in the future!!!");
        }
        this.publishedYear = publishedYear;
        this.author = author;
        this.dateIssued = LocalTime.parse("00:00:00.000");
        this.dateDue = LocalTime.parse("00:00:00.000");
        this.overDue = "-";
    }

    public BookAudioBook(int id, String title, String isbn,  String publishedYear, Author author) {
        super(id, title);
        this.isbn = isbn;
        this.status = "available";
        this.publishedYear = publishedYear;
        this.author = author;
        this.dateIssued = LocalTime.parse("00:00:00.000");
        this.dateDue = LocalTime.parse("00:00:00.000");
        this.overDue = "-";
    }

    public LocalTime getDateIssued() {
        return dateIssued;
    }

    public void setDateIssued(LocalTime dateIssued) {
        this.dateIssued = dateIssued;
    }

    public LocalTime getDateDue() {
        return dateDue;
    }

    public void setDateDue(LocalTime dateDue) {
        this.dateDue = dateDue;
    }

    public String getOverDue() {
        return overDue;
    }

    public void setOverDue(String overDue) {
        this.overDue = overDue;
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
        return String.format("BookId: %d, Isbn: %s, Status: %s, Year: %s, Author: %s",
                getId(),
                getIsbn(),
                getStatus(),
                getPublishedYear(),
                getAuthor().getName());
    }
}
