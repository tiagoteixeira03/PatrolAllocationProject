package EvolutionaryProgramming;

import DiscreteStochasticSimulation.EventManager;

/**
 * Class that represents a reproduction event.
 * This event creates a new individual (child) from the current individual when it occurs.
 */
public class EventReproduction extends Event {
    /** The individual associated with this event. */
	Individual ind;
    /** Strategy used to increment the event's occurring simulation time. */
	TimeIncrementStrategy timestrat;
    /** The new individual created as a result of the reproduction event. */
	Individual child;
	
	/**
     * Constructs an EventReproduction with the specified parameters.
     *
     * @param ind_ the individual associated with this event
     * @param eventmanager_ the event manager responsible for scheduling and managing events
     * @param timestrat_ the strategy used to increment the event's occurring simulation time
     * @param solution_ the solution associated with an individual
     */
	public EventReproduction(Individual ind_, Solution solution_, double simTime) {
		super(ind_, solution_, simTime);
	}
	
	/**
     * Simulates the reproduction event. This method creates a new individual (child)
     * from the current individual by invoking the newChild method on the child.
     *
     * @param eventmanager the event manager responsible for scheduling and managing events
     */
	public void simulate(EventManager eventmanager) {
		child = new Individual(eventmanager, solution.getSolutionObject());
		child.newChild(solution);
	}
}
