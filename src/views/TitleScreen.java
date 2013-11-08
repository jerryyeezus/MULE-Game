package views;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.ImageIcon;
import javax.swing.JPanel;

import models.GameConfigModel;
import presenters.GameConfigPresenter;

import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.Color;


public class TitleScreen {

	private JFrame frame;
	JButton btnNewButton;

	/**
	 * Launch the application.
	 */
	

	/**
	 * Create the application.
	 */
	public TitleScreen() {
		initialize();
		frame.setVisible(true);
	}

	public void addActionListener(ActionListener l) {
		btnNewButton.addActionListener(l);
	}
	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frame = new JFrame();
		frame.getContentPane().setBackground(new Color(228,228,228));
		frame.setBounds(100, 100, 450, 300);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);
		
		JButton btnNewButton = new JButton("START");
		btnNewButton.setBounds(108, 131, 203, 23);
		frame.getContentPane().add(btnNewButton);
		btnNewButton.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent arg0) {
				GameConfigPresenter.instantiate();
				frame.setVisible(false);
				
			}
		});
		
		JButton btnNewButton_1 = new JButton("LOAD");
		btnNewButton_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				System.out.println("hey! loading game...");
			}
		});
		btnNewButton_1.setBounds(108, 198, 203, 23);
		frame.getContentPane().add(btnNewButton_1);
		
		JLabel lblNewLabel = new JLabel("M.U.L.E   GAME");
		lblNewLabel.setIcon(new ImageIcon("C:\\Users\\Tanay\\Yeezus\\src\\temp\\Title.jpg"));
		lblNewLabel.setBounds(125, 43, 162, 48);
		frame.getContentPane().add(lblNewLabel);
	}
	public static void main(String[] args) {
		TitleScreen t = new TitleScreen();
	}
}
