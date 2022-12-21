package com.oneandahalfasians.chordchartapp.data.entities;

import com.oneandahalfasians.chordchartapp.controller.chart.chartEntity.InstrumentalController;
import com.oneandahalfasians.chordchartapp.controller.chart.chartEntity.VerseController;
import com.oneandahalfasians.chordchartapp.data.entities.ChartEntity;
import com.oneandahalfasians.chordchartapp.data.entities.line.ChordLine;
import com.oneandahalfasians.chordchartapp.data.entities.line.Lyric;
import com.oneandahalfasians.chordchartapp.data.entities.line.LyricLine;
import com.oneandahalfasians.chordchartapp.view.FXMLHelper;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class Verse extends ChartEntity {

    protected List<ChordLyricWrapper> lines = new ArrayList<>();

    public List<ChordLyricWrapper> getLines() {
        return lines;
    }

    public Verse setLines(List<ChordLyricWrapper> lines) {
        this.lines = lines;
        return this;
    }

    public void addLine(LyricLine lyricLine){
        getLines().add(new ChordLyricWrapper(lyricLine));
    }

    @Override
    public Node render() {
        try {

            FXMLLoader loader = new FXMLLoader(FXMLHelper.load("chart/chartEntity/verse.fxml"));
            loader.setControllerFactory(a -> new VerseController(this));
            return loader.<Parent>load();

        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
}
