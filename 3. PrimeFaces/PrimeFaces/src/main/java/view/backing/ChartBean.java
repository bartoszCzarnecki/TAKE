/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/JSF/JSFManagedBean.java to edit this template
 */
package view.backing;

import static java.lang.Math.sin;
import javax.inject.Named;
import javax.enterprise.context.RequestScoped;

import org.primefaces.model.chart.Axis;
import org.primefaces.model.chart.AxisType;
import org.primefaces.model.chart.LineChartModel;
import org.primefaces.model.chart.LineChartSeries;

/**
 *
 * @author Bartek
 */
@Named(value = "chartBean")
@RequestScoped
public class ChartBean {

    private LineChartModel chart;
    /**
     * Creates a new instance of ChartBean
     */
    public ChartBean() {
        chart = new LineChartModel();
        LineChartSeries chartSeries = new LineChartSeries();
        for(int i=0; i<360; i++) {
            chartSeries.set(i, sin(Math.toRadians(i)));
        }
        chart.addSeries(chartSeries);
        chart.setLegendPosition("e");
        Axis y = chart.getAxis(AxisType.Y);
        y.setMin(-1.0);
        y.setMax(1.0);
        y.setLabel("Y");
        
        Axis x = chart.getAxis(AxisType.X);
        x.setMin(0);
        x.setMax(360);
        x.setTickInterval("30");
        x.setLabel("X");
    }

    /**
     * @return the chart
     */
    public LineChartModel getChart() {
        return chart;
    }

    /**
     * @param chart the chart to set
     */
    public void setChart(LineChartModel chart) {
        this.chart = chart;
    }
    
}
