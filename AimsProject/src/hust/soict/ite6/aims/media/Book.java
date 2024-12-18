package hust.soict.ite6.aims.media;

import java.util.ArrayList;
import java.util.List;

public class Book extends Media {
    
    private List<String> authors = new ArrayList<String>();
    
    //Constructor
    public Book(String title, String category, float cost) {
        super(title, category, cost);
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

    public List<String> getAuthors() {
        return authors;
    }

    public void setAuthors(List<String> authors) {
        this.authors = authors;
    }
}
