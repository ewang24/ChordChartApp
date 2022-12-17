package com.oneandahalfasians.chordchartapp.data.entities.key;

public enum Accidental {
    FLAT("b"),
    SHARP("#");

    final String value;

    Accidental(String value) {
        this.value = value;
    }
}
