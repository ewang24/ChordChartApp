package com.oneandahalfasians.chordchartapp.data;

import com.google.common.collect.BiMap;
import com.google.common.collect.HashBiMap;
import com.oneandahalfasians.chordchartapp.data.entities.*;
import com.oneandahalfasians.chordchartapp.data.entities.key.*;
import com.oneandahalfasians.chordchartapp.data.entities.line.*;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.function.DoubleBinaryOperator;

public class ChartService{

    private Chart chart;
    public BiMap<Key, Integer> keyMap = HashBiMap.create();
    private static ChartService chartServiceInstance;
    private ChartService(){
        chart = new Chart();
        keyMap.put(new Key(KeyLetter.C), 0);
        keyMap.put(new Key(KeyLetter.C, Accidental.SHARP), 1);
        keyMap.put(new Key(KeyLetter.D, Accidental.FLAT), 2);
        keyMap.put(new Key(KeyLetter.D), 3);
        keyMap.put(new Key(KeyLetter.D, Accidental.SHARP), 4);
        keyMap.put(new Key(KeyLetter.E, Accidental.FLAT), 5);
        keyMap.put(new Key(KeyLetter.E), 6);
        keyMap.put(new Key(KeyLetter.F), 7);
        keyMap.put(new Key(KeyLetter.F, Accidental.SHARP), 8);
        keyMap.put(new Key(KeyLetter.G, Accidental.FLAT), 9);
        keyMap.put(new Key(KeyLetter.G), 10);
        keyMap.put(new Key(KeyLetter.G, Accidental.SHARP), 11);
        keyMap.put(new Key(KeyLetter.A, Accidental.FLAT), 12);
        keyMap.put(new Key(KeyLetter.A), 13);
        keyMap.put(new Key(KeyLetter.A, Accidental.SHARP), 14);
        keyMap.put(new Key(KeyLetter.B, Accidental.FLAT), 15);
        keyMap.put(new Key(KeyLetter.B ), 16);
    }

    public static ChartService getInstance(){
        if(chartServiceInstance == null){
            chartServiceInstance = new ChartService();
        }
        return chartServiceInstance;
    }

    public void generateChart_TEST() {
        Chart chart = new Chart();
        chart.setTitle("Evan's First Song");
        chart.getKeyList().add(new Key(KeyLetter.E, Accidental.SHARP));
        chart.setNumberOfBeats(6);
        chart.setUnitBeat(8);
        chart.setTempo(42069);
        chart.setIntro(new Intro());
        chart.setEnding(new Outro());

        //Make a few lines of lyrics:
        List<Chord> chordList = (Arrays.asList(new Chord(new Key(KeyLetter.E, Accidental.SHARP), Quality.MAJOR_7TH),
                new Chord(new Key(KeyLetter.B, Accidental.SHARP), Quality.DOMINANT),
                new Chord(new Key(KeyLetter.A, Accidental.SHARP), Quality.MAJOR_7TH, new Extension(Accidental.SHARP, 11))));

        LyricLine lyricLine = new LyricLine();
        lyricLine.getLyricList().addAll(generateLyric( "This is Evan's first song!!!!", chordList, lyricLine));

        LyricLine lyric2Line = new LyricLine();
        lyric2Line.getLyricList().addAll(generateLyric("This song is super cool", chordList, lyric2Line));

        LyricLine lyric3Line = new LyricLine();
        lyric3Line.getLyricList().addAll(generateLyric("No really, it is please believe me!", chordList, lyric3Line));

        //Added a helper method to Verse.java called addLine() that you can pass a cord and a lyric too.
        //It will automatically create the ChordLyricWrapper for you and put it into the list.
        //ChordLyricWrapper wrapper = new ChordLyricWrapper(null,lyricLine);

        Verse verse = new Verse();
        verse.setHeaderName("Verse 1");
        //Add in every of the lyrics to the verse
        verse.addLine(lyricLine);
        verse.addLine(lyric2Line);
        verse.addLine(lyric3Line);

        Chorus chorus = new Chorus();
        chorus.setHeaderName("Chorus 1");
        chorus.addLine(lyricLine);
        chorus.addLine(lyric2Line);
        chorus.addLine(lyric3Line);

        Bridge bridge = new Bridge();
        bridge.addLine(lyricLine);
        bridge.addLine(lyric2Line);
        bridge.addLine(lyric3Line);

        Instrumental instrumental = new Instrumental();
        instrumental.setHeaderName("Instrumental 1");
        instrumental.addLine(lyricLine);
        instrumental.addLine(lyric2Line);
        instrumental.addLine(lyric3Line);

        chart.getEntityList().add(verse);
        this.chart.incrementMaxVerse();

        chart.getEntityList().add(chorus);
        this.chart.incrementMaxChorus();

        chart.getEntityList().add(bridge);

        chart.getEntityList().add(instrumental);
        this.chart.incrementMaxInstrumental();

        this.chart = chart;
    }


