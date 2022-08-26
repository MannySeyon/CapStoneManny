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
    private Label phoneLabel, emailLabel, UserLabel, passwordLabel, welcomeLabel, passwordShow;
    @FXML
    ImageView BanklogoGif;
    @FXML TextField nameTextField;  @FXML private PasswordField passwordField;
    @FXML
    private Button Home, SignupButton, loginButton;
    @FXML
    private AnchorPane anchorPane;
    private Stage stage; private Scene scene; private Parent root;
    @FXML
    private String username,password;
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
             passwordShow.setText("Please enter User name and Password");
        }
    }
@FXML
    public void validateLogin(ActionEvent event ) throws SQLException, IOException {
        Connectivity connectivity = new Connectivity();
        Connection connection = connectivity.getConnection();
        String query = "select count(1) from  customer_personal_info where username = ?   and password= ?";
        PreparedStatement statement = connection.prepareStatement(query);
        statement.setString(1,nameTextField.getText());
        statement.setString(2,passwordField.getText());
        ResultSet resultSet = statement.executeQuery();
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
                passwordShow.setText("Wrong user name and password combination!");
            }
        }
    }
}
