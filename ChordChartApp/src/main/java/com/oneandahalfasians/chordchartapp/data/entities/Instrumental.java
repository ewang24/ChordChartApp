package com.oneandahalfasians.chordchartapp.data.entities;

import com.oneandahalfasians.chordchartapp.data.entities.ChartEntity;

import java.util.List;

public class Instrumental extends ChartEntity {

    List<ChordLine> chordLines;

    public List<ChordLine> getChordLines() {
        return chordLines;
    }

    public Instrumental setChordLines(List<ChordLine> chordLines) {
        this.chordLines = chordLines;
        return this;
    }
}
