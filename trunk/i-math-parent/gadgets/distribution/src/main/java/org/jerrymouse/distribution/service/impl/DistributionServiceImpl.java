package org.jerrymouse.distribution.service.impl;

import org.jerrymouse.distribution.service.InverseDistributionService;
import org.jerrymouse.distribution.service.PostiveDistributionService;

public class DistributionServiceImpl implements PostiveDistributionService,
		InverseDistributionService {
	PostiveDistributionService postiveDistributionService;
	InverseDistributionService inverseDistributionService;

	public DistributionServiceImpl() {
		postiveDistributionService = new PostiveDistributionServiceImpl();
		inverseDistributionService = new InverseDistributionServiceImpl();
	}

	@Override
	public double getBetaDistribution(double alpha, double beta, double x) {
		return postiveDistributionService.getBetaDistribution(alpha, beta, x);
	}

	@Override
	public double getBinomialDistribution(double p, int n, double x) {
		return postiveDistributionService.getBinomialDistribution(p, n, x);
	}

	@Override
	public double getCauchyDistribution(double median, double s, double x) {
		return postiveDistributionService.getCauchyDistribution(median, s, x);
	}

	@Override
	public double getChiSquaredDistribution(double df, double x) {
		return postiveDistributionService.getChiSquaredDistribution(df, x);
	}

	@Override
	public double getExponentialDistribution(double sita, double x) {
		return postiveDistributionService.getExponentialDistribution(sita, x);
	}

	@Override
	public double getFDistribution(double numeratorDegreesOfFreedom,
			double denominatorDegreesOfFreedom, double x) {
		return postiveDistributionService.getFDistribution(numeratorDegreesOfFreedom, denominatorDegreesOfFreedom, x);
	}

	@Override
	public double getGammaDistribution(double alpha, double beta, double x) {
		return postiveDistributionService.getGammaDistribution(alpha, beta, x);
	}

	@Override
	public double getHypergeometricDistribution(int p, int n, int s, double x) {
		return postiveDistributionService.getHypergeometricDistribution(p, n,
				s, x);
	}

	@Override
	public double getInverseBinomialDistribution(double p, int n, double x) {
		return inverseDistributionService.getInverseBinomialDistribution(p, n,
				x);
	}

	@Override
	public double getInverseExponentialDistribution(double sita, double x) {
		return inverseDistributionService.getInverseExponentialDistribution(
				sita, x);
	}

	@Override
	public double getInverseNormalDistribution(double d, double m, double x) {
		return inverseDistributionService.getInverseNormalDistribution(d, m, x);
	}

	@Override
	public double getInverseStandardNormalDistribution(double x) {
		return inverseDistributionService
				.getInverseStandardNormalDistribution(x);
	}

	@Override
	public double getInverseTDistribution(double degreesOfFreedom, double x) {
		return inverseDistributionService.getInverseTDistribution(
				degreesOfFreedom, x);
	}

	@Override
	public double getNormalDistribution(double d, double m, double x) {
		return postiveDistributionService.getNormalDistribution(d, m, x);
	}

	@Override
	public double getPascalDistribution(int r, double p, double x) {
		return postiveDistributionService.getPascalDistribution(r, p, x);
	}

	@Override
	public double getPoissonDistribution(double p, double x) {
		return postiveDistributionService.getPoissonDistribution(p, x);
	}

	@Override
	public double getStandardNormalDistribution(double x) {
		return postiveDistributionService.getStandardNormalDistribution(x);
	}

	@Override
	public double getTDistribution(double degreesOfFreedom, double x) {
		return postiveDistributionService.getTDistribution(degreesOfFreedom, x);
	}

	@Override
	public double getWeibullDistribution(double alpha, double beta, double x) {
		return postiveDistributionService.getWeibullDistribution(alpha, beta, x);
	}

	@Override
	public double getZipfDistribution(int numberOfElements, double exponent,
			double x) {
		return postiveDistributionService.getZipfDistribution(numberOfElements, exponent, x);
	}

}
