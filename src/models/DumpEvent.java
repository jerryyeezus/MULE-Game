package models;

import javax.swing.JOptionPane;
/**
 * A class that implements a specific kind of event. 
 * @author Tanay
 *
 */
public class DumpEvent extends Event {
    public DumpEvent(PlayerConfigModel players) {
	super(players);
	this.eventString = "A UFO dumped Gems worth 156 $  on your land!!";
    this.isBad = false;
    }

    /**
     * An overriden method that describes the algorithm for the event.
     * @param player
     */
    @Override
    public void doEvent(int player) {
	System.out.println("TODO dump event");
	JOptionPane.showMessageDialog(null, "Player " + player + ": " + eventString);
	int i = player;
	PlayerModel p = players.getPlayer(i);
	int money = p.getMoney();
	p.setMoney(money + 156);
    }
}
