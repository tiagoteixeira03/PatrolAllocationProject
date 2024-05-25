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
	
	public static Population getInstance() {
		if(instance==null) {
			instance = new Population(EvolutionaryProgramming.initPopSize, EvolutionaryProgramming.popMaxSize);
		}
		return instance;
	}
	
	public void addIndtoPop(Individual ind) {
		pop.add(ind);
	}
	
	public void removeIndfromPop(Individual ind) {
		pop.remove(ind);
	}
}
