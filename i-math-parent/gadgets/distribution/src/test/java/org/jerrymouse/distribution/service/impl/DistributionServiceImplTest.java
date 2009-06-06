package org.jerrymouse.distribution.service.impl;

import junit.framework.TestCase;

public class DistributionServiceImplTest extends TestCase {
	DistributionServiceImpl distributionService;

	@Override
	protected void setUp() throws Exception {
		super.setUp();
		distributionService = new DistributionServiceImpl();
	}

	public void testNormalDistribution() throws Exception {
		System.out
				.println(distributionService.getStandardNormalDistribution(2));
	}

	public void testExponentialDistribution() throws Exception {
		System.out
				.println(distributionService.getExponentialDistribution(1, 1));
	}

	public void testINormalDistribution() throws Exception {
		System.out.println(distributionService
				.getInverseStandardNormalDistribution(0.9772));
	}

	public void testBinomialDistribution() throws Exception {
		System.out.println(distributionService.getBinomialDistribution(0.2, 20,
				16));
	}

}
