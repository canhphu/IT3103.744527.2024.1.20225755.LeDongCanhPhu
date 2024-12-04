package hust.soict.ite6.aims.store.Store;

import java.util.ArrayList;

import hust.soict.ite6.aims.media.Media;

public class Store {
    private ArrayList<Media> itemsInStore = new ArrayList<Media>();

    public void addMedia(Media media) {
        itemsInStore.add(media);
        System.out.println("LeDongCanhPhu-20225755-Added Successfully.");
    }

    public void removeMedia(Media media) {
        if(itemsInStore.contains(media)) {
            itemsInStore.remove(media);
            System.out.println("LeDongCanhPhu-20225755-Removed Successfully.");
        } else {
            System.out.println("LeDongCanhPhu-20225755-Can't found.");
        }
    }
    //Getter and setter
    public ArrayList<Media> getItemsInStore() {
        return itemsInStore;
    }
    
    public void printStore() {
        System.out.println("*************LeDongCanhPhu-20225755's STORE*************");
        for(Media media : itemsInStore) {
            System.out.println(media.toString());
        }
        System.out.println("*******************************************************");
    }

    //Find media by ID
    public Media findMediabyID(int id) {
        for(Media media : itemsInStore) {
            if(media.getId() == id) {
                return media;
            }
        }
        return null;
    }

    //Find media by title
    public Media findMediabyTitle(String title) {
        for(Media media : itemsInStore) {
            if(media.getTitle().equalsIgnoreCase(title)) {
                return media;
            }
        }
        return null;
    }   
}
