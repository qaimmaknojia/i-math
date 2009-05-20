package org.jerrymouse.googleChart.bean;

import java.util.List;

public class ChartEncoder {
	private static ChartEncoder chartEncoder = new ChartEncoder();
	private static final String simpleEncoding = "ABCDEFGHIJKLMNOPQRSTUVWXYZabcdefghijklmnopqrstuvwxyz0123456789";

	String encode(List<Double> valueArray, double maxValue) {
		String chartData = "s:";
		for (Double currentValue : valueArray) {
			if (currentValue >= 0) {
				chartData += simpleEncoding.charAt((int) (Math
						.round(simpleEncoding.length() - 1)
						* currentValue / maxValue));
			} else
				chartData += "_";

		}
		return chartData;
	}

	public static ChartEncoder getChartEncoder() {
		return chartEncoder;
	}
}
