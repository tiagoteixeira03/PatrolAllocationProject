package DiscreteStochasticSimulation;

import java.util.Random;

public class MuTimeIncrementStrategy extends TimeIncrement{
	Random random;
	static MuTimeIncrementStrategy instance=null;
	
	private MuTimeIncrementStrategy() {
		
	}
	
	public static MuTimeIncrementStrategy getInstance() {
		if(instance == null) {
			instance = new MuTimeIncrementStrategy();
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
		return (1-Math.log(1-fitting))*DiscreteStochasticSimulation.mu;
	}
}
