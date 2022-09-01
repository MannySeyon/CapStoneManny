package com.example.demo;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;

public class chatbot {
    @FXML
    private TextArea page;
    @FXML
    private TextField user;
    @FXML
    private Button clientButton;


    public void send(ActionEvent event) {
        if (user.getText().contains("hi")) {
            page.setText("HI this is summit robot what can i do for you ");
        }

    }
}

