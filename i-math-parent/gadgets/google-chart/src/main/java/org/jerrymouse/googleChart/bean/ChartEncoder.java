package org.jerrymouse.googleChart.bean;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class ChartEncoder {
	private static ChartEncoder chartEncoder = new ChartEncoder();
	private static final String simpleEncoding = "ABCDEFGHIJKLMNOPQRSTUVWXYZabcdefghijklmnopqrstuvwxyz0123456789";

	String encode(List<Double> valueArray, double cha) {
		List<Double> values = new ArrayList<Double>();
		double min = Collections.min(valueArray);
		double max = Collections.max(valueArray);
		for (Double double1 : valueArray) {
			values.add(double1 - min);
		}
		String chartData = "s:";
		for (Double currentValue : values) {
			if (currentValue >= 0) {
				chartData += simpleEncoding.charAt((int) (Math
						.round(simpleEncoding.length() - 1)
						* currentValue / (max-min)));
			} else
				chartData += "_";

		}
		return chartData;
	}

	public static String getSimpleEncoding() {
		return simpleEncoding;
	}

	public static void setChartEncoder(ChartEncoder chartEncoder) {
		ChartEncoder.chartEncoder = chartEncoder;
	}

	public static ChartEncoder getChartEncoder() {
		return chartEncoder;
	}
}
