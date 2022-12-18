package com.oneandahalfasians.chordchartapp.controller.chart.chartEntity;

import com.oneandahalfasians.chordchartapp.data.entities.Chorus;

public class ChorusController {

    private final Chorus chorus;

    public ChorusController(Chorus chorus) {
        this.chorus = chorus;
    }

    public Chorus getChorus() {
        return chorus;
    }
}
