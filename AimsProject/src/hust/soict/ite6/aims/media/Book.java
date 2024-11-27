package hust.soict.ite6.aims.media;

import java.util.ArrayList;
import java.util.List;

public class Book {
    
    private int id;
    private String title;
    private String category;
    private float cost;
    private List<String> authors = new ArrayList<String>();
    
    //Constructor
    public Book(int id, String title, String category, float cost) {
        this.id = id;
        this.title = title;
        this.category = category;
        this.cost = cost;
    }
    //Getters
    public int getId() {
        return id;
    }

    public String getTitle() {
        return title;
    }

    public String getCategory() {
        return category;
    }

    public float getCost() {
        return cost;
    }

    // addAuthor method
    public void addAuthor(String authorName) {
        if(authors.contains(authorName)) {
            System.out.println("The author is already in the list"); 
            return;
        }
        else {
            authors.add(authorName);
            System.out.println("The author " + authorName + " has been added to the list");
        }
    }

    //removeAuthor method
    public void removeAuthor(String authorName) {
        if(authors.contains(authorName)) {
           authors.remove(authorName);
           System.out.println("The author has been removed");
           return;
        }
        System.out.println("Not found the author in the list");
    }
}
