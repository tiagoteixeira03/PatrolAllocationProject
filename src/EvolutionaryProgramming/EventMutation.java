package EvolutionaryProgramming;

import DiscreteStochasticSimulation.EventManager;

/**
 * Class that represents a mutation event.
 * This event performs the mutation of an individual.
 */
public class EventMutation extends Event {

	Population pop = Population.getInstance();
	
	/**
     * Constructs an EventMutation with the specified parameters.
     *
     * @param ind_ the individual associated with this event
     * @param eventmanager_ the event manager responsible for scheduling and managing events
     * @param timestrat_ the strategy used to increment the event's occurring simulation time
     * @param solution_ the solution associated with an individual
     */
	public EventMutation(Individual ind_, Solution solution_, double simTime) {
		super(ind_, solution_, simTime);
	}
	
	/**
     * Simulates the mutation event. This method performs the mutation of an individual
     * by invoking the mutateSolution method on the associated solution.
     *
     * @param eventmanager the event manager responsible for scheduling and managing events
     */
	public void simulate(EventManager eventmanager) {
		solution.mutateSolution();
		ind.fitting = solution.getFitting();
		if(ind.fitting > pop.bestFitting) {
			pop.bestSol = ind.solution.cloneObject();
			pop.bestFitting = pop.bestSol.getFitting();
			pop.bestID = ind.id;
		}
		pop.updateIndPosition(ind);
		ind.scheduleNextMutation();
	}
}
