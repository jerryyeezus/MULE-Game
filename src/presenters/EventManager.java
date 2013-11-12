package presenters;

import java.util.Random;

import models.CageEvent;
import models.DumpEvent;
import models.Event;
import models.PlayerConfigModel;

public class EventManager {
    private PlayerConfigModel model;
    private Event[] events;
    private Event[] goodEvents;
    private static final int NUM_EVENTS = 3;
    private static final int PROBABILITY = 27; // 27% chance

    public EventManager(PlayerConfigModel model) {
	this.model = model;
	
	events = new Event[NUM_EVENTS];
	goodEvents = new Event[3];
	events[0] = new CageEvent(model);
	events[1] = new DDREvent(model);
	events[2] = new DumpEvent(model);
	goodEvents[0] = new DumpEvent(model);
	goodEvents[1] = new DDREvent(model);
	goodEvents[2] = new DDREvent(model);
    }

    public void run() {
	Random r = new Random();
	int poorest = model.getCurRoundOrder()[0];

	for (int i = 0; i < model.getNumPlayers(); i++) {	    
	    int rng = r.nextInt(100);
	    
	    for (int evt = NUM_EVENTS - 1; evt >= 0; evt--) {
			if (rng > evt * PROBABILITY / NUM_EVENTS) {
				if(i == poorest && events[evt].getIsBad())
			    {	goodEvents[evt].doEvent(i);
			    	break;
			    }
				else 
				{
					events[evt].doEvent(i);
					break;
				}
			}
	    }
	} // end of outer-for
    }

}
