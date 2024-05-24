package DiscreteStochasticSimulation;
import EvolutionaryProgramming.IEv;

public interface EventManager {
	public void scheduleEvent(IEv ev);
	public float getCurrSimTime();
}
