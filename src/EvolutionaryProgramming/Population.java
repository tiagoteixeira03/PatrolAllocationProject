package EvolutionaryProgramming;

import java.util.Comparator;
import java.util.Iterator;
import java.util.PriorityQueue;

public class Population {
	private static Population instance;
	int numIndvInit;
	int numIndivMax;
	TimeIncrementStrategy timeincr;
	
	Comparator<Individual> com = new Comparator<Individual>()
	{
			@Override
			public int compare(Individual i1, Individual i2) {
				double f1 = i1.fitting, f2 = i2.fitting;
				if(f1>f2) 
					return 1;
				else if(f1==f2)
					return 0;
				else
					return -1;
			}
	};
	
	private PriorityQueue<Individual> pop = new PriorityQueue<Individual>(com);
	
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
		if(pop.size() >= numIndivMax) {
			
		}
	}
	
	public void removeIndfromPop(Individual ind) {
		pop.remove(ind);
	}
	
	public void startEpidemic() {
		Individual currentInd;
		timeincr = EvolutionaryProgramming.strategiesMap.get("Epidemic");
		for(int i=0; i<5; i++) {
			it.next();
		}
		while(it.hasNext()) {
			currentInd = it.next();
			if(timeincr.getRandomTime(currentInd.fitting) == 1){
				continue;
			}
			else {
				currentInd.killIndividual();
			}
		}
	}
}
