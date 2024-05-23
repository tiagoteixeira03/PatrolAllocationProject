package DiscreteStochasticSimulation;

import Main.ComponentFactory;

public class DiscreteStochasticSimulationFactory implements ComponentFactory{
	@Override
	public void initialize(String[] args) {
		float simulationTime = Integer.parseInt(args[2]);
		float eventParameter[] = new float[3];

        for (int i = 5; i < 8; i++) {
            eventParameter[i] = Float.parseFloat(args[i]);
        }
        
		DiscreteStochasticSimulation.init(simulationTime, eventParameter);
	}
}
