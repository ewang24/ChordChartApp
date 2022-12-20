package com.oneandahalfasians.chordchartapp.controller.chart.chartEntity;

import com.oneandahalfasians.chordchartapp.data.entities.ChordLyricWrapper;
import com.oneandahalfasians.chordchartapp.data.entities.Verse;
import com.oneandahalfasians.chordchartapp.data.entities.line.Chord;
import com.oneandahalfasians.chordchartapp.data.entities.line.Lyric;
import javafx.beans.value.ChangeListener;
import javafx.beans.value.ObservableValue;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.TextField;
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
    public VBox verseBox;

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
        verseBox.setStyle("-fx-padding: 0 10 0 10");

        for (ChordLyricWrapper wrapper : verse.getLines()) {
            HBox chordBox = new HBox();
            chordBox.setStyle("-fx-spacing: 10");
            if (wrapper.getChordLine() != null) {
                for (Chord chord : wrapper.getChordLine().getChords()) {
                    TextField chordText = new TextField(chord.toString());
//                    chordText.textProperty().addListener(new ChangeListener<String>() {
//                        @Override
//                        public void changed(ObservableValue<? extends String> ob, String o,
//                                            String n) {
//                            // expand the textfield
//                            chordText.setPrefWidth(TextUtils.computeTextWidth(field.getFont(),
//                                    field.getText(), 0.0D) + 10);
//                        }
//                    });
                    chordBox.getChildren().add(chordText);
                }
            }
            HBox lyricBox = new HBox();
            if(wrapper.getLyricLine() != null) {
                for (Lyric lyric : wrapper.getLyricLine().getLyricList()) {
                    TextField lyricText = new TextField(lyric.getLyric());
                    lyricBox.getChildren().add(lyricText);
                }
            }
            verseBox.getChildren().add(chordBox);
            verseBox.getChildren().add(lyricBox);
        }
    }
}
