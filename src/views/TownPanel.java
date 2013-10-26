package views;
import java.awt.Event.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.*;

import javax.swing.*;

import models.PlayerConfigModel;

/**
 * 
 * @author Tanay
 *
 * This class contains the Town frame which contains different buttons which trigger different events.
 *
 */
public class TownPanel extends JPanel {

	private PlayerConfigModel model;
	/**
	 * Create the application.
	 */
	public TownPanel(PlayerConfigModel model) {
		this.model = model;
		JLabel s = new JLabel("shit");
		s.setBounds(680, 450, 301, 14);
		this.add(s);
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		
	}
}
