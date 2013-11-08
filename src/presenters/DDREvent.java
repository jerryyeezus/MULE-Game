package presenters;

import models.Event;
import models.PlayerConfigModel;

public class DDREvent extends Event {
    public DDREvent(PlayerConfigModel players) {
	super(players);
	this.eventString = "Something happen blah blah";
    }

    @Override
    public void doEvent(int player) {
	System.out.println("TODO DDR Event");

    }

}
