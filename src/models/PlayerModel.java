package models;

import java.awt.Color;
import java.io.Serializable;
import java.util.ArrayList;
import models.Land;

/**
 * @author yee Info holder for player's name,race,color
 */
public class PlayerModel implements Serializable {
    private String name;
    private String race;
    private String color;
    private static final long serialVersionUID = 1L;
    private int money;
    private int land;
    private int food;
    private int drink;
    private int nicolasCage;
    private ArrayList<Land> landOwned;

    public int getDrink() {
	return drink;
    }

    public void setDrink(int drink) {
	this.drink = drink;
    }

    public int getNicolasCage() {
	return nicolasCage;
    }

    public void setNicolasCage(int nicolasCage) {
	this.nicolasCage = nicolasCage;
    }

   

    public PlayerModel() {
	name = "NOT IN GAME";
	race = "NOT IN GAME";
	color = "NOT IN GAME";
	landOwned = new ArrayList<Land>();

    }

    public String getName() {
	return name;
    }

    public void setName(String n) {
	name = n;
    }

    public String getRace() {
	return race;
    }

    public void setRace(String n) {
	race = n;
    }

    public void addLand(Land l) {
	landOwned.add(l);
    }

    public Color getColor() {
	String s = color;
	if (s.equalsIgnoreCase("Red"))
	    return new Color(255, 0, 0);
	else if (s.equalsIgnoreCase("Blue"))
	    return new Color(0, 0, 255);
	else if (s.equalsIgnoreCase("Green"))
	    return new Color(0, 255, 0);
	else
	    return new Color(255, 255, 0);

    }

    public void setColor(String n) {
    	color = n;
    }
    
    public void setActualColor(Color c) {
    	if (c.equals(new Color(255, 0, 0) ))
    	{
    		this.color = "Red";
    	}
    	
    	// TODO finish this
    }

    public int getMoney() {
	return money;
    }

    public int getLand() {
	return land;
    }

    public int getFood() {
	return food;
    }

    public int getTotal() {
	return (money + food + drink + nicolasCage);
    }

    public void setMoney(int n) {
	money = n;
    }

    public void setLand(int n) {
	land = n;
    }

    public void setFood(int n) {
	food = n;
    }

    public ArrayList<Land> getLandsOwner() {
	return landOwned;
    }
    public int getGoods(){
    	return food+drink+nicolasCage;
    }
}