package PatrolAllocation;

import java.util.ArrayList;
import java.util.Iterator;

import EvolutionaryProgramming.InformationProvider;
import EvolutionaryProgramming.Solution;

public class ResultsPrinter implements PrintCurrentResults{
	
	InformationProvider info = PatrolAllocationFactory.info;
	private static ResultsPrinter instance;
	double currInstant;
	int numEvents, popSize, numEpidemics, obsNum=1;
	ArrayList<Solution> bestSols = new ArrayList<>();
	double bestFitting;

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
		popSize = PatrolAllocation.info.getPopSize();
		numEpidemics = PatrolAllocation.info.getNumEpidemics();
		bestSols = PatrolAllocation.info.getBestSols();
		Solution sol;
		
		Iterator<Solution> it = bestSols.iterator();
		String offset = "                         "; // 25 spaces for the offset
		
		System.out.println("Observation" + " " + obsNum);
		System.out.println(offset + "Present instant:" + currInstant);
		System.out.println(offset + "Number of realized events:" + numEvents);
		System.out.println(offset + "Population size:" + popSize);
		System.out.println(offset + "Number of epidemics:" + numEpidemics);
		if(it.hasNext()) {
			sol = it.next();
			System.out.println(offset + "Best distribution of the patrols:" + sol.toString());
			System.out.println(offset + "Empire policing time:" + sol.getTime());
			System.out.println(offset + "Comfort:" + sol.getFitting());
			if(it.hasNext()) {
				sol = it.next();
				System.out.println(offset + "Other candidate distribution:" + sol.toString() + " : " + sol.getTime() + " : " + sol.getFitting());
				for(int i=0; i<4; i++) {
					if(it.hasNext()) {
						sol = it.next();
						System.out.println(offset + sol.toString() + " : " + sol.getTime() + " : " + sol.getFitting());
					}
				}
			}
		}
		obsNum++;
	}

}
