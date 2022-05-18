package org.loose.fis.sre.controllers;

import javafx.animation.TranslateTransition;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.Pane;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;
import javafx.util.Duration;

import java.io.File;

public class MainPageCustomer {

    @FXML
    private Button Dashboard;

    @FXML
    private ImageView DashboardImage;

    @FXML
    private ImageView DashboardImageUp;

    @FXML
    private Button DashboardUp;

    @FXML
    private Button Flower;

    @FXML
    private ImageView FlowerImage;

    @FXML
    private Button FlowerShop;

    @FXML
    private ImageView FlowerShopImage;

    @FXML
    private Button History;

    @FXML
    private ImageView HistoryImage;

    @FXML
    private ImageView HistoryImageUp;

    @FXML
    private Button HistoryUp;

    @FXML
    private Button LogOut;

    @FXML
    private ImageView LogOutImage;

    @FXML
    private ImageView LogOutImageUp;

    @FXML
    private Button LogOutUp;

    @FXML
    private Label Menu;

    @FXML
    private Label MenuClose;

    @FXML
    private ImageView MenuImage;

    @FXML
    private Button Orders;

    @FXML
    private ImageView OrdersImage;

    @FXML
    private ImageView OrdersImageUp;

    @FXML
    private Button OrdersUp;

    @FXML
    private VBox Slider;

    @FXML
    private AnchorPane Slider2;

    @FXML
    private ImageView welcome;


    @FXML
    public void initialize() {

        File welcomeFile = new File("src/main/java/org/loose/fis/sre/images/welcome.jpg");
        Image welcomeImage = new Image(welcomeFile.toURI().toString());
        welcome.setImage(welcomeImage);

        File flowerShopFile = new File("src/main/java/org/loose/fis/sre/images/searching.png");
        Image flowerShopImage = new Image(flowerShopFile.toURI().toString());
        FlowerShopImage.setImage(flowerShopImage);

        File dashboardFile = new File("src/main/java/org/loose/fis/sre/images/home.png");
        Image dashboardImage = new Image(dashboardFile.toURI().toString());
        DashboardImage.setImage(dashboardImage);
        DashboardImageUp.setImage(dashboardImage);

        File flowerImageFile = new File("src/main/java/org/loose/fis/sre/images/flowersicon.png");
        Image flowerImage = new Image(flowerImageFile.toURI().toString());
        FlowerImage.setImage(flowerImage);

        File historyFile = new File("src/main/java/org/loose/fis/sre/images/history.png");
        Image historyImage = new Image(historyFile.toURI().toString());
        HistoryImage.setImage(historyImage);
        HistoryImageUp.setImage(historyImage);

        File logOutFile = new File("src/main/java/org/loose/fis/sre/images/log-out.png");
        Image logOutImage = new Image(logOutFile.toURI().toString());
        LogOutImage.setImage(logOutImage);
        LogOutImageUp.setImage(logOutImage);

        File menuFile = new File("src/main/java/org/loose/fis/sre/images/menu.png");
        Image menuImage = new Image(menuFile.toURI().toString());
        MenuImage.setImage(menuImage);

        File ordersFile = new File("src/main/java/org/loose/fis/sre/images/checkout.png");
        Image ordersImage = new Image(ordersFile.toURI().toString());
        OrdersImage.setImage(ordersImage);
        OrdersImageUp.setImage(ordersImage);

        Slider.setTranslateX(300);
        MenuClose.setVisible(false);

        Menu.setOnMouseClicked( event -> {
            TranslateTransition slide = new TranslateTransition();
            slide.setDuration(Duration.seconds(0.5));
            slide.setNode(Slider);

            slide.setToX(0);
            slide.play();

            Slider.setTranslateX(-300);

            slide.setOnFinished((ActionEvent e) -> {
                Menu.setVisible(false);
                MenuClose.setVisible(true);
            });
        });

        MenuClose.setOnMouseClicked( event -> {
            TranslateTransition slide = new TranslateTransition();
            slide.setDuration(Duration.seconds(0.5));
            slide.setNode(Slider);

            slide.setToX(-300);
            slide.play();

            Slider.setTranslateX(0);

            slide.setOnFinished((ActionEvent e) -> {
                Menu.setVisible(true);
                MenuClose.setVisible(false);
            });
        });


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
    void handleFlowerShopsAction(javafx.event.ActionEvent event) throws Exception{
        Stage stage = new Stage();
        FXMLLoader fxmlLoader = new FXMLLoader(this.getClass().getClassLoader().getResource("FlowersShop.fxml"));
        Pane root = (Pane)fxmlLoader.load();
        ((Node)event.getSource()).getScene().getWindow().hide();
        stage.setTitle("Flowers Shop that are in the app.");
        stage.setScene(new Scene((Parent)root, 1200.0, 700.0));
        stage.show();
    }

}
