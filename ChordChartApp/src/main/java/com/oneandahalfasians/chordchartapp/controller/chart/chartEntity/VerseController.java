package com.oneandahalfasians.chordchartapp.controller.chart.chartEntity;

import com.oneandahalfasians.chordchartapp.data.entities.ChordLyricWrapper;
import com.oneandahalfasians.chordchartapp.data.entities.Verse;
import com.oneandahalfasians.chordchartapp.data.entities.line.Lyric;
import javafx.fxml.Initializable;
import javafx.scene.layout.HBox;
import javafx.scene.text.Text;

import java.net.URL;
import java.util.ResourceBundle;

public class VerseController implements Initializable {

    /*
        FXML Fields
     */
    public HBox lyricBox;

    public HBox chordBox;

    /*
        Instance Fields
     */

    private final Verse verse;

    public VerseController(Verse verse) {
        this.verse = verse;
    }

    public Verse getVerse() {
        return verse;
    }

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        for (ChordLyricWrapper wrapper : verse.getLines()) {
            //TODO: wrapper.getChordLine()
            if(wrapper.getLyricLine() != null){
                for (Lyric lyric : wrapper.getLyricLine().getLyricList()) {
                    lyricBox.getChildren().add(new Text(lyric.getLyric()));
                }
            }
        }
    }
}
