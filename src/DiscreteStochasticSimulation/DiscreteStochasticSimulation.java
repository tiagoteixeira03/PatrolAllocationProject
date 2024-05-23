package DiscreteStochasticSimulation;

public class DiscreteStochasticSimulation {
	static float simulationTime;
	static float eventParameter[] = new float[3];
	
	public static void init(float simulationTime_, float eventParameter_[]) {
		simulationTime = simulationTime_;
		System.arraycopy(eventParameter_, 0, eventParameter, 0, eventParameter_.length);
	}
}
