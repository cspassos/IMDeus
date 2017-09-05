package com.imdeus.controller.dashboard;

import java.io.Serializable;
import java.util.List;
import java.util.OptionalLong;

import javax.annotation.PostConstruct;
import javax.faces.view.ViewScoped;
import javax.inject.Inject;
import javax.inject.Named;

import org.primefaces.model.chart.Axis;
import org.primefaces.model.chart.AxisType;
import org.primefaces.model.chart.BarChartModel;
import org.primefaces.model.chart.BarChartSeries;
import org.primefaces.model.chart.ChartSeries;

import com.imdeus.repository.GrupoPessoaGraph;
import com.imdeus.repository.GrupoRepository;

@Named
@ViewScoped
public class LineController implements Serializable {

	private static final long serialVersionUID = 1L;

//	private BarChartModel yearModel;
//
//	public LineController() {
//		yearModel = new BarChartModel();
//		setAxisInfo();
//		ChartData sampleData = new ChartData();
//		BarChartSeries primeFacesSeries = sampleData.primeFacesSeries2();
//		yearModel.addSeries(primeFacesSeries);
//		BarChartSeries richFacesSeries = sampleData.richFacesSeries2();
//		yearModel.addSeries(richFacesSeries);
//		BarChartSeries iceFacesSeries = sampleData.iceFacesSeries2();
//		yearModel.addSeries(iceFacesSeries);
//	}
//
//	public BarChartModel getYearModel() {
//		return (yearModel);
//	}
//
//	private void setAxisInfo() {
//		yearModel.setTitle("Search Volume By Year");
//		yearModel.setLegendPosition("e");
//		Axis xAxis = yearModel.getAxis(AxisType.X);
//		xAxis.setLabel("Year");
//		Axis yAxis = yearModel.getAxis(AxisType.Y);
//		yAxis.setMin(0);
//		yAxis.setMax(100);
//		yAxis.setLabel("Search Volume");
//	}

	private BarChartModel barModel;

	@Inject
	private GrupoRepository grupoRepository;

	private List<GrupoPessoaGraph> dadosGrafico;

	@PostConstruct
	public void init() {
		dadosGrafico = grupoRepository.grupoPessoaGrafico();
		createBarModels();
	}

	public BarChartModel getBarModel() {
		return barModel;
	}

	private BarChartModel initBarModel() {
		BarChartModel model = new BarChartModel();

		ChartSeries boys = new ChartSeries();
		boys.setLabel("Boys");
		dadosGrafico.stream().forEach(g -> {
			boys.set(g.getCriacao(), g.getQtdePessoas());
		});

		model.addSeries(boys);

		return model;
	}

	private void createBarModels() {
		createBarModel();
	}

	private void createBarModel() {
		barModel = initBarModel();

		barModel.setTitle("Quantidades de pessoas por Grupo");
		barModel.setLegendPosition("ne");

		long maiorQuantidade = dadosGrafico.stream().mapToLong(g -> g.getQtdePessoas()).max().getAsLong() + 10;

		Axis yAxis = barModel.getAxis(AxisType.Y);
		yAxis.setLabel("Quantidade de pessoas");
		yAxis.setMin(0);
		yAxis.setMax(maiorQuantidade);
	}

}