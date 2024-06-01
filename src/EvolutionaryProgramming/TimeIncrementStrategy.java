package EvolutionaryProgramming;

/**
 * Interface that lets the Evolutionary Programming package acknowledge an upcoming event's simulation time.
 */
public interface TimeIncrementStrategy {
	/**
     * Abstract method that generates a random time increment based on the comfort of an individual.
     * 
     * @param fitting The comfort value of an individual.
     * @return A random time increment.
     */
	public double getRandomTime(double fitting);
}
