package EvolutionaryProgramming;

import PatrolAllocation.IndividualSolution;

/**
 * Interface that represents a solution.
 */
public interface Solution {
	/**
     * Gets the comfort value of the solution.
     * 
     * @return The comfort value of the solution.
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
     * @param parentSolution The parent solution from which to inherit properties.
     */
	public void inheritSolution(Solution parentSolution);
	
	/**
     * Gets the solution object.
     * 
     * @return The solution object.
     */
	public Solution getSolutionObject();
	
	/**
     * Gets the time associated with the solution.
     *
     * @return The time associated with the solution.
     */
	public double getTime();
	
	/**
     * Clones the solution object.
     *
     * @return A cloned instance of the solution object.
     */
	public IndividualSolution cloneObject();
	
	/**
     * Checks if two solutions are equal.
     *
     * @param sol2 The solution to compare.
     * @return True if the solutions are equal, otherwise false.
     */
	public boolean isSolEqual(Solution sol2);
}
