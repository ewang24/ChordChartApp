package com.oneandahalfasians.chordchartapp.data.entities;

import com.oneandahalfasians.chordchartapp.controller.chart.chartEntity.EntityController;
import com.oneandahalfasians.chordchartapp.data.entities.line.Lyric;
import com.oneandahalfasians.chordchartapp.data.entities.line.LyricLine;
import com.oneandahalfasians.chordchartapp.model.ChartEntityOptionsModel;
import javafx.fxml.Initializable;
import javafx.scene.Node;

import java.util.List;
import java.util.UUID;

public abstract class ChartEntity {

    private UUID uuid;
    protected String headerName;

    public String getHeaderName() {
        return headerName;
    }

    public ChartEntity setHeaderName(String headerName) {
        this.headerName = headerName;
        return this;
    }

    /*
    Abstract Methods
     */

    public abstract Class<? extends EntityController> getViewClass();

    public abstract List<LyricLine<Lyric>> getLyricLines();
}
