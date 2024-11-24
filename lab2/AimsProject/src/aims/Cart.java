package aims;

public class Cart {
    public static final int MAX_NUMBERS_ORDERED = 20;
    private DigitalVideoDisc itemsOrdered[] = new DigitalVideoDisc[MAX_NUMBERS_ORDERED];
    private int qtyOrdered = 0;
    public boolean addDigitalVideoDisc(DigitalVideoDisc disc) {
        if(qtyOrdered < MAX_NUMBERS_ORDERED) {
            itemsOrdered[qtyOrdered] = disc;
            qtyOrdered++;
            System.out.println("LeDongCanhPhu-20225755-The disc has been added.");
            return true;
        }
        else {
            System.out.println("LeDongCanhPhu-20225755-The cart is almost full.");
            return false;
        }
    }

    public boolean addDigitalVideoDisc(DigitalVideoDisc[] dvdlist) {
        if(dvdlist.length < MAX_NUMBERS_ORDERED) {
            for(qtyOrdered = 0; qtyOrdered < dvdlist.length; qtyOrdered++) {
                itemsOrdered[qtyOrdered] = dvdlist[qtyOrdered];
             }
            System.out.println("LeDongCanhPhu-20225755-The dvdlist has been added.");
            return true;
        }
        else {
            System.out.println("LeDongCanhPhu-20225755-The cart is almost full.");
            return false;
         }
     }
    
    public boolean addDigitalVideoDisc(DigitalVideoDisc dvd1, DigitalVideoDisc dvd2) {
            if(qtyOrdered < MAX_NUMBERS_ORDERED) {
                itemsOrdered[qtyOrdered] = dvd1;
                qtyOrdered++;
                itemsOrdered[qtyOrdered] = dvd2;
                qtyOrdered++;
            System.out.println("LeDongCanhPhu-20225755-The two disc has been added.");
            return true;
        }
        else {
             System.out.println("LeDongCanhPhu-20225755-The cart is almost full.");
             return false;
        }
}
    public float totalCost() {
        float total = 0;
        for(int i = 0; i < qtyOrdered; i++) {
            total += itemsOrdered[i].getCost();
        }
        return total;
    }

    public void removeDigitalVideoDisc(DigitalVideoDisc disc) {
        for(int i = 0; i < qtyOrdered; i++) {
            if(itemsOrdered[i] == disc) {
                for(int j = i; j < qtyOrdered - 1; j++) {
                    itemsOrdered[j] = itemsOrdered[j + 1];
                }
                qtyOrdered--;
                System.out.println("LeDongCanhPhu-20225755-The disc has been removed.");
                return;
            }
        }
        System.out.println("LeDongCanhPhu-20225755-The disc is not in the cart.");
    }

    public void printCart() {
        System.out.println("*************LeDongCanhPhu-20225755's CART*************");
        System.out.println("Ordered Items:");
        for(int i = 0; i < qtyOrdered; i++) {
            System.out.println(i+1 + itemsOrdered[i].toString());
        }
        System.out.println("*******************************************************");
    }
    public void SearchDVDbyID(int id) {
        for(int i = 0; i < qtyOrdered; i++) {
            if(itemsOrdered[i].getId() == id) {
                System.out.println("LeDongCanhPhu-20225755-The disc is found.");
                System.out.println(itemsOrdered[i].toString());
                return;
            }
        }
        System.out.println("LeDongCanhPhu-20225755-The disc is not found.");
    }

    public boolean isMatch(String title) {
        for(int i = 0; i < qtyOrdered; i++) {
            if(itemsOrdered[i].getTitle().equals(title)) {
                return true;
            }
        }
        return false;
    }

    public void SearchDVDbyTitle(String title) {
        for(int i = 0; i < qtyOrdered; i++) {
            if(itemsOrdered[i].getTitle().equals(title)) {
                System.out.println("LeDongCanhPhu-20225755-The disc is found.");
                System.out.println(itemsOrdered[i].toString());
                return;
            }
        }
        System.out.println("LeDongCanhPhu-20225755-The disc is not found.");
    }

}
