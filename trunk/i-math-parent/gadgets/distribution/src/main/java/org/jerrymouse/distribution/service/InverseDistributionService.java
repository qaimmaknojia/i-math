package org.jerrymouse.distribution.service;

public interface InverseDistributionService {
	double getInverseNormalDistribution(double d, double m, double x);

	double getInverseStandardNormalDistribution(double x);

	double getInverseExponentialDistribution(double sita, double x);

	double getInverseBinomialDistribution(double p, int n, double x);

	double getInverseTDistribution(double degreesOfFreedom, double x);
}
