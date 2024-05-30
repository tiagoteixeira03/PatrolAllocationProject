package PatrolAllocation;

import EvolutionaryProgramming.InformationProvider;
import Main.ComponentFactory;

/**
 * Factory class to initialize the PatrolAllocation components.
 * Implements the ComponentFactory interface to provide initialization logic for the patrol allocation problem.
 */
public class PatrolAllocationFactory implements ComponentFactory {
	
	static InformationProvider info;
	
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
	public void initialize(String[] PAargs) {
		int nrPatrols = Integer.parseInt(PAargs[0]);
		int nrPlanetSystems = Integer.parseInt(PAargs[1]);
		String stringMatrixC = PAargs[2];
		
		new PatrolAllocation();
		
		PatrolAllocation.init(nrPatrols,nrPlanetSystems, stringMatrixC, info);
	}
}