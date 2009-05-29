package org.jerrymouse.univariateFunction.service.impl;

import org.apache.commons.math.MathException;
import org.apache.commons.math.analysis.UnivariateRealFunction;
import org.apache.commons.math.analysis.solvers.BisectionSolver;
import org.apache.commons.math.analysis.solvers.LaguerreSolver;
import org.apache.commons.math.analysis.solvers.MullerSolver;
import org.apache.commons.math.analysis.solvers.NewtonSolver;
import org.apache.commons.math.analysis.solvers.RiddersSolver;
import org.apache.commons.math.analysis.solvers.SecantSolver;
import org.apache.commons.math.analysis.solvers.UnivariateRealSolverImpl;
import org.jerrymouse.gadgets.calculate.service.impl.CalculateServiceImpl;
import org.jerrymouse.gadgets.calculator.service.CalculateService;
import org.jerrymouse.univariateFunction.UnivariateFunctionService;
import org.jerrymouse.univariateFunction.bean.Function;

public class UnivariateFunctionServiceImpl implements UnivariateFunctionService {

	@Override
	public double getFunctionValue(String expression, double variableValue) {
		// TODO Auto-generated method stub
		CalculateService calculate = new CalculateServiceImpl();
		return calculate.value(expression, variableValue);
	}

	@Override
	public double getRootOfFunction(String expression, double min, double max,
			double startValue, String solver) throws MathException {
		UnivariateRealFunction fun = new Function(expression);
		UnivariateRealSolverImpl funSolver = getSolver(solver);
		double result = funSolver.solve(fun, min, max, startValue);
		return result;
	}

	private UnivariateRealSolverImpl getSolver(String solver) {
		UnivariateRealSolverImpl s = null;
		if (solver.equals(UnivariateFunctionService.BisectionSolver)) {
			s = new BisectionSolver();
		} else if (solver.equals(UnivariateFunctionService.SecantSolver)) {
			s = new SecantSolver();
		} else if (solver.equals(UnivariateFunctionService.MullerSolver)) {
			s = new MullerSolver();
		} else if (solver.equals(UnivariateFunctionService.LaguerreSolver)) {
			s = new LaguerreSolver();
		} else if (solver.equals(UnivariateFunctionService.RidderSolver)) {
			s = new RiddersSolver();
		} else if (solver.equals(UnivariateFunctionService.NewtonSolver)) {
			s = new NewtonSolver();
		}
		return s;
	}

	public double getRootOfFunction(String expression, double min, double max,
			double startValue) throws MathException {
		UnivariateRealFunction fun = new Function(expression);
		UnivariateRealSolverImpl funSolver = new BisectionSolver();
		double result = funSolver.solve(fun, min, max, startValue);
		return result;

	}

	public double getRootOfFunction(String expression, double min, double max)
			throws MathException {
		UnivariateRealFunction fun = new Function(expression);
		UnivariateRealSolverImpl funSolver = getSolver(BisectionSolver);
		return funSolver.solve(fun, min, max);
	}

	public double getRootOfFunction(String expression, double min, double max,
			String solver) throws MathException {
		UnivariateRealFunction fun = new Function(expression);
		UnivariateRealSolverImpl funSolver = getSolver(solver);
		return funSolver.solve(fun, min, max);
	}
}
