package com.example.demo.Admin;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.SplitPane;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.Pane;

import java.net.URL;
import java.util.ResourceBundle;

public class AdminDashController implements Initializable {

    @FXML
    private SplitPane pnCreateClient;
    @FXML
    private Pane pnClientsListview;
    @FXML
    private AnchorPane pnDeposits;
    @FXML
    private BorderPane mainPane;
    @FXML
    private Button create_c_btn, Clients_btn, deposit_btn, logout_btn;



    @FXML
    private void handleClicks(ActionEvent event) {

        if(event.getSource()== create_c_btn)
        {
         pnCreateClient.toFront();

        } else
        if(event.getSource()== Clients_btn)
        {
         pnClientsListview.toFront();
        } else
        if(event.getSource()== deposit_btn)
        {
         pnDeposits.toFront();
        } else
        if(event.getSource()== logout_btn)
        {

        }


    }


    @FXML
    private void createClientAction(ActionEvent event) {



    }
    @FXML
    protected void ClientListAction(ActionEvent actionEvent) {
    }
    @FXML
    protected void depositAction(ActionEvent actionEvent) {
    }

    @FXML
    protected void logoutAction(ActionEvent actionEvent) {
    }

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {

    }
}