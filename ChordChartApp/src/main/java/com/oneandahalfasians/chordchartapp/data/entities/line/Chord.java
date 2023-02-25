package com.oneandahalfasians.chordchartapp.data.entities.line;

import com.oneandahalfasians.chordchartapp.data.entities.key.Accidental;
import com.oneandahalfasians.chordchartapp.data.entities.key.Extension;
import com.oneandahalfasians.chordchartapp.data.entities.key.Key;
import com.oneandahalfasians.chordchartapp.data.entities.key.Quality;

import java.util.ArrayList;
import java.util.List;

public class Chord {
    private Key key;
    private Quality quality;
    private boolean superscriptQuality;
    private List<Extension> extensions = new ArrayList<>();

    public Key getKey() {
        return key;
    }

    public Chord(Key key, Quality quality) {
        this.key = key;
        this.quality = quality;
    }

    public Chord(Key key, Quality quality, Extension extension) {
        this.key = key;
        this.quality = quality;
        this.extensions.add(extension);
    }


    public Chord(Key key, Quality quality, List<Extension> extensions) {
        this.key = key;
        this.quality = quality;
        this.extensions = extensions;
    }

    public void setKey(Key key) {
        this.key = key;
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

    @Override
    public String toString() {
        String chord = ""+ key + quality.getSymbol();
        if (!extensions.isEmpty()) {
            for (Extension e : extensions) {
                chord = chord + e.toString();
            }
        }
        return chord;
    }
}
