package com.oneandahalfasians.chordchartapp.view.chartEntity;

import javafx.beans.value.ChangeListener;
import javafx.beans.value.ObservableValue;
import javafx.scene.Scene;
import javafx.scene.control.TextField;
import javafx.scene.layout.VBox;

public class ChartBodyRowColumnBox extends VBox {

    private TextField chordText;
    private TextField lyricText;

    public ChartBodyRowColumnBox() {
    }

    public ChartBodyRowColumnBox(TextField chordText, TextField lyricText) {
        setup(chordText, lyricText);
    }

    public void setup(TextField chordText, TextField lyricText){
        this.chordText = chordText;
        this.lyricText = lyricText;

        if(chordText != null){
            super.getChildren().add(chordText);
        }

        if(lyricText != null){
            super.getChildren().add(chordText == null? 0: 1, lyricText);
        }
    }

    public TextField getChordText() {
        return chordText;
    }

    public TextField getLyricText() {
        return lyricText;
    }

    public void focusLast(){
        TextField textToFocus = null;
        if(lyricText != null){
            textToFocus = lyricText;
        }
        else if(chordText != null){
            textToFocus = chordText;
        }
        else{
            return;
        }

        //TODO: reevaluate this and see if there is an easier way.
        final TextField finalTextToFocus = textToFocus;
        textToFocus.sceneProperty().addListener(new ChangeListener<>() {
            @Override
            public void changed(ObservableValue<? extends Scene> observable, Scene oldValue, Scene newValue) {
                if (newValue != null) {
                    finalTextToFocus.requestFocus();
                    finalTextToFocus.sceneProperty().removeListener(this);
                }
            }
        });
    }
}
