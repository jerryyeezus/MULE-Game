package views;


import java.awt.CardLayout;
import java.awt.event.ActionListener;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JPanel;

import models.GameConfigModel;
import models.PlayerConfigModel;

/**
 * 
 * This class contains the Town this which contains different buttons
 * which trigger different events.
 * 
 * @author Tanay
 * 
 */
public class TownPanel extends JPanel {
	// Pub, Buy MULES, Go to Map,
	private PlayerConfigModel model;
	JButton btnLand;
	JButton btnPub;
	private GameConfigModel gameConfig;
	private JPanel storePanel;
	private JPanel panel; // panel for Town
	private CardLayout layout;
	private JPanel pubPanel;

	/**
	 * Create the application.
	 */
	public TownPanel(PlayerConfigModel model) {
	    	layout = new CardLayout();
	    	pubPanel = new Pub(model);
	    	this.setLayout(layout);
		this.storePanel = new StorePanel(model);
		this.model = model;
		this.initialize();
	}

	/**
	 * Initialize the contents of the this.
	 */
	private void initialize() {
		panel = new JPanel();
		panel.setBounds(10, 118, 815, 313);

		btnPub = new JButton("");

		btnPub.setIcon(new ImageIcon("src/temp/miniPub.jpg"));
		btnPub.setBounds(10, 174, 304, 128);
		btnPub.addActionListener(new CardUpdater(this, "Pub", pubPanel));
		panel.add(btnPub);
		panel.setLayout(null);

		JButton btnAssay = new JButton("slickdeals");
		// btnAssay.setIcon(new
		//btnAssay.setIcon(new ImageIcon("src/temp/miniLand.jpg"));
		btnAssay.setBounds(10, 11, 304, 128);
		panel.add(btnAssay);

		btnLand = new JButton("");
		btnLand.setIcon(new ImageIcon("src/temp/miniLand.jpg"));
		btnLand.setBounds(501, 11, 304, 128);
		panel.add(btnLand);


		JButton btnStore = new JButton("");
		btnStore.setIcon(new ImageIcon("src/temp/mule.jpg"));
		btnStore.setBounds(501, 174, 304, 128);
		panel.add(btnStore);

		/*
		JButton btnExit = new JButton("Exit");
		btnExit.setBounds(736, 442, 89, 23);
		this.add(btnExit);

		JButton btnNewButton = new JButton("Next>>");
		btnNewButton.setBounds(627, 442, 89, 23);
		this.add(btnNewButton);

		JLabel lblNewLabel_10 = new JLabel("sdfd");
		lblNewLabel_10.setIcon(new ImageIcon("src/temp/mule.jpg"));
		lblNewLabel_10.setBounds(105, 11, 143, 96);
		this.add(lblNewLabel_10);

		JSeparator separator = new JSeparator();
		separator.setBounds(10, 476, 815, 7);
		this.add(separator);

		JLabel lblNewLabel_3 = new JLabel("New label");
		lblNewLabel_3.setBounds(10, 494, 815, 14);
		this.add(lblNewLabel_3);

		*/
		this.add("Town", panel);
		this.add("Store", storePanel);
		this.add("Pub", pubPanel);
		btnAssay.addActionListener(new CardUpdater(this, "Store",storePanel));
		//CardLayout cl = (CardLayout) layout.getLayout();
		//cl.show( layout, "Town");
	}

	/**
	 * Add an action listener for the Exit button.
	 * 
	 */

	public void addListener(ActionListener l) {
		btnLand.addActionListener(l);
	}

	public void resetView() {
	    System.out.println("reseting...");
	    layout.show(this, "Town");
	}

}
