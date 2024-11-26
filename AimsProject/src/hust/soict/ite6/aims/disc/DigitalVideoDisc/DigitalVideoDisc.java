package hust.soict.ite6.aims.disc.DigitalVideoDisc;

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
    private static int nbDigitalVideoDiscs = 0; // Class attribute
    private int id; // Instance attribute
    public void UpdateID() {
        nbDigitalVideoDiscs++; // Increase the number of DigitalVideoDisc objects created
        id = nbDigitalVideoDiscs; // Assign the id of the DigitalVideoDisc object
    }
    public DigitalVideoDisc(String title) {
        this.title = title;
        UpdateID();
    }
    
    public DigitalVideoDisc(String title, String category, float cost) {
        this.title = title;
        this.category = category;
        this.cost = cost;
        UpdateID();
    }

    public DigitalVideoDisc(String title, String category, String director, float cost) {
        this.title = title;
        this.category = category;
        this.director = director;
        this.cost = cost;
        UpdateID();
    }

    public DigitalVideoDisc(String title, String category, String director, int length, float cost) {
        this.title = title;
        this.category = category;
        this.director = director;
        this.length = length;
        this.cost = cost;
        UpdateID();
    }
    public void setTitle(String title) {
        this.title = title;
    }
    
    public void setCategory(String category) {
        this.category = category;
    }
    public void setDirector(String director) {
        this.director = director;
    }
    public void setLength(int length) {
        this.length = length;
    }
    public void setCost(float cost) {
        this.cost = cost;
    }
    public static int getNbDigitalVideoDiscs() { 
        return nbDigitalVideoDiscs; // Get the number of DigitalVideoDisc objects created
    }
    public int getId() { 
        return id; // Get the id of the DigitalVideoDisc object
    }
    public String toString() {
        return id + ". DVD - " + title + " - " + category + " - " + director + " - " + length + ": " + cost + "$";
    }
}
