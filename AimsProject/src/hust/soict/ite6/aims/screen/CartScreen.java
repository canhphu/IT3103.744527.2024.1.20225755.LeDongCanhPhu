package hust.soict.ite6.aims.screen;

import java.awt.Dimension;
import java.io.IOException;

import javax.swing.JFrame;

import hust.soict.ite6.aims.cart.Cart.Cart;
import hust.soict.ite6.aims.media.Book;
import hust.soict.ite6.aims.media.CompactDisc;
import hust.soict.ite6.aims.media.DigitalVideoDisc;
import javafx.application.Platform;
import javafx.embed.swing.JFXPanel;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;

public class CartScreen extends JFrame {
    private Cart cart;

    public CartScreen(Cart cart) {
        super();
        this.cart = cart;
        JFXPanel fxPanel = new JFXPanel();
        this.add(fxPanel);

        this.setTitle("Cart");
        this.setVisible(true);

        this.setSize(new Dimension(1024, 768));
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        Platform.runLater(new Runnable() {

            @Override
            public void run() {
                // TODO Auto-generated method stub
                try {
                    FXMLLoader loader = new FXMLLoader(getClass().getResource("/hust/soict/ite6/screen/cart.fxml"));
                    CartScreenController controller = new CartScreenController(cart); // Pass the cart object
                    loader.setController(controller); // Set the controller programmatically
                    Parent root = loader.load();
                    Scene scene = new Scene(root);
                    fxPanel.setScene(scene);


                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        });

    }

    public static void main(String[] args) {
        Cart cart = new Cart();
        // Compact Discs
        CompactDisc cd = new CompactDisc( "Yunomi's Vol4 CD", "Music", 10.99f, "Yunomi", 180, "Yunomi");
        CompactDisc cd1 = new CompactDisc( "PhuLDC_20225755", "Pop", 12.99f, "Aimer", 170, "Aimer");
        CompactDisc cd2 = new CompactDisc( "Nightcore Hits", "Remix", 8.99f, "Various Artists", 200, "Various");
        CompactDisc cd3 = new CompactDisc( "Jazz Vibes", "Jazz", 14.99f, "Norah Jones", 240, "Norah Jones");
        CompactDisc cd4 = new CompactDisc( "Epic Classics", "Classical", 9.99f, "Ludwig Orchestra", 120, "Beethoven");

// Digital Video Discs
        DigitalVideoDisc dvd = new DigitalVideoDisc( "Highlight MV", "Music", "Hatsune Miku", 123);
        DigitalVideoDisc dvd1 = new DigitalVideoDisc( "Interstellar", "Sci-fi", "Christopher Nolan", 169);
        DigitalVideoDisc dvd2 = new DigitalVideoDisc( "Inception", "Thriller", "Christopher Nolan", 148);
        DigitalVideoDisc dvd3 = new DigitalVideoDisc( "Frozen 2", "Animation", "Disney", 103);
        DigitalVideoDisc dvd4 = new DigitalVideoDisc( "The Matrix", "Action", "Lana Wachowski", 136);

// Books
        Book book = new Book("Dune Book", "Sci-fi", 9.99f);
        Book book1 = new Book("1984", "Dystopian", 8.99f);
        Book book2 = new Book("To Kill a Mockingbird", "Classic", 7.99f);
        Book book3 = new Book("The Hobbit", "Fantasy", 10.49f);
        Book book4 = new Book("The Catcher in the Rye", "Classic", 6.99f);

        Cart.addMedia(cd);
        Cart.addMedia(cd1);
        Cart.addMedia(cd2);
        Cart.addMedia(cd3);
        Cart.addMedia(cd4);

        Cart.addMedia(dvd);
        Cart.addMedia(dvd2);
        Cart.addMedia(dvd3);
        Cart.addMedia(dvd4);
        Cart.addMedia(dvd1);

        Cart.addMedia(book);
        Cart.addMedia(book1);
        Cart.addMedia(book2);
        Cart.addMedia(book3);
        Cart.addMedia(book4);

        new CartScreen(cart);
    }
}
