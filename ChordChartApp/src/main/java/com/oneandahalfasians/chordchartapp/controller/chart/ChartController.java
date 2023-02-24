package com.oneandahalfasians.chordchartapp.controller.chart;

import com.oneandahalfasians.chordchartapp.controller.chart.chartEntity.EntityController;
import com.oneandahalfasians.chordchartapp.data.Chart;
import com.oneandahalfasians.chordchartapp.data.entities.ChartEntity;
import com.oneandahalfasians.chordchartapp.model.ChartEntityOptionsModel;
import com.oneandahalfasians.chordchartapp.view.FXMLHelper;
import com.oneandahalfasians.chordchartapp.view.chartEntity.Page;
import javafx.application.Platform;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.ListView;
import javafx.scene.control.ScrollPane;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.Priority;
import javafx.scene.layout.VBox;
import javafx.scene.text.Font;
import javafx.scene.text.FontWeight;
import javafx.scene.text.Text;
import javafx.stage.Stage;

import java.io.IOException;
import java.lang.reflect.InvocationTargetException;
import java.net.URL;
import java.util.*;
import java.util.stream.IntStream;

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

    @FXML
    public ScrollPane scrollPane;

    @FXML
    public VBox scrollingBox;

    public List<Page> pages = new ArrayList<>();

    /*
        Instance fields
     */
    private Chart chart;
    private double pageHeight = 0;
    private double width = 0;

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        container.setMinWidth(width);
        VBox.setVgrow(container, Priority.ALWAYS);
        VBox.setVgrow(scrollPane, Priority.ALWAYS);
        scrollPane.setMaxWidth(Double.MAX_VALUE);
    }

    public void setupChart(Chart chart, double pageHeight, double width) {
        this.chart = chart;
        this.pageHeight = pageHeight;
        this.width = width;

        //Display chart title if present
        if(chart.getTitle() != null){
            Text title = new Text(chart.getTitle());
            title.setFont(Font.font("arial", FontWeight.BOLD,  30));
            scrollingBox.getChildren().add(title);
        }

        //Generate a horizontal display for the chart info
        HBox infoBox = new HBox();
        if(chart.getKeyList() != null && !chart.getKeyList().isEmpty()){
            infoBox.getChildren().add(new Text(chart.getKeySignature()));
        }

        infoBox.getChildren().add(new Text(chart.getTimeSignature()));
        infoBox.getChildren().add(new Text(chart.getTempoString()));

        if(!infoBox.getChildren().isEmpty()){
            scrollingBox.getChildren().add(infoBox);
        }

        try {
            addChild(null, false, false);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    public void addChild(ChartEntity newEntity) throws IOException {
//        addChild(newEntity, false, false);
    }

    public void addChild(ChartEntity newEntity, boolean shouldFocus, boolean shouldAddNewEmptyElement) throws IOException {
        Map<String, FXMLLoader> loaderMap = new HashMap<>();

        if(pageHeight == 0.0){
            throw new RuntimeException("Layout is invalid!");
        }

        Page pageToUse;
        if(pages.isEmpty()){
            pageToUse = new Page(pageHeight);
            pages.add(pageToUse);
        }
        else{
            pageToUse = pages.get(pages.size() - 1);
        }

        scrollingBox.getChildren().add(pageToUse);

        try {

            List<ChartEntity> chartEntityList = chart.getEntityList();

            //Create a row for each of the chart entities (verses, choruses, bridge, etc.)
            for (ChartEntity chartEntity : chartEntityList) {
                EntityController controller =
                        chartEntity.getViewClass()
                                .getDeclaredConstructor(ChartEntity.class, ChartEntityOptionsModel.class)
                                .newInstance(
                                        chartEntity,
                                        new ChartEntityOptionsModel(false, false)
                                );

                String fxmlFileName = controller.getFxmlFileName();

                FXMLLoader fxmlLoader;
                if(!loaderMap.containsKey(fxmlFileName)){
                    fxmlLoader = new FXMLLoader(FXMLHelper.load(fxmlFileName));
                    fxmlLoader.setController(controller);
                    loaderMap.put(fxmlFileName, fxmlLoader);
                }else{
                    fxmlLoader = loaderMap.get(fxmlFileName);
                }

                VBox row = fxmlLoader.<VBox>load();

                pageToUse.addRow(row);

                scrollPane.applyCss();
                scrollPane.layout();

                if(pageToUse.getHeight() > pageHeight){
                    pageToUse.removeLastAdded();

                    pageToUse = pageToUse.addPageNext();
                    scrollingBox.getChildren().add(pageToUse);
                    VBox.setVgrow(pageToUse, Priority.ALWAYS);
                    GridPane.setVgrow(pageToUse, Priority.ALWAYS);
                    pageToUse.addRow(row);

                    pages.add(pageToUse);
                }
            }
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
