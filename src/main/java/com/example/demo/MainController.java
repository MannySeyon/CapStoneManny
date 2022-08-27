package com.example.demo;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Stage;
import java.io.IOException;

@SuppressWarnings("ALL")
public class MainController {
    @FXML
    private Button signupButton;
    @FXML
    private Button loginButton;
    @FXML
    private Label baLable;
    @FXML
    private Label welcomeLabel;
    @FXML
    private AnchorPane anchorPane;
    private Stage stage;
    private Scene scene;
    private Parent root;
    @FXML
    protected void SignUpPage(ActionEvent event) throws IOException {
        root = FXMLLoader.load(getClass().getResource("SignUpPage.fxml"));
        //get Source cast to a node //Pass node to Stage
        stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
        //Pass the new fxml path to scene variable
        scene = new Scene(root);
        //pass scene to stage
        stage.setScene(scene);
        stage.show();
    }
    @FXML
    protected void LoginPage(ActionEvent event) throws IOException {
        root = FXMLLoader.load(getClass().getResource("LoginPage1.fxml"));
        stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
        scene = new Scene(root);
        stage.setScene(scene);
        stage.show();

    }
}
