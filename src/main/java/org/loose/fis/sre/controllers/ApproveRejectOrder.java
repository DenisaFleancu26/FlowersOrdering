package org.loose.fis.sre.controllers;

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

public class ApproveRejectOrder {

    @FXML
    private Button Back;

    @FXML
    private ImageView BackImage;

    @FXML
    private ImageView DashboardImage;

    @FXML
    private Button DashboardUp;

    @FXML
    private Button rejectButton;

    @FXML
    private Button approveButton;

    @FXML
    private ImageView LogOutImage;

    @FXML
    private Button LogOutUp;

    @FXML
    private Text addMessage;

    @FXML
    private ImageView backgroundImage;

    @FXML
    private ImageView approveImage;

    @FXML
    private ImageView rejectImage;

    @FXML
    private ImageView orderImage;

    @FXML
    private ListView<String> listView;

    @FXML
    private Text rejectMessage;

    @FXML
    private Text approveMessage;

    private List<Item> itemi = new ArrayList<>();
    private List<Item> itemi2 = new ArrayList<>();

    @FXML
    public void initialize() throws IOException {

        itemi = ItemsService.getDataaChart();

        for (Item c : itemi){
            listView.getItems().addAll(  c.getId() + " " + c.getName() + " " + c.getSize() + " " + c.getPrice());
        }

        File fundalFile = new File("src/main/java/org/loose/fis/sre/images/fundal.jpg");
        Image fundalImage = new Image(fundalFile.toURI().toString());
        backgroundImage.setImage(fundalImage);

        File dashboardFile = new File("src/main/java/org/loose/fis/sre/images/home.png");
        Image dashboardImage = new Image(dashboardFile.toURI().toString());
        DashboardImage.setImage(dashboardImage);

        File historyFile = new File("src/main/java/org/loose/fis/sre/images/back.png");
        Image historyImage = new Image(historyFile.toURI().toString());
        BackImage.setImage(historyImage);

        File logOutFile = new File("src/main/java/org/loose/fis/sre/images/log-out.png");
        Image logOutImage = new Image(logOutFile.toURI().toString());
        LogOutImage.setImage(logOutImage);

        File approveFile = new File("src/main/java/org/loose/fis/sre/Images/approve.png");
        Image ApproveImage = new Image(approveFile.toURI().toString());
        approveImage.setImage(ApproveImage);

        File rejectFile = new File("src/main/java/org/loose/fis/sre/Images/reject.png");
        Image RejectImage = new Image(rejectFile.toURI().toString());
        rejectImage.setImage(RejectImage);

        File orderFile = new File("src/main/java/org/loose/fis/sre/Images/order-now.png");
        Image OrderImage = new Image(orderFile.toURI().toString());
        orderImage.setImage(OrderImage);


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

    @FXML
    void handleRejectOrderAction() {
        itemi2 = ItemsService.getDataaChart();

        for(Item c : itemi2){
            ItemsService.moveItemHistory(c.getId(), c.getName(), c.getPrice(), c.getSize() );
        }
        ItemsService.moveItemHistory(" ", "Order Rejected!", " ", " "  );
        approveMessage.setText("Order Rejected!");
    }
    @FXML
    void handleApproveOrderAction() {
        itemi2 = ItemsService.getDataaChart();

        for(Item c : itemi2){
            ItemsService.moveItemHistory(c.getId(), c.getName(), c.getPrice(), c.getSize() );
        }
        ItemsService.moveItemHistory(" ", "Order Approved!", " ", " "  );
        approveMessage.setText("Order Approved!");
    }

}

