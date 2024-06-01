package EvolutionaryProgramming;

import DiscreteStochasticSimulation.EventManager;

/**
 * Interface that lets the EvolutionaryProgramming package schedule events and lets the 
 * DiscreteStochasticSimulation package simulate events.
 */
public interface IEv {
	/**
     * Abstract method that simulates an event.
     * 
     * @param eventmanager The event manager responsible for managing simulation events.
     */
	public void simulate(EventManager eventmanager);
	
	/**
     * Abstract method that gets the simulation time.
     * 
     * @return The simulation time for the event.
     */
	public double getSimTime();
	
	/**
     * Abstract method that gets the individual ID associated with the event.
     *
     * @return The individual ID associated with the event.
     */
	public int getIndID();
}
