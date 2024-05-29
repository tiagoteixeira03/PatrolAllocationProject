package DiscreteStochasticSimulation;

import java.util.Comparator;
import java.util.Iterator;
import java.util.PriorityQueue;

import EvolutionaryProgramming.IEv;


/**
 * The PEC (Pending Event Container) class represents a queue of pending events in a discrete stochastic simulation.
 * It manages the scheduling and execution of events based on their simulation time.
 */
public class PEC implements EventManager {
    /** The singleton instance of the PEC class. */
	private static PEC instance;
    /** The current simulation time. */
    private double simTime = 0;
    private int numofEventsSim=0;
    
    /** Comparator for sorting events by simulation time. */
	Comparator<IEv> com = new Comparator<IEv>()
	{
			@Override
			public int compare(IEv o1, IEv o2) {
				double t1=o1.getSimTime(), t2=o2.getSimTime();
				if(t1>t2) 
					return 1;
				else if(t1==t2)
					return 0;
				else
					return -1;
			}
	};
	
    /** The priority queue of events sorted by simulation time. */
	private PriorityQueue<IEv> pec = new PriorityQueue<>(com);  
	
    /** Iterator for traversing events in the PEC. */
	Iterator<IEv> it = pec.iterator();
	
    /** Private constructor to prevent instantiation outside the class. */
	private PEC() {}
	
	/**
     * Retrieves the singleton instance of the PEC class.
     * 
     * @return the singleton instance of the PEC class
     */
	public static PEC getInstance() {
		if(instance==null) {
			instance = new PEC();
		}
		return instance;	
	}
	
	/**
     * Schedules an event in the PEC.
     * 
     * @param ev the event to be scheduled
     */
	@Override
	public void scheduleEvent(IEv ev) {
		pec.add(ev);//We need to implement the verification to check if the add is valid
	}
	
	/**
     * Retrieves and removes the next event from the PEC.
     * 
     * @return the next event from the PEC
     */
	public IEv nextEvPEC() {
		IEv nextEvent = null;
		it = pec.iterator();
		
		if(it.hasNext()) {
			nextEvent = it.next();
			it.remove();
		}
		return nextEvent;
	}

	/**
     * Gets the current simulation time.
     * 
     * @return the current simulation time
     */
	@Override
	public double getCurrSimTime() {
		return simTime;
	}
	
	/**
     * Iterates through the events in the PEC, simulating each event and updating the simulation time.
     */
	public void iterateEvents() {
		double nextPrint = DiscreteStochasticSimulation.simulationTime/20;
		double currentTime=nextPrint;
		IEv ev;
		while(it.hasNext()) {
			ev = nextEvPEC();
			simTime += ev.getSimTime();
			if(simTime >= DiscreteStochasticSimulation.simulationTime) {
				DiscreteStochasticSimulation.printResults.printCurrentResult(currentTime, numofEventsSim);
				return;
			}
			if(simTime>=currentTime) {
				DiscreteStochasticSimulation.printResults.printCurrentResult(currentTime, numofEventsSim);
				currentTime += nextPrint;
			}
			ev.simulate(instance);
			numofEventsSim++;
		}
	}

	@Override
	public void removeIdEvents(int id) {
		while(it.hasNext()) {
			if(it.next().getIndID() == id) {
				it.remove();
			}
		}
		it = pec.iterator();
	}
	
	
}