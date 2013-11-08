package presenters;

import java.util.Random;

import models.CageEvent;
import models.Event;
import models.PlayerConfigModel;

public class EventManager {
    private PlayerConfigModel model;
    private Event[] events = { new CageEvent(), new DDREvent(), new DDREvent()};
    private static final int NUM_EVENTS = 3;
    private static final int PROBABILITY = 100; // 27% chance

    public EventManager(PlayerConfigModel model) {
	this.model = model;
    }

    public void run() {
	for (int i = 0; i < model.getNumPlayers(); i++) {
	    Random r = new Random();
	    int rng = r.nextInt(100);
	    for (int evt = NUM_EVENTS - 1; evt >= 0; evt--) {
		System.out.println(evt * PROBABILITY / NUM_EVENTS);
		if (rng > evt * PROBABILITY / NUM_EVENTS) {
		    events[evt].doEvent();
		    break;
		}
	    }
	}	// end of outer-for
    }

}
