package com.imdeus.controller.dashboard.highfaces;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

import javax.annotation.PostConstruct;
import javax.enterprise.inject.Model;
import javax.faces.application.FacesMessage;
import javax.faces.context.FacesContext;
import javax.inject.Inject;

import com.imdeus.repository.GrupoPessoaGraph;
import com.imdeus.repository.GrupoRepository;

@Model
public class LineChartController {

	@Inject
	private GrupoRepository grupoRepository;

	private List<GrupoPessoaGraph> dadosGrafico;

	private List<Births> boys;
	private List<Births> girls;
	private String selectedPoint;
	private String selectedSeries;

	@PostConstruct
	public void init() {
		dadosGrafico = grupoRepository.grupoPessoaGrafico();
		reload();
	}

	private void reload() {
		boys = new ArrayList<>();
		girls = new ArrayList<>();
		Random r = new Random();

		for (int i = 2000; i < 2010; i++) {
			boys.add(new Births(Integer.toString(i), r.nextInt(500) + 800));
		}
		for (int i = 2000; i < 2009; i++) {
			girls.add(new Births(Integer.toString(i), r.nextInt(500) + 800));
		}
	}

	public void clicked() {
		FacesMessage m = new FacesMessage("You clicked " + selectedPoint + " on series " + selectedSeries);
		FacesContext.getCurrentInstance().addMessage("", m);
	}

	public String getSelectedSeries() {
		return selectedSeries;
	}

	public String getSelectedPoint() {
		return selectedPoint;
	}

	public List<Births> getBoys() {
		return boys;
	}

	public List<Births> getGirls() {
		return girls;
	}

	public List<GrupoPessoaGraph> getDadosGrafico() {
		return dadosGrafico;
	}

}
