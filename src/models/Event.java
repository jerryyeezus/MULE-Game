package models;

public abstract class Event {
    protected PlayerConfigModel players;
    protected String eventString;
    protected boolean isBad;
    
    public Event(PlayerConfigModel players) {
	this.players = players;
    }

    public abstract void doEvent(int i);
    
	public boolean getIsBad() {
		return isBad;
	}
}
