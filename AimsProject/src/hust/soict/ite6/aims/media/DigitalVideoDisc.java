package hust.soict.ite6.aims.media;

public class DigitalVideoDisc extends Media{
    private String director;
    private int length;
    public String getDirector() {
        return director;
    }
    public int getLength() {
        return length;
    }
    private static int nbDigitalVideoDiscs = 0; // Class attribute
    public void UpdateID() {
        nbDigitalVideoDiscs++; // Increase the number of DigitalVideoDisc objects created
        id = nbDigitalVideoDiscs; // Assign the id of the DigitalVideoDisc object
    }
    public DigitalVideoDisc(String title) {
        super(title);
        UpdateID();
    }
    
    public DigitalVideoDisc(String title, String category, float cost) {
        super(title, category, cost);
        UpdateID();
    }

    public DigitalVideoDisc(String title, String category, String director, float cost) {
        super(title, category, cost);
        this.director = director;
        UpdateID();
    }

    public DigitalVideoDisc(String title, String category, String director, int length, float cost) {
        super(title, category, cost);
        this.director = director;
        this.length = length;
        UpdateID();
    }
    public void setDirector(String director) {
        this.director = director;
    }
    public void setLength(int length) {
        this.length = length;
    }
    public static int getNbDigitalVideoDiscs() { 
        return nbDigitalVideoDiscs; // Get the number of DigitalVideoDisc objects created
    }
    public String toString() {
        return id + ". DVD - " + title + " - " + category + " - " + director + " - " + length + ": " + cost + "$";
    }
}
