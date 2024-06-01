package EvolutionaryProgramming;

import java.util.ArrayList;

/**
 * Class that provides information about the population and solutions.
 */
public class InformationProviderClass implements InformationProvider{
    /** The singleton instance of the InformationProviderClass. */
	static InformationProviderClass instance;
    /** The population instance. */
	Population pop = Population.getInstance();
	
    /** Private constructor to prevent instantiation outside the class. */
	private InformationProviderClass() {
		
	}
	
	/**
     * Retrieves the singleton instance of the InformationProviderClass.
     *
     * @return The singleton instance of the InformationProviderClass.
     */
	public static InformationProviderClass getInstance() {
		if(instance == null) {
			instance = new InformationProviderClass();
		}
		return instance;
	}
	
	/**
     * Gets the size of the population.
     *
     * @return The population size.
     */
	@Override
	public int getPopSize() {
		return pop.currentIndID;
	}

	/**
     * Gets the number of epidemics.
     *
     * @return The number of epidemics.
     */
	@Override
	public int getNumEpidemics() {
		return pop.numEpidemics;
	}

	/**
     * Gets the list of best solutions.
     *
     * @return An ArrayList containing the best solutions.
     */
	@Override
	public ArrayList<Solution> getBestSols() {
		return pop.getBestInds();
	}
}