package PatrolAllocation;

import java.util.Random;

public class PatrolAllocation {
	static Random random;
	static int nrPatrols;
	static int nrPlanetSystems;
	static int[][] matrixC;
	static double tmin;
	
	public static void init(int nrPatrols_, int nrPlanetSystems_) {
		nrPatrols = nrPatrols_;
		nrPlanetSystems = nrPlanetSystems_;
		matrixC = new int[nrPatrols][nrPlanetSystems];
		generateMatrix();
	}
	
	private static void generateMatrix() {
		int minLine=0;
		
		for(int i=0; i<nrPatrols; i++) {
			for(int j=0; j<nrPlanetSystems; j++) {
				matrixC[i][j] = random.nextInt(10) + 1;
				if(matrixC[i][j] < minLine)
					minLine = matrixC[i][j];					
			}
			tmin +=minLine;
			minLine=0;
		}
		tmin = tmin/nrPatrols;
	}
}
