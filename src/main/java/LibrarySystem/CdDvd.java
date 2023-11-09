package LibrarySystem;

public class CdDvd extends Asset{
    private Producer producer;
    private Director director;
    private String status;
    private int playTime;
    private String productionYear;

    public CdDvd(int id, String title, Producer producer, Director director, String status, int playTime, String productionYear) {
        super(id, title);
        this.producer = producer;
        this.director = director;
        this.status = status;
        this.playTime = playTime;
        this.productionYear = productionYear;
    }

    public Producer getProducer() {
        return producer;
    }

    public void setProducer(Producer producer) {
        this.producer = producer;
    }

    public Director getDirector() {
        return director;
    }

    public void setDirector(Director director) {
        this.director = director;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public int getPlayTime() {
        return playTime;
    }

    public void setPlayTime(int playTime) {
        this.playTime = playTime;
    }

    public String getProductionYear() {
        return productionYear;
    }

    public void setProductionYear(String productionYear) {
        this.productionYear = productionYear;
    }

    @Override
    public String toString() {
        return null;
    }
}