    private List<Lyric> generateLyric(String string, List<Chord> chordLine, LyricLine lyricLine){
        List<Lyric> lyricList = new ArrayList<>();
        String[] split = string.split(" ");
        for (int i = 0; i < split.length; i++) {
            String l = split[i];

            Lyric lyric = new Lyric(l, lyricLine);

            Blank blank = new Blank(lyricLine);
            if(i < chordLine.size()){
                lyric.setAnchorPoint(new AnchorPoint(lyric, chordLine.get(i)));
                blank.setAnchorPoint(new AnchorPoint(lyric, chordLine.get(i)));
            }

            lyricList.add(lyric);
            lyricList.add(blank);
        }
        return lyricList;
    }

    public void loadChart(Chart chart) {
        this.chart = chart;
    }

    public Chart getChart(){
        return chart;
    }

    public Intro addIntro() {
        Intro intro = new Intro();
        intro.setHeaderName("Intro");
        chart.getEntityList().add(intro);
        return intro;
    }

    public Outro addOutro() {
        Outro outro = new Outro();
        outro.setHeaderName("Outro");
        chart.getEntityList().add(outro);
        return outro;
    }

    public Verse addVerse() {
        Verse verse = new Verse();
        chart.incrementMaxVerse();
        verse.setHeaderName("Verse #" + chart.getMaxVerse());

        chart.getEntityList().add(verse);
        return verse;
    }

    public Chorus addChorus() {
        Chorus chorus = new Chorus();
        chart.incrementMaxChorus();
        chorus.setHeaderName("Chorus #" + chart.getMaxChorus());

        chart.getEntityList().add(chorus);
        return chorus;
    }

    public Instrumental addInstrumental() {
        Instrumental instrumental = new Instrumental();
        chart.incrementMaxInstrumental();
        instrumental.setHeaderName("Instrumental #" + chart.getMaxInstrumental());

        chart.getEntityList().add(instrumental);
        return instrumental;
    }

    public Bridge addBridge() {
        return null;
    }

    public Lyric addLyric(ChartEntity parent, String lyricText, int index) {
        return null;
    }

    public AnchorPoint anchorChord() {
        return null;
    }

    public Break addBreak() {
        return null;
    }

    public void updateSectionHeader() {

    }

    public void editLyric() {

    }

    public void editChord() {

    }

    public void deleteLyric() {

    }

    public void deleteChord() {

    }

    public void transpose(Key target) {
        Key currentKey = chart.getKeyList().get(0);
        int diff = keyMap.get(target) - keyMap.get(currentKey);
        for (ChartEntity chartEntity : chart.getEntityList()) {
            for (LyricLine<Lyric> lyricLine : chartEntity.getLyricLines()) {
                for (Lyric lyric : lyricLine.getLyricList()) {
                    if (lyric.hasAnchorPoint() && lyric.getAnchorPoint().getChord() != null) {
                        Chord currentChord = lyric.getAnchorPoint().getChord();
                        Key currentChordKey = currentChord.getKey();
                        int mapValue = keyMap.get(currentChordKey);
                        mapValue = (mapValue + diff) % 17;
                        currentChord.setKey(keyMap.inverse().get(mapValue));
                    }
                }
            }
        }
    }
}
