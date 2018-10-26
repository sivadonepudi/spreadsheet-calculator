/**
 * 
 */
package com.sample.application.validators;

import static org.junit.Assert.fail;

import org.junit.Before;
import org.junit.Rule;
import org.junit.Test;
import org.junit.rules.ExpectedException;

import com.sample.application.calculator.exceptions.InvalidInputException;
import com.sample.application.calculator.validators.DimensionsValidator;

/**
 * @author sidonepudi
 *
 */
public class DimensionsValidatorTest {

	@Rule
	public final ExpectedException expectedException = ExpectedException.none();
	DimensionsValidator validator;

	@Before
	public void init() {
		validator = new DimensionsValidator();
	}

	@Test
	public void testValidate() {
		try {
			validator.validate("3 2");
			validator.validate("1000 26");
		} catch (InvalidInputException e) {
			e.printStackTrace();
			fail();
		}
	}

	@Test
	public void testValidateException() throws InvalidInputException {
		expectedException.expect(InvalidInputException.class);
		expectedException.expectMessage("Invalid dimensions");
		validator.validate("3, 2");
	}

	@Test
	public void testValidateNumberOfRowsException() throws InvalidInputException {
		expectedException.expect(InvalidInputException.class);
		expectedException.expectMessage("min/max no.of rows are 1/26");
		validator.validate("3 27");
	}

	@Test
	public void testValidateNumberOfColumnsException() throws InvalidInputException {
		expectedException.expect(InvalidInputException.class);
		expectedException.expectMessage("min no.of colums are 1");
		validator.validate("-1 5");
	}

}
