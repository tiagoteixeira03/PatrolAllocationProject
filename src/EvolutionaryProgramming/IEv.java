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
     * @param eventManager the event manager responsible for managing simulation events
     */
	public void simulate(EventManager eventmanager);
	
	/**
     * Abstract method that gets the simulation time.
     */
	public float getSimTime();
}
