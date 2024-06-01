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
    /** Singleton instance of ResultsPrinter. */
	private ResultsPrinter resultsPrinter = ResultsPrinter.getInstance();
    /** Singleton instance of InformationProviderClass. */
	private InformationProviderClass info = InformationProviderClass.getInstance();
	
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
		factories.add(new PatrolAllocationFactory(info));
		factories.add(new DiscreteStochasticSimulationFactory(resultsPrinter));
		factories.add(new EvolutionaryProgrammingFactory(strategies, new IndividualSolution(), pec));
	}
	
	/**
     * Initializes the components with the specified arguments.
     * 
     * @param args The arguments used to initialize the components.
     */
	public void initializeComponents(String[] args) {
	    // Extract arguments for PatrolAllocationFactory
	    String[] patrolAllocationArgs = { args[0], args[1], args[8] };

	    // Extract arguments for DiscreteStochasticSimulationFactory
	    String[] discreteStochasticArgs = { args[2], args[5], args[6], args[7] };

	    // Extract arguments for EvolutionaryProgrammingFactory
	    String[] evolutionaryProgrammingArgs = { args[3], args[4]};

	    // Initialize each factory with their specific arguments
	    factories.get(0).initialize(patrolAllocationArgs);
	    factories.get(1).initialize(discreteStochasticArgs);
	    factories.get(2).initialize(evolutionaryProgrammingArgs);

	    // Iterate events
	    pec.iterateEvents();
	}
}