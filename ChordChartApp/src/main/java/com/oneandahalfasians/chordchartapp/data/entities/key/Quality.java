package com.oneandahalfasians.chordchartapp.data.entities.key;

public enum Quality {
    MAJOR("maj"),
    MINOR("-"),
    DOMINANT("7"),
    SUSPENDED("sus"),
    HALF_DIMINISHED("%"),
    DIMINISHED("o"),
    AUGMENTED("+"),
    MAJOR_MINOR("maj min"),
    ALTERED("alt");
    private final String symbol;

    Quality(String symbol) {
        this.symbol = symbol;
    }

    public String getSymbol() {
        return symbol;
    }
}
