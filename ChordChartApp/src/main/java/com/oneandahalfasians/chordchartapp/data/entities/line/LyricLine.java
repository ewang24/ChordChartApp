package com.oneandahalfasians.chordchartapp.data.entities.line;

import java.util.ArrayList;
import java.util.List;

public class LyricLine {
    private List<Lyric> lyricLine = new ArrayList<>();

    public LyricLine() {
    }

    public List<Lyric> getLyricLine() {
        return lyricLine;
    }

    public void setLyricLine(List<Lyric> lyricLine) {
        this.lyricLine = lyricLine;
    }
}
