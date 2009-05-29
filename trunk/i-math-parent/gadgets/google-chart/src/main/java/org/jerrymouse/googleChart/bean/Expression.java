package org.jerrymouse.googleChart.bean;

import java.util.ArrayList;
import java.util.List;

import org.jerrymouse.gadgets.calculate.service.impl.CalculateServiceImpl;
import org.jerrymouse.gadgets.calculator.service.CalculateService;

public class Expression {
	private double min;
	private double max;
	private double step;
	private CalculateService calculateService;

	public Expression(String expressionStr, double min, double max, double step) {
		this.min = min;
		this.max = max;
		this.step = step;
		calculateService = new CalculateServiceImpl();
		calculateService.setExpression(expressionStr);
	}

	public List<Double> getData() {
		List<Double> list = new ArrayList<Double>();
		for (double i = min; i < max; i += step) {
			list.add(calculateService.value(i));
		}
		return list;
	}

}
