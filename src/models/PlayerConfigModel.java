package models;

import java.awt.Color;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.Arrays;

import views.FourthScreenPanel;
import enums.Constants;

/**
 * Getters and setters for numPlayers and returns particular player object
 * 
 * @author yee
 */
public class PlayerConfigModel implements Serializable {
	private PlayerModel[] players;
	private int numPlayers;
	private int timer;
	private int round;
	private int curPlayer;
	private int[] curRoundOrder;
	private int curRoundOrderIndex;

	private static final long serialVersionUID = 1L;

	/**
	 * Method which returns the player currently playing the game.
	 * 
	 * @return player.
	 */
	public int getCurPlayer() {
		return curPlayer;
	}
	
	/**
	 * Method which takes in a roundOrder and sets it to curRoundOrder.
	 * 
	 * @param a[]
	 */
	public void setCurRoundOrder(int a[])
	{
		for(int i =0; i<numPlayers; i++)
		{
			curRoundOrder[i]= a[i];
		}
	}
	/**
	 * Method which takes in a player number and sets it to current player.
	 * 
	 * @param curPlayer
	 */
	public void setCurPlayer(int curPlayer) {
		this.curPlayer = curPlayer;
	}

	/**
	 * @param numPlayers
	 *            initializes the players array, initialize a player object for
	 *            each player in the game
	 * 
	 */
	public PlayerConfigModel(int numPlayers) {
		this.numPlayers = numPlayers;
		this.curRoundOrder = new int[numPlayers];
		this.curPlayer = -1;
		this.wasLoaded = false;
		this.curRoundOrderIndex = 0;
		players = new PlayerModel[4];
		for (int i = 0; i < numPlayers; i++) {
			players[i] = new PlayerModel();
		}
	}

	/**
	 * Copy constructor for Player
	 * 
	 * @param readObject
	 *            serialized player object to be serialized
	 */
	public PlayerConfigModel(PlayerConfigModel readObject) {
		this(readObject.getNumPlayers());

		// Set playerConfigModel attributes
		this.curRoundOrder = readObject.getCurRoundOrder();
		this.curRoundOrderIndex = readObject.getCurRoundOrderIndex();
		this.curPlayer = readObject.getCurPlayer();
		this.wasLoaded = true;
		this.round = this.getRound();

		// now set players
		PlayerModel savedPlayer;

		PlayerModel newPlayer;
		for (int i = 0; i < readObject.getNumPlayers(); i++) {
			newPlayer = this.getPlayer(i);
			savedPlayer = readObject.getPlayer(i);
			this.setCurPlayer(readObject.getCurPlayer());
			this.curRoundOrder = readObject.curRoundOrder;
			newPlayer.setActualColor(savedPlayer.getColor());
			if (savedPlayer.getColor().equals(new Color(255, 0, 0)))
				newPlayer.setColor("RED");
			if (savedPlayer.getColor().equals(new Color(0, 0, 255)))
				newPlayer.setColor("BLUE");
			if (savedPlayer.getColor().equals(new Color(0, 255, 0)))
				newPlayer.setColor("GREEN");
			if (savedPlayer.getColor().equals(new Color(255, 255, 0)))
				newPlayer.setColor("YELLOW");
			newPlayer.setDrink(savedPlayer.getDrink());
			ArrayList<Land> lands = savedPlayer.getLandsOwned();
			for (Land l : lands) {
				newPlayer.addLand(l);
			}
			newPlayer.setFood(savedPlayer.getFood());
			newPlayer.setName(savedPlayer.getName());
			newPlayer.setLand(savedPlayer.getLandsOwned().size());
			newPlayer.setNicolasCage(savedPlayer.getNicolasCage());
			newPlayer.setMoney(savedPlayer.getMoney());
			newPlayer.setRace(savedPlayer.getRace());
		}
	}

	/**
	 * Method that gives the Round order Index of the current player.
	 * 
	 * @return int curRoundOrderIndex
	 */
	private int getCurRoundOrderIndex() {
		// TODO Auto-generated method stub
		return this.curRoundOrderIndex;
	}

	/**
	 * Method which returns the number of players playing the game.
	 * 
	 * @return num of players
	 */
	public int getNumPlayers() {
		return this.numPlayers;
	}

