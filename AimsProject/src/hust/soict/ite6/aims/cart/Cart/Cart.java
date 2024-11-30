package hust.soict.ite6.aims.cart.Cart;

import java.util.ArrayList;

import hust.soict.ite6.aims.media.Media;

public class Cart {
    public static final int MAX_NUMBERS_ORDERED = 20;
    private ArrayList<Media> itemsOrdered = new ArrayList<Media>();
    
    public void addMedia(Media media) {
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
            System.out.println("LeDongCanhPhu-20225755-The disc is not in the cart.");
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
    public void SearchbyID(int id) {
        for(Media media : itemsOrdered) {
            if(media.getId() == id) {
                System.out.println("LeDongCanhPhu-20225755-Found successfully.");
                System.out.println(media.toString());
                return;
            }
        }
        System.out.println("LeDongCanhPhu-20225755-Can't found.");
    }

    public boolean isMatch(String title) {
        for(Media media : itemsOrdered) {
            if(media.getTitle().equals(title)) {
                return true;
            }
        }
        return false;
    }

    public void SearchbyTitle(String title) {
        int check = 0;
        for(Media media : itemsOrdered) {
            if(isMatch(title)) {
                System.out.println(media.toString());
                check = 1;
            }
        }
        if(check == 1) {
            System.out.println("LeDongCanhPhu-20225755-Found successfully.");
            return;
        }
        System.out.println("LeDongCanhPhu-20225755-Can't found.");
    }

    public ArrayList<Media> getItemsOrdered() {
        return itemsOrdered;
    }

}
