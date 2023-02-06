package com.oneandahalfasians.chordchartapp.view.chartEntity;

import javafx.collections.ObservableList;
import javafx.scene.Node;
import javafx.scene.layout.VBox;

public class ChartBodyBox extends VBox {

    public void addRow(ChartBodyRowBox row){
        super.getChildren().add(row);
    }

    public void addRow(int index, ChartBodyRowBox row){
        super.getChildren().add(index, row);
    }

    public ChartBodyRowBox getFirstRow(){
        return getRow(0);
    }

    public ChartBodyRowBox getRow(int index){
        return (ChartBodyRowBox) super.getChildren().get(index
    );

    }
}
