package com.oneandahalfasians.chordchartapp.data.entities.key;

import java.util.HashMap;

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

    @Override
    public String toString() {
        return keyLetter.toString() + accidental.getSymbol();
    }

    @Override
    public boolean equals(Object obj) {
        Key other = (Key) obj;
        return this.keyLetter.equals(other.keyLetter) && this.accidental.equals(other.accidental);
    }
}
