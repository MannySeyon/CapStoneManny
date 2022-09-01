/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.example.demo;

import javafx.animation.TranslateTransition;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.layout.VBox;
import javafx.util.Duration;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

/**
 *
 * @author Admin
 */
public class MainControllermodif implements Initializable {
     
    @FXML
    private VBox vbox;    
    private Parent fxml;
    
    
    
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        Translation();
    }
    @FXML
    private void open_signin(ActionEvent event){
        Translation();
    }

    private void Translation() {
        TranslateTransition transition = new TranslateTransition(Duration.seconds(1), vbox);
        transition.setToX(vbox.getLayoutX() * 20);
        transition.play();
        transition.setOnFinished((e) ->{
            try{
                fxml = FXMLLoader.load(getClass().getResource("LoginPage.fxml"));
                vbox.getChildren().removeAll();
                vbox.getChildren().setAll(fxml);
            }catch(IOException ex){

            }
        });
    }


//    private void AdminDash() {
//        TranslateTransition transition = new TranslateTransition(Duration.seconds(1), vbox);
//        transition.setToX(vbox.getLayoutX() * 20);
//        transition.play();
//        transition.setOnFinished((e) ->{
//            try{
//                fxml = FXMLLoader.load(getClass().getResource("LoginPage.fxml"));
//                vbox.getChildren().removeAll();
//                vbox.getChildren().setAll(fxml);
//            }catch(IOException ex){
//
//            }
//        });
//    }


    @FXML
    private void open_signup(ActionEvent event){
          TranslateTransition transition = new TranslateTransition(Duration.seconds(1), vbox);
        transition.setToX(0);
        transition.play();
        transition.setOnFinished((e) ->{
            try{
                fxml = FXMLLoader.load(getClass().getResource("SignUp.fxml"));
                vbox.getChildren().removeAll();
                vbox.getChildren().setAll(fxml);
            }catch(IOException ex){
                
            }
        });
    }

    @FXML
    private void Signupp(ActionEvent event){


        TranslateTransition t = new TranslateTransition(Duration.seconds(1), vbox);
        t.setToX(vbox.getLayoutX() * 20);
        t.play();
        t.setOnFinished((e) ->{
            try{
                fxml = FXMLLoader.load(getClass().getResource("SignUp.fxml"));
                vbox.getChildren().removeAll();
                vbox.getChildren().setAll(fxml);
            }catch(IOException ex){

            }
        });

    }


    }
    

