package com.oneandahalfasians.chordchartapp.data.entities.line;

import com.oneandahalfasians.chordchartapp.data.entities.line.Lyric;

public class Blank extends Lyric {

    public Blank(LyricLine lyricLine) {
        super(null, lyricLine);
    }

    @Override
    public String getLyric() {
        return "";
    }
}
