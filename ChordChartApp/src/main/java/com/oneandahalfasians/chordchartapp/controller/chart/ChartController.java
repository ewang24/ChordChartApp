package com.oneandahalfasians.chordchartapp.controller.chart;

import com.oneandahalfasians.chordchartapp.data.Chart;
import com.oneandahalfasians.chordchartapp.data.entities.ChartEntity;
import com.oneandahalfasians.chordchartapp.view.FXMLHelper;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.control.ListView;
import javafx.scene.layout.VBox;

import java.io.IOException;
import java.net.URL;
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
    private Chart chart;

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {

    }

    public ChartController setChart(Chart chart) {
        this.chart = chart;
        List<ChartEntity> chartEntityList = chart.getEntityList();

        try {
            for (ChartEntity chartEntity : chartEntityList) {
                FXMLLoader fxmlLoader = new FXMLLoader(FXMLHelper.load("chart/chartListCell.fxml"));
                fxmlLoader.setControllerFactory(a -> new ChartListViewCell(chartEntity));
                
                Parent row = fxmlLoader.load();

                container.getChildren().add(row);

            }
        } catch (IOException e) {
            throw new RuntimeException(e);
        }

        return this;
    }
}
