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
import javafx.scene.layout.Pane;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;
import javafx.util.Duration;

import java.io.File;

public class MainPageManager {

    @FXML
    private Button Catalogue;

    @FXML
    private ImageView CatalogueImage;

    @FXML
    private Button Dashboard;

    @FXML
    private ImageView DashboardImage;

    @FXML
    private ImageView DashboardImageUp;

    @FXML
    private Button DashboardUp;

    @FXML
    private ImageView EditImage;

    @FXML
    private Button EditItems;

    @FXML
    private Button History;

    @FXML
    private ImageView HistoryImage;

    @FXML
    private ImageView HistoryImageUp;

    @FXML
    private Button HistoryUp;

    @FXML
    private ImageView ImageBackground;

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
    private Button Orders1;

    @FXML
    private ImageView OrdersImage;

    @FXML
    private ImageView OrdersImageUp;

    @FXML
    private Button OrdersUp;

    @FXML
    private VBox Slider;

    @FXML
    private ImageView welcome;

    @FXML
    public void initialize() {

        File fundalFile = new File("src/main/java/org/loose/fis/sre/images/fundal.jpg");
        Image fundalImage = new Image(fundalFile.toURI().toString());
        ImageBackground.setImage(fundalImage);

        File welcomeFile = new File("src/main/java/org/loose/fis/sre/images/welcome.jpg");
        Image welcomeImage = new Image(welcomeFile.toURI().toString());
        welcome.setImage(welcomeImage);

        File catalogFile = new File("src/main/java/org/loose/fis/sre/images/catalog.png");
        Image catalogImage = new Image(catalogFile.toURI().toString());
        CatalogueImage.setImage(catalogImage);

        File dashboardFile = new File("src/main/java/org/loose/fis/sre/images/home.png");
        Image dashboardImage = new Image(dashboardFile.toURI().toString());
        DashboardImage.setImage(dashboardImage);
        DashboardImageUp.setImage(dashboardImage);

        File editImageFile = new File("src/main/java/org/loose/fis/sre/images/add.png");
        Image editImage = new Image(editImageFile.toURI().toString());
        EditImage.setImage(editImage);

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

        Slider.setTranslateX(-300);
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
    void handleEditItemsAction(ActionEvent event) throws Exception {
        Stage stage = new Stage();
        FXMLLoader fxmlLoader = new FXMLLoader(this.getClass().getClassLoader().getResource("EditItem.fxml"));
        Pane root = (Pane)fxmlLoader.load();
        ((Node)event.getSource()).getScene().getWindow().hide();
        stage.setTitle("Manager - edit items");
        stage.setScene(new Scene((Parent)root, 1200.0, 700.0));
        stage.show();
    }

    @FXML
    void handleApproveRejectOrders(ActionEvent event) throws Exception {
        Stage stage = new Stage();
        FXMLLoader fxmlLoader = new FXMLLoader(this.getClass().getClassLoader().getResource("ApproveRejectOrder.fxml"));
        Pane root = (Pane)fxmlLoader.load();
        ((Node)event.getSource()).getScene().getWindow().hide();
        stage.setTitle("Approve/Reject Orders (Manager)");
        stage.setScene(new Scene((Parent)root, 1200.0, 700.0));
        stage.show();
    }
    @FXML
    void handleManagerHistoryAction(ActionEvent event) throws Exception {
        Stage stage = new Stage();
        FXMLLoader fxmlLoader = new FXMLLoader(this.getClass().getClassLoader().getResource("ManagerHistory.fxml"));
        Pane root = (Pane)fxmlLoader.load();
        ((Node)event.getSource()).getScene().getWindow().hide();
        stage.setTitle("Order History (Manager)");
        stage.setScene(new Scene((Parent)root, 1200.0, 700.0));
        stage.show();
    }
}

