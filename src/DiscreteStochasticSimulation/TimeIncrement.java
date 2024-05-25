package DiscreteStochasticSimulation;

import EvolutionaryProgramming.TimeIncrementStrategy;

public abstract class TimeIncrement implements TimeIncrementStrategy {
	public abstract double getRandomTime(double fitting);
}
