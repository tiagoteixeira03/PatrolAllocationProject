package EvolutionaryProgramming;

import java.util.HashMap;
import java.util.List;

import DiscreteStochasticSimulation.EventManager;
import Main.ComponentFactory;

/**
 * Factory class to create and initialize the evolutionary programming components.
 * Sets up the initial population sizes and associates the appropriate time
 * increment strategies for the evolutionary programming process.
 */
public class EvolutionaryProgrammingFactory implements ComponentFactory{
    /** List of time increment strategies used in the simulation. */
	List<TimeIncrementStrategy> strategies;
    /** Instance of the EvolutionaryProgramming class. */
	static HashMap<String, TimeIncrementStrategy> strategiesMap = new HashMap<>();
    /** A solution for a problem. */
	Solution solution;
    /** The event manager responsible for scheduling and managing events. */
	EventManager eventmanager;
	
	/**
     * Constructs an EvolutionaryProgrammingFactory with the specified strategies and solution.
     *
     * @param strategies_ The list of time increment strategies.
     * @param solution_ A solution for a problem.
     * @param eventmanager_ The event manager responsible for scheduling and managing events.
     */
	public EvolutionaryProgrammingFactory(List<TimeIncrementStrategy> strategies_, Solution solution_, EventManager eventmanager_) {
		strategies = strategies_;
		solution = solution_;
		eventmanager = eventmanager_;
	}
	
	/**
     * Initializes the evolutionary programming components with parameters provided through command-line arguments.
     *
     * @param EPargs The command-line arguments containing simulation parameters.
     */
	@Override
	public void initialize(String[] EPargs) {
		int initPopSize_ = Integer.parseInt(EPargs[0]);
		int popMaxSize_ = Integer.parseInt(EPargs[1]);
		
		strategiesMap.put("Reproduction", strategies.get(0));
		strategiesMap.put("Death", strategies.get(1));
		strategiesMap.put("Mutation", strategies.get(2));
		strategiesMap.put("Epidemic", strategies.get(3));
		
		new EvolutionaryProgramming();
		
		EvolutionaryProgramming.init(initPopSize_, popMaxSize_, solution, eventmanager);
	}
}