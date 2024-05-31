package PatrolAllocation;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.ListIterator;
import java.util.Random;

import EvolutionaryProgramming.Solution;

/**
 * Class that represents an individual solution for patrol allocation.
 */
public class IndividualSolution implements Solution {
    /** The partition of patrols, where each patrol is a list of integers. */
	List<List<Integer>> partition = new ArrayList<List<Integer>>(PatrolAllocation.nrPatrols);
	double time;
	
	/**
     * Calculates the comfort value of the solution.
     * 
     * @return the comfort value of the solution
     */
	public double getFitting() {
	    double tz = 0, aux = 0;
	    ListIterator<List<Integer>> iterPatrols = partition.listIterator();
	    while (iterPatrols.hasNext()) {
	        List<Integer> patrol = iterPatrols.next();
	        for (Integer element : patrol) { 
	            aux += PatrolAllocation.matrixC[partition.indexOf(patrol)][element-1];
	        }
	        if (aux > tz)
	            tz = aux;
	        aux = 0;
	    }
	    time = tz;
	    return PatrolAllocation.tmin / tz;
	}
	
	/**
     * Generates a random solution by randomly assigning planet systems to patrols.
     */
	public void generateRandomSolution() {
        // Step 1: Initialize each patrol list
        for (int i = 0; i < PatrolAllocation.nrPatrols; i++) {
            partition.add(new ArrayList<Integer>());
        }

        // Step 2: Create a list of integers from 1 to m
        List<Integer> numbers = new ArrayList<Integer>();
        for (int i = 1; i <= PatrolAllocation.nrPlanetSystems; i++) {
            numbers.add(i);
        }

        // Step 3: Shuffle the list of integers to ensure randomness
        Collections.shuffle(numbers, new Random());

        // Step 4: Randomly assign each integer to a patrol
        Random rand = new Random();
        for (int number : numbers) {
            int patrolIndex = rand.nextInt(PatrolAllocation.nrPatrols);
            partition.get(patrolIndex).add(number);
        }
	}
	
	/**
     * Mutates the solution by randomly moving an element from one patrol to another.
     */
	public void mutateSolution() {
        Random rand = new Random();

        // Step 1: Select a random patrol that is not empty
        int fromPatrolIndex;
        do {
            fromPatrolIndex = rand.nextInt(PatrolAllocation.nrPatrols);
        } while (partition.get(fromPatrolIndex).isEmpty());

        // Step 2: Remove a random integer from this selected patrol
        List<Integer> fromPatrol = partition.get(fromPatrolIndex);
        int removedIndex = rand.nextInt(fromPatrol.size());
        int removedValue = fromPatrol.remove(removedIndex);

        // Step 3: Select another patrol (different from the one we removed the integer from)
        int toPatrolIndex;
        do {
            toPatrolIndex = rand.nextInt(PatrolAllocation.nrPatrols);
        } while (toPatrolIndex == fromPatrolIndex);

        // Step 4: Add the removed integer to the selected patrol
        partition.get(toPatrolIndex).add(removedValue);
	}
	
	/**
     * Inherits properties from a parent solution by copying the parent's partition and then 
     * randomly adjusting it.
     * 
     * @param parentSolution the parent solution from which to inherit properties
     */
	public void inheritSolution(Solution parentSolution) {
		IndividualSolution parent = (IndividualSolution) parentSolution;
	    
	    // Clear the current partition
	    partition.clear();

	    // Deep copy each list from the parent partition to this partition
	    for (List<Integer> parentList : parent.partition) {
	        List<Integer> newList = new ArrayList<>(parentList);  // Create a new list with the same elements
	        partition.add(newList);
	    }
	    
	    Random rand = new Random();
	    List<Integer> removedIntegers = new ArrayList<>();
	    List<Integer> removedFromPatrols = new ArrayList<>();
	    
	    int IntegersToRemove = (int) Math.floor((1 - this.getFitting()) * PatrolAllocation.nrPlanetSystems);

	    // Step 1: Randomly remove IntegersToRemove integers from the patrols
	    for (int i = 0; i < IntegersToRemove; i++) {
	        int fromPatrolIndex;
	        do {
	            fromPatrolIndex = rand.nextInt(PatrolAllocation.nrPatrols);
	        } while (partition.get(fromPatrolIndex).isEmpty());

	        List<Integer> fromPatrol = partition.get(fromPatrolIndex);
	        int removedIndex = rand.nextInt(fromPatrol.size());
	        int removedValue = fromPatrol.remove(removedIndex);
	        
	        removedIntegers.add(removedValue);
	        removedFromPatrols.add(fromPatrolIndex);
	    }

	    // Step 2: Shuffle the removed integers to ensure random redistribution
	    Collections.shuffle(removedIntegers, rand);

	    // Step 3: Randomly redistribute the removed integers across the patrols
	    for (int i = 0; i < removedIntegers.size(); i++) {
	        int removedValue = removedIntegers.get(i);
	        int originalPatrol = removedFromPatrols.get(i);
	        
	        // Generate a random index between 0 and nrPatrols-1, excluding the original patrol
	        int toPatrolIndex;
	        do {
	            toPatrolIndex = rand.nextInt(PatrolAllocation.nrPatrols);
	        } while (toPatrolIndex == originalPatrol);

	        partition.get(toPatrolIndex).add(removedValue);
	    }
	}
	
	/**
     * Gets a new instance of the IndividualSolution.
     * 
     * @return a new IndividualSolution object
     */
	public Solution getSolutionObject() {
		return new IndividualSolution();
	}
	
	@Override
	public String toString() {
		StringBuilder sb = new StringBuilder();
        sb.append("{");

        for (int i = 0; i < partition.size(); i++) {
            List<Integer> innerList = partition.get(i);
            sb.append("{");
            for (int j = 0; j < innerList.size(); j++) {
                sb.append(innerList.get(j));
                if (j < innerList.size() - 1) {
                    sb.append(",");
                }
            }
            sb.append("}");
            if (i < partition.size() - 1) {
                sb.append(",");
            }
        }

        sb.append("}");
        return sb.toString();
	}
	
	public double getTime() {
		return time;
	}
	
	public IndividualSolution cloneObject() {
		IndividualSolution sol;
		List<List<Integer>> copyPartition = new ArrayList<List<Integer>>(PatrolAllocation.nrPatrols);
		
		for (List<Integer> copy : partition) {
            List<Integer> newList = new ArrayList<>(copy);  // Create a new list with the same elements
            copyPartition.add(newList);
        }
		
		sol = new IndividualSolution();
		sol.partition = copyPartition;
		
		return sol;
		
	}
	
	public boolean isSolEqual(Solution sol2) { 
		
		IndividualSolution indSol2 = (IndividualSolution)sol2;
		
		for (int i = 0; i < partition.size(); i++) {
            List<Integer> list1 = partition.get(i);
            List<Integer> list2 = indSol2.partition.get(i);
            // Check if both inner lists are null
            if (list1 == null && list2 == null) {
                continue;
            }
            // Check if one of the inner lists is null
            if (list1 == null || list2 == null) {
                return false;
            }
            // Check if the inner lists are equal
            if (!list1.equals(list2)) {
                return false;
            }
        }
        return true;
    }
}