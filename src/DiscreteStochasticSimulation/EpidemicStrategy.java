package DiscreteStochasticSimulation;

import java.util.Random;

/**
 * Class that represents a time increment strategy based on the epidemic event.
 */
public class EpidemicStrategy extends TimeIncrement {
    /** The random number generator. */
    Random random = new Random();
    
    /** The singleton instance of the EpidemicStrategy class. */
    static EpidemicStrategy instance = null;
    
    /** Private constructor to prevent instantiation outside the class. */
    private EpidemicStrategy() {
        // Private constructor to enforce singleton pattern
    }
    
    /**
     * Retrieves the singleton instance of the EpidemicStrategy class.
     * 
     * @return The singleton instance of the EpidemicStrategy class.
     */
    public static EpidemicStrategy getInstance() {
        if (instance == null) {
            instance = new EpidemicStrategy();
        }
        return instance;
    }

    /**
     * Generates a random time increment for an epidemic event based on individual comfort.
     * 
     * @param fitting The comfort value of the individual.
     * @return 1 if the individual survives, 0 if the individual dies.
     */
    @Override
    public double getRandomTime(double fitting) {
        double next = random.nextDouble();
        double probability = (2.0 / 3) * fitting; // Calculate the survival probability based on fitting
        if (next <= probability) {
            return 1; // Individual survives
        } else {
            return 0; // Individual dies
        }
    }
}