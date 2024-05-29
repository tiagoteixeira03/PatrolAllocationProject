package EvolutionaryProgramming;

import DiscreteStochasticSimulation.EventManager;

/**
 * Abstract class representing an event.
 */
public abstract class Event implements IEv{
    /** The individual associated with this event. */
	Individual ind;
    /** The simulation time when the event occurs. */
	double simTime;
    /** Strategy used to increment the event's occurring simulation time. */
	TimeIncrementStrategy timeincr;
    /** The solution associated with an individual. */
	Solution solution;
	
	/**
     * Constructs an Event with the specified parameters.
     *
     * @param ind_ the individual associated with this event
     * @param eventmanager_ the event manager responsible for scheduling and managing events
     * @param timeincr_ the strategy used to increment the event's occurring simulation time
     * @param solution_ the solution associated with an individual
     */
	public Event(Individual ind_, Solution solution_, double simTime_) {
		ind = ind_;
		solution = solution_;
		simTime = simTime_;
		EvolutionaryProgramming.eventmanager.scheduleEvent((IEv) this);
	}

	/**
     * Abstract method that simulates the event.
     *
     * @param eventmanager the event manager responsible for scheduling and managing events
     */
	public abstract void simulate(EventManager eventmanager);
	
	/**
     * Gets the simulation time of when an event occurs.
     *
     * @return the simulation time of when an event occurs
     */
	public double getSimTime() {
		return simTime;
	}
	
	public int getIndID() {
		return ind.id;
	}
}