package hust.soict.ite6.aims.media;

import java.util.Comparator;
public abstract class Media implements Comparable<Media> {
    protected int id;
    protected String title;
    protected String category;
    protected float cost;
    private static int nbDigitalVideoDiscs = 1; // Class attribute
    public static final Comparator<Media> COMPARE_BY_TITLE_COST = new MediaComparatorByTitleCost();
    public static final Comparator<Media> COMPARE_BY_COST_TITLE = new MediaComparatorByCostTitle();
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
    public static int getNbDigitalVideoDiscs() {
        return nbDigitalVideoDiscs;
    }
    public void setTitle(String title) {
        this.title = title;
    }
    public void setCategory(String category) {
        this.category = category;
    }
    public void setCost(float cost) {
        this.cost = cost;
    }
    public Media(String title, String category, float cost) {
        this.id = nbDigitalVideoDiscs++;
        this.title = title;
        this.category = category;
        this.cost = cost;
    }
    public Media(String title) {
        this.id = nbDigitalVideoDiscs++;
        this.title = title;
    }

    @Override
    public boolean equals(Object o) throws NullPointerException, ClassCastException {
        try {
            o.getClass().cast(this);
            Media media = (Media) o;
            String title = media.getTitle();
            return title.equals(this.getTitle());
        } catch (NullPointerException e) {
            return false;
        } catch(ClassCastException e) {
            return false;
        }
    }
    @Override
    public String toString() {
        return "Media {" + id + ". " + title + " - " + category + " - " + cost + "$}";
    }
    @Override
    public int compareTo(Media otherMedia) {
        //Compare by title first
        int titleComparison = this.getTitle().compareTo(otherMedia.getTitle());
        return (titleComparison != 0) ? titleComparison : Float.compare(this.getCost(), otherMedia.getCost());
    }
    
    public boolean isMatch(String title) {
        String[] keywords = title.split("\\s+");
        for (String word : keywords) {
            if (this.title.toLowerCase().contains(word.toLowerCase()))
                return true;
        }
        return false;
    }
}
