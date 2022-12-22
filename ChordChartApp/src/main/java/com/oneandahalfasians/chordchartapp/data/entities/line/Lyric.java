package com.oneandahalfasians.chordchartapp.data.entities.line;

public class Lyric {

    private LyricLine lyricLine;
    private String lyric;
    private AnchorPoint anchorPoint;

    public Lyric(String lyric, LyricLine lyricLine) {
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

    public LyricLine getLyricLine() {
        return lyricLine;
    }

    public void setLyricLine(LyricLine lyricLine) {
        this.lyricLine = lyricLine;
    }
}
