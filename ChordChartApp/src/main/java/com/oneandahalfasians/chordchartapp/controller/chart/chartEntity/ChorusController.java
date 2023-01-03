package com.oneandahalfasians.chordchartapp.controller.chart.chartEntity;

import com.oneandahalfasians.chordchartapp.data.entities.Chorus;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.layout.VBox;
import javafx.scene.text.Text;

import java.net.URL;
import java.util.ResourceBundle;

public class ChorusController implements Initializable {

    @FXML
    public Text header;
    @FXML
    public VBox chorusBox;
    private final Chorus chorus;

    public ChorusController(Chorus chorus) {
        this.chorus = chorus;
    }

    public Chorus getChorus() {
        return chorus;
    }

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        SectionHelper.initializeSectionContents(chorus, chorus.getChordLines(), header, chorusBox);
    }

}
