/**
 * 
 */
package com.sample.application.calculator.handler;

import java.util.HashMap;
import java.util.Map;

/**
 * @author sidonepudi
 *
 */
public enum Operation {
	ADDITION("+"), SUBTRACTION("-"), MULTIPLY("*"), DIVIDE("/"), INCREMENT("++"), DECREMENT("--");
	private String value;

	private Operation(String value) {
		this.value = value;
	}

	public String getValue() {
		return value;
	}

	private static final Map<String, Operation> operations = new HashMap<String, Operation>(values().length);

	static {
		for (Operation operationType : values())
			operations.put(operationType.getValue(), operationType);
	}

	public static Operation getByName(String name) {
		return operations.get(name);
	}
}
