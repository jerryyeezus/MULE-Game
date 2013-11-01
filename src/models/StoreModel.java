package models;

import views.StorePanel;

public class StoreModel {

		private int numberOfGoodsAvailable;
		private int priceOfGoods;
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
		
}
