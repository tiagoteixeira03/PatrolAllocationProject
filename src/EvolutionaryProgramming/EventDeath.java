package EvolutionaryProgramming;

import DiscreteStochasticSimulation.EventManager;

/**
 * Class that represents a death event.
 * This event removes an individual from the population when it occurs.
 */
public class EventDeath extends Event {
    /**
     * Constructs an EventDeath with the specified parameters.
     *
     * @param ind_ the individual associated with this event.
     * @param solution_ the solution associated with an individual.
     * @param simTime The simulation time when the event occurs.
     */
    public EventDeath(Individual ind_, Solution solution_, double simTime) {
        super(ind_, solution_, simTime);
    }

    /**
     * Simulates the death event. This method removes the individual from the population
     * by invoking the killIndividual method on the associated individual.
     *
     * @param eventmanager The event manager responsible for scheduling and managing events.
     */
    public void simulate(EventManager eventmanager) {
        ind.killIndividual();
    }
}