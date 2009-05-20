package org.jerrymouse.googleChart.bean;

import java.util.List;

public class Expression {
	private String expressionStr;
	private double min;
	private double max;
	private double step;

	public Expression(String expressionStr, double min, double max, double step) {
		this.expressionStr = expressionStr;
		this.min = min;
		this.max = max;
		this.step = step;
	}

	public List<Double> getData() {
		return null;
	}

}
