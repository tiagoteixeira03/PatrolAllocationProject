package PatrolAllocation;

import java.util.ArrayList;
import java.util.Iterator;

import EvolutionaryProgramming.InformationProvider;
import EvolutionaryProgramming.Solution;

/**
 * Class responsible for printing the current results of the patrol allocation simulation.
 */
public class ResultsPrinter implements PrintCurrentResults {
    /** The instance of the InformationProvider used to retrieve simulation data. */
    InformationProvider info = PatrolAllocationFactory.info;
    /** The singleton instance of the ResultsPrinter class. */
    private static ResultsPrinter instance;
    /** The current instant of the simulation. */
    double currInstant;
    /** The number of events in the simulation. */
    int numEvents;
    /** The size of the population in the simulation. */
    int popSize;
    /** The number of epidemics in the simulation. */
    int numEpidemics;
    /** The observation number. */
    int obsNum = 1;
    /** The list of best solutions found during the simulation. */
    ArrayList<Solution> bestSols = new ArrayList<>();
    /** The best fitting value found during the simulation. */
    double bestFitting;

    /**
     * Private constructor for the ResultsPrinter class.
     * Prevents instantiation from outside the class.
     */
    private ResultsPrinter() {}

    /**
     * Retrieves the singleton instance of the ResultsPrinter class.
     * 
     * @return The singleton instance of the ResultsPrinter class.
     */
    public static ResultsPrinter getInstance() {
        if (instance == null) {
            instance = new ResultsPrinter();
        }
        return instance;
    }

    /**
     * Prints the current observation of the simulation.
     * 
     * @param currInstant_ The current instant of the simulation.
     * @param numEvents_ The number of events in the simulation.
     */
    @Override
    public void printCurrentResult(double currInstant_, int numEvents_) {
        // Update the current state of the simulation
        numEvents = numEvents_;
        currInstant = currInstant_;
        popSize = PatrolAllocation.info.getPopSize();
        numEpidemics = PatrolAllocation.info.getNumEpidemics();
        bestSols = PatrolAllocation.info.getBestSols();
        Solution sol;

        // Iterator to traverse through the best solutions
        Iterator<Solution> it = bestSols.iterator();

        // Formats for printing the results
        String headerFormat = "%s %s:%n";
        String indent = "               ";
        String dataFormat = indent + "%-35s %s%n";
        String candidateFormat = indent + "%-35s %s : %s : %s%n";
        
        // Print the observation header
        System.out.printf(headerFormat, "Observation", obsNum);
        // Print the current state data
        System.out.printf(dataFormat, "Present instant:", currInstant);
        System.out.printf(dataFormat, "Number of realized events:", numEvents);
        System.out.printf(dataFormat, "Population size:", popSize);
        System.out.printf(dataFormat, "Number of epidemics:", numEpidemics);

        // Print the best solution and other candidate solutions if available
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
        // Increment the observation number for the next print
        obsNum++;
    }
}
