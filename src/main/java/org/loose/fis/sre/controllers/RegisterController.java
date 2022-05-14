package org.loose.fis.sre.controllers;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.Pane;
import javafx.stage.Stage;

import java.io.File;

public class RegisterController {
    @FXML
    private Button Back;

    @FXML
    private Button Customer;

    @FXML
    private ImageView CustomerImgBackground;

    @FXML
    private Button Manager;

    @FXML
    private ImageView ManagerImgBackground;

    @FXML
    public void initialize() {
        File fundalCustomerFile = new File("src/main/java/org/loose/fis/sre/images/man-user.png");
        Image fundalCustomerImage = new Image(fundalCustomerFile.toURI().toString());
        CustomerImgBackground.setImage(fundalCustomerImage);
        File fundalManagerFile = new File("src/main/java/org/loose/fis/sre/images/businessman.png");
        Image fundalManagerImage = new Image(fundalManagerFile.toURI().toString());
        ManagerImgBackground.setImage(fundalManagerImage);
    }

    @FXML
    void handleBackAction(javafx.event.ActionEvent event) throws Exception {
        Stage stage = new Stage();
        FXMLLoader fxmlLoader = new FXMLLoader(getClass().getClassLoader().getResource("login.fxml"));
        Pane root = fxmlLoader.load();
        ((Node) (event.getSource())).getScene().getWindow().hide();
        stage.setTitle("Login");
        stage.setScene(new Scene(root, 730, 468));
        stage.show();
    }

    @FXML
    void handleCustomerAction(javafx.event.ActionEvent event) throws Exception{
        Stage stage = new Stage();
        FXMLLoader fxmlLoader = new FXMLLoader(getClass().getClassLoader().getResource("CustomerSignUp.fxml"));
        Pane root = fxmlLoader.load();
        ((Node) (event.getSource())).getScene().getWindow().hide();
        stage.setTitle("Create an account as Customer");
        stage.setScene(new Scene(root, 730, 468));
        stage.show();
    }

    @FXML
    void handleManagerAction(javafx.event.ActionEvent event) throws Exception{
        Stage stage = new Stage();
        FXMLLoader fxmlLoader = new FXMLLoader(getClass().getClassLoader().getResource("ManagerSignUp.fxml"));
        Pane root = fxmlLoader.load();
        ((Node) (event.getSource())).getScene().getWindow().hide();
        stage.setTitle("Create an account as Manager");
        stage.setScene(new Scene(root, 730, 468));
        stage.show();
    }

}
