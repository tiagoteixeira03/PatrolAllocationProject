package EvolutionaryProgramming;

import DiscreteStochasticSimulation.EventManager;

/**
 * Class that represents a mutation event.
 * This event performs the mutation of an individual.
 */
public class EventMutation extends Event {
    /** The individual associated with this event. */
	Individual ind;
    /** The event manager responsible for scheduling and managing events. */
	EventManager eventmanager;
    /** Strategy used to increment the event's occurring simulation time. */
	TimeIncrementStrategy timestrat;
    /** The solution associated with the individual. */
	Solution solution;
	
	/**
     * Constructs an EventMutation with the specified parameters.
     *
     * @param ind_ the individual associated with this event
     * @param eventmanager_ the event manager responsible for scheduling and managing events
     * @param timestrat_ the strategy used to increment the event's occurring simulation time
     * @param solution_ the solution associated with an individual
     */
	public EventMutation(Individual ind_, EventManager eventmanager_, Solution solution_, double simTime) {
		super(ind_, eventmanager_, solution_, simTime);
	}
	
	/**
     * Simulates the mutation event. This method performs the mutation of an individual
     * by invoking the mutateSolution method on the associated solution.
     *
     * @param eventmanager the event manager responsible for scheduling and managing events
     */
	public void simulate(EventManager eventmanager) {
		solution.mutateSolution();
	}
}
