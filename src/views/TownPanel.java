package views;

import java.awt.Event.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.*;

import javax.swing.*;

import models.GameConfigModel;
import models.PlayerConfigModel;

/**
 * 
 * @author Tanay
 * 
 *         This class contains the Town this which contains different buttons
 *         which trigger different events.
 * 
 */
public class TownPanel extends JPanel {
	// Pub, Buy MULES, Go to Map,
	private PlayerConfigModel model;
	JButton btnLand;
	JButton btnPub;
	private GameConfigModel gameConfig;

	/**
	 * Create the application.
	 */
	public TownPanel(PlayerConfigModel model) {
		this.model = model;
		this.gameConfig = gameConfig;
		this.setLayout(null);
		this.initialize();
	}

	/**
	 * Initialize the contents of the this.
	 */
	private void initialize() {

		JPanel panel = new JPanel();
		panel.setBounds(10, 118, 815, 313);
		this.add(panel);
		panel.setLayout(null);

		btnPub = new JButton("");

		btnPub.setIcon(new ImageIcon("src/temp/miniPub.jpg"));
		btnPub.setBounds(10, 174, 304, 128);
		btnPub.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				Pub p = new Pub(model);
				p.setVisible(true);

			}
		});
		panel.add(btnPub);

		JButton btnAssay = new JButton("ASSAY OFFICE");
		// btnAssay.setIcon(new
		// ImageIcon("src/temp/miniLand.jpg"));
		btnAssay.setBounds(10, 11, 304, 128);
		panel.add(btnAssay);

		btnLand = new JButton("");
		btnLand.setIcon(new ImageIcon("src/temp/miniLand.jpg"));
		btnLand.setBounds(501, 11, 304, 128);
		panel.add(btnLand);

		JLabel lblNewLabel_1 = new JLabel("TOWN");
		lblNewLabel_1.setFont(new Font("Times New Roman", Font.BOLD, 30));
		lblNewLabel_1.setBounds(324, 96, 167, 128);
		panel.add(lblNewLabel_1);
		lblNewLabel_1.setHorizontalAlignment(SwingConstants.CENTER);

		JButton btnStore = new JButton("");
		btnStore.setIcon(new ImageIcon("src/temp/mule.jpg"));
		btnStore.setBounds(501, 174, 304, 128);
		panel.add(btnStore);

		JButton btnExit = new JButton("Exit");
		btnExit.setBounds(736, 442, 89, 23);
		this.add(btnExit);

		JButton btnNewButton = new JButton("Next>>");
		btnNewButton.setBounds(627, 442, 89, 23);

		this.add(btnNewButton);

		JLabel lblNewLabel_10 = new JLabel("");
		lblNewLabel_10.setIcon(new ImageIcon("src/temp/mule.jpg"));
		lblNewLabel_10.setBounds(105, 11, 143, 96);
		this.add(lblNewLabel_10);

		JSeparator separator = new JSeparator();
		separator.setBounds(10, 476, 815, 7);
		this.add(separator);

		JLabel lblNewLabel_3 = new JLabel("New label");
		lblNewLabel_3.setBounds(10, 494, 815, 14);
		this.add(lblNewLabel_3);

	}

	/**
	 * Add an action listener for the Exit button.
	 * 
	 */

	public void addListener(ActionListener l) {
		btnLand.addActionListener(l);
	}

}
