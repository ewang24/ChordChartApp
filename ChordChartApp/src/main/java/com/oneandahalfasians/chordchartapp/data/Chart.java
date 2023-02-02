package com.oneandahalfasians.chordchartapp.data;

import com.oneandahalfasians.chordchartapp.data.entities.ChartEntity;
import com.oneandahalfasians.chordchartapp.data.entities.Outro;
import com.oneandahalfasians.chordchartapp.data.entities.Intro;
import com.oneandahalfasians.chordchartapp.data.entities.key.Key;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class Chart {

    //calculated data fields
    int maxVerse;
    int maxChorus;
    int maxInstrumental;

    //Data fields
    private String title;
    private List<Key> keyList = new ArrayList<>();
    private int numberOfBeats;
    private int unitBeat;

    private int tempo;

    private Intro intro;
    private Outro outro;

    //This is all of the possible chart elements (verses, choruses, etc)
    List<ChartEntity> entityList = new ArrayList<>();


    public int getMaxVerse() {
        return maxVerse;
    }

    public Chart incrementMaxVerse(){
        maxVerse++;
        return this;
    }

    public int getMaxChorus() {
        return maxChorus;
    }

    public Chart incrementMaxChorus(){
        maxChorus++;
        return this;
    }

    public int getMaxInstrumental() {
        return maxInstrumental;
    }

    public Chart incrementMaxInstrumental(){
        maxInstrumental++;
        return this;
    }

    public String getTitle() {
        return title;
    }

    public Chart setTitle(String title) {
        this.title = title;
        return this;
    }

    public List<Key> getKeyList() {
        return keyList;
    }

    public Chart setKeyList(List<Key> keyList) {
        this.keyList = keyList;
        return this;
    }

    public int getNumberOfBeats() {
        return numberOfBeats;
    }

    public Chart setNumberOfBeats(int numberOfBeats) {
        this.numberOfBeats = numberOfBeats;
        return this;
    }

    public int getUnitBeat() {
        return unitBeat;
    }

    public Chart setUnitBeat(int unitBeat) {
        this.unitBeat = unitBeat;
        return this;
    }

    public int getTempo() {
        return tempo;
    }

    public Chart setTempo(int tempo) {
        this.tempo = tempo;
        return this;
    }

    public Intro getIntro() {
        return intro;
    }

    public Chart setIntro(Intro intro) {
        this.intro = intro;
        return this;
    }

    public Outro getEnding() {
        return outro;
    }

    public Chart setEnding(Outro outro) {
        this.outro = outro;
        return this;
    }

    public List<ChartEntity> getEntityList() {
        return entityList;
    }

    public Chart setEntityList(List<ChartEntity> entityList) {
        this.entityList = entityList;
        return this;
    }

    /*
     * Business logic
     */

    public String getTimeSignature(){
        return "Time - " + numberOfBeats + "/" + unitBeat;
    }

    public String getKeySignature(){
        return "Key - " + getKeyList().stream().map(Key::toString).collect(Collectors.joining(" -> "));
    }

    public String getTempoString(){
        return "Tempo - " + getTempo();
    }
}
