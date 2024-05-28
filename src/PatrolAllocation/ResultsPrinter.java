package PatrolAllocation;

import java.util.ArrayList;
import java.util.Iterator;

import EvolutionaryProgramming.InformationProvider;
import EvolutionaryProgramming.Solution;

public class ResultsPrinter implements PrintCurrentResults{
	
	InformationProvider info = PatrolAllocation.info;
	private static ResultsPrinter instance;
	double currInstant;
	int numEvents, popSize, numEpidemics, obsNum=0;
	ArrayList<Solution> bestSols = new ArrayList<>();

	private ResultsPrinter() {
		
	}
	
	public static ResultsPrinter getInstance() {
		if(instance == null) {
			instance = new ResultsPrinter();
		}
		return instance;
	}
	
	@Override
	public void printCurrentResult(double currInstant_, int numEvents_) {
		numEvents = numEvents_;
		currInstant = currInstant_;
		popSize = info.getPopSize();
		numEpidemics = info.getNumEpidemics();
		bestSols = info.getBestSols();
		Solution sol;
		
		Iterator<Solution> it = bestSols.iterator();
		String offset = "                         "; // 25 spaces for the offset
		
		System.out.println("Observation" + obsNum);
		System.out.println(offset + "Present instant:" + currInstant);
		System.out.println(offset + "Number of realized events:" + numEvents);
		System.out.println(offset + "Population size:" + popSize);
		System.out.println(offset + "Number of epidemics:" + numEpidemics);
		sol = it.next();
		System.out.println(offset + "Best distribution of the patrols:" + sol.toString());
		System.out.println(offset + "Empire policing time:" + sol.getTime());
		System.out.println(offset + "Comfort:" + sol.getFitting());
		sol = it.next();
		System.out.println(offset + "Other candidate distribution:" + sol.toString() + " : " + sol.getTime() + " : " + sol.getFitting());
		for(int i=0; i<4; i++) {
			sol = it.next();
			System.out.println(offset + sol.toString() + " : " + sol.getTime() + " : " + sol.getFitting());
		}
		
	}

}
