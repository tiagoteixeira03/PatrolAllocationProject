package EvolutionaryProgramming;

import DiscreteStochasticSimulation.EventManager;

public abstract class Event {
	Individual ind;
	float simTime;
	
	public Event(Individual ind_, float simTime_) {
		ind = ind_;
		simTime = simTime_;
	}
	
	public void simulate(EventManager eventmanager) {
		
	}
}
