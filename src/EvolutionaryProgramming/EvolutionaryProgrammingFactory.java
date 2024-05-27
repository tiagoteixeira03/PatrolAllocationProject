package EvolutionaryProgramming;

import java.util.List;

import DiscreteStochasticSimulation.EventManager;
import Main.ComponentFactory;

public class EvolutionaryProgrammingFactory implements ComponentFactory{
	List<TimeIncrementStrategy> strategies;
	EvolutionaryProgramming ep = new EvolutionaryProgramming();
	Solution solution;
	EventManager eventmanager;
	
	public EvolutionaryProgrammingFactory(List<TimeIncrementStrategy> strategies_, Solution solution_, EventManager eventmanager_) {
		strategies = strategies_;
		solution = solution_;
		eventmanager = eventmanager_;
	}
	
	@Override
	public void initialize(String[] args) {
		int initPopSize = Integer.parseInt(args[3]);
		int popMaxSize = Integer.parseInt(args[4]);
		
		EvolutionaryProgramming.init(initPopSize, popMaxSize, solution, eventmanager);
		
		ep.setStrategy("Reproduction", strategies.get(0));
		ep.setStrategy("Death", strategies.get(1));
		ep.setStrategy("Mutation", strategies.get(2));
		ep.setStrategy("Epidemic", strategies.get(3));
	}
}
