package com.imdeus.controller.dashboard;

import org.primefaces.model.chart.LineChartSeries;

public class CharData {

	public static final int START_YEAR = 2007;
	private static final int[] primeFacesNumbers = { 0, 0, 1, 12, 34, 66, 82, 88, 80 };
	private static final int[] richFacesNumbers = { 22, 62, 74, 57, 45, 31, 23, 14, 9 };
	private static final int[] iceFacesNumbers = { 28, 34, 48, 34, 25, 14, 9, 6, 4 };
	private LineChartSeries primeFacesSeries;
	private LineChartSeries richFacesSeries;
	private LineChartSeries iceFacesSeries;

	public CharData() {
		buildLineChartSeries();
	}

	private void buildLineChartSeries() {
		primeFacesSeries = new LineChartSeries();
		primeFacesSeries.setLabel("PrimeFaces");
		richFacesSeries = new LineChartSeries();
		richFacesSeries.setLabel("RichFaces");
		iceFacesSeries = new LineChartSeries();
		iceFacesSeries.setLabel("IceFaces");
		int numYears = primeFacesNumbers.length;
		for (int i = 0; i < numYears; i++) {
			String xValue = String.valueOf(i + START_YEAR);
			int yValue = primeFacesNumbers[i];
			primeFacesSeries.set(xValue, yValue);
			yValue = richFacesNumbers[i];
			richFacesSeries.set(xValue, yValue);
			yValue = iceFacesNumbers[i];
			iceFacesSeries.set(xValue, yValue);
		}
	}

	public LineChartSeries primeFacesSeries() {
		return (primeFacesSeries);
	}

	public LineChartSeries richFacesSeries() {
		return (richFacesSeries);
	}

	public LineChartSeries iceFacesSeries() {
		return (iceFacesSeries);
	}

}
