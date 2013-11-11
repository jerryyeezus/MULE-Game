package views;

import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.io.File;
import java.io.IOException;
import java.util.Observable;
import java.util.Observer;
import java.util.Random;

import javax.imageio.ImageIO;
import javax.swing.JPanel;
import javax.swing.Timer;

public class AnimPanel extends JPanel {
	private int x, y, dx;
	private int counter, frame;
	private static final int NUM_ARROWS = 58;
	protected static final int D_ALPHA = 9;

	private int arr_x[];
	private int arr_y[];
	private int cloud_x;
	private int cloud_y;
	private int cloud_x2;
	private int cloud_y2;

	File[] images = { new File("src/temp/frame0.png"),
			new File("src/temp/frame1.png"), new File("src/temp/frame2.png"),
			new File("src/temp/frame3.png") };

	private Image[] imgFrames;
	private Image cursorImg;
	private Image cloud;
	private Image bg;
	private int alphaLevel = 255;
	private Image rain;
	private Random r;
	protected int cursor;

	private TitleScreen titleScreen;
	protected int dAlpha;

	private enum State {
		PRESS_ENTER, CHOOSE, ABOUT
	}

	private State current = State.PRESS_ENTER;

	public AnimPanel(TitleScreen screen) {
		super();
		titleScreen = screen;
		dAlpha = -D_ALPHA;
		cloud_x = 0;
		cloud_y = 210;

		cloud_x2 = 500;
		cloud_y2 = 78;

		cursor = 0;
		addKeyListener(new KeyAdapter() {
			@Override
			public void keyPressed(KeyEvent e) {
				if (e.getKeyCode() == KeyEvent.VK_ENTER) {
					if (current == State.CHOOSE) {
						if (cursor != 2)
							titleScreen.update(cursor);
						else
							current = State.ABOUT;
					} else if (current == State.PRESS_ENTER)
						current = State.CHOOSE;
					else
						current = State.PRESS_ENTER;
				} else if (e.getKeyCode() == KeyEvent.VK_DOWN) {
					cursor++;
					if (cursor > 2)
						cursor = 0;
				} else {
					cursor--;
					if (cursor < 0)
						cursor = 2;
				}
			}

		});
		this.setFocusable(true);
		setLayout(null);
		setBackground(new Color(228, 228, 228));
		arr_x = new int[NUM_ARROWS];
		arr_y = new int[NUM_ARROWS];

		r = new Random();
		for (int i = 0; i < NUM_ARROWS; i++) {
			arr_x[i] = 30 + r.nextInt(1200);
			arr_y[i] = r.nextInt(620);
		}
		this.dx = 0;
		this.counter = 0;
		this.x = 0;
		this.y = 410;
		this.frame = 0;
		imgFrames = new Image[4];
		try {
			bg = ImageIO.read(new File("src/temp/bg2.jpg"));
			cursorImg = ImageIO.read(new File("src/temp/cursor.png"));
			cloud = ImageIO.read(new File("src/temp/cloud.png"));
			rain = ImageIO.read(new File("src/temp/rain2.png"));
			for (int i = 0; i < 4; i++)
				imgFrames[i] = ImageIO.read(images[i]);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	@Override
	public void paint(Graphics g) {
		super.paint(g);
		g.drawImage(bg, x, 0, null);

		g.drawImage(imgFrames[frame], 250, y, null);

		if (current == State.CHOOSE) {
			g.drawImage(cursorImg, 210, 215 + cursor * 60, null);

			g.setColor(Color.WHITE);
			g.setFont(new Font("Verdana", Font.BOLD, 24));
			if (cursor == 0)
				g.setColor(Color.RED);
			g.drawString("New Game", this.getWidth() / 3 + 30, 230);
			g.setColor(Color.WHITE);

			if (cursor == 1)
				g.setColor(Color.RED);
			g.drawString("Load Game", this.getWidth() / 3 + 30, 290);

			g.setColor(Color.WHITE);
			if (cursor == 2)
				g.setColor(Color.RED);
			g.drawString("About", this.getWidth() / 3 + 30, 350);
			g.setColor(Color.WHITE);

		} else if (current == State.PRESS_ENTER) {
			g.setColor(new Color(83, 23, 230, alphaLevel));
			g.setFont(new Font("calibri", Font.BOLD, 20));
			g.drawString("Press Enter...", this.getWidth() / 3 + 40, 290);
		} else {
			cursor = 0;
			g.setColor(Color.WHITE);
			g.setFont(new Font("Verdana", Font.BOLD, 18));
			String str[] = new String[6];
			str[0] = "Produced by Team Outsourced";
			g.drawString(str[0], this.getWidth() / 4, 200);

			g.setFont(new Font("Verdana", Font.PLAIN, 12));
			str[1] = "	Architect: Jerry \"Yeezus\" Yee";
			str[2] = "	Programmer: Tanay Pontkshe";
			str[3] = "	Intern: Ishaan Grover";
			str[4] = "	Javadoc Specialist : Sham";
			for (int i = 1; i < 5; i++)
				g.drawString(str[i], this.getWidth() / 4, 200 + i * 30);
		}

		for (int i = 0; i < NUM_ARROWS; i++)
			g.drawImage(rain, arr_x[i], arr_y[i], null);

		g.drawImage(cloud, cloud_x, cloud_y, 1800, 380, null);
		g.drawImage(cloud, cloud_x2, cloud_y2, 1800, 400, null);
	}

	public void animate() {
		final Timer timer = new Timer(40, null);
		timer.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				alphaLevel += dAlpha;
				if (alphaLevel > 225)
					dAlpha = -D_ALPHA;
				else if (alphaLevel < 10)
					dAlpha = D_ALPHA;

				if ((counter % 10) == 0 && counter != 0)
					if (frame++ > 2)
						frame = 0;

				x -= 8;
				if (x < -900)
					x = 0;
				counter += 5;
				if (counter > 21) {
					counter = 0;
				}

				cloud_x -= 30;
				if (cloud_x < -1750)
					cloud_x = 100;

				cloud_x2 -= 15;
				if (cloud_x2 < -1750)
					cloud_x2 = 100;

				for (int i = 0; i < NUM_ARROWS; i++) {
					arr_y[i] += 19;
					arr_x[i] -= 6 + r.nextInt(12);
					if (arr_x[i] < 0) {
						arr_x[i] = r.nextInt(800) + 40;
						arr_y[i] = 0;
					} else if (arr_y[i] > 600)
						arr_y[i] = 0;
				}

				repaint();
			}
		});
		timer.start();

	}

}
