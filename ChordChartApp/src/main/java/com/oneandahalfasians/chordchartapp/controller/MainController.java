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
import javafx.scene.layout.VBox;
import javafx.scene.text.Text;

import java.net.URL;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.ResourceBundle;

public class MainController implements Initializable {

    @FXML
    public Button styledButton;

    @FXML
    public Text styledText;

    @FXML
    public Text fancytext;

    @FXML
    public VBox appCenterVBox;

    @FXML
    private Parent chartView;

    @FXML
    private ChartController chartViewController;

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        appCenterVBox.setId("app-center-vbox");
//        styledButton.setStyle("-fx-background-color: slateblue; -fx-text-fill: white;");
//        styledText.setStyle("-fx-background-color: slateblue; -fx-text-fill: white;");
        fancytext.setId("fancytext");

        Chart chart = new Chart();
        chart.setTitle("Evan's First Song");
        chart.getKeyList().add(new Key(KeyLetter.E, Accidental.SHARP));
        chart.setNumberOfBeats(6);
        chart.setUnitBeat(8);
        chart.setTempo(42069);
        chart.setIntro(new Intro());
        chart.setEnding(new Ending());

        //Make a few lines of lyrics:
        ChordLine chordLine = new ChordLine();
        chordLine.getChords().addAll(Arrays.asList(new Chord(new Key(KeyLetter.E, Accidental.SHARP), Quality.MAJOR),
                                                    new Chord(new Key(KeyLetter.B, Accidental.SHARP), Quality.DOMINANT),
                                                    new Chord(new Key(KeyLetter.A, Accidental.SHARP), Quality.MAJOR, new Extension(Accidental.SHARP, 11))));

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
        verse.setHeaderName("Verse 1");
        //Add in every of the lyrics to the verse
        verse.addLine(chordLine, lyricLine);
        verse.addLine(chordLine, lyric2Line);
        verse.addLine(chordLine, lyric3Line);

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
