package com.imdeus.controller.dashboard;

import java.io.Serializable;

import javax.annotation.PostConstruct;
import javax.faces.view.ViewScoped;
import javax.inject.Named;

import org.primefaces.model.chart.Axis;
import org.primefaces.model.chart.AxisType;
import org.primefaces.model.chart.BubbleChartModel;
import org.primefaces.model.chart.BubbleChartSeries;

@Named
@ViewScoped
public class DashboardController implements Serializable{

	private static final long serialVersionUID = 1L;
	
	private BubbleChartModel bubbleModel1;

	@PostConstruct
	public void init() {
		createBubbleModels();
	}

	public BubbleChartModel getBubbleModel1() {
		return bubbleModel1;
	}

	private void createBubbleModels() {
		bubbleModel1 = initBubbleModel();
		bubbleModel1.setTitle("Bubble Chart");
		bubbleModel1.getAxis(AxisType.X).setLabel("Price");
		Axis yAxis = bubbleModel1.getAxis(AxisType.Y);
		yAxis.setMin(0);
		yAxis.setMax(250);
		yAxis.setLabel("Labels");
	}

	private BubbleChartModel initBubbleModel() {
		BubbleChartModel model = new BubbleChartModel();

		model.add(new BubbleChartSeries("Acura", 70, 183, 55));
		model.add(new BubbleChartSeries("Alfa Romeo", 45, 92, 36));
		model.add(new BubbleChartSeries("AM General", 24, 104, 40));
		model.add(new BubbleChartSeries("Bugatti", 50, 123, 60));
		model.add(new BubbleChartSeries("BMW", 15, 89, 25));
		model.add(new BubbleChartSeries("Audi", 40, 180, 80));
		model.add(new BubbleChartSeries("Aston Martin", 70, 70, 48));

		return model;
	}

}
