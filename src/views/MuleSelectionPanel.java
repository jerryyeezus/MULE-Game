package views;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;

import models.PlayerConfigModel;
import models.PlayerModel;

/**
 * @author yee
 * Controller logic for mule selection. Lets u choose between mules and calls the doMule() function in MulePlacementPanel
 */
public class MuleSelectionPanel extends JPanel{
	
	private JButton btnNewButton;
	private JButton btnNewButton_1;
	private JButton btnNewButton_2;
	private PlayerConfigModel model;
	
	private TownPanel townPanel;
	public MuleSelectionPanel( TownPanel townPanel, PlayerConfigModel model){
		super();
		this.model = model;
		this.townPanel = townPanel;
		initialize();
	}
	private void initialize() {
		setBounds(100, 100, 450, 300);
		setLayout(null);
		
		btnNewButton = new JButton("New button");
		btnNewButton.setBounds(68, 119, 89, 23);
		btnNewButton.setSize(135,135);
		btnNewButton.setIcon(new ImageIcon("src/temp/food-mule.jpg"));
		btnNewButton.addActionListener(new MuleListener(1));
		add(btnNewButton);
		
		btnNewButton_1 = new JButton("New button");
		btnNewButton_1.setBounds(261, 119, 89, 23);
		btnNewButton_1.setSize(135,135);
		btnNewButton_1.setIcon(new ImageIcon("src/temp/drink-mule.jpg"));
		btnNewButton_1.addActionListener(new MuleListener(2));
		add(btnNewButton_1);
		
		btnNewButton_2 = new JButton("New button");
		btnNewButton_2.setBounds(483, 119, 89, 23);
		btnNewButton_2.setSize(135,135);
		btnNewButton_2.setIcon(new ImageIcon("src/temp/Nicolas_Cage_2011_CC.jpg"));
		btnNewButton_2.addActionListener(new MuleListener(3));
		add(btnNewButton_2);
		
		JLabel foodLabel = new JLabel("Food Mule : 37 $");
		foodLabel.setBounds(100, 300, 150, 20);
		//foodLabel.setSize(50,10);
		add(foodLabel);
		
		JLabel drinkLabel = new JLabel("Drink Mule : 13 $");
		drinkLabel.setBounds(300, 300, 150, 20);
		//foodLabel.setSize(50,10);
		add(drinkLabel);
		
		JLabel cageLabel = new JLabel("Cage Mule : 56 $");
		cageLabel.setBounds(500, 300, 150, 20);
		//foodLabel.setSize(50,10);
		add(cageLabel);
		
		
		JLabel lblSelectYourMule = new JLabel("Select your mule ");
		lblSelectYourMule.setBounds(163, 62, 143, 14);
		add(lblSelectYourMule);
		
		
	}
	private class MuleListener implements ActionListener {
		int muleType;
		public MuleListener(int muleType){
			this.muleType = muleType;
		}
		@Override
		public void actionPerformed(ActionEvent arg0) {
			PlayerModel p = model.getPlayer(model.getCurPlayer());
			if(muleType ==1)
				p.setMoney(p.getMoney()-37);
			else if(muleType ==2)
				p.setMoney(p.getMoney()-13);
			else if(muleType ==3)
				p.setMoney(p.getMoney()-56);
			townPanel.gotoMulePlacement(muleType);
			
		}
		
	}
	
}
