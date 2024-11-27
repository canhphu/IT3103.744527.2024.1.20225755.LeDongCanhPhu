package hust.soict.ite6.aims.media;

public abstract class Media {
    protected int id;
    protected String title;
    protected String category;
    protected float cost;
    private static int nbDigitalVideoDiscs = 0; // Class attribute
    public int getId() {
        return id;
    }
    public String getTitle() {
        return title;
    }
    public String getCategory() {
        return category;
    }
    public float getCost() {
        return cost;
    }
    public static int getNbDigitalVideoDiscs() {
        return nbDigitalVideoDiscs;
    }
    public void setId(int id) {
        id = nbDigitalVideoDiscs++;
        this.id = id;
    }
    public void setTitle(String title) {
        this.title = title;
    }
    public void setCategory(String category) {
        this.category = category;
    }
    public void setCost(float cost) {
        this.cost = cost;
    }
    public Media(String title, String category, float cost) {
        this.title = title;
        this.category = category;
        this.cost = cost;
    }
    public Media(String title) {
        this.title = title;
    }
   
}
