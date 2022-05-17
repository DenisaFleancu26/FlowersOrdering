package org.loose.fis.sre.controllers;

import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.geometry.Insets;
import javafx.scene.Node;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.ScrollPane;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.Pane;
import javafx.stage.Stage;
import org.loose.fis.sre.model.Item;
import org.loose.fis.sre.services.ItemsService;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class EditItem {

    @FXML
    private ImageView AddImage;

    @FXML
    private Button AddItem;

    @FXML
    private Button Back;

    @FXML
    private ImageView BackImage;

    @FXML
    private ImageView DashboardImage;

    @FXML
    private Button DashboardUp;

    @FXML
    private Button DeleteItem;

    @FXML
    private ImageView DeleteItemsImage;

    @FXML
    private ImageView ImageBackground;

    @FXML
    private ImageView LogOutImage;

    @FXML
    private Button LogOutUp;

    @FXML
    private GridPane ItemContainer;

    @FXML
    private ScrollPane scroll;

    private List<Item> itemi = new ArrayList<>();

    @FXML
    public void initialize() throws  IOException {
        itemi = ItemsService.getDataa();

        int column = 0;
        int row =0;

        try {
            for (Item itemm : itemi ) {
                FXMLLoader fxmlLoader = new FXMLLoader();
                fxmlLoader.setLocation(getClass().getResource("/ItemSyle.fxml"));
                AnchorPane AranjBox = fxmlLoader.load();
                ItemSyle itemSyle = fxmlLoader.getController();
                itemSyle.setData(itemm);

                if( column == 4) {
                    column = 0;
                    row++;
                }

                ItemContainer.add(AranjBox, column++, row );
                GridPane.setMargin(AranjBox, new Insets(10));

            }
        } catch (IOException e){
            e.printStackTrace();
        }


        File fundalFile = new File("src/main/java/org/loose/fis/sre/images/fundal.jpg");
        Image fundalImage = new Image(fundalFile.toURI().toString());
        ImageBackground.setImage(fundalImage);

        File catalogFile = new File("src/main/java/org/loose/fis/sre/images/add.png");
        Image catalogImage = new Image(catalogFile.toURI().toString());
        AddImage.setImage(catalogImage);

        File dashboardFile = new File("src/main/java/org/loose/fis/sre/images/home.png");
        Image dashboardImage = new Image(dashboardFile.toURI().toString());
        DashboardImage.setImage(dashboardImage);

        File editImageFile = new File("src/main/java/org/loose/fis/sre/images/delete.png");
        Image editImage = new Image(editImageFile.toURI().toString());
        DeleteItemsImage.setImage(editImage);

        File historyFile = new File("src/main/java/org/loose/fis/sre/images/back.png");
        Image historyImage = new Image(historyFile.toURI().toString());
        BackImage.setImage(historyImage);

        File logOutFile = new File("src/main/java/org/loose/fis/sre/images/log-out.png");
        Image logOutImage = new Image(logOutFile.toURI().toString());
        LogOutImage.setImage(logOutImage);
    }

    @FXML
    void handleBackAction(javafx.event.ActionEvent event) throws Exception {
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
    void handleAddItemAction(javafx.event.ActionEvent event) throws Exception {
        Stage stage = new Stage();
        FXMLLoader fxmlLoader = new FXMLLoader(getClass().getClassLoader().getResource("addItem.fxml"));
        Pane root = fxmlLoader.load();
        ((Node) (event.getSource())).getScene().getWindow().hide();
        stage.setTitle("Add a new item");
        stage.setScene(new Scene(root, 1200, 700));
        stage.show();
    }

}
