package com.example.demo;

import com.example.demo.customer.Customer;
import javafx.application.Application;
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
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.time.LocalDate;


@SuppressWarnings("ALL")
public class SignupPageController {
    public Label firstName;
    public TextField SocialSecurityF;
    public TextField UsernameF;
    public TextField PasswordF;
    public TextField PhoneNumberF;
    public TextField EmailF;
    public TextField LastNameF;
    public TextField FirstNameF;
    public TextField SuffixLabel;
    public TextField MiddleNameF;
    @FXML
    private Label DOBLabel;
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

    public void saveInfo(){
        Connectivity connectivity = new Connectivity();
        Connection connection = connectivity.getConnection();

        Customer customer = new Customer(FirstNameF.getText(),
                LastNameF.getText(),
                MiddleNameF.getText(),
                LocalDate.of(datePicker.getValue().getYear(),datePicker.getValue().getMonth(),datePicker.getValue().getDayOfMonth()),
                SocialSecurityF.getText(),
                PhoneNumberF.getText(),
                EmailF.getText(),
                UsernameF.getText(),
                PasswordF.getText());
        String query = "Insert into customer_personal_info ";
        PreparedStatement preparedStatement = (PreparedStatement) connection;

   }



}