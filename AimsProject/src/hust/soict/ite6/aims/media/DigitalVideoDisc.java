package hust.soict.ite6.aims.media;

public class DigitalVideoDisc extends Disc{
    private String director;
    private int length;
    public String getDirector() {
        return director;
    }
    public int getLength() {
        return length;
    }
    public DigitalVideoDisc(String title) {
        super(title);
    }
    
    public DigitalVideoDisc(String title, String category, float cost) {
        super(title, category, cost);
    }

    public DigitalVideoDisc(String title, String category, String director, float cost) {
        super(title, category, director, cost);
    }

    public DigitalVideoDisc(String title, String category, String director, int length, float cost) {
        super(title, category, cost, director, length);
    }
    public String toString() {
        return id + ". DVD - " + title + " - " + category + " - " + director + " - " + length + ": " + cost + "$";
    }
}
