package org.loose.fis.sre.controllers;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.ChoiceBox;
import javafx.scene.control.TextField;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.Pane;
import javafx.scene.text.Text;
import javafx.stage.Stage;
import org.loose.fis.sre.exceptions.IdAlreadyExistsException;
import org.loose.fis.sre.services.ItemsService;

import javax.swing.*;
import java.io.File;

public class AddItem {

    @FXML
    private Button AddInShop;

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
    private ImageView backgroundImage;

    @FXML
    private Button LogOutUp;

    @FXML
    private Button attachButton;

    @FXML
    private TextField idField;

    @FXML
    private ImageView itemImage;

    @FXML
    private TextField nameField;

    @FXML
    private TextField pathField;

    @FXML
    private TextField priceField;

    @FXML
    private ChoiceBox size;

    @FXML
    private Text addMessage;

    @FXML
    public void initialize() {
        size.getItems().addAll("Small", "Medium", "Big");
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
    }

    @FXML
    void handleAddInShopAction(javafx.event.ActionEvent event) throws Exception {

        try{

            String image = pathField.getText();
            image = image.replace("\\","\\\\");
            ItemsService.addItem(idField.getText(), nameField.getText(), priceField.getText(), ((String) size.getValue() ), image);
            addMessage.setText("Item added successfully!");
        } catch ( IdAlreadyExistsException e) {
        addMessage.setText(e.getMessage());
        }

    }

    @FXML
    void handleAttachButtonAction(ActionEvent event) {
        JFileChooser chooser = new JFileChooser();
        chooser.showOpenDialog(null);
        File f = chooser.getSelectedFile();
        String filename = f.getAbsolutePath();
        pathField.setText(filename);
        itemImage.setImage(new Image(filename));
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
