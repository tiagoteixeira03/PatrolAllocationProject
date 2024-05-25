package EvolutionaryProgramming;

import DiscreteStochasticSimulation.EventManager;

public class EventDeath extends Event{
	Individual ind;
	EventManager eventmanager;
	TimeIncrementStrategy timestrat;
	
	public EventDeath(Individual ind_, EventManager eventmanager_, TimeIncrementStrategy timestrat_) {
		super(ind_, eventmanager_, timestrat_);
	}
	
	public void simulate(EventManager eventmanager) {
		ind.killIndividual();
	}
}
