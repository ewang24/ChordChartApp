package com.oneandahalfasians.chordchartapp.controller;

import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.text.Text;

import java.net.URL;
import java.util.ResourceBundle;

public class MainController implements Initializable {

    @FXML
    private Text testText;

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        testText.setText("This is a test");
    }
}
