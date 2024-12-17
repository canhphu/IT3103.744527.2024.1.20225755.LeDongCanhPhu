package hust.soict.ite6.aims.Aims;

import java.util.Scanner;

import javax.naming.LimitExceededException;

import hust.soict.ite6.aims.cart.Cart.Cart;
import hust.soict.ite6.aims.exception.PlayerException;
import hust.soict.ite6.aims.media.Book;
import hust.soict.ite6.aims.media.CompactDisc;
import hust.soict.ite6.aims.media.DigitalVideoDisc;
import hust.soict.ite6.aims.media.Media;
import hust.soict.ite6.aims.store.Store.Store;

public class Aims {
    public static void main(String[] args) throws Exception, PlayerException, LimitExceededException {
        //Create a new cart
        Cart anOrder = new Cart();
        Store aStore = new Store();
        Scanner num = new Scanner(System.in);
        //Compact Disc
        CompactDisc cd1 = new CompactDisc("Phu.LDC-20225755", "Pop", 15.99f, "Michael Jackson");
        CompactDisc cd2 = new CompactDisc("Back in Black", "Rock", 12.99f, "AC/DC");
        CompactDisc cd3 = new CompactDisc("The Dark Side of the Moon", "Progressive Rock", 14.99f, "Pink Floyd");
        CompactDisc cd4 = new CompactDisc("The Bodyguard", "Soundtrack", 11.99f, "Whitney Houston");
        CompactDisc cd5 = new CompactDisc("Rumours", "Rock", 13.99f, "Fleetwood Mac");

        //Digital Video Disc
        DigitalVideoDisc dvd1 = new DigitalVideoDisc("The Lion King", "Animation", "Roger Allers", 87, 19.95f);
        DigitalVideoDisc dvd2 = new DigitalVideoDisc("Star Wars", "Science Fiction", "George Lucas", 121, 24.95f);
        DigitalVideoDisc dvd3 = new DigitalVideoDisc("Aladdin", "Animation", "Ron Clements", 90, 18.99f);
        DigitalVideoDisc dvd4 = new DigitalVideoDisc("Phu.LDC-20225755", "Crime", "Francis Ford Coppola", 175, 29.99f);
        DigitalVideoDisc dvd5 = new DigitalVideoDisc("Pulp Fiction", "Crime", "Quentin Tarantino", 154, 22.99f);
        
        //Book
        Book book1 = new Book("To Kill a Mockingbird", "Fiction", 10.99f);
        Book book2 = new Book("1984", "Dystopian", 8.99f);
        Book book3 = new Book("The Great Gatsby", "Classic", 12.99f);
        Book book4 = new Book("Moby Dick", "Adventure", 15.99f);
        Book book5 = new Book("War and Peace", "Historical", 20.99f);

        Store.addMedia(cd1);
        Store.addMedia(cd2);
        Store.addMedia(cd3);
        Store.addMedia(cd4);
        Store.addMedia(cd5);

        Store.addMedia(dvd1);
        Store.addMedia(dvd2);
        Store.addMedia(dvd3);
        Store.addMedia(dvd4);
        Store.addMedia(dvd5);

        Store.addMedia(book1);
        Store.addMedia(book2);
        Store.addMedia(book3);
        Store.addMedia(book4);
        Store.addMedia(book5);
        
        // Add 3 CDs and 2 DVDs to the order
        Cart.addMedia(cd1);
        Cart.addMedia(cd2);
        Cart.addMedia(cd3);
        Cart.addMedia(dvd1);
        Cart.addMedia(dvd2);

        Media mediabytitle;
        int numberofDVD = 0;
        showMenu(); //Show Menu
        int option = num.nextInt();
        while(option != 0) {
            if(option < 0 || option > 3) { //Exception
                System.out.println("Invalid option. Please choose again.");
                showMenu();
                option = num.nextInt();
            }
            if(option == 1) { //View Store
                Store.printStore();
                storeMenu(); //Store Menu
                int option1 = num.nextInt();
                num.nextLine(); // Consume the newline character
                while(option1 != 0) {
                    if(option1 < 0 || option1 > 4) { //Exception
                        System.out.println("Invalid option. Please choose again.");
                        storeMenu();
                        option1 = num.nextInt();
                        num.nextLine(); // Consume the newline character
                    }
                    if(option1 == 1) { //See a media's detail
                        System.out.print("Enter the title: ");
                        String title = num.nextLine();
                        mediabytitle = Store.findMediabyTitle(title); //Find media by title
                        if(mediabytitle != null) {
                            System.out.println(mediabytitle.toString());
                            mediaDetailsMenu(); //Media Detail Menu
                            int option3 = num.nextInt();
                            num.nextLine(); // Consume the newline character
                            while(option3 != 0) {
                                if(option3 < 0 || option3 > 2) { //Exception
                                    System.out.println("Invalid option. Please choose again.");
                                    mediaDetailsMenu();
                                    option3 = num.nextInt();
                                }
                                if(option3 == 1) { //Add to cart
                                    Cart.addMedia(mediabytitle);
                                    storeMenu();
                                    option1 = num.nextInt();
                                    num.nextLine(); // Consume the newline character
                                    break;
                                }
                                if(option3 == 2) { //Play
                                    if(mediabytitle instanceof DigitalVideoDisc) {
                                        ((DigitalVideoDisc) mediabytitle).play();
                                    }
                                    else if(mediabytitle instanceof CompactDisc) {
                                        ((CompactDisc) mediabytitle).play();
                                    }else {
                                        System.out.println("Can't play this media.");
                                    }
                                    mediaDetailsMenu();
                                    option3 = num.nextInt();
                                }
                            }
                            if(option3 == 0) {
                                storeMenu();
                                option1 = num.nextInt();
                                num.nextLine(); // Consume the newline character
                            }
                        }else {
                            System.out.println("Can't found the media you're looking for.");
                            storeMenu();
                            option1 = num.nextInt();
                            num.nextLine(); // Consume the newline character
                        }
                    }
                    if(option1 == 2) { //Add a media to cart
                        Store.printStore();
                        System.out.print("Choose the media you want to add: ");
                        mediabytitle = Store.findMediabyTitle(num.nextLine());
                        if(mediabytitle != null) {
                            Cart.addMedia(mediabytitle);
                            if(mediabytitle instanceof DigitalVideoDisc) {
                                numberofDVD++;
                            }
                            System.out.println("The number of DVD in the cart is: " + numberofDVD); 
                            storeMenu();
                            option1 = num.nextInt();
                            num.nextLine(); // Consume the newline character
                        }else {
                            System.out.println("Can't found the media you're looking for.");
                            storeMenu();
                            option1 = num.nextInt();
                            num.nextLine(); // Consume the newline character
                        }
                    }
                    if(option1 == 3) { //Play a media
                        Store.printStore();
                        System.out.print("Choose the media you want to play: ");
                        mediabytitle = Store.findMediabyTitle(num.nextLine());
                        if(mediabytitle instanceof DigitalVideoDisc) {
                            ((DigitalVideoDisc) mediabytitle).play();
                        }
                        else if(mediabytitle instanceof CompactDisc) {
                            ((CompactDisc) mediabytitle).play();
                        }else {
                            System.out.println("Can't play this media.");
                        }
                        storeMenu();
                        option1 = num.nextInt();
                        num.nextLine(); // Consume the newline character
                    }
                    if(option1 == 4) { //See current cart
                        anOrder.printCart();
                        System.out.print("Press any key to go back: ");
                        int back = num.nextInt();
                        num.nextLine(); // Consume the newline character
                        storeMenu();
                        option1 = num.nextInt();
                    }
            }
            if(option1 == 0) {
                showMenu();
                option = num.nextInt();
            }
        }
        if(option == 2) { //Update Store
            Store.printStore();
            System.out.println("What do you want to do?");
            System.out.print("0-Remove\n1-Add: ");
            int option4 = num.nextInt();
            num.nextLine(); // Consume the newline character
            if(option4 != 0 && option4 != 1) {
                System.out.println("Invalid option. Please choose again.");
                option4 = num.nextInt();
            }
            if(option4 == 0) { //Remove
                System.out.print("Enter the title: ");
                mediabytitle = Store.findMediabyTitle(num.nextLine());
                Store.removeMedia(mediabytitle);
                Store.printStore();
                System.out.print("Press any key to go back: ");
                String back = num.nextLine();
                showMenu();
                option = num.nextInt();
            } if(option4 == 1) { //Add
                System.out.println("Choose the type of media you want to add:\n0-Book\n1-DVD\n2-CD");
                int option5 = num.nextInt();
                num.nextLine(); // Consume the newline character
                if(option5 == 0) { //Book
                    System.out.print("Enter the title: ");
                    String title = num.nextLine();
                    System.out.print("Enter the category: ");
                    String category = num.nextLine();
                    System.out.print("Enter the cost: ");
                    float cost = num.nextFloat();
                    Book book = new Book(title, category, cost);
                    Store.addMedia(book);
                    Store.printStore();
                    System.out.print("Press any key to go back: ");
                    String back = num.nextLine();
                    showMenu();
                    option = num.nextInt();
                }else if(option5 == 1) { //DVD
                    System.out.print("Enter the title: ");
                    String title = num.nextLine();
                    System.out.print("Enter the category: ");
                    String category = num.nextLine();
                    System.out.print("Enter the director: ");
                    String director = num.nextLine();
                    System.out.print("Enter the length: ");
                    int length = num.nextInt();
                    System.out.print("Enter the cost: ");
                    float cost = num.nextFloat();
                    DigitalVideoDisc dvd = new DigitalVideoDisc(title, category, director, length, cost);
                    Store.addMedia(dvd);
                    Store.printStore();
                    System.out.print("Press any key to go back: ");
                    String back = num.nextLine();
                    showMenu();
                    option = num.nextInt();
                }else if(option5 == 2) { //CD
                    System.out.print("Enter the title: ");
                    String title = num.nextLine();
                    System.out.print("Enter the category: ");
                    String category = num.nextLine();
                    System.out.print("Enter the cost: ");
                    float cost = num.nextFloat();
                    num.nextLine(); // Consume the newline character
                    System.out.print("Enter the artist: ");
                    String artist = num.nextLine();
                    CompactDisc cd = new CompactDisc(title, category, cost, artist);
                    Store.addMedia(cd);
                    Store.printStore();
                    System.out.print("Press any key to go back: ");
                    String back = num.nextLine();
                    showMenu();
                    option = num.nextInt();
                }else {
                    System.out.println("Invalid option. Please choose again.");
                    option5 = num.nextInt();
                }
            }
        }
        if(option == 3) { //See current cart
            anOrder.printCart();
            cartMenu();
            int option2 = num.nextInt();
            num.nextLine(); // Consume the newline character
            while(option2 != 0) {
                if(option2 < 0 || option2 > 5) { //Exception
                    System.out.println("Invalid option. Please choose again.");
                    cartMenu();
                    option2 = num.nextInt();
                }
                if(option2 == 1) { //Filter medias in cart
                    System.out.println("Choose an option the filer:\n0-ID\n1-Title");
                    int option6 = num.nextInt();
                    num.nextLine(); // Consume the newline character
                    if(option6 == 0) { //Filter by ID
                        System.out.print("Enter the ID: ");
                        int id = num.nextInt();
                        Media mediabyid = anOrder.SearchbyID(id);
                        if(mediabyid != null) {
                            System.out.println(mediabyid.toString());
                        }else { 
                            System.out.println("Can't found the media you're looking for.");
                        }
                        cartMenu();
                        option2 = num.nextInt();
                    } else if(option6 == 1) { //Title
                        System.out.println("Enter the title: ");
                        mediabytitle = anOrder.SearchbyTitle(num.nextLine());
                        if(mediabytitle != null) {
                            System.out.println(mediabytitle.toString());
                        }else {
                            System.out.println("Can't found the media you're looking for.");
                        }
                        cartMenu();
                        option2 = num.nextInt();
                    } else {
                        System.out.println("Invalid option. Please choose again.");
                    }
                }
                if(option2 == 2) { //Sort medias in cart
                    System.out.println("Choose an option to sort:\n 0-Cost\n1-Title");
                    int option7 = num.nextInt();
                    num.nextLine(); // Consume the newline character
                    if(option7 == 0) { //Sort by cost
                        anOrder.sortByCost();
                        anOrder.printCart();
                        cartMenu();
                        option2 = num.nextInt();
                        num.nextLine(); // Consume the newline character
                    } else if(option7 == 1) { //Sort by title
                        anOrder.sortByTitle();
                        anOrder.printCart();
                        cartMenu();
                        option2 = num.nextInt();
                        num.nextLine(); // Consume the newline character  
                    } else {
                        System.out.println("Invalid option. Please choose again.");
                    }
                }
                if(option2 == 3) {
                    anOrder.printCart();
                    System.out.print("Enter the title: ");
                    mediabytitle = anOrder.SearchbyTitle(num.nextLine());
                    if(mediabytitle != null) {
                        anOrder.removeMedia(mediabytitle);
                        anOrder.printCart();
                        cartMenu();
                        option2 = num.nextInt();
                        num.nextLine(); // Consume the newline character
                    }else {
                        System.out.println("Can't found the media you're looking for.");
                        cartMenu();
                        option2 = num.nextInt();
                        num.nextLine(); // Consume the newline character
                    }
                }
                if(option2 == 4) { //Play a media
                    anOrder.printCart();
                    System.out.print("Choose the CD/DVD you want to play: ");
                    mediabytitle = anOrder.SearchbyTitle(num.nextLine());
                    if(mediabytitle == null) {
                        System.out.println("Can't found the media you're looking for.");
                        cartMenu();
                        option2 = num.nextInt();
                        num.nextLine(); // Consume the newline character
                    }
                    if(mediabytitle instanceof DigitalVideoDisc) {
                        ((DigitalVideoDisc) mediabytitle).play();
                        cartMenu();
                        option2 = num.nextInt();
                        num.nextLine(); // Consume the newline character
                    }
                    else if(mediabytitle instanceof CompactDisc) {
                        ((CompactDisc) mediabytitle).play();
                        cartMenu();
                        option2 = num.nextInt();
                        num.nextLine(); // Consume the newline character
                    }else {
                        System.out.println("Can't play this media.");
                        cartMenu();
                        option2 = num.nextInt();
                        num.nextLine(); // Consume the newline character
                    }
                }
                if(option2 == 5) {
                    System.out.println("Order Successfully.");
                    anOrder.clearCart();
                    anOrder.printCart();
                    cartMenu();
                    option2 = num.nextInt();
                    num.nextLine(); // Consume the newline character
                }
            }
            if(option2 == 0) {
                showMenu();
                option = num.nextInt();
            }
        }
    }
    if(option == 0) {
        System.out.println("Goodbye!");
        num.close();
    }
}

