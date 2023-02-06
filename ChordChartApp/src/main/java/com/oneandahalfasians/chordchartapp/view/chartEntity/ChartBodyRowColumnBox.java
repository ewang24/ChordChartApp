package com.oneandahalfasians.chordchartapp.view.chartEntity;

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

        super.getChildren().add(0, chordText);

        if(lyricText != null){
            super.getChildren().add(1, lyricText);
        }
    }

    public TextField getChordText() {
        return chordText;
    }

    public TextField getLyricText() {
        return lyricText;
    }

    public void focusLast(){
        if(lyricText != null){
            lyricText.requestFocus();
        }
        else if(chordText != null){
            chordText.requestFocus();
        }
    }
}
