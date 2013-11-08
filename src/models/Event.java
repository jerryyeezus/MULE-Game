package models;

public abstract class Event {
    protected PlayerConfigModel players;
    protected String eventString;
    
    public Event(PlayerConfigModel players) {
	this.players = players;
    }

    public abstract void doEvent(int i);
}
