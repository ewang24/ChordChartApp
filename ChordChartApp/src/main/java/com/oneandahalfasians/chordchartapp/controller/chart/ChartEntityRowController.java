package com.oneandahalfasians.chordchartapp.controller.chart;

import com.oneandahalfasians.chordchartapp.data.entities.ChartEntity;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.layout.VBox;

import java.net.URL;
import java.util.ResourceBundle;

public class ChartEntityRowController extends Node implements Initializable {

    @FXML
    VBox vBox;

    private ChartEntity chartEntity;

    public ChartEntityRowController(ChartEntity chartEntity) {
        this.chartEntity = chartEntity;
    }

    public ChartEntity getChartEntity() {
        return chartEntity;
    }

    public ChartEntityRowController setChartEntity(ChartEntity chartEntity) {
        this.chartEntity = chartEntity;
        return this;
    }

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        vBox.getChildren().add(chartEntity.render());
    }
}
