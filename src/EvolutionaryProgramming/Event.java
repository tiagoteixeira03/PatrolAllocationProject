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
     * @param ind_ The individual associated with this event.
     * @param solution_ The solution associated with an individual.
     * @param simTime_ The simulation time when the event occurs.
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
     * @param eventmanager The event manager responsible for scheduling and managing events.
     */
	public abstract void simulate(EventManager eventmanager);
	
	/**
     * Gets the simulation time of when an event occurs.
     *
     * @return The simulation time of when an event occurs.
     */
	public double getSimTime() {
		return simTime;
	}
	
	/**
     * Gets the ID of the individual associated with this event.
     *
     * @return The ID of the individual.
     */
	public int getIndID() {
		return ind.id;
	}
}