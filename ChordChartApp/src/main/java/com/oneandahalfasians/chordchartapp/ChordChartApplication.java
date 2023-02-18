package com.oneandahalfasians.chordchartapp;

import com.oneandahalfasians.chordchartapp.controller.MainController;
import com.oneandahalfasians.chordchartapp.data.ChartService;
import com.oneandahalfasians.chordchartapp.view.FXMLHelper;
import javafx.application.Application;
import javafx.application.Platform;
import javafx.fxml.FXMLLoader;
import javafx.geometry.Dimension2D;
import javafx.geometry.Rectangle2D;
import javafx.scene.Scene;
import javafx.stage.Screen;
import javafx.stage.Stage;
import javafx.stage.StageStyle;

import java.io.IOException;

public class ChordChartApplication extends Application {
    @Override
    public void start(Stage stage) throws IOException {

        Rectangle2D bounds = Screen.getPrimary().getVisualBounds();

        ChartService chartService = ChartService.getInstance();
        chartService.generateChart_TEST();

        MainController mainController = new MainController();

        FXMLLoader fxmlLoader = new FXMLLoader(ChordChartApplication.class.getResource("main.fxml"));
        fxmlLoader.setController(mainController);

        Scene scene = new Scene(fxmlLoader.load());

        chartService.setStage(stage);

        scene.getStylesheets().add(FXMLHelper.loadCSS("css/app.css"));
        stage.setTitle("Chord Chart App");
        stage.setMaximized(true);
        stage.setWidth(bounds.getMaxX());
        stage.setHeight(bounds.getMaxY());
        stage.setScene(scene);
        stage.show();

        Platform.runLater(mainController::loadChart);
    }

    public static void main(String[] args) {
        launch();
    }
}