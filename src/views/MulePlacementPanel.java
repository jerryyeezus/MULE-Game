package views;

import java.awt.Color;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.util.ArrayList;

import javax.swing.BorderFactory;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;

import models.Land;
import models.PlayerConfigModel;

public class MulePlacementPanel extends JPanel {
	private int muleType;

	private PlayerConfigModel model;
	private JPanel townPanel;
	private JButton[][] buttons = new JButton[5][9];
	private int curPlayer;
	private String[][] landArr = new String[5][9];

	public MulePlacementPanel(PlayerConfigModel model, JPanel townPanel) {
		this.model = model;
		this.townPanel = townPanel;
		System.out.println();

	}

	public void doMuleSelection(int muleType) {
		this.muleType = muleType;

		// TODO Auto-generated method stub
		this.removeAll();

		curPlayer = model.getCurPlayer();

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
				buttons[i][j] = button;
				
				// Check if currently owned
				for (int player = 0; player < model.getNumPlayers(); player++) {
					ArrayList<Land> ownedByPlayer = model.getPlayer(player)
							.getLandsOwner();
					for (Land myLand : ownedByPlayer){
						if (myLand.x == i && myLand.y == j) {
							button.setBorder(BorderFactory
									.createLineBorder(model.getPlayer(player)
											.getColor()));
							if (myLand.getMule() == 1) {
								button.setIcon(new ImageIcon("src/temp/muled.jpg"));
								repaint();
							}
							if (myLand.getMule() == 2) {
								button.setIcon(new ImageIcon("src/temp/muled.jpg"));
								repaint();
							}
							if (myLand.getMule() == 3) {
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
					final int muleType1 = this.muleType;
					button.setEnabled(true);
					if (true) {
						button.addMouseListener(new MouseAdapter() {
							@Override
							public void mouseClicked(MouseEvent arg0) {
									
									int player = model.getCurPlayer();
									ArrayList<Land> ownedByPlayer = model.getPlayer(player)
											.getLandsOwner();
									boolean isValid = false;
									for (Land myLand : ownedByPlayer) {
										if (myLand.x == my_i && myLand.y == my_j) {
											isValid = true;
											myLand.setOwner(player);
											myLand.setMule(muleType1);
											setVisible(false);
											((TownPanel)townPanel).clickTheLandButton();
											
											break;
										}
									}
									
									if (!isValid) {
										System.out.println("Mule lost lol owned");
										((TownPanel)townPanel).clickTheLandButton();
										setVisible(false);
										//((TownPanel)townPanel).setInvisible();
									}
									
									
									
							}
						});
					}

				}
				JLabel selectionLabel = new JLabel(" Player : " + model.getCurPlayer() + " ; Please select land to place the mule");
				//selectionPanel.setBackground(model.getPlayer(model.getCurPlayer()).getColor());
				selectionLabel.setBackground(Color.BLUE);
				selectionLabel.setBounds(200, 450, 400, 40);
				selectionLabel.setBorder(BorderFactory.createLineBorder(model.getPlayer(model.getCurPlayer()).getColor(), 5, true));
				//foodLabel.setSize(50,10);
				add(selectionLabel);
				add(button);
			}
		} // end of FOR
		
		this.revalidate();
		this.repaint();

	}

	

}
