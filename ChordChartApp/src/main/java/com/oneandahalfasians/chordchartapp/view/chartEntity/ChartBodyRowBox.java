package com.oneandahalfasians.chordchartapp.view.chartEntity;

import com.oneandahalfasians.chordchartapp.data.entities.line.Lyric;
import com.oneandahalfasians.chordchartapp.view.FXMLHelper;
import javafx.collections.ObservableList;
import javafx.scene.Node;
import javafx.scene.layout.HBox;

public class ChartBodyRowBox extends HBox {

    public void addColumn(ChartBodyRowColumnBox child){
        super.getChildren().add(child);
    }

    public void addColumn(int index, ChartBodyRowColumnBox child){
        super.getChildren().add(index, child);
    }

    public ChartBodyRowColumnBox getFirstColumn(){
        return getColumn(0);
    }

    public ChartBodyRowColumnBox getColumn(int index){

        for (int i = 0; i < super.getChildren().size(); i++) {
            FXMLHelper.data(super.getChildren().get(i), Lyric.LYRIC_INDEX, i);
        }
        return (ChartBodyRowColumnBox) super.getChildren().get(index);
    }

}
