package DiscreteStochasticSimulation;

public class DiscreteStochasticSimulation {
	static float simulationTime;
	static double rho,mu,delta;
	
	public static void init(float simulationTime_, double rho_, double mu_, double delta_) {
		simulationTime = simulationTime_;
		rho = rho_;
		mu = mu_;
		delta = delta_;
	}
}
