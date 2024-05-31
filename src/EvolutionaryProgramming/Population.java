package EvolutionaryProgramming;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.Iterator;
import java.util.List;
import java.util.PriorityQueue;

/**
 * Class that represents a population of individuals.
 * It manages the individuals within the population.
 */
public class Population {
    /** The singleton instance of the Population class. */
	private static Population instance;
    /** The initial number of individuals in the population. */
	static int numIndvInit = EvolutionaryProgramming.initPopSize;
    /** The maximum number of individuals allowed in the population. */
	static int numIndivMax = EvolutionaryProgramming.popMaxSize;
	
	double bestFitting=0;
	Solution bestSol;
	int bestID;
	
	int currentIndID=0, numEpidemics=0;
	
    /** Comparator for sorting individuals in the population by comfort. */
	Comparator<Individual> com = new Comparator<Individual>()
	{
			@Override
			public int compare(Individual i1, Individual i2) {
				double f1 = i1.fitting, f2 = i2.fitting;
				if(f1<f2) 
					return 1;
				else if(f1==f2)
					return 0;
				else
					return -1;
			}
	};
	
    /** The priority queue of individuals in the population, sorted by comfort. */
	private PriorityQueue<Individual> pop = new PriorityQueue<Individual>(com);
	
	/**
     * Constructs the Population class.
     * 
     * @param numIndivInit_ the initial number of individuals in the population
     * @param numIndivMax_ the maximum number of individuals allowed in the population
     */
	private Population() {
			
	}
	
	/**
     * Retrieves the singleton instance of the Population class.
     * 
     * @return the singleton instance of the Population class
     */
	public static Population getInstance() {
		if(instance==null) {
			instance = new Population();
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
		if(ind.fitting > bestFitting) {
			bestSol = ind.solution.cloneObject();
			bestFitting = bestSol.getFitting();
			bestID = ind.id;
		}
		if(pop.size() >= EvolutionaryProgramming.popMaxSize) {
			startEpidemic();
		}
	}
	
	public void updateIndPosition(Individual ind) {
		pop.remove(ind);
		pop.add(ind);
	}
	
	/**
     * Removes an individual from the population.
     * 
     * @param ind the individual to be removed from the population
     */
	public void removeIndfromPop(Individual ind) {
		pop.remove(ind);
		currentIndID--;
	}
	
	/**
     * Initiates an epidemic in the population, killing individuals.
     */
	public void startEpidemic() {
		Individual currentInd;
		TimeIncrementStrategy timeincr = EvolutionaryProgrammingFactory.strategiesMap.get("Epidemic");
		ArrayList<Individual> bestInds = new ArrayList<Individual>(5);
		List<Individual> survivingInds = new ArrayList<Individual>(EvolutionaryProgramming.popMaxSize);
		
		for(int i=0; i<5; i++) {
			bestInds.add(pop.poll());
		}
		while(!pop.isEmpty()) {
			currentInd = pop.poll();
			if(timeincr.getRandomTime(currentInd.fitting) == 1){
				survivingInds.add(currentInd);
				continue;
			}
			else {
				currentInd.killIndividualEpidemic();
			}
		}
		numEpidemics++;
		Iterator<Individual> it = survivingInds.iterator();
		
		while(it.hasNext()) {
			pop.add(it.next());
		}
		
		for(int i=0; i<5; i++) {
			pop.add(bestInds.get(i));
		}
	}
	
	public ArrayList<Solution> getBestInds() {
	    ArrayList<Solution> bestInds = new ArrayList<>(6);
	    ArrayList<Individual> inds = new ArrayList<>();
	    Individual ind;
	    Boolean isSolValid=true;

	    // Poll individuals from pop and add to inds list
	    bestInds.add(bestSol);
	    for(int i = 0; i < 5; i++) {
	        if(!pop.isEmpty()) {
	            ind = pop.poll();
	            inds.add(ind);
	            if(ind.id == bestID) {
	            	i--;
	            	continue;
	            }
	            for(Solution bestSol : bestInds) {
	            	if(ind.solution.isSolEqual(bestSol)) {
	            		isSolValid = false;
	            	}
	            }
	            if(isSolValid) {
	            	bestInds.add(ind.solution);
	            }
	            else {
	            	i--;
	            	continue;
	            }
	            
	        } else {
	            break; // Exit loop if pop is empty
	        }
	    }

	    // Reinsert polled individuals back into pop
	    for(int i = 0; i < inds.size(); i++) {
	        pop.add(inds.get(i));
	    }

	    return bestInds;
	}

}
