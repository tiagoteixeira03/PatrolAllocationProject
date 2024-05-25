package EvolutionaryProgramming;

import DiscreteStochasticSimulation.EventManager;

public class EventMutation extends Event {
	Individual ind;
	EventManager eventmanager;
	TimeIncrementStrategy timestrat;
	
	public EventMutation(Individual ind_, EventManager eventmanager_, TimeIncrementStrategy timestrat_) {
		super(ind_, eventmanager_, timestrat_);
	}
}
