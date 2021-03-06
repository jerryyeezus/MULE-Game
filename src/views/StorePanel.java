package views;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.util.HashMap;

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
 * 
 * GUI and controller logic for Store class
 * 
 * @author yee
 */
public class StorePanel extends JPanel {
    private static final String savefile = "game.dat";
    StoreModel storeModel;
    PlayerConfigModel model;
    private JFrame frame;
    private JTextField txtFoodSell;
    private JTextField txtDrinkSell;
    private JTextField txtCageSell;
    private JTextField txtFoodBuy;
    private JTextField txtDrinkBuy;
    private JTextField txtCageBuy;
    private JLabel foodAvailable;
    private JLabel drinkAvailable;
    private JLabel cageAvailable;
    private JLabel lblSellStatus;
    private JLabel lblBuyStatus;
    int a;
    int playerNumber;

    /**
     * Constructor to initilize all the variables.
     * 
     * @param model
     */
    public StorePanel(PlayerConfigModel model) {
	super();

	if (model.wasLoaded()) {
	    System.out.println("Loading store..");
	    ObjectInputStream in;
	    try {
		in = new ObjectInputStream(new FileInputStream(savefile));
		try {
		    //storeModel = (StoreModel) in.readObject();
		    HashMap saved;
		    saved = (HashMap) in.readObject();
		    storeModel = (StoreModel) saved.get("store");
		} catch (ClassNotFoundException e) {
		    e.printStackTrace();
		}
	    } catch (FileNotFoundException e) {
		e.printStackTrace();
	    } catch (IOException e) {
		e.printStackTrace();
	    }
	} else {
	    storeModel = new StoreModel();
	}

	this.model = model;
	this.initialize();
    }

    public StoreModel getStoreModel() {
	return this.storeModel;
    }

