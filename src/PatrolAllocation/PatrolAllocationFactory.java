package PatrolAllocation;

import EvolutionaryProgramming.InformationProvider;
import Main.ComponentFactory;

/**
 * Factory class to initialize the PatrolAllocation components.
 * Implements the ComponentFactory interface to provide initialization logic for the patrol allocation problem.
 */
public class PatrolAllocationFactory implements ComponentFactory {
    /** The information provider for the simulation. */
	static InformationProvider info;
	
	/**
     * Constructs a PatrolAllocationFactory with the specified information provider.
     * 
     * @param info_ The information provider for the simulation.
     */
	public PatrolAllocationFactory(InformationProvider info_) {
		info = info_;
	}
	
	/**
     * Initializes the PatrolAllocation component with the specified arguments.
     * 
     * @param PAargs The command-line arguments containing simulation parameters.
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