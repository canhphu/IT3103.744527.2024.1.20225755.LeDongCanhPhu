package hust.soict.ite6.test.disc;

import java.util.ArrayList;
import java.util.List;

import hust.soict.ite6.aims.media.Book;
import hust.soict.ite6.aims.media.CompactDisc;
import hust.soict.ite6.aims.media.DigitalVideoDisc;
import hust.soict.ite6.aims.media.Media;

public class TestPolymorphism {
    public static void main(String[] args) {
        List<Media> mediae = new ArrayList<Media>();
        
        //create some media here
        //for example: cd, dvd, book
        CompactDisc cd = new CompactDisc("PhuLDC-20225755", "Music", 10, "John");
        DigitalVideoDisc dvd = new DigitalVideoDisc("DVD", "Movie", 20);
        Book book = new Book("Book", "Literature", 30);

        mediae.add(cd);
        mediae.add(dvd);
        mediae.add(book);

        for(Media m : mediae) {
            System.out.println(m.toString());
        }
    }
}
