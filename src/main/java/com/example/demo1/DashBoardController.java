package com.example.demo1;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Stage;

import java.io.IOException;

public class DashBoardController {

        private Stage stage;
        private Scene scene;
        private Parent root;
        @FXML
         Label nameLabel;
        @FXML
        private Button Home;
        @FXML
        private Label welcomeLabel;
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
        protected void LoginPage(ActionEvent event) throws IOException {
            root = FXMLLoader.load(getClass().getResource("LoginPage.fxml"));
            stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
            scene = new Scene(root);
            stage.setScene(scene);
            stage.show();
        }
    public void displayName(String username){
        nameLabel.setText("Welcome to your Dashboard: " + username + "!" );
    }
    }

