package DiscreteStochasticSimulation;

import PatrolAllocation.PrintCurrentResults;

/**
 * Class that has the parameters required by the DiscreteStochasticSimulation package.
 */
public class DiscreteStochasticSimulation {
    /** The simulation time. */
	static float simulationTime;
    /** The value of the parameter rho used in the simulation. */
	static double rho;
    /** The value of the parameter mu used in the simulation. */
	static double mu;
    /** The value of the parameter delta used in the simulation. */
	static double delta;
    /** Holds a reference to any object that implements the PrintCurrentResults interface. */
	static PrintCurrentResults printResults;
	
	/**
     * Initializes the discrete stochastic simulation with the specified parameters.
     *
     * @param simulationTime_ The simulation time.
     * @param mu_ The value of the parameter mu.
     * @param rho_ The value of the parameter rho.
     * @param delta_ The value of the parameter delta.
     * @param printResults_ Holds a reference to any object that implements the PrintCurrentResults interface.
     */
	public static void init(float simulationTime_, double mu_, double rho_, double delta_, PrintCurrentResults printResults_) {
		simulationTime = simulationTime_;
		rho = rho_;
		mu = mu_;
		delta = delta_;
		printResults = printResults_;
	}
}