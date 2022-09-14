package com.example.demo;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.image.ImageView;
import javafx.scene.layout.Pane;
import javafx.scene.text.Text;
import javafx.stage.Stage;

import java.io.IOException;

public class AboutUsController {
   @FXML
           private Label aboutUsLabel;
    @FXML
    private  Text chouaLabel,ruhamaLabel,samLabel,davidLabel,mannyLabel,pandoraLabel;
    @FXML
    private  Pane chouaText,pandoraText,mannyText,samText,ruhamaText,DavidText;
    @FXML
    private  ImageView chouaImage,panImage, mannyImage,ruhImage,Image2,Image;
    private Stage stage;
    private Scene scene;
    private Parent root;
    @FXML
    protected void Home(ActionEvent event) throws IOException {
        root = FXMLLoader.load(getClass().getResource("MainModified.fxml"));
        stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
        scene = new Scene(root);
        stage.setScene(scene);
        stage.show();
    }
}
