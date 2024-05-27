package EvolutionaryProgramming;

/**
 * Interface that lets the Evolutionary Programming package acknowledge an upcoming event's simulation time.
 */
public interface TimeIncrementStrategy {
	/**
     * Abstract method that generates a random time increment based on the comfort of an individual.
     * 
     * @param fitting the comfort value of an individual
     */
	public double getRandomTime(double fitting);
}
