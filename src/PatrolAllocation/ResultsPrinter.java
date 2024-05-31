package PatrolAllocation;

import java.util.ArrayList;
import java.util.Iterator;

import EvolutionaryProgramming.InformationProvider;
import EvolutionaryProgramming.Solution;

public class ResultsPrinter implements PrintCurrentResults {
    
    InformationProvider info = PatrolAllocationFactory.info;
    private static ResultsPrinter instance;
    double currInstant;
    int numEvents, popSize, numEpidemics, obsNum = 1;
    ArrayList<Solution> bestSols = new ArrayList<>();
    double bestFitting;

    private ResultsPrinter() {
    }

    public static ResultsPrinter getInstance() {
        if (instance == null) {
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

        String headerFormat = "%s %s:%n";
        // Add indentation (4 spaces)
        String indent = "               ";
        String dataFormat = indent + "%-35s %s%n";
        String candidateFormat = indent + "%-35s %s : %s : %s%n";

        System.out.printf(headerFormat, "Observation", obsNum);
        System.out.printf(dataFormat, "Present instant:", currInstant);
        System.out.printf(dataFormat, "Number of realized events:", numEvents);
        System.out.printf(dataFormat, "Population size:", popSize);
        System.out.printf(dataFormat, "Number of epidemics:", numEpidemics);

        if (it.hasNext()) {
            sol = it.next();
            System.out.printf(dataFormat, "Best distribution of the patrols:", sol.toString());
            System.out.printf(dataFormat, "Empire policing time:", sol.getTime());
            System.out.printf(dataFormat, "Comfort:", sol.getFitting());
            if (it.hasNext()) {
                sol = it.next();
                System.out.printf(candidateFormat, "Other candidate distribution:", sol.toString(), sol.getTime(), sol.getFitting());
                for (int i = 0; i < 4; i++) {
                    if (it.hasNext()) {
                        sol = it.next();
                        System.out.printf(candidateFormat, "", sol.toString(), sol.getTime(), sol.getFitting());
                    }
                }
            }
        }
        obsNum++;
    }
}
