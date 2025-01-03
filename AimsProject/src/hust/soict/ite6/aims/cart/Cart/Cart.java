package hust.soict.ite6.aims.cart.Cart;

import java.util.ArrayList;
import java.util.Comparator;

import javax.naming.LimitExceededException;

import hust.soict.ite6.aims.media.Media;
import hust.soict.ite6.aims.media.MediaComparatorByCostTitle;
import hust.soict.ite6.aims.media.MediaComparatorByTitleCost;
import javafx.beans.Observable;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;

public class Cart {
    public static final Comparator<Media> COMPARE_BY_TITLE_COST = new MediaComparatorByTitleCost();
    public static final Comparator<Media> COMPARE_BY_COST_TITLE = new MediaComparatorByCostTitle();
    public static final int MAX_NUMBERS_ORDERED = 20;
    private static ObservableList<Media> itemsOrdered = FXCollections.observableArrayList();
        
        public static void addMedia(Media media) throws LimitExceededException {
            if(itemsOrdered.size() < MAX_NUMBERS_ORDERED) {
            itemsOrdered.add(media);
            System.out.println("LeDongCanhPhu-20225755-Added Successfully.");
        } else {
            throw new LimitExceededException("Error: The number of " + media.getTitle() + " has reached its limit.");
        }
    }


        public void removeMedia(Media media) throws Exception {
            if(itemsOrdered.size() == 0) {
            throw new Exception("LeDongCanhPhu-20225755-The cart is empty.");
            } 
            if(itemsOrdered.contains(media)) {
            itemsOrdered.remove(media);
            System.out.println("LeDongCanhPhu-20225755-Removed Successfully.");
            } else {
            throw new Exception("LeDongCanhPhu-20225755-The media is not in the cart.");
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

    public static ObservableList<Media> getItemsOrdered() {
        return FXCollections.observableArrayList(itemsOrdered);
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


    public void placeOrder() {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'placeOrder'");
    }   
}