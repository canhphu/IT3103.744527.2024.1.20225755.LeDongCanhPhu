package hust.soict.ite6.aims.Aims;

import java.util.Scanner;

import javax.naming.LimitExceededException;

import hust.soict.ite6.aims.cart.Cart.Cart;
import hust.soict.ite6.aims.exception.DuplicatedItemException;
import hust.soict.ite6.aims.exception.PlayerException;
import hust.soict.ite6.aims.media.Book;
import hust.soict.ite6.aims.media.CompactDisc;
import hust.soict.ite6.aims.media.DigitalVideoDisc;
import hust.soict.ite6.aims.media.Media;
import hust.soict.ite6.aims.screen.CartScreen;
import hust.soict.ite6.aims.screen.StoreScreen;
import hust.soict.ite6.aims.store.Store.Store;

public class Aims {

    private static Scanner sc;
    private static Store store;
    private static Cart cart;
    private static StoreScreen storeScreen;
    private static CartScreen cartScreen;

    public static void main(String[] args) throws LimitExceededException, PlayerException, DuplicatedItemException {
        store = new Store();
        cart = new Cart();

        Media[] sampleMedia = new Media[]{        // Compact Discs
                new CompactDisc("Yunomi's Vol4 CD", "Music", 10.99f, "Yunomi", 180, "Yunomi"),
                new CompactDisc("BachDT_20225600", "Pop", 12.99f, "Aimer", 170, "Aimer"),

// Digital Video Discs
                new DigitalVideoDisc("Highlight MV", "Music", "Hatsune Miku", 123),

// Books
                new Book("Dune Book", "Sci-fi", 9.99f),

        };
         //BachDT_20225600
        for (Media m : sampleMedia) {
            store.addMedia(m);
        }

        openStoreScreen();
    }

    public static Store getStore() {
        return store;
    }

    public static Cart getCart() {
        return cart;
    }

    public static StoreScreen getStoreScreen() {
        return storeScreen;
    }

    public static CartScreen getCartScreen() {
        return cartScreen;
    }

    public static void openStoreScreen() {
        storeScreen = new StoreScreen(store);
    }

    public static void closeStoreScreen() {
        storeScreen.setVisible(false);
        storeScreen = null;
    }

    public static void openCartScreen() {
        cartScreen = new CartScreen(cart);
    }

    public static void closeCartScreen() {
        cartScreen.setVisible(false);
        cartScreen = null;
    }

}