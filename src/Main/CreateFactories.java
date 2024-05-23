package Main;

import java.util.ArrayList;
import java.util.List;
import PatrolAllocation.PatrolAllocationFactory;
import DiscreteStochasticSimulation.DiscreteStochasticSimulationFactory;
import EvolutionaryProgramming.EvolutionaryProgrammingFactory;

public class CreateFactories {
	private List<ComponentFactory> factories;
	
	public CreateFactories() {
		factories = new ArrayList<>();
		factories.add(new PatrolAllocationFactory());
		factories.add(new DiscreteStochasticSimulationFactory());
		factories.add(new EvolutionaryProgrammingFactory());
	}
	
	public void initializeComponents(String[] args) {
		for (ComponentFactory factory : factories) {
			factory.initialize(args);
		}
	}
}
