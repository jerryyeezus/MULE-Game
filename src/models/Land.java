package models;

import java.util.ArrayList;

/**
 * 
 * @author Tanay
 * 
 *         This class creates an object of Land class.
 * 
 */

public class Land {

	private String type;
	private int owner;
	private int price;
	public boolean hasMule;
	public int x;
	public int y;
	public ArrayList<Mule> placedMules;

	/**
	 * Constructor which implements the object of the Land class.
	 * 
	 * @param type
	 * @param locationX
	 * @param locationY
	 */
	public Land(String type, int locationX, int locationY) {
		this.type = type;
		placedMules = new ArrayList<Mule>();
		x = locationX;
		y = locationY;
		owner = -1;
		if (type.equals("M"))
			price = 20;
		else if (type.equals("R"))
			price = 50;
		else
			price = 40;

	}

	/**
	 * The method which returns the type of mineral/resource the land tile has.
	 * 
	 * @return type (the type of the land)
	 */
	public String getType() {
		return this.type;
	}

	/**
	 * The method which will tell if the mule has been placed on the land tile
	 * or not.
	 * 
	 * @param mule
	 */
	public void placeMule(Mule mule) {
		placedMules.add(mule);
		hasMule = true;
	}

	/**
	 * Method that returns the price of the land, which is specific to the land
	 * location and the mountain/plateau/river it has.
	 * 
	 * @return price of the land based on the type
	 */
	public int getPrice() {
		return price;
	}

	/**
	 * Method which sets the player to the land it has selected. It will help in
	 * keeping the track of the land a player has selected over the course of
	 * the game.
	 * 
	 * @param owner
	 */
	public void setOwner(int owner) {
		this.owner = owner;
	}

	/**
	 * Method which returns the owner from the land we have selected.
	 * 
	 * @return owner
	 */
	public int getOwner() {
		return owner;
	}

}
