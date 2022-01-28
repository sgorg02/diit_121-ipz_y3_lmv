package com.example.lab3_lmv;

import javafx.beans.value.ChangeListener;
import javafx.beans.value.ObservableValue;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.image.ImageView;
import javafx.stage.Stage;

import java.io.IOException;

public class MediaViewController {

    @FXML
    private Button buttonBluetooth;
    @FXML
    private Button buttonSD;
    @FXML
    private Button buttonAUX;
    @FXML
    private Button buttonUSB;
    @FXML
    private Button buttonExitMain;

    @FXML
    private Label dateTime;
    @FXML
    private Label dateDegree;

    @FXML
    private ListView<String> listViewBluetooth;

    @FXML
    private ImageView imageBluetooth;

    private boolean checkVisibleListView = false;

    public void initialize() {
        TopPanel.initTime(dateTime);
        TopPanel.choosingImageBluetooth(imageBluetooth);
        TopPanel.initDateDegree(dateDegree);

        initButtonImage();
        initListViewBluetooth();

        listViewBluetoothAction();
        buttonBluetoothAction();
        buttonAUXAction();
        buttonSDAction();
        buttonUSBAction();
        buttonExitMainAction();
    }


    private void initButtonImage() {
        ImageView bluetooth = new ImageView("D:/IdeaProjects/lab3_lmv/src/main/resources/icon/bluetooth_searching_icon.png");
        bluetooth.setFitHeight(100); bluetooth.setFitWidth(100); // set size image
        buttonBluetooth.graphicProperty().setValue(bluetooth); // set image in button

        ImageView AUX = new ImageView("D:/IdeaProjects/lab3_lmv/src/main/resources/icon/AUX1.png");
        AUX.setFitHeight(100); AUX.setFitWidth(100); // set size image
        buttonAUX.graphicProperty().setValue(AUX); // set image in button

        ImageView SD = new ImageView("D:/IdeaProjects/lab3_lmv/src/main/resources/icon/sd_storage_icon.png");
        SD.setFitHeight(100); SD.setFitWidth(100); // set size image
        buttonSD.graphicProperty().setValue(SD); // set image in button

        ImageView USB = new ImageView("D:/IdeaProjects/lab3_lmv/src/main/resources/icon/usb_fill_icon.png");
        USB.setFitHeight(100); USB.setFitWidth(100); // set size image
        buttonUSB.graphicProperty().setValue(USB); // set image in button
    }
    private void initListViewBluetooth() {
        ObservableList<String> langs = FXCollections.observableArrayList("Readmi", "OnePlus", "iPhone 12");
        listViewBluetooth.setItems(langs);
        listViewBluetooth.setStyle("-fx-control-inner-background: #2E3349; -fx-border-color: #3b415e;");
        listViewBluetooth.setVisible(checkVisibleListView);
    }
    private void listViewBluetoothAction() {
        MultipleSelectionModel<String> langsSelectionModel = listViewBluetooth.getSelectionModel();
        // set a listener to track changes
        langsSelectionModel.selectedItemProperty().addListener(new ChangeListener<String>() {
            public void changed(ObservableValue<? extends String> changed, String oldValue, String newValue) {
                Alert alert = new Alert(Alert.AlertType.INFORMATION);

                alert.setTitle("Information Dialog");
                alert.setHeaderText(null);
                alert.setContentText("Пристрій " + newValue + " підключен!");

                alert.showAndWait();

                // set image bluetooth_connected.png
                TopPanel.check = true;
                TopPanel.choosingImageBluetooth(imageBluetooth);
            }
        });
    }

    private void buttonBluetoothAction() {
        buttonBluetooth.setOnAction(event -> {
            if (!checkVisibleListView) {
                listViewBluetooth.setVisible(true);
                checkVisibleListView = true;
            }  else {
                listViewBluetooth.setVisible(false);
                checkVisibleListView = false;
                TopPanel.check = false;
                TopPanel.choosingImageBluetooth(imageBluetooth);
            }

        });
    }
    private void buttonUSBAction() {
        buttonUSB.setOnAction(event -> {
            Alert alert = new Alert(Alert.AlertType.INFORMATION);

            alert.setTitle("Information Dialog");
            alert.setHeaderText(null);
            alert.setContentText("USB-носій підключен!");

            alert.showAndWait();
        });
    }
    private void buttonSDAction() {
        buttonSD.setOnAction(event -> {
            Alert alert = new Alert(Alert.AlertType.INFORMATION);

            alert.setTitle("Information Dialog");
            alert.setHeaderText(null);
            alert.setContentText("SD-картка підключена!");

            alert.showAndWait();
        });
    }
    private void buttonAUXAction() {
        buttonAUX.setOnAction(event -> {
            Alert alert = new Alert(Alert.AlertType.INFORMATION);

            alert.setTitle("Information Dialog");
            alert.setHeaderText(null);
            alert.setContentText("Пристрій підключен!");

            alert.showAndWait();
        });
    }
    private void buttonExitMainAction() {
        buttonExitMain.setOnAction(event ->
                buttonExitMain.getScene().getWindow().hide());

        FXMLLoader loader = new FXMLLoader();
        loader.setLocation(getClass().getResource("main-view.fxml"));

        try {
            loader.load();
        } catch (IOException e){
            e.printStackTrace();
        }

        Parent root = loader.getRoot();
        Stage stage = new Stage();
        stage.setScene(new Scene(root));
        stage.show();
    }
}
