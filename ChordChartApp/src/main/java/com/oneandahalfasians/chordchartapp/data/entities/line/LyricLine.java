package com.oneandahalfasians.chordchartapp.data.entities.line;

import java.util.ArrayList;
import java.util.List;

public class LyricLine<LyricType> {
    private List<LyricType> lyricList = new ArrayList<>();

    public LyricLine() {
    }

    public List<LyricType> getLyricList() {
        return lyricList;
    }

    public void setLyricList(List<LyricType> lyricList) {
        this.lyricList = lyricList;
    }
}
