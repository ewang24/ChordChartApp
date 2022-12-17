package com.oneandahalfasians.chordchartapp.controller;

import com.oneandahalfasians.chordchartapp.controller.chart.ChartController;
import com.oneandahalfasians.chordchartapp.data.entities.ChartEntity;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.text.Text;

import java.net.URL;
import java.util.Arrays;
import java.util.ResourceBundle;

public class MainController implements Initializable {

    @FXML
    private Parent chartView;

    @FXML
    private ChartController chartViewController;

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {

        chartViewController.setChartEntityList(Arrays.asList(
                new ChartEntity(),
                new ChartEntity(),
                new ChartEntity(),
                new ChartEntity(),
                new ChartEntity()
        ));

    }
}
