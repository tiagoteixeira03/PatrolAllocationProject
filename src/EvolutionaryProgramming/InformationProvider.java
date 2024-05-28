package EvolutionaryProgramming;

import java.util.ArrayList;

public interface InformationProvider {
	public int getPopSize();
	
	public int getNumEpidemics();
	
	public ArrayList<Solution> getBestSols();
}
