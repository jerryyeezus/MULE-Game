package presenters;

import javax.swing.JOptionPane;

import models.Event;
import models.PlayerConfigModel;
import models.PlayerModel;

public class DDREvent extends Event {

	public DDREvent(PlayerConfigModel players) {
		super(players);
		this.eventString = "you won a 100 $ :)";
		isBad = false;
	}

	@Override
	public void doEvent(int player) {
		System.out.println("TODO DDR Event");
		JOptionPane.showMessageDialog(null, "Player " + player + ": " + eventString);
	
		int money = players.getPlayer(player).getMoney();
		 players.getPlayer(player).setMoney(money + 100);

	}

}
