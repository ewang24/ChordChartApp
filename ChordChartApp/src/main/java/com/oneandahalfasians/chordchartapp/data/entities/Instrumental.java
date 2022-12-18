package com.oneandahalfasians.chordchartapp.data.entities;

import com.oneandahalfasians.chordchartapp.controller.chart.chartEntity.InstrumentalController;
import com.oneandahalfasians.chordchartapp.data.entities.line.ChordLine;
import com.oneandahalfasians.chordchartapp.view.FXMLHelper;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;

import java.io.IOException;
import java.util.List;

public class Instrumental extends ChartEntity {

    List<ChordLine> chordLines;

    public List<ChordLine> getChordLines() {
        return chordLines;
    }

    public Instrumental setChordLines(List<ChordLine> chordLines) {
        this.chordLines = chordLines;
        return this;
    }

    @Override
    public Node render() {
        try {

            FXMLLoader loader = new FXMLLoader(FXMLHelper.load("chart/chartEntity/instrumental.fxml"));
            loader.setControllerFactory(a -> new InstrumentalController(this));
            return loader.<Parent>load();

        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
}
