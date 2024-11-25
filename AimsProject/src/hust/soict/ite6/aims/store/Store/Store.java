package hust.soict.ite6.aims.store.Store;

import hust.soict.ite6.aims.disc.DigitalVideoDisc.DigitalVideoDisc;

public class Store {
    public DigitalVideoDisc[] itemsInStore = new DigitalVideoDisc[20];
    public int qtyInStore = 0;
    public boolean addDVD(DigitalVideoDisc disc) {
        if(qtyInStore < 20) {
            itemsInStore[qtyInStore] = disc;
            qtyInStore++;
            System.out.println("LeDongCanhPhu-20225755-The disc has been added.");
            return true;
        }
        else {
            System.out.println("LeDongCanhPhu-20225755-The store is almost full.");
            return false;
        }

    }
    public void removeDVD(DigitalVideoDisc disc) {
        for(int i = 0; i < qtyInStore; i++) {
            if(itemsInStore[i] == disc) {
                for(int j = i; j < qtyInStore - 1; j++) {
                    itemsInStore[j] = itemsInStore[j + 1];
                }
                qtyInStore--;
                System.out.println("LeDongCanhPhu-20225755-The disc has been removed.");
                return;
            }
        }
        System.out.println("LeDongCanhPhu-20225755-The disc is not in the store.");
    }
}
