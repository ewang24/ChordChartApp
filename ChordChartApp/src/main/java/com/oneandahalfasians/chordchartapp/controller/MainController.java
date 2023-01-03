package com.oneandahalfasians.chordchartapp.controller;

import com.oneandahalfasians.chordchartapp.controller.chart.ChartController;
import com.oneandahalfasians.chordchartapp.data.Chart;
import com.oneandahalfasians.chordchartapp.data.entities.*;
import com.oneandahalfasians.chordchartapp.data.entities.key.*;
import com.oneandahalfasians.chordchartapp.data.entities.line.*;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.control.Button;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.VBox;
import javafx.scene.text.Text;

import java.net.URL;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.ResourceBundle;

public class MainController implements Initializable {

    @FXML
    public GridPane appCenterVBox;

    @FXML
    private Parent chartView;

    @FXML
    private ChartController chartViewController;

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        appCenterVBox.setId("app-center-vbox");


        Chart chart = new Chart();
        chart.setTitle("Evan's First Song");
        chart.getKeyList().add(new Key(KeyLetter.E, Accidental.SHARP));
        chart.setNumberOfBeats(6);
        chart.setUnitBeat(8);
        chart.setTempo(42069);
        chart.setIntro(new Intro());
        chart.setEnding(new Ending());

        //Make a few lines of lyrics:
        List<Chord> chordList = (Arrays.asList(new Chord(new Key(KeyLetter.E, Accidental.SHARP), Quality.MAJOR),
                                                    new Chord(new Key(KeyLetter.B, Accidental.SHARP), Quality.DOMINANT),
                                                    new Chord(new Key(KeyLetter.A, Accidental.SHARP), Quality.MAJOR, new Extension(Accidental.SHARP, 11))));

        LyricLine lyricLine = new LyricLine();
        lyricLine.getLyricList().addAll(generateLyric( "This is Evan's first song!!!!", chordList, lyricLine));

        LyricLine lyric2Line = new LyricLine();
        lyric2Line.getLyricList().addAll(generateLyric("This song is super cool", chordList, lyric2Line));

        LyricLine lyric3Line = new LyricLine();
        lyric3Line.getLyricList().addAll(generateLyric("No really, it is please believe me!", chordList, lyric3Line));

        //Added a helper method to Verse.java called addLine() that you can pass a cord and a lyric too.
        //It will automatically create the ChordLyricWrapper for you and put it into the list.
        //ChordLyricWrapper wrapper = new ChordLyricWrapper(null,lyricLine);

        Verse verse = new Verse();
        verse.setHeaderName("Verse 1");
        //Add in every of the lyrics to the verse
        verse.addLine(lyricLine);
        verse.addLine(lyric2Line);
        verse.addLine(lyric3Line);

        Chorus chorus = new Chorus();
        chorus.setHeaderName("Chorus 1");
        chorus.addLine(lyricLine);
        chorus.addLine(lyric2Line);
        chorus.addLine(lyric3Line);

        Bridge bridge = new Bridge();
        bridge.addLine(lyricLine);
        bridge.addLine(lyric2Line);
        bridge.addLine(lyric3Line);

        chart.getEntityList().add(verse);
        chart.getEntityList().add(chorus);
        chart.getEntityList().add(bridge);

        chartViewController.setChart(chart);
    }

    private List<Lyric> generateLyric(String string, List<Chord> chordLine, LyricLine lyricLine){
        List<Lyric> lyricList = new ArrayList<>();
        String[] split = string.split(" ");
        for (int i = 0; i < split.length; i++) {
            String l = split[i];

            Lyric lyric = new Lyric(l, lyricLine);

            Blank blank = new Blank(lyricLine);
            if(i < chordLine.size()){
                lyric.setAnchorPoint(new AnchorPoint(lyric, chordLine.get(i)));
                blank.setAnchorPoint(new AnchorPoint(lyric, chordLine.get(i)));
            }

            lyricList.add(lyric);
            lyricList.add(blank);
        }
        return lyricList;
    }
}
