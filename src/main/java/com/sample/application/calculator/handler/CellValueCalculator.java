/**
 * 
 */
package com.sample.application.calculator.handler;

import java.util.LinkedList;
import java.util.StringTokenizer;

import com.sample.application.calculator.domain.Cell;
import com.sample.application.calculator.exceptions.InvalidInputException;
import com.sample.application.calculator.utils.SpreadsheetUtils;

/**
 * @author sidonepudi
 *
 */
public class CellValueCalculator {
	public Cell[][] spreadSheet = null;

	/**
	 * For each cell, compute the result & sets the result to Cell Object
	 * 
	 * @param spreadSheet
	 * @throws InvalidInputException
	 */
	public void calculate(Cell[][] spreadSheet) throws InvalidInputException {
		this.spreadSheet = spreadSheet;
		for (Cell[] rows : spreadSheet) {
			for (Cell column : rows) {
				Double d = evaluate(column.getInput());
				column.setValue(d);
			}
		}
	}

	public Double evaluate(String line) throws InvalidInputException {
		String[] tokens = SpreadsheetUtils.getTokens(line);
		LinkedList<Double> stack = new LinkedList<Double>();

		Evaluator evaluator = new Evaluator();
		for (String token : tokens) {
			if (Operation.getByName(token) != null) {
				evaluator.evaluate(Operation.getByName(token), stack);
			} else if (SpreadsheetUtils.isCellHoldingReferenceToOtherCell(token)) {
				String refCellVal = getCellValue(token);
				runCycleDependencyCheck(token, refCellVal);
				stack.push(evaluate(refCellVal));
			} else {
				stack.push(Double.parseDouble(token));
			}
		}
		return stack.pop();
	}

	/**
	 * Throws exception for Cyclic scenarios i.e for input 2 1 \n A2 \n A1
	 * 
	 * @param token
	 * @param refCellVal
	 * @throws InvalidInputException
	 */
	private void runCycleDependencyCheck(String token, String refCellVal) throws InvalidInputException {
		StringTokenizer refCellValTokens = new StringTokenizer(refCellVal, " ");
		while (refCellValTokens.hasMoreTokens()) {
			String refCellToken = refCellValTokens.nextToken();
			if (SpreadsheetUtils.isCellHoldingReferenceToOtherCell(refCellToken)) {
				if (token.equals(getCellValue(refCellToken))) {
					throw new InvalidInputException("encountered cyclic dependency " + token + " & " + refCellVal);
				}
			}
		}
	}

	private String getCellValue(String s) throws InvalidInputException {
		try {
			int x = (int) s.charAt(0) % 65;
			int y = Integer.parseInt(s.substring(1, s.length())) - 1;
			return spreadSheet[x][y].getInput();
		} catch (NumberFormatException e) {
			throw new InvalidInputException("Data format error occurred while evaluating Cell " + s);
		}
	}
}
