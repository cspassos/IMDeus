package com.imdeus.controller.dashboard;

import java.io.Serializable;
import java.util.List;
import java.util.Random;

import javax.annotation.PostConstruct;
import javax.enterprise.inject.Model;
import javax.inject.Inject;

import org.primefaces.model.chart.Axis;
import org.primefaces.model.chart.AxisType;
import org.primefaces.model.chart.BubbleChartModel;
import org.primefaces.model.chart.BubbleChartSeries;

import com.imdeus.repository.GrupoGraph;
import com.imdeus.repository.StatusGrupoRepository;

@Model
public class BubbleController implements Serializable{

	private static final long serialVersionUID = 1L;

	private BubbleChartModel bubbleModel;

	private List<GrupoGraph> statusComGrupos;

	@Inject
	private StatusGrupoRepository statusRepository;

	@PostConstruct
	public void init() {
		statusComGrupos = statusRepository.statusComTotalDeGrupos();
		createBubbleModels();
	}

	public BubbleChartModel getBubbleModel() {
		return bubbleModel;
	}
	
	private void createBubbleModels() {
		bubbleModel = initBubbleModel();
		long maiorQtdeDeGruposPorStatus = statusComGrupos.stream()
				.mapToLong(g -> g.getQtdeGrupos()).count();
		
		bubbleModel.setTitle("Status Grupos cadastrados");
		bubbleModel.getAxis(AxisType.X).setLabel("Status Grupos");
		Axis yAxis = bubbleModel.getAxis(AxisType.Y);
		yAxis.setMin(0);
		yAxis.setMax(maiorQtdeDeGruposPorStatus);
		yAxis.setLabel("Ingresos");
	}
	
	private BubbleChartModel initBubbleModel() {
		BubbleChartModel model = new BubbleChartModel();
		
		statusComGrupos.stream().forEach(s -> {
			model.add(new BubbleChartSeries(s.getNomeStatus(), 
					new Random().nextInt(2) - 200,
					new Random().nextInt(2) - 300, 
					(int) s.getQtdeGrupos()));
		});

		return model;
	}

}
