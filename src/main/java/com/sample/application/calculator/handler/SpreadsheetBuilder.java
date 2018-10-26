/**
 * 
 */
package com.sample.application.calculator.handler;

import java.io.InputStream;
import java.util.NoSuchElementException;
import java.util.Scanner;
import java.util.StringTokenizer;

import com.sample.application.calculator.domain.Cell;
import com.sample.application.calculator.exceptions.InvalidInputException;
import com.sample.application.calculator.utils.SpreadsheetConstants;
import com.sample.application.calculator.validators.DimensionsValidator;

/**
 * Creates the spreadsheet instance with the provided dimensions and the
 * data/expression etc
 * 
 * @author sidonepudi
 *
 */
public class SpreadsheetBuilder {

	private InputStream inputStream;

	public SpreadsheetBuilder(InputStream inputStream) {
		this.inputStream = inputStream;
	}

	/**
	 * Creates the spreadsheet object with the given dimensions
	 * 
	 * @return
	 * @throws InvalidInputException
	 */
	public Cell[][] createSpreadSheet() throws InvalidInputException {
		Cell[][] spreadSheet = null;
		Scanner scanner = new Scanner(inputStream);
		// create spread sheet
		if (scanner.hasNext()) {
			String dimensionStr = scanner.nextLine();
			spreadSheet = initializeSpreadSheet(dimensionStr);
		} else {
			scanner.close();
			throw new InvalidInputException("spreadsheet dimensions are not provided.");
		}

		// since all the column are of same length, taking one of row
		int numberOfColumns = spreadSheet[0].length;
		int row = 0;
		int column = 0;

		// populate spread sheet
		while (scanner.hasNext()) {
			if (column < numberOfColumns) {
				spreadSheet[row][column] = new Cell(scanner.nextLine());
				column++;
			} else {
				column = 0;
				row++;
			}
		}
		scanner.close();
		return spreadSheet;
	}

	private Cell[][] initializeSpreadSheet(String line) throws InvalidInputException {
		new DimensionsValidator().validate(line);
		try {
			StringTokenizer tokens = new StringTokenizer(line, SpreadsheetConstants.DELIMITER);
			int columns = Integer.parseInt(tokens.nextToken());
			int rows = Integer.parseInt(tokens.nextToken());
			return new Cell[rows][columns];
		} catch (NoSuchElementException e) {
			throw new InvalidInputException(e.getMessage());
		}
	}
}
