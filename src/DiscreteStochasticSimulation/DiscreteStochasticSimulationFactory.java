package DiscreteStochasticSimulation;

import Main.ComponentFactory;

public class DiscreteStochasticSimulationFactory implements ComponentFactory{
	@Override
	public void initialize(String[] args) {
		float simulationTime = Integer.parseInt(args[2]);
		double mu = Double.parseDouble(args[5]),rho = Double.parseDouble(args[6]), delta = Double.parseDouble(args[7]);
        
		DiscreteStochasticSimulation.init(simulationTime, mu, rho, delta);
	}
}
