package hust.soict.ite6.aims.media;

import java.awt.Component;
import java.util.ArrayList;
import java.util.List;

import javax.swing.JOptionPane;

import hust.soict.ite6.aims.exception.PlayerException;

public class CompactDisc extends Disc implements Playable {
    private String artist;
    private List<Track> tracks = new ArrayList<Track>();
    public String getArtist() {
        return artist;
    }
    public CompactDisc(String title, String artist) {
        super(title);
        this.artist = artist;
    }
    public CompactDisc(String title, String category, float cost, String artist) {
        super(title, category, cost);
        this.artist = artist;
    }
    public CompactDisc(String title, String category, String director, float cost, String artist) {
        super(title, category, director, cost);
        this.artist = artist;
    }
    public CompactDisc(String title, String category, float cost, String director, int length, String artist) {
        super(title, category, cost, director, length);
        this.artist = artist;
    }
    public void addTrack(Track track) {
        if(tracks.indexOf(track)==-1) {
            System.out.println("Track is already in list");
            return;
        }
        tracks.add(track);
        System.out.println("Add track successfully");
    }
    public void removeTrack(Track track) {
        if(tracks.indexOf(track) == -1) {
            System.out.println("Track is not in list");
            return;
        }
        tracks.remove(tracks.indexOf(track));
        System.out.println("Remove track successfully");
    }
    public int getLength() {
        int length = 0;
        for(Track track : tracks) {
            length += track.getLength();
        }
        setLength(length);
        return length;
    }
    public void play() throws PlayerException {
        int length = this.getLength();
        if(length <= 0) {
            System.err.println("CD length is non-positive");
        } else {
            JOptionPane.showMessageDialog(null, "Playing CD: " + this.getTitle() + "\nCD length: " + this.getLength());
            for(Track track : tracks) {
                track.play();
            }
        }
    }
    public List<Track> getTracks() {
        // TODO Auto-generated method stub
        return tracks;
    }
}
