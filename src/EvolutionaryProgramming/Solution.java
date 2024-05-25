package EvolutionaryProgramming;

public interface Solution {
	public float getFitting();
	
	public void generateRandomSolution();
	
	public void mutateSolution();
	
	public void inheritSolution();
}
