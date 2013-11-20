import static org.junit.Assert.assertEquals;

import java.awt.Color;

import models.PlayerModel;

import org.junit.Before;
import org.junit.Test;

import views.PlayerConfigPanel;

/**
 * @author Ishaan
 * Test Player Color assignment from string according to color chosen from dropdown
 * in PlayerConfigModel.
 */
public class ColorTest {

	PlayerModel model;
	PlayerConfigPanel panel;

	@Before
	public void setUp() throws Exception {
		model = new PlayerModel();
		panel = new PlayerConfigPanel(4);
	}
	
	/**
	 * If Player selects string "Red" from the dropdown.
	 */
	@Test
	public void testColor() {
		model.setColor("Red");
		Color c = model.getColor();
		assertEquals(Color.RED, c);
	}
	
	/**
	 * If Player selects string "Blue" from the dropdown.
	 */
	@Test
	public void testColor1() {
		model.setColor("Blue");
		Color c = model.getColor();
		assertEquals(Color.BLUE, c);
	}
	
	/**
	 * If Player selects string "Green" from the dropdown.
	 */
	@Test
	public void testColor2() {
		model.setColor("Green");
		Color c = model.getColor();
		assertEquals(Color.GREEN, c);
	}
	
	/**
	 * If Player selects string "Yellow" from the dropdown.
	 */
	@Test
	public void testColor3() {
		model.setColor("Yellow");
		Color c = model.getColor();
		assertEquals(Color.YELLOW, c);
	}
}