package com.oneandahalfasians.chordchartapp.controller.chart;

import com.oneandahalfasians.chordchartapp.data.entities.ChartEntity;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.layout.VBox;
import javafx.scene.text.Text;

import java.net.URL;
import java.util.ResourceBundle;

public class ChartListViewCell extends Node implements Initializable {

    @FXML
    VBox vBox;

    private ChartEntity chartEntity;

    public ChartListViewCell(ChartEntity chartEntity) {
        this.chartEntity = chartEntity;
    }

    public ChartEntity getChartEntity() {
        return chartEntity;
    }

    public ChartListViewCell setChartEntity(ChartEntity chartEntity) {
        this.chartEntity = chartEntity;
        return this;
    }

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        vBox.getChildren().add(chartEntity.render());
    }
}
