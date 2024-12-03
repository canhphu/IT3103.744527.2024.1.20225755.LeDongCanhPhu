package hust.soict.ite6.test.cart.CartTest;

import hust.soict.ite6.aims.cart.Cart.Cart;
import hust.soict.ite6.aims.media.DigitalVideoDisc;

public class CartTest {
    public static void main(String[] args) {
        //Create a new cart
        Cart cart = new Cart();

        //Create new dvd objects and add them to the cart
        DigitalVideoDisc dvd1 = new DigitalVideoDisc("The Lion King", "Animation", "Roger Allers", 87, 19.95f);
        cart.addMedia(dvd1);

        DigitalVideoDisc dvd2 = new DigitalVideoDisc("Star Wars", "Science Fiction", "Geogre Lucas", 87, 24.95f);
        cart.addMedia(dvd2);

        DigitalVideoDisc dvd3 = new DigitalVideoDisc("Aladin", "Animation", 18.99f);
        cart.addMedia(dvd3);
        
        //Test the print method
        cart.printCart();
        //To-do: Test the search methods here
        cart.SearchbyID(1);
        cart.SearchbyID(0);
        cart.SearchbyTitle("The Lion King");
        cart.SearchbyTitle("Doraemon");
    }
}
