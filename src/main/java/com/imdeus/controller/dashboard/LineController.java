package com.imdeus.controller.dashboard;

import java.io.Serializable;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.annotation.PostConstruct;
import javax.faces.view.ViewScoped;
import javax.inject.Inject;
import javax.inject.Named;

import org.primefaces.model.chart.Axis;
import org.primefaces.model.chart.AxisType;
import org.primefaces.model.chart.BarChartModel;
import org.primefaces.model.chart.ChartSeries;
import org.primefaces.model.chart.LegendPlacement;

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

		List<Integer> anos = Arrays.asList(2007, 2012, 2014, 2016);

		Map<String, ChartSeries> chars = new HashMap<>();

		for (GrupoPessoaGraph pg : dadosGrafico) {
			if (!chars.containsKey(pg.getNomeGrupo())) {
				ChartSeries chart = new ChartSeries();
				chart.setLabel(pg.getNomeGrupo());
				chart.set(pg.getCriacao(), pg.getQtdePessoas());
				chars.put(pg.getNomeGrupo(), chart);
			} else {
				ChartSeries chart = chars.get(pg.getNomeGrupo());
				chart.set(pg.getCriacao(), pg.getQtdePessoas());
			}
		}
		for (String key : chars.keySet()) {
			ChartSeries chart = chars.get(key);
			for (Integer ano : anos) {
				if (!containsAno(chart.getData(), ano)) {
					chart.set(ano, 0);
				}
			}
			model.addSeries(chars.get(key));
		}
		
		model.setLegendPosition("e");
		model.setLegendPlacement(LegendPlacement.OUTSIDEGRID);

		return model;
	}

	public boolean containsAno(Map<Object, Number> data, Integer ano) {
		for (Object key : data.keySet()) {
			if (key.equals(ano)) {
				return true;
			}
		}
		return false;
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