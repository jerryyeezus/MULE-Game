import static org.junit.Assert.assertEquals;
import models.PlayerConfigModel;

import org.junit.Before;
import org.junit.Test;

import views.FourthScreenPanel;

/**
 * @author Ishaan
 * Test player time according to food by comparing with food requirements for various rounds
 * for any arbitrary player, say 0.
 */

public class IshaanTest {

	PlayerConfigModel model;
	FourthScreenPanel panel;
	
	@Before
	public void setUp() throws Exception {
		model = new PlayerConfigModel(2);
		model.setCurPlayer(0);
		panel = new FourthScreenPanel(model);
	}
	
	/**
	 * If round is 2 and player food is 2
	 */
	@Test
	public void testPlayerTime() {
		model.setRound(2);
		model.getPlayer(0).setFood(2);
		int time = model.calcPlayerTime();
		assertEquals(30, time);
	}
	/**
	 * If round is 2 and player food is 0
	 */
	@Test
	public void testPlayerTime1() {
		model.setRound(2);
		model.getPlayer(0).setFood(0);
		int time = model.calcPlayerTime();
		assertEquals(5, time);
	}
	
	/**
	 * If round is 2 and player food is 3
	 */
	@Test
	public void testPlayerTime2() {
		model.setRound(2);
		model.getPlayer(0).setFood(3);
		int time = model.calcPlayerTime();
		assertEquals(40, time);
	}
	
	/**
	 * If round is 6 and player food is 4
	 */
	@Test
	public void testPlayerTime3() {
		model.setRound(6);
		model.getPlayer(0).setFood(4);
		int time = model.calcPlayerTime();
		assertEquals(30, time);
	}
	
	/**
	 * If round is 6 and player food is 0
	 */
	@Test
	public void testPlayerTime4() {
		model.setRound(6);
		model.getPlayer(0).setFood(0);
		int time = model.calcPlayerTime();
		assertEquals(5, time);
	}
	
	/**
	 * If round is 4 and player food is 6
	 */
	@Test
	public void testPlayerTime5() {
		model.setRound(4);
		model.getPlayer(0).setFood(6);
		int time = model.calcPlayerTime();
		assertEquals(40, time);
	}
	
}
