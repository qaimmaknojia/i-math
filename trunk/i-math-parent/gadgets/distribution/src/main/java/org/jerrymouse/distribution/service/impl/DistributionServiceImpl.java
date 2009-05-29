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
import org.jerrymouse.distribution.service.DistributionService;

public class DistributionServiceImpl implements DistributionService {

	@Override
	public double getNormalDistribution(double d, double m, double x) {
		ContinuousDistribution normalDistribution = new NormalDistributionImpl(
				m, d);
		return getCumulativeProbability(normalDistribution, x);
	}

	@Override
	public double getStandardNormalDistribution(double x) {
		return getNormalDistribution(1, 0, x);
	}

	@Override
	public double getExponentialDistribution(double sita, double x) {
		ExponentialDistribution exponentialDistribution = new ExponentialDistributionImpl(
				sita);
		return getCumulativeProbability(exponentialDistribution, x);
	}

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

	private double getCumulativeProbability(Distribution distributionm, double x) {
		double res = 0;
		try {
			res = distributionm.cumulativeProbability(x);
		} catch (MathException e) {
			e.printStackTrace();
		}
		return res;
	}

	private double getInverseCumulativeProbability(
			ContinuousDistribution distributionm, double x) {
		double res = 0;
		try {
			res = distributionm.inverseCumulativeProbability(x);
		} catch (MathException e) {
			e.printStackTrace();
		}
		return res;
	}

	@Override
	public double getBinomialDistribution(double p, int n, double x) {
		Distribution distribution = new BinomialDistributionImpl(n, p);
		return getCumulativeProbability(distribution, x);
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
	public double getHypergeometricDistribution(int p, int n, int s, double x) {
		Distribution distribution = new HypergeometricDistributionImpl(p, n, s);
		return getCumulativeProbability(distribution, x);
	}

	@Override
	public double getTDistribution(double degreesOfFreedom, double x) {
		Distribution distribution = new TDistributionImpl(degreesOfFreedom);
		return getCumulativeProbability(distribution, x);
	}

}
