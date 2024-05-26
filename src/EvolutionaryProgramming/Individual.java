package EvolutionaryProgramming;

import DiscreteStochasticSimulation.EventManager;
import DiscreteStochasticSimulation.RhoTimeIncrementStrategy;
import DiscreteStochasticSimulation.MuTimeIncrementStrategy;
import DiscreteStochasticSimulation.DeltaTimeIncrementStrategy;

public class Individual {
	float fitting;
	int[] distribution;
	EventManager eventmanager;
	Population pop = Population.getInstance();
	
	public Individual(EventManager eventmanager_) {
		eventmanager = eventmanager_;
		innitEvents(eventmanager);
	}
	
	public void innitEvents(EventManager eventmanager) {
		pop.addIndtoPop(this);
		new EventReproduction(this, eventmanager, EvolutionaryProgramming.strategiesMap.get("Reproduction"));
		new EventDeath(this, eventmanager, EvolutionaryProgramming.strategiesMap.get("Death"));
		new EventMutation(this, eventmanager, EvolutionaryProgramming.strategiesMap.get("Mutation"));
	}
	
	public void killIndividual() {
		pop.removeIndfromPop(this);
	}
}
