package org.jerrymouse.distribution.service.impl;

import org.apache.commons.math.MathException;
import org.apache.commons.math.distribution.BetaDistributionImpl;
import org.apache.commons.math.distribution.BinomialDistributionImpl;
import org.apache.commons.math.distribution.CauchyDistributionImpl;
import org.apache.commons.math.distribution.ChiSquaredDistributionImpl;
import org.apache.commons.math.distribution.ContinuousDistribution;
import org.apache.commons.math.distribution.Distribution;
import org.apache.commons.math.distribution.ExponentialDistribution;
import org.apache.commons.math.distribution.ExponentialDistributionImpl;
import org.apache.commons.math.distribution.FDistributionImpl;
import org.apache.commons.math.distribution.GammaDistributionImpl;
import org.apache.commons.math.distribution.HypergeometricDistributionImpl;
import org.apache.commons.math.distribution.NormalDistributionImpl;
import org.apache.commons.math.distribution.PascalDistributionImpl;
import org.apache.commons.math.distribution.PoissonDistributionImpl;
import org.apache.commons.math.distribution.TDistributionImpl;
import org.apache.commons.math.distribution.WeibullDistributionImpl;
import org.apache.commons.math.distribution.ZipfDistributionImpl;
import org.jerrymouse.distribution.service.PostiveDistributionService;

public class PostiveDistributionServiceImpl implements
		PostiveDistributionService {
	@Override
	public double getBetaDistribution(double alpha, double beta, double x) {
		Distribution distribution = new BetaDistributionImpl(alpha, beta);
		return getCumulativeProbability(distribution, x);
	}

	@Override
	public double getBinomialDistribution(double p, int n, double x) {
		Distribution distribution = new BinomialDistributionImpl(n, p);
		return getCumulativeProbability(distribution, x);
	}

	@Override
	public double getCauchyDistribution(double median, double s, double x) {
		Distribution distribution = new CauchyDistributionImpl(median, s);
		return getCumulativeProbability(distribution, x);
	}

	@Override
	public double getChiSquaredDistribution(double df, double x) {
		Distribution distribution = new ChiSquaredDistributionImpl(df);
		return getCumulativeProbability(distribution, x);
	}

	private double getCumulativeProbability(Distribution distribution, double x) {
		double res = 0;
		try {
			res = distribution.cumulativeProbability(x);
		} catch (MathException e) {
			e.printStackTrace();
		}
		return res;
	}

	@Override
	public double getExponentialDistribution(double sita, double x) {
		ExponentialDistribution exponentialDistribution = new ExponentialDistributionImpl(
				sita);
		return getCumulativeProbability(exponentialDistribution, x);
	}

	@Override
	public double getFDistribution(double numeratorDegreesOfFreedom,
			double denominatorDegreesOfFreedom, double x) {
		Distribution distribution = new FDistributionImpl(
				numeratorDegreesOfFreedom, denominatorDegreesOfFreedom);
		return getCumulativeProbability(distribution, x);
	}

	@Override
	public double getGammaDistribution(double alpha, double beta, double x) {
		Distribution distribution = new GammaDistributionImpl(alpha, beta);
		return getCumulativeProbability(distribution, x);
	}

	@Override
	public double getHypergeometricDistribution(int p, int n, int s, double x) {
		Distribution distribution = new HypergeometricDistributionImpl(p, n, s);
		return getCumulativeProbability(distribution, x);
	}

	@Override
	public double getNormalDistribution(double d, double m, double x) {
		ContinuousDistribution normalDistribution = new NormalDistributionImpl(
				m, d);
		return getCumulativeProbability(normalDistribution, x);
	}

	@Override
	public double getPascalDistribution(int r, double p, double x) {
		Distribution distribution = new PascalDistributionImpl(r, p);
		return getCumulativeProbability(distribution, x);
	}

	@Override
	public double getPoissonDistribution(double p, double x) {
		Distribution distribution = new PoissonDistributionImpl(p);
		return getCumulativeProbability(distribution, x);
	}

	@Override
	public double getStandardNormalDistribution(double x) {
		return getNormalDistribution(1, 0, x);
	}

	@Override
	public double getTDistribution(double degreesOfFreedom, double x) {
		Distribution distribution = new TDistributionImpl(degreesOfFreedom);
		return getCumulativeProbability(distribution, x);
	}

	@Override
	public double getWeibullDistribution(double alpha, double beta, double x) {
		Distribution distribution = new WeibullDistributionImpl(alpha, beta);
		return getCumulativeProbability(distribution, x);
	}

	@Override
	public double getZipfDistribution(int numberOfElements, double exponent,
			double x) {
		Distribution distribution = new ZipfDistributionImpl(numberOfElements,
				exponent);
		return getCumulativeProbability(distribution, x);
	}

}
