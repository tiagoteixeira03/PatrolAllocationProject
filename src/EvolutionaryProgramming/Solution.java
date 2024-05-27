package EvolutionaryProgramming;

/**
 * Interface that represents a solution.
 */
public interface Solution {
	/**
     * Gets the comfort value of the solution.
     * 
     * @return the comfort value of the solution
     */
	public double getFitting();
	
	/**
     * Generates a random solution.
     */
	public void generateRandomSolution();
	
	/**
     * Mutates the solution.
     */
	public void mutateSolution();
	
	/**
     * Inherits properties from a parent solution.
     * 
     * @param parentSolution the parent solution from which to inherit properties
     */
	public void inheritSolution(Solution parentSolution);
	
	/**
     * Gets the solution object.
     * 
     * @return the solution object
     */
	public Solution getSolutionObject();
}
