package DiscreteStochasticSimulation;

import java.util.Random;

/**
 * Class that represents a time increment strategy based on the parameter delta.
 * It calculates random time increments using the exponential distribution with a mean 
 * determined by the fitting and delta.
 */
public class DeltaTimeIncrementStrategy extends TimeIncrement {
    /** The random number generator. */
    Random random = new Random();
    
    /** The singleton instance of the DeltaTimeIncrementStrategy class. */
    static DeltaTimeIncrementStrategy instance = null;
    
    /** Private constructor to prevent instantiation outside the class. */
    private DeltaTimeIncrementStrategy() {}
    
    /**
     * Retrieves the singleton instance of the DeltaTimeIncrementStrategy class.
     * 
     * @return The singleton instance of the DeltaTimeIncrementStrategy class.
     */
    public static DeltaTimeIncrementStrategy getInstance() {
        if (instance == null) {
            instance = new DeltaTimeIncrementStrategy();
        }
        return instance;
    }

    /**
     * Generates a random time increment based on the fitting using the exponential 
     * distribution with mean determined by the fitting and delta.
     * 
     * @param fitting The comfort value used to calculate the mean of the exponential distribution.
     * @return A random time increment.
     */
    @Override
    public double getRandomTime(double fitting) {
        double mean = getMean(fitting); // Calculate the mean based on fitting
        double next = random.nextDouble();
        double observation = -mean * Math.log(1.0 - next); // Calculate the time increment using the exponential distribution formula
        // System.out.println("Next Mutation in: " + observation); //Debugging
        return observation;
    }
    
    /**
     * Calculates the mean of the exponential distribution based on the fitting and delta parameters.
     * 
     * @param fitting The comfort value.
     * @return The mean of the exponential distribution.
     */
    private double getMean(double fitting) {
        return (1 - Math.log(fitting)) * DiscreteStochasticSimulation.delta; // Calculate the mean probability of the event
    }
}