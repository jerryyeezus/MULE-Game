package models;

import javax.swing.JOptionPane;

public class CageEvent extends Event {
	public CageEvent(PlayerConfigModel players) {
		super(players);
		this.eventString = "Nicolas Cage took all your money  #Bankruptcy #tooBad.";
		this.isBad = true;
	}

	@Override
	public void doEvent(int player) {
		JOptionPane.showMessageDialog(null, "Payer " + player + ": " + eventString);
		players.getPlayer(player).setMoney(0);
	}
}
