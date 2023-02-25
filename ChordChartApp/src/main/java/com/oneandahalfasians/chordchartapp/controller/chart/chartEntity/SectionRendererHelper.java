package com.oneandahalfasians.chordchartapp.controller.chart.chartEntity;

import com.oneandahalfasians.chordchartapp.data.entities.ChartEntity;
import com.oneandahalfasians.chordchartapp.data.entities.line.*;
import com.oneandahalfasians.chordchartapp.view.CSS;
import com.oneandahalfasians.chordchartapp.view.FXMLHelper;
import com.oneandahalfasians.chordchartapp.view.TextUtils;
import com.oneandahalfasians.chordchartapp.view.chartEntity.ChartBodyBox;
import com.oneandahalfasians.chordchartapp.view.chartEntity.ChartBodyRowBox;
import com.oneandahalfasians.chordchartapp.view.chartEntity.ChartBodyRowColumnBox;
import javafx.collections.ObservableList;
import javafx.event.EventHandler;
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

import java.util.List;

public class SectionRendererHelper {

    /**
     * Helper method to setup the view for sections (instrumentals, verses, choruses, etc.)
     * @param section The given section. This will be a child of ChartEntity, like instrumental, verse, etc.
     * @param lines The list of content for the given section
     * @param header The header element for this view
     * @param contentBox The main content box for this view
     */
    public static void initializeSectionContents(ChartEntity section, List<LyricLine<Lyric>> lines, Text header, ChartBodyBox contentBox) {

        String cssLayout = ""; /*"""
                -fx-border-color: red;
                -fx-border-width: 3;
                -fx-border-style: dashed;
                """;*/

//        contentBox.setStyle(cssLayout);

       //Set basic universal section info
        header.setText(section.getHeaderName());
        header.setFont(Font.font("arial", FontWeight.BOLD, 20));
        contentBox.setStyle(cssLayout + String.format("-fx-padding: 0 %s 0 %s", CSS.VERSE_CONTROLLER__VERSE_BOX__PADDING, CSS.VERSE_CONTROLLER__VERSE_BOX__PADDING));

        //These are testing styles
        String styles = "-fx-border-color: blue;\n" +
                "    -fx-border-insets: 5;\n" +
                "    -fx-border-width: 2;\n" +
                "    -fx-border-style: dashed;";


        //Loop over the rows of contents of the sections
        for (LyricLine<? extends Lyric> lyricLine : lines) {

            //lyricRow represents a visual line of content for a section
            ChartBodyRowBox lyricRow = new ChartBodyRowBox();
            if (lyricLine.getLyricList() != null) {

                //process the contents of a row
                List<? extends Lyric> lyricList = lyricLine.getLyricList();
                for (int childIndex = 0; childIndex < lyricList.size(); childIndex++) {
                    Lyric lyric = lyricList.get(childIndex);
                    lyricRow.addColumn(generateLyricColumn(lyric, lyricRow, childIndex));
                }
            }

            //Finally add our new row to the main container for the section
            contentBox.addRow(lyricRow);
        }
    }

    private static ChartBodyRowColumnBox generateLyricColumn(Lyric lyric, ChartBodyRowBox lyricRow, int index) {
        return generateLyricColumn(lyric, lyricRow, index, false);
    }

    private static ChartBodyRowColumnBox generateLyricColumn(Lyric lyric,
                                            ChartBodyRowBox lyricRow,
                                            int index,
                                            boolean requestFocus) {

        //Create the vertical container for the lyric text/chord grouping
        ChartBodyRowColumnBox lyricColumn = new ChartBodyRowColumnBox();
        lyricColumn.setAlignment(Pos.BOTTOM_CENTER);

        //These are testing styles:
        String styles2 = "-fx-border-color: pink;\n" +
                "    -fx-border-insets: 5;\n" +
                "    -fx-border-width: 1;\n" +
                "    -fx-border-style: dashed;";
//        lyricColumn.setStyle(styles2);


        //Create the two parts of the grouping:
        TextField chordText = generateChordText(lyric, lyricColumn);
        TextField lyricText = generateLyricText(lyric, index, lyricRow, lyricColumn, requestFocus);

        lyricColumn.setup(chordText, lyricText);

        return lyricColumn;
    }

