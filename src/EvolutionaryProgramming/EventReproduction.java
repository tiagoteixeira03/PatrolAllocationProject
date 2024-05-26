package EvolutionaryProgramming;

import DiscreteStochasticSimulation.EventManager;

public class EventReproduction extends Event {
	Individual ind;
	EventManager eventmanager;
	TimeIncrementStrategy timestrat;
	Individual child;
	
	public EventReproduction(Individual ind_, EventManager eventmanager_, TimeIncrementStrategy timestrat_, Solution solution_) {
		super(ind_, eventmanager_, timestrat_, solution_);
	}
	
	public void simulate(EventManager eventmanager) {
		child = new Individual(eventmanager, solution.getSolutionObject());
		child.newChild(solution);
	}
	

}
