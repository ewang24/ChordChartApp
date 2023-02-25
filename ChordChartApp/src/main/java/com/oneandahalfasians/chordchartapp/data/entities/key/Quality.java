package com.oneandahalfasians.chordchartapp.data.entities.key;

public enum Quality {
    MAJOR_7TH("△", true),
    MINOR("m", true),
    MINOR_7TH("-", true),
    DOMINANT("7", true),
    SUSPENDED("sus", true),
    HALF_DIMINISHED("ø", true),
    DIMINISHED("°", true),
    AUGMENTED("+", true),
    ALTERED("alt", true),
    MIN_MAJOR_7TH(MINOR_7TH.getSymbol() + MAJOR_7TH.getSymbol(true), true),
    SLASH ("" + '\uE87B', false);

    private final String symbol;
    private final boolean superscriptAllowed;
    private boolean forceSuperscript;

    Quality(String symbol, boolean superscriptAllowed) {
        this.symbol = symbol;
        this.superscriptAllowed = superscriptAllowed;
    }

    public String getSymbol(boolean forceSuperscript) {
        this.forceSuperscript = forceSuperscript;
        return symbol;
    }

    public String getSymbol() {
        return symbol;
    }

    public boolean isSuperscriptAllowed() {
        return superscriptAllowed;
    }

    public boolean isForceSuperscript() {
        return forceSuperscript;
    }
}
