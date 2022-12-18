package com.oneandahalfasians.chordchartapp.controller.chart;

import com.oneandahalfasians.chordchartapp.data.entities.ChartEntity;
import com.oneandahalfasians.chordchartapp.view.FXMLHelper;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.control.ListCell;
import javafx.scene.layout.VBox;
import javafx.scene.text.Text;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

public class ChartListViewCell extends Node implements Initializable {

    @FXML
    VBox vBox;

    private ChartEntity chart;

    public ChartListViewCell(ChartEntity chart) {
        this.chart = chart;
    }

    public ChartEntity getChart() {
        return chart;
    }

    public ChartListViewCell setChart(ChartEntity chart) {
        this.chart = chart;
        return this;
    }

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        chart
        vBox.getChildren().add(new Text(chart.()));
    }
}
