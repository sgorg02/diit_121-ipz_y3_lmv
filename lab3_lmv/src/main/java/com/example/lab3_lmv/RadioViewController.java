package com.example.lab3_lmv;

import javafx.beans.value.ChangeListener;
import javafx.beans.value.ObservableValue;
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.Slider;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseEvent;
import javafx.stage.Stage;

import java.io.IOException;
import java.text.DecimalFormat;

public class RadioViewController {

    @FXML
    private Button buttonExitMain;

    @FXML
    private Button buttonRadio;
    @FXML
    private Button buttonRadio1;
    @FXML
    private Button buttonRadio2;
    @FXML
    private Button buttonRadio3;
    @FXML
    private Button buttonRadio4;
    @FXML
    private Button buttonRadio5;
    @FXML
    private Button buttonRadio51;
    @FXML
    private Button buttonRadio511;
    @FXML
    private Button buttonRadio512;
    @FXML
    private Button buttonRadio513;
    @FXML
    private Button buttonRadio514;
    @FXML
    private Button buttonRadio515;
    @FXML
    private Button buttonRadio516;
    @FXML
    private Button buttonRadio5161;
    @FXML
    private Button buttonRadio5162;
    @FXML
    private Button buttonRadio5163;
    @FXML
    private Button buttonRadio5164;
    @FXML
    private Button buttonRadio5165;
    @FXML
    private Button buttonRadioAdd;



    @FXML
    private Slider sliderRadio;

    @FXML
    private Label dateDegree;
    @FXML
    private Label dateTime;
    @FXML
    private Label infoLabel;
    @FXML
    private Label labelRadioMHr;

    @FXML
    private ImageView imageBluetooth;


    public void initialize() {
        TopPanel.initTime(dateTime);
        TopPanel.choosingImageBluetooth(imageBluetooth);
        TopPanel.initDateDegree(dateDegree);

        initSliderRadio();

        sliderRadioAction();
        buttonExitMainAction();
        buttonRadioAction();
    }

    private void initSliderRadio() {
        sliderRadio.setShowTickLabels(true);
        sliderRadio.setShowTickMarks(true);
        sliderRadio.setBlockIncrement(10);

        initVisibleRollUpBlock(false);
    }

    private void initVisibleRollUpBlock(boolean checkVisible) {
        sliderRadio.setVisible(checkVisible);
        infoLabel.setVisible(checkVisible);
        buttonRadioAdd.setVisible(checkVisible);
    }

    private void sliderRadioAction() {

        sliderRadio.valueProperty().addListener(new ChangeListener<Number>() {

            @Override
            public void changed(ObservableValue<? extends Number> observable, //
                                Number oldValue, Number newValue) {
                String formattedDouble = new DecimalFormat("#0.00").format(newValue);
                infoLabel.setText(formattedDouble + "MHz");
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

    private void buttonRadioAction() {
        longClickButtonRadio(buttonRadio);
        longClickButtonRadio(buttonRadio1);
        longClickButtonRadio(buttonRadio2);
        longClickButtonRadio(buttonRadio3);
        longClickButtonRadio(buttonRadio4);
        longClickButtonRadio(buttonRadio5);
        longClickButtonRadio(buttonRadio51);
        longClickButtonRadio(buttonRadio511);
        longClickButtonRadio(buttonRadio511);
        longClickButtonRadio(buttonRadio512);
        longClickButtonRadio(buttonRadio513);
        longClickButtonRadio(buttonRadio514);
        longClickButtonRadio(buttonRadio515);
        longClickButtonRadio(buttonRadio516);
        longClickButtonRadio(buttonRadio5161);
        longClickButtonRadio(buttonRadio5162);
        longClickButtonRadio(buttonRadio5163);
        longClickButtonRadio(buttonRadio5164);
        longClickButtonRadio(buttonRadio5165);
    }
    private void longClickButtonRadio(Button buttonTmp) {
        boolean check = false;
        buttonTmp.addEventFilter(MouseEvent.ANY, new EventHandler<MouseEvent>() {
            long startTime;
            @Override
            public void handle(MouseEvent mouseEvent) {
                if (mouseEvent.getEventType().equals(MouseEvent.MOUSE_PRESSED)) {
                    startTime = System.currentTimeMillis();
                } else if (mouseEvent.getEventType().equals(MouseEvent.MOUSE_RELEASED)) {
                    if (System.currentTimeMillis() - startTime > 1.5 * 1000) {
                        //System.out.println("Pressed for at least 1.5 seconds (" + (System.currentTimeMillis() - startTime) + " milliseconds)");
                        buttonRadioAddAction(buttonTmp);
                    } else {
                        //System.out.println("Pressed for " + (System.currentTimeMillis() - startTime) + " milliseconds");
                        labelRadioMHr.setText("");
                        if (!buttonTmp.getText().equals("н/д"))
                            labelRadioMHr.setText(buttonTmp.getText());

                    }
                }
            }
        });
    }
    private void buttonRadioAddAction(Button buttonTmp) {
        initVisibleRollUpBlock(true);

        buttonRadioAdd.setOnAction(event -> {
            buttonTmp.setText(infoLabel.getText());
            labelRadioMHr.setText(buttonTmp.getText());
            initVisibleRollUpBlock(false);
        });
    }
}