    /**
     * creates the gui and adds all the components. It checks for the available
     * resources to instantiate transactions;
     */
    public void initialize() {
	setBounds(0, 0, 850, 550);
	setLayout(null);

	JSeparator separator = new JSeparator();
	separator.setBounds(10, 220, 450, 25);
	add(separator);

	JLabel lblNewLabel = new JLabel("SELL");
	lblNewLabel.setBounds(200, 20, 50, 20);
	add(lblNewLabel);

	JLabel lblBuy = new JLabel("BUY");
	lblBuy.setBounds(200, 250, 50, 20);
	add(lblBuy);

	JButton btnNewButton = new JButton("Sell Items");
	btnNewButton.setBounds(160, 150, 100, 25);
	add(btnNewButton);
	btnNewButton.addActionListener(new ActionListener() {
	    public void actionPerformed(ActionEvent e) {
		Integer noOfFoodItems = Integer.parseInt(txtFoodSell.getText());
		Integer noOfDrinkItems = Integer.parseInt(txtDrinkSell
			.getText());
		Integer noOfCageItems = Integer.parseInt(txtCageSell.getText());
		int a = model.getCurPlayer();
		PlayerModel p = model.getPlayer(a);
		if (noOfFoodItems <= p.getFood()
			&& noOfDrinkItems <= p.getDrink()
			&& noOfCageItems <= p.getNicolasCage()) {
		    storeModel.addToFood(noOfFoodItems);
		    storeModel.addToDrinks(noOfDrinkItems);
		    storeModel.addToCage(noOfCageItems);
		    int moneyEarned = (noOfFoodItems * storeModel
			    .getPriceOfFood())
			    + (noOfDrinkItems * storeModel.getPriceOfDrinks())
			    + (noOfCageItems * storeModel.getPriceOfCage());
		    model.getPlayer(a).setMoney(
			    model.getPlayer(a).getMoney() + moneyEarned);
		    p.setFood(p.getFood() - noOfFoodItems);
		    p.setDrink(p.getDrink() - noOfDrinkItems);
		    p.setNicolasCage(p.getNicolasCage() - noOfCageItems);
		    txtFoodSell.setText("0");
		    txtDrinkSell.setText("0");
		    txtCageSell.setText("0");
		    foodAvailable.setText(storeModel.getFoodAvailable() + "");
		    drinkAvailable.setText(storeModel.getDrinksAvailable() + "");
		    cageAvailable.setText(storeModel.getCageAvailable() + "");
		    lblSellStatus.setText("You have sold " + noOfFoodItems
			    + " food items, " + noOfDrinkItems
			    + " drink items, " + noOfCageItems
			    + " Nicolas Cage and gained " + moneyEarned
			    + " money.");
		    lblBuyStatus.setText("");
		} else {
		    JOptionPane.showMessageDialog(lblSellStatus,
			    "Can't Sell more Items than what you have.");
		}
	    }
	});

	JButton btnNewButton_1 = new JButton("Buy Goods");
	btnNewButton_1.setBounds(160, 470, 100, 25);
	add(btnNewButton_1);
	btnNewButton_1.addActionListener(new ActionListener() {
	    public void actionPerformed(ActionEvent e) {
		Integer noOfFoodItems = Integer.parseInt(txtFoodBuy.getText());
		Integer noOfDrinkItems = Integer.parseInt(txtDrinkBuy.getText());
		Integer noOfCageItems = Integer.parseInt(txtCageBuy.getText());
		a = model.getCurPlayer();
		int moneyAvailable = model.getPlayer(a).getMoney();
		int priceNeeded = (noOfFoodItems * storeModel.getPriceOfFood())
			+ (noOfDrinkItems * storeModel.getPriceOfDrinks())
			+ (noOfCageItems * storeModel.getPriceOfCage());
		if (moneyAvailable >= priceNeeded
			&& noOfFoodItems <= storeModel.getFoodAvailable()
			&& noOfDrinkItems <= storeModel.getDrinksAvailable()
			&& noOfCageItems <= storeModel.getCageAvailable()) {
		    storeModel.reduceFood(noOfFoodItems);
		    storeModel.reduceDrinks(noOfDrinkItems);
		    storeModel.reduceCage(noOfCageItems);
		    int moneySpent = (noOfFoodItems * storeModel
			    .getPriceOfFood())
			    + (noOfDrinkItems * storeModel.getPriceOfDrinks())
			    + (noOfCageItems * storeModel.getPriceOfCage());
		    model.getPlayer(a).setMoney(
			    model.getPlayer(a).getMoney() - moneySpent);
		    model.getPlayer(a).setFood(
			    model.getPlayer(a).getFood() + noOfFoodItems);
		    model.getPlayer(a).setDrink(
			    model.getPlayer(a).getDrink() + noOfDrinkItems);
		    model.getPlayer(a)
			    .setNicolasCage(
				    model.getPlayer(a).getNicolasCage()
					    + noOfCageItems);
		    txtFoodBuy.setText("0");
		    txtDrinkBuy.setText("0");
		    txtCageBuy.setText("0");
		    // System.out.println(model.getPlayer(a).getMoney());
		    foodAvailable.setText(storeModel.getFoodAvailable() + "");
		    drinkAvailable.setText(storeModel.getDrinksAvailable() + "");
		    cageAvailable.setText(storeModel.getCageAvailable() + "");
		    lblBuyStatus.setText("You have bought " + noOfFoodItems
			    + " food items, " + noOfDrinkItems
			    + " drink items and " + noOfCageItems
			    + " Nicolas Cage and spent " + moneySpent
			    + " money.");
		    lblSellStatus.setText("");
		} else {
		    JOptionPane.showMessageDialog(lblBuyStatus,
			    "Can't buy items worth more than existing Money");
		}

	    }
	});

	JLabel lblFoodAvailable = new JLabel("Number of Food to sell");
	lblFoodAvailable.setBounds(70, 50, 175, 20);
	add(lblFoodAvailable);

	JLabel lblDrinksAvailable = new JLabel("Number of Drinks to sell");
	lblDrinksAvailable.setBounds(70, 80, 175, 20);
	add(lblDrinksAvailable);

	JLabel lblCageAvailable = new JLabel("Number of Nicolas Cage to sell");
	lblCageAvailable.setBounds(70, 110, 175, 20);
	add(lblCageAvailable);

	txtFoodSell = new JTextField("0");
	txtFoodSell.setBounds(255, 50, 70, 20);
	add(txtFoodSell);
	txtFoodSell.setColumns(10);

	txtDrinkSell = new JTextField("0");
	txtDrinkSell.setBounds(255, 80, 70, 20);
	add(txtDrinkSell);
	txtDrinkSell.setColumns(10);

	txtCageSell = new JTextField("0");
	txtCageSell.setBounds(255, 110, 70, 20);
	add(txtCageSell);
	txtCageSell.setColumns(10);

	JLabel lblAvailableNumberOf = new JLabel("Available Number of Foods: ");
	lblAvailableNumberOf.setBounds(70, 280, 170, 20);
	add(lblAvailableNumberOf);

	JLabel lblAvailableNumberOfDrink = new JLabel(
		"Available Number of Drinks: ");
	lblAvailableNumberOfDrink.setBounds(70, 310, 170, 20);
	add(lblAvailableNumberOfDrink);

	JLabel lblAvailableNumberOfCage = new JLabel(
		"Available Number of Nicolas Cages: ");
	lblAvailableNumberOfCage.setBounds(70, 340, 170, 20);
	add(lblAvailableNumberOfCage);

	foodAvailable = new JLabel("New label");
	foodAvailable.setBounds(250, 280, 50, 20);
	add(foodAvailable);

	drinkAvailable = new JLabel("");
	drinkAvailable.setBounds(250, 310, 50, 20);
	add(drinkAvailable);

	cageAvailable = new JLabel("");
	cageAvailable.setBounds(250, 340, 50, 20);
	add(cageAvailable);

	JLabel lblQuantityOfFood = new JLabel("Quantity of Foods:");
	lblQuantityOfFood.setBounds(70, 370, 150, 20);
	add(lblQuantityOfFood);

	JLabel lblQuantityOfDrink = new JLabel("Quantity of Drinks:");
	lblQuantityOfDrink.setBounds(70, 400, 150, 20);
	add(lblQuantityOfDrink);

	JLabel lblQuantityOfCage = new JLabel("Quantity of Nicolas Cage:");
	lblQuantityOfCage.setBounds(70, 430, 170, 20);
	add(lblQuantityOfCage);

	txtFoodBuy = new JTextField("0");
	txtFoodBuy.setBounds(250, 370, 70, 20);
	add(txtFoodBuy);
	txtFoodBuy.setColumns(10);

	txtDrinkBuy = new JTextField("0");
	txtDrinkBuy.setBounds(250, 400, 70, 20);
	add(txtDrinkBuy);
	txtDrinkBuy.setColumns(10);

	txtCageBuy = new JTextField("0");
	txtCageBuy.setBounds(250, 430, 70, 20);
	add(txtCageBuy);
	txtCageBuy.setColumns(10);

	JButton btnBack = new JButton("Back to Town");
	btnBack.setBounds(560, 510, 120, 23);
	add(btnBack);
	btnBack.addActionListener(new ActionListener() {
	    public void actionPerformed(ActionEvent e) {
		setVisible(false);
	    }
	});

	lblSellStatus = new JLabel("");
	lblSellStatus.setBounds(70, 185, 500, 20);
	add(lblSellStatus);

	lblBuyStatus = new JLabel("");
	lblBuyStatus.setBounds(70, 505, 500, 20);
	add(lblBuyStatus);
    }

    /**
     * <<<<<<< HEAD gets the information from the player regarding his available
     * resources. ======= Populates jlabel with store's available stuff >>>>>>>
     * 4d3a36d2d205e3a0d8a81b32db2b8bd3089c7bfa
     */
    public void runStore() {
	int storeFood = storeModel.getFoodAvailable();
	int storeDrinks = storeModel.getDrinksAvailable();
	int storeCage = storeModel.getCageAvailable();
	int playerFood = model.getPlayer(model.getCurPlayer()).getFood();
	int playerDrinks = model.getPlayer(model.getCurPlayer()).getDrink();
	int playerCage = model.getPlayer(model.getCurPlayer()).getNicolasCage();
	int playerMoney = model.getPlayer(model.getCurPlayer()).getMoney();
	foodAvailable.setText(storeFood + "");
	drinkAvailable.setText(storeDrinks + "");
	cageAvailable.setText(storeCage + "");
    }

}
