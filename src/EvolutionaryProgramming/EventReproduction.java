package EvolutionaryProgramming;

import DiscreteStochasticSimulation.EventManager;

public class EventReproduction extends Event {
	Individual ind;
	EventManager eventmanager;
	RandomDecider randomdecider;
	
	public EventReproduction(Individual ind_, EventManager eventmanager_, RandomDecider randomdecider_) {
		super(ind_, eventmanager_, randomdecider_);
	}
	
	public void simulate(EventManager eventmanager) {
		new Individual(eventmanager.getCurrSimTime());
	}
	

}
