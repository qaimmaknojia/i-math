package org.jerrymouse.distribution.service;

public interface PostiveDistributionService {

	double getBetaDistribution(double alpha, double beta, double x);

	double getBinomialDistribution(double p, int n, double x);

	double getCauchyDistribution(double median, double s, double x);

	double getChiSquaredDistribution(double df, double x);

	double getExponentialDistribution(double sita, double x);

	double getFDistribution(double numeratorDegreesOfFreedom,
			double denominatorDegreesOfFreedom, double x);

	double getGammaDistribution(double alpha, double beta, double x);

	double getHypergeometricDistribution(int p, int n, int s, double x);

	double getNormalDistribution(double d, double m, double x);

	double getPascalDistribution(int r, double p, double x);

	double getPoissonDistribution(double p, double x);

	double getStandardNormalDistribution(double x);

	double getTDistribution(double degreesOfFreedom, double x);

	double getWeibullDistribution(double alpha, double beta, double x);

	double getZipfDistribution(int numberOfElements, double exponent, double x);

}
