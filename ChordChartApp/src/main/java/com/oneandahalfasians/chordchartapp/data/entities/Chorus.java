package com.oneandahalfasians.chordchartapp.data.entities;

import com.oneandahalfasians.chordchartapp.data.entities.ChartEntity;

import java.util.ArrayList;
import java.util.List;

public class Chorus extends ChartEntity {

    List<ChordLyricWrapper> lines = new ArrayList<>();

    public List<ChordLyricWrapper> getLines() {
        return lines;
    }

    public Chorus setLines(List<ChordLyricWrapper> lines) {
        this.lines = lines;
        return this;
    }
}
