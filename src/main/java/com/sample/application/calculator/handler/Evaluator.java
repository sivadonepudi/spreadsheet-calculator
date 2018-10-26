/**
 * 
 */
package com.sample.application.calculator.handler;

import java.util.LinkedList;

/**
 * @author sidonepudi
 *
 */
public class Evaluator {
	public void evaluate(Operation operation, LinkedList<Double> stack) {
		double op1, op2;
		switch (operation) {
		case ADDITION:
			op1 = stack.pop();
			op2 = stack.pop();
			stack.push(op2 + op1);
			break;
		case SUBTRACTION:
			op1 = stack.pop();
			op2 = stack.pop();
			stack.push(op2 - op1);
			break;
		case MULTIPLY:
			op1 = stack.pop();
			op2 = stack.pop();
			stack.push(op2 * op1);
			break;
		case DIVIDE:
			op1 = stack.pop();
			op2 = stack.pop();
			stack.push(op2 / op1);
			break;
		case INCREMENT:
			op1 = stack.pop();
			stack.push(op1 + 1);
			break;
		case DECREMENT:
			op1 = stack.pop();
			stack.push(op1 - 1);
			break;
		}
	}
}
