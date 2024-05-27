package EvolutionaryProgramming;

import DiscreteStochasticSimulation.EventManager;

/**
 * Class that represents an individual.
 * It contains methods for initializing events, managing individual properties, and interacting with the population.
 */
public class Individual {
    /** The comfort value of the individual. */
	double fitting;
    /** The event manager responsible for managing simulation events. */
	EventManager eventmanager;
    /** The population instance. */
	Population pop = Population.getInstance();
    /** The solution associated with the individual. */
	Solution solution;
	
	/**
     * Constructs a new Individual with the specified event manager and solution.
     * 
     * @param eventManager_ the event manager responsible for managing simulation events
     * @param solution_ the solution associated with the individual
     */
	public Individual(EventManager eventmanager_, Solution solution_) {
		eventmanager = eventmanager_;
		solution = solution_;
		innitEvents(eventmanager);
	}
	
	/**
     * Initializes the events associated with the individual.
     * 
     * @param eventManager the event manager responsible for managing simulation events
     */
	public void innitEvents(EventManager eventmanager) {
		new EventReproduction(this, eventmanager, EvolutionaryProgramming.strategiesMap.get("Reproduction"), solution);
		new EventDeath(this, eventmanager, EvolutionaryProgramming.strategiesMap.get("Death"), solution);
		new EventMutation(this, eventmanager, EvolutionaryProgramming.strategiesMap.get("Mutation"), solution);
	}
	
    /** Removes the individual from the population. */
	public void killIndividual() {
		pop.removeIndfromPop(this);
	}
	
    /** Generates a new individual and adds it to the population. */
	public void newIndividual() {
		solution.generateRandomSolution();
		fitting = solution.getFitting();
		pop.addIndtoPop(this);	
	}
	
	/**
     * Generates a new individual as a child of the specified parent solution.
     * 
     * @param parentSolution the parent solution from which to inherit
     */
	public void newChild(Solution parentSolution) {
		solution.inheritSolution(parentSolution);
		fitting = solution.getFitting();
		pop.addIndtoPop(this);	
	}
}
