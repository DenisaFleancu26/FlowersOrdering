package org.loose.fis.sre.controllers;

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
import org.loose.fis.sre.exceptions.IdDoesNotExistException;
import org.loose.fis.sre.model.Item;
import org.loose.fis.sre.services.ItemsService;

import java.io.File;
import java.util.ArrayList;
import java.util.List;

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

    private List<Item> itemi = new ArrayList<>();

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
    void handleDeleteFromShopAction(javafx.event.ActionEvent event) throws Exception  {
        try{
            ItemsService.deleteItem(idField.getText()/*, nameField.getText(), priceField.getText(), ((String) size.getValue() ), image*/);
            addMessage.setText("Item deleted successfully!");
       } catch ( IdDoesNotExistException e) {
            addMessage.setText(e.getMessage());
        }
    }

    @FXML
    void handleShowItemAction(javafx.event.ActionEvent event) {
        itemi = ItemsService.getDataa();
        int ok = 0;

            for (Item itemm : itemi ) {
                if( idField.getText().equals(itemm.getId())) {
                    var test = itemm.getImg().replace("\\\\", "\\");
                    try {
                        itemImage.setImage(new Image(itemm.getImg().replace("\\\\", "\\")));
                    } catch (Exception ex) {
                        System.out.println(itemm.getImg().replace("\\\\", "\\"));
                        File invalid = new File("src/main/java/org/loose/fis/sre/Images/error.jpg");
                        Image inval = new Image(invalid.toURI().toString());
                        itemImage.setImage(inval);
                    }
                    ok = 1;
                }

            }
        if(ok == 0)
            addMessage.setText("Your data is invalid!");
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
