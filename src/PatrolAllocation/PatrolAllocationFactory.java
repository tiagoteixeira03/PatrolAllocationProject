package PatrolAllocation;

import EvolutionaryProgramming.InformationProvider;
import Main.ComponentFactory;

/**
 * Factory class to initialize the PatrolAllocation components.
 * Implements the ComponentFactory interface to provide initialization logic for the patrol allocation problem.
 */
public class PatrolAllocationFactory implements ComponentFactory {
	
	InformationProvider info;
	
	public PatrolAllocationFactory(InformationProvider info_) {
		info = info_;
	}
	
	/**
     * Initializes the PatrolAllocation component with the specified arguments.
     * 
     * @param args the arguments used to initialize the PatrolAllocation component. 
     *             arg[0] the number of patrols, 
     *             arg[1] the number of planet systems.
     */
	@Override
	public void initialize(String[] args) {
		int nrPatrols = Integer.parseInt(args[0]);
		int nrPlanetSystems = Integer.parseInt(args[1]);
		
		PatrolAllocation.init(nrPatrols,nrPlanetSystems, info);
	}
}