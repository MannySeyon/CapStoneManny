package com.example.demo;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import de.jensd.fx.glyphs.fontawesome.FontAwesomeIconView;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import javafx.scene.image.ImageView;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.Pane;
import javafx.scene.shape.Circle;

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
    public void SendMessage(ActionEvent event) {
        if (userInput.getText().contains("hi")) {
            Console.setText("HI this is summit robot what can i do for you ");
        }

    }
}

