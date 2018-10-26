/**
 * 
 */
package com.sample.application.calculator.handler;

import java.io.OutputStream;
import java.io.PrintStream;
import java.util.stream.Stream;

import com.sample.application.calculator.domain.Cell;
import com.sample.application.calculator.utils.SpreadsheetConstants;

/**
 * @author sidonepudi
 *
 */
public class OutputWriter {

	private OutputStream outputStream;

	public OutputWriter(OutputStream outputStream) {
		this.outputStream = outputStream;
	}

	public void printOutput(Cell[][] spreadSheet) {
		if (outputStream instanceof PrintStream) {
			PrintStream out = ((PrintStream) outputStream);
			out.println(spreadSheet[0].length + SpreadsheetConstants.DELIMITER + spreadSheet.length);
			Stream.of(spreadSheet)
					.forEach(row -> Stream.of(row).forEach(cell -> out.printf("%.5f%n", cell.getValue())));
		}
	}
}
