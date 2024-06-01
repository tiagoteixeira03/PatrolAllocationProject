package EvolutionaryProgramming;

import java.util.ArrayList;


/**
 * Interface for providing information about the population and solutions.
 */
public interface InformationProvider {
	/**
     * Gets the size of the population.
     *
     * @return The population size.
     */
	public int getPopSize();
	
	/**
     * Gets the number of epidemics.
     *
     * @return The number of epidemics.
     */
	public int getNumEpidemics();
	
	/**
     * Gets the list of best solutions.
     *
     * @return An ArrayList containing the best solutions.
     */
	public ArrayList<Solution> getBestSols();
}
