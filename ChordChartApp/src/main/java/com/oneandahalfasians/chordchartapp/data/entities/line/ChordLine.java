package com.oneandahalfasians.chordchartapp.data.entities.line;

import java.util.ArrayList;
import java.util.List;

public class ChordLine {
    private List<Chord> chords = new ArrayList<Chord>();
    private List<AnchorPoint> anchorPoints = new ArrayList<AnchorPoint>();

    public List<Chord> getChords() {
        return chords;
    }

    public void setChords(List<Chord> chords) {
        this.chords = chords;
    }

    public List<AnchorPoint> getAnchorPoints() {
        return anchorPoints;
    }

    public void setAnchorPoints(List<AnchorPoint> anchorPoints) {
        this.anchorPoints = anchorPoints;
    }
}
