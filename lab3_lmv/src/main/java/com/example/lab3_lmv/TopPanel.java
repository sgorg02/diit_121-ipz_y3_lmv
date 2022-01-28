package com.example.lab3_lmv;

import javafx.animation.Animation;
import javafx.animation.KeyFrame;
import javafx.animation.Timeline;
import javafx.scene.control.Label;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.util.Duration;

import java.time.LocalDateTime;

public class TopPanel {
    private static int minute;
    private static int hour;
    private static int randomNumber = (int) (Math.random()*30 - 30);;
    public static boolean check;

    public  TopPanel() {}

    public static void initTime(Label dateTime) {
        Timeline clock = new Timeline(new KeyFrame(Duration.ZERO, e -> {
            minute = LocalDateTime.now().getMinute();
            hour = LocalDateTime.now().getHour();
            if((minute) <= 9) //time pattern selection
                dateTime.setText(hour + ":0" + (minute));
            else
                dateTime.setText(hour + ":" + (minute));
        }),
                new KeyFrame(Duration.seconds(1))
        );
        clock.setCycleCount(Animation.INDEFINITE);
        clock.play();
    }

    public static void choosingImageBluetooth(ImageView imageBluetooth) {
        Image image;
        if (!check)
            image = new Image("D:/IdeaProjects/lab3_lmv/src/main/resources/icon/bluetooth_disabled_icon.png");
        else
            image = new Image("D:/IdeaProjects/lab3_lmv/src/main/resources/icon/bluetooth_connected_icon.png");
        imageBluetooth.setImage(image); //set image
        // set size image
        imageBluetooth.setFitWidth(20);
        imageBluetooth.setFitHeight(20);
    }

    public static void initDateDegree(Label dateDegree) {
        dateDegree.setText(String.valueOf(randomNumber)); // set random Degree
    }
}
