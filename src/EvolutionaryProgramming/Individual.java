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
	
	/** The simulation time when the individual dies. */
    double deathTime;
    
    /** The simulation time when the individual reproduces. */
    double repoTime;
    
    /** The simulation time when the individual mutates. */
    double mutTime;
    
    /** The unique identifier of the individual. */
    int id;
	
	/**
     * Constructs a new Individual with the specified event manager and solution.
     * 
     * @param eventmanager_ The event manager responsible for managing simulation events.
     * @param solution_ The solution associated with the individual.
     */
	public Individual(EventManager eventmanager_, Solution solution_) {
		eventmanager = eventmanager_;
		solution = solution_;
		id = pop.currentIndID + 1;
	}
	
	/**
     * Initializes the events associated with the individual.
     */
	public void innitEvents() {
		double currentTime = eventmanager.getCurrSimTime();
		
        // Calculate death time and create a new EventDeath
		deathTime = currentTime + EvolutionaryProgrammingFactory.strategiesMap.get("Death").getRandomTime(fitting);
		new EventDeath(this, solution, deathTime);
		
        // Calculate reproduction time and create a new EventReproduction if it's earlier than death time
		repoTime = currentTime + EvolutionaryProgrammingFactory.strategiesMap.get("Reproduction").getRandomTime(fitting);
		if(repoTime < deathTime) {
			new EventReproduction(this, solution, repoTime);
		}
		
        // Calculate mutation time and create a new EventMutation if it's earlier than death time
		mutTime = currentTime + EvolutionaryProgrammingFactory.strategiesMap.get("Mutation").getRandomTime(fitting);
		if(mutTime < deathTime) {
			new EventMutation(this, solution, mutTime);
		}
	}
	
    /** Removes the individual from the population. */
	public void killIndividual() {
		pop.removeIndfromPop(this);
	}
	
    /** Removes the individual from the population, 
     * specific to when there is an epidemic event. */
	public void killIndividualEpidemic() {
		eventmanager.removeIdEvents(id);
		pop.removeIndfromPop(this);
	}
	
    /** Generates a new individual and adds it to the population. */
	public void newIndividual() {
		solution.generateRandomSolution();
		fitting = solution.getFitting();
		innitEvents();
		pop.addIndtoPop(this);	
	}
	
	/**
     * Generates a new individual as a child of the specified parent solution.
     * 
     * @param parentSolution The parent solution from which to inherit.
     */
	public void newChild(Solution parentSolution) {
		solution.inheritSolution(parentSolution);
		fitting = solution.getFitting();
		innitEvents();
		pop.addIndtoPop(this);
	}
	
    /** Schedules the next reproduction event for the individual. */
	public void scheduleNextReproduction() {
		double currentTime = eventmanager.getCurrSimTime();
		repoTime = currentTime + EvolutionaryProgrammingFactory.strategiesMap.get("Reproduction").getRandomTime(fitting);
		if(repoTime < deathTime) {
			new EventReproduction(this, solution, repoTime);
		}
	}
	
    /** Schedules the next mutation event for the individual. */
	public void scheduleNextMutation() {
		double currentTime = eventmanager.getCurrSimTime();
		mutTime = currentTime + EvolutionaryProgrammingFactory.strategiesMap.get("Mutation").getRandomTime(fitting);
		if(mutTime < deathTime) {
			new EventMutation(this, solution, mutTime);
		}
	}
}
