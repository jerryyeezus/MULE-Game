package views;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JSeparator;
import javax.swing.JTextField;

import models.PlayerConfigModel;
import models.PlayerModel;
import models.StoreModel;
/**
 * The SlickDeals store where the player can buy and sell his resourses 
 * Depending upon the moneey he has.
 * 
 * @author Tanay
 *
 */
public class StorePanel extends JPanel {
	StoreModel storeModel;
	PlayerConfigModel model;
	private JFrame frame;
	private JTextField textField;
	private JTextField textField_1;
	private JLabel foodAvailable;
	private JLabel lblSellStatus;
	private JLabel lblBuyStatus;
	int a;


	/**
	 * Constructor to initilize all the variables.
	 * 
	 * @param model
	 */
	public StorePanel(PlayerConfigModel model) {
		super();
		storeModel = new StoreModel();
		this.model = model;
		this.initialize();
	}

	/**
	 * creates the gui and adds all the components.
	 * It checks for the available resources to instantiate transactions;
	 */
	public void initialize() {
		setLayout(null);

		JSeparator separator = new JSeparator();
		separator.setBounds(10, 175, 450, 120);
		add(separator);

		JLabel lblNewLabel = new JLabel("SELL");
		lblNewLabel.setBounds(200, 20, 50, 25);
		add(lblNewLabel);

		JLabel lblBuy = new JLabel("BUY");
		lblBuy.setBounds(200, 225, 50, 25);
		add(lblBuy);

		JButton btnNewButton = new JButton("Sell Items");
		btnNewButton.setBounds(160, 89, 89, 23);
		add(btnNewButton);
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Integer noOfItems = Integer.parseInt(textField.getText());
				int a = model.getCurPlayer();
				PlayerModel p = model.getPlayer(a);
				if (noOfItems <= p.getFood()){
					storeModel.increaseInventory(noOfItems);
					int moneyEarned = noOfItems*storeModel.getPriceOfGoods();
					model.getPlayer(a).setMoney(model.getPlayer(a).getMoney() + moneyEarned);
					p.setFood(p.getFood()-noOfItems);
					textField.setText("0");
					//System.out.println(model.getPlayer(a).getMoney());
					foodAvailable.setText(storeModel.getGoodsAvailable()+"");
					lblSellStatus.setText("You have sold " + noOfItems + " and gained "+ moneyEarned + "money.");
					lblBuyStatus.setText("");
				}
				else{
					JOptionPane.showMessageDialog(textField, "Can't sell more items than you have");
				}
			}
		});

		JButton btnNewButton_1 = new JButton("Buy Goods");
		btnNewButton_1.setBounds(160, 330, 89, 23);
		add(btnNewButton_1);
		btnNewButton_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Integer noOfItems = Integer.parseInt(textField_1.getText());
				a = model.getCurPlayer();
				int moneyAvailable = model.getPlayer(a).getMoney();
				int priceNeeded = noOfItems*storeModel.getPriceOfGoods();
				if (moneyAvailable >= priceNeeded){
					storeModel.reduceInventory(noOfItems);
					int moneySpent = noOfItems*storeModel.getPriceOfGoods();
					model.getPlayer(a).setMoney(model.getPlayer(a).getMoney() - moneySpent);
					model.getPlayer(a).setFood(model.getPlayer(a).getFood()+noOfItems);
					textField_1.setText("0");
					System.out.println(model.getPlayer(a).getMoney());
					foodAvailable.setText(storeModel.getGoodsAvailable()+"");
					lblBuyStatus.setText("You have bought " + noOfItems + " and spent "+ moneySpent + "money.");
					lblSellStatus.setText("");
				}
				else{
					JOptionPane.showMessageDialog(textField, "Can't buy items worth more than existing Money");
				}
				
			}
		});

		JLabel lblGoodsAvailable = new JLabel("Number of Food to sell");
		lblGoodsAvailable.setBounds(70, 50, 175, 20);
		add(lblGoodsAvailable);

		textField = new JTextField("0");
		textField.setBounds(255, 45, 70, 20);
		add(textField);
		textField.setColumns(10);

		JLabel lblAvailableNumberOf = new JLabel("Available Number of Food : ");
		lblAvailableNumberOf.setBounds(70, 250, 150, 20);
		add(lblAvailableNumberOf);

		foodAvailable = new JLabel("New label");
		foodAvailable.setBounds(250, 250, 50, 20);
		add(foodAvailable);

		JLabel lblQuantityOfFood = new JLabel("Quantity of Food  :");
		lblQuantityOfFood.setBounds(70, 300, 150, 20);
		add(lblQuantityOfFood);

		textField_1 = new JTextField("0");
		textField_1.setBounds(220, 300, 100, 20);
		add(textField_1);
		textField_1.setColumns(10);
		
		JButton btnBack = new JButton("Back to Town");
		btnBack.setBounds(460, 400, 120, 23);
		add(btnBack);
		btnBack.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				setVisible(false);
			}
		});
		
		lblSellStatus = new JLabel("");
		lblSellStatus.setBounds(70, 150, 250, 20);
		add(lblSellStatus);

		lblBuyStatus = new JLabel("");
		lblBuyStatus.setBounds(70, 360, 250, 20);
		add(lblBuyStatus);
	}

	/**
	 * gets the information from the player regarding his available resources.
	 */
	public void runStore() {
		int storeGoods = storeModel.getGoodsAvailable();
		int playerGoods = model.getPlayer(model.getCurPlayer()).getFood();
		int playerMoney = model.getPlayer(model.getCurPlayer()).getMoney();
		foodAvailable.setText(storeGoods+"");

	}

}
