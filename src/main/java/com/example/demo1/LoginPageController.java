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
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class LoginPageController {
    @FXML
    private Label UserLabel;
    @FXML
    TextField nameTextField;
    @FXML
    private Label passwordLabel;
    @FXML
    public TextField passwordTextField;

    @FXML
    private Button Home;
    @FXML
    private Button SignupButton;
    @FXML
    private Button loginButton;
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
        stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
        scene = new Scene(root);
        stage.setScene(scene);
        stage.show();
    }
    @FXML
    protected void Home(ActionEvent event) throws IOException {
        Parent root = FXMLLoader.load(getClass().getResource("main.fxml"));
        stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
        scene = new Scene(root);
        stage.setScene(scene);
        stage.show();
    }

    @FXML
    protected void Login(ActionEvent event) throws IOException {
        //Store text from the text field as string variables username and password
        String username = nameTextField.getText();
        String password = passwordTextField.getText();
        // Fxml loader instance
        FXMLLoader loader = new FXMLLoader(getClass().getResource("LandingPage.fxml"));
        //set root =to loader and load it.
        root = loader.load();

        //Create instance of the next scene's controller
        DashBoardController landingController = loader.getController();

        //Use scenecontroller variable to call methods within controller class
        landingController.displayName(username);

        //root = FXMLLoader.load(getClass().getResource("LandingPage.fxml"));
        stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
        scene = new Scene(root);
        stage.setScene(scene);
        stage.show();

    }
      public void loginButtonOnAction(ActionEvent e) throws SQLException {
        if(nameTextField.getText().isBlank()==false && passwordTextField.getText().isBlank()==false){
            validateLogin();
        }
        else {

        }
    }


      public void validateLogin() throws SQLException {
        Connectivity connectivity = new Connectivity();
          Connection  connection = connectivity.getConnection();
          String query = "select count(1) from  CustomerInfo where username =" + nameTextField.getText() +" and"+ "password="+passwordTextField.getText();
          Statement statement = connection.createStatement();
          ResultSet  resultSet = statement.executeQuery(query);
      }
}
