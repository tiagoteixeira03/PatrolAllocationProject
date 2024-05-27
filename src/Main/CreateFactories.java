package Main;

import java.util.ArrayList;
import java.util.List;

import EvolutionaryProgramming.*;
import DiscreteStochasticSimulation.*;
import PatrolAllocation.*;

/**
 * Class that creates and initializes the factories.
 * It manages a list of factories and strategies, and initializes them with the provided arguments.
 */
public class CreateFactories {
    /** List of component factories. */
	private List<ComponentFactory> factories;
    /** List of time increment strategies. */
	private List<TimeIncrementStrategy> strategies;
    /** Singleton instance of MuTimeIncrementStrategy. */
	private MuTimeIncrementStrategy mu = MuTimeIncrementStrategy.getInstance();
    /** Singleton instance of RhoTimeIncrementStrategy. */
	private RhoTimeIncrementStrategy rho = RhoTimeIncrementStrategy.getInstance();
    /** Singleton instance of DeltaTimeIncrementStrategy. */
	private DeltaTimeIncrementStrategy delta = DeltaTimeIncrementStrategy.getInstance();
    /** Singleton instance of EpidemicStrategy. */
	private EpidemicStrategy epidemic = EpidemicStrategy.getInstance();
    /** Singleton instance of PEC (Priority Event Container). */
	private PEC pec = PEC.getInstance();
	
	/**
     * Constructor that initializes the lists of strategies and factories.
     */
	public CreateFactories() {
		strategies = new ArrayList<>();
		strategies.add(rho);
		strategies.add(mu);
		strategies.add(delta);
		strategies.add(epidemic);
		factories = new ArrayList<>();
		factories.add(new PatrolAllocationFactory());
		factories.add(new DiscreteStochasticSimulationFactory());
		factories.add(new EvolutionaryProgrammingFactory(strategies, new IndividualSolution(), pec));
	}
	
	/**
     * Initializes the components with the specified arguments.
     * 
     * @param args the arguments used to initialize the components
     */
	public void initializeComponents(String[] args) {
		for (ComponentFactory factory : factories) {
			factory.initialize(args);
		}
	}
}