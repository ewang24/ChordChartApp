package com.oneandahalfasians.chordchartapp.data.entities.line;

public class Lyric {
    private String lyric;
    private AnchorPoint anchorPoint;

    public Lyric() {
    }

    public Lyric(String lyric) {
        this.lyric = lyric;
    }

    public String getLyric() {
        return lyric;
    }

    public void setLyric(String lyric) {
        this.lyric = lyric;
    }

    public AnchorPoint getAnchorPoint() {
        return anchorPoint;
    }

    public void setAnchorPoint(AnchorPoint anchorPoint) {
        this.anchorPoint = anchorPoint;
    }
}
