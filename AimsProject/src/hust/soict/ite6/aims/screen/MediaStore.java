package hust.soict.ite6.aims.screen;

import hust.soict.ite6.aims.cart.Cart.*;
import hust.soict.ite6.aims.media.Media;
import hust.soict.ite6.aims.media.Playable;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class MediaStore extends JPanel {//PhuLDC_20225755

    private Media media;
    private StoreScreen storeScreen;

    public MediaStore(Media media, StoreScreen storeScreen) {
        this.media = media;
        //this.storeScreen = storeScreen;
        this.setLayout(new BoxLayout(this, BoxLayout.Y_AXIS));

        JLabel title = new JLabel(media.getTitle());
        title.setFont(new Font(title.getFont().getName(), Font.PLAIN, 20));
        title.setAlignmentX(CENTER_ALIGNMENT);

        JLabel cost = new JLabel(String.format("%.2f $", media.getCost()));
        cost.setAlignmentX(CENTER_ALIGNMENT);

        JPanel container = new JPanel();
        container.setLayout(new FlowLayout(FlowLayout.CENTER));

        JButton btnAddToCart = new JButton("Add to cart");
        btnAddToCart.addActionListener(new ButtonListener());
        container.add(btnAddToCart);

        if (media instanceof Playable) {
            JButton btnPlay = new JButton("Play");
            btnPlay.addActionListener(new ButtonListener());
            container.add(btnPlay);
        }

        JButton btnDetails = new JButton("Details");
        btnDetails.addActionListener(new ButtonListener());
        container.add(btnDetails);

        this.add(Box.createVerticalGlue());
        this.add(title);
        this.add(cost);
        this.add(Box.createVerticalGlue());
        this.add(container);

        this.setBorder(BorderFactory.createLineBorder(Color.BLACK));
    }

    private class ButtonListener implements ActionListener {

        @Override
        public void actionPerformed(ActionEvent e) {
            String button = e.getActionCommand();
            switch (button) {
                //PhuLDC_20225755
                case "Add to cart":
                    Cart.addMedia(media);
                    JOptionPane.showMessageDialog(null,
                            String.format("Added %s to cart.\nCurrent number of items in cart: %d", media.toString(),
                                    Cart.getItemsOrdered().size()));
                    break;
                case "Play":
                    ((Playable) media).play();
                    break;
                case "Details":
                    JOptionPane.showMessageDialog(null,"Detail Page");
                    break;
            }

        }

    }

}
