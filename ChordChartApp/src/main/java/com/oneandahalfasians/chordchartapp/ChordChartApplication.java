package com.oneandahalfasians.chordchartapp;

import com.oneandahalfasians.chordchartapp.controller.MainController;
import com.oneandahalfasians.chordchartapp.view.FXMLHelper;
import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.stage.Stage;

import java.io.IOException;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.context.annotation.ComponentScan;

@SpringBootApplication
@ComponentScan("com.oneandahalfasians.chordchartapp")
public class ChordChartApplication extends Application {

    private ConfigurableApplicationContext springContext;
    public static void main(String[] args) {
        Application.launch(ChordChartApplication.class, args);
    }

    @Override
    public void init() throws Exception {
        springContext = SpringApplication.run(ChordChartApplication.class);
    }

    @Override
    public void start(Stage stage) throws IOException {
        FXMLLoader fxmlLoader = new FXMLLoader(ChordChartApplication.class.getResource("main.fxml"));
        fxmlLoader.setControllerFactory(springContext::getBean);

        Scene scene = new Scene(fxmlLoader.load());
        scene.getStylesheets().add(FXMLHelper.loadCSS("css/app.css"));
        stage.setTitle("Chord Chart App");
        stage.setScene(scene);
        stage.setMaximized(false);
        stage.show();
    }
}