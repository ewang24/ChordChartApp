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
//randum teszt komint
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
    public void addVerse(ActionEvent e){;
        try {
            var verse = ChartService.getInstance().addVerse();
            chartViewController.addChild(verse);
        } catch (IOException ex) {
            System.out.println("You dun goofed.");
        }
    }

    @FXML
    public void addChorus(ActionEvent e){
        System.out.println("chorus added");
        var newChorus = new Chorus();
        try {
            chartViewController.addChild(newChorus);
        } catch (IOException ex) {
            System.out.println("You dun goofed.");
        }
    }

    @FXML
    public void addBridge(ActionEvent e){
        System.out.println("bridge added");
        var newBridge = new Bridge();
        try {
            chartViewController.addChild(newBridge);
        } catch (IOException ex) {
            System.out.println("You dun goofed.");
        }
    }

    @FXML
    public void addInstrumental(ActionEvent e){
        System.out.println("instrumental added");
        var newInstrumental = new Instrumental();
        try {
            chartViewController.addChild(newInstrumental);
        } catch (IOException ex) {
            System.out.println("You dun goofed.");
        }
    }

    @FXML
    public void addIntro(ActionEvent e){
        System.out.println("intro added");
        var newIntro = new Intro();
        try {
            chartViewController.addChild(newIntro);
        } catch (IOException ex) {
            System.out.println("You dun goofed.");
        }
    }

    @FXML
    public void addOutro(ActionEvent e){
        System.out.println("outro added");
        var newOutro = new Outro();
        try {
            chartViewController.addChild(newOutro);
        } catch (IOException ex) {
            System.out.println("You dun goofed.");
        }
    }
}
