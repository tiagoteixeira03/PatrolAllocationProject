package DiscreteStochasticSimulation;

import EvolutionaryProgramming.IEv;

/**
 * Interface that defines methods for managing events.
 */
public interface EventManager {
	/**
     * Abstract method that schedules an event in the simulation.
     * 
     * @param ev the event to be scheduled
     */
	public void scheduleEvent(IEv ev);
	
	public void removeIdEvents(int id);
	
	/**
     * Gets the current simulation time.
     * 
     * @return the current simulation time
     */
	public double getCurrSimTime();
	
	public int getNumEvents();
}
