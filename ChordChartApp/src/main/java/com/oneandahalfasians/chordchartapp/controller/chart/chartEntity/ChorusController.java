package com.oneandahalfasians.chordchartapp.controller.chart.chartEntity;

import com.oneandahalfasians.chordchartapp.data.entities.ChartEntity;
import com.oneandahalfasians.chordchartapp.data.entities.Chorus;
import com.oneandahalfasians.chordchartapp.model.ChartEntityOptionsModel;
import com.oneandahalfasians.chordchartapp.view.chartEntity.ChartBodyBox;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.layout.VBox;
import javafx.scene.text.Text;

import java.net.URL;
import java.util.ResourceBundle;

public class ChorusController extends EntityController implements Initializable {


    private VBox mainContainer;

//    @FXML
    public Text header;
//    @FXML
    public ChartBodyBox chorusBox;
    private final Chorus chorus;

    private ChartEntityOptionsModel options;

    public ChorusController(ChartEntity chorus, ChartEntityOptionsModel options) {
        this.mainContainer = new VBox();
        this.header = new Text();
        this.chorusBox = new ChartBodyBox();
        this.chorus = (Chorus) chorus;
        this.options = options;
    }

    public Chorus getChorus() {
        return chorus;
    }

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        SectionRendererHelper.initializeSectionContents(chorus, chorus.getChordLines(), header, chorusBox);

        if(options.isShouldFocus()){
            chorusBox.getFirstRow().getFirstColumn().focusLast();
        }
    }

    @Override
    public String getFxmlFileName() {
        return "chart/chartEntity/chorus.fxml";
    }

    @Override
    public Parent getContents() {
        SectionRendererHelper.initializeSectionContents(chorus, chorus.getChordLines(), header, chorusBox);

        if(options.isShouldFocus()){
            chorusBox.getFirstRow().getFirstColumn().focusLast();
        }

        mainContainer.getChildren().add(header);
        mainContainer.getChildren().add(chorusBox);

        return mainContainer;
    }
}
