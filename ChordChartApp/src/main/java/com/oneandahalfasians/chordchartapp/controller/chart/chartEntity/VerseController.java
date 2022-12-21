package com.oneandahalfasians.chordchartapp.controller.chart.chartEntity;

import com.oneandahalfasians.chordchartapp.data.entities.Verse;
import com.oneandahalfasians.chordchartapp.data.entities.line.*;
import com.oneandahalfasians.chordchartapp.view.CSS;
import com.oneandahalfasians.chordchartapp.view.TextUtils;
import javafx.beans.value.ChangeListener;
import javafx.beans.value.ObservableValue;
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.geometry.Pos;
import javafx.scene.control.TextField;
import javafx.scene.input.KeyCode;
import javafx.scene.input.KeyEvent;
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
        verseBox.setStyle(String.format("-fx-padding: 0 %s 0 %s", CSS.VERSE_CONTROLLER__VERSE_BOX__PADDING, CSS.VERSE_CONTROLLER__VERSE_BOX__PADDING));


        String styles = "-fx-border-color: blue;\n" +
                "    -fx-border-insets: 5;\n" +
                "    -fx-border-width: 2;\n" +
                "    -fx-border-style: dashed;";

        String styles2 = "-fx-border-color: pink;\n" +
                "    -fx-border-insets: 5;\n" +
                "    -fx-border-width: 1;\n" +
                "    -fx-border-style: dashed;";
        for (LyricLine lyricLine : verse.getLines()) {
//            HBox chordBox = new HBox();
//            chordBox.setStyle(styles);
//            chordBox.setStyle("-fx-spacing: " + CSS.VERSE_CONTROLLER__VERSE_BOX__PADDING);
//            if (wrapper.getChordLine() != null) {
//                for (Chord chord : wrapper.getChordLine().getChords()) {
//
//
//
//                    chordBox.getChildren().add(chordText);
//                }
//            }

            HBox lyricBox = new HBox();
            lyricBox.setStyle(styles);
            if(lyricLine.getLyricList() != null) {
                for (Lyric lyric : lyricLine.getLyricList()) {
                    TextField lyricText = new TextField(lyric.getLyric());
                    setTextFieldWidthListener(lyricText);

                    String lyricClass = null;
                    if(lyric instanceof Blank){
                        lyricClass = CSS.BLANK_LYRIC_TEXT_CLASS;
                        lyricText.setPrefWidth(0);
                    }
                    else if(lyric instanceof Break){
                        lyricClass = CSS.BREAK_LYRIC_TEXT_CLASS;
                    }
                    else{
                        lyricClass = CSS.LYRIC_TEXT_CLASS;
                    }

                    lyricText.getStyleClass().add(lyricClass);

                    VBox lyricColumn = new VBox();
                    if(lyric.getAnchorPoint() != null){
                        Chord anchoredChord = lyric.getAnchorPoint().getChord();

                        TextField chordText = new TextField(anchoredChord.toString());
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

                        setTextFieldWidthListener(chordText);

                        lyricColumn.getChildren().add(chordText);
                    }

                    lyricColumn.getChildren().add(lyricText);
                    lyricColumn.setAlignment(Pos.BOTTOM_CENTER);
                    lyricColumn.setStyle(styles2);

                    setTextFieldKeyListeners(lyricText, true);

                    lyricBox.getChildren().add(lyricColumn);
                }
            }
//            verseBox.getChildren().add(chordBox);
            verseBox.getChildren().add(lyricBox);
        }
    }

    private void setTextFieldWidthListener(TextField textField){

        //Listener that will fire when the text field is updated.
        //Readjusts the text field size to fit the text better.
        textField.textProperty().addListener((ob, o, n) ->
            textField.setPrefWidth(TextUtils.computeTextWidth(textField.getFont(), textField.getText(), 0D) + CSS.VERSE_CONTROLLER__VERSE_BOX__PADDING * 2)
        );

        //Manually trigger the resize initially so that things line up correctly at first
        textField.setPrefWidth(TextUtils.computeTextWidth(textField.getFont(), textField.getText(), 0D) + CSS.VERSE_CONTROLLER__VERSE_BOX__PADDING * 2);
    }

    private void setTextFieldKeyListeners(TextField textField, boolean isLyric){
        if(isLyric){
            textField.setOnKeyPressed(new EventHandler<KeyEvent>() {
                @Override
                public void handle(KeyEvent event) {
                    event.consume();
                    System.out.println("");
                    KeyCode keyCode = event.getCode();
                    if(keyCode == KeyCode.SPACE){
                        System.out.println("Space pressed");
                    }
                }
            });
//            textField.textProperty().addListener((observable, oldValue, newValue) -> {
//                System.out.println(oldValue + " " + newValue);
//            });
        }
        else{
            textField.textProperty().addListener((observable, oldValue, newValue) -> {
                System.out.println(oldValue + " " + newValue);
            });
        }
    }

}
