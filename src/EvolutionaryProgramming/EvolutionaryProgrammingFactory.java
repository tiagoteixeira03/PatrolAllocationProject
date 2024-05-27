package EvolutionaryProgramming;

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
	EvolutionaryProgramming ep = new EvolutionaryProgramming();
    /** ??. */
	Solution solution;
    /** The event manager responsible for scheduling and managing events. */
	EventManager eventmanager;
	
	/**
     * Constructs an EvolutionaryProgrammingFactory with the specified strategies and solution.
     *
     * @param strategies_ the list of time increment strategies
     * @param solution_ ??
     * @param eventmanager_ the event manager responsible for scheduling and managing events
     */
	public EvolutionaryProgrammingFactory(List<TimeIncrementStrategy> strategies_, Solution solution_, EventManager eventmanager_) {
		strategies = strategies_;
		solution = solution_;
		eventmanager = eventmanager_;
	}
	
	/**
     * Initializes the evolutionary programming components with the specified arguments.
     *
     * @param args the array of arguments for initialization
     * 		 	   args[3]: initial population size
     *             args[5]: maximum population size
     */
	@Override
	public void initialize(String[] args) {
		int initPopSize = Integer.parseInt(args[3]);
		int popMaxSize = Integer.parseInt(args[4]);
		
		EvolutionaryProgramming.init(initPopSize, popMaxSize, solution, eventmanager);
		
		ep.setStrategy("Reproduction", strategies.get(0));
		ep.setStrategy("Death", strategies.get(1));
		ep.setStrategy("Mutation", strategies.get(2));
		ep.setStrategy("Epidemic", strategies.get(3));
	}
}
