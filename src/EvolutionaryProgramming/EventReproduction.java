package EvolutionaryProgramming;

import DiscreteStochasticSimulation.EventManager;

public class EventReproduction extends Event {
	Individual ind;
	float simTime;
	
	public EventReproduction(Individual ind_, float simTime_) {
		super(ind_, simTime_);
	}
	
	public void simulate(EventManager eventmanager, float currentSimTime) {
		new Individual(currentSimTime);
	}
	

}
