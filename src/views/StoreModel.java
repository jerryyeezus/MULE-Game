package views;

public class StoreModel {

		private int numberOfGoodsAvailable;
		private StorePanel panel;
		public StoreModel(){
			numberOfGoodsAvailable = 16;
		}
		
		public int getGoodsAvailable(){
			return numberOfGoodsAvailable;
			
		}
		public void reduceInventory(int value){
			numberOfGoodsAvailable  = numberOfGoodsAvailable-value;
		}
}
