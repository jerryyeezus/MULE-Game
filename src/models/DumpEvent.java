package models;

public class DumpEvent extends Event {
    public DumpEvent(PlayerConfigModel players) {
	super(players);
	this.eventString = "Something happen blah blah";
    }

    @Override
    public void doEvent(int player) {
	System.out.println("TODO dump event");
    }
}
