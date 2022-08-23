package com.example.demo1;

import javafx.application.Application;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.ButtonType;
import javafx.scene.image.Image;
import javafx.stage.Stage;

public class Main extends Application {

    @Override
    public void start(Stage primaryStage){
            try {
                Parent root = FXMLLoader.load(getClass().getResource("main.fxml"));
                primaryStage.setScene(new Scene(root));
                primaryStage.setTitle("Summit Financial Corporation");
                Image bankLogo = new Image("Summit Fin Corp.png");
                primaryStage.getIcons().add(bankLogo);
                //Al-F4 also closes application with Exit method
                // when you click x on window
                primaryStage.setOnCloseRequest(event -> {
                    //prevent window close unless exit method is passed
                    event.consume();
                    Exit(primaryStage);
                });
                    primaryStage.show();

            }  catch (Exception e){
                e.printStackTrace();
            }
    }
    @FXML
    public void Exit(Stage primaryStage) {
        //Create Alert box-Confirmation type
        Alert alert = new Alert(Alert.AlertType.CONFIRMATION);
        alert.setTitle("Exit");
        alert.setHeaderText("You Are About To Quit");
        alert.setContentText("Do you want to Quit?");

        if(alert.showAndWait().get() == ButtonType.OK) {
            //set stage =to the current working stage
            System.out.println("You've successfully Quit!");
            primaryStage.close();
        }
    }
    public static void main(String[] args) {
        launch(args);
    }
}