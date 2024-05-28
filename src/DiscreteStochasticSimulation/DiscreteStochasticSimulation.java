package DiscreteStochasticSimulation;

import PatrolAllocation.PrintCurrentResults;

/**
 * Class that represents ??.
 * It manages the initialization of parameters that are specific to the simulation.
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
	static PrintCurrentResults printResults;
	
	/**
     * Initializes the discrete stochastic simulation with the specified parameters.
     *
     * @param simulationTime_ the simulation time
     * @param rho_ the value of the parameter rho
     * @param mu_ the value of the parameter mu
     * @param delta_ the value of the parameter delta
     */
	public static void init(float simulationTime_, double rho_, double mu_, double delta_, PrintCurrentResults printResults_) {
		simulationTime = simulationTime_;
		rho = rho_;
		mu = mu_;
		delta = delta_;
		printResults = printResults_;
	}
}
