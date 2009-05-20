package org.jerrymouse.googleChart.service;

import java.util.List;

public interface ChartService {
	public String draw(List<Double> datas, double min, double max, double step);
	
	public String draw(String expression,double min, double max, double step);
}
