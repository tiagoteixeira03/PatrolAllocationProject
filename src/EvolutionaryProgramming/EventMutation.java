package EvolutionaryProgramming;

import DiscreteStochasticSimulation.EventManager;

public class EventMutation extends Event {
	Individual ind;
	EventManager eventmanager;
	TimeIncrementStrategy timestrat;
	Solution solution;
	
	public EventMutation(Individual ind_, EventManager eventmanager_, TimeIncrementStrategy timestrat_, Solution solution_) {
		super(ind_, eventmanager_, timestrat_, solution_);
	}
	
	public void simulate(EventManager eventmanager) {
		solution.mutateSolution();
	}
}
