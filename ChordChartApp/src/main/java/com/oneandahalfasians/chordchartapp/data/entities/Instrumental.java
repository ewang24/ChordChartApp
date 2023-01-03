package com.oneandahalfasians.chordchartapp.data.entities;

import com.oneandahalfasians.chordchartapp.controller.chart.chartEntity.InstrumentalController;
import com.oneandahalfasians.chordchartapp.data.entities.line.LyricLine;
import com.oneandahalfasians.chordchartapp.view.FXMLHelper;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;

import java.io.IOException;
import java.util.List;

public class Instrumental extends Verse {

    List<LyricLine> chordLines;

    public List<LyricLine> getChordLines() {
        return chordLines;
    }

    public void setChordLines(List<LyricLine> chordLines) {
        this.chordLines = chordLines;
    }

    @Override
    public Node render() {
//        try {
//
//            FXMLLoader loader = new FXMLLoader(FXMLHelper.load("chart/chartEntity/instrumental.fxml"));
//            loader.setControllerFactory(a -> new InstrumentalController(this));
//            return loader.<Parent>load();
//
//        } catch (IOException e) {
//            throw new RuntimeException(e);
//        }
        return super.render();
    }
}
