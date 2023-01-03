package com.oneandahalfasians.chordchartapp.controller.chart.chartEntity;

import com.oneandahalfasians.chordchartapp.data.entities.Instrumental;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.layout.VBox;
import javafx.scene.text.Text;

import java.net.URL;
import java.util.ResourceBundle;

public class InstrumentalController implements Initializable {

    private final Instrumental instrumental;

    @FXML
    public Text header;

    @FXML
    public VBox instrumentalBox;

    public InstrumentalController(Instrumental instrumental) {
        this.instrumental = instrumental;
    }

    public Instrumental getInstrumental() {
        return instrumental;
    }

    @Override
    public void initialize(URL location, ResourceBundle resources) {
        SectionRendererHelper.initializeSectionContents(instrumental, instrumental.getChordLines(), header, instrumentalBox);
    }

}
