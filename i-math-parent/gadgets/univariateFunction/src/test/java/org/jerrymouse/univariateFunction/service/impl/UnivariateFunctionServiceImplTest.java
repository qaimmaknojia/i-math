package org.jerrymouse.univariateFunction.service.impl;

import junit.framework.TestCase;

import org.jerrymouse.univariateFunction.service.UnivariateFunctionService;

public class UnivariateFunctionServiceImplTest extends TestCase {
	UnivariateFunctionService univariateFunctionService;

	@Override
	protected void setUp() throws Exception {
		super.setUp();
		univariateFunctionService = new UnivariateFunctionServiceImpl();
	}

	public void testS() throws Exception {
		System.out.println(univariateFunctionService.getRootOfFunction("1-x",
				0, 100, UnivariateFunctionService.BisectionSolver));
	}
}
