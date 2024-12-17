package hust.soict.ite6.aims.media;

import hust.soict.ite6.aims.exception.PlayerException;
import java.util.ArrayList;
import java.util.List;

public class Track implements Playable {
    private String title;
    private int length;
    private List<Track> tracks = new ArrayList<>();

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

    public String getTitle() {
        return title;
    }

    public int getLength() {
        return length;
    }

    public void play() throws PlayerException {
        try {
            if (this.getLength() > 0) {
                System.out.println("Playing track: " + this.getTitle());
                System.out.println("Track length: " + this.getLength());
                java.util.Iterator<Track> iter = tracks.iterator();
                Track nextTrack;
                while (iter.hasNext()) {
                    nextTrack = iter.next();
                    try {
                        nextTrack.play();
                    } catch (PlayerException e) {
                        throw e;
                    }
                }
            } else {
                throw new PlayerException("ERROR: Track length is non-positive");
            }
        } catch (PlayerException e) {
            System.err.println(e.getMessage());
            throw e;
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
