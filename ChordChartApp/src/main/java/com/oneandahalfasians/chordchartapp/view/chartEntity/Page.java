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
        this.setHeight(totalHeight);
    }

    public Page addPagePrevious(){
        this.previousPage = new Page(totalHeight);
        return this.previousPage;
    }

    public Page addPageNext(){
        this.nextPage = new Page(totalHeight);
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

    public boolean hasSpace(){
        return accumulatedHeight > totalHeight;
    }

    public boolean hasSpace(double rowHeight){
        return accumulatedHeight > totalHeight + rowHeight;
    }

    public void addRow(Parent row, Integer index, double rowHeight){
        accumulatedHeight += rowHeight;
        if (index == null) {
            getChildren().add(row);
        }
        else{
            getChildren().add(index, row);
        }
    }
}
