package EvolutionaryProgramming;

import java.util.ArrayList;

public class InformationProviderClass implements InformationProvider{
	
	static InformationProviderClass instance;
	Population pop = Population.getInstance();
	
	private InformationProviderClass() {
		
	}
	
	public static InformationProviderClass getInstance() {
		if(instance == null) {
			instance = new InformationProviderClass();
		}
		return instance;
	}
	
	@Override
	public int getPopSize() {
		return pop.currentIndID;
	}

	@Override
	public int getNumEpidemics() {
		return pop.numEpidemics;
	}

	@Override
	public ArrayList<Solution> getBestSols() {
		return pop.getBestInds();
	}

}
