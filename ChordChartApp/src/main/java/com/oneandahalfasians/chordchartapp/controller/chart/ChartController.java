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
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.scene.text.Font;
import javafx.scene.text.FontWeight;
import javafx.scene.text.Text;
import javafx.stage.Stage;

import java.io.IOException;
import java.lang.reflect.InvocationTargetException;
import java.net.URL;
import java.util.ArrayList;
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

    public List<Page> pages = new ArrayList<>();

    /*
        Instance fields
     */
    private Chart chart;
    private double pageHeight = 0;

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {

    }

    public ChartController setupChart(Chart chart, double pageHeight) {
        this.chart = chart;
        this.pageHeight = pageHeight;

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

        try {
            addChild(null, false, false);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }

        return this;
    }

    public void addChild(ChartEntity newEntity) throws IOException {
//        addChild(newEntity, false, false);
    }

    public void addChild(ChartEntity newEntity, boolean shouldFocus, boolean shouldAddNewEmptyElement) throws IOException {
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

        container.getChildren().add(pageToUse);

        try {

//            Stage stage = new Stage();
//
//            VBox vbox = new VBox();
//            Scene scene = new Scene(vbox);
//            scene.getStylesheets().add(FXMLHelper.loadCSS("css/app.css"));
//
//            stage.setScene(scene);
//
//            vbox.getChildren().add(row);
//
//            vbox.applyCss();
//            vbox.layout();

//            System.out.println("Vbox height: " + vbox.getHeight());

//            Platform.runLater(() -> System.out.println("Vbox height later: " + row.getHeight()));

//            stage.show();

            container.getChildren().clear();

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

                FXMLLoader fxmlLoader = new FXMLLoader(FXMLHelper.load(controller.getFxmlFileName()));
                fxmlLoader.setController(controller);
                VBox row = fxmlLoader.<VBox>load();

                pageToUse.addRow(row, null, 0);

                pageToUse.applyCss();
                pageToUse.layout();

                System.out.println(pageToUse.getHeight());

                if(!pageToUse.hasSpace()){
                    pageToUse = pageToUse.addPageNext();
                    container.getChildren().add(pageToUse);
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
