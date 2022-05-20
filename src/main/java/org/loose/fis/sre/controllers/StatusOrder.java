package org.loose.fis.sre.controllers;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.ListView;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.Pane;
import javafx.scene.text.Text;
import javafx.stage.Stage;
import org.loose.fis.sre.model.Item;
import org.loose.fis.sre.services.ItemsService;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class StatusOrder {

    @FXML
    private Button Back;

    @FXML
    private ImageView BackImage;

    @FXML
    private ImageView DashboardImage;

    @FXML
    private Button DashboardUp;

    @FXML
    private ImageView ImageBackground;

    @FXML
    private ImageView LogOutImage;

    @FXML
    private Button LogOutUp;

    @FXML
    private ListView<String> finalStatus;

    @FXML
    private ListView<String> initialStatus;

    @FXML
    private Button sendButton;

    @FXML
    private ImageView statusImage;

    @FXML
    private Text statusOrderMessage;

    private List<Item> itemi = new ArrayList<>();
    private List<Item> itemi2 = new ArrayList<>();

    @FXML
    public void initialize() throws IOException {

        itemi = ItemsService.getDataaChart();

        for (Item c : itemi){
            initialStatus.getItems().addAll(  c.getId() + " " + c.getName() + " " + c.getSize() + " " + c.getPrice());
        }

        File fundalFile = new File("src/main/java/org/loose/fis/sre/images/fundal.jpg");
        Image fundalImage = new Image(fundalFile.toURI().toString());
        ImageBackground.setImage(fundalImage);

        File dashboardFile = new File("src/main/java/org/loose/fis/sre/images/home.png");
        Image dashboardImage = new Image(dashboardFile.toURI().toString());
        DashboardImage.setImage(dashboardImage);

        File historyFile = new File("src/main/java/org/loose/fis/sre/images/back.png");
        Image historyImage = new Image(historyFile.toURI().toString());
        BackImage.setImage(historyImage);

        File logOutFile = new File("src/main/java/org/loose/fis/sre/images/log-out.png");
        Image logOutImage = new Image(logOutFile.toURI().toString());
        LogOutImage.setImage(logOutImage);

        File statusFile = new File("src/main/java/org/loose/fis/sre/images/delivery.png");
        Image StatusImage = new Image(statusFile.toURI().toString());
        statusImage.setImage(StatusImage);
    }

    @FXML
    void handleBackAction(javafx.event.ActionEvent event) throws Exception {
        Stage stage = new Stage();
        FXMLLoader fxmlLoader = new FXMLLoader(getClass().getClassLoader().getResource("MainPageCustomer.fxml"));
        Pane root = fxmlLoader.<Pane>load();
        ((Node) (event.getSource())).getScene().getWindow().hide();
        stage.setTitle("Flowers Ordering (Customer)");
        stage.setScene(new Scene(root, 1200, 700));
        stage.show();
    }

    @FXML
    void handleDashboardUpAction(javafx.event.ActionEvent event) throws Exception {
        Stage stage = new Stage();
        FXMLLoader fxmlLoader = new FXMLLoader(getClass().getClassLoader().getResource("MainPageCustomer.fxml"));
        Pane root = fxmlLoader.<Pane>load();
        ((Node) (event.getSource())).getScene().getWindow().hide();
        stage.setTitle("Flowers Ordering (Customer)");
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

    @FXML
    void handleSendOrderAction(javafx.event.ActionEvent event) {
        itemi = ItemsService.getDataaChart();

        initialStatus.getItems().removeAll();
        itemi2 = ItemsService.getDataaHistory();
        for (Item c : itemi2){
            finalStatus.getItems().addAll(  c.getId() + " " + c.getName() + " " + c.getSize() + " " + c.getPrice());
        }
        statusOrderMessage.setText("The status of the order!");
    }

}
