package org.loose.fis.sre.controllers;

import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.geometry.Insets;
import javafx.scene.Node;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.ScrollPane;
import javafx.scene.control.TextField;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.Pane;
import javafx.scene.text.Text;
import javafx.stage.Stage;
import org.loose.fis.sre.model.Item;
import org.loose.fis.sre.services.ItemsService;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class FlowersShopsItemsController {

    @FXML
    private Button Back;

    @FXML
    private ImageView BackImage;

    @FXML
    private ImageView DashboardImage;

    @FXML
    private Button DashboardUp;

    @FXML
    private GridPane ItemContainer;

    @FXML
    private ImageView LogOutImage;

    @FXML
    private ImageView SearchImage;

    @FXML
    private Button LogOutUp;

    @FXML
    private Button SearchButton;

    @FXML
    private Text addMessage;

    @FXML
    private TextField idField;

    @FXML
    private ImageView itemImage;

    @FXML
    private ScrollPane scroll;

    private List<Item> itemi = new ArrayList<>();

    @FXML
    public void initialize() throws IOException {
        itemi = ItemsService.getDataa();

        int column = 0;
        int row = 0;

        try {
            for (Item itemm : itemi) {
                FXMLLoader fxmlLoader = new FXMLLoader();
                fxmlLoader.setLocation(getClass().getResource("/ItemSyle.fxml"));
                AnchorPane AranjBox = fxmlLoader.load();
                ItemSyle itemSyle = fxmlLoader.getController();
                itemSyle.setData(itemm);

                if (column == 4) {
                    column = 0;
                    row++;
                }

                ItemContainer.add(AranjBox, column++, row);
                GridPane.setMargin(AranjBox, new Insets(10));

            }
        } catch (IOException e) {
            e.printStackTrace();
        }

        File searchFile = new File("src/main/java/org/loose/fis/sre/images/search.jpg");
        Image searchImg = new Image(searchFile.toURI().toString());
        SearchImage.setImage(searchImg);

        File dashboardFile = new File("src/main/java/org/loose/fis/sre/images/home.png");
        Image dashboardImage = new Image(dashboardFile.toURI().toString());
        DashboardImage.setImage(dashboardImage);

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
    void handleSearchButtonAction(javafx.event.ActionEvent event) {
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

}
