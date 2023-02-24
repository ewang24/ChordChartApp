package com.oneandahalfasians.chordchartapp.data.entities;

import com.oneandahalfasians.chordchartapp.controller.chart.chartEntity.EntityController;
import com.oneandahalfasians.chordchartapp.controller.chart.chartEntity.VerseController;
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

public class Verse extends ChartEntity implements Cloneable{

    public static final String MAIN_CONTAINER_ID = "verseBox";

    protected List<LyricLine<Lyric>> lines = new ArrayList<>();

    public List<LyricLine<Lyric>> getLines() {
        return lines;
    }

    public void setLines(List<LyricLine<Lyric>> lines) {
        this.lines = lines;
    }

    public void addLine(LyricLine<Lyric> lyricLine){
        getLines().add(lyricLine);
    }

    @Override
    public Class<? extends EntityController> getViewClass() {
        return VerseController.class;
    }

    @Override
    public Verse clone() {
        try {
            Verse clone = (Verse) super.clone();
            // TODO: copy mutable state here, so the clone can't change the internals of the original
            return clone;
        } catch (CloneNotSupportedException e) {
            throw new AssertionError();
        }
    }

//    @Override
//    public Node render(ChartEntityOptionsModel options) {
//        try {
//
//            if(options.isShouldAddNewEmptyElement()){
//                addEmptyChild();
//            }
//
//            FXMLLoader loader = new FXMLLoader(FXMLHelper.load("chart/chartEntity/verse.fxml"));
//            loader.setControllerFactory(a -> new VerseController(this));
//            return loader.<Parent>load();
//
//        } catch (IOException e) {
//            throw new RuntimeException(e);
//        }
//    }
//
//    @Override
//    public void addEmptyChild() {
//        LyricLine<Lyric> lyricLine = new LyricLine<>();
//        lyricLine.getLyricList().add(new Lyric(lyricLine));
//        lines.add(lyricLine);
//    }
//
//    @Override
//    public String getMainContainerId() {
//        return MAIN_CONTAINER_ID;
//    }
}
