package com.oneandahalfasians.chordchartapp.data;

import com.oneandahalfasians.chordchartapp.data.entities.ChartEntity;

public interface IChartService {

    void addIntro();

    void addOutro();

    void addVerse();

    void addChorus();

    void addInstrumental();

    void addBridge();

    void addLyric(ChartEntity parent, String lyricText, int index);
    void anchorChord();

    void addBreak();

    void updateSectionHeader();

    void editLyric();

    void editChord();

    void deleteLyric();

    void deleteChord();
}
