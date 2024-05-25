package EvolutionaryProgramming;

import DiscreteStochasticSimulation.EventManager;

public interface IEv {
	public void simulate(EventManager eventmanager, TimeIncrementStrategy timestrat);
	public float getSimTime();
}
