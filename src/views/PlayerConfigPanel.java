package views;

import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.DefaultComboBoxModel;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JSlider;
import javax.swing.JSpinner;
import javax.swing.JTextField;
import javax.swing.SwingConstants;

/**
 * @author yee Initializes the config screen components, getters and setters for
 *         these JPanel values
 */
public class PlayerConfigPanel extends JPanel {
	JLabel lblNewLabel;
	JButton btnNext;
	private JSlider slider;

	// Name fields
	private JTextField textField;
	private JTextField textField_1;
	private JTextField textField_2;
	private JTextField textField_3;

	// race
	JComboBox comboBox;
	JComboBox comboBox_1;
	JComboBox comboBox_2;
	JComboBox comboBox_3;
	JComboBox comboBox_4;
	JComboBox comboBox_5;
	JComboBox comboBox_6;
	JComboBox comboBox_7;
	JComboBox comboBox_8;

	/**
	 * set actionlist for next button
	 * 
	 * @param l
	 */
	public void addActionListener(ActionListener l) {
		btnNext.addActionListener(l);
	}

	/**
	 * @return difficulty slider's value
	 */
	public int getDifficultyValue() {
		return (Integer) this.slider.getValue();
	}

	public String[] getRaces() {
		String[] ret = new String[4];
		ret[0] = (String) (comboBox.getSelectedItem());
		ret[1] = (String) (comboBox_2.getSelectedItem());
		ret[2] = (String) (comboBox_4.getSelectedItem());
		ret[3] = (String) (comboBox_6.getSelectedItem());
		return ret;
	}

	public String[] getColors() {
		String[] ret = new String[4];
		ret[0] = (String) (comboBox_1.getSelectedItem());
		ret[1] = (String) (comboBox_3.getSelectedItem());
		ret[2] = (String) (comboBox_5.getSelectedItem());
		ret[3] = (String) (comboBox_7.getSelectedItem());
		return ret;
	}

	private int numPlayers;

	/**
	 * @return an 4 length array containing name values (null if none set)
	 */
	public String[] getNames() {
		String[] ret = new String[4];
		ret[0] = textField.getText();
		ret[1] = textField_1.getText();
		ret[2] = textField_2.getText();
		ret[3] = textField_3.getText();
		return ret;
	}

