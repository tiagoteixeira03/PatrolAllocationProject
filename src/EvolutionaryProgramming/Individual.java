package EvolutionaryProgramming;

import DiscreteStochasticSimulation.EventManager;

public class Individual {
	double fitting;
	EventManager eventmanager;
	Population pop = Population.getInstance();
	Solution solution;
	
	public Individual(EventManager eventmanager_, Solution solution_) {
		eventmanager = eventmanager_;
		solution = solution_;
		innitEvents(eventmanager);
	}
	
	public void innitEvents(EventManager eventmanager) {
		pop.addIndtoPop(this);	
		new EventReproduction(this, eventmanager, EvolutionaryProgramming.strategiesMap.get("Reproduction"), solution);
		new EventDeath(this, eventmanager, EvolutionaryProgramming.strategiesMap.get("Death"), solution);
		new EventMutation(this, eventmanager, EvolutionaryProgramming.strategiesMap.get("Mutation"), solution);
	}
	
	public void killIndividual() {
		pop.removeIndfromPop(this);
	}
	
	public void newIndividual() {
		solution.generateRandomSolution();
		fitting = solution.getFitting();
	}
	
	public void newChild(Solution parentSolution) {
		solution.inheritSolution(parentSolution);
		fitting = solution.getFitting();
	}
}
