package views;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JSeparator;
import javax.swing.JLabel;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.JTextField;

public class gui {

	private JFrame frame;
	private JTextField textField;
	private JTextField textField_1;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					gui window = new gui();
					window.frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the application.
	 */
	public gui() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frame = new JFrame();
		frame.setBounds(100, 100, 450, 300);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);
		
		JSeparator separator = new JSeparator();
		separator.setBounds(10, 123, 424, 113);
		frame.getContentPane().add(separator);
		
		JLabel lblNewLabel = new JLabel("SELL");
		lblNewLabel.setBounds(194, 11, 46, 14);
		frame.getContentPane().add(lblNewLabel);
		
		JLabel lblBuy = new JLabel("BUY");
		lblBuy.setBounds(194, 123, 46, 25);
		frame.getContentPane().add(lblBuy);
		
		JButton btnNewButton = new JButton("Sell Items");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			}
		});
		btnNewButton.setBounds(160, 89, 89, 23);
		frame.getContentPane().add(btnNewButton);
		
		JButton btnNewButton_1 = new JButton("Buy Goods");
		btnNewButton_1.setBounds(160, 228, 89, 23);
		frame.getContentPane().add(btnNewButton_1);
		
		JLabel lblGoodsAvailable = new JLabel("Number of Food to sell");
		lblGoodsAvailable.setBounds(67, 48, 143, 14);
		frame.getContentPane().add(lblGoodsAvailable);
		
		textField = new JTextField();
		textField.setBounds(224, 45, 86, 20);
		frame.getContentPane().add(textField);
		textField.setColumns(10);
		
		JLabel lblAvailableNumberOf = new JLabel("Available Number of Food : ");
		lblAvailableNumberOf.setBounds(52, 153, 143, 14);
		frame.getContentPane().add(lblAvailableNumberOf);
		
		JLabel lblNewLabel_1 = new JLabel("New label");
		lblNewLabel_1.setBounds(218, 153, 46, 14);
		frame.getContentPane().add(lblNewLabel_1);
		
		JLabel lblQuantityOfFood = new JLabel("Quantity of Food  :");
		lblQuantityOfFood.setBounds(52, 189, 143, 14);
		frame.getContentPane().add(lblQuantityOfFood);
		
		textField_1 = new JTextField();
		textField_1.setBounds(218, 186, 86, 20);
		frame.getContentPane().add(textField_1);
		textField_1.setColumns(10);
	}
}
