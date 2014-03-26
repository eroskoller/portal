/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.facesbeans.monitor.faturamento;

import br.com.hibernate.entities.LabUnidade;
import java.awt.Color;
import java.awt.Paint;
import java.awt.Shape;
import java.awt.Stroke;
import java.util.Date;

import org.primefaces.model.chart.CartesianChartModel;
import org.primefaces.model.chart.ChartSeries;
import org.primefaces.model.chart.LineChartSeries;

/**
 *
 * @author eros
 */
public class MonitorDeFaturamentoChartBuilder {

    public static CartesianChartModel buildAxisChart(String[] xAxisLabels, double[][] data, String xTitle, String yTitle, String title, Shape[] shapes, Stroke[] strokes, Paint[] arrayPaint, String[] legendLabels, int intWidth, int intHeight) {
        CartesianChartModel chartModelNew = null;
        try {

            chartModelNew = new CartesianChartModel();
            LineChartSeries chartSeriesNew = null;

            if (data != null && data.length > 0) {
                for (int i = 0; i < data.length; i++) {
                    chartSeriesNew = new LineChartSeries();
                    for (int y = 0; y < data[0].length; y++) {
                        double x = data[i][y];
                        //xAxisLabels[y]
                        chartSeriesNew.set(xAxisLabels[y], new Double(x) );
                        chartSeriesNew.setShowLine(true);
                    }
//                    chartSeriesNew.setLabel(legendLabels[i]);
                    chartSeriesNew.setLabel(legendLabels[i]);
                    chartModelNew.addSeries(chartSeriesNew);
                }
            } else {
                chartModelNew = new CartesianChartModel();
                chartSeriesNew = new LineChartSeries();
                chartSeriesNew.set("2004", 52);
                chartSeriesNew.set("2005", 60);
                chartSeriesNew.set("2006", 110);
                chartSeriesNew.set("2007", 135);
                chartSeriesNew.set("2008", 120);
                chartSeriesNew.setLabel("test");
                chartModelNew.addSeries(chartSeriesNew);

            }


        } catch (Exception e) {
            e.printStackTrace();
        }

        return chartModelNew;
    }
}
