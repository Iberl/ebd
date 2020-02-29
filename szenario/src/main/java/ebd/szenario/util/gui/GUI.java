package ebd.szenario.util.gui;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.image.Image;
import javafx.stage.Stage;

import java.io.IOException;

public class GUI extends Application {

    @Override
    public void start(Stage primaryStage) {
        Parent root = null;
        try {
            root = FXMLLoader.load(Thread.currentThread().getContextClassLoader().getResource("GUI.fxml"));
            if (root == null) throw new IOException();
        }
        catch (IOException e) {
            System.out.println("GUI.fxml File was not found!");
            return;
        }

        primaryStage.setTitle("Demonstrator");
        primaryStage.setScene(new Scene(root,1000,800));
        primaryStage.show();
    }
}
