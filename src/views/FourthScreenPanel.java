package views;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Graphics;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.util.ArrayList;

import javax.swing.BorderFactory;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.Timer;

import models.Land;
import models.PlayerConfigModel;
import models.PlayerModel;
import enums.Constants;

/**
 * This class configures a map which allows user to select the land and
 * start the game and work on it.
 * 
 * @author Tanay
 * 
 */

public class FourthScreenPanel extends JPanel {

	private JFrame frame;
	public JButton[][] buttonArray = new JButton[5][9];
	public String[][] landArr = new String[5][9];
	public Land[][] LandObjects = new Land[5][9];
	private PlayerConfigModel model;
	public int ctr;
	public JButton clickedButton;
	public JButton next;
	public JButton passButton;
	public JLabel PlayerNumLabel;
	private JLabel timerLbl;
	int curPlayer;
	boolean landPicked = false;
	public TownPanel townPanel;
	//public MulePlacementPanel mulePlacementPanel;
	private Timer roundTimer;

	/**
	 * Constructor to Create the application.
	 */
	public FourthScreenPanel(PlayerConfigModel model) {
		ctr = 0;
		this.model = model;
		this.townPanel = new TownPanel(model);
		this.townPanel.addListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				gotoMap();
			}
		});
	

		initialize();
	}

	/**
	 * It returns the player number who is playing at that moment.
	 * 
	 * @return current player number
	 */
	public int getCtr() {
		return ctr;
		
	}
	

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		this.removeAll();

		clickedButton = new JButton();
		model.addCallback(this);
		next = new JButton();
		this.model.calcPlayerOrder();
		next.setBounds(450, 450, 70, 70);
		add(next);
		passButton = new JButton();
		passButton.setBounds(300, 450, 70, 70);
		passButton.setText("Pass");
		PlayerNumLabel = new JLabel();
		PlayerNumLabel.setBounds(10, 300, 300, 300);
		add(PlayerNumLabel);
		PlayerNumLabel.setText("<html> Player "+ model.getCurPlayer()+"'s" + " turn " + "<br>" + "Player Resources:" + "<br>" + "money: " + model.getPlayer(model.getCurPlayer()).getMoney()
				+ "<br>" + "Food: " + model.getPlayer(model.getCurPlayer()).getFood() + "<br>" + "Drink: " + model.getPlayer(model.getCurPlayer()).getDrink()
				+ "<br>" + "Nicolas Cage: " + model.getPlayer(model.getCurPlayer()).getNicolasCage() + "</html>");

		curPlayer = model.getCurPlayer();
		add(passButton);
		initTimer();

		setBounds(100, 100, 850, 550);
		setLayout(null);
		setBounds(56, 74, 720, 400);
		landArr[0][0] = "P";
		landArr[0][1] = "P";
		landArr[0][2] = "M";
		landArr[0][3] = "P";
		landArr[0][4] = "R";
		landArr[0][5] = "M";
		landArr[0][6] = "P";
		landArr[0][7] = "P";
		landArr[0][8] = "P";
		landArr[1][0] = "M";
		landArr[1][1] = "M";
		landArr[1][2] = "M";
		landArr[1][3] = "P";
		landArr[1][4] = "R";
		landArr[1][5] = "M";
		landArr[1][6] = "P";
		landArr[1][7] = "P";
		landArr[1][8] = "M";
		landArr[2][0] = "P";
		landArr[2][1] = "M";
		landArr[2][2] = "P";
		landArr[2][3] = "P";
		landArr[2][4] = "R";
		landArr[2][5] = "P";
		landArr[2][6] = "P";
		landArr[2][7] = "M";
		landArr[2][8] = "P";
		landArr[3][0] = "P";
		landArr[3][1] = "P";
		landArr[3][2] = "M";
		landArr[3][3] = "P";
		landArr[3][4] = "R";
		landArr[3][5] = "P";
		landArr[3][6] = "P";
		landArr[3][7] = "M";
		landArr[3][8] = "P";
		landArr[4][0] = "P";
		landArr[4][1] = "P";
		landArr[4][2] = "M";
		landArr[4][3] = "P";
		landArr[4][4] = "R";
		landArr[4][5] = "P";
		landArr[4][6] = "M";
		landArr[4][7] = "P";
		landArr[4][8] = "P";
		passButton.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				// ctr++;
				model.nextPlayer();
				model.setTimer(0);
				ctr++;

			}
		});

		int n = 0;
		for (int i = 0; i < 5; i++) {
			for (int j = 0; j < 9; j++) {
				final JButton button = new JButton("");
				button.setIcon(new ImageIcon("src/temp/images/map1_" + (n + 1)
						+ ".gif"));
				n++;
				button.setBounds(80 * j, 80 * i, 80, 80);
				button.setName(landArr[i][j]);
				boolean currentlyOwned = false;

				// Check if currently owned
				for (int player = 0; player < model.getNumPlayers(); player++) {
					ArrayList<Land> ownedByPlayer = model.getPlayer(player)
							.getLandsOwner();
					for (Land myLand : ownedByPlayer) {
						if (myLand.x == i && myLand.y == j) {
							button.setBorder(BorderFactory
									.createLineBorder(model.getPlayer(player)
											.getColor()));
							button.setEnabled(false);
							currentlyOwned = true;
						}
					}
				}

				if (!(i == 2 && j == 4)) {
					final int my_i = i;
					final int my_j = j;
					if (!currentlyOwned) {
						button.addMouseListener(new MouseAdapter() {
							@Override
							public void mouseClicked(MouseEvent arg0) {
								if (!landPicked) {
									// TODO add round check if <2
									// JERRY ADDED
									if (model.getRound() > 2) {
										int amt = 0;
										if (landArr[my_i][my_j].equals("M"))
											amt = 20;
										else if (landArr[my_i][my_j]
												.equals("R"))
											amt = 50;
										else
											amt = 40;

										PlayerModel curr = model
												.getPlayer(curPlayer);
										curr.setMoney(curr.getMoney() - amt);
									}
									Color playersColor = model.getPlayer(
											curPlayer).getColor();
									model.getPlayer(curPlayer).addLand(
											new Land(landArr[my_i][my_j], my_i,
													my_j));
									button.setBorder(BorderFactory
											.createLineBorder(playersColor));
									button.setVisible(true);
									landPicked = true;
									repaint();
								}
							}
						});
					}

				}
				buttonArray[i][j] = button;
				add(button);
			}
		} // end of FOR

		buttonArray[2][4].addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent arg0) {
				gotoTown();
			}

		});

		this.invalidate();
		this.repaint();

	}
	
	/**
	 * Initializes the timer for the player
	 * 
	 */
	private void initTimer() {
		int delay = Constants.DELAY;
		int timer = model.getTimer();
		model.setTimer(timer);
		if (timer != -1) {
			roundTimer = new Timer(delay, taskPerformer);
			roundTimer.start();
		}
		displayTimer();

	}

	ActionListener taskPerformer = new ActionListener() {
		public void actionPerformed(ActionEvent evt) {
			model.updateTimer();
		}
	};

	/**
	 * displays the count-down timer as a panel
	 */
	private void displayTimer() {
		timerLbl = new JLabel("");
		timerLbl.setBounds(680, 450, 301, 14);
		add(timerLbl, BorderLayout.SOUTH);
	}

	/**
	 * repaints the mapScreen with the Town whenever the player clicks on the town
	 * Button.
	 */
	public void gotoTown() {
		this.removeAll();
		this.setLayout(new java.awt.BorderLayout());
		
		this.add(townPanel, BorderLayout.CENTER);
		displayTimer();
		this.revalidate();
		this.repaint();
		// this.landPicked = false;
	}

	/**
	 * callback when model updates the cur player
	 * @param a string
	 */
	public void callback(String string) {
		if (string.equals("ROUND_END")) {
			roundTimer.stop();
			JOptionPane.showMessageDialog(this, "Player " + curPlayer
					+ "'s turn is over.");
			String dispMsg = "END OF ROUND " + model.getRound();
			int[] moneys = new int[4];
			int[] foods = new int[4];
			int[] scores = new int[4];
			for (int i = 0; i < model.getNumPlayers(); i++) {
				PlayerModel curPlayer = model.getPlayer(i);
				dispMsg += "\nPlayer " + i + "\nMoney: " + curPlayer.getMoney() + "\nDrink: " + curPlayer.getDrink()+ "\nFood: " + curPlayer.getFood()+ "\nNicolasCage: " + curPlayer.getNicolasCage()
						+ "\nTotal Score: " + curPlayer.getTotal() + "\n";
			}
			JOptionPane.showMessageDialog(this, dispMsg);
			this.curPlayer = model.getCurPlayer();
			this.landPicked = false;
			this.displayTimer();
			this.gotoMap();
		} else if (string.equals("TURN_END")) {
			roundTimer.stop();
			JOptionPane.showMessageDialog(this, "Player " + curPlayer
					+ "'s turn is over.");
			this.curPlayer = model.getCurPlayer();
			this.landPicked = false;
			this.displayTimer();
			this.gotoMap();

		}
		
		townPanel.resetView();
	}
	@Override
	public void paint(Graphics g) {
		super.paint(g);
		int timer = model.getTimer();
		timerLbl.setText(Integer.toString(timer));
		timerLbl.repaint();
	}

	/**
	 * Add an action listener for the Next button.
	 * 
	 * @param l
	 */
	public void addActionListener(ActionListener l) {
		next.addActionListener(l);
	}

	
	/**
	 * refreshes and repaints the screen with the map screen for the player's turn.
	 */
	public void gotoMap() {
		// TODO Auto-generated method stub
		this.removeAll();

		clickedButton = new JButton();
		model.addCallback(this);
		next = new JButton();
		next.setBounds(450, 450, 70, 70);
		add(next);
		passButton = new JButton();
		passButton.setBounds(300, 450, 70, 70);
		passButton.setText("Pass");
		add(PlayerNumLabel);
		PlayerNumLabel.setText("<html> Player "+ model.getCurPlayer()+"'s" + " turn " + "<br>" + "Player Resources:" + "<br>" + "money: " + model.getPlayer(model.getCurPlayer()).getMoney()
				+ "<br>" + "Food: " + model.getPlayer(model.getCurPlayer()).getFood() + "<br>" + "Drink: " + model.getPlayer(model.getCurPlayer()).getDrink()
				+ "<br>" + "Nicolas Cage: " + model.getPlayer(model.getCurPlayer()).getNicolasCage() + "</html>");

		
		
		curPlayer = model.getCurPlayer();
		add(passButton);
		// initTimer();
		displayTimer();

		setBounds(100, 100, 850, 550);
		setLayout(null);
		setBounds(56, 74, 720, 400);
		landArr[0][0] = "P";
		landArr[0][1] = "P";
		landArr[0][2] = "M";
		landArr[0][3] = "P";
		landArr[0][4] = "R";
		landArr[0][5] = "M";
		landArr[0][6] = "P";
		landArr[0][7] = "P";
		landArr[0][8] = "P";
		landArr[1][0] = "M";
		landArr[1][1] = "M";
		landArr[1][2] = "M";
		landArr[1][3] = "P";
		landArr[1][4] = "R";
		landArr[1][5] = "M";
		landArr[1][6] = "P";
		landArr[1][7] = "P";
		landArr[1][8] = "M";
		landArr[2][0] = "P";
		landArr[2][1] = "M";
		landArr[2][2] = "P";
		landArr[2][3] = "P";
		landArr[2][4] = "R";
		landArr[2][5] = "P";
		landArr[2][6] = "P";
		landArr[2][7] = "M";
		landArr[2][8] = "P";
		landArr[3][0] = "P";
		landArr[3][1] = "P";
		landArr[3][2] = "M";
		landArr[3][3] = "P";
		landArr[3][4] = "R";
		landArr[3][5] = "P";
		landArr[3][6] = "P";
		landArr[3][7] = "M";
		landArr[3][8] = "P";
		landArr[4][0] = "P";
		landArr[4][1] = "P";
		landArr[4][2] = "M";
		landArr[4][3] = "P";
		landArr[4][4] = "R";
		landArr[4][5] = "P";
		landArr[4][6] = "M";
		landArr[4][7] = "P";
		landArr[4][8] = "P";
		passButton.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				model.setTimer(0);
				ctr++;

			}
		});

		int n = 0;
		for (int i = 0; i < 5; i++) {
			for (int j = 0; j < 9; j++) {
				final JButton button = new JButton("");
				button.setIcon(new ImageIcon("src/temp/images/map1_" + (n + 1)
						+ ".gif"));
				n++;
				button.setBounds(80 * j, 80 * i, 80, 80);
				button.setName(landArr[i][j]);
				boolean currentlyOwned = false;

				// Check if currently owned
				for (int player = 0; player < model.getNumPlayers(); player++) {
					ArrayList<Land> ownedByPlayer = model.getPlayer(player)
							.getLandsOwner();
					for (Land myLand : ownedByPlayer) {
						if (myLand.x == i && myLand.y == j) {
							button.setBorder(BorderFactory
									.createLineBorder(model.getPlayer(player)
											.getColor()));
							button.setEnabled(false);
							if (myLand.getMule() == 1 || myLand.getMule() == 2 || myLand.getMule() == 3) {
								button.setIcon(new ImageIcon("src/temp/muled.jpg"));
								repaint();
							}
							currentlyOwned = true;
						}
					}
				}

				if (!(i == 2 && j == 4)) {
					final int my_i = i;
					final int my_j = j;
					if (!currentlyOwned) {
						button.addMouseListener(new MouseAdapter() {
							@Override
							public void mouseClicked(MouseEvent arg0) {
								if (!landPicked) {
									if (model.getRound() > 2) {
										int amt = 0;
										if (landArr[my_i][my_j].equals("M"))
											amt = 20;
										else if (landArr[my_i][my_j]
												.equals("R"))
											amt = 50;
										else
											amt = 40;

										PlayerModel curr = model
												.getPlayer(curPlayer);
										curr.setMoney(curr.getMoney() - amt);
									}
									// TODO add round check if <2
									Color playersColor = model.getPlayer(
											curPlayer).getColor();
									model.getPlayer(curPlayer).addLand(
											new Land(landArr[my_i][my_j], my_i,
													my_j));
									button.setBorder(BorderFactory
											.createLineBorder(playersColor));
									button.setVisible(true);
									landPicked = true;
									repaint();
								}
							}
						});
					}

				}
				buttonArray[i][j] = button;
				add(button);
			}
		} // end of FOR

		buttonArray[2][4].addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent arg0) {
				gotoTown();
			}

		});
		this.revalidate();
		this.repaint();

		if (!roundTimer.isRunning()) {
			roundTimer.start();
		}

	}
}
