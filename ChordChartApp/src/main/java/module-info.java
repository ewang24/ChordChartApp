module com.oneandahalfasians.chordchartapp {
    requires javafx.controls;
    requires javafx.fxml;

    requires org.controlsfx.controls;
    requires com.dlsc.formsfx;
    requires net.synedra.validatorfx;
    requires org.kordamp.ikonli.javafx;
    requires org.kordamp.bootstrapfx.core;
    requires com.almasb.fxgl.all;
    requires annotations;
    requires com.google.common;

    opens com.oneandahalfasians.chordchartapp to javafx.fxml;
    exports com.oneandahalfasians.chordchartapp;
    exports com.oneandahalfasians.chordchartapp.controller;
    opens com.oneandahalfasians.chordchartapp.controller to javafx.fxml;
    opens com.oneandahalfasians.chordchartapp.controller.chart to javafx.fxml;
    opens com.oneandahalfasians.chordchartapp.controller.chart.chartEntity to javafx.fxml;
    opens com.oneandahalfasians.chordchartapp.view.chartEntity to javafx.fxml;
}