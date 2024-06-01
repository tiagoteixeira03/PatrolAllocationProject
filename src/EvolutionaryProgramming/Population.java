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
    /** The best fitness value. */
	double bestFitting=0;
    /** The best solution. */
	Solution bestSol;
    /** The ID of the best individual. */
	int bestID;
	/** The current indivual ID. */
    int currentIndID = 0;
    /** The number of epidemics that have occurred. */
    int numEpidemics = 0;
	
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
	
    /** Private constructor to prevent instantiation outside the class. */
	private Population() {
			
	}
	
	/**
     * Retrieves the singleton instance of the Population class.
     * 
     * @return The singleton instance of the Population class.
     */
	public static Population getInstance() {
		if(instance==null) {
			instance = new Population();
		}
		return instance;
	}
	
	/**
     * Adds an individual to the population. Checks if the population size 
     * is bigger than max, if so start an epidemic.
     * 
     * @param ind The individual to be added to the population.
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
	
	/**
     * Updates the position of an individual in the population.
     *
     * @param ind The individual whose position needs to be updated.
     */
	public void updateIndPosition(Individual ind) {
		pop.remove(ind);
		pop.add(ind);
	}
	
	/**
     * Removes an individual from the population.
     * 
     * @param ind The individual to be removed from the population.
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
			bestInds.add(pop.poll()); // First we remove the 5 best individuals
		}
		while(!pop.isEmpty()) { // For the rest of the individuals in the population we check if they die or not
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
		
		while(it.hasNext()) { // We add the individuals that survived the epidemic back to the population
			pop.add(it.next());
		}
		
		for(int i=0; i<5; i++) { // We add the 5 best individuals back to the population
			pop.add(bestInds.get(i));
		}
	}
	
	/**
	 * Retrieves the best solutions from the population.
	 * This method selects the solutions with the highest fitness values, ensuring diversity by avoiding duplicate solutions.
	 *
	 * @return An ArrayList containing the best solutions.
	 */
	public ArrayList<Solution> getBestInds() {
	    // Initialize ArrayList to store best solutions
	    ArrayList<Solution> bestInds = new ArrayList<>(6);
	    // Temporary ArrayList to store individuals
	    ArrayList<Individual> inds = new ArrayList<>();
	    Individual ind;
	    // Boolean to track if a solution is valid (i.e., not duplicate)
	    Boolean isSolValid=true;

	    // Add the best solution ever found to the list of best solutions
	    bestInds.add(bestSol);
	    
	    // Retrieve the 5 best living individuals with different solutions
	    for(int i = 0; i < 5; i++) {
	        if(!pop.isEmpty()) {
	            // Retrieve and remove the best individual from the population
	            ind = pop.poll();
	            // Add the individual to the temporary list
	            inds.add(ind);
	            // Skip if the individual is the same as the best individual ever found
	            if(ind.id == bestID) {
	            	i--;
	            	continue;
	            }
	            // Check if the individual's solution is different from previously selected best solutions
	            isSolValid=true;
	            for(Solution bestSol : bestInds) {
	            	if(ind.solution.isSolEqual(bestSol)) {
	            		isSolValid = false;
	            	}
	            }
	            // If the solution is different, add it to the list of best solutions
	            if(isSolValid) {
	            	bestInds.add(ind.solution);
	            }
	            // If the solution is a duplicate, skip and decrement loop counter
	            else {
	            	i--;
	            	continue;
	            }
	        } else {
	            break;
	        }
	    }

	    // Add back the individuals removed from the population
	    for(int i = 0; i < inds.size(); i++) {
	        pop.add(inds.get(i));
	    }
	    
	    // Return the list of best solutions
	    return bestInds;
	}

}