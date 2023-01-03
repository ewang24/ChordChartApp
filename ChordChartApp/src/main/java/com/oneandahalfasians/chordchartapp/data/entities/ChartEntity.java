package com.oneandahalfasians.chordchartapp.data.entities;

import javafx.scene.Node;

public abstract class ChartEntity {

    protected String headerName;

    public String getHeaderName() {
        return headerName;
    }

    public ChartEntity setHeaderName(String headerName) {
        this.headerName = headerName;
        return this;
    }

    public abstract Node render();
}
