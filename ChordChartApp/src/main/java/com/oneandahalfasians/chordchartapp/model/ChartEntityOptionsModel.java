package com.oneandahalfasians.chordchartapp.model;

public class ChartEntityOptionsModel {

    private final boolean shouldFocus;
    private final boolean shouldAddNewEmptyElement;

    public ChartEntityOptionsModel(boolean shouldFocus, boolean shouldAddNewEmptyElement) {
        this.shouldFocus = shouldFocus;
        this.shouldAddNewEmptyElement = shouldAddNewEmptyElement;
    }

    public boolean isShouldFocus() {
        return shouldFocus;
    }

    public boolean isShouldAddNewEmptyElement() {
        return shouldAddNewEmptyElement;
    }
}
