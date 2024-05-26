package DiscreteStochasticSimulation;

import java.util.Random;

public class RhoTimeIncrementStrategy extends TimeIncrement{
	Random random;
	static RhoTimeIncrementStrategy instance=null;
	
	private RhoTimeIncrementStrategy() {
		
	}
	
	public static RhoTimeIncrementStrategy getInstance() {
		if(instance == null) {
			instance = new RhoTimeIncrementStrategy();
		}
		return instance;
	}

	@Override
	public double getRandomTime(double fitting) {
		double m = getMean(fitting);
		double next = random.nextDouble();
		return -m*Math.log(1.0-next);
		
	}
	
	private double getMean(double fitting) {
		return (1-Math.log(fitting))*DiscreteStochasticSimulation.rho;
	}
	
	
	
	
}
