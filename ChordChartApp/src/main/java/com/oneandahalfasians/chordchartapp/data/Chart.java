package com.oneandahalfasians.chordchartapp.data;

import com.oneandahalfasians.chordchartapp.data.entities.ChartEntity;
import com.oneandahalfasians.chordchartapp.data.entities.Ending;
import com.oneandahalfasians.chordchartapp.data.entities.Intro;
import com.oneandahalfasians.chordchartapp.data.entities.key.Key;

import java.util.List;

public class Chart {

    private String title;
    private List<Key> keyList;
    private int numberOfBeats;
    private int unitBeat;

    private int tempo;

    private Intro intro;
    private Ending ending;

    List<ChartEntity> entityList;

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

    public Ending getEnding() {
        return ending;
    }

    public Chart setEnding(Ending ending) {
        this.ending = ending;
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
        return numberOfBeats + "/" + unitBeat;
    }
}