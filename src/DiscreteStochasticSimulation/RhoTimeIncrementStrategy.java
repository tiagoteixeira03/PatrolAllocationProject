package DiscreteStochasticSimulation;

import java.util.Random;

/**
 * Class that represents a time increment strategy based on the parameter rho.
 * It calculates random time increments using the exponential distribution with a mean 
 * determined by the comfort and rho.
 */
public class RhoTimeIncrementStrategy extends TimeIncrement{
    /** The random number generator. */
	Random random = new Random();
    /** The singleton instance of the RhoTimeIncrementStrategy class. */
	static RhoTimeIncrementStrategy instance=null;
	
    /** Private constructor to prevent instantiation outside the class. */
	private RhoTimeIncrementStrategy() {
		
	}
	
	/**
     * Retrieves the singleton instance of the RhoTimeIncrementStrategy class.
     * 
     * @return The singleton instance of the RhoTimeIncrementStrategy class.
     */
	public static RhoTimeIncrementStrategy getInstance() {
		if(instance == null) {
			instance = new RhoTimeIncrementStrategy();
		}
		return instance;
	}

	/**
     * Generates a random time increment based on the comfort using the exponential 
     * distribution with mean determined by the comfort and rho.
     * 
     * @param fitting The comfort value used to calculate the mean of the exponential distribution.
     * @return A random time increment.
     */
	@Override
	public double getRandomTime(double fitting) {
		double m = getMean(fitting);
		double next = random.nextDouble();
		double observation = -m*Math.log(1.0-next);
		return observation;
	}
	
	/**
     * Calculates the mean of the exponential distribution based on the comfort and rho parameters.
     * 
     * @param fitting The comfort value.
     * @return The mean of the exponential distribution.
     */
	private double getMean(double fitting) {
		return (1-Math.log(fitting))*DiscreteStochasticSimulation.rho;
	}
}