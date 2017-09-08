package com.imdeus.controller.dashboard;

import java.io.Serializable;
import java.util.List;

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

	@Inject
	private StatusGrupoRepository statusRepository;
	
	private BubbleChartModel bubbleModel;
	
	private List<GrupoGraph> statusComGrupos;

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
		
		bubbleModel.setTitle("Status Grupos existentes");
		Axis yAxis = bubbleModel.getAxis(AxisType.Y);
		yAxis.setMin(0);
		yAxis.setMax(total());
		yAxis.setLabel("Quantidade de grupos cadastrados");
		
		Axis xAxis = bubbleModel.getAxis(AxisType.X);
		xAxis.setMin(0);
		xAxis.setMax(10);
		
	}

	private long total() {
		return statusComGrupos.stream().mapToLong(GrupoGraph::getQtdeGrupos).sum();
	}
	
	private BubbleChartModel initBubbleModel() {
		BubbleChartModel model = new BubbleChartModel();
		
		statusComGrupos.stream().forEach(s -> {
			model.add(new BubbleChartSeries(s.getNomeStatus(), 
					(int) s.getQtdeGrupos() * 2,
					(int) s.getQtdeGrupos(), 
					(int) s.getQtdeGrupos()));
		});

		return model;
	}

}
