package models;

import views.StorePanel;

/**
 * @author yee
 * Stores price of goods, quantities of goods, and perform transactions.
 */
public class StoreModel {

		private int numberOfGoodsAvailable;
		private int priceOfGoods;
		
		private int numberOfDrinksAvailable;
		private int priceOfDrinks;

		private StorePanel panel;
		public StoreModel(){
			numberOfGoodsAvailable = 16;
			priceOfGoods = 30;
		}
		
		public int getGoodsAvailable(){
			return numberOfGoodsAvailable;
			
		}
		public void reduceInventory(int value){
			numberOfGoodsAvailable  = numberOfGoodsAvailable-value;
		}
		public int getPriceOfGoods(){
			return priceOfGoods;
		}
		public void increaseInventory(int value){
			numberOfGoodsAvailable  = numberOfGoodsAvailable+value;
		}
		public void addToDrinks(int value) {
		    this.numberOfDrinksAvailable += value;
		}
		
		public int getDrinksAvailable() {
		    return this.numberOfDrinksAvailable;
		}
		
}
