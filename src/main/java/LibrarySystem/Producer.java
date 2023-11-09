package LibrarySystem;

import java.util.ArrayList;

public class Producer extends Person{
    private ArrayList<Asset> assetProduced;


    public Producer(int id, String name, ArrayList<Asset> assetProduced) {
        super(id, name);
        this.assetProduced = assetProduced;
    }

    public ArrayList<Asset> getAssetProduced() {
        return assetProduced;
    }

    public void setAssetProduced(ArrayList<Asset> assetProduced) {
        this.assetProduced = assetProduced;
    }

    @Override
    public String toString() {
        return String.format("ProducerId: %d, ProducerName: %s", getId(), getName());
    }
}
