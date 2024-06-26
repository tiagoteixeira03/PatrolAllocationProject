package EvolutionaryProgramming;

import DiscreteStochasticSimulation.EventManager;

/**
 * Class that represents a reproduction event.
 * This event creates a new individual (child) from the current individual when it occurs.
 */
public class EventReproduction extends Event {
    
    /** The new individual created as a result of the reproduction event. */
    Individual child;
    
    /**
     * Constructs an EventReproduction with the specified parameters.
     *
     * @param ind_ The individual associated with this event.
     * @param solution_ The solution associated with the individual.
     * @param simTime The simulation time when the event occurs.
     */
    public EventReproduction(Individual ind_, Solution solution_, double simTime) {
        super(ind_, solution_, simTime);
    }
    
    /**
     * Simulates the reproduction event. This method creates a new individual (child)
     * from the current individual by invoking the newChild method on the child.
     *
     * @param eventmanager The event manager responsible for scheduling and managing events.
     */
    public void simulate(EventManager eventmanager) {
        // Create a new individual (child) using the current solution
        child = new Individual(eventmanager, solution.getSolutionObject());
        
        // Invoke the newChild method on the child with the current solution
        child.newChild(solution);
        
        // Schedule the next reproduction event for the current individual
        ind.scheduleNextReproduction();
    }
}