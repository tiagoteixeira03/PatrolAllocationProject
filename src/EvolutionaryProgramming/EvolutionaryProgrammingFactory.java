package EvolutionaryProgramming;

import Main.ComponentFactory;

public class EvolutionaryProgrammingFactory implements ComponentFactory{
	@Override
	public void initialize(String[] args) {
		int initPopSize = Integer.parseInt(args[3]);
		int popMaxSize = Integer.parseInt(args[4]);
		
		EvolutionaryProgramming.init(initPopSize, popMaxSize);
	}
}
