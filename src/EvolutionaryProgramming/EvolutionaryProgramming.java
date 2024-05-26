package EvolutionaryProgramming;

import java.util.HashMap;

public class EvolutionaryProgramming {
	static int initPopSize;
	static int popMaxSize;
	static HashMap<String, TimeIncrementStrategy> strategiesMap = new HashMap<>();
	static Solution solution;
	
	public static void init(int initPopSize_, int popMaxSize_, Solution solution_) {
		initPopSize = initPopSize_;
		popMaxSize = popMaxSize_;
		solution = solution_;
	}
	
	public void setStrategy(String s, TimeIncrementStrategy strategy) {
		strategiesMap.put(s, strategy);
	}
}
