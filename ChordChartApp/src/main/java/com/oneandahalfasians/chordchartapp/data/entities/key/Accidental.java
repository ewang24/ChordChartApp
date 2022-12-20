package com.oneandahalfasians.chordchartapp.data.entities.key;

public enum Accidental {
    FLAT("b"),
    SHARP("#");

    final String symbol;

    Accidental(String symbol) {
        this.symbol = symbol;
    }

    public String getSymbol(){
        return symbol;
    }
}
