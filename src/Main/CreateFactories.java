package Main;

import java.util.ArrayList;
import java.util.List;

import EvolutionaryProgramming.*;
import DiscreteStochasticSimulation.*;
import PatrolAllocation.*;


public class CreateFactories {
	private List<ComponentFactory> factories;
	private List<TimeIncrementStrategy> strategies;
	private MuTimeIncrementStrategy mu = MuTimeIncrementStrategy.getInstance();
	private RhoTimeIncrementStrategy rho = RhoTimeIncrementStrategy.getInstance();
	private DeltaTimeIncrementStrategy delta = DeltaTimeIncrementStrategy.getInstance();
	
	public CreateFactories() {
		strategies = new ArrayList<>();
		strategies.add(rho);
		strategies.add(mu);
		strategies.add(delta);
		factories = new ArrayList<>();
		factories.add(new PatrolAllocationFactory());
		factories.add(new DiscreteStochasticSimulationFactory());
		factories.add(new EvolutionaryProgrammingFactory(strategies, new IndividualSolution()));
	}
	
	public void initializeComponents(String[] args) {
		for (ComponentFactory factory : factories) {
			factory.initialize(args);
		}
	}
}
