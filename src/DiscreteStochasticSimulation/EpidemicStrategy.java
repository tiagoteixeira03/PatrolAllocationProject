package DiscreteStochasticSimulation;

import java.util.Random;

/**
 * Class that represents a time increment strategy based on the epidemic event.
 */
public class EpidemicStrategy extends TimeIncrement{
    /** The random number generator. */
	Random random = new Random();
    /** The singleton instance of the EpidemicStrategy class. */
	static EpidemicStrategy instance=null;
	
    /** Private constructor to prevent instantiation outside the class. */
	private EpidemicStrategy() {
		
	}
	
	/**
     * Retrieves the singleton instance of the EpidemicStrategy class.
     * 
     * @return the singleton instance of the EpidemicStrategy class
     */
	public static EpidemicStrategy getInstance() {
		if(instance == null) {
			instance = new EpidemicStrategy();
		}
		return instance;
	}

	/**
     * Generates a random time increment for an epidemic event based on individual comfort.
     * 
     * @param fitting the comfort value of the individual
     * @return 1 if the individual survives, 0 if the individual dies
     */
	@Override
	public double getRandomTime(double fitting) {
		double next = random.nextDouble();
		double probability = (2/3)*fitting;
		if(next<=probability) {
			return 1; //Individual lives
		}
		else {
			return 0; //Individual dies
		}
		
	}
}
