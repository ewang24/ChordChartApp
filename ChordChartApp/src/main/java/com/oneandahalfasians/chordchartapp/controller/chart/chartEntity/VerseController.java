package com.oneandahalfasians.chordchartapp.controller.chart.chartEntity;

import com.oneandahalfasians.chordchartapp.data.entities.ChordLyricWrapper;
import com.oneandahalfasians.chordchartapp.data.entities.Verse;
import com.oneandahalfasians.chordchartapp.data.entities.line.Blank;
import com.oneandahalfasians.chordchartapp.data.entities.line.Break;
import com.oneandahalfasians.chordchartapp.data.entities.line.Chord;
import com.oneandahalfasians.chordchartapp.data.entities.line.Lyric;
import com.oneandahalfasians.chordchartapp.view.CSS;
import com.oneandahalfasians.chordchartapp.view.TextUtils;
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
                    chordText.getStyleClass().add(CSS.CHORD_TEXT_CLASS);

                    processTextField(chordText);

                    chordBox.getChildren().add(chordText);
                }
            }
            HBox lyricBox = new HBox();
            if(wrapper.getLyricLine() != null) {
                for (Lyric lyric : wrapper.getLyricLine().getLyricList()) {
                    TextField lyricText = new TextField(lyric.getLyric());
                    processTextField(lyricText);

                    String lyricClass = null;
                    if(lyric instanceof Blank){
                        lyricClass = CSS.BLANK_LYRIC_TEXT_CLASS;
                    }
                    else if(lyric instanceof Break){
                        lyricClass = CSS.BREAK_LYRIC_TEXT_CLASS;
                    }
                    else{
                        lyricClass = CSS.LYRIC_TEXT_CLASS;
                    }

                    lyricText.getStyleClass().add(lyricClass);

                    lyricBox.getChildren().add(lyricText);
                }
            }
            verseBox.getChildren().add(chordBox);
            verseBox.getChildren().add(lyricBox);
        }
    }

    private void processTextField(TextField textField){

        //Listener that will fire when the text field is updated.
        //Readjusts the text field size to fit the text better.
        textField.textProperty().addListener((ob, o, n) ->
            textField.setPrefColumnCount(3)
//            textField.setPrefColumnCount(textField.getText().length() +1)
        );

        //Manually trigger the resize initially so that things line up correctly at first
//        textField.setPrefColumnCount(textField.getText().length() +1);
        textField.setPrefWidth(TextUtils.computeTextWidth(textField.getFont(), textField.getText(), 0D));

    }

}
