package DiscreteStochasticSimulation;

import java.util.Random;

public class DeltaTimeIncrementStrategy extends TimeIncrement{
	Random random;
	static DeltaTimeIncrementStrategy instance=null;
	
	private DeltaTimeIncrementStrategy() {
		
	}
	
	public static DeltaTimeIncrementStrategy getInstance() {
		if(instance == null) {
			instance = new DeltaTimeIncrementStrategy();
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
		return (1-Math.log(fitting))*DiscreteStochasticSimulation.delta;
	}

}
