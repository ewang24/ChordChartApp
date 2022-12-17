package com.oneandahalfasians.chordchartapp.data.entities;

public class ChordLyricWrapper {

    private final ChordLine chordLine;
    private final LyricLine lyricLine;


    public ChordLyricWrapper(ChordLine chordLine, LyricLine lyricLine) {
        this.chordLine = chordLine;
        this.lyricLine = lyricLine;
    }

    public ChordLine getChordLine() {
        return chordLine;
    }

    public LyricLine getLyricLine() {
        return lyricLine;
    }
}
