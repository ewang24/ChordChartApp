package com.oneandahalfasians.chordchartapp.controller.chart.chartEntity;

import com.oneandahalfasians.chordchartapp.data.ChartService;
import com.oneandahalfasians.chordchartapp.data.entities.Verse;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.layout.VBox;
import javafx.scene.text.Text;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.net.URL;
import java.util.ResourceBundle;

@Component
public class VerseController implements Initializable {

    /*
        Autowired
     */

    @Autowired
    ChartService chartService;

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

    public VerseController(Verse verse) {
        this.verse = verse;
    }

    public Verse getVerse() {
        return verse;
    }

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        chartService.test();
        SectionRendererHelper.initializeSectionContents(verse, verse.getLines(), header, verseBox);
    }
}
