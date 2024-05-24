package EvolutionaryProgramming;

import DiscreteStochasticSimulation.EventManager;

public abstract class Event {
	Individual ind;
	float simTime;
	EventManager eventmanager;
	RandomDecider randomdecider;
	
	public Event(Individual ind_, EventManager eventmanager_, RandomDecider randomdecider_) {
		ind = ind_;
		eventmanager = eventmanager_;
		randomdecider = randomdecider_;
		simTime = randomdecider.getRandomTime(ind.fitting);
		eventmanager.scheduleEvent((IEv) this);
	}
	
	public void simulate(EventManager eventmanager) {
	
	}
	
	public float getSimTime() {
		return simTime;
	}
}
