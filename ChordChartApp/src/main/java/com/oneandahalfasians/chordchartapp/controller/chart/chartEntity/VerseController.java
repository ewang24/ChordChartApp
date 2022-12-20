package com.oneandahalfasians.chordchartapp.controller.chart.chartEntity;

import com.oneandahalfasians.chordchartapp.data.entities.ChordLyricWrapper;
import com.oneandahalfasians.chordchartapp.data.entities.Verse;
import com.oneandahalfasians.chordchartapp.data.entities.line.Lyric;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.scene.text.Font;
import javafx.scene.text.FontWeight;
import javafx.scene.text.Text;

import java.net.URL;
import java.util.ResourceBundle;

public class VerseController implements Initializable {

    /*
        FXML Fields
     */
    @FXML
    public VBox lyricBox;

    @FXML
    public HBox chordBox;

    @FXML
    private Text header;

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
        header.setText(verse.getHeaderName());
        header.setFont(Font.font("arial", FontWeight.BOLD, 20));

        for (ChordLyricWrapper wrapper : verse.getLines()) {
            //TODO: wrapper.getChordLine()
            if(wrapper.getLyricLine() != null){
                HBox lineBox = new HBox();
                lyricBox.getChildren().add(lineBox);
                for (Lyric lyric : wrapper.getLyricLine().getLyricList()) {
                    Text lyricText = new Text(lyric.getLyric());
                    lyricText.getStyleClass().add("text-entry");
                    lyricText.setId("test");
                    lineBox.getChildren().add(lyricText);
                }
            }
        }
    }
}
