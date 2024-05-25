package PatrolAllocation;

import java.util.ArrayList;
import java.util.List;
import java.util.ListIterator;

import EvolutionaryProgramming.Solution;

public class IndividualSolution implements Solution {
	List<List<Integer>> partition = new ArrayList<List<Integer>>(PatrolAllocation.nrPatrols);
	
	public double getFitting() {
	    double tz = 0, aux = 0;
	    ListIterator<List<Integer>> iterPatrols = partition.listIterator();
	    while (iterPatrols.hasNext()) {
	        List<Integer> patrol = iterPatrols.next();
	        for (Integer element : patrol) { 
	            aux += PatrolAllocation.matrixC[partition.indexOf(patrol)][element];
	        }
	        if (aux > tz)
	            tz = aux;
	        aux = 0;
	    }
	    return PatrolAllocation.tmin / tz;
	}
	
	public void generateRandomSolution() {
		
	}
	
}
