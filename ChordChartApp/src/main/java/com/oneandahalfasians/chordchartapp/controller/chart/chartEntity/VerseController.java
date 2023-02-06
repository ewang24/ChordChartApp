package com.oneandahalfasians.chordchartapp.controller.chart.chartEntity;

import com.oneandahalfasians.chordchartapp.data.entities.ChartEntity;
import com.oneandahalfasians.chordchartapp.data.entities.Verse;
import com.oneandahalfasians.chordchartapp.data.entities.line.Lyric;
import com.oneandahalfasians.chordchartapp.data.entities.line.LyricLine;
import com.oneandahalfasians.chordchartapp.model.ChartEntityOptionsModel;
import com.oneandahalfasians.chordchartapp.view.chartEntity.ChartBodyBox;
import javafx.beans.value.ChangeListener;
import javafx.beans.value.ObservableValue;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.Scene;
import javafx.scene.control.TextField;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.scene.text.Text;

import java.net.URL;
import java.util.ResourceBundle;

public class VerseController extends EntityController implements Initializable {

    /*
        FXML Fields
     */
    @FXML
    public ChartBodyBox verseBox;

    @FXML
    private Text header;

    /*
        Instance Fields
     */

    private final Verse verse;
    private final ChartEntityOptionsModel options;

    public VerseController(ChartEntity verse, ChartEntityOptionsModel options) {
        if (!(verse instanceof Verse)) {
            throw new RuntimeException("Error!");
        }

        this.options = options;
        this.verse = (Verse) verse;

        if(options.isShouldAddNewEmptyElement()){
            LyricLine<Lyric> lyricLine = new LyricLine<>();
            lyricLine.getLyricList().add(new Lyric(lyricLine));
            this.verse.getLines().add(lyricLine);
        }
    }

    public Verse getVerse() {
        return verse;
    }

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        SectionRendererHelper.initializeSectionContents(verse, verse.getLines(), header, verseBox);

        if(options.isShouldFocus()){
            var firstRow = verseBox.getFirstRow();

            var lyricColumn = firstRow.getChildren().get(0);

            if(!(lyricColumn instanceof VBox)){
                return;
            }

            //super messy ugh this makes me want to commit sudoku. TODO: need to figure out a way to not want to die when looking at this.
            var textToFocus = ((TextField) ((VBox) lyricColumn).getChildren().get(((VBox) lyricColumn).getChildren().size() - 1));

            //TODO: reevaluate this and see if there is an easier way.
            textToFocus.sceneProperty().addListener(new ChangeListener<>() {
                @Override
                public void changed(ObservableValue<? extends Scene> observable, Scene oldValue, Scene newValue) {
                    if (newValue != null) {
                        textToFocus.requestFocus();
                        textToFocus.sceneProperty().removeListener(this);
                    }
                }
            });
        }
    }

    @Override
    public String getFxmlFileName() {
        return "chart/chartEntity/verse.fxml";
    }
}
