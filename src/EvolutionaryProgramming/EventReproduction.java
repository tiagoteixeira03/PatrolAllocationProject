package EvolutionaryProgramming;

import DiscreteStochasticSimulation.EventManager;

public class EventReproduction extends Event {
	Individual ind;
	EventManager eventmanager;
	TimeIncrementStrategy timestrat;
	
	public EventReproduction(Individual ind_, EventManager eventmanager_, TimeIncrementStrategy timestrat_, Solution solution_) {
		super(ind_, eventmanager_, timestrat_, solution_);
	}
	
	public void simulate(EventManager eventmanager) {
		new Individual(eventmanager);
	}
	

}
