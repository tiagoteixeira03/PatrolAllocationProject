package DiscreteStochasticSimulation;

import Main.ComponentFactory;
import PatrolAllocation.PrintCurrentResults;

/**
 * Factory class to create and initialize the discrete stochastic simulation components.
 * Sets up parameters that are specific to the simulation.
 */
public class DiscreteStochasticSimulationFactory implements ComponentFactory{
    /** Holds a reference to any object that implements the PrintCurrentResults interface. */
	PrintCurrentResults printResults;
	
	/**
     * Constructor for DiscreteStochasticSimulationFactory.
     *
     * @param printResults_ The object implementing the PrintCurrentResults interface.
     */
	public DiscreteStochasticSimulationFactory(PrintCurrentResults printResults_) {
		printResults = printResults_;
	}
	
	/**
     * Initializes the discrete stochastic simulation with parameters provided through command-line arguments.
     * 
     * @param DSSargs The command-line arguments containing simulation parameters.
     */
	@Override
	public void initialize(String[] DSSargs) {
		float simulationTime = Integer.parseInt(DSSargs[0]);
		double mu = Double.parseDouble(DSSargs[1]),rho = Double.parseDouble(DSSargs[2]), delta = Double.parseDouble(DSSargs[3]);
        
		new DiscreteStochasticSimulation();
		
		DiscreteStochasticSimulation.init(simulationTime, mu, rho, delta, printResults);
	}
}
