package com.oneandahalfasians.chordchartapp.view;

public enum PageSize {

    LETTER(8.5, 11),
    ;

    private final double width;
    private final double height;

    PageSize(double width, double height) {
        this.width = width;
        this.height = height;
    }

    public double calculateRatio(double width){
        return width * (height/this.width);
    }
}
