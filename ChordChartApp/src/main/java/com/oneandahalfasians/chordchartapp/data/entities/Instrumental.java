package com.oneandahalfasians.chordchartapp.data.entities;

import com.oneandahalfasians.chordchartapp.controller.chart.chartEntity.EntityController;
import com.oneandahalfasians.chordchartapp.controller.chart.chartEntity.InstrumentalController;
import com.oneandahalfasians.chordchartapp.data.entities.line.AnchorPoint;
import com.oneandahalfasians.chordchartapp.data.entities.line.InstrumentalLyric;
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
import java.util.stream.Collectors;

public class Instrumental extends ChartEntity {

    public static final String MAIN_CONTAINER_ID = "instrumentalBox";

    List<LyricLine<Lyric>> chordLines = new ArrayList<>();

    public List<LyricLine<Lyric>> getChordLines() {
        return chordLines;
    }

    public void setChordLines(List<LyricLine<Lyric>> chordLines) {
        this.chordLines = chordLines;
    }

    public void addLine(LyricLine<Lyric> lyricLine){
        LyricLine<Lyric> instrumentalLine = new LyricLine<Lyric>();
        List<Lyric> chords = lyricLine.getLyricList().stream().map(l -> {
            InstrumentalLyric lyric = new InstrumentalLyric(instrumentalLine);
            lyric.setAnchorPoint(l.getAnchorPoint());
            return lyric;
        }).collect(Collectors.toList());

        instrumentalLine.setLyricList(chords);
        getChordLines().add(instrumentalLine);
    }

    @Override
    public Class<? extends EntityController> getViewClass() {
        return InstrumentalController.class;
    }

    @Override
    public EntityController getEntityController(ChartEntity chartEntity, ChartEntityOptionsModel options) {
        return new InstrumentalController(chartEntity, options);
    }

//    @Override
//    public Node render(ChartEntityOptionsModel options) {
//        try {
//
//            FXMLLoader loader = new FXMLLoader(FXMLHelper.load("chart/chartEntity/instrumental.fxml"));
//            loader.setControllerFactory(a -> new InstrumentalController(this));
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
