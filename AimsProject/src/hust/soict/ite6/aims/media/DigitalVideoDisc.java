package hust.soict.ite6.aims.media;

public class DigitalVideoDisc extends Disc implements Playable{
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
    public void play() {
        System.out.println("Playing DVD: " + this.getTitle());
        System.out.println("DVD length: " + this.getLength());
    }
    @Override
    public int compareTo(Media otherMedia) {
        if(otherMedia instanceof DigitalVideoDisc) {
            DigitalVideoDisc dvd = (DigitalVideoDisc) otherMedia;
            // Compare by title, then by length, then by cost
            int titleComparison = this.getTitle().compareTo(dvd.getTitle());
            if(titleComparison == 0) {
                int lengthComparison = Integer.compare(this.getLength(), dvd.getLength());
                return (lengthComparison == 0) ? Float.compare(this.getCost(), dvd.getCost()) : lengthComparison;
            }
            return titleComparison;
        }
        return super.compareTo(otherMedia);
    }
}
