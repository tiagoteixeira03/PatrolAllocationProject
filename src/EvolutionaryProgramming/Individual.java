package EvolutionaryProgramming;

import DiscreteStochasticSimulation.EventManager;

public class Individual {
	float fitting;
	int[] distribution;
	EventManager eventmanager;
	
	
	
	public Individual(EventManager eventmanager_) {
		eventmanager = eventmanager_;
		innitEvents(eventmanager);
	}
	
	public void innitEvents(EventManager eventmanager) {
		new EventReproduction(this, eventmanager, );
	}
}
