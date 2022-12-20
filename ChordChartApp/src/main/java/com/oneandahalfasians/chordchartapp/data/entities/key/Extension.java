package com.oneandahalfasians.chordchartapp.data.entities.key;

public class Extension {
    private Accidental accidental;
    private int extension;

    public Extension(int extension) {
        this.extension = extension;
    }

    public Extension(Accidental accidental, int extension) {
        this.accidental = accidental;
        this.extension = extension;
    }

    public Accidental getAccidental() {
        return accidental;
    }

    public void setAccidental(Accidental accidental) {
        this.accidental = accidental;
    }

    public int getExtension() {
        return extension;
    }

    public void setExtension(int extension) {
        this.extension = extension;
    }

    @Override
    public String toString() {
        String add = "" + accidental.getSymbol() + extension;
        return add;
    }
}
