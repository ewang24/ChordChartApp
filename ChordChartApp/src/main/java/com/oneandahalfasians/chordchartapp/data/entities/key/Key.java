package com.oneandahalfasians.chordchartapp.data.entities.key;

public class Key {

    private KeyLetter keyLetter;
    private Accidental accidental;

    public Key(KeyLetter keyLetter, Accidental accidental) {
        this.keyLetter = keyLetter;
        this.accidental = accidental;
    }
    public Key(KeyLetter keyLetter) {
        this.keyLetter = keyLetter;
    }

    public KeyLetter getKeyLetter() {
        return keyLetter;
    }

    public Key setKeyLetter(KeyLetter keyLetter) {
        this.keyLetter = keyLetter;
        return this;
    }

    public Accidental getAccidental() {
        return accidental;
    }

    public Key setAccidental(Accidental accidental) {
        this.accidental = accidental;
        return this;
    }
}
