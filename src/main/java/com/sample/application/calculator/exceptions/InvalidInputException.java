/**
 * 
 */
package com.sample.application.calculator.exceptions;

/**
 * Application exception
 * 
 * @author sidonepudi
 *
 */
public class InvalidInputException extends Exception {
	/**
	 * 
	 */
	private static final long serialVersionUID = 7451545583082862958L;

	public InvalidInputException(String message) {
		super(message);
	}
}
