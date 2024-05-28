package EvolutionaryProgramming;

import java.util.ArrayList;

public class InformationProviderClass implements InformationProvider{
	
	static InformationProviderClass instance;
	
	private InformationProviderClass() {
		
	}
	
	public static InformationProviderClass getInstance() {
		if(instance == null) {
			instance = new InformationProviderClass();
		}
		return instance;
	}
	
	Population pop = Population.getInstance();
	
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
