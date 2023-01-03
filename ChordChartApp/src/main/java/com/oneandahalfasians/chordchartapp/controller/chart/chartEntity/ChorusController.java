package com.oneandahalfasians.chordchartapp.controller.chart.chartEntity;

import com.oneandahalfasians.chordchartapp.data.entities.Chorus;
import com.oneandahalfasians.chordchartapp.data.entities.line.*;
import com.oneandahalfasians.chordchartapp.view.CSS;
import com.oneandahalfasians.chordchartapp.view.FXMLHelper;
import com.oneandahalfasians.chordchartapp.view.TextUtils;
import javafx.collections.ObservableList;
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.geometry.Pos;
import javafx.scene.Node;
import javafx.scene.control.TextField;
import javafx.scene.input.InputEvent;
import javafx.scene.input.KeyCode;
import javafx.scene.input.KeyEvent;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.scene.text.Font;
import javafx.scene.text.FontWeight;
import javafx.scene.text.Text;

import java.net.URL;
import java.util.List;
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
