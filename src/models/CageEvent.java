package models;

import javax.swing.JOptionPane;

/**
 * A class that implements a specific event.
 * @author Tanay
 *
 */
public class CageEvent extends Event {
	public CageEvent(PlayerConfigModel players) {
		super(players);
		this.eventString = "Nicolas Cage took all your money to pay off his IRS debts. You now have $0. #Bankruptcy #tooBad.";
		this.isBad = true;
	}

	/**
	 * An overriden method which takes in an integer as a parameter and runs the algorithm for the event.
	 * 
	 * @param player
	 */
	@Override
	public void doEvent(int player) {
		JOptionPane.showMessageDialog(null, "Player " + player + ": " + eventString);
		players.getPlayer(player).setMoney(0);
	}
}
