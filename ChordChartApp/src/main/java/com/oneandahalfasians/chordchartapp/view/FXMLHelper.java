package com.oneandahalfasians.chordchartapp.view;

import com.oneandahalfasians.chordchartapp.ChordChartApplication;

import java.net.URL;

public class FXMLHelper {

    /**
     * Load an FXML file.
     * The base path will be relative to target/classes/com/oneandahalfasians/chordchartapp/
     * You do not need to include / in your path.
     */
    public static URL load(String view){
        return ChordChartApplication.class.getResource(view);
    }
}
