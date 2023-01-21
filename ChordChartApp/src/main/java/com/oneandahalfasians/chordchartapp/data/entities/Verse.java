package com.oneandahalfasians.chordchartapp.data.entities;

import com.oneandahalfasians.chordchartapp.controller.chart.chartEntity.VerseController;
import com.oneandahalfasians.chordchartapp.data.entities.line.Lyric;
import com.oneandahalfasians.chordchartapp.data.entities.line.LyricLine;
import com.oneandahalfasians.chordchartapp.view.FXMLHelper;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import org.springframework.stereotype.Component;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

@Component
public class Verse extends ChartEntity {

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
