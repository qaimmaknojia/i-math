package org.jerrymouse.linearSystem.service;

import java.util.List;

public interface LinearSystemsService {
	List<Double> getSolution(List<List<Double>> a, List<Double> b);
}
