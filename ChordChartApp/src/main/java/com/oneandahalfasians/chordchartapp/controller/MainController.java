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

        //Make a few lines of lyrics:
        LyricLine lyricLine = new LyricLine();
        lyricLine.getLyricList().addAll(generateLyric("This is Evan's first song!!!!"));

        LyricLine lyric2Line = new LyricLine();
        lyric2Line.getLyricList().addAll(generateLyric("This song is super cool"));

        LyricLine lyric3Line = new LyricLine();
        lyric3Line.getLyricList().addAll(generateLyric("No really, it is please believe me!"));

        //Added a helper method to Verse.java called addLine() that you can pass a cord and a lyric too.
        //It will automatically create the ChordLyricWrapper for you and put it into the list.
        //ChordLyricWrapper wrapper = new ChordLyricWrapper(null,lyricLine);

        Verse verse = new Verse();
        //Add in all of the lyrics to the verse
        verse.addLine(null, lyricLine);
        verse.addLine(null, lyric2Line);
        verse.addLine(null, lyric3Line);

        chart.getEntityList().add(verse);

        chartViewController.setChart(chart);
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
