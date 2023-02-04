package com.oneandahalfasians.chordchartapp.controller;

import com.oneandahalfasians.chordchartapp.controller.chart.ChartController;
import com.oneandahalfasians.chordchartapp.data.Chart;
import com.oneandahalfasians.chordchartapp.data.ChartService;
import com.oneandahalfasians.chordchartapp.data.entities.*;
import com.oneandahalfasians.chordchartapp.data.entities.key.*;
import com.oneandahalfasians.chordchartapp.data.entities.line.*;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.layout.GridPane;

import java.io.IOException;
import java.net.URL;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.ResourceBundle;

public class MainController implements Initializable {
    @FXML
    public GridPane appCenterVBox;

    @FXML
    private Parent chartView;

    @FXML
    private ChartController chartViewController;

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        appCenterVBox.setId("app-center-vbox");

        chartViewController.setChart(ChartService.getInstance().getChart());
    }


    @FXML
    public void addVerse(ActionEvent e){
        try {
            var verse = ChartService.getInstance().addVerse();
            chartViewController.addChild(verse, true, true);
        } catch (IOException ex) {
            System.out.println("You dun goofed:\n" + ex.getMessage());
            ex.printStackTrace();
        }
    }

    @FXML
    public void addChorus(ActionEvent e){
        try {
            var newChorus = ChartService.getInstance().addChorus();
            chartViewController.addChild(newChorus, true, true);
        } catch (IOException ex) {
            System.out.println("You dun goofed.\n" + e);
        }
    }

    @FXML
    public void addBridge(ActionEvent e){
        try {
            var newBridge = ChartService.getInstance().addBridge();
            chartViewController.addChild(newBridge);
        } catch (IOException ex) {
            System.out.println("You dun goofed.\n" + e);
        }
    }

    @FXML
    public void addInstrumental(ActionEvent e){
        try {
            var newInstrumental = ChartService.getInstance().addInstrumental();
            chartViewController.addChild(newInstrumental);
        } catch (IOException ex) {
            System.out.println("You dun goofed.\n" + e);
        }
    }

    @FXML
    public void addIntro(ActionEvent e){
        try {
            var newIntro = ChartService.getInstance().addIntro();
            chartViewController.addChild(newIntro);
        } catch (IOException ex) {
            System.out.println("You dun goofed.\n" + e);
        }
    }

    @FXML
    public void addOutro(ActionEvent e){
        try {
            var newOutro = ChartService.getInstance().addOutro();
            chartViewController.addChild(newOutro);
        } catch (IOException ex) {
            System.out.println("You dun goofed.\n" + e);
        }
    }
}
