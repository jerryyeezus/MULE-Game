package views;

/**
 * 
 * THe information holder for the Store where the player can Buy and Sell resources.
 * 
 * @author Tanay
 *
 */
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
