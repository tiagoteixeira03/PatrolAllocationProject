package DiscreteStochasticSimulation;

import java.util.Random;

/**
 * Class that represents a time increment strategy based on the parameter mu.
 * It calculates random time increments using the exponential distribution with a mean 
 * determined by the comfort and mu.
 */
public class MuTimeIncrementStrategy extends TimeIncrement{
    /** The random number generator. */
	Random random = new Random();
    /** The singleton instance of the MuTimeIncrementStrategy class. */
	static MuTimeIncrementStrategy instance=null;
	
    /** Private constructor to prevent instantiation outside the class. */
	private MuTimeIncrementStrategy() {
		
	}
	
	/**
     * Retrieves the singleton instance of the MuTimeIncrementStrategy class.
     * 
     * @return the singleton instance of the MuTimeIncrementStrategy class
     */
	public static MuTimeIncrementStrategy getInstance() {
		if(instance == null) {
			instance = new MuTimeIncrementStrategy();
		}
		return instance;
	}

	/**
     * Generates a random time increment based on the comfort using the exponential 
     * distribution with mean determined by the comfort and mu.
     * 
     * @param fitting the comfort value used to calculate the mean of the exponential distribution
     * @return a random time increment
     */
	@Override
	public double getRandomTime(double fitting) {
		double m = getMean(fitting);
		double next = random.nextDouble();
		double observation = -m*Math.log(1.0-next);
//		System.out.println("Event will live for: " + observation);
		return observation;
	}
	
	/**
     * Calculates the mean of the exponential distribution based on the comfort and mu parameters.
     * 
     * @param fitting the comfort value
     * @return the mean of the exponential distribution
     */
	private double getMean(double fitting) {
		return (1-Math.log(1-fitting))*DiscreteStochasticSimulation.mu;
	}
}
