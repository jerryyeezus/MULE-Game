package views;

import java.awt.CardLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JPanel;

public class CardUpdater implements ActionListener {
    private String panelString;
    private JPanel cards;
    private Pub pubPanel;

    public CardUpdater(JPanel cards, String panelString, JPanel panel) {
	this.cards = cards;
	this.panelString = panelString;
	if (panel instanceof Pub)
	{
	    this.pubPanel = (Pub) panel;
	}
    }

    @Override
    public void actionPerformed(ActionEvent e) {
	CardLayout cardLayout = (CardLayout) cards.getLayout();
	cardLayout.show(cards, panelString);
	if (panelString == "Pub")
	{
	    pubPanel.gamble();
	}
    }

}
