package models;

import java.io.Serializable;

import views.StorePanel;

/**
 * @author yee Stores price of goods, quantities of goods, and perform
 *         transactions.
 */
public class StoreModel implements Serializable {

    private int numberOfFoodsAvailable;
    private int priceOfFood;

    private int numberOfDrinksAvailable;
    private int priceOfDrinks;

    private int numberOfCageAvailable;
    private int priceOfCage;

    private StorePanel panel;

    public StoreModel() {
	numberOfFoodsAvailable = 16;
	priceOfFood = 30;
	numberOfDrinksAvailable = 16;
	priceOfDrinks = 25;
	numberOfCageAvailable = 0;
	priceOfCage = 50;
    }

    /**
     * Method that gives the number of foods available in the store.
     * 
     * @return no of foods
     */
    public int getFoodAvailable() {
	return numberOfFoodsAvailable;
    }

    /**
     * Method that gives the drinks in the store.
     * 
     * @return no of drinks
     */
    public int getDrinksAvailable() {
	return numberOfDrinksAvailable;
    }

    /**
     * Method that gives the Nicolas Cage available in the Store.
     * 
     * @return no of Nicols Cage
     */
    public int getCageAvailable() {
	return numberOfCageAvailable;
    }

    /**
     * Method that reduces the food items from the Store based on the integer
     * parameter.
     * 
     * @param value
     */
    public void reduceFood(int value) {
	numberOfFoodsAvailable -= value;
    }

    /**
     * Method that gives the price of food items in the Store.
     * 
     * @return priceOfFood
     */
    public int getPriceOfFood() {
	return priceOfFood;
    }

    /**
     * Method that increases the food items from the Store based on the integer
     * parameter.
     * 
     * @param value
     */
    public void addToFood(int value) {
	numberOfFoodsAvailable += value;
    }

    /**
     * Method that increases the drink items from the Store based on the integer
     * parameter.
     * 
     * @param value
     */
    public void addToDrinks(int value) {
	this.numberOfDrinksAvailable += value;
    }

    /**
     * Method that reduces the drink items from the Store based on the integer
     * parameter.
     * 
     * @param value
     */
    public void reduceDrinks(int value) {
	numberOfDrinksAvailable -= value;
    }

    /**
     * Method that gives the price of drink items in the Store.
     * 
     * @return priceOfDrinks
     */

    public int getPriceOfDrinks() {
	return priceOfDrinks;
    }

    /**
     * Method that increases the Nicolas Cage from the Store based on the
     * integer parameter.
     * 
     * @param value
     */
    public void addToCage(int value) {
	numberOfCageAvailable += value;
    }

    /**
     * Method that reduces the Nicolas Cage from the Store based on the integer
     * parameter.
     * 
     * @param value
     */
    public void reduceCage(int value) {
	numberOfCageAvailable -= value;
    }

    /**
     * Method that gives the price of Nicolas Cage available in the Store.
     * 
     * @return priceOfCage
     */

    public int getPriceOfCage() {
	return priceOfCage;
    }
}
