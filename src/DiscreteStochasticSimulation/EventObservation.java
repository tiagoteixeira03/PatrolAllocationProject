package DiscreteStochasticSimulation;

import EvolutionaryProgramming.IEv;

public class EventObservation implements IEv {
	double simTime;
	
	public EventObservation(double simTime_, PEC pec) {
		this.simTime = simTime_;
		pec.scheduleEvent(this);
	}

	@Override
	public void simulate(EventManager eventmanager) {
		DiscreteStochasticSimulation.printResults.printCurrentResult(eventmanager.getCurrSimTime(), eventmanager.getNumEvents());	
	}

	@Override
	public double getSimTime() {
		return simTime;
	}

	@Override
	public int getIndID() {
		// TODO Auto-generated method stub
		return -1;
	}
}
