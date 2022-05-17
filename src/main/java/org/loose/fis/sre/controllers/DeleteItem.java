package org.loose.fis.sre.controllers;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.Pane;
import javafx.scene.text.Text;
import javafx.stage.Stage;

import java.io.File;

public class DeleteItem {

    @FXML
    private Button DeleteFromShop;

    @FXML
    private Button Back;

    @FXML
    private ImageView BackImage;

    @FXML
    private ImageView DashboardImage;

    @FXML
    private Button DashboardUp;

    @FXML
    private ImageView LogOutImage;

    @FXML
    private Button LogOutUp;

    @FXML
    private Button ShowItem;

    @FXML
    private Text addMessage;

    @FXML
    private ImageView backgroundImage;

    @FXML
    private TextField idField;

    @FXML
    private ImageView itemImage;

    @FXML
    private ImageView trash;

    @FXML
    public void initialize() {
        File fundalFile = new File("src/main/java/org/loose/fis/sre/images/fundal.jpg");
        Image fundalImage = new Image(fundalFile.toURI().toString());
        backgroundImage.setImage(fundalImage);

        File historyFile = new File("src/main/java/org/loose/fis/sre/images/back.png");
        Image historyImage = new Image(historyFile.toURI().toString());
        BackImage.setImage(historyImage);

        File logOutFile = new File("src/main/java/org/loose/fis/sre/images/log-out.png");
        Image logOutImage = new Image(logOutFile.toURI().toString());
        LogOutImage.setImage(logOutImage);

        File dashboardFile = new File("src/main/java/org/loose/fis/sre/images/home.png");
        Image dashboardImage = new Image(dashboardFile.toURI().toString());
        DashboardImage.setImage(dashboardImage);

        File trashFile = new File("src/main/java/org/loose/fis/sre/images/trash.png");
        Image trashImage = new Image(trashFile.toURI().toString());
        trash.setImage(trashImage);

    }

    @FXML
    void handleDeleteFromShopAction(ActionEvent event) {

    }

    @FXML
    void handleBackAction(javafx.event.ActionEvent event) throws Exception {
        Stage stage = new Stage();
        FXMLLoader fxmlLoader = new FXMLLoader(getClass().getClassLoader().getResource("EditItem.fxml"));
        Pane root = fxmlLoader.load();
        ((Node) (event.getSource())).getScene().getWindow().hide();
        stage.setTitle("Manager - edit items");
        stage.setScene(new Scene(root, 1200, 700));
        stage.show();
    }

    @FXML
    void handleDashboardUpAction(javafx.event.ActionEvent event) throws Exception {
        Stage stage = new Stage();
        FXMLLoader fxmlLoader = new FXMLLoader(getClass().getClassLoader().getResource("MainPageManager.fxml"));
        Pane root = fxmlLoader.<Pane>load();
        ((Node) (event.getSource())).getScene().getWindow().hide();
        stage.setTitle("Flowers Ordering (Manager)");
        stage.setScene(new Scene(root, 1200, 700));
        stage.show();
    }

    @FXML
    void handleLogOutAction(javafx.event.ActionEvent event) throws Exception {
        Stage stage = new Stage();
        FXMLLoader fxmlLoader = new FXMLLoader(getClass().getClassLoader().getResource("login.fxml"));
        Pane root = fxmlLoader.load();
        ((Node) (event.getSource())).getScene().getWindow().hide();
        stage.setTitle("Login");
        stage.setScene(new Scene(root, 730, 468));
        stage.show();
    }

}
