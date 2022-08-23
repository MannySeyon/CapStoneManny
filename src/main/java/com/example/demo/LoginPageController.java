package com.example.demo;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.scene.image.ImageView;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Stage;

import java.io.IOException;
import java.sql.*;

@SuppressWarnings("ALL")
public class LoginPageController {

    @FXML
    private Label phoneLabel;
    @FXML
    private  Label emailLabel;

    @FXML
    ImageView BanklogoGif;
    @FXML
    private Label UserLabel;
    @FXML
    TextField nameTextField;
    @FXML
    private Label passwordLabel;
    @FXML
    private PasswordField passwordField;

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
    String username;
    @FXML
    String password;
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

@SuppressWarnings("ThrowablePrintedToSystemOut")

@FXML
    public void loginButtonOnAction(ActionEvent event) throws SQLException, IOException {
        if(nameTextField.getText().isBlank()==false && passwordField.getText().isBlank()==false){
            validateLogin(event);


        }
        else {

        }
    }


    public void validateLogin(ActionEvent event ) throws SQLException, IOException {
        Connectivity connectivity = new Connectivity();
        Connection connection = connectivity.getConnection();
        String query = "select count(1) from  customer_personal_info where username = ' " + nameTextField.getText() + "' and password= '" + passwordField.getText()+"'";
        Statement statement = connection.createStatement();
        ResultSet resultSet = statement.executeQuery(query);
        while (resultSet.next()) {
            System.out.println(resultSet.getInt(1));
            if (resultSet.getInt(1) == 1) {
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
            } else {
                System.out.println("i am sorry");
            }
        }
    }
}
