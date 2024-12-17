package hust.soict.ite6.aims.media;

import hust.soict.ite6.aims.exception.PlayerException;

public class Track implements Playable {
    private String title;
    private int length;
    public String getTitle() {
        return title;
    }
    public int getLength() {
        return length;
    }
    public Track(String title, int length) {
        this.title = title;
        this.length = length;
    }
    public Track(String title) {
        this.title = title;
    }
    public Track(int length) {
        this.length = length;
    }
    public void play() throws PlayerException {
        if(this.getLength() > 0) {
            System.out.println("Playing track: " + this.getTitle());
            System.out.println("Track length: " + this.getLength());
        } else {
            throw new PlayerException("ERROR: Track length is non-positive");
        }
    }

    @Override
    public boolean equals(Object o) {
        Track track = (Track) o;
        String title = track.getTitle();
        int length = track.getLength();
        return title.equals(this.getTitle()) && length == this.getLength();
    }
}
