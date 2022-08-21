package com.example.demo1;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.image.Image;
import javafx.stage.Stage;

public class Main extends Application {
    @Override
    public void start(Stage primaryStage) throws Exception {
        Parent root = FXMLLoader.load(getClass().getResource("main.fxml"));
        primaryStage.setScene(new Scene(root));
        primaryStage.setTitle("Summit Financial Corporation");
        Image bankLogo = new Image("Summit Fin Corp.png");
        primaryStage.getIcons().add(bankLogo);
        primaryStage.show();
    }

    public static void main(String[] args) {
        launch(args);
    }
}