package com.example.demo;

import com.example.demo.customer.Customer;
import javafx.beans.Observable;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Stage;

import java.io.IOException;
import java.net.URL;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.time.LocalDate;
import java.time.Period;
import java.util.ResourceBundle;
import java.util.regex.Matcher;
import java.util.regex.Pattern;


@SuppressWarnings("ALL")

public class SignupPageController implements Initializable {
    @FXML
    private TextField SocialSecurityF, UsernameF, PasswordF, PhoneNumberF, EmailF,
            firstName, LastNameF, FirstNameF, Street, MiddleNameF, City, ZipCode, Apartment, gender, maritalStatus;
    private String genderSet = "";
    private String maritalSet = "";
    @FXML
    private Label DOBLabel, firstName1, LastName, MiddleName, SocialSecurity, Username, Password,
            PhoneNumber, Email, SignupLabel, verifySSN, verifyPhone, verifyAgeLabel, usernameWarning;
    @FXML
    private RadioButton male;
    @FXML
    private RadioButton female;
    @FXML
    private RadioButton other;
    @FXML
    private RadioButton single, married;
    private Stage stage;
    private Scene scene;
    private Parent root;
    @FXML
    private Button Home, SignupButton;
    @FXML
    private DatePicker datePicker;
    @FXML
    private AnchorPane anchorPane;
    @FXML
    private int age;


    @FXML
    private ComboBox<String> comboBox;


    ObservableList<String> list = FXCollections.observableArrayList("Alabama", "Alaska", "Arizona", "Arkansas", "California", "Colorado", "Connecticut", "Delaware", "Florida", "Georgia", "Hawaii", "Idaho", "Illinois", "Indiana", "Iowa", "Kansas", "Kentucky", "Louisiana", "Maine", "Maryland", "Massachusetts", "Michigan", "Minnesota", "Mississippi", "Missouri", "Montana", "Nebraska", "Nevada", "New Hampshire", "New Jersey", "New Mexico", "New York", "North Carolina", "North Dakota", "Ohio", "Oklahoma", "Oregon ", "Pennsylvania ", "Rhode Island", "South Carolina ", "South Dakota", "Tennessee", "Texas", "Utah", "Vermont", "Virginia", "Washington", "West Virginia", "Wisconsin", "Wyoming");


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


    public void verify(ActionEvent actionEvent) throws Exception {
        String[] verifyTextfield = new String[]{FirstNameF.getText(), LastNameF.getText(), SocialSecurityF.getText(),
                UsernameF.getText(), PasswordF.getText(), PhoneNumberF.getText(), EmailF.getText(), Street.getText(), City.getText(), ZipCode.getText(), Apartment.getText()};
        TextField[] textFields = new TextField[]{FirstNameF, LastNameF, SocialSecurityF, UsernameF, PasswordF, PhoneNumberF, EmailF, Street, City, ZipCode, Apartment};
        for (int i = 0; i < verifyTextfield.length; i++) {
            if (verifyTextfield[i].isBlank()) {
                textFields[i].setStyle("-fx-text-box-border: #ff0000; -fx-focus-color: #ff0000;");
            } else if (!verifyTextfield[i].isBlank()) {
                textFields[i].setStyle("-fx-text-box-border: #D3D3D3; -fx-focus-color: #D3D3D3;");
            }
        }
        if (datePicker.getValue() == null) {
            datePicker.setStyle("-fx-text-box-border: #ff0000; -fx-focus-color: #ff0000;");
        } else{
             datePicker.setStyle("-fx-text-box-border: #D3D3D3; -fx-focus-color: #D3D3D3;");
    }

        if (checkSSNInfo() == false || checkPhoneInfo() == false || ageVerify() == false || passwordVerify() == false || datePicker.getValue() == null ) {

            if (checkSSNInfo() == false) {
                SocialSecurityF.setStyle("-fx-text-box-border: #ff0000; -fx-focus-color: #ff0000;");
                verifySSN.setText("Your Social Security Number is invalid.");
            } else {
                verifySSN.setText("");
            }

            if (checkPhoneInfo() == false ) {
                PhoneNumberF.setStyle("-fx-text-box-border: #ff0000; -fx-focus-color: #ff0000;");
                verifyPhone.setText("Your phone number is invalid.");
            } else {
                verifyPhone.setText("");
            }
            if (ageVerify() == false) {
                datePicker.setStyle("-fx-text-box-border: #ff0000; -fx-focus-color: #ff0000;");
                verifyAgeLabel.setText("You are not eligable to create an account");
            } else {
                verifyAgeLabel.setText("");
            }
            if (passwordVerify() == false) {
            }
            if (UsernameF.getText().length() < 5 || UsernameF.getText().length() > 20) {
                usernameWarning.setText("user name must be between  6 and 19 charachters ");
            }

        } else {
            verifySSN.setText("");
            verifyPhone.setText("");
            verifyAgeLabel.setText("");
            usernameWarning.setText("");
            saveInfo(actionEvent);
        }
    }


