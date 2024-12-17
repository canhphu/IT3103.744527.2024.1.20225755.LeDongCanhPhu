package hust.soict.ite6.aims.cart.Cart;

import java.util.ArrayList;
import java.util.Comparator;

import hust.soict.ite6.aims.media.Media;
import hust.soict.ite6.aims.media.MediaComparatorByCostTitle;
import hust.soict.ite6.aims.media.MediaComparatorByTitleCost;

public class Cart {
    public static final Comparator<Media> COMPARE_BY_TITLE_COST = new MediaComparatorByTitleCost();
    public static final Comparator<Media> COMPARE_BY_COST_TITLE = new MediaComparatorByCostTitle();
    public static final int MAX_NUMBERS_ORDERED = 20;
    private static ArrayList<Media> itemsOrdered = new ArrayList<Media>();
        
        public static void addMedia(Media media) {
            if(itemsOrdered.size() < MAX_NUMBERS_ORDERED) {
            itemsOrdered.add(media);
            System.out.println("LeDongCanhPhu-20225755-Added Successfully.");
        } else {
            System.out.println("LeDongCanhPhu-20225755-The cart is almost full.");
        }
    }

    public void removeMedia(Media media) {
        if(itemsOrdered.size() == 0) {
            System.out.println("LeDongCanhPhu-20225755-The cart is empty.");
            return;
        } if(itemsOrdered.contains(media)) {
            itemsOrdered.remove(media);
            System.out.println("LeDongCanhPhu-20225755-Removed Successfully.");
        } else {
            System.out.println("LeDongCanhPhu-20225755-The media is not in the cart.");
        }
    }
    public float totalCost() {
        float total = 0;
        for(Media media : itemsOrdered) {
            total += media.getCost();
        }
        return total;
    }
    
    public void printCart() {
        System.out.println("*************LeDongCanhPhu-20225755's CART*************");
        System.out.println("Ordered Items:");
        for(Media media : itemsOrdered) {
            System.out.println(media.toString());
        }
        System.out.println("*******************************************************");
    }
    public Media SearchbyID(int id) {
        for(Media media : itemsOrdered) {
            if(media.getId() == id) {
                return media;
            }
        }
        return null;
    }

    public boolean isMatch(String title) {
        for(Media media : itemsOrdered) {
            if(media.getTitle().equals(title)) {
                return true;
            }
        }
        return false;
    }

    public Media SearchbyTitle(String title) {
        for(Media media : itemsOrdered) {
            if(isMatch(title)) {
                return media;
            }
        }
        return null;
    }

    public static ArrayList<Media> getItemsOrdered() {
        return itemsOrdered;
    }
    public void clearCart() {
        itemsOrdered.clear();
    }
    public void sortByTitle() { 
        itemsOrdered.sort(COMPARE_BY_TITLE_COST);      
    }
    public void sortByCost(){
        itemsOrdered.sort(COMPARE_BY_COST_TITLE);
    }   
}