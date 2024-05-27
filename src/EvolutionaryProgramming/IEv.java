package EvolutionaryProgramming;

import DiscreteStochasticSimulation.EventManager;

/**
 * Interface that lets the Evolutionary Programming package schedule events and lets the Discrete
 * Stochastic Simulation simulate events.
 */
public interface IEv {
	/**
     * Abstract method that simulates an event.
     * 
     * @param eventmanager the event manager responsible for managing simulation events
     */
	public void simulate(EventManager eventmanager);
	
	/**
     * Abstract method that gets the simulation time.
     * 
     * @return the simulation time for the event
     */
	public float getSimTime();
}
