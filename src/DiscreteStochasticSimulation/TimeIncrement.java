package DiscreteStochasticSimulation;

import EvolutionaryProgramming.TimeIncrementStrategy;

/**
 * Abstract class representing a time increment strategy.
 */
public abstract class TimeIncrement implements TimeIncrementStrategy {
	/**
     * Abstract method for a time increment strategy.
     *
     * @param fitting The comfort value of the individual.
     */
	public abstract double getRandomTime(double fitting);
}
