package com.oneandahalfasians.chordchartapp.data.entities.line;

import com.oneandahalfasians.chordchartapp.data.entities.key.Accidental;
import com.oneandahalfasians.chordchartapp.data.entities.key.Extension;
import com.oneandahalfasians.chordchartapp.data.entities.key.Key;
import com.oneandahalfasians.chordchartapp.data.entities.key.Quality;

import java.util.List;

public class Chord {
    private Key key;
    private Accidental accidental;
    private Quality quality;
    private List<Extension> extensions;

    public Key getKey() {
        return key;
    }

    public void setKey(Key key) {
        this.key = key;
    }

    public Accidental getAccidental() {
        return accidental;
    }

    public void setAccidental(Accidental accidental) {
        this.accidental = accidental;
    }

    public Quality getQuality() {
        return quality;
    }

    public void setQuality(Quality quality) {
        this.quality = quality;
    }

    public List<Extension> getExtensions() {
        return extensions;
    }

    public void setExtensions(List<Extension> extensions) {
        this.extensions = extensions;
    }
}
