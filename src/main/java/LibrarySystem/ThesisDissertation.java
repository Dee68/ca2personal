package LibrarySystem;

public class ThesisDissertation extends Asset{
    private Author author;
    private String topic;
    private String status;
    private String summary;
    private String publishedDate;

    public ThesisDissertation(int id, String title, Author author, String topic, String summary, String publishedDate) throws AssetException {
        super(id, title);
        this.author = author;
        this.topic = topic;
        this.status = "available";
        this.summary = summary;
        this.publishedDate = publishedDate;
    }

    public Author getAuthor() {
        return author;
    }

    public void setAuthor(Author author) {
        this.author = author;
    }

    public String getTopic() {
        return topic;
    }

    public void setTopic(String topic) {
        this.topic = topic;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public String getSummary() {
        return summary;
    }

    public void setSummary(String summary) {
        this.summary = summary;
    }

    public String getPublishedDate() {
        return publishedDate;
    }

    public void setPublishedDate(String publishedDate) {
        this.publishedDate = publishedDate;
    }

    @Override
    public String toString() {
        return String.format("Author: %s, Topic: %s, Date: %s", author.getName(),topic,getPublishedDate());
    }
}
