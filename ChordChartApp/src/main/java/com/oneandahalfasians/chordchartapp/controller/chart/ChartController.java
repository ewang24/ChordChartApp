package com.oneandahalfasians.chordchartapp.controller.chart;

import com.oneandahalfasians.chordchartapp.data.entities.ChartEntity;
import com.oneandahalfasians.chordchartapp.view.FXMLHelper;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.control.ListView;
import javafx.scene.layout.FlowPane;
import javafx.scene.layout.VBox;

import java.io.IOException;
import java.net.URL;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.ResourceBundle;

public class ChartController implements Initializable {

    /*
        FXML objects
     */
    @FXML
    private URL location;
    @FXML
    public ListView<ChartEntity> chartEntitiesListView;
    @FXML
    public VBox container;

    /*
        Instance fields
     */

    private List<ChartEntity> chartEntityList = new ArrayList<>();

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {

    }

    public List<ChartEntity> getChartEntityList() {
        return chartEntityList;
    }

    public ChartController setChartEntityList(List<ChartEntity> chartEntityList) {
        this.chartEntityList = chartEntityList;

        try {
            for (ChartEntity chartEntity : chartEntityList) {
                FXMLLoader fxmlLoader = new FXMLLoader(FXMLHelper.load("chart/chartListCell.fxml"));
                Parent row = fxmlLoader.load();
                container.getChildren().add(row);
            }
        } catch (IOException e) {
            throw new RuntimeException(e);
        }

        return this;
    }
}
