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
    public static Key[] keyCircle;

    private static ChartService chartServiceInstance;
    private ChartService(){
        BiMap<Key, Integer> keyMap = HashBiMap.create();
        chart = new Chart();
        keyCircle = new Key[17];
        keyCircle[0] = new Key(KeyLetter.C);
        keyCircle[1] = new Key(KeyLetter.C, Accidental.SHARP);
        keyCircle[2] = new Key(KeyLetter.D, Accidental.FLAT);
        keyCircle[3] = new Key(KeyLetter.D);
        keyCircle[4] = new Key(KeyLetter.D, Accidental.SHARP);
        keyCircle[5] = new Key(KeyLetter.E, Accidental.FLAT);
        keyCircle[6] = new Key(KeyLetter.E);
        keyCircle[7] = new Key(KeyLetter.F);
        keyCircle[8] = new Key(KeyLetter.F, Accidental.SHARP);
        keyCircle[9] = new Key(KeyLetter.G, Accidental.FLAT);
        keyCircle[10] = new Key(KeyLetter.G);
        keyCircle[11] = new Key(KeyLetter.G, Accidental.SHARP);
        keyCircle[12] = new Key(KeyLetter.A, Accidental.FLAT);
        keyCircle[13] = new Key(KeyLetter.A);
        keyCircle[14] = new Key(KeyLetter.A, Accidental.SHARP);
        keyCircle[15] = new Key(KeyLetter.B, Accidental.FLAT);
        keyCircle[16] = new Key(KeyLetter.B );
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

    }
}
