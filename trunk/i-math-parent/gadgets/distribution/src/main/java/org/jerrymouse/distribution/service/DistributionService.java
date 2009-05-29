package org.jerrymouse.distribution.service;

public interface DistributionService {
	double getNormalDistribution(double d, double m, double x);

	double getStandardNormalDistribution(double x);

	double getBinomialDistribution(double p, int n, double x);

	double getExponentialDistribution(double sita, double x);

	double getHypergeometricDistribution(int p, int n, int s, double x);

	double getTDistribution(double degreesOfFreedom, double x);

	double getInverseNormalDistribution(double d, double m, double x);

	double getInverseStandardNormalDistribution(double x);

	double getInverseExponentialDistribution(double sita, double x);

	double getInverseBinomialDistribution(double p, int n, double x);

	double getInverseTDistribution(double degreesOfFreedom, double x);

}
