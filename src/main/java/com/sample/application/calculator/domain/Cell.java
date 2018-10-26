/**
 * 
 */
package com.sample.application.calculator.domain;

/**
 * Basic unit of spreadsheet to hold the data
 * 
 * @author sidonepudi
 *
 */
public class Cell {
	// user entered input, could be data/expression/reference.
	private String input;
	// computed data
	private Double value;

	public Cell(String input) {
		this.input = input;
	}

	public String getInput() {
		return input;
	}

	public Double getValue() {
		return value;
	}

	public void setValue(Double value) {
		this.value = value;
	}
}
