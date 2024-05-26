package EvolutionaryProgramming;

import DiscreteStochasticSimulation.EventManager;

public abstract class Event {
	Individual ind;
	double simTime;
	EventManager eventmanager;
	TimeIncrementStrategy timeincr;
	Solution solution;
	
	public Event(Individual ind_, EventManager eventmanager_, TimeIncrementStrategy timeincr_, Solution solution_) {
		ind = ind_;
		eventmanager = eventmanager_;
		solution = solution_;
		timeincr = timeincr_;
		simTime = timeincr.getRandomTime(ind.fitting);
		eventmanager.scheduleEvent((IEv) this);
	}
	
	public abstract void simulate(EventManager eventmanager);
	
	public double getSimTime() {
		return simTime;
	}
}
