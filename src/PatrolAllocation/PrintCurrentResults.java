package PatrolAllocation;

/**
 * Interface for printing current results of the patrol allocation simulation.
 */
public interface PrintCurrentResults {
	/**
     * Prints the current observation of the simulation.
     * 
     * @param currInstant The current instant of the simulation.
     * @param numEvents The number of events in the simulation.
     */
	public void printCurrentResult(double currInstant, int numEvents);
}
