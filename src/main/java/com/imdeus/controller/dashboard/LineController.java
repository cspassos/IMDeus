package com.imdeus.controller.dashboard;

import java.io.Serializable;
import java.util.List;
import java.util.stream.Collectors;

import javax.annotation.PostConstruct;
import javax.faces.view.ViewScoped;
import javax.inject.Inject;
import javax.inject.Named;

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

		List<Integer> anos = dadosGrafico.stream().map(GrupoPessoaGraph::getCriacao).collect(Collectors.toList());

		dadosGrafico.stream().forEach(g -> {
			ChartSeries chart = new ChartSeries();
			anos.forEach(a -> {
				if (g.getCriacao() == a) {
					chart.setLabel(g.getNomeGrupo());
					chart.set(a, g.getQtdePessoas());
				} else {
					chart.setLabel("");
					chart.set(a, 0);
				}
			});
			model.addSeries(chart);
		});

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

		long maiorQuantidade = dadosGrafico.stream().mapToLong(GrupoPessoaGraph::getQtdePessoas).max().getAsLong() + 2;

		Axis yAxis = barModel.getAxis(AxisType.Y);
		yAxis.setLabel("Quantidade de pessoas");
		yAxis.setMin(0);
		yAxis.setMax(maiorQuantidade);
	}

}