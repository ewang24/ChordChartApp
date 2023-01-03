package com.oneandahalfasians.chordchartapp.data.entities.line;

public class InstrumentalLyric extends Lyric {
    public InstrumentalLyric(LyricLine lyricLine) {
        super(lyricLine);
    }

    @Override
    public String getLyric() {
        throw new UnsupportedOperationException("getLyric() is not implemented for InstrumentalLyric");
    }

    @Override
    public void setLyric(String lyric) {
        throw new UnsupportedOperationException("getLyric() is not implemented for InstrumentalLyric");
    }
}
