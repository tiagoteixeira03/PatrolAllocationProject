package EvolutionaryProgramming;

import java.util.HashMap;

import DiscreteStochasticSimulation.EventManager;

/**
 * Class that has the parameters required by the EvolutionaryProgramming package.
 */
public class EvolutionaryProgramming {
    /** The initial population size. */
	static int initPopSize;
    /** The maximum population size. */
	static int popMaxSize;
    /** A map of strategy names to their corresponding time increment strategies. */
	static HashMap<String, TimeIncrementStrategy> strategiesMap = new HashMap<>();
    /** A solution for a problem. */
	static Solution solution;
    /** The event manager responsible for scheduling and managing events. */
	static EventManager eventmanager;
    /** The individual. */
	static Individual ind;
	
	/**
     * Initializes the EvolutionaryProgramming package with the specified parameters.
     *
     * @param initPopSize_ The initial population size.
     * @param popMaxSize_ The maximum population size.
     * @param solution_ A solution for a problem.
     * @param eventmanager_ The event manager responsible for scheduling and managing events.
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
}
