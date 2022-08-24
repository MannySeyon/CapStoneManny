package com.example.demo;

import de.jensd.fx.glyphs.fontawesome.FontAwesomeIconView;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.image.ImageView;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Stage;

import java.io.IOException;

@SuppressWarnings("ALL")
public class DashBoardController {

    @FXML
    private  Label cardLabel1;
    @FXML
    private  Label TimeDateLabel;
    @FXML
    private  FontAwesomeIconView bars;
    @FXML
    private ImageView securityLogo;
    @FXML
    private  FontAwesomeIconView HomeButton;
    @FXML
    private FontAwesomeIconView list;
    @FXML
    private  FontAwesomeIconView image;
    @FXML
    private  FontAwesomeIconView gear;
    @FXML
    private  Separator separator;
    @FXML
    private FontAwesomeIconView plus;
    @FXML
    private  ImageView bankLogo;

@FXML
    private Label dashLabel;
    @FXML
    private Button exit;
    private Stage stage;
    private Scene scene;
    private Parent root;
    @FXML
    Label nameLabel;
    @FXML
    private Button Home;
    @FXML
    private AnchorPane anchorPane;
    @FXML
    private Button Logout;

    @FXML
    protected void Home(ActionEvent event) throws IOException {
        root = FXMLLoader.load(getClass().getResource("main.fxml"));
        stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
        scene = new Scene(root);
        stage.setScene(scene);
        stage.show();
    }
    @FXML
    protected void Logout(ActionEvent event) throws IOException {
        //Logout Alert
        Alert alert = new Alert(Alert.AlertType.CONFIRMATION);
        alert.setTitle("Logout");
        alert.setHeaderText("You Are About To Logout");
        alert.setContentText("Do you want to Logout?");

        //If they click ok-logout-return to the login screen
        if(alert.showAndWait().get() == ButtonType.OK) {
            root = FXMLLoader.load(getClass().getResource("LoginPage.fxml"));
            stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
            scene = new Scene(root);
            stage.setScene(scene);
            stage.show();
        }
    }

    //Save any progress and close stage
    @FXML
    public void Exit(ActionEvent event) {
        //Create Alert box-Confirmation type
        Alert alert = new Alert(Alert.AlertType.CONFIRMATION);
        alert.setTitle("Exit");
        alert.setHeaderText("You Are About To Quit");
        alert.setContentText("Do you want to Quit?");

        if(alert.showAndWait().get() == ButtonType.OK) {
        //set stage =to the current working stage
        stage = (Stage) anchorPane.getScene().getWindow();
        System.out.println("You've successfully Quit!");
        stage.close();
        }
    }
    public void displayName(String username){
        nameLabel.setText("Hello, " + "firstName + lastName" + ". Welcome to your Summit Dashboard!" );
    }
}

