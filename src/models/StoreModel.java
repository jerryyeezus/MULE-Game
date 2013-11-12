package models;

import java.io.Serializable;

import views.StorePanel;

/**
 * @author yee
 * Stores price of goods, quantities of goods, and perform transactions.
 */
public class StoreModel implements Serializable {

		private int numberOfFoodsAvailable;
		private int priceOfFood;
		
		private int numberOfDrinksAvailable;
		private int priceOfDrinks;
		
		private int numberOfCageAvailable;
		private int priceOfCage;

		private StorePanel panel;
		public StoreModel(){
			numberOfFoodsAvailable = 16;
			priceOfFood = 30;
			numberOfDrinksAvailable = 16;
			priceOfDrinks = 25;
			numberOfCageAvailable = 0;
			priceOfCage = 50;
		}
		
		public int getFoodAvailable(){
			return numberOfFoodsAvailable;
		}
		public int getDrinksAvailable(){
			return numberOfDrinksAvailable;
		}
		public int getCageAvailable(){
			return numberOfCageAvailable;
		}
		public void reduceFood(int value){
			numberOfFoodsAvailable -= value;
		}
		public int getPriceOfFood(){
			return priceOfFood;
		}
		public void addToFood(int value){
			numberOfFoodsAvailable  += value;
		}
		public void addToDrinks(int value) {
		    this.numberOfDrinksAvailable += value;
		}
		public void reduceDrinks(int value){
			numberOfDrinksAvailable -= value;
		}
		public int getPriceOfDrinks(){
			return priceOfDrinks;
		}
		public void addToCage(int value){
			numberOfCageAvailable += value;
		}
		public void reduceCage(int value){
			numberOfCageAvailable -= value;
		}
		public int getPriceOfCage(){
			return priceOfCage;
		}
}
