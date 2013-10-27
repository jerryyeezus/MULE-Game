
package models;

import java.awt.Color;
import java.util.ArrayList;

/**
 * @author yee
 * Info holder for player's name,race,color
 */
public class PlayerModel
{
	String name;
	String race;
	String color;
	int money;
	int land;
	int goods;
	ArrayList<Land> landOwned ;


	public PlayerModel()
	{
		name = "NOT IN GAME";
		race = "NOT IN GAME";
		color = "NOT IN GAME";
		landOwned = new ArrayList<Land>();
		
	}

	public String getName()
	{
		return name;
	}

	public void setName( String n )
	{
		name = n;
	}

	public String getRace()
	{
		return race;
	}

	public void setRace( String n )
	{
		race = n;
	}
	
	public void addLand(Land l){
		landOwned.add(l);
	}
	
	
	public Color getColor()
	{
		String s = color;
		if(s.equalsIgnoreCase("Red"))
			return new Color(255, 0, 0);
		else if(s.equalsIgnoreCase("Blue"))
			return new Color(0, 0, 255);
		else if(s.equalsIgnoreCase("Green"))
			return new Color(0, 255, 0);
		else 
			return new Color(0, 0, 0);
		
	}

	public void setColor( String n )
	{
		color = n;
	}
	
	public int getMoney()
	{
		return money;
	}
	
	public int getLand()
	{
		return land;
	}
	
	public int getGoods()
	{
		return goods;
	}
	
	public int getTotal()
	{
		return (money+land+goods);
	}
	
	public void setMoney( int n )
	{
		money = n;
	}	
	
	public void setLand( int n )
	{
		land = n;
	}
	
	public void setGoods( int n )
	{
		goods = n;
	}
	public ArrayList<Land> getLandsOwner(){
		return landOwned;
	}

}