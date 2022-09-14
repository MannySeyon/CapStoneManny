package com.example.demo;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import de.jensd.fx.glyphs.fontawesome.FontAwesomeIconView;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import javafx.scene.image.ImageView;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.Pane;
import javafx.scene.shape.Circle;
import javafx.stage.Stage;

import java.io.IOException;
import java.util.Objects;

public class ChatbotController {
    @FXML
    private AnchorPane anchPane;
    @FXML
    private Button minButton;
    @FXML
    private Label chatbotNameLabel;
    @FXML
    private ImageView chatbotAvatar;
    @FXML
    private Circle avatarBackground;
    @FXML
    private Pane sidebar;
    @FXML
    private TextArea Console;
    @FXML
    private TextField userInput;
    @FXML
    private Button sendButton;
    @FXML
    private  FontAwesomeIconView minIcon;
    private Stage stage;
    private Scene scene;
    private Parent root;
    @FXML
    protected void Home(ActionEvent event) throws IOException {
        root = FXMLLoader.load(Objects.requireNonNull(getClass().getResource("LandingPage.fxml")));
        stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
        scene = new Scene(root);
        stage.setScene(scene);
        stage.show();
    }
    public void SendMessage(ActionEvent event) {


        if (userInput.getText().contains("hi") || userInput.getText().contains("hello") || userInput.getText().contains("hey") || userInput.getText().contains("howdy")) {
            Console.setText("Hello, this is Summit Financial Corp. ChatBot. How may I assist you?");
        }
        else if (userInput.getText().contains("transfer funds")){
            Console.setText("You can transfer funds by clicking on the Transaction button on your dashboard page.");
        }
        else if(userInput.getText().contains("mobile deposit")){
            Console.setText("Summit Financial Corp. does not support mobile deposit.");
        }
        else if (userInput.getText().contains("closing account")){
            Console.setText("You will have to go to the nearest Summit Financial Corp. branch and speak with a bank teller for more information.");
        }
        else{

                Console.setText("Oops. I didn't get that!");
        }

    }
}

