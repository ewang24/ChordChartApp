package com.oneandahalfasians.chordchartapp.controller.chart.chartEntity;

import com.oneandahalfasians.chordchartapp.data.entities.Instrumental;
import com.oneandahalfasians.chordchartapp.data.entities.line.*;
import com.oneandahalfasians.chordchartapp.view.CSS;
import com.oneandahalfasians.chordchartapp.view.FXMLHelper;
import com.oneandahalfasians.chordchartapp.view.TextUtils;
import javafx.collections.ObservableList;
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.geometry.Pos;
import javafx.scene.Node;
import javafx.scene.control.TextField;
import javafx.scene.input.InputEvent;
import javafx.scene.input.KeyCode;
import javafx.scene.input.KeyEvent;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.scene.text.Font;
import javafx.scene.text.FontWeight;
import javafx.scene.text.Text;

import java.net.URL;
import java.util.List;
import java.util.ResourceBundle;

public class InstrumentalController implements Initializable {

    private final Instrumental instrumental;

    @FXML
    public Text header;

    @FXML
    public VBox instrumentalBox;

    public InstrumentalController(Instrumental instrumental) {
        this.instrumental = instrumental;
    }

    public Instrumental getInstrumental() {
        return instrumental;
    }

    @Override
    public void initialize(URL location, ResourceBundle resources) {
        header.setText(instrumental.getHeaderName());
        header.setFont(Font.font("arial", FontWeight.BOLD, 20));
        instrumentalBox.setStyle(String.format("-fx-padding: 0 %s 0 %s", CSS.VERSE_CONTROLLER__VERSE_BOX__PADDING, CSS.VERSE_CONTROLLER__VERSE_BOX__PADDING));


        String styles = "-fx-border-color: blue;\n" +
                "    -fx-border-insets: 5;\n" +
                "    -fx-border-width: 2;\n" +
                "    -fx-border-style: dashed;";


        for (LyricLine lyricLine : instrumental.getLines()) {

            HBox lyricRow = new HBox();
//            lyricRow.setStyle(styles);
            if(lyricLine.getLyricList() != null) {
                List<Lyric> lyricList = lyricLine.getLyricList();
                for (int i = 0; i < lyricList.size(); i++) {
                    Lyric lyric = lyricList.get(i);


                    lyricRow.getChildren().add(generateLyricColumn(lyric, lyricRow, i));
                }
            }
            instrumentalBox.getChildren().add(lyricRow);
        }

    }

    private VBox generateLyricColumn(Lyric lyric, HBox lyricRow, int index){
        return generateLyricColumn(lyric, lyricRow, index, false);
    }

    private VBox generateLyricColumn(Lyric lyric, HBox lyricRow, int index, boolean requestFocus){

        VBox lyricColumn = new VBox();
        if (lyric.getAnchorPoint() != null) {
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
            chordText.setAlignment(Pos.CENTER);

            setTextFieldWidthListener(chordText);

            lyricColumn.getChildren().add(chordText);
        }

        String styles2 = "-fx-border-color: pink;\n" +
                "    -fx-border-insets: 5;\n" +
                "    -fx-border-width: 1;\n" +
                "    -fx-border-style: dashed;";

        lyricColumn.setAlignment(Pos.TOP_CENTER);
//        lyricColumn.setStyle(styles2);

//        if(requestFocus){
//            lyricText.requestFocus();
//        }

        return lyricColumn;
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

}
