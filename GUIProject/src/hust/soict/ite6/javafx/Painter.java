package hust.soict.ite6.javafx;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

import java.util.Objects;

public class Painter extends Application {//PhuLDC_20225755
    @Override
    public void start(Stage stage) throws Exception {
        Parent root = FXMLLoader.load(getClass().getResource("Painter.fxml"));
        if (root == null) {
            System.out.println("FXML file not found!");
        } else {
            System.out.println("FXML file loaded successfully!");
            Scene scene = new Scene(root);
            stage.setTitle("Painter");
            stage.setScene(scene);
            stage.show();
        }

    }

    public static void main(String[] args) {
        launch(args);
    }
}