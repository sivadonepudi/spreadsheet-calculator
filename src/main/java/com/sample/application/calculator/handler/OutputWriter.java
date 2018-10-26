/**
 * 
 */
package com.sample.application.calculator.handler;

import java.io.OutputStream;
import java.io.PrintStream;
import java.util.stream.Stream;

import com.sample.application.calculator.domain.Cell;

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
			Stream.of(spreadSheet).forEach(row -> Stream.of(row)
					.forEach(cell -> ((PrintStream) outputStream).printf("%.5f%n", cell.getValue())));
		}
	}
}
