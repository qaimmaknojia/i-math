package org.jerrymouse.googleChart.bean;

import java.util.Arrays;
import java.util.List;

import junit.framework.TestCase;

public class GoogleChartTest extends TestCase {
	GoogleChart googleChart;

	protected void setUp() throws Exception {
		super.setUp();
		googleChart = new GoogleChart();
	}

	public void testSize() throws Exception {
		System.out.println(googleChart.buildUrl());
	}

	public void testData() throws Exception {
		List<Double> data = Arrays.asList(0.0, 1.0, 4.0, 4.0, 6.0, 11.0, 14.0, 17.0, 23.0, 28.0,
				33.0, 36.0, 43.0, 59.0, 65.0);
		googleChart.setData(data, 70);
		System.out.println(googleChart.buildUrl());
	}
}
