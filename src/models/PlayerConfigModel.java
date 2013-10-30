package models;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.ConcurrentModificationException;

import enums.*;
import views.FourthScreenPanel;

/**
 * @author yee Getters and setters for numPlayers and returns particular player
 *         object
 */
public class PlayerConfigModel {
	PlayerModel[] players;
	int numPlayers;
	int timer;
	private int round;
	private int curPlayer;
	private int[] curRoundOrder;

	public int getCurPlayer() {
		return curPlayer;
	}

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
		players = new PlayerModel[4];
		for (int i = 0; i < numPlayers; i++) {
			players[i] = new PlayerModel();
		}
	}

	public int getNumPlayers() {
		return this.numPlayers;
	}

	public PlayerModel getPlayer(int i) {
		return players[i];
	}

	public void increaseRound() {
		round++;
	}

	public void broadcast(String string) {
		for (FourthScreenPanel o : observers) {
			o.callback(string);
		}
	}

	ArrayList<FourthScreenPanel> observers = new ArrayList<FourthScreenPanel>();

	public int getRound() {
		return round;
	}

	public int getTimer() {
		return this.timer;
	}

	public void setTimer(int timer) {
		this.timer = timer;
	}

	public void updateTimer() {
		System.out.println(this.timer);
		// Decrement timer, check if timer = 0

		if (--this.timer < 0) {
			if (curPlayer == numPlayers - 1) {
				curRoundOrder = calcPlayerOrder();
				this.increaseRound();
				curPlayer = curRoundOrder[0];
				this.timer = calcPlayerTime();
				broadcast("ROUND_END");
			} else {
				curPlayer++;
				this.timer = calcPlayerTime();
				broadcast("TURN_END");
			}
		} // End of ROUND END
	}
	
	private static final int[] foodRequirements = { 3, 3, 3, 4, 4, 4, 5, 5, 5,
		6, 6, 6 };
	
	private int calcPlayerTime() {
		int numFood = this.getPlayer(curPlayer).getGoods();

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

	public int[] calcPlayerOrder() {
		// TODO calc
		System.out.println("calculating round");
		players[1].setMoney(400);
		int[] totals = new int[this.numPlayers];
		int[] ret = new int[this.numPlayers];
		ArrayList <PlayerModel> play = new ArrayList <PlayerModel>();
		
		for (int i = 0; i < this.numPlayers; i++) {
			totals[i] = players[i].getTotal();
			System.out.println(players[i].getName() + " "+ players[i].getTotal());

			play.add(players[i]);
		}
		Arrays.sort(ret);
		
		outerloop:
		for(int i = 0; i <this.numPlayers; i++){
			for(int j = 0; i <this.numPlayers; j++){
				if(totals[i] == play.get(j).getTotal()){
					ret[i] = j;
					play.remove(j);
					break outerloop;
				}
					
			}
		}
		
		return ret;
	}

	public int nextPlayer() {
		return curRoundOrder[curPlayer];
	}

	public void addCallback(FourthScreenPanel fourthScreenPanel) {
		this.observers.add(fourthScreenPanel);
	}

}
