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
	static InformationProvider info;
	
	/**
     * Initializes the patrol allocation with the specified number of patrols and planet systems.
     * 
     * @param nrPatrols_ the number of patrols
     * @param nrPlanetSystems_ the number of planet systems
     */
	public static void init(int nrPatrols_, int nrPlanetSystems_, String stringMatrixC, InformationProvider info_) {
		nrPatrols = nrPatrols_;
		nrPlanetSystems = nrPlanetSystems_;
		matrixC = new int[nrPatrols][nrPlanetSystems];
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
		int minLine=11;
		
		for(int i=0; i<nrPatrols; i++) {
			for(int j=0; j<nrPlanetSystems; j++) {
				matrixC[i][j] = random.nextInt(10) + 1;
				if(matrixC[i][j] < minLine)
					minLine = matrixC[i][j];					
			}
			tmin +=minLine;
			minLine=11;
		}
		tmin = tmin/nrPatrols;
	}
	
	private static void generateUserMatrix(String stringMatrixC) {
		String[] arrayMatrixC = stringMatrixC.split("-");
		int aux = 0;
		for(int i=0; i<nrPatrols; i++) {
			for(int j=0; j<nrPlanetSystems; j++) {
				matrixC[i][j] = Integer.parseInt(arrayMatrixC[aux]);
				aux++;
			}
		}
	}
}