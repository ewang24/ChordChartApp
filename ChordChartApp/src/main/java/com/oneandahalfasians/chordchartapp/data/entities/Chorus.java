package com.oneandahalfasians.chordchartapp.data.entities;

import com.oneandahalfasians.chordchartapp.controller.chart.chartEntity.ChorusController;
import com.oneandahalfasians.chordchartapp.controller.chart.chartEntity.EntityController;
import com.oneandahalfasians.chordchartapp.controller.chart.chartEntity.InstrumentalController;
import com.oneandahalfasians.chordchartapp.data.entities.ChartEntity;
import com.oneandahalfasians.chordchartapp.data.entities.line.Lyric;
import com.oneandahalfasians.chordchartapp.data.entities.line.LyricLine;
import com.oneandahalfasians.chordchartapp.model.ChartEntityOptionsModel;
import com.oneandahalfasians.chordchartapp.view.FXMLHelper;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class Chorus extends ChartEntity {

    public static final String MAIN_CONTAINER_ID = "chorusBox";

    List<LyricLine<Lyric>> chordLines = new ArrayList<LyricLine<Lyric>>();

    public List<LyricLine<Lyric>> getChordLines() {
        return chordLines;
    }

    public void setChordLines(List<LyricLine<Lyric>> chordLines) {
        this.chordLines = chordLines;
    }

    public void addLine(LyricLine lyricLine){
        getChordLines().add(lyricLine);
    }

    @Override
    public Class<? extends EntityController> getViewClass() {
        return ChorusController.class;
    }

    @Override
    public EntityController getEntityController(ChartEntity chartEntity, ChartEntityOptionsModel options) {
        return new ChorusController(chartEntity, options);
    }

    //    @Override
//    public Node render(ChartEntit) {
//        try {
//
//            FXMLLoader loader = new FXMLLoader(FXMLHelper.load("chart/chartEntity/chorus.fxml"));
//            loader.setControllerFactory(a -> new ChorusController(this));
//            return loader.<Parent>load();
//
//        } catch (IOException e) {
//            throw new RuntimeException(e);
//        }
//    }
//
//    @Override
//    public void addEmptyChild() {
//
//    }
//
//    @Override
//    public String getMainContainerId() {
//        return MAIN_CONTAINER_ID;
//    }
}
