package PatrolAllocation;

import java.util.Random;

/**
 * Class that handles the initialization and setup of the patrol allocation problem.
 * It initializes the number of patrols, number of planet systems, and the cost matrix.
 */
public class PatrolAllocation {
    /** The random number generator. */
	static Random random;
    /** The number of patrols. */
	static int nrPatrols;
    /** The number of planet systems. */
	static int nrPlanetSystems;
    /** The cost matrix representing the time required for each system to be patrolled by each patrol. */
	static int[][] matrixC;
    /** The lower bound for the optimal time to patrol the empire. */
	static double tmin;
	
	/**
     * Initializes the patrol allocation with the specified number of patrols and planet systems.
     * 
     * @param nrPatrols_ the number of patrols
     * @param nrPlanetSystems_ the number of planet systems
     */
	public static void init(int nrPatrols_, int nrPlanetSystems_) {
		nrPatrols = nrPatrols_;
		nrPlanetSystems = nrPlanetSystems_;
		matrixC = new int[nrPatrols][nrPlanetSystems];
		generateMatrix();
	}
	
	/**
     * Generates the cost matrix with random values and calculates the lower bound for the 
     * optimal time to patrol the empire.
     */
	private static void generateMatrix() {
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
}