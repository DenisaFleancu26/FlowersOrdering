package org.loose.fis.sre.controllers;


import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.Pane;
import javafx.stage.Stage;
import org.loose.fis.sre.model.Item;
import org.loose.fis.sre.services.ItemsService;


import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class FeedbackOrder {

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
    private TextArea feedbackField;

    @FXML
    private ImageView feedbackImage;

    @FXML
    private Button sendButton;

    @FXML
    private Button recivedButton;

    private List<Item> itemi = new ArrayList<>();

    @FXML
    public void initialize() throws IOException {


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

        File feedbackFile = new File("src/main/java/org/loose/fis/sre/images/feedback.png");
        Image FeedbackImage = new Image(feedbackFile.toURI().toString());
        feedbackImage.setImage(FeedbackImage);
    }

    @FXML
    void handleBackAction(javafx.event.ActionEvent event) throws Exception {
        Stage stage = new Stage();
        FXMLLoader fxmlLoader = new FXMLLoader(getClass().getClassLoader().getResource("StatusOrder.fxml"));
        Pane root = fxmlLoader.<Pane>load();
        ((Node) (event.getSource())).getScene().getWindow().hide();
        stage.setTitle("Status Order.");
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
    void handleSendFeedbackAction(javafx.event.ActionEvent event) throws Exception{

        itemi = ItemsService.getDataaHistory();

        for(Item c : itemi){}
        ItemsService.moveItemHistory("Customer feedback: ", feedbackField.getText(), "  ", "  "  );

        Stage stage = new Stage();
        FXMLLoader fxmlLoader = new FXMLLoader(getClass().getClassLoader().getResource("StatusOrder.fxml"));
        Pane root = fxmlLoader.<Pane>load();
        ((Node) (event.getSource())).getScene().getWindow().hide();
        stage.setTitle("Status Order.");
        stage.setScene(new Scene(root, 1200, 700));
        stage.show();
    }

}

