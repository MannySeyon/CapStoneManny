package com.example.demo;

import com.example.demo.customer.Customer;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Stage;
import java.io.IOException;
import java.math.BigDecimal;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.time.LocalDate;


@SuppressWarnings("ALL")
public class SignupPageController {
    @FXML
    private TextField SocialSecurityF, UsernameF, PasswordF, PhoneNumberF, EmailF
            , LastNameF, FirstNameF, StreetF, MiddleNameF, CityF, ZipCodeF, ApartmentF, Gender, MaritalStatus;
    private String genderSet = "";
    private String maritalSet = "";
    @FXML
    private Label DOBLabel, FirstName, LastName, MiddleName, SocialSecurity, Username, Password, zipCode, streetName, apt,
            PhoneNumber, Email, SignupLabel, verifySSN, verifyPhone, verifyAgeLabel, progressLabel, progressPercentLabel;
    @FXML
    private RadioButton male, other,female, single, married;

    private Stage stage;
    private Scene scene;
    private Parent root;
    @FXML
    private Button LoginButton,  Home,  SignupButton, nextButton,
            progressButton;
    @FXML
    private DatePicker datePicker;
    @FXML
    private AnchorPane anchorPane;
    @FXML
    private int age;

    @FXML
    private ProgressBar progressBar;
    BigDecimal progress = new BigDecimal(String.format("%.2f", 0.0));

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

    //Redundant
    @FXML
    protected void Signup(ActionEvent event) throws IOException {
        root = FXMLLoader.load(getClass().getResource("LoginPage.fxml"));
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
    public void verify(ActionEvent actionEvent) throws Exception {
        String[] verifyTextfield = new String[]{FirstNameF.getText(), LastNameF.getText(), SocialSecurityF.getText(),
                UsernameF.getText(), PasswordF.getText(), PhoneNumberF.getText(), EmailF.getText(), StreetF.getText(), CityF.getText(), ZipCodeF.getText(), ApartmentF.getText()};
        TextField[] textFields = new TextField[]{FirstNameF, LastNameF, SocialSecurityF, UsernameF, PasswordF, PhoneNumberF, EmailF, StreetF, CityF, ZipCodeF, ApartmentF};
        for (int i = 0; i < verifyTextfield.length; i++) {
            if (verifyTextfield[i].isBlank()) {
                textFields[i].setStyle("-fx-text-box-border: #ff0000; -fx-focus-color: #ff0000;");
            } else if (!verifyTextfield[i].isBlank()) {
                textFields[i].setStyle("-fx-text-box-border: #D3D3D3; -fx-focus-color: #D3D3D3;");
            }
        }
        if (SocialSecurityF.getText().length() != 9 || PhoneNumberF.getText().length() != 10 || checkSSNInfo() == false || checkPhoneInfo() == false || ageVerify() == false) {

            if (SocialSecurityF.getText().length() != 9 || checkSSNInfo() == false) {
                SocialSecurityF.setStyle("-fx-text-box-border: #ff0000; -fx-focus-color: #ff0000;");
                verifySSN.setText("Your Social Security Number is invalid.");
            } else {
                verifySSN.setText("");
            }

            if (checkPhoneInfo() == false || PhoneNumberF.getText().length() != 10) {
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

        } else {
            verifySSN.setText("");
            verifyPhone.setText("");
            verifyAgeLabel.setText("");
            saveInfo(actionEvent);
        }
    }

    //checks for age - ssn & phone = number - if user exists
    public boolean checkSSNInfo() throws Exception, ArithmeticException {

        try {
            int intValue = Integer.parseInt(SocialSecurityF.getText());
            return true;
        } catch (NumberFormatException e) {
            return false;
        }
    }
    public boolean checkPhoneInfo() throws Exception, ArithmeticException {

        try {
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

    public String genderCheck() {

        if (male.isSelected()) {
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
                StreetF.getText(),
                CityF.getText(),
                "mn",
                ZipCodeF.getText(),
                ApartmentF.getText(), genderCheck(), maritalCheck()
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
        statement.setString(8, "MN");
        statement.setString(9, customer.getCity());
        statement.setString(10, customer.getPhoneNumber());
        statement.setString(11, customer.getSSN());
        statement.setString(12, customer.getUsername());
        statement.setString(13, customer.getPassword());
        statement.setString(14, customer.getEmail());
        statement.setString(15, customer.getGender());
        statement.setString(16, customer.getMartialStatus());
        statement.executeUpdate();
        System.out.println(customer.getEmail());
        connection.close();
    }
    @FXML  //Set progress percents =to Scene pages for Sign up
    protected void NextPage(ActionEvent event) throws IOException {

        //Method to access value in progress
        if (progress.doubleValue() < 1) {
            //must keep reInstantiate BigDecimals
            progress = new BigDecimal(String.format("%.2f", progress.doubleValue() + 0.50));
            progressBar.setProgress(progress.doubleValue());
            //Set text to progress *100 add % string to end //change double to Integer and round
            //progressLabel.setText(Integer.toString((int) Math.round(progress.doubleValue() * 100)) + "%");
            progressPercentLabel.setText(Integer.toString((int) (progress.doubleValue() * 100)) + "%");

            root = FXMLLoader.load(getClass().getResource("SignUpPage2.fxml"));
            //get Source cast to a node //Pass node to Stage
            stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
            //Pass the new fxml path to scene variable
            scene = new Scene(root);
            //pass scene to stage
            stage.setScene(scene);
            stage.show();
        }

    }


    @FXML
    protected void PreviousPage(ActionEvent event) throws IOException {
        root = FXMLLoader.load(getClass().getResource("SignUpPage.fxml"));
        //get Source cast to a node //Pass node to Stage
        stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
        //Pass the new fxml path to scene variable
        scene = new Scene(root);
        //pass scene to stage
        stage.setScene(scene);
        stage.show();
        //Method to access value in progress
        if (progress.doubleValue() < 1) {
            //must keep reInstantiate BigDecimals
            progress = new BigDecimal(String.format("%.2f", progress.doubleValue() + -0.50));
            progressBar.setProgress(progress.doubleValue());
            //Set text to progress *100 add % string to end //change double to Integer and round
            //progressLabel.setText(Integer.toString((int) Math.round(progress.doubleValue() * 100)) + "%");
            progressPercentLabel.setText(Integer.toString((int) (progress.doubleValue() * 100)) + "%");
        }

    }

}

