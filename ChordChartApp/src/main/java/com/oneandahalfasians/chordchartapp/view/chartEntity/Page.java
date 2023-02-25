package com.oneandahalfasians.chordchartapp.view.chartEntity;

import javafx.scene.Parent;
import javafx.scene.layout.VBox;

import java.util.ArrayList;
import java.util.List;

public class Page extends VBox {
    private final double totalHeight;
    private double accumulatedHeight = 0;
    private Page previousPage;
    private Page nextPage;

    private final List<Parent> rows = new ArrayList<>();

    public Page(double totalHeight) {
        this(totalHeight, null, null);
    }

    public Page(double totalHeight, Page previousPage, Page nextPage) {
        this.totalHeight = totalHeight;
        this.previousPage = previousPage;
        this.nextPage = nextPage;
        this.setMinHeight(totalHeight);
        this.setMaxHeight(totalHeight * 1.1);
        String cssLayout = """
                -fx-border-color: black;
                -fx-border-width: 1;
                -fx-border-style: solid;
                """;
        this.setStyle(cssLayout);
    }

    public Page addPagePrevious(){
        this.previousPage = new Page(totalHeight);
        return this.previousPage;
    }

    public Page addPageNext(){
        this.nextPage = new Page(totalHeight);
        this.nextPage.setPreviousPage(this);
        return this.nextPage;
    }

    public Page getPreviousPage() {
        return previousPage;
    }

    public void setPreviousPage(Page previousPage) {
        this.previousPage = previousPage;
    }

    public Page getNextPage() {
        return nextPage;
    }

    public void setNextPage(Page nextPage) {
        this.nextPage = nextPage;
    }

    public void addRow(Parent row){
        addRow(row, null);
    }

    public void addRow(Parent row, Integer index){
        if (index == null) {
            getChildren().add(row);
        }
        else{
            getChildren().add(index, row);
        }
    }

    public void removeLastAdded(){
        if(getChildren().isEmpty()){
            return;
        }

        remove(getChildren().size() - 1);
    }

    public void remove(int index){
        getChildren().remove(index, index + 1);
    }
}
