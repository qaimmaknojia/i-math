package org.jerrymouse.googleChart.bean;

import java.text.DecimalFormat;
import java.util.Collection;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class GoogleChart {
	private static final String urlBase = "http://chart.apis.google.com/chart";

	private Map<String, String> params = new HashMap<String, String>();
	private DecimalFormat decimalFormat=new DecimalFormat(".##");

	public GoogleChart() {
		initParams();
	}

	private void initParams() {
		setType("lc");
		setSize(400, 300);
		setXT();
	}

	private void setXT() {
		params.put("chxt", "x,y");
	}

	private void setType(String type) {
		params.put("cht", type);
	}

	void setSize(int lenth, int height) {
		params.put("chs", lenth + "x" + height);
	}

	public String buildUrl() {
		StringBuilder stringBuilder = new StringBuilder();
		stringBuilder.append(urlBase);
		stringBuilder.append("?");
		for (Map.Entry<String, String> entry : params.entrySet()) {
			stringBuilder.append(entry.getKey());
			stringBuilder.append("=");
			stringBuilder.append(entry.getValue());
			stringBuilder.append("&");
		}
		stringBuilder.deleteCharAt(stringBuilder.length() - 1);
		return stringBuilder.toString();
	}

	public void setData(List<Double> valueArray, double minValue,
			double maxValue, double step) {
		String data = ChartEncoder.getChartEncoder().encode(valueArray,
				maxValue - minValue);
		params.put("chd", data);
		String x = "";
		x += setX(minValue, maxValue, step);
		x += setY(valueArray);
		params.put("chxl", x);
	}

	private String setY(List<Double> valueArray) {
		String x = "1:|";
		double max = Collections.max(valueArray);
		double min = Collections.min(valueArray);
		for (double i = min; i < max; i += (max - min) / 5) {
			x += formate(i) + "|";
		}
		return x;
	}

	// chxl=
	// 0:|Jan|July|Jan|July|Jan|
	// 1:|0|50|100|
	// 2:|A|B|C|
	// 3:|2005|2006|2007

	private String setX(double minValue, double maxValue, double step) {
		String x = "0:|";
		for (double i = minValue; i < maxValue; i += (maxValue - minValue) / 10) {
			x += formate(i) + "|";
		}
		return x;
	}

	private String formate(double i) {
		return decimalFormat.format(i);
	}

}
