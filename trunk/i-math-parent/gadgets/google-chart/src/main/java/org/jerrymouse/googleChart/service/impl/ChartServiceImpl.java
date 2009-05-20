package org.jerrymouse.googleChart.service.impl;

import java.util.List;
import java.util.Map;

import org.jerrymouse.googleChart.bean.Expression;
import org.jerrymouse.googleChart.bean.GoogleChart;
import org.jerrymouse.googleChart.service.ChartService;

public class ChartServiceImpl implements ChartService {

	public String draw(Map<Double, Double> datas) {
		GoogleChart googleChart = new GoogleChart();
		return googleChart.buildUrl();
	}

	public String draw(List<Double> datas, double min, double max, double step) {
		GoogleChart googleChart = new GoogleChart();
		googleChart.setData(datas, max);
		return googleChart.buildUrl();
	}

	public String draw(String expressionStr, double min, double max, double step) {
		Expression expression = new Expression(expressionStr, min, max, step);
		GoogleChart googleChart = new GoogleChart();
		googleChart.setData(expression.getData(), max);
		return googleChart.buildUrl();
	}
}
