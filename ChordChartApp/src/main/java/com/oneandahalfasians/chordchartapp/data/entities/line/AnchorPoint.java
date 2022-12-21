package com.oneandahalfasians.chordchartapp.data.entities.line;

public class AnchorPoint {

    private Lyric lyric;
    private Chord chord;

    public AnchorPoint(Lyric lyric, Chord chord) {
        this.lyric = lyric;
        this.chord = chord;
    }

    public Lyric getLyric() {
        return lyric;
    }

    public void setLyric(Lyric lyric) {
        this.lyric = lyric;
    }

    public Chord getChord() {
        return chord;
    }

    public void setChord(Chord chord) {
        this.chord = chord;
    }
}
