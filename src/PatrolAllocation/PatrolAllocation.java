package PatrolAllocation;

import java.util.Random;

import EvolutionaryProgramming.InformationProvider;

/**
 * Class that handles the initialization and setup of the patrol allocation problem.
 * It initializes the number of patrols, number of planet systems, and the cost matrix.
 */
public class PatrolAllocation {
    /** The random number generator. */
	static Random random = new Random();
    /** The number of patrols. */
	static int nrPatrols;
    /** The number of planet systems. */
	static int nrPlanetSystems;
    /** The cost matrix representing the time required for each system to be patrolled by each patrol. */
	static int[][] matrixC;
    /** The lower bound for the optimal time to patrol the empire. */
	static double tmin;
    /** The information provider. */
	static InformationProvider info;
	
	/**
     * Initializes the patrol allocation with the specified number of patrols and planet systems.
     * 
     * @param nrPatrols_ The number of patrols.
     * @param nrPlanetSystems_ The number of planet systems.
     * @param stringMatrixC A string representation of the cost matrix.
     * @param info_ The information provider for the simulation.
     */
	public static void init(int nrPatrols_, int nrPlanetSystems_, String stringMatrixC, InformationProvider info_) {
		nrPatrols = nrPatrols_;
		nrPlanetSystems = nrPlanetSystems_;
		matrixC = new int[nrPatrols][nrPlanetSystems];
		//If the user selected -r as an argument create a random matrix
		if(stringMatrixC.equals("RANDOM_MATRIX")) {
			generateRandomMatrix();
		}
		else {
			generateUserMatrix(stringMatrixC);
		}
		info = info_;
	}
	
	/**
     * Generates the cost matrix with random values and calculates the lower bound for the 
     * optimal time to patrol the empire.
     */
	private static void generateRandomMatrix() {
		int aux=0, min=11;
		double sum=0;
		
		for(int i=0; i<nrPatrols; i++) {
			for(int j=0; j<nrPlanetSystems; j++) {
				matrixC[i][j] = random.nextInt(10) + 1;					
			}
		}
		
		for(int j=0; j<nrPlanetSystems; j++) {
			for(int i=0; i<nrPatrols; i++) {
				aux = matrixC[i][j];
				if(min > aux) {
					min = aux;
				}
			}
			sum += min;
			min = 11;
		}
		tmin = sum/nrPatrols;
	}
	
	/**
     * Generates the cost matrix from the provided string representation and calculates the lower bound for the 
     * optimal time to patrol the empire.
     * 
     * @param stringMatrixC A string representation of the cost matrix.
     */
	private static void generateUserMatrix(String stringMatrixC) {
		int min=11;
		double sum=0;
		String[] arrayMatrixC = stringMatrixC.split("-");
		int aux = 0;
		for(int i=0; i<nrPatrols; i++) {
			for(int j=0; j<nrPlanetSystems; j++) {
				matrixC[i][j] = Integer.parseInt(arrayMatrixC[aux]);
				aux++;
			}
		}
		
		for(int j=0; j<nrPlanetSystems; j++) {
			for(int i=0; i<nrPatrols; i++) {
				aux = matrixC[i][j];
				if(min > aux) {
					min = aux;
				}
			}
			sum += min;
			min = 11;
		}
		tmin = sum/nrPatrols;
	}
}