package com.oneandahalfasians.chordchartapp.data.entities;

import com.oneandahalfasians.chordchartapp.data.entities.ChartEntity;

import java.util.ArrayList;
import java.util.List;

public class Verse extends ChartEntity {

    protected List<ChordLyricWrapper> lines = new ArrayList<>();

    public List<ChordLyricWrapper> getLines() {
        return lines;
    }

    public Verse setLines(List<ChordLyricWrapper> lines) {
        this.lines = lines;
        return this;
    }
}
