package com.example.demo;

import com.example.demo.customer.Customer;
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
import java.sql.SQLException;
import java.time.LocalDate;


@SuppressWarnings("ALL")
public class SignupPageController {
    @FXML
    private Label firstName;
    @FXML
    private TextField SocialSecurityF;
    @FXML
    private TextField UsernameF;
    @FXML
    private TextField PasswordF;
    @FXML
    private TextField PhoneNumberF;
    @FXML
    private TextField EmailF;
    @FXML
    private TextField LastNameF;
    @FXML
    private TextField FirstNameF;
    @FXML
    private TextField SuffixLabel;
    @FXML
    private TextField MiddleNameF;
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
    private Label SignupLabel;
    private Stage stage;
    private Scene scene;
    private Parent root;
    @FXML
    private Button Home;
    @FXML
    private Button SignupButton;
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

    public void saveInfo(ActionEvent actionEvent) throws SQLException, IOException {
        Connectivity connectivity = new Connectivity();
        Connection connection = connectivity.getConnection();

//        if(FirstNameF.getText().isBlank() ||
//                LastNameF.getText().isBlank()||
//                MiddleNameF.getText().isBlank() ||
//                SocialSecurityF.getText().isBlank()||
//                UsernameF.getText().isBlank()||
//                PasswordF.getText().isBlank()||
//                EmailF.getText().isBlank()){
//            Signup(actionEvent);
//        }


        Customer customer = new Customer(FirstNameF.getText(),
                LastNameF.getText(),
                MiddleNameF.getText(),
                LocalDate.of(datePicker.getValue().getYear(),
                        datePicker.getValue().getMonth(),
                        datePicker.getValue().getDayOfMonth()),
                SocialSecurityF.getText(),
                PhoneNumberF.getText(),
                EmailF.getText(),
                UsernameF.getText(),
                PasswordF.getText());



        String query = "insert into customer_personal_info(First_name,Last_name,middle_name,date_of_birth,address,contact_no,\n" +
                "                                ssn,username,password,email,gender) values (?,?,?,?,?,?,?,?,?,?,?)";
        PreparedStatement statement = connection.prepareStatement(query);
        statement.setString(1, customer.getFirstName());
        statement.setString(2, customer.getLastName());
        statement.setString(3,customer.getMiddleName()) ;
        statement.setString(4,customer.getDateOfBirth().toString());
        statement.setString(5,"sdss");
        statement.setString(6,customer.getPhoneNumber());
        statement.setString(7, customer.getSSN());
        statement.setString(8,customer.getUsername());
        statement.setString(9, customer.getPassword());
        statement.setString(10,customer.getEmail());
        statement.setString(11,"m");
        statement.executeUpdate();
        System.out.println(customer.getEmail());

   }

}