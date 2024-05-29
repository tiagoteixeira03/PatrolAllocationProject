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
	double deathTime, repoTime, mutTime;
	int id;
	
	/**
     * Constructs a new Individual with the specified event manager and solution.
     * 
     * @param eventmanager_ the event manager responsible for managing simulation events
     * @param solution_ the solution associated with the individual
     */
	public Individual(EventManager eventmanager_, Solution solution_) {
		eventmanager = eventmanager_;
		solution = solution_;
		id = pop.currentIndID + 1;
	}
	
	/**
     * Initializes the events associated with the individual.
     * 
     * @param eventmanager the event manager responsible for managing simulation events
     */
	public void innitEvents(EventManager eventmanager) {
		double currentTime = eventmanager.getCurrSimTime();
		deathTime = currentTime + EvolutionaryProgrammingFactory.strategiesMap.get("Death").getRandomTime(fitting);
		new EventDeath(this, solution, deathTime);
		
		repoTime = currentTime + EvolutionaryProgrammingFactory.strategiesMap.get("Reproduction").getRandomTime(fitting);
		if(repoTime < deathTime) {
			new EventReproduction(this, solution, repoTime);
		}
		
		mutTime = currentTime + EvolutionaryProgrammingFactory.strategiesMap.get("Mutation").getRandomTime(fitting);
		if(mutTime < deathTime) {
			new EventMutation(this, solution, mutTime);
		}
	}
	
    /** Removes the individual from the population. */
	public void killIndividual() {
		eventmanager.removeIdEvents(id);
		pop.removeIndfromPop(this);
	}
	
    /** Generates a new individual and adds it to the population. */
	public void newIndividual() {
		solution.generateRandomSolution();
		fitting = solution.getFitting();
		innitEvents(eventmanager);
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
		innitEvents(eventmanager);
		pop.addIndtoPop(this);	
	}
}
