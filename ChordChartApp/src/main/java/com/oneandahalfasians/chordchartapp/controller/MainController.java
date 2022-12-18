package com.oneandahalfasians.chordchartapp.controller;

import com.oneandahalfasians.chordchartapp.controller.chart.ChartController;
import com.oneandahalfasians.chordchartapp.data.Chart;
import com.oneandahalfasians.chordchartapp.data.entities.*;
import com.oneandahalfasians.chordchartapp.data.entities.key.Accidental;
import com.oneandahalfasians.chordchartapp.data.entities.key.Key;
import com.oneandahalfasians.chordchartapp.data.entities.key.KeyLetter;
import com.oneandahalfasians.chordchartapp.data.entities.line.Blank;
import com.oneandahalfasians.chordchartapp.data.entities.line.Lyric;
import com.oneandahalfasians.chordchartapp.data.entities.line.LyricLine;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.text.Text;

import java.net.URL;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.ResourceBundle;

public class MainController implements Initializable {

    @FXML
    private Parent chartView;

    @FXML
    private ChartController chartViewController;

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        Chart chart = new Chart();
        chart.setTitle("Evan's First Song");
        chart.getKeyList().add(new Key(KeyLetter.E, Accidental.SHARP));
        chart.setNumberOfBeats(6);
        chart.setUnitBeat(8);
        chart.setTempo(42069);
        chart.setIntro(new Intro());
        chart.setEnding(new Ending());
        LyricLine lyricLine = new LyricLine();
        lyricLine.getLyricLine().addAll(generateLyric("This is Evan's first song!!!!"));
        Verse verse = new Verse();
        ChordLyricWrapper wrapper = new ChordLyricWrapper(null,lyricLine);
    }

    private List<Lyric> generateLyric(String string){
        List<Lyric> lyricList = new ArrayList<>();
        Arrays.stream(string.split(" ")).forEach(l ->
                {
                    lyricList.add(new Lyric(l));
                    lyricList.add(new Blank());
                }
            );
        return lyricList;
    }
}
