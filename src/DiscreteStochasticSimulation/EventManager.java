package DiscreteStochasticSimulation;

import EvolutionaryProgramming.IEv;

/**
 * Interface that defines methods for managing events.
 */
public interface EventManager {
    /**
     * Schedules an event in the simulation.
     *
     * @param ev The event to be scheduled.
     */
    public void scheduleEvent(IEv ev);

    /**
     * Removes an event with the associated  ID.
     *
     * @param id The ID of the event to be removed.
     */
    public void removeIdEvents(int id);

    /**
     * Retrieves the current simulation time.
     *
     * @return The current simulation time.
     */
    public double getCurrSimTime();

    /**
     * Retrieves the number of events currently scheduled in the simulation.
     *
     * @return The number of events currently scheduled.
     */
    public int getNumEvents();
}