    public static void showMenu() {
        System.out.println("AIMS: ");
		System.out.println("--------------------------------");
		System.out.println("1. View store");
        System.out.println("2. Update store");
		System.out.println("3. See current cart");
		System.out.println("0. Exit");
		System.out.println("--------------------------------");
		System.out.println("Please choose a number: 0-1-2-3");
    }
    public static void storeMenu() {
		System.out.println("Options: ");
		System.out.println("--------------------------------");
		System.out.println("1. See a media’s details");
		System.out.println("2. Add a media to cart");
        System.out.println("3. Play a media");
		System.out.println("4. See current cart");
		System.out.println("0. Back");
		System.out.println("--------------------------------");
		System.out.println("Please choose a number: 0-1-2-3-4");
    }
    public static void mediaDetailsMenu() {
        System.out.println("Options: ");
        System.out.println("--------------------------------");
        System.out.println("1. Add to cart");
        System.out.println("2. Play");
        System.out.println("0. Back");
        System.out.println("--------------------------------");
        System.out.println("Please choose a number: 0-1-2");
    }
    public static void cartMenu() {
		System.out.println("Options: ");
		System.out.println("--------------------------------");
		System.out.println("1. Filter medias in cart");
		System.out.println("2. Sort medias in cart");
		System.out.println("3. Remove media from cart");
		System.out.println("4. Play a media");
		System.out.println("5. Place order");
		System.out.println("0. Back");
		System.out.println("--------------------------------");
		System.out.println("Please choose a number: 0-1-2-3-4-5");
    }
}
