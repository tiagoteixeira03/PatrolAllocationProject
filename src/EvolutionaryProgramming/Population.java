package EvolutionaryProgramming;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.Iterator;
import java.util.PriorityQueue;

/**
 * Class that represents a population of individuals.
 * It manages the individuals within the population.
 */
public class Population {
    /** The singleton instance of the Population class. */
	private static Population instance;
    /** The initial number of individuals in the population. */
	int numIndvInit;
    /** The maximum number of individuals allowed in the population. */
	int numIndivMax;
    /** The list of individuals in the population. */
	TimeIncrementStrategy timeincr;
	
	int currentIndID=0, numEpidemics=0;
	
    /** Comparator for sorting individuals in the population by comfort. */
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
	
    /** The priority queue of individuals in the population, sorted by comfort. */
	private PriorityQueue<Individual> pop = new PriorityQueue<Individual>(com);
	
	/** Iterator for traversing the population. */
	Iterator<Individual> it = pop.iterator();
	
	/**
     * Constructs the Population class.
     * 
     * @param numIndivInit_ the initial number of individuals in the population
     * @param numIndivMax_ the maximum number of individuals allowed in the population
     */
	private Population(int numIndivInit_, int numIndivMax_) {
		numIndvInit = numIndivInit_;
		numIndivMax = numIndivMax_;	
	}
	
	/**
     * Retrieves the singleton instance of the Population class.
     * 
     * @return the singleton instance of the Population class
     */
	public static Population getInstance() {
		if(instance==null) {
			instance = new Population(EvolutionaryProgramming.initPopSize, EvolutionaryProgramming.popMaxSize);
		}
		return instance;
	}
	
	/**
     * Adds an individual to the population.
     * 
     * @param ind the individual to be added to the population
     */
	public void addIndtoPop(Individual ind) {
		pop.add(ind);
		currentIndID++;
		if(pop.size() >= numIndivMax) {
			startEpidemic();
		}
	}
	
	/**
     * Removes an individual from the population.
     * 
     * @param ind the individual to be removed from the population
     */
	public void removeIndfromPop(Individual ind) {
		pop.remove(ind);
	}
	
	/**
     * Initiates an epidemic in the population, killing individuals.
     */
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
		it = pop.iterator();
		numEpidemics++;
	}
	
	public ArrayList<Solution> getBestInds() {
		ArrayList<Solution> bestInds = new ArrayList<>();
		for(int i=0; i<6; i++) {
			bestInds.add(it.next().solution);
		}
		return bestInds;
	}
}