	/**
	 * Method which returns a specific player from its integer value (assigned
	 * to it)
	 * 
	 * @param i
	 * @return a player
	 */
	public PlayerModel getPlayer(int i) {
		return players[i];
	}

	/**
	 * Method which keeps in track of the rounds of the game and increment it.
	 * 
	 */
	public void increaseRound() {
		round++;
	}

	/**
	 * Method which takes in string and call callback() method.
	 * 
	 * @param string
	 */
	public void broadcast(String string) {
		for (FourthScreenPanel o : observers) {
			o.callback(string);
		}
	}

	transient ArrayList<FourthScreenPanel> observers = new ArrayList<FourthScreenPanel>();
	private boolean wasLoaded;

	/**
	 * Method that gets the current round in progress.
	 * 
	 * @return round
	 */
	public int getRound() {
		return round;
	}

	/**
	 * Method that gets the timer for a player.
	 * 
	 * @return time
	 */
	public int getTimer() {
		return this.timer;
	}
	
	/**
	 * Method that sets the timer for a player.
	 * 
	 * @param timer
	 */
	public void setTimer(int timer) {
		this.timer = timer;
	}

	/**
	 * Method that updates the timer for a player which allows to allot a time
	 * window for a particular turn.
	 */
	public void updateTimer() {
		// Decrement timer, check if timer = 0

		if (--this.timer < 0) {
			if (curPlayer == curRoundOrder[this.numPlayers - 1]) {
				curRoundOrder = calcPlayerOrder();
				this.increaseRound();
				curPlayer = curRoundOrder[0];
				this.timer = calcPlayerTime();
				this.curRoundOrderIndex = 0;
				broadcast("ROUND_END");
			} else {
				curPlayer = curRoundOrder[++curRoundOrderIndex]; // TODO
				this.timer = calcPlayerTime();
				broadcast("TURN_END");
			}
		} // End of ROUND END
	}
	
	
	/**
	 * Makes an array for the food requirements that will be assigned to each
	 * player at the beginning according to their race they have chosen.
	 */
	private static final int[] foodRequirements = { 3, 3, 3, 4, 4, 4, 5, 5, 5,
			6, 6, 6 };

	/**
	 * Method that calculates the player time and update it at the end of the
	 * turn.
	 * 
	 * @return Constants
	 */
	public int calcPlayerTime() {
		int numFood = this.getPlayer(curPlayer).getFood();

		// Case Partial Shortage
		if (numFood > 0
				&& numFood < PlayerConfigModel.foodRequirements[this.round]) {
			return 30;
		}

		// Case Complete shortage
		else if (numFood == 0) {
			return 5;
		}

		// Case met
		return Constants.BASE_TIME;

	}
	
	/**
	 * Method that sets the round.
	 * 
	 * @param n
	 */
	public void setRound(int n)
	{
		round = n;
	}
	/**
	 * Method that calculates the order in which play takes place according to
	 * the resources and money left with the player.
	 * 
	 * @return
	 */
	public int[] calcPlayerOrder() {
		// TODO calc
		ArrayList<Integer> ab = new ArrayList<Integer>();
		int[] totals = new int[this.numPlayers];
		int[] orderedPlayers = new int[this.numPlayers];

		for (int i = 0; i < this.numPlayers; i++) {
			totals[i] = players[i].getTotal();
			ab.add(players[i].getTotal());
		}

		Arrays.sort(totals);

		for (int i = 0; i < this.numPlayers; i++) {
			orderedPlayers[i] = ab.indexOf(totals[i]);
			ab.set(ab.indexOf(totals[i]), null);
			System.out.println("index " + i + " value :" + orderedPlayers[i]);
			this.curRoundOrder[i] = orderedPlayers[i];
		}
		return orderedPlayers;

	}

	public int[] getCurRoundOrder() {
		return curRoundOrder;
	}

	/**
	 * Method that returns the current round order of the current player.
	 * 
	 * @return round order for the player
	 */
	public int nextPlayer() {
		return curRoundOrder[curPlayer];
	}

	/**
	 * Method that add to the observers.
	 * 
	 * @param fourthScreenPanel
	 */
	public void addCallback(FourthScreenPanel fourthScreenPanel) {
		if (this.observers == null) {
			this.observers = new ArrayList<FourthScreenPanel>();
		}

		this.observers.add(fourthScreenPanel);
	}

	public boolean wasLoaded() {
		return this.wasLoaded;
	}

}
