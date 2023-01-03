package com.oneandahalfasians.chordchartapp.data.entities;

import com.oneandahalfasians.chordchartapp.controller.chart.chartEntity.ChorusController;
import com.oneandahalfasians.chordchartapp.controller.chart.chartEntity.InstrumentalController;
import com.oneandahalfasians.chordchartapp.data.entities.ChartEntity;
import com.oneandahalfasians.chordchartapp.data.entities.line.LyricLine;
import com.oneandahalfasians.chordchartapp.view.FXMLHelper;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class Chorus extends ChartEntity {

    List<LyricLine> chordLines = new ArrayList<>();

    public List<LyricLine> getChordLines() {
        return chordLines;
    }

    public void setChordLines(List<LyricLine> chordLines) {
        this.chordLines = chordLines;
    }

    public void addLine(LyricLine lyricLine){
        getChordLines().add(lyricLine);
    }

    @Override
    public Node render() {
        try {

            FXMLLoader loader = new FXMLLoader(FXMLHelper.load("chart/chartEntity/chorus.fxml"));
            loader.setControllerFactory(a -> new ChorusController(this));
            return loader.<Parent>load();

        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
}
