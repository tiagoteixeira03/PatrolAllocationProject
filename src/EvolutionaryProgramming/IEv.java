package EvolutionaryProgramming;

import DiscreteStochasticSimulation.EventManager;

public interface IEv {
	public void simulate(EventManager eventmanager);
	public float getSimTime(IEv ev);
}
