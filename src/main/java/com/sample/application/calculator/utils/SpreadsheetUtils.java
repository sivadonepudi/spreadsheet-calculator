/**
 * 
 */
package com.sample.application.calculator.utils;

import java.util.StringTokenizer;

/**
 * @author sidonepudi
 *
 */
public class SpreadsheetUtils {

	public static boolean isCellHoldingReferenceToOtherCell(String s) {
		if (("" + s.charAt(0)).matches("^[A-Z]")) {
			return true;
		}
		return false;
	}

	public static String[] getTokens(String input) {
		StringTokenizer tokens = new StringTokenizer(input, SpreadsheetConstants.DELIMITER);
		String[] tokenArray = new String[tokens.countTokens()];

		int i = 0;
		while (tokens.hasMoreTokens()) {
			tokenArray[i] = tokens.nextToken();
			i++;
		}
		return tokenArray;
	}
}
