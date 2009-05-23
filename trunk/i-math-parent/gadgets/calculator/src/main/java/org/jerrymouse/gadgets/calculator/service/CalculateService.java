package org.jerrymouse.gadgets.calculator.service;

public interface CalculateService {
	double value(double x);

	void setExpression(String expression);

	double value(String expression);

	double value(String expression, double x);
}
