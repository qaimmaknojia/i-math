package org.jerrymouse.univariateFunction.service;

public interface UnivariateFunctionService {

	public static final String BisectionSolver = "bisectionSolver",
			SecantSolver = "secantSolver", NewtonSolver = "newtonSolver",
			MullerSolver = "mullerSolver", LaguerreSolver = "laguerreSolver",
			RidderSolver = "ridderSolver";

	double getRootOfFunction(String expression, double min, double max,
			String solver);

}
