package test.com.oneandahalfasians.chordchartapp.data;

import com.oneandahalfasians.chordchartapp.data.ChartService;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

/**
 * @author Winston Ji
 * @version 3/31/2023
 * @project ChordChartApp
 */
class ChartServiceTest {

    ChartService chartService;
    @BeforeEach
    void setUp() {
        chartService = ChartService.getInstance();
    }

    @Test
    void transpose() {

    }

}
