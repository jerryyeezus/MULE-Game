package presenters;

import java.util.Random;

import models.CageEvent;
import models.DumpEvent;
import models.Event;
import models.PlayerConfigModel;
/**
 * 
 * Event Manager is a class that implements the random events that occur to player after end of every round.
 * 
 * @author Tanay
 *
 */
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

    /**
     * Method that modifies the player inventpry according to the random event occurred. It also calculates the probability (27%)
     * of each event.
     */
    public void run() {
	Random r = new Random();
	int poorest = model.getCurRoundOrder()[0];
	int rng;
	for (int i = 0; i < model.getNumPlayers(); i++) {	    
	    rng = r.nextInt(100);
			if (rng > 40) {
				int temp = r.nextInt(3);
				if(i == poorest && events[temp].getIsBad())
			    {	goodEvents[temp].doEvent(i);
			    	//break;
			    }
				else 
				{
					events[temp].doEvent(i);
					//break;
				}
			}
	    }
	} // end of outer-for
 }


