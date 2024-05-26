package EvolutionaryProgramming;

import java.util.List;

import Main.ComponentFactory;

public class EvolutionaryProgrammingFactory implements ComponentFactory{
	List<TimeIncrementStrategy> strategies;
	EvolutionaryProgramming ep = new EvolutionaryProgramming();
	Solution solution;
	
	public EvolutionaryProgrammingFactory(List<TimeIncrementStrategy> strategies_, Solution solution_) {
		strategies = strategies_;
		solution = solution_;
	}
	
	@Override
	public void initialize(String[] args) {
		int initPopSize = Integer.parseInt(args[3]);
		int popMaxSize = Integer.parseInt(args[4]);
		
		EvolutionaryProgramming.init(initPopSize, popMaxSize, solution);
		
		ep.setStrategy("Reproduction", strategies.get(0));
		ep.setStrategy("Death", strategies.get(1));
		ep.setStrategy("Mutation", strategies.get(2));
	}
}
