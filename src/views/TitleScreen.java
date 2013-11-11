package views;

import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.net.URL;

import javax.sound.sampled.AudioInputStream;
import javax.sound.sampled.AudioSystem;
import javax.sound.sampled.Clip;
import javax.sound.sampled.LineUnavailableException;
import javax.sound.sampled.UnsupportedAudioFileException;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

import models.PlayerConfigModel;
import presenters.GameConfigPresenter;
import presenters.ThirdScreenPresenter;

public class TitleScreen {

	private JFrame frame;
	JButton btnNewButton;
	Clip clip;

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
		// frame.setContentPane(new JLabel(new
		// ImageIcon("src/temp/clouds3.jpg")));
		frame.getContentPane().setBackground(new Color(228, 228, 228));
		frame.setBounds(100, 100, 650, 540);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);

		JButton btnNewButton = new JButton("START");
		btnNewButton.setBounds(frame.getWidth() / 3, 161, 203, 23);
		// frame.getContentPane().add(btnNewButton);
		btnNewButton.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent arg0) {
				clip.stop();
				clip.close();
				GameConfigPresenter.instantiate();
				frame.setVisible(false);

			}
		});

		JLabel b = new JLabel("Load Game");
		b.setBounds(frame.getWidth() / 3 + 30, 267, 203, 23);
		//frame.getContentPane().add(b);

		JButton btnNewButton_1 = new JButton("LOAD");
		btnNewButton_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				frame.setVisible(false);
				load();
			}
		});
		btnNewButton_1.setBounds(frame.getWidth() / 3, 238, 203, 23);
		// frame.getContentPane().add(btnNewButton_1);
		JLabel a = new JLabel("New Game");
		a.setBounds(frame.getWidth() / 3 + 30, 208, 200, 23);
		//frame.getContentPane().add(a);

		JLabel lblNewLabel = new JLabel("M.U.L.E   GAME");
		lblNewLabel.setIcon(new ImageIcon("src/temp/title.png"));
		lblNewLabel.setOpaque(false);
		lblNewLabel.setBounds(195, 43, 262, 48);

		JLabel slogan = new JLabel(new ImageIcon("src/temp/slogan.png"));
		slogan.setBounds(115, 90, 452, 48);
		frame.getContentPane().add(slogan);

		frame.getContentPane().add(lblNewLabel);

		tmp = new AnimPanel(this);
		// tmp.setBounds(0, frame.getHeight() - 120, frame.getWidth(), 80);
		tmp.setBounds(0, 0, frame.getWidth(), frame.getHeight());
		frame.getContentPane().add(tmp);
		tmp.animate();
		tmp.setOpaque(false);
		try {
			// Open an audio input stream.
			URL url = this.getClass().getClassLoader()
					.getResource("temp/theme.mid");
			AudioInputStream audioIn = AudioSystem.getAudioInputStream(url);
			// Get a sound clip resource.
			clip = AudioSystem.getClip();
			// Open audio clip and load samples from the audio input stream.
			clip.open(audioIn);
			clip.start();
		} catch (UnsupportedAudioFileException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		} catch (LineUnavailableException e) {
			e.printStackTrace();
		}
	}

	AnimPanel tmp;

	private static final String savefile = "game.dat";

	protected void load() {
		PlayerConfigModel playerModel = null;
		ObjectInputStream in;
		try {
			in = new ObjectInputStream(new FileInputStream(savefile));
			try {
				playerModel = new PlayerConfigModel(
						(PlayerConfigModel) in.readObject());
			} catch (ClassNotFoundException e) {
				e.printStackTrace();
			}
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}

		clip.stop();
		clip.close();

		View view = new View(new ThirdScreenPanel(playerModel));
		new ThirdScreenPresenter(view, playerModel);
	}

	public static void main(String[] args) {
		TitleScreen t = new TitleScreen();
	}

	
	
	public void update(int cursor) {
		if (cursor == 0) {
			clip.stop();
			clip.close();
			GameConfigPresenter.instantiate();
			frame.setVisible(false);
		} else if (cursor == 1)
			load();
		else
			JOptionPane.showMessageDialog(frame, "Produced by Team OUTSOURCED\n\nLead Architect: Jerry \"Yeezus\" Yee\n\n"
					+ "Asst. Programmer: Tanay Pontkshe\n\nIntern: Nikhil\n\nIntern: Ishaan Grover\n\nJavadoc Person : Sham");
	}

}
