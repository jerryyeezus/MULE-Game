package views;

import java.awt.EventQueue;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.HashMap;
import java.util.Random;

import javax.swing.*;

import models.GameConfigModel;
import models.PlayerConfigModel;
import models.PlayerModel;

public class Pub extends JPanel {

    Random rand;
    int valueFromGambling;
    PlayerConfigModel model;
    int playerNumber;
    PlayerModel playerMod;
    JLabel lblNewLabel;

    /**
     * Launch the application.
     */

    /**
     * Create the application.
     */
    public Pub(PlayerConfigModel model) {
	this.model = model;
	/*
	rand = new Random();
	valueFromGambling = rand.nextInt(100);
	playerNumber = model.getCurPlayer();
	playerMod = model.getPlayer(playerNumber);
	playerMod.setMoney(playerMod.getMoney() + valueFromGambling);
	model.setTimer(0);
	*/

	initialize();

    }
    
    /**
     * Called to run the gamble algorithm
     */
    public void gamble() {
	rand = new Random();
	valueFromGambling = rand.nextInt(100);
	playerNumber = model.getCurPlayer();
	playerMod = model.getPlayer(playerNumber);
	playerMod.setMoney(playerMod.getMoney() + valueFromGambling);
	model.setTimer(1);
	this.setLabel();
    }

    /**
     * Initialize the contents of the
     */
    private void initialize() {

	setBounds(100, 100, 850, 550);
	this.setLayout(null);

	JPanel panel = new JPanel();
	panel.setBounds(10, 120, 814, 313);
	this.add(panel);
	panel.setLayout(null);

	lblNewLabel = new JLabel("New label");
	lblNewLabel.setBounds(160, 11, 500, 250);
	panel.add(lblNewLabel);

	JLabel lblNewLabel_1 = new JLabel("New label");
	lblNewLabel_1.setBounds(160, 272, 500, 30);
	setLabel();
	panel.add(lblNewLabel_1);

	JLabel lblGamble = new JLabel("GAMBLING");
	lblGamble.setBounds(354, 81, 450, 28);
	add(lblGamble);
	lblGamble.setHorizontalAlignment(SwingConstants.LEFT);

	/*
	JButton btnNext = new JButton("Next>>");
	btnNext.setBounds(735, 444, 89, 23);
	btnNext.addActionListener(new ActionListener() {

	    @Override
	    public void actionPerformed(ActionEvent e) {
		setVisible(false);

	    }
	});
	add(btnNext);
	*/
    }

    private void setLabel() {
	lblNewLabel.setText("You have won " + valueFromGambling
		+ " dollars from Gambling..");
    }

}