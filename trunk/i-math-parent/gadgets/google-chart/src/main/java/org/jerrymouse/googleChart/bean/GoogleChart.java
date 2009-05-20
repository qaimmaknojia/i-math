package org.jerrymouse.googleChart.bean;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class GoogleChart {
	private static final String urlBase = "http://chart.apis.google.com/chart";

	private Map<String, String> params = new HashMap<String, String>();

	public GoogleChart() {
		initParams();
	}

	private void initParams() {
		setType("lc");
		setSize(400, 300);
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

	public void setData(List<Double> valueArray, double maxValue) {
		String data = ChartEncoder.getChartEncoder().encode(valueArray,
				maxValue);
		params.put("chd", data);
	}
}