    private static TextField generateChordText(Lyric lyric, VBox lyricColumn){
        //Add the chord if there is a chord anchored to the lyric
        if (lyric.getAnchorPoint() != null) {
            Chord anchoredChord = lyric.getAnchorPoint().getChord();

            TextField chordText = new TextField(anchoredChord.toString());
            chordText.getStyleClass().add(CSS.CHORD_TEXT_CLASS);
            chordText.setAlignment(Pos.CENTER);

            setTextFieldWidthListener(chordText);

            return chordText;
        }

        return null;
    }
    private static TextField generateLyricText(Lyric lyric,
                                               int index,
                                               HBox lyricRow,
                                               VBox lyricColumn,
                                               boolean requestFocus
    ) {
        //Create the lyric. Instrumentals do not have lyrics,
        //so make sure that we are not dealing with an InstrumentalLyric.
        if(lyric instanceof InstrumentalLyric){
            return null;
        }

        TextField lyricText = new TextField(lyric.getLyric());
        setTextFieldWidthListener(lyricText);

        //Determine the styling for the type of lyric
        String lyricClass = null;
        if (lyric instanceof Blank) {
            lyricClass = CSS.BLANK_LYRIC_TEXT_CLASS;
            lyricText.setPrefWidth(0);
        } else if (lyric instanceof Break) {
            lyricClass = CSS.BREAK_LYRIC_TEXT_CLASS;
        } else {
            lyricClass = CSS.LYRIC_TEXT_CLASS;
            FXMLHelper.data(lyricText, Lyric.LYRIC_INDEX, index);
            FXMLHelper.data(lyricText, Lyric.PARENT, lyricRow);
        }

        lyricText.getStyleClass().add(lyricClass);
        lyricText.setAlignment(Pos.CENTER);

        setTextFieldKeyListeners(lyricText, true);

        return lyricText;
    }

    private static void setTextFieldWidthListener(TextField textField) {

        //Listener that will fire when the text field is updated.
        //Readjusts the text field size to fit the text better.
        textField.textProperty().addListener((ob, o, n) ->
                textField.setPrefWidth(TextUtils.computeTextWidth(textField.getFont(), textField.getText(), 0D) + CSS.VERSE_CONTROLLER__VERSE_BOX__PADDING * 2)
        );

        //Manually trigger the resize initially so that things line up correctly at first
        textField.setPrefWidth(TextUtils.computeTextWidth(textField.getFont(), textField.getText(), 0D) + CSS.VERSE_CONTROLLER__VERSE_BOX__PADDING * 2);
    }

    private static void setTextFieldKeyListeners(final TextField textField, boolean isLyric) {
        //Handle key events for the text field
        if (isLyric) {
            textField.addEventHandler(KeyEvent.KEY_PRESSED, new EventHandler<InputEvent>() {
                @Override
                public void handle(InputEvent event) {

                    if (!(event instanceof KeyEvent)) {
                        return;
                    }

                    KeyCode keyCode = ((KeyEvent) event).getCode();

                    //Process space key events
                    if (keyCode.equals(KeyCode.SPACE)) {

                        //If the text has no contents, then there is nothing to do
                        if (textField.getText() == null || textField.getText().trim().isBlank()) {
                            return;
                        }

                        //Otherwise, we will want to add a new text field
                        Integer index = (Integer) FXMLHelper.data(textField, Lyric.LYRIC_INDEX);
                        if (index != null) {
                            ChartBodyRowBox lyricRow = (ChartBodyRowBox) FXMLHelper.data(textField, Lyric.PARENT);

                            int newIndex = index + 1;
                            ChartBodyRowColumnBox lyricColumn = generateLyricColumn(new Lyric(null), lyricRow, newIndex, true);

                            //This shouldn't happen, but if it does there isn't much we can do so just throw an exception.
                            if(lyricRow == null)
                            {
                                throw new RuntimeException(
                                        "Something has gone terribly wrong." +
                                                " Tried adding a column to a row but the row was null."
                                );
                            }

                            lyricRow.addColumn(newIndex, lyricColumn);
                            lyricColumn.focusLast();
                        }

                    }
                }
            });
        } else {
            textField.textProperty().addListener((observable, oldValue, newValue) -> {
                System.out.println(oldValue + " " + newValue);
            });
        }
    }
}
