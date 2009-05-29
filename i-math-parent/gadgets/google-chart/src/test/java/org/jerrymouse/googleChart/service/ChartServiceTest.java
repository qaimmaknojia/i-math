package org.jerrymouse.googleChart.service;

import org.jerrymouse.googleChart.service.impl.ChartServiceImpl;

import junit.framework.TestCase;

public class ChartServiceTest extends TestCase {
	ChartService chartService;

	@Override
	protected void setUp() throws Exception {
		super.setUp();
		chartService = new ChartServiceImpl();
	}

	public void testDraw() throws Exception {
		System.out.println(chartService.draw("sin(x)+1", -6, 6));
	}
}
