package hust.soict.ite6.test.store.StoreTest;

import hust.soict.ite6.aims.disc.DigitalVideoDisc.DigitalVideoDisc;
import hust.soict.ite6.aims.store.Store.Store;

public class StoreTest {
    public static void main(String[] args) {
        //Create a new store
        Store store = new Store();

        //Create new dvd objects and add them to the store
        DigitalVideoDisc dvd1 = new DigitalVideoDisc("The Lion King", "Animation", "Roger Allers", 87, 19.95f);
        store.addDVD(dvd1);

        DigitalVideoDisc dvd2 = new DigitalVideoDisc("Star Wars", "Science Fiction", "Geogre Lucas", 87, 24.95f);
        store.addDVD(dvd2);

        DigitalVideoDisc dvd3 = new DigitalVideoDisc("Aladin", "Animation", 18.99f);
        store.addDVD(dvd3);
        
        //Test the removeDVD method
        store.removeDVD(dvd1);
        store.removeDVD(dvd2);
        store.removeDVD(dvd3);
        store.removeDVD(dvd1);
    }
    
}
