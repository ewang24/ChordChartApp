package com.oneandahalfasians.chordchartapp.data.entities.line;

import java.util.ArrayList;
import java.util.List;

public class LyricLine {
    private List<Lyric> lyricList = new ArrayList<>();

    public LyricLine() {
    }

    public List<Lyric> getLyricList() {
        return lyricList;
    }

    public void setLyricList(List<Lyric> lyricList) {
        this.lyricList = lyricList;
    }
}
