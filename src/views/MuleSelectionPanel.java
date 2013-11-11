package views;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;

import models.PlayerConfigModel;
import models.PlayerModel;

/**
<<<<<<< HEAD
 * The panel where the user can select the type of Mule he wants 
 * to buy. it also displays the price of each mule.
 * 
 * @author Tanay
 *
=======
 * @author yee
 * Controller logic for mule selection. Lets u choose between mules and calls the doMule() function in MulePlacementPanel
>>>>>>> 4d3a36d2d205e3a0d8a81b32db2b8bd3089c7bfa
 */
public class MuleSelectionPanel extends JPanel{
	
	private JButton btnNewButton;
	private JButton btnNewButton_1;
	private JButton btnNewButton_2;
	private PlayerConfigModel model;
	
	private TownPanel townPanel;
	
	/**
	 * Constructor to initilize variables.
	 * 
	 * @param townPanel
	 * @param model
	 */
	public MuleSelectionPanel( TownPanel townPanel, PlayerConfigModel model){
		super();
		this.model = model;
		this.townPanel = townPanel;
		initialize();
	}
	
	/**
	 * Sets the buttons in place and adds the labels.
	 */
	private void initialize() {
		setBounds(100, 100, 450, 300);
		setLayout(null);
		int money =model.getPlayer(model.getCurPlayer()).getMoney();
		System.out.println(money + " money for player " + model.getCurPlayer());
		
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
	public void setVisiblity(){
		this.setVisible(false);
	}
	
	/**
	 * Private MuleListener class that inplements ActionListener interface.
	 * It adds functionality to all the three ule selection buttons.
	 * 
	 * @author Tanay
	 *
	 */
	private class MuleListener implements ActionListener {
		int muleType;
		public MuleListener(int muleType){
			this.muleType = muleType;
			
		}
		@Override
		public void actionPerformed(ActionEvent arg0) {
			
			PlayerModel p = model.getPlayer(model.getCurPlayer());
			int money = p.getMoney();
			if(muleType ==1 && money>=37){
				p.setMoney(p.getMoney()-37);
				townPanel.gotoMulePlacement(muleType);
			}
			else if(money < 37){
				setVisiblity();
				message();
				
			}
			else if(muleType ==2 && money>=13){
				p.setMoney(p.getMoney()-13);
				townPanel.gotoMulePlacement(muleType);
			}
			else if(money <13){
				setVisiblity();
				message();
			}
			else if(muleType ==3  && money>=56){
				p.setMoney(p.getMoney()-56);
				townPanel.gotoMulePlacement(muleType);
			}
			else if(money < 56){
				setVisiblity();
				message();
			}
			
			
		}
		public void message(){
			JOptionPane.showMessageDialog(null, "You don't have enough money! Going back to town...");
		}
		
	}
	
}
