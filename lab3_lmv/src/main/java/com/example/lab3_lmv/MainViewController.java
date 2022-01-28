package com.example.lab3_lmv;

import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.image.ImageView;

import java.io.IOException;

import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

public class MainViewController {

    @FXML
    private Label dateDegree;
    @FXML
    private Button buttonMedia;
    @FXML
    private Button buttonNavi;
    @FXML
    private Button buttonRadio;
    @FXML
    private Label dateTime;
    @FXML
    private ImageView imageBluetooth;


    public void initialize() {
        TopPanel.initTime(dateTime);
        TopPanel.choosingImageBluetooth(imageBluetooth);
        TopPanel.initDateDegree(dateDegree);

        initButtonImage();
        buttonNaviAction();
        buttonMediaAction();
        buttonRadioAction();
    }

    private void initButtonImage() {
        ImageView navi = new ImageView("D:/IdeaProjects/lab3_lmv/src/main/resources/icon/navigation_icon.png");
        navi.setFitHeight(100); navi.setFitWidth(100); // set size image
        buttonNavi.graphicProperty().setValue(navi); // set image in button

        ImageView radio = new ImageView("D:/IdeaProjects/lab3_lmv/src/main/resources/icon/radio_icon.png");
        radio.setFitHeight(100); radio.setFitWidth(100); // set size image
        buttonRadio.graphicProperty().setValue(radio);

        ImageView media = new ImageView("D:/IdeaProjects/lab3_lmv/src/main/resources/icon/media_music_network_social_icon.png");
        media.setFitHeight(100); media.setFitWidth(100); // set size image
        buttonMedia.graphicProperty().setValue(media); // set image in button

    }

    private void buttonNaviAction() {
        buttonNavi.setOnAction(event -> {
            buttonNavi.getScene().getWindow().hide();

            try {
                openScene("navi-view.fxml");
            } catch (IOException e) {
                e.printStackTrace();
            }
        });

    }
    private void buttonMediaAction() {
        buttonMedia.setOnAction(event -> {
            buttonMedia.getScene().getWindow().hide();

            try {
                openScene("media-view.fxml");
            } catch (IOException e) {
                e.printStackTrace();
            }

        });
    }
    private void buttonRadioAction() {
        buttonRadio.setOnAction(event -> {
            buttonRadio.getScene().getWindow().hide();

            try {
                openScene("radio-view.fxml");
            } catch (IOException e) {
                e.printStackTrace();
            }
        });
    }

    private void openScene(String fileName) throws IOException {
        FXMLLoader loader = new FXMLLoader();
        loader.setLocation(getClass().getResource(fileName));

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

