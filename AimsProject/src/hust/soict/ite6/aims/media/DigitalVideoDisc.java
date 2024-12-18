package hust.soict.ite6.aims.media;

import hust.soict.ite6.aims.exception.PlayerException;
import javax.swing.JOptionPane;

public class DigitalVideoDisc extends Disc implements Playable {
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

    public void play() throws PlayerException {
        int length = this.getLength();
        if (length > 0) {
            JOptionPane.showMessageDialog(null, "Playing DVD: " + this.getTitle() + "\nDVD length: " + this.getLength());
        } else {
            throw new PlayerException("ERROR: DVD length is non-positive");
        }
    }

    @Override
    public int compareTo(Media otherMedia) {
        if (otherMedia instanceof DigitalVideoDisc) {
            DigitalVideoDisc dvd = (DigitalVideoDisc) otherMedia;
            // Compare by title, then by length, then by cost
            int titleComparison = this.getTitle().compareTo(dvd.getTitle());
            if (titleComparison == 0) {
                int lengthComparison = Integer.compare(this.getLength(), dvd.getLength());
                return (lengthComparison == 0) ? Float.compare(this.getCost(), dvd.getCost()) : lengthComparison;
            }
            return titleComparison;
        }
        return super.compareTo(otherMedia);
    }
}
