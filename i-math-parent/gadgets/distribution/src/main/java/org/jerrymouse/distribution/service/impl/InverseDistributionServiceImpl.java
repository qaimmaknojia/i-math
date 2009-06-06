package org.jerrymouse.distribution.service.impl;

import org.apache.commons.math.MathException;
import org.apache.commons.math.distribution.BinomialDistributionImpl;
import org.apache.commons.math.distribution.ContinuousDistribution;
import org.apache.commons.math.distribution.Distribution;
import org.apache.commons.math.distribution.ExponentialDistribution;
import org.apache.commons.math.distribution.ExponentialDistributionImpl;
import org.apache.commons.math.distribution.HypergeometricDistributionImpl;
import org.apache.commons.math.distribution.NormalDistributionImpl;
import org.apache.commons.math.distribution.TDistributionImpl;
import org.jerrymouse.distribution.service.InverseDistributionService;

public class InverseDistributionServiceImpl implements
		InverseDistributionService {
	@Override
	public double getInverseNormalDistribution(double d, double m, double x) {
		ContinuousDistribution normalDistribution = new NormalDistributionImpl(
				m, d);
		return getInverseCumulativeProbability(normalDistribution, x);
	}

	@Override
	public double getInverseStandardNormalDistribution(double x) {
		return getInverseNormalDistribution(1, 0, x);
	}

	@Override
	public double getInverseExponentialDistribution(double sita, double x) {
		ExponentialDistribution exponentialDistribution = new ExponentialDistributionImpl(
				sita);
		return getInverseCumulativeProbability(exponentialDistribution, x);
	}

	private double getInverseCumulativeProbability(
			ContinuousDistribution distribution, double x) {
		double res = 0;
		try {
			res = distribution.inverseCumulativeProbability(x);
		} catch (MathException e) {
			e.printStackTrace();
		}
		return res;
	}

	@Override
	public double getInverseBinomialDistribution(double p, int n, double x) {
		BinomialDistributionImpl distribution = new BinomialDistributionImpl(n,
				p);
		double res = 0;
		try {
			res = distribution.inverseCumulativeProbability(x);
		} catch (MathException e) {
			e.printStackTrace();
		}
		return res;
	}

	@Override
	public double getInverseTDistribution(double degreesOfFreedom, double x) {
		ContinuousDistribution distribution = new TDistributionImpl(
				degreesOfFreedom);
		return getInverseCumulativeProbability(distribution, x);
	}
}
