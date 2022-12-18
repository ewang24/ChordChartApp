package com.oneandahalfasians.chordchartapp.controller;

import com.oneandahalfasians.chordchartapp.controller.chart.ChartController;
import com.oneandahalfasians.chordchartapp.data.Chart;
import com.oneandahalfasians.chordchartapp.data.entities.ChartEntity;
import com.oneandahalfasians.chordchartapp.data.entities.Ending;
import com.oneandahalfasians.chordchartapp.data.entities.Intro;
import com.oneandahalfasians.chordchartapp.data.entities.key.Accidental;
import com.oneandahalfasians.chordchartapp.data.entities.key.Key;
import com.oneandahalfasians.chordchartapp.data.entities.key.KeyLetter;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.text.Text;

import java.net.URL;
import java.util.Arrays;
import java.util.ResourceBundle;

public class MainController implements Initializable {

    @FXML
    private Parent chartView;

    @FXML
    private ChartController chartViewController;

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        Chart chart = new Chart();
        chart.setTitle("Evan's First Song");
        chart.getKeyList().add(new Key(KeyLetter.E, Accidental.SHARP));
        chart.setNumberOfBeats(6);
        chart.setUnitBeat(8);
        chart.setTempo(42069);
        chart.setIntro(new Intro());
        chart.setEnding(new Ending());

    }
}
