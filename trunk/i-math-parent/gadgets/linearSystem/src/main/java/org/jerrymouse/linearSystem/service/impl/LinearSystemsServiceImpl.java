package org.jerrymouse.linearSystem.service.impl;

import java.util.ArrayList;
import java.util.List;

import org.apache.commons.math.linear.RealMatrix;
import org.apache.commons.math.linear.RealMatrixImpl;
import org.apache.commons.math.linear.RealVector;
import org.apache.commons.math.linear.RealVectorImpl;
import org.apache.commons.math.linear.decomposition.DecompositionSolver;
import org.apache.commons.math.linear.decomposition.LUDecompositionImpl;
import org.jerrymouse.linearSystem.service.LinearSystemsService;

public class LinearSystemsServiceImpl implements LinearSystemsService {

	@Override
	public List<Double> getSolution(List<List<Double>> a, List<Double> b) {
		// TODO Auto-generated method stub
		double[][] c = new double[a.size()][a.get(0).size()];
		double[] d = new double[b.size()];
		List<Double> result = new ArrayList<Double>();
		for (int i = 0; i < a.size(); i++) {
			for (int j = 0; j < a.get(i).size(); j++) {
				c[i][j] = a.get(i).get(j);
			}
		}

		for (int i = 0; i < b.size(); i++) {
			d[i] = b.get(i);
		}

		RealMatrix coefficients = new RealMatrixImpl(c);
		DecompositionSolver solver = new LUDecompositionImpl(coefficients)
				.getSolver();
		RealVector constants = new RealVectorImpl(d, false);
		RealVector solution = solver.solve(constants);
		System.out.print("hi");
		for (int i = 0; i < c.length; i++) {
			for (int j = 0; j < c[i].length; j++) {
				System.out.print(c[i][j]);
				System.out.print(" ");
			}
			System.out.println();
		}
		for (int i = 0; i < d.length; i++) {
			System.out.println(d[i]);
		}
		System.out.println(solution.getEntry(0));
		for (Double double1 : solution.getData()) {
			result.add(double1);
		}
		return result;
	}

}
