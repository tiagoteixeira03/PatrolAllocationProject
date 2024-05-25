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
	//We know this is not decoupled but we can't find a better solution
	RhoTimeIncrementStrategy rhostrat;
	MuTimeIncrementStrategy mustrat;
	DeltaTimeIncrementStrategy deltastrat;
	
	public Individual(EventManager eventmanager_) {
		eventmanager = eventmanager_;
		innitEvents(eventmanager);
	}
	
	public void innitEvents(EventManager eventmanager) {
		pop.addIndtoPop(this);
		new EventReproduction(this, eventmanager, rhostrat.getInstance());
		new EventDeath(this, eventmanager, mustrat.getInstance());
		new EventMutation(this, eventmanager, deltastrat.getInstance());
	}
	
	public void killIndividual() {
		pop.removeIndfromPop(this);
	}
}
