package hust.soict.ite6.aims.store.Store;

import java.util.ArrayList;

import javax.naming.LimitExceededException;

import hust.soict.ite6.aims.media.Media;

public class Store {
    private static ArrayList<Media> itemsInStore = new ArrayList<Media>();
    
        public static void addMedia(Media media) throws LimitExceededException {
            if(itemsInStore.size() >= 20) {
            throw new LimitExceededException("Error: The number of " + media.getTitle() + " has reached its limit.");
        } else {
            itemsInStore.add(media);
            System.out.println("LeDongCanhPhu-20225755-Added Successfully.");
        }
    }

    public static void removeMedia(Media media) throws Exception {
        if(itemsInStore.contains(media)) {
            itemsInStore.remove(media);
            System.out.println("LeDongCanhPhu-20225755-Removed Successfully.");
        } else {
            throw new Exception("LeDongCanhPhu-20225755-The media is not in the store.");
        }
    }
    //Getter and setter
    public ArrayList<Media> getItemsInStore() {
        return itemsInStore;
    }
    
    public static void printStore() {
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
    public static Media findMediabyTitle(String title) {
        for(Media media : itemsInStore) {
            if(media.getTitle().equalsIgnoreCase(title)) {
                return media;
            }
        }
        return null;
    }   
}
