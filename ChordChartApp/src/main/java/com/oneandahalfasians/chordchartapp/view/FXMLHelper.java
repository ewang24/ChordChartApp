package com.oneandahalfasians.chordchartapp.view;

import com.oneandahalfasians.chordchartapp.ChordChartApplication;
import javafx.scene.Node;

import java.net.URL;
import java.util.HashMap;
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

    public static Node data(Node node, Object key, Object value) {
        if(node.getUserData() == null){
            node.setUserData(new HashMap<Object, Object>());
        }

        ((HashMap<Object, Object>)node.getUserData()).put(key, value);
        return node;
    }

    public static Object data(Node node, Object key){
        if(node.getUserData() == null){
            return null;
        }
        return ((HashMap<Object, Object>)node.getUserData()).get(key);
    }
}
