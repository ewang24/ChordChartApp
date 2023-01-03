package com.oneandahalfasians.chordchartapp.controller.chart.chartEntity;

import com.oneandahalfasians.chordchartapp.data.entities.Instrumental;
import javafx.fxml.Initializable;

import java.net.URL;
import java.util.ResourceBundle;

public class InstrumentalController implements Initializable {

    private final Instrumental instrumental;

    public InstrumentalController(Instrumental instrumental) {
        this.instrumental = instrumental;
    }

    public Instrumental getInstrumental() {
        return instrumental;
    }

    @Override
    public void initialize(URL location, ResourceBundle resources) {

    }
}
