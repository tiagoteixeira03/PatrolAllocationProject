package EvolutionaryProgramming;

import java.util.HashMap;

public class EvolutionaryProgramming {
	static int initPopSize;
	static int popMaxSize;
	static HashMap<TimeIncrementStrategy, String> strategiesMap = new HashMap<>();
	
	public static void init(int initPopSize_, int popMaxSize_) {
		initPopSize = initPopSize_;
		popMaxSize = popMaxSize_;
	}
	
	public void setStrategy(String s, TimeIncrementStrategy strategy) {
		strategiesMap.put(strategy, s);
	}
}
