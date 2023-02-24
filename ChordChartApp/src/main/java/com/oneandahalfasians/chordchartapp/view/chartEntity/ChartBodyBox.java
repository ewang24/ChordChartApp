package com.oneandahalfasians.chordchartapp.view.chartEntity;

import com.oneandahalfasians.chordchartapp.ChordChartApplication;
import com.oneandahalfasians.chordchartapp.data.ChartService;
import com.oneandahalfasians.chordchartapp.view.FXMLHelper;
import javafx.application.Platform;
import javafx.collections.ObservableList;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Scene;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

import java.io.IOException;

/**
 * Class that represents a renderable chart section (e.g. a verse, chorus, etc.)
 */
public class ChartBodyBox extends VBox {
//love for Annie
    public void addRow(ChartBodyRowBox row) {

        Stage stage = new Stage();

        VBox vbox = new VBox();
        Scene scene = new Scene(vbox);

        stage.setScene(scene);

        vbox.getChildren().add(row);

        vbox.applyCss();
        vbox.layout();

//        System.out.println(row.getBoundsInParent());
        stage.close();
        super.getChildren().add(row);


//        Platform.runLater(
//                () -> System.out.println("btn width: " + row.getBoundsInParent())
//        );

    }

    public void addRow(int index, ChartBodyRowBox row) {
        super.getChildren().add(index, row);
    }

    public ChartBodyRowBox getFirstRow() {
        return getRow(0);
    }

    public ChartBodyRowBox getRow(int index) {
        return (ChartBodyRowBox) super.getChildren().get(index
        );
    }


}
