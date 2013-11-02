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
import models.StoreModel;

public class StorePanel extends JPanel {
	StoreModel storeModel;
	PlayerConfigModel model;
	private JFrame frame;
	private JTextField textField;
	private JTextField textField_1;
	private JLabel foodAvailable;
	int playerNumber;


	public StorePanel(PlayerConfigModel model) {
		super();
		storeModel = new StoreModel();
		this.model = model;
		this.initialize();
	}

	public void initialize() {
		setLayout(null);

		JSeparator separator = new JSeparator();
		separator.setBounds(10, 123, 424, 113);
		add(separator);

		JLabel lblNewLabel = new JLabel("SELL");
		lblNewLabel.setBounds(194, 11, 46, 14);
		add(lblNewLabel);

		JLabel lblBuy = new JLabel("BUY");
		lblBuy.setBounds(194, 123, 46, 25);
		add(lblBuy);

		JButton btnNewButton = new JButton("Sell Items");
		btnNewButton.setBounds(160, 89, 89, 23);
		add(btnNewButton);
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Integer noOfItems = Integer.parseInt(textField.getText());
				if (noOfItems <= storeModel.getGoodsAvailable()){
					storeModel.increaseInventory(noOfItems);
					playerNumber = model.getCurPlayer();
					model.getPlayer(playerNumber).setMoney(model.getPlayer(playerNumber).getMoney() + (noOfItems*storeModel.getPriceOfGoods()));
					textField.setText("0");
					System.out.println(model.getPlayer(playerNumber).getMoney());
				}
				else{
					JOptionPane.showMessageDialog(textField, "Can't sell more items than what you have dumbass");
				}
			}
		});

		JButton btnNewButton_1 = new JButton("Buy Goods");
		btnNewButton_1.setBounds(160, 228, 89, 23);
		add(btnNewButton_1);
		btnNewButton_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Integer noOfItems = Integer.parseInt(textField_1.getText());
				playerNumber = model.getCurPlayer();
				int moneyAvailable = model.getPlayer(playerNumber).getMoney();
				int priceNeeded = noOfItems*storeModel.getPriceOfGoods();
				if (moneyAvailable >= priceNeeded){
					storeModel.reduceInventory(noOfItems);
					model.getPlayer(playerNumber).setMoney(model.getPlayer(playerNumber).getMoney() - (noOfItems*storeModel.getPriceOfGoods()));
					textField_1.setText("0");
					System.out.println(model.getPlayer(playerNumber).getMoney());
				}
				else{
					JOptionPane.showMessageDialog(textField, "Dont have enough money");
				}
			}
		});

		JLabel lblGoodsAvailable = new JLabel("Number of Food to sell");
		lblGoodsAvailable.setBounds(67, 48, 143, 14);
		add(lblGoodsAvailable);

		textField = new JTextField("0");
		textField.setBounds(224, 45, 86, 20);
		add(textField);
		textField.setColumns(10);

		JLabel lblAvailableNumberOf = new JLabel("Available Number of Food : ");
		lblAvailableNumberOf.setBounds(52, 153, 143, 14);
		add(lblAvailableNumberOf);

		foodAvailable = new JLabel("New label");
		foodAvailable.setBounds(218, 153, 46, 14);
		add(foodAvailable);

		JLabel lblQuantityOfFood = new JLabel("Quantity of Food  :");
		lblQuantityOfFood.setBounds(52, 189, 143, 14);
		add(lblQuantityOfFood);

		textField_1 = new JTextField("0");
		textField_1.setBounds(218, 186, 86, 20);
		add(textField_1);
		textField_1.setColumns(10);
	}

	public void runStore() {
		int storeGoods = storeModel.getGoodsAvailable();
		int playerGoods = model.getPlayer(model.getCurPlayer()).getGoods();
		int playerMoney = model.getPlayer(model.getCurPlayer()).getMoney();
		foodAvailable.setText(storeGoods+"");

	}

}
