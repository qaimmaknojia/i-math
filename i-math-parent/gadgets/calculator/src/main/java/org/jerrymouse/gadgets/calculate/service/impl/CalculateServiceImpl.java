package org.jerrymouse.gadgets.calculate.service.impl;

import org.jerrymouse.gadgets.calculator.service.CalculateService;
import org.nfunk.jep.JEP;

public class CalculateServiceImpl implements CalculateService {
	private JEP jep;

	public CalculateServiceImpl() {
	}

	@Override
	public void setExpression(String expression) {
		jep = getJep();
		jep.addVariable("x", 0);
		jep.parseExpression(expression);
	}

	@Override
	public double value(double x) {
		if (jep == null) {
			return 0;
		}
		jep.addVariable("x", x);
		return jep.getValue();
	}

	@Override
	public double calculate(String expression) {
		jep = getJep();
		jep.parseExpression(expression);
		return jep.getValue();
	}

	@Override
	public double value(String expression, double x) {
		jep = getJep();
		jep.addVariable("x", x);
		jep.parseExpression(expression);
		return jep.getValue();
	}

	public JEP getJep() {
		jep = new JEP();
		jep.addStandardFunctions();
		jep.addStandardConstants();
		return jep;
	}

}
