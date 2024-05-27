package EvolutionaryProgramming;

import java.util.HashMap;

import DiscreteStochasticSimulation.EventManager;

public class EvolutionaryProgramming {
	static int initPopSize;
	static int popMaxSize;
	static HashMap<String, TimeIncrementStrategy> strategiesMap = new HashMap<>();
	static Solution solution;
	static EventManager eventmanager;
	static Individual ind;
	
	public static void init(int initPopSize_, int popMaxSize_, Solution solution_, EventManager eventmanager_) {
		initPopSize = initPopSize_;
		popMaxSize = popMaxSize_;
		solution = solution_;
		eventmanager = eventmanager_;
		for(int i=0; i<initPopSize; i++) {
			ind = new Individual(eventmanager, solution.getSolutionObject());
			ind.newIndividual();
		}
	}
	
	public void setStrategy(String s, TimeIncrementStrategy strategy) {
		strategiesMap.put(s, strategy);
	}
}
