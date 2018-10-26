/**
 * 
 */
package com.sample.application.calculator;

import static java.lang.System.out;

import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;

import com.sample.application.calculator.domain.Cell;
import com.sample.application.calculator.exceptions.InvalidInputException;
import com.sample.application.calculator.handler.CellValueCalculator;
import com.sample.application.calculator.handler.OutputWriter;

/**
 * Spread sheet calculator computes given input
 * 
 * @author sidonepudi
 *
 */
public class Spreadsheet {
	private InputStream inputStream;
	private OutputStream outputStream;

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		Spreadsheet handler = new Spreadsheet();
		handler.setInputStrem(System.in);
		handler.setOutputStrem(System.out);
		handler.execute();
	}

	public void execute() {
		try {
			// read & populate the user input
			SpreadsheetBuilder builder = new SpreadsheetBuilder(inputStream);
			Cell[][] spreadSheet = builder.createSpreadSheet();

			// compute the expression, references
			CellValueCalculator cellValueCalculator = new CellValueCalculator();
			cellValueCalculator.calculate(spreadSheet);

			// print the output
			OutputWriter writer = new OutputWriter(outputStream);
			writer.printOutput(spreadSheet);

		} catch (InvalidInputException e) {
			out.println(e.getMessage());
		} finally {
			closeStream();
		}
	}

	/**
	 * close stream gracefully
	 */
	private void closeStream() {
		if (inputStream != null) {
			try {
				inputStream.close();
			} catch (IOException e) {
				out.print(e.getMessage());
			}
		}
		if (outputStream != null) {
			try {
				outputStream.close();
			} catch (IOException e) {
				out.print(e.getMessage());
			}
		}
	}

	/**
	 * sets the input stream
	 * 
	 * @param inputStream
	 */
	private void setInputStrem(InputStream inputStream) {
		this.inputStream = inputStream;
	}

	/**
	 * sets the output stream
	 * 
	 * @param outputStream
	 */
	private void setOutputStrem(OutputStream outputStream) {
		this.outputStream = outputStream;
	}

}
