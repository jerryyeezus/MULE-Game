package views;

import java.awt.CardLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JPanel;
/**
 * The card updater class that gives the card layout functionality to the game.
 * It allows for the panels to be changed seamlessly on the JFrame of the game.
 * 
 * @author Tanay
 * @version 1.3
 */
public class CardUpdater implements ActionListener {
	private String panelString;
	private JPanel cards;
	private Pub pubPanel;
	private StorePanel storePanel;
	private MuleSelectionPanel mulePanel;
	private FourthScreenPanel fourthScreenPanel;

	/**
	 * Changes the instance variables according to the parameter-panel.
	 * 
	 * @param cards
	 * @param panelString
	 * @param panel
	 */
	public CardUpdater(JPanel cards, String panelString, JPanel panel) {
		this.cards = cards;
		this.panelString = panelString;
		if (panel instanceof Pub) {
			
			this.pubPanel = (Pub) panel;
		}
		else if(panel instanceof StorePanel){
			this.storePanel = (StorePanel)panel;
		}
		else if (panel instanceof MuleSelectionPanel)
			this.mulePanel = (MuleSelectionPanel) panel;
		else if (panel instanceof FourthScreenPanel)
			this.fourthScreenPanel = (FourthScreenPanel) panel;
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		CardLayout cardLayout = (CardLayout) cards.getLayout();
		cardLayout.show(cards, panelString);
		if (panelString == "Pub") {
			pubPanel.gamble();
		}
		if (panelString == "Store") {
			
			storePanel.runStore();
		}
		if (panelString == "Mule")
			System.out.println("shit");
		if (panelString == "Four") {
			
		}
	}

}
