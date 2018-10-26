/**
 * 
 */
package com.sample.application.calculator.validators;

import java.util.StringTokenizer;

import com.sample.application.calculator.exceptions.InvalidInputException;

/**
 * Validator for the spreadsheet dimensions
 * 
 * @author sidonepudi
 *
 */
public class DimensionsValidator {

	public void validate(String line) throws InvalidInputException {
		StringTokenizer tokens = new StringTokenizer(line, " ");
		int rows = -1;
		int columns = -1;
		try {
			columns = Integer.parseInt(tokens.nextToken());
			rows = Integer.parseInt(tokens.nextToken());
		} catch (NumberFormatException e) {
			throw new InvalidInputException("Invalid dimensions");
		}
		if (rows > 26 || rows < 1) {
			throw new InvalidInputException("min/max no.of rows are 1/26");
		}
		if (columns < 1) {
			throw new InvalidInputException("min no.of colums are 1");
		}
	}
}
