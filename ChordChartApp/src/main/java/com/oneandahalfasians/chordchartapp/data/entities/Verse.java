package com.oneandahalfasians.chordchartapp.data.entities;

import com.oneandahalfasians.chordchartapp.data.entities.ChartEntity;
import com.oneandahalfasians.chordchartapp.data.entities.line.ChordLine;
import com.oneandahalfasians.chordchartapp.data.entities.line.Lyric;
import com.oneandahalfasians.chordchartapp.data.entities.line.LyricLine;

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

    public void addLine(ChordLine chordLine, LyricLine lyricLine){
        getLines().add(new ChordLyricWrapper(chordLine, lyricLine));
    }
}
