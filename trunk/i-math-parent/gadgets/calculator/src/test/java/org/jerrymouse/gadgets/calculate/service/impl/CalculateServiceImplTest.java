package org.jerrymouse.gadgets.calculate.service.impl;

import org.jerrymouse.gadgets.calculator.service.CalculateService;
import org.nfunk.jep.function.Sine;

import junit.framework.TestCase;

public class CalculateServiceImplTest extends TestCase {
	CalculateService calculateService;

	@Override
	protected void setUp() throws Exception {
		super.setUp();
		calculateService = new CalculateServiceImpl();
	}

	public void testValue() throws Exception {
		System.out.println(calculateService.calculate("1+cos(2)"));
	}

	public void testValue1() throws Exception {
		calculateService.setExpression("1+x");
		System.out.println(calculateService.value(1));
	}

	public void testValue2() throws Exception {
		System.out.println(calculateService.value("1+x",1));
	}
}
