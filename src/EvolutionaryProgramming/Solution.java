package EvolutionaryProgramming;

public interface Solution {
	public double getFitting();
	
	public void generateRandomSolution();
	
	public void mutateSolution();
	
	public void inheritSolution(Solution parentSolution);
	
	public Solution getSolutionObject();
}
