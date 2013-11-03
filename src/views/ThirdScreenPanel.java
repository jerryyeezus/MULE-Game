package views;
import java.awt.EventQueue;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.SwingConstants;

import models.PlayerConfigModel;
/**
 * 
 * @author Tanay
 * 
 * This class creates the User Interface for the Status Summary which mentions 
 * all the stats (money, land, goods) assigned with the player.
 * 
 */

public class ThirdScreenPanel extends JPanel {

	private PlayerConfigModel model;
	JButton btnNewButton_1;
	/**
	 * Create the application.
	 */
	public ThirdScreenPanel(PlayerConfigModel model) {
		this.model = model;
		initialize();
	}
	/**
	 * Launch the application.
	 */


	/**
	 * Initialize the contents of the frame.
	 */

	private void initialize() {
		setBounds(10, 78, 542, 125);
		setLayout(null);
		
		
		if(model.getPlayer(0) != null)
		{
		
			JPanel panel = new JPanel();
			panel.setLayout(null);
			panel.setBounds(10, 11, 400, 136);
			add(panel);
			
			JLabel lblPlayer = new JLabel(""+model.getPlayer(0).getName());
			lblPlayer.setBounds(10, 11, 301, 14);
			panel.add(lblPlayer);
			
			JLabel lblNewLabel = new JLabel("Money");
			lblNewLabel.setBounds(10, 36, 46, 14);
			panel.add(lblNewLabel);
			
			JLabel lblNewLabel_1 = new JLabel("Land");
			lblNewLabel_1.setBounds(10, 61, 46, 14);
			panel.add(lblNewLabel_1);
			
			JLabel lblNewLabel_2 = new JLabel("Goods");
			lblNewLabel_2.setBounds(10, 86, 46, 14);
			panel.add(lblNewLabel_2);
			
			JLabel lblNewLabel_3 = new JLabel("Total");
			lblNewLabel_3.setBounds(10, 111, 46, 14);
			panel.add(lblNewLabel_3);
	
			JLabel lblNewLabel_4 = new JLabel(""+model.getPlayer(0).getMoney());
			lblNewLabel_4.setBounds(131, 36, 159, 14);
			panel.add(lblNewLabel_4);
			
			JLabel lblNewLabel_5 = new JLabel(""+model.getPlayer(0).getLand());
			lblNewLabel_5.setBounds(131, 61, 159, 14);
			panel.add(lblNewLabel_5);
			
			JLabel lblNewLabel_6 = new JLabel(""+model.getPlayer(0).getFood());
			lblNewLabel_6.setBounds(131, 86, 159, 14);
			panel.add(lblNewLabel_6);
			
			JLabel lblNewLabel_7 = new JLabel(""+model.getPlayer(0).getTotal());
			lblNewLabel_7.setBounds(131, 111, 159, 14);
			panel.add(lblNewLabel_7);
			
		}
		
		if(model.getPlayer(1) != null)
		{
			JPanel panel_4 = new JPanel();
			panel_4.setLayout(null);
			panel_4.setBounds(425, 11, 400, 136);
			add(panel_4);
			
			JLabel label = new JLabel(""+model.getPlayer(1).getName());
			label.setBounds(10, 11, 301, 14);
			panel_4.add(label);
			
			JLabel lblPM = new JLabel(""+model.getPlayer(1).getMoney());
			lblPM.setBounds(131, 36, 159, 14);
			panel_4.add(lblPM);
			
			JLabel lblPL = new JLabel(""+model.getPlayer(1).getLand());
			lblPL.setBounds(131, 61, 159, 14);
			panel_4.add(lblPL);
			
			JLabel lblPG = new JLabel(""+model.getPlayer(1).getFood());
			lblPG.setBounds(131, 86, 159, 14);
			panel_4.add(lblPG);
			
			JLabel lblPT = new JLabel(""+model.getPlayer(1).getTotal());
			lblPT.setBounds(131, 111, 159, 14);
			panel_4.add(lblPT);
			
			JLabel label_25 = new JLabel("Money");
			label_25.setBounds(10, 36, 46, 14);
			panel_4.add(label_25);
			
			JLabel label_26 = new JLabel("Land");
			label_26.setBounds(10, 61, 46, 14);
			panel_4.add(label_26);
			
			JLabel label_27 = new JLabel("Goods");
			label_27.setBounds(10, 86, 46, 14);
			panel_4.add(label_27);
			
			JLabel label_28 = new JLabel("Total");
			label_28.setBounds(10, 111, 46, 14);
			panel_4.add(label_28);
			
		}
		
		if(model.getPlayer(2) != null)
		{
		
			JPanel panel_1 = new JPanel();
			panel_1.setLayout(null);
			panel_1.setBounds(10, 158, 400, 136);
			add(panel_1);
			
			JLabel label_1 = new JLabel(""+model.getPlayer(2).getName());
			label_1.setBounds(10, 11, 301, 14);
			panel_1.add(label_1);
			
			JLabel label_2 = new JLabel("Money");
			label_2.setBounds(10, 36, 46, 14);
			panel_1.add(label_2);
			
			JLabel label_3 = new JLabel("Land");
			label_3.setBounds(10, 61, 46, 14);
			panel_1.add(label_3);
			
			JLabel label_4 = new JLabel("Goods");
			label_4.setBounds(10, 86, 46, 14);
			panel_1.add(label_4);
			
			JLabel label_5 = new JLabel("Total");
			label_5.setBounds(10, 111, 46, 14);
			panel_1.add(label_5);
			
			JLabel lblPM_2 = new JLabel(""+model.getPlayer(2).getMoney());
			lblPM_2.setBounds(131, 36, 159, 14);
			panel_1.add(lblPM_2);
			
			JLabel lblPL_2 = new JLabel(""+model.getPlayer(2).getLand());
			lblPL_2.setBounds(131, 61, 159, 14);
			panel_1.add(lblPL_2);
			
			JLabel lblPG_2 = new JLabel(""+model.getPlayer(2).getFood());
			lblPG_2.setBounds(131, 86, 159, 14);
			panel_1.add(lblPG_2);
			
			JLabel lblPT_2 = new JLabel(""+model.getPlayer(2).getTotal());
			lblPT_2.setBounds(131, 111, 159, 14);
			panel_1.add(lblPT_2);
			
		
		}
		
		if(model.getPlayer(3) != null)
		{
		
			JPanel panel_2 = new JPanel();
			panel_2.setLayout(null);
			panel_2.setBounds(425, 158, 400, 136);
			add(panel_2);
			
			JLabel label_10 = new JLabel(""+model.getPlayer(3).getName());
			label_10.setBounds(10, 11, 301, 14);
			panel_2.add(label_10);
			
			JLabel label_11 = new JLabel("Money");
			label_11.setBounds(10, 36, 46, 14);
			panel_2.add(label_11);
			
			JLabel label_12 = new JLabel("Land");
			label_12.setBounds(10, 61, 46, 14);
			panel_2.add(label_12);
			
			JLabel label_13 = new JLabel("Goods");
			label_13.setBounds(10, 86, 46, 14);
			panel_2.add(label_13);
			
			JLabel label_14 = new JLabel("Total");
			label_14.setBounds(10, 111, 46, 14);
			panel_2.add(label_14);
			
			JLabel lblPM_1 = new JLabel(""+model.getPlayer(3).getMoney());
			lblPM_1.setBounds(131, 36, 159, 14);
			panel_2.add(lblPM_1);
			
			JLabel lblPL_1 = new JLabel(""+model.getPlayer(3).getLand());
			lblPL_1.setBounds(131, 61, 159, 14);
			panel_2.add(lblPL_1);
			
			JLabel lblPG_1 = new JLabel(""+model.getPlayer(3).getFood());
			lblPG_1.setBounds(131, 86, 159, 14);
			panel_2.add(lblPG_1);
			
			JLabel lblPT_1 = new JLabel(""+model.getPlayer(3).getTotal());
			lblPT_1.setBounds(131, 111, 159, 14);
			panel_2.add(lblPT_1);
			
		}
		
		btnNewButton_1 = new JButton("Next>>");
		btnNewButton_1.setBounds(450, 450, 70, 70);
		add(btnNewButton_1);
		
		JButton btnNewButton_2 = new JButton("Exit");
		btnNewButton_2.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				System.exit(0);
			}
		});
		
		btnNewButton_2.setBounds(463, 622, 89, 23);
		add(btnNewButton_2);
		
		JLabel lblNewLabel_8 = new JLabel("M.U.L.E.");
		lblNewLabel_8.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel_8.setBounds(115, 11, 437, 31);
		add(lblNewLabel_8);
		
	}

/**
 * This method implements the action listener for the next button which takes us to the next class.
 * 
 * @param action listener object l
 */

	public void addActionListener(ActionListener l) {
		btnNewButton_1.addActionListener(l);
		
	}
}
