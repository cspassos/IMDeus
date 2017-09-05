package com.imdeus.controller.dashboard;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import javax.annotation.PostConstruct;
import javax.faces.view.ViewScoped;
import javax.inject.Inject;
import javax.inject.Named;

import org.hibernate.event.internal.AbstractFlushingEventListener;
import org.primefaces.model.chart.Axis;
import org.primefaces.model.chart.AxisType;
import org.primefaces.model.chart.BarChartModel;
import org.primefaces.model.chart.ChartSeries;

import com.imdeus.repository.GrupoPessoaGraph;
import com.imdeus.repository.GrupoRepository;

@Named
@ViewScoped
public class LineController implements Serializable {

	private static final long serialVersionUID = 1L;

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
		List<ChartSeries> charts = new ArrayList<>();

		dadosGrafico.stream().forEach(g -> {
			ChartSeries chart = new ChartSeries();
			chart.setLabel(g.getNomeGrupo());
			System.out.println(g.getNomeGrupo());
			chart.set(g.getCriacao(), g.getQtdePessoas());
			System.out.println(g.getCriacao() + " - "+ g.getQtdePessoas());
			charts.add(chart);
		});
		
		charts.forEach(ch -> model.addSeries(ch));
//		model.addSeries(chart);
		
		System.out.println(dadosGrafico.stream().count());

		return model;
	}

	private void createBarModels() {
		createBarModel();
	}

	private void createBarModel() {
		barModel = initBarModel();

		barModel.setTitle("Quantidades de pessoas por Grupo");
		barModel.setLegendPosition("ne");
		
		Axis xAxis = barModel.getAxis(AxisType.X); 
		xAxis.setLabel("Year");

		long maiorQuantidade = dadosGrafico.stream().mapToLong(g -> g.getQtdePessoas()).max().getAsLong();
		
		maiorQuantidade += maiorQuantidade / 2;

		Axis yAxis = barModel.getAxis(AxisType.Y);
		yAxis.setLabel("Quantidade de pessoas");
		yAxis.setMin(0);
		yAxis.setMax(maiorQuantidade);
	}

}