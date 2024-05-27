package DiscreteStochasticSimulation;

import EvolutionaryProgramming.IEv;

import java.util.Comparator;
import java.util.Iterator;
import java.util.PriorityQueue;

public class PEC implements EventManager {
	private static PEC instance;
	private float simTime=0;
	
	Comparator<IEv> com = new Comparator<IEv>()
	{
			@Override
			public int compare(IEv o1, IEv o2) {
				float t1=o1.getSimTime(), t2=o2.getSimTime();
				if(t1>t2) 
					return 1;
				else if(t1==t2)
					return 0;
				else
					return -1;
			}
	};
	private PriorityQueue<IEv> pec = new PriorityQueue<>(com);  
	
	
	Iterator<IEv> it = pec.iterator();
	
	private PEC() {}
	
	public static PEC getInstance() {
		if(instance==null) {
			instance = new PEC();
		}
		return instance;	
	}
	
	@Override
	public void scheduleEvent(IEv ev) {
		pec.add(ev);//We need to implement the verification to check if the add is valid
	}
	
	public IEv nextEvPEC() {
		IEv nextEvent = null;
		
		if(it.hasNext()) {
			nextEvent = it.next();
			it.remove();
		}
		return nextEvent;
	}

	@Override
	public float getCurrSimTime() {
		return simTime;
	}
	
	public void iterateEvents() {
		IEv ev;
		while(it.hasNext()) {
			ev = nextEvPEC();
			ev.simulate(instance);
			simTime += ev.getSimTime();
		}
	}
}

