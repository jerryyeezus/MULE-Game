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

	public void broadcast() {
		for (FourthScreenPanel o : observers) {
			o.callback();
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
		if (--this.timer < 0) {
			if (curPlayer == numPlayers - 1) {
				curRoundOrder = calcPlayerOrder();
				this.increaseRound();
				System.out.println("Round increased");
			
				System.out.println(players[curPlayer].getName() + " "+ players[curPlayer].getTotal());

				curPlayer = curRoundOrder[0];
			} else {
				curPlayer++;
			}
			this.timer = Constants.BASE_TIME; // TODO calc1
			broadcast();
		}

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
