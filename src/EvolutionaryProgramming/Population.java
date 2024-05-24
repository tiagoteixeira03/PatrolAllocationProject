package EvolutionaryProgramming;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class Population {
	private static Population instance;
	int numIndvInit;
	int numIndivMax;
	private List<Individual> pop = new ArrayList<Individual>();
	
	Iterator<Individual> it = pop.iterator();
	
	private Population(int numIndivInit_, int numIndivMax_) {
		numIndvInit = numIndivInit_;
		numIndivMax = numIndivMax_;	
	}
	
	public static Population getInstance(int numIndivInit, int numIndivMax) {
		if(instance==null) {
			instance = new Population(numIndivInit, numIndivMax);
		}
		return instance;
	}
}