    //checks for age - ssn & phone = number - if user exists
    public boolean checkSSNInfo() throws Exception, ArithmeticException {

        try {
            if(SocialSecurityF.getText().length() != 9)
                return false;
            int intValue = Integer.parseInt(SocialSecurityF.getText());
            return true;
        } catch (NumberFormatException e) {
            return false;
        }
    }

    public boolean checkPhoneInfo() throws Exception, ArithmeticException {

        try {
            if (PhoneNumberF.getText().length() != 10)
                return false;
            int intValue = Integer.parseInt(PhoneNumberF.getText());
            return true;

        } catch (NumberFormatException e) {
            return false;

        }


    }

    public boolean ageVerify() {
        LocalDate today = LocalDate.now();
        LocalDate birthday = LocalDate.of(datePicker.getValue().getYear(),
                datePicker.getValue().getMonth(),
                datePicker.getValue().getDayOfMonth());
        LocalDate verifyAge = today.minusYears(birthday.getYear());
        if (verifyAge.getYear() < 16) {
            return false;
        } else if (verifyAge.getYear() == 16 && today.getMonthValue() < birthday.getMonthValue()) {
            return false;
        } else if (verifyAge.getYear() == 16 && today.getMonthValue() == birthday.getMonthValue() && today.getDayOfMonth() < birthday.getDayOfMonth()) {
            return false;
        } else {
            return true;
        }
    }

    public boolean passwordVerify() {

        Pattern pattern = Pattern.compile("(?=.*[0-9])(?=.*[a-z])(?=.*[A-Z])(?=.*[@#$%^&-+=()])(?=\\\\S+$).{6,15}");
        Matcher matcher = pattern.matcher(PasswordF.getText());
        if (matcher.find() && matcher.group().equals(PasswordF.getText())) {
            return true;
        } else
            return false;

    }

    public boolean emailVerify() {

        Pattern pattern = Pattern.compile("[a-zA-Z0-9_!#$%&'*+/=?`{|}~^.-]+@[a-zA-Z0-9.-]");
        Matcher matcher = pattern.matcher(EmailF.getText());
        if (matcher.find() && matcher.group().equals(EmailF.getText())) {
            return true;
        } else
            return false;

    }

//    public boolean userExistsVerify() {
//        Connectivity connectivity = new Connectivity();
//        Connection connection = connectivity.getConnection();
//        String query = "select count(1) where ssn=?  or (First_name=? and Last_name=? and date_of_birth=?) ";
//
//    }


    public String genderCheck() {

        if (male.isSelected()){
            genderSet = "M";
        } else if (female.isSelected()) {
            genderSet = "F";

        } else if (other.isSelected()) {
            genderSet = "O";
        }
        return genderSet;
    }

    public String maritalCheck() {

        if (single.isSelected()) {
            maritalSet = "single";
        } else if (married.isSelected()) {
            maritalSet = "married";
        }
        return maritalSet;
    }

    public void checkEmptyFields() {

    }


    public void saveInfo(ActionEvent actionEvent) throws SQLException, IOException {
        Connectivity connectivity = new Connectivity();
        Connection connection = connectivity.getConnection();
        Object object = new Object();
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
                PasswordF.getText(),
                Street.getText(),
                City.getText(),
                comboBox.getValue(),
                ZipCode.getText(),
                Apartment.getText(), genderCheck(), maritalCheck()
        );
        System.out.println(customer);

        String query = "insert into customer_personal_info(" + "First_name,Last_name,middle_name,date_of_birth,address,zipp_code,Country,states,city,contact_no, ssn,username,password,email,gender,marital_status) values "
                + "(?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?)";
        PreparedStatement statement = connection.prepareStatement(query);
        statement.setString(1, customer.getFirstName());
        statement.setString(2, customer.getLastName());
        statement.setString(3, customer.getMiddleName());
        statement.setString(4, customer.getDateOfBirth().toString());
        statement.setString(5, customer.getStreet());
        statement.setString(6, customer.getZipCode());
        statement.setString(7, "US");
        statement.setString(8, comboBox.getValue());
        statement.setString(9, customer.getCity());
        statement.setString(10, customer.getPhoneNumber());
        statement.setString(11, customer.getSSN());
        statement.setString(12, customer.getUsername());
        statement.setString(13, customer.getPassword());
        statement.setString(14, customer.getEmail());
        statement.setString(15, customer.getGender());
        statement.setString(16, customer.getMartialStatus());
        statement.executeUpdate();
        System.out.println(comboBox.getValue());
        connection.close();
    }

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        comboBox.setItems(list);
    }
}
