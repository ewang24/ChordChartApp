package com.oneandahalfasians.chordchartapp.controller.chart;

import com.oneandahalfasians.chordchartapp.ChordChartApplication;
import com.oneandahalfasians.chordchartapp.view.FXMLHelper;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.layout.VBox;

import java.io.IOException;

public class ChartListViewCellController    {

    @FXML
    private VBox vBox;

    public ChartListViewCellController() {
        FXMLLoader loader = new FXMLLoader(FXMLHelper.load("chart/chartListCell.fxml"));
        loader.setController(this);
        try {
            loader.load();
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }



    public VBox getvBox() {
        return vBox;
    }
}
