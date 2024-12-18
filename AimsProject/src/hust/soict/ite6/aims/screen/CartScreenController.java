package hust.soict.ite6.aims.screen;

import javax.swing.JOptionPane;

import hust.soict.ite6.aims.Aims.Aims;
import hust.soict.ite6.aims.cart.Cart.Cart;
import hust.soict.ite6.aims.exception.PlayerException;
import hust.soict.ite6.aims.media.Media;
import hust.soict.ite6.aims.media.Playable;
import javafx.beans.value.ChangeListener;
import javafx.beans.value.ObservableValue;
import javafx.collections.transformation.FilteredList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.RadioButton;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.control.ToggleGroup;
import javafx.scene.control.cell.PropertyValueFactory;

import javax.swing.*;
import java.io.IOException;

public class CartScreenController {//PhuLDC_20225755
    private Cart cart;
    @FXML
    private TableColumn<Media, String> colMediaCost;
    @FXML
    private TableColumn<Media, String> colMediaTitle;
    @FXML
    private TableColumn<Media, String> colMediaCategory;
    @FXML
    private Button btnPlay;
    @FXML
    private Button btnRemove;
    @FXML
    private Button btnDetails;
    @FXML
    private RadioButton radioBtnFilterId;
    @FXML
    private RadioButton radioBtnFilterTitle;
    @FXML
    private TextField tfFilter;
    @FXML
    private TableView<Media> tblMedia;

    @FXML
    private ToggleGroup filterCategory;

    @FXML
    private Button btnPlaceOrder;
    @FXML
    private Label lblCost;
    public CartScreenController(Cart cart) {
        super();
        this.cart = cart;
    }
    @FXML
    private void initialize() {
        colMediaTitle.setCellValueFactory(new PropertyValueFactory<Media, String>("title"));
        colMediaCategory.setCellValueFactory(new PropertyValueFactory<Media, String>("category"));
        colMediaCost.setCellValueFactory(new PropertyValueFactory<Media, String>("cost"));
        tblMedia.setItems(cart.getItemsOrdered());
        btnDetails.setVisible(false);
        //PhuLDC_20225755
        btnPlay.setVisible(false);
        btnRemove.setVisible(false);
        tblMedia.getSelectionModel().selectedItemProperty().addListener(new ChangeListener<Media>() {
            @Override
            public void changed(ObservableValue<? extends Media> observable, Media oldValue, Media newValue) {
                if (newValue != null) {
                    updateButtonBar(newValue);
                }
            }
        });
        //PhuLDC_20225755
        tfFilter.textProperty().addListener(new ChangeListener<String>() {
            @Override
            public void changed(ObservableValue<? extends String> observable, String oldValue, String newValue) {
                showFilteredMedia(newValue);
            }

        });
        updateCost();
    }
    //PhuLDC_20225755
    void updateCost() {
        lblCost.setText(String.format("%.2f $", cart.totalCost()));
    }
    //PhuLDC_20225755
    void updateButtonBar(Media media) {
        btnRemove.setVisible(true);
        if (media instanceof Playable) {
            btnPlay.setVisible(true);
        } else {
            btnPlay.setVisible(false);
        }
        btnDetails.setVisible(true);
    }
    //PhuLDC_20225755
    void showFilteredMedia(String input) {
        if (input == "") {
            tblMedia.setItems(cart.getItemsOrdered());
            return;
        }

        FilteredList<Media> filteredList = new FilteredList<>(Cart.getItemsOrdered());
        if (radioBtnFilterId.isSelected())
            filteredList.setPredicate((it) -> it.getId() == Integer.parseInt(input));
        else
            filteredList.setPredicate((it) -> it.isMatch(input));

        tblMedia.setItems(filteredList);
    }

    @FXML
    void btnSortPressed(ActionEvent event) {
        tblMedia.getSortOrder().clear();

        colMediaCost.setSortType(TableColumn.SortType.DESCENDING);

        if (event.getSource().toString().split("\'")[1].equals("Sort by Title")) {
            tblMedia.getSortOrder().add(colMediaTitle);
            tblMedia.getSortOrder().add(colMediaCost);
        } else {
            tblMedia.getSortOrder().add(colMediaCost);
            tblMedia.getSortOrder().add(colMediaTitle);
        }

        tblMedia.sort();
    }

    @FXML
    void btnDetailsPressed(ActionEvent event) {
        new DetailScreen(tblMedia.getSelectionModel().getSelectedItem());
    }
    //PhuLDC_20225755
    @FXML
    void btnPlayPressed(ActionEvent event) throws PlayerException {
        Media media = tblMedia.getSelectionModel().getSelectedItem();
        ((Playable) media).play();
    }
    //PhuLDC_20225755
    @FXML
    void btnRemovePressed(ActionEvent event) throws Exception {
        Media media = tblMedia.getSelectionModel().getSelectedItem();
        cart.removeMedia(media);
        tblMedia.getItems().remove(media);
        updateCost();
    }
    //PhuLDC_20225755
    @FXML
    void btnPlaceOrderPressed(ActionEvent event) {
        if (cart.getItemsOrdered().isEmpty())
            JOptionPane.showMessageDialog(null, "Cart is empty!", "Error", JOptionPane.ERROR_MESSAGE);
        else {
            new PlaceOrderScreen();
            updateCost();
        }
    }

    @FXML
    void menuAddBook(ActionEvent event) {
        new AddBookToStoreScreen();
    }

    @FXML
    void menuAddCd(ActionEvent event) {
        new AddCompactDiscToStoreScreen();
    }

    @FXML
    void menuAddDvd(ActionEvent event) {
        new AddDigitalVideoDiscToStoreScreen();
    }

    @FXML
    void menuViewStore(ActionEvent event) {
        Aims.closeCartScreen();
        Aims.openStoreScreen();
    }
}
