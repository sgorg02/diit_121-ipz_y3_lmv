package com.example.lab3_lmv;

import animations.Shake;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.image.ImageView;
import javafx.stage.Stage;

import java.io.IOException;

public class NaviViewController {
    @FXML
    private Label dateDegree;
    @FXML
    private Label dateTime;

    @FXML
    private TextField appointmenTextArea;
    @FXML
    private TextField departureTextArea;

    @FXML
    private Button buttonExitMain;
    @FXML
    private Button buttonSwap;
    @FXML
    private Button buttonWillGo;

    @FXML
    private ImageView imageBluetooth;


    public void initialize() {
        TopPanel.initTime(dateTime);
        TopPanel.choosingImageBluetooth(imageBluetooth);
        TopPanel.initDateDegree(dateDegree);

        initStyleTextField();
        initButtonSwap();

        buttonSwapAction();
        buttonExitMainAction();
        buttonWillGoAction();
    }

    private void initButtonSwap() {
        ImageView navi = new ImageView("D:/IdeaProjects/lab3_lmv/src/main/resources/icon/swap_exchange_icon.png");
        navi.setFitHeight(15); navi.setFitWidth(15); // set size image
        buttonSwap.graphicProperty().setValue(navi); // set image in button
    }
    private void initStyleTextField() {
        appointmenTextArea.setStyle("-fx-text-fill: #949494; -fx-background-color: #3b415e");
        departureTextArea.setStyle("-fx-text-fill: #949494; -fx-background-color: #3b415e");
    }

    private void buttonSwapAction() {
        buttonSwap.setOnAction(event ->{
            String tmp1 = appointmenTextArea.getText();
            appointmenTextArea.setText(departureTextArea.getText());
            departureTextArea.setText(tmp1);
                });
    }
    private void buttonWillGoAction() {
        buttonWillGo.setOnAction(event -> {
            boolean check = true;
            // checking for an empty string
            if(appointmenTextArea.getText().isEmpty()){
                Shake willGoAnim = new Shake(appointmenTextArea);
                willGoAnim.playAnim(); // play animation
                check = false;
            }
            // checking for an empty string
            if(departureTextArea.getText().isEmpty()) {
                Shake willGoAnim = new Shake(departureTextArea);
                willGoAnim.playAnim(); // play animation
                check = false;
            }
            if (check) { // trigger notification if all rows are full
                Alert alert = new Alert(Alert.AlertType.INFORMATION);

                alert.setTitle("Information Dialog");
                alert.setHeaderText(null);
                alert.setContentText("Маршрут побудован!");

                alert.showAndWait();
            }
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
