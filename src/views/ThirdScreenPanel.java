package views;
import java.awt.Color;
import java.awt.EventQueue;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.BorderFactory;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.SwingConstants;
import javax.swing.border.Border;

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
		setBounds(0, 0, 850, 550);
		setLayout(null);
		setBackground(new Color(255, 239, 213));
		if(model.getPlayer(0) != null)
		{
		
			JPanel panel = new JPanel();
			panel.setLayout(null);
			panel.setBounds(10, 150, 350, 136);
			panel.setBackground(Color.pink);
			panel.setBorder(BorderFactory.createMatteBorder(7, 7, 7, 7, model.getPlayer(0).getColor()));
			add(panel);
			
			JLabel lblPlayer = new JLabel(model.getPlayer(0).getName());
			lblPlayer.setBounds(10, 11, 301, 14);
			lblPlayer.setForeground(model.getPlayer(0).getColor());
			panel.add(lblPlayer);
			
			JLabel lblMoney = new JLabel("Money");
			lblMoney.setBounds(10, 36, 46, 14);
			lblMoney.setForeground(model.getPlayer(0).getColor());
			panel.add(lblMoney);
			
			JLabel lblLand = new JLabel("Land");
			lblLand.setBounds(10, 61, 46, 14);
			lblLand.setForeground(model.getPlayer(0).getColor());
			panel.add(lblLand);
			
			JLabel lblGoods = new JLabel("Goods");
			lblGoods.setBounds(10, 86, 46, 14);
			lblGoods.setForeground(model.getPlayer(0).getColor());
			panel.add(lblGoods);
			
			JLabel lblTotal = new JLabel("Total");
			lblTotal.setBounds(10, 111, 46, 14);
			lblTotal.setForeground(model.getPlayer(0).getColor());
			panel.add(lblTotal);
	
			JLabel lblGetMoney = new JLabel(""+model.getPlayer(0).getMoney());
			lblGetMoney.setBounds(131, 36, 159, 14);
			lblGetMoney.setForeground(model.getPlayer(0).getColor());
			panel.add(lblGetMoney);
			
			JLabel lblGetLand = new JLabel(""+model.getPlayer(0).getLand());
			lblGetLand.setBounds(131, 61, 159, 14);
			lblGetLand.setForeground(model.getPlayer(0).getColor());
			panel.add(lblGetLand);
			
			JLabel lblgetGoods = new JLabel(""+model.getPlayer(0).getGoods());
			lblgetGoods.setBounds(131, 86, 159, 14);
			lblgetGoods.setForeground(model.getPlayer(0).getColor());
			panel.add(lblgetGoods);
			
			JLabel lblGetTotal = new JLabel(""+model.getPlayer(0).getTotal());
			lblGetTotal.setBounds(131, 111, 159, 14);
			lblGetTotal.setForeground(model.getPlayer(0).getColor());
			panel.add(lblGetTotal);
			
		}
		
		if(model.getPlayer(1) != null)
		{
			JPanel panelPlayer1 = new JPanel();
			panelPlayer1.setLayout(null);
			panelPlayer1.setBounds(425, 150, 350, 136);
			panelPlayer1.setBackground(Color.pink);
			panelPlayer1.setBorder(BorderFactory.createMatteBorder(7, 7, 7, 7, model.getPlayer(1).getColor()));
			add(panelPlayer1);
			
			JLabel label = new JLabel(""+model.getPlayer(1).getName());
			label.setBounds(10, 11, 301, 14);
			label.setForeground(model.getPlayer(1).getColor());
			panel_4.add(label);
			
			JLabel lblPM = new JLabel(""+model.getPlayer(1).getMoney());
			lblPM.setBounds(131, 36, 159, 14);
			lblPM.setForeground(model.getPlayer(1).getColor());
			panel_4.add(lblPM);
			
			JLabel lblPL = new JLabel(""+model.getPlayer(1).getLand());
			lblPL.setBounds(131, 61, 159, 14);
			lblPL.setForeground(model.getPlayer(1).getColor());
			panel_4.add(lblPL);
			
			JLabel lblPG = new JLabel(""+model.getPlayer(1).getGoods());
			lblPG.setBounds(131, 86, 159, 14);
			lblPG.setForeground(model.getPlayer(1).getColor());
			panel_4.add(lblPG);
			
			JLabel lblPT = new JLabel(""+model.getPlayer(1).getTotal());
			lblPT.setBounds(131, 111, 159, 14);
			lblPT.setForeground(model.getPlayer(1).getColor());
			panel_4.add(lblPT);
			
			JLabel lblMoney = new JLabel("Money");
			lblMoney.setBounds(10, 36, 46, 14);
			lblMoney.setForeground(model.getPlayer(1).getColor());
			panelPlayer1.add(lblMoney);
			
			JLabel lblLand = new JLabel("Land");
			lblLand.setBounds(10, 61, 46, 14);
			lblLand.setForeground(model.getPlayer(1).getColor());
			panelPlayer1.add(lblLand);
			
			JLabel lblGoods = new JLabel("Goods");
			lblGoods.setBounds(10, 86, 46, 14);
			lblGoods.setForeground(model.getPlayer(1).getColor());
			panelPlayer1.add(lblGoods);
			
			JLabel lblTotal = new JLabel("Total");
			lblTotal.setBounds(10, 111, 46, 14);
			lblTotal.setForeground(model.getPlayer(1).getColor());
			panelPlayer1.add(lblTotal);
			
		}
		
		if(model.getPlayer(2) != null)
		{
		
			JPanel panel_1 = new JPanel();
			panel_1.setLayout(null);
			panel_1.setBounds(10, 310, 350, 136);
			panel_1.setBackground(Color.pink);
			panel_1.setBorder(BorderFactory.createMatteBorder(7, 7, 7, 7, model.getPlayer(2).getColor()));
			add(panel_1);
			
			JLabel label_1 = new JLabel(""+model.getPlayer(2).getName());
			label_1.setBounds(10, 11, 301, 14);
			label_1.setForeground(model.getPlayer(2).getColor());
			panel_1.add(label_1);
			
			JLabel lblMoney = new JLabel("Money");
			lblMoney.setBounds(10, 36, 46, 14);
			lblMoney.setForeground(model.getPlayer(2).getColor());
			panelPlayer2.add(lblMoney);
			
			JLabel lblLand = new JLabel("Land");
			lblLand.setBounds(10, 61, 46, 14);
			lblLand.setForeground(model.getPlayer(2).getColor());
			panelPlayer2.add(lblLand);
			
			JLabel lblGoods = new JLabel("Goods");
			lblGoods.setBounds(10, 86, 46, 14);
			lblGoods.setForeground(model.getPlayer(2).getColor());
			panelPlayer2.add(lblGoods);
			
			JLabel lblTotal = new JLabel("Total");
			lblTotal.setBounds(10, 111, 46, 14);
			lblTotal.setForeground(model.getPlayer(2).getColor());
			panelPlayer2.add(lblTotal);
			
			JLabel lblPM_2 = new JLabel(""+model.getPlayer(2).getMoney());
			lblPM_2.setBounds(131, 36, 159, 14);
			lblPM_2.setForeground(model.getPlayer(2).getColor());
			panel_1.add(lblPM_2);
			
			JLabel lblPL_2 = new JLabel(""+model.getPlayer(2).getLand());
			lblPL_2.setBounds(131, 61, 159, 14);
			lblPL_2.setForeground(model.getPlayer(2).getColor());
			panel_1.add(lblPL_2);
			
			JLabel lblPG_2 = new JLabel(""+model.getPlayer(2).getGoods());
			lblPG_2.setBounds(131, 86, 159, 14);
			lblPG_2.setForeground(model.getPlayer(2).getColor());
			panel_1.add(lblPG_2);
			
			JLabel lblPT_2 = new JLabel(""+model.getPlayer(2).getTotal());
			lblPT_2.setBounds(131, 111, 159, 14);
			lblPT_2.setForeground(model.getPlayer(2).getColor());
			panel_1.add(lblPT_2);
			
		
		}
		
		if(model.getPlayer(3) != null)
		{
		
			JPanel panel_2 = new JPanel();
			panel_2.setLayout(null);
			panel_2.setBounds(425, 310, 350, 136);
			panel_2.setBackground(Color.pink);
			panel_2.setBorder(BorderFactory.createMatteBorder(7, 7, 7, 7, model.getPlayer(3).getColor()));
			add(panel_2);
			
			JLabel label_10 = new JLabel(""+model.getPlayer(3).getName());
			label_10.setBounds(10, 11, 301, 14);
			label_10.setForeground(model.getPlayer(3).getColor());
			panel_2.add(label_10);
			
			JLabel lblMoney = new JLabel("Money");
			lblMoney.setBounds(10, 36, 46, 14);
			lblMoney.setForeground(model.getPlayer(3).getColor());
			panelPlayer3.add(lblMoney);
			
			JLabel lblLand = new JLabel("Land");
			lblLand.setBounds(10, 61, 46, 14);
			lblLand.setForeground(model.getPlayer(3).getColor());
			panelPlayer3.add(lblLand);
			
			JLabel lblGoods = new JLabel("Goods");
			lblGoods.setBounds(10, 86, 46, 14);
			lblGoods.setForeground(model.getPlayer(3).getColor());
			panelPlayer3.add(lblGoods);
			
			JLabel lblTotal = new JLabel("Total");
			lblTotal.setBounds(10, 111, 46, 14);
			lblTotal.setForeground(model.getPlayer(3).getColor());
			panelPlayer3.add(lblTotal);
			
			JLabel lblPM_1 = new JLabel(""+model.getPlayer(3).getMoney());
			lblPM_1.setBounds(131, 36, 159, 14);
			lblPM_1.setForeground(model.getPlayer(3).getColor());
			panel_2.add(lblPM_1);
			
			JLabel lblPL_1 = new JLabel(""+model.getPlayer(3).getLand());
			lblPL_1.setBounds(131, 61, 159, 14);
			lblPL_1.setForeground(model.getPlayer(3).getColor());
			panel_2.add(lblPL_1);
			
			JLabel lblPG_1 = new JLabel(""+model.getPlayer(3).getGoods());
			lblPG_1.setBounds(131, 86, 159, 14);
			lblPG_1.setForeground(model.getPlayer(3).getColor());
			panel_2.add(lblPG_1);
			
			JLabel lblPT_1 = new JLabel(""+model.getPlayer(3).getTotal());
			lblPT_1.setBounds(131, 111, 159, 14);
			lblPT_1.setForeground(model.getPlayer(3).getColor());
			panel_2.add(lblPT_1);
			
		}
		
		btnNewButton_1 = new JButton("Next>>");
		btnNewButton_1.setBounds(350, 475, 100, 23);
		add(btnNewButton_1);
		
		JButton btnNewButton_2 = new JButton("Exit");
		btnNewButton_2.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				System.exit(0);
			}
		});
		
		btnNewButton_2.setBounds(460, 475, 89, 23);
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
