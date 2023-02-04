package com.oneandahalfasians.chordchartapp.controller.chart.chartEntity;

import com.oneandahalfasians.chordchartapp.data.entities.ChartEntity;
import com.oneandahalfasians.chordchartapp.data.entities.Verse;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.layout.VBox;
import javafx.scene.text.Text;

import java.net.URL;
import java.util.ResourceBundle;

public class VerseController extends EntityController implements Initializable {

    /*
        FXML Fields
     */
    @FXML
    public VBox verseBox;

    @FXML
    private Text header;

    /*
        Instance Fields
     */

    private final Verse verse;

    public VerseController(ChartEntity verse) {
        if (!(verse instanceof Verse)) {
            throw new RuntimeException("Error!");
        }
        this.verse = (Verse) verse;
    }

    public Verse getVerse() {
        return verse;
    }

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        SectionRendererHelper.initializeSectionContents(verse, verse.getLines(), header, verseBox);
    }

    @Override
    public String getFxmlFileName() {
        return "chart/chartEntity/verse.fxml";
    }
}
