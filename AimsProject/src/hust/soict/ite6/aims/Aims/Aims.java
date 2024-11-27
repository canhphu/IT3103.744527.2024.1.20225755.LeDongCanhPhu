package hust.soict.ite6.aims.Aims;

import hust.soict.ite6.aims.cart.Cart.Cart;
import hust.soict.ite6.aims.media.DigitalVideoDisc;

public class Aims {
    public static void main(String[] args) {
        //Create a new cart
        Cart anOrder = new Cart();
        final int MAX_NUMBERS_ORDERED = 3; 
        DigitalVideoDisc[] dvdlist = new DigitalVideoDisc[MAX_NUMBERS_ORDERED];
        //Create a new dvd objects and add them to the cart
        DigitalVideoDisc dvd1 = new DigitalVideoDisc("The Lion King", "Animation", "Roger Allers", 87, 19.95f);
        //anOrder.addDigitalVideoDisc(dvd1);
        dvdlist[0] = dvd1;
        DigitalVideoDisc dvd2 = new DigitalVideoDisc("Star Wars", "Science Fiction", "Geogre Lucas", 87, 24.95f);
        //anOrder.addDigitalVideoDisc(dvd2);
        dvdlist[1] = dvd2;
        DigitalVideoDisc dvd3 = new DigitalVideoDisc("The Lion King", "Animation", 18.99f);
        dvdlist[2] = dvd3;
        anOrder.addDigitalVideoDisc(dvdlist);
        anOrder.addDigitalVideoDisc(dvd1, dvd2);
        anOrder.addDigitalVideoDisc(dvd3);

        //print total cost of the items in the cart
        System.out.println("LeDongCanhPhu-20225755-Total cost is: ");
        System.out.println(anOrder.totalCost());

        //remove a dvd from the cart
        anOrder.removeDigitalVideoDisc(dvd2);
        System.out.println("LeDongCanhPhu-20225755-The total cost after removing a dvd is: ");
        System.out.println(anOrder.totalCost());
    }
}
