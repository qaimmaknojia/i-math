package org.jerrymouse.univariateFunction.bean;

import org.apache.commons.math.FunctionEvaluationException;
import org.apache.commons.math.analysis.UnivariateRealFunction;
import org.jerrymouse.gadgets.calculate.service.impl.CalculateServiceImpl;
import org.jerrymouse.gadgets.calculator.service.CalculateService;

public class Function implements UnivariateRealFunction {
	CalculateService calculateService = new CalculateServiceImpl();

	public Function(String expression) {
		calculateService.setExpression(expression);
	}

	@Override
	public double value(double x) throws FunctionEvaluationException {
		return calculateService.value(x);
	}

}
