package EvolutionaryProgramming;

import DiscreteStochasticSimulation.EventManager;

public class EventDeath extends Event{
	Individual ind;
	EventManager eventmanager;
	TimeIncrementStrategy timestrat;
	
	public EventDeath(Individual ind_, EventManager eventmanager_, TimeIncrementStrategy timestrat_, Solution solution_) {
		super(ind_, eventmanager_, timestrat_, solution_);
	}
	
	public void simulate(EventManager eventmanager) {
		ind.killIndividual();
	}
}
