package aims;

public class DigitalVideoDisc {
    private String title;
    private String category;
    private String director;
    private int length;
    private float cost;
    public String getTitle() {
        return title;
    }
    public String getCategory() {
        return category;
    }
    public String getDirector() {
        return director;
    }
    public int getLength() {
        return length;
    }
    public float getCost() {
        return cost;
    }
    
    public DigitalVideoDisc(String title) {
        this.title = title;
    }
    
    public DigitalVideoDisc(String title, String category, float cost) {
        this.title = title;
        this.category = category;
        this.cost = cost;
    }

    public DigitalVideoDisc(String title, String category, String director, float cost) {
        this.title = title;
        this.category = category;
        this.director = director;
        this.cost = cost;
    }

    public DigitalVideoDisc(String title, String category, String director, int length, float cost) {
        this.title = title;
        this.category = category;
        this.director = director;
        this.length = length;
        this.cost = cost;
    }
    public void setTitle(String title) {
        this.title = title;
    }
    private static int nbDigitalVideoDiscs = 0; // Class attribute
    private int id; // Instance attribute
    public DigitalVideoDisc() {
        nbDigitalVideoDiscs++; // Increase the number of DigitalVideoDisc objects created
        this.id = nbDigitalVideoDiscs; // Assign the id of the DigitalVideoDisc object
    }
    public static int getNbDigitalVideoDiscs() { 
        return nbDigitalVideoDiscs; // Get the number of DigitalVideoDisc objects created
    }
    public int getId() { 
        return id; // Get the id of the DigitalVideoDisc object
    }
    public String toString() {
        return ". DVD - " + title + " - " + category + " - " + director + " - " + length + ": " + cost + "$";
    }
}
