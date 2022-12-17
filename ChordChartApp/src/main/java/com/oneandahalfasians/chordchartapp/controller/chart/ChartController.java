package com.oneandahalfasians.chordchartapp.controller.chart;

import com.oneandahalfasians.chordchartapp.ChordChartApplication;
import com.oneandahalfasians.chordchartapp.data.entities.ChartEntity;
import com.oneandahalfasians.chordchartapp.view.FXMLHelper;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.ListCell;
import javafx.scene.control.ListView;
import javafx.util.Callback;

import java.io.IOException;
import java.net.URL;
import java.util.Arrays;
import java.util.ResourceBundle;

public class ChartController implements Initializable {

    @FXML
    private URL location;
    @FXML
    public ListView<ChartEntity> chartEntitiesListView;
    ObservableList<ChartEntity> chartEntityObservableList = FXCollections.observableArrayList();

    public ChartController() {
        try {
            FXMLLoader loader = new FXMLLoader(FXMLHelper.load("chart/chartListView.fxml"));
            loader.setController(this);
            Parent parent = (Parent) loader.load();
            Scene scene = new Scene(parent);
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }


    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        setListView();
    }

    public void setListView(){

        chartEntityObservableList.addAll(
                Arrays.asList(
                        new ChartEntity(),
                        new ChartEntity(),
                        new ChartEntity()
                )
        );
        chartEntitiesListView.setItems(chartEntityObservableList);
        chartEntitiesListView.setCellFactory(new Callback<ListView<ChartEntity>, ListCell<ChartEntity>>() {
            @Override
            public ListCell<ChartEntity> call(ListView listView) {
                return new ChartListViewCell();
            }
        });
    }

}
