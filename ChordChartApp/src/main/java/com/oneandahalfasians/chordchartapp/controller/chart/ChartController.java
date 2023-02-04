package com.oneandahalfasians.chordchartapp.controller.chart;

import com.oneandahalfasians.chordchartapp.controller.chart.chartEntity.EntityController;
import com.oneandahalfasians.chordchartapp.data.Chart;
import com.oneandahalfasians.chordchartapp.data.entities.ChartEntity;
import com.oneandahalfasians.chordchartapp.view.FXMLHelper;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.control.ListView;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.scene.text.Font;
import javafx.scene.text.FontWeight;
import javafx.scene.text.Text;

import java.io.IOException;
import java.lang.reflect.InvocationTargetException;
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

        //Display chart title if present
        if(chart.getTitle() != null){
            Text title = new Text(chart.getTitle());
            title.setFont(Font.font("arial", FontWeight.BOLD,  30));
            container.getChildren().add(title);
        }

        //Generate a horizontal display for the chart info
        HBox infoBox = new HBox();
        if(chart.getKeyList() != null && !chart.getKeyList().isEmpty()){
            infoBox.getChildren().add(new Text(chart.getKeySignature()));
        }

        infoBox.getChildren().add(new Text(chart.getTimeSignature()));
        infoBox.getChildren().add(new Text(chart.getTempoString()));

        if(!infoBox.getChildren().isEmpty()){
            container.getChildren().add(infoBox);
        }

        List<ChartEntity> chartEntityList = chart.getEntityList();

        //Create a row for each of the chart entities (verses, choruses, bridge, etc.)
        try {
            for (ChartEntity chartEntity : chartEntityList) {
                addChild(chartEntity);
            }
        } catch (IOException e) {
            throw new RuntimeException(e);
        }

        return this;
    }

    public void addChild(ChartEntity newEntity) throws IOException {
        addChild(newEntity, false, false);
    }

    public void addChild(ChartEntity newEntity, boolean shouldFocus, boolean shouldAddNewEmptyElement) throws IOException {

        try {
            EntityController controller = newEntity.getViewClass().getDeclaredConstructor(ChartEntity.class).newInstance(newEntity);

            FXMLLoader fxmlLoader = new FXMLLoader(FXMLHelper.load(controller.getFxmlFileName()));
            fxmlLoader.setController(controller);
            Parent row = fxmlLoader.load();
            container.getChildren().add(row);
        } catch (
                InstantiationException |
                IllegalAccessException |
                InvocationTargetException |
                NoSuchMethodException e
        ) {
            throw new RuntimeException(e);
        }
    }
}
