package DiscreteStochasticSimulation;

import EvolutionaryProgramming.IEv;

/**
 * Represents an event that is an observation of the simulation state at a specific time.
 */
public class EventObservation implements IEv {
    /** The simulation time at which this observation event occurs. */
    double simTime;

    /**
     * Constructs an EventObservation object with the specified simulation time and schedules it.
     *
     * @param simTime_ The simulation time at which this observation event occurs.
     * @param pec      The Pending Event Container.
     */
    public EventObservation(double simTime_, PEC pec) {
        this.simTime = simTime_;
        pec.scheduleEvent(this);
    }

    /**
     * Simulates the observation event by printing the current simulation results.
     *
     * @param eventManager The event manager responsible for managing events in the simulation.
     */
    @Override
    public void simulate(EventManager eventManager) {
        DiscreteStochasticSimulation.printResults.printCurrentResult(eventManager.getCurrSimTime(), eventManager.getNumEvents());
    }

    /**
     * Retrieves the simulation time at which this observation event occurs.
     *
     * @return The simulation time.
     */
    @Override
    public double getSimTime() {
        return simTime;
    }

    /**
     * Retrieves the individual ID associated with this event.
     *
     * @return The individual ID, or -1 if not applicable.
     */
    @Override
    public int getIndID() {
        return -1;
    }
}