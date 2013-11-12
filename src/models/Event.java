package models;
/**
 * An abstract class Event which defines the skeleton for an event.
 *
 * @author Tanay
 *
 */
public abstract class Event {
    protected PlayerConfigModel players;
    protected String eventString;
    protected boolean isBad;
    
    /**
     * Constructor which initializes the player.
     * @param players
     */
    public Event(PlayerConfigModel players) {
	this.players = players;
    }

    /**
     * An abstract method which defines the type of event that occurs to the player.
     * @param i
     */
    public abstract void doEvent(int i);
    
    /**
     * Method which checks if the event is Bad or not.
     * @return
     */
	public boolean getIsBad() {
		return isBad;
	}
}
