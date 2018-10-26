/**
 * 
 */
package com.sample.application.calculator.utils;

import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.assertThat;

import org.junit.Test;

/**
 * @author sidonepudi
 *
 */
public class SpreadsheetUtilsTest {

	@Test
	public void testIsCellHoldingReferenceToOtherCell() {
		assertThat(SpreadsheetUtils.isCellHoldingReferenceToOtherCell("1"), is(false));
		assertThat(SpreadsheetUtils.isCellHoldingReferenceToOtherCell("A"), is(true));
		assertThat(SpreadsheetUtils.isCellHoldingReferenceToOtherCell("Z2"), is(true));
	}

}
