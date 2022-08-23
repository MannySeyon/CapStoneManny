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
    private Label label;

    @FXML
    private AnchorPane anchorPane;

    @FXML
    TextField ageTextField;

    @FXML
        int age;
    @FXML
    public void getDate(ActionEvent event) {
        LocalDate date = datePicker.getValue();
        label.setText(date.toString());
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
    @FXML
    public void Submit(ActionEvent event){
        try {
            //turn string entered into an int variable
            age = Integer.parseInt(ageTextField.getText());
            if (age >= 16)
            {
                SignupLabel.setText("You are Eligible for a Basic Account");

            } else
            {
                SignupLabel.setText("Must be 16+ to Create basic Account. Please create a Co-owned Account");
            }

        } catch (Exception e){
            System.out.println(e);
        }
    }

}
