package views;

import java.awt.CardLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JPanel;

/**
 * @author yee
 * Updates the Town class's card layout with appropriate JPanel
 */
public class CardUpdater implements ActionListener {
	private String panelString;
	private JPanel cards;
	private Pub pubPanel;
	private StorePanel storePanel;
	private MuleSelectionPanel mulePanel;
	private FourthScreenPanel fourthScreenPanel;

	/**
	 * @param cards parent container
	 * @param panelString "Town", "Pub", "Mule", etc...
	 * @param panel instance of the appropriate JPanel
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
