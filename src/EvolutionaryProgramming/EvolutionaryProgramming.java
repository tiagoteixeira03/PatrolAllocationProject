package EvolutionaryProgramming;

import java.util.HashMap;

import DiscreteStochasticSimulation.EventManager;

/**
 * Class that represents ??.
 * Manages the initialization of the population and the time increment strategies 
 * used in the simulation.
 */
public class EvolutionaryProgramming {
    /** The initial population size. */
	static int initPopSize;
    /** The maximum population size. */
	static int popMaxSize;
    /** A map of strategy names to their corresponding time increment strategies. */
	static HashMap<String, TimeIncrementStrategy> strategiesMap = new HashMap<>();
    /** ??. */
	static Solution solution;
    /** The event manager responsible for scheduling and managing events. */
	static EventManager eventmanager;
    /** The individual. */
	static Individual ind;
	
	/**
     * Initializes the evolutionary programming simulation with the specified parameters.
     *
     * @param initPopSize_ the initial population size
     * @param popMaxSize_ the maximum population size
     * @param solution_ ??
     */
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
	
	/**
     * Sets the time increment strategy for a given strategy name.
     *
     * @param s the name of the strategy
     * @param strategy the time increment strategy to be associated with the name
     */
	public void setStrategy(String s, TimeIncrementStrategy strategy) {
		strategiesMap.put(s, strategy);
	}
}