	/**
	 * initialize jpanel components for playerconfig
	 * 
	 * @param numPlayers
	 */
	public PlayerConfigPanel(int numPlayers) {

		this.numPlayers = numPlayers;
		this.setBackground(new Color(255, 239, 213));
		setBounds(100, 100, 850, 549);
		this.setLayout(null);

		JLabel lblMule = new JLabel("");
		lblMule.setIcon(new ImageIcon(
				"C:\\Users\\Tanay\\workspace\\MuleGame\\src\\mule_mini.jpg"));
		lblMule.setFont(new Font("Times New Roman", Font.BOLD, 19));
		lblMule.setHorizontalAlignment(SwingConstants.LEFT);
		lblMule.setBounds(60, 11, 77, 76);
		this.add(lblMule);

		JLabel lblMule_1 = new JLabel("M.U.L.E.");
		lblMule_1.setBackground(new Color(0, 204, 153));
		lblMule_1.setForeground(new Color(255, 0, 204));
		lblMule_1.setHorizontalAlignment(SwingConstants.CENTER);
		lblMule_1.setFont(new Font("Times New Roman", Font.BOLD, 35));
		lblMule_1.setBounds(268, 11, 256, 76);
		this.add(lblMule_1);

		JPanel panel = new JPanel();
		panel.setBounds(10, 105, 398, 135);
		this.add(panel);
		panel.setLayout(null);

		JLabel lblSelectPlayerName = new JLabel("Select Player Name:");
		lblSelectPlayerName.setBounds(10, 11, 104, 16);
		panel.add(lblSelectPlayerName);
		lblSelectPlayerName
				.setFont(new Font("Times New Roman", Font.PLAIN, 13));

		textField = new JTextField();
		textField.setBounds(163, 9, 130, 20);
		panel.add(textField);
		textField.setFont(new Font("Times New Roman", Font.PLAIN, 13));
		textField.setColumns(10);

		JLabel lblMaxCharacters = new JLabel("(Max. 25 characters)");
		lblMaxCharacters.setBounds(296, 12, 101, 14);
		panel.add(lblMaxCharacters);
		lblMaxCharacters.setFont(new Font("Times New Roman", Font.PLAIN, 11));

		JLabel lblSelectPlayerRace = new JLabel("Select Player Race:");
		lblSelectPlayerRace.setBounds(10, 46, 121, 14);
		panel.add(lblSelectPlayerRace);
		lblSelectPlayerRace
				.setFont(new Font("Times New Roman", Font.PLAIN, 13));

		comboBox = new JComboBox();
		comboBox.setBounds(163, 40, 130, 20);
		panel.add(comboBox);
		comboBox.setFont(new Font("Times New Roman", Font.PLAIN, 13));
		comboBox.setModel(new DefaultComboBoxModel(new String[] { "Humanoid",
				"Ponkshe", "Lall", "Flapper" }));

		JLabel lblSelectPlayerColor = new JLabel("Select Player Color:");
		lblSelectPlayerColor.setBounds(10, 82, 121, 14);
		panel.add(lblSelectPlayerColor);
		lblSelectPlayerColor
				.setFont(new Font("Times New Roman", Font.PLAIN, 13));
		comboBox_1 = new JComboBox();
		comboBox_1.setBounds(163, 79, 130, 20);
		panel.add(comboBox_1);
		comboBox_1.setModel(new DefaultComboBoxModel(new String[] { "Red",
				"Blue", "Green", "Black" }));
		comboBox_1.setSelectedIndex(1);
		comboBox_1.setFont(new Font("Times New Roman", Font.PLAIN, 13));

		JLabel lblNoOfResources = new JLabel("Amount available at start:");
		lblNoOfResources.setBounds(10, 110, 137, 14);
		panel.add(lblNoOfResources);
		lblNoOfResources.setFont(new Font("Times New Roman", Font.PLAIN, 13));

		final JLabel lblNewLabel = new JLabel("600");
		lblNewLabel.setBounds(163, 110, 130, 14);
		panel.add(lblNewLabel);
		lblNewLabel.setFont(new Font("Times New Roman", Font.PLAIN, 13));
		lblNewLabel.setHorizontalAlignment(SwingConstants.CENTER);

		JPanel panel_1 = new JPanel();
		panel_1.setBounds(96, 397, 457, 46);
		this.add(panel_1);
		panel_1.setLayout(null);

		JButton btnClear = new JButton("<< Back");
		btnClear.setBounds(58, 11, 93, 25);
		panel_1.add(btnClear);
		btnClear.setFont(new Font("Times New Roman", Font.PLAIN, 13));

		JButton btnClear_1 = new JButton("Clear");
		btnClear_1.setBounds(161, 12, 83, 23);
		panel_1.add(btnClear_1);
		btnNext = new JButton("Next >>");
		btnNext.setBounds(254, 12, 77, 23);
		panel_1.add(btnNext);

		JButton btnExit = new JButton("Exit");
		btnExit.setBounds(341, 12, 84, 23);
		panel_1.add(btnExit);

		JPanel panel_2 = new JPanel();
		panel_2.setBounds(10, 454, 806, 48);
		this.add(panel_2);
		panel_2.setLayout(null);

		JLabel lblNewLabel_1 = new JLabel(
				" \u00A9 Shyamak Aggarwal, Tanay Ponkshe, Nikhil Karajgikar, Jerry Yee & Ishaan Grover ");
		lblNewLabel_1.setBounds(10, 23, 407, 14);
		panel_2.add(lblNewLabel_1);
		lblNewLabel_1.setFont(new Font("Times New Roman", Font.PLAIN, 10));

		JPanel panel_3 = new JPanel();
		panel_3.setLayout(null);
		panel_3.setBounds(418, 105, 398, 135);
		this.add(panel_3);

		JLabel label = new JLabel("Select Player Name:");
		label.setFont(new Font("Times New Roman", Font.PLAIN, 13));
		label.setBounds(10, 11, 104, 16);
		panel_3.add(label);

		textField_1 = new JTextField();
		textField_1.setFont(new Font("Times New Roman", Font.PLAIN, 13));
		textField_1.setColumns(10);
		textField_1.setBounds(163, 9, 130, 20);
		panel_3.add(textField_1);

		JLabel label_1 = new JLabel("(Max. 25 characters)");
		label_1.setFont(new Font("Times New Roman", Font.PLAIN, 11));
		label_1.setBounds(296, 12, 101, 14);
		panel_3.add(label_1);

		JLabel label_2 = new JLabel("Select Player Race:");
		label_2.setFont(new Font("Times New Roman", Font.PLAIN, 13));
		label_2.setBounds(10, 46, 121, 14);
		panel_3.add(label_2);

		comboBox_2 = new JComboBox();
		comboBox_2.setModel(new DefaultComboBoxModel(new String[] { "Humanoid",
				"Ponkshe", "Lall", "Flapper" }));
		comboBox_2.setFont(new Font("Times New Roman", Font.PLAIN, 13));
		comboBox_2.setBounds(163, 40, 130, 20);
		panel_3.add(comboBox_2);

		JLabel label_3 = new JLabel("Select Player Color:");
		label_3.setFont(new Font("Times New Roman", Font.PLAIN, 13));
		label_3.setBounds(10, 82, 121, 14);
		panel_3.add(label_3);
		comboBox_3 = new JComboBox();
		comboBox_3.setModel(new DefaultComboBoxModel(new String[] { "Red",
				"Blue", "Green", "Black" }));
		comboBox_3.setFont(new Font("Times New Roman", Font.PLAIN, 13));
		comboBox_3.setBounds(163, 79, 130, 20);
		panel_3.add(comboBox_3);

		JLabel label_4 = new JLabel("Amount available at start:");
		label_4.setFont(new Font("Times New Roman", Font.PLAIN, 13));
		label_4.setBounds(10, 110, 137, 14);
		panel_3.add(label_4);

		JLabel label_5 = new JLabel("600");
		label_5.setHorizontalAlignment(SwingConstants.CENTER);
		label_5.setFont(new Font("Times New Roman", Font.PLAIN, 13));
		label_5.setBounds(163, 110, 130, 14);
		panel_3.add(label_5);

		JPanel panel_4 = new JPanel();
		panel_4.setLayout(null);
		panel_4.setBounds(10, 251, 398, 135);
		this.add(panel_4);

		comboBox_3.setSelectedIndex(2);
		JLabel label_6 = new JLabel("Select Player Name:");
		label_6.setFont(new Font("Times New Roman", Font.PLAIN, 13));
		label_6.setBounds(10, 11, 104, 16);
		panel_4.add(label_6);

		textField_2 = new JTextField();
		textField_2.setFont(new Font("Times New Roman", Font.PLAIN, 13));
		textField_2.setColumns(10);
		textField_2.setBounds(163, 9, 130, 20);
		panel_4.add(textField_2);

		JLabel label_7 = new JLabel("(Max. 25 characters)");
		label_7.setFont(new Font("Times New Roman", Font.PLAIN, 11));
		label_7.setBounds(296, 12, 101, 14);
		panel_4.add(label_7);

		JLabel label_8 = new JLabel("Select Player Race:");
		label_8.setFont(new Font("Times New Roman", Font.PLAIN, 13));
		label_8.setBounds(10, 46, 121, 14);

		panel_4.add(label_8);
		comboBox_4 = new JComboBox();
		comboBox_4.setModel(new DefaultComboBoxModel(new String[] { "Humanoid",
				"Ponkshe", "Lall", "Flapper" }));
		comboBox_4.setFont(new Font("Times New Roman", Font.PLAIN, 13));
		comboBox_4.setBounds(163, 40, 130, 20);
		panel_4.add(comboBox_4);

		comboBox_4.setSelectedIndex(3);
		JLabel label_9 = new JLabel("Select Player Color:");
		label_9.setFont(new Font("Times New Roman", Font.PLAIN, 13));
		label_9.setBounds(10, 82, 121, 14);
		panel_4.add(label_9);
		comboBox_5 = new JComboBox();
		comboBox_5.setModel(new DefaultComboBoxModel(new String[] { "Red",
				"Blue", "Green", "Black" }));
		comboBox_5.setFont(new Font("Times New Roman", Font.PLAIN, 13));
		comboBox_5.setBounds(163, 79, 130, 20);
		panel_4.add(comboBox_5);

		JLabel label_10 = new JLabel("Amount available at start:");
		label_10.setFont(new Font("Times New Roman", Font.PLAIN, 13));
		label_10.setBounds(10, 110, 137, 14);
		panel_4.add(label_10);

		JLabel label_11 = new JLabel("600");
		label_11.setHorizontalAlignment(SwingConstants.CENTER);
		label_11.setFont(new Font("Times New Roman", Font.PLAIN, 13));
		label_11.setBounds(163, 110, 130, 14);
		panel_4.add(label_11);

		JPanel panel_5 = new JPanel();
		panel_5.setLayout(null);
		panel_5.setBounds(418, 251, 398, 135);
		add(panel_5);

		JLabel label_12 = new JLabel("Select Player Name:");
		label_12.setFont(new Font("Times New Roman", Font.PLAIN, 13));
		label_12.setBounds(10, 11, 104, 16);
		panel_5.add(label_12);

		textField_3 = new JTextField();
		textField_3.setFont(new Font("Times New Roman", Font.PLAIN, 13));
		textField_3.setColumns(10);
		textField_3.setBounds(163, 9, 130, 20);
		panel_5.add(textField_3);

		JLabel label_13 = new JLabel("(Max. 25 characters)");
		label_13.setFont(new Font("Times New Roman", Font.PLAIN, 11));
		label_13.setBounds(296, 12, 101, 14);
		panel_5.add(label_13);

		JLabel label_14 = new JLabel("Select Player Race:");
		label_14.setFont(new Font("Times New Roman", Font.PLAIN, 13));
		label_14.setBounds(10, 46, 121, 14);
		panel_5.add(label_14);

		comboBox_6 = new JComboBox();
		comboBox_6.setModel(new DefaultComboBoxModel(new String[] { "Humanoid",
				"Ponkshe", "Lall", "Flapper" }));
		comboBox_6.setFont(new Font("Times New Roman", Font.PLAIN, 13));
		comboBox_6.setBounds(163, 40, 130, 20);
		panel_5.add(comboBox_6);

		JLabel label_15 = new JLabel("Select Player Color:");
		label_15.setFont(new Font("Times New Roman", Font.PLAIN, 13));
		label_15.setBounds(10, 82, 121, 14);
		panel_5.add(label_15);

		comboBox_7 = new JComboBox();
		comboBox_7.setModel(new DefaultComboBoxModel(new String[] { "Red",
				"Blue", "Green", "Black" }));
		comboBox_7.setFont(new Font("Times New Roman", Font.PLAIN, 13));
		comboBox_7.setBounds(163, 79, 130, 20);
		panel_5.add(comboBox_7);

		JLabel label_16 = new JLabel("Amount available at start:");
		label_16.setFont(new Font("Times New Roman", Font.PLAIN, 13));
		label_16.setBounds(10, 110, 137, 14);
		panel_5.add(label_16);

		JLabel label_17 = new JLabel("600");
		/*
		 * this.setLayout( null ); JLabel lblNewLabel = new JLabel( "my" );
		 * lblNewLabel.setFont( new Font( "Times New Roman", Font.BOLD, 28 ) );
		 * lblNewLabel.setHorizontalAlignment( SwingConstants.CENTER );
		 * lblNewLabel.setBounds( 147, 11, 256, 76 ); add( lblNewLabel );
		 */
		label_17.setHorizontalAlignment(SwingConstants.CENTER);
		label_17.setFont(new Font("Times New Roman", Font.PLAIN, 13));
		label_17.setBounds(163, 110, 130, 14);
		panel_5.add(label_17);
		btnExit.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				System.exit(0);
			}
		});

		comboBox_6.setSelectedIndex(2);
		comboBox_7.setSelectedIndex(3);
		btnClear_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				textField.setText("");
				textField_1.setText("");
				textField_2.setText("");
				textField_3.setText("");
				comboBox.setSelectedIndex(0);
				comboBox_1.setSelectedIndex(0);
				comboBox_2.setSelectedIndex(0);
				comboBox_3.setSelectedIndex(0);
				comboBox_4.setSelectedIndex(0);
				comboBox_5.setSelectedIndex(0);
				comboBox_6.setSelectedIndex(0);
				comboBox_7.setSelectedIndex(0);
				lblNewLabel.setText("600");
			}
		});
		btnClear.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
			}
		});
	}
}
