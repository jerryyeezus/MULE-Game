package models;

import javax.swing.JOptionPane;

public class CageEvent extends Event {
	public CageEvent(PlayerConfigModel players) {
		super(players);
		this.eventString = "Nicolas Cage took all your money to pay off his IRS debts. You now have $0. #Bankruptcy #tooBad.";
		this.isBad = true;
	}

	@Override
	public void doEvent(int player) {
		JOptionPane.showMessageDialog(null, "Player " + player + ": " + eventString);
		players.getPlayer(player).setMoney(0);
	}
}
