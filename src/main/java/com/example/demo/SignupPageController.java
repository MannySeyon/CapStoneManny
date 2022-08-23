package com.example.demo;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.DatePicker;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Stage;

import java.io.IOException;
import java.time.LocalDate;


@SuppressWarnings("ALL")
public class SignupPageController {
    @FXML
    private  TextField SocialSecurityF;
    @FXML
    private  TextField UsernameF;
    @FXML
    private TextField PasswordF;
    @FXML
    private TextField PhoneNumberF;
    @FXML
    private  TextField EmailF;
    @FXML
    private TextField LastNameF;
    @FXML
    private TextField MiddleNameF;
    @FXML
    private  TextField FirstName;
    @FXML
    private Label firstName;
    @FXML
    private Label LastName;
    @FXML
    private Label MiddleName;
    @FXML
    private Label SocialSecurity;
    @FXML
    private Label Username;
    @FXML
    private Label Password;
    @FXML
    private Label PhoneNumber;
    @FXML
    private Label Email;
    @FXML
    private Button CheckAgeButton;
    @FXML
    private Label ageLable;
    @FXML
    private Label SignupLabel;
    private Stage stage;
    private Scene scene;
    private Parent root;
    @FXML
    private Button Home;
    @FXML
    private Button SignupButton;
    @FXML
    private Label welcomeLabel;
    @FXML
    private DatePicker datePicker;
    @FXML
    private AnchorPane anchorPane;
    @FXML
        int age;
    @FXML
    public void getDate(ActionEvent event) {
        LocalDate date = datePicker.getValue();
    }
    @FXML
    protected void Home(ActionEvent event) throws IOException {
        root = FXMLLoader.load(getClass().getResource("main.fxml"));
        stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
        scene = new Scene(root);
        stage.setScene(scene);
        stage.show();
    }
    @FXML
    protected void Signup(ActionEvent event) throws IOException {
        root = FXMLLoader.load(getClass().getResource("LoginPage.fxml"));
        stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
        scene = new Scene(root);
        stage.setScene(scene);
        stage.show();
    }

}
