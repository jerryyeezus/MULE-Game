package models;

public class CageEvent extends Event {
    public CageEvent(PlayerConfigModel players) {
	super(players);
	this.eventString = "Something happen blah blah. Lose All money.";
    }

    @Override
    public void doEvent(int player) {
	System.out.println("EVENTTTTTTTTT CAGE");
	players.getPlayer(player).setMoney(0);
    }
}
