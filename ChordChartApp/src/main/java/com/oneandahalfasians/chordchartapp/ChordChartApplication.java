package com.oneandahalfasians.chordchartapp;

import com.oneandahalfasians.chordchartapp.controller.MainController;
import com.oneandahalfasians.chordchartapp.data.ChartService;
import com.oneandahalfasians.chordchartapp.view.FXMLHelper;
import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.stage.Stage;
import javafx.stage.StageStyle;

import java.io.IOException;

public class ChordChartApplication extends Application {
    @Override
    public void start(Stage stage) throws IOException {
        ChartService chartService = ChartService.getInstance();
        chartService.generateChart_TEST();

        FXMLLoader fxmlLoader = new FXMLLoader(ChordChartApplication.class.getResource("main.fxml"));

        Scene scene = new Scene(fxmlLoader.load());
        scene.getStylesheets().add(FXMLHelper.loadCSS("css/app.css"));
        stage.setTitle("Chord Chart App");
        stage.setScene(scene);
        stage.setMaximized(false);
        stage.show();
    }

    public static void main(String[] args) {
        launch();
    }
}