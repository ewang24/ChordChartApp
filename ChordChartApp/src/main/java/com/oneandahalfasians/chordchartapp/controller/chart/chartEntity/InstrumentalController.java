package com.oneandahalfasians.chordchartapp.controller.chart.chartEntity;

import com.oneandahalfasians.chordchartapp.data.entities.Instrumental;

public class InstrumentalController {

    private final Instrumental instrumental;

    public InstrumentalController(Instrumental instrumental) {
        this.instrumental = instrumental;
    }

    public Instrumental getInstrumental() {
        return instrumental;
    }
}
