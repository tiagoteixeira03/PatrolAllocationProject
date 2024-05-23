package DiscreteStochasticSimulation;

import EvolutionaryProgramming.IEv;

import java.util.Comparator;
import java.util.Iterator;
import java.util.PriorityQueue;

public class PEC implements EventManager {
	private static PEC instance;
	Comparator<IEv> com = new Comparator<IEv>()
	{
			@Override
			public int compare(IEv o1, IEv o2) {
				// TODO Auto-generated method stub
				return 0;
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
			return nextEvent;
		}
		else {
			return nextEvent;
		}
	}
}

