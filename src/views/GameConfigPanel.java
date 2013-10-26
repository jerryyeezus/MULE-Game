package views;

import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JSeparator;
import javax.swing.JSlider;
import javax.swing.JSpinner;
import javax.swing.SwingConstants;

public class GameConfigPanel extends JPanel {
	JLabel lblNewLabel;
	JSpinner spinner;
	private JButton btnNewButton;
	private JSlider slider;
	JSpinner spinner_1;

	/**
	 * Add the passed listener to the next button
	 * 
	 * @param l
	 *            listener
	 */
	public void addActionListener(ActionListener l) {
		btnNewButton.addActionListener(l);
	}

	/**
	 * @return
	 */
	public int getMapType() {
		return (Integer) spinner_1.getValue(); // WHICH
	}

	/**
	 * @return the current value of difficulty slider
	 */
	public int getDifficultyValue() {
		return (Integer) this.slider.getValue();
	}

	/**
	 * @return current value of num players spinner
	 */
	public int getNumPlayers() {

		return (Integer) this.spinner.getValue();
	}

	/**
	 * init panel components
	 */
	public GameConfigPanel() {
		this.setLayout(null);
		JLabel lblNewLabel = new JLabel("M.U.L.E.");
		lblNewLabel.setFont(new Font("Times New Roman", Font.BOLD, 28));
		lblNewLabel.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel.setBounds(147, 11, 256, 76);
		add(lblNewLabel);

		JLabel lblNewLabel_1 = new JLabel("Select Difficulty Level:");
		lblNewLabel_1.setBounds(10, 98, 142, 14);
		add(lblNewLabel_1);

		JLabel lblSelectMapType = new JLabel("Select Map type:");
		lblSelectMapType.setBounds(10, 137, 123, 14);
		add(lblSelectMapType);

		JLabel lblSelectNoOf = new JLabel("Select no. of players:");
		lblSelectNoOf.setBounds(10, 175, 123, 14);
		add(lblSelectNoOf);
		spinner = new JSpinner();
		spinner.setBounds(208, 173, 43, 17);
		add(spinner);
		btnNewButton = new JButton("Next >>");
		btnNewButton.setBounds(158, 201, 89, 23);
		add(btnNewButton);

		JButton btnExit = new JButton("Exit");
		btnExit.setBounds(257, 201, 89, 23);
		this.add(btnExit);

		JButton btnClear = new JButton("Clear");
		btnClear.setBounds(59, 200, 89, 23);
		this.add(btnClear);
		slider = new JSlider();
		slider.setValue(0);
		slider.setMaximum(2);
		slider.setBounds(162, 92, 150, 20);
		this.add(slider);

		JLabel lblNewLabel_2 = new JLabel("Beginner");
		lblNewLabel_2.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel_2.setBounds(129, 112, 200, 14);
		this.add(lblNewLabel_2);

		JLabel lblshyamakAggarwalTanay = new JLabel(
				" \u00A9 Shyamak Aggarwal, Tanay Ponkshe, Nikhil Karajgikar, Jerry \"Yeezys\" Yee & Ishaan Grover ");
		lblshyamakAggarwalTanay.setFont(new Font("Times New Roman", Font.PLAIN,
				10));
		lblshyamakAggarwalTanay.setBounds(10, 238, 407, 14);
		this.add(lblshyamakAggarwalTanay);

		JSeparator separator = new JSeparator();
		separator.setBounds(10, 235, 393, 2);
		this.add(separator);

		JLabel lblNewLabel_3 = new JLabel("");
		lblNewLabel_3.setIcon(new ImageIcon(
				"C:\\Users\\Tanay\\workspace\\MuleGame\\src\\mule_mini.jpg"));
		lblNewLabel_3.setBounds(60, 11, 77, 76);
		this.add(lblNewLabel_3);

		spinner_1 = new JSpinner();
		spinner.setValue(2);
		spinner_1.setBounds(208, 134, 43, 20);
		this.add(spinner_1);

		btnExit.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				System.exit(0);
			}
		});
	}

}
