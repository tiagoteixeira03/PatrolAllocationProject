package DiscreteStochasticSimulation;

import java.util.Random;

public class EpidemicStrategy extends TimeIncrement{
	Random random;
	static EpidemicStrategy instance=null;
	
	private EpidemicStrategy() {
		
	}
	
	public static EpidemicStrategy getInstance() {
		if(instance == null) {
			instance = new EpidemicStrategy();
		}
		return instance;
	}

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
