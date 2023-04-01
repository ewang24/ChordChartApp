package com.oneandahalfasians.chordchartapp.data.entities.line;

public class Lyric {

    public static final String LYRIC_INDEX = "lyricIndex";
    public static final String PARENT = "parent";

    private LyricLine lyricLine;
    private String lyric;
    private AnchorPoint anchorPoint;

    public Lyric(LyricLine lyricLine){
        this.lyricLine = lyricLine;
    }

    public Lyric(String lyric, LyricLine lyricLine) {
        this.lyric = lyric;
        this.lyricLine = lyricLine;
    }

    public String getLyric() {
        return lyric;
    }

    public void setLyric(String lyric) {
        this.lyric = lyric;
    }

    public boolean hasAnchorPoint() {
        return getAnchorPoint() != null;
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
