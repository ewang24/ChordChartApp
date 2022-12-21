package com.oneandahalfasians.chordchartapp.data.entities.line;

import com.oneandahalfasians.chordchartapp.data.entities.line.Lyric;

public class Break extends Lyric {

    public Break(String lyric, LyricLine lyricLine) {
        super(lyric, lyricLine);
    }

    @Override
    public String getLyric(){
        return "-";
    }

}
