package DiscreteStochasticSimulation;

import Main.ComponentFactory;
import PatrolAllocation.PrintCurrentResults;

/**
 * Factory class to create and initialize the discrete stochastic simulation components.
 * Sets up parameters that are specific to the simulation.
 */
public class DiscreteStochasticSimulationFactory implements ComponentFactory{
	
	PrintCurrentResults printResults;
	
	public DiscreteStochasticSimulationFactory(PrintCurrentResults printResults_) {
		printResults = printResults_;
	}
	
	/**
     * Initializes the discrete stochastic simulation with parameters provided through command-line arguments.
     * 
     * @param args the command-line arguments containing simulation parameters
     *             args[2]: simulation time
     *             args[5]: mu (parameter for the simulation)
     *             args[6]: rho (parameter for the simulation)
     *             args[7]: delta (parameter for the simulation)
     */
	@Override
	public void initialize(String[] args) {
		float simulationTime = Integer.parseInt(args[2]);
		double mu = Double.parseDouble(args[5]),rho = Double.parseDouble(args[6]), delta = Double.parseDouble(args[7]);
        
		DiscreteStochasticSimulation.init(simulationTime, mu, rho, delta, printResults);
	}
}
