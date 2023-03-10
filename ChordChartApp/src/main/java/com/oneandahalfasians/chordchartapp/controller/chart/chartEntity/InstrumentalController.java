package com.oneandahalfasians.chordchartapp.controller.chart.chartEntity;

import com.oneandahalfasians.chordchartapp.data.entities.ChartEntity;
import com.oneandahalfasians.chordchartapp.data.entities.Instrumental;
import com.oneandahalfasians.chordchartapp.model.ChartEntityOptionsModel;
import com.oneandahalfasians.chordchartapp.view.chartEntity.ChartBodyBox;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.layout.VBox;
import javafx.scene.text.Text;

import java.net.URL;
import java.util.ResourceBundle;

public class InstrumentalController extends EntityController implements Initializable {

    private final Instrumental instrumental;
    private ChartEntityOptionsModel options;

    @FXML
    public Text header;

    @FXML
    public ChartBodyBox instrumentalBox;

    public InstrumentalController(ChartEntity instrumental, ChartEntityOptionsModel options) {
        this.instrumental = (Instrumental) instrumental;
        this.options = options;
    }

    public Instrumental getInstrumental() {
        return instrumental;
    }

    @Override
    public void initialize(URL location, ResourceBundle resources) {
        SectionRendererHelper.initializeSectionContents(instrumental, instrumental.getChordLines(), header, instrumentalBox);

        if(options.isShouldFocus()){
            instrumentalBox.getFirstRow().getFirstColumn().focusLast();
        }
    }

    @Override
    public String getFxmlFileName() {
        return "chart/chartEntity/instrumental.fxml";
    }
}
