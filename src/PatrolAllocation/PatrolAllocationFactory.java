package PatrolAllocation;

import Main.ComponentFactory;

public class PatrolAllocationFactory implements ComponentFactory {
	@Override
	public void initialize(String[] args) {
		int nrPatrols = Integer.parseInt(args[0]);
		int nrPlanetSystems = Integer.parseInt(args[1]);
		
		PatrolAllocation.init(nrPatrols,nrPlanetSystems);
	}
}