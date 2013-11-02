package views;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;

public class MuleSelectionPanel extends JPanel{
	
	private JButton btnNewButton;
	private JButton btnNewButton_1;
	private JButton btnNewButton_2;
	private TownPanel townPanel;
	public MuleSelectionPanel( TownPanel townPanel){
		super();
		this.townPanel = townPanel;
		initialize();
	}
	private void initialize() {
		setBounds(100, 100, 450, 300);
		setLayout(null);
		
		btnNewButton = new JButton("New button");
		btnNewButton.setBounds(68, 119, 89, 23);
		btnNewButton.addActionListener(new MuleListener(1));
		add(btnNewButton);
		
		btnNewButton_1 = new JButton("New button");
		btnNewButton_1.setBounds(191, 119, 89, 23);
		add(btnNewButton_1);
		
		btnNewButton_2 = new JButton("New button");
		btnNewButton_2.setBounds(313, 119, 89, 23);
		add(btnNewButton_2);
		
		JLabel lblSelectYourMule = new JLabel("Select your mule ");
		lblSelectYourMule.setBounds(163, 62, 143, 14);
		add(lblSelectYourMule);
	}
	private class MuleListener implements ActionListener {
		int muleType;
		public MuleListener(int muleType){
			this.muleType = muleType;
		}
		@Override
		public void actionPerformed(ActionEvent arg0) {
			townPanel.gotoMulePlacement(muleType);
			
		}
		
	}
}
