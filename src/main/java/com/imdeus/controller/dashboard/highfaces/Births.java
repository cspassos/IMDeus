package com.imdeus.controller.dashboard.highfaces;

public class Births {

	private String year;
	private Integer amount;

	public Births() {  }

	public Births(String year, Integer amount) {
		this.year = year;
		this.amount = amount;
	}

	public String getYear() {
		return year;
	}

	public void setYear(String year) {
		this.year = year;
	}

	public Integer getAmount() {
		return amount;
	}

	public void setAmount(Integer amount) {
		this.amount = amount;
	}

}
