package EvolutionaryProgramming;

import DiscreteStochasticSimulation.EventManager;

public abstract class Event {
	Individual ind;
	double simTime;
	EventManager eventmanager;
	TimeIncrementStrategy timeincr;
	
	public Event(Individual ind_, EventManager eventmanager_, TimeIncrementStrategy timeincr_) {
		ind = ind_;
		eventmanager = eventmanager_;
		timeincr = timeincr_;
		simTime = timeincr.getRandomTime(ind.fitting);
		eventmanager.scheduleEvent((IEv) this);
	}
	
	public abstract void simulate(EventManager eventmanager);
	
	public double getSimTime() {
		return simTime;
	}
}
