package com.oneandahalfasians.chordchartapp.view;

import com.oneandahalfasians.chordchartapp.ChordChartApplication;

import java.net.URL;
import java.util.Objects;

public class FXMLHelper {

    /**
     * Load an FXML file.
     * The base path will be relative to target/classes/com/oneandahalfasians/chordchartapp/
     * You do not need to include / in your path.
     */
    public static URL load(String view){
        return ChordChartApplication.class.getResource(view);
    }

    public static String loadCSS(String css){
        return Objects.requireNonNull(ChordChartApplication.class.getResource(css)).toExternalForm();
    }
}
