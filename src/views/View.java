package views;
import java.awt.Dimension;
import java.awt.event.ActionListener;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JSlider;
import javax.swing.JSpinner;


/**
 * @author yee
 * Init JFrame that changes panels, getters and setters for each possible variable
 */
public class View extends JFrame
{
	JSlider slider;
	JSpinner spinner;
	JButton btnNewButton;

	private JPanel panel;

	public View( JPanel panel )
	{
		setFocusable( true );
		this.setBounds( 100, 100, 450, 300 );
		this.setPreferredSize( new Dimension( 800, 600 ) );
		this.pack();
		this.setDefaultCloseOperation( JFrame.EXIT_ON_CLOSE );

		this.panel = panel;
		this.getContentPane().add( panel );
		this.setVisible( true );
	}

	public int getDifficultyValue()
	{
		return ( (GameConfigPanel) panel ).getDifficultyValue();
	}
	
	public String[] getPlayerNames()
	{
		return ((PlayerConfigPanel) panel).getNames();
	}
	
	public String[] getPlayerColors() {
	    return ((PlayerConfigPanel) panel).getColors();
	}
	
	public String[] getPlayerRaces() {
	    return ((PlayerConfigPanel) panel).getRaces();
	}
	
	public int getNumPlayers() {
		return ((GameConfigPanel) panel).getNumPlayers();
	}

	public void setPanel( JPanel newPanel )
	{
		this.remove( this.panel );
		this.panel = newPanel;

		this.getContentPane().add( newPanel );
		//this.revalidate();
		this.repaint();
	}

	public void addActionListener( ActionListener l )
	{
		if (this.panel instanceof GameConfigPanel)
		{
			GameConfigPanel myPanel = (GameConfigPanel) this.panel;
			myPanel.addActionListener( l );
		}
		else if (this.panel instanceof TownPanel)
		{
			GameConfigPanel myPanel = (GameConfigPanel) this.panel;
			myPanel.addActionListener( l );
		}
		
		else if (this.panel instanceof PlayerConfigPanel) {
			
			PlayerConfigPanel myPanel = (PlayerConfigPanel) this.panel;
			myPanel.addActionListener( l );
		}
		else if(this.panel instanceof ThirdScreenPanel){
			ThirdScreenPanel myPanel = (ThirdScreenPanel) this.panel;
			myPanel.addActionListener( l );
		}
		else if(this.panel instanceof FourthScreenPanel){
			FourthScreenPanel myPanel = (FourthScreenPanel) this.panel;
			myPanel.addActionListener( l );
		}
		else if(this.panel instanceof FifthScreenPanel){
			FifthScreenPanel myPanel = (FifthScreenPanel) this.panel;
			myPanel.addActionListener( l );
		}
	}

	public int getMapType() {
	    return ((GameConfigPanel)panel).getMapType();
	}

}