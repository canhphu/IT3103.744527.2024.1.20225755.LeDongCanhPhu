package hust.soict.ite6.aims.media;

import java.util.Comparator;
public abstract class Media {
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
    public boolean equals(Object o) {
        Media media = (Media) o;
        try {
            String title = media.getTitle();
            return title.equals(this.getTitle());
        } catch (NullPointerException e) {
            return false;
        }
    }
    @Override
    public String toString() {
        return "Media {" + id + ". " + title + " - " + category + " - " + cost + "$}";
    }
    
}
