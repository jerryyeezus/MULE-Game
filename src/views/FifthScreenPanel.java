package views;
import java.awt.Color;
import java.awt.EventQueue;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.SwingConstants;

import models.PlayerConfigModel;

/**
 * 
 * @author Tanay
 *
 * This class implements the GUI where Land Auction takes place. Each player gets to enter the bid
 * and then land will be granted to the highest bidder.
 */
public class FifthScreenPanel extends JPanel{


	private JTextField player3Bid;
	private JTextField player1Bid;
	private JTextField player2Bid;
	private JTextField player4Bid;
	private PlayerConfigModel model;
	public JTextField[] bids;
	JButton btnNext;
	int auctioned_i;
	int auctioned_j;
	

	/**
	 * Create the application.
	 */
	public FifthScreenPanel(PlayerConfigModel model) {
		this.model= model;
		initialize();
	}

	/**
	 * Initialize the contents of the 
	 */
	private void initialize() {
		
		setLayout(null);
		bids = new JTextField[4];
		JPanel panel = new JPanel();
		panel.setBounds(10, 61, 526, 260);
		add(panel);
		
		JLabel lblNewLabel = new JLabel("Land Auction #1");
		lblNewLabel.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel.setBounds(10, 11, 526, 14);
		add(lblNewLabel);
		
		JLabel lblNewLabel_1 = new JLabel("No Bids Tendered");
		lblNewLabel_1.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel_1.setBounds(10, 36, 526, 14);
		add(lblNewLabel_1);
		
		JLabel lblNewLabel_2 = new JLabel("Bids start at");
		lblNewLabel_2.setBounds(10, 357, 287, 14);
		add(lblNewLabel_2);
		
		JLabel lblNewLabel_3 = new JLabel("New label");
		lblNewLabel_3.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel_3.setBounds(419, 357, 117, 14);
		add(lblNewLabel_3);
		
		JLabel lblMoney = new JLabel("Money");
		lblMoney.setBounds(10, 332, 46, 14);
		add(lblMoney);
		
		JLabel label = new JLabel("Money");
		label.setBounds(490, 332, 46, 14);
		add(label);
		
		JLabel lblNewLabel_4 = new JLabel("New label");
		lblNewLabel_4.setBounds(101, 332, 46, 14);
		add(lblNewLabel_4);
		
		JLabel label_1 = new JLabel("New label");
		label_1.setBounds(200, 332, 46, 14);
		add(label_1);
		
		JLabel label_2 = new JLabel("New label");
		label_2.setBounds(299, 332, 46, 14);
		add(label_2);
		
		player1Bid = new JTextField();
		panel.add(player1Bid);
		player1Bid.setColumns(10);
		
		player2Bid = new JTextField();
		panel.add(player2Bid);
		player2Bid.setColumns(10);
		
		player3Bid = new JTextField();
		panel.add(player3Bid);
		player3Bid.setColumns(10);
		
		player4Bid = new JTextField();
		panel.add(player4Bid);
		player4Bid.setColumns(10);
		
		bids[0] = player1Bid;
		bids[1] = player2Bid;
		bids[2] = player3Bid;
		bids[3] = player4Bid;
		JLabel label_3 = new JLabel("New label");
		label_3.setBounds(386, 332, 46, 14);
		add(label_3);
		
		JButton btnExit = new JButton("Exit");
		btnExit.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				System.exit(0);
			}
		});
		btnExit.setBounds(447, 382, 89, 23);
		add(btnExit);
		
		
		btnNext = new JButton("Next>>");
		btnNext.setBounds(335, 382, 89, 23);
		add(btnNext);
		
		
		
		btnNext.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				
				
				boolean isValid = true;
				for (int i = 0; i < model.getNumPlayers(); i++)
				{
					if (model.getPlayer(i).getMoney() < Integer.parseInt(bids[i].getText()) )
					{
						isValid = false;
						System.out.println("Bids invalid.");
						break;
					}
				}
				
				if (isValid) {
					
				}
			}
			
		});

	}

	/**
	 * Action listener for the next button to allow game to proceed.
	 * @param l
	 */
	public void addActionListener(ActionListener l) {
		btnNext.addActionListener(l);
		
	}
}
