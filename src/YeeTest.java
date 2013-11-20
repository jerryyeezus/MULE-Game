import static org.junit.Assert.assertTrue;

import java.util.Arrays;

import models.PlayerConfigModel;

import org.junit.Before;
import org.junit.Test;

import views.FourthScreenPanel;

/**
 * @author Yee
 * Test player order logic for 2 player and 4 players
 * It should output correct array depending on total score (money + food + resources)
 */
public class YeeTest {

	PlayerConfigModel model;
	FourthScreenPanel panel;

	@Before
	public void setUp() throws Exception {
		model = new PlayerConfigModel(4);
		model.setCurPlayer(0);
		panel = new FourthScreenPanel(model);
	}

	/**
	 * 4 players
	 * If all players have same score, it just order in alphabetical order
	 */
	@Test
	public void testAllSame() {
		int[] answer = {0,1,2,3};
		model.getPlayer(0).setMoney(0);
		model.getPlayer(1).setMoney(0);
		model.getPlayer(2).setMoney(0);
		model.getPlayer(3).setMoney(0);
		int order[] = model.calcPlayerOrder();
		assertTrue(Arrays.equals(answer, order));
	}
	
	/**
	 * 2 Players
	 * All have same score that is non-zero, still is alphabetical order
	 */
	@Test
	public void testAllSame2() {
		// Reinit model to 2 player so the test works
		model = new PlayerConfigModel(2);
		model.setCurPlayer(0);
		panel = new FourthScreenPanel(model);

		int[] answer = {0,1};
		model.getPlayer(0).setMoney(50);
		model.getPlayer(1).setMoney(50);
		int order[] = model.calcPlayerOrder();
		assertTrue(Arrays.equals(answer, order));
	}
	
	/**
	 * 4 players
	 * players 1 and 2 have duplicate score so it should break tie artibitrarily
	 */
	@Test
	public void testDuplications4() {
		int[] answer = { 3,0,1,2};
		model.getPlayer(0).setMoney(20);
		model.getPlayer(1).setMoney(50);
		model.getPlayer(2).setMoney(50);
		model.getPlayer(3).setMoney(0);
		int order[] = model.calcPlayerOrder();
		assertTrue(Arrays.equals(answer, order));
	}
	
	/**
	 * 4 Players
	 *  Order should be 3,2,0,1 since 3 is lowest
	 */
	@Test
	public void testGeneral() {
		int[] answer = {3,2,0,1};
		model.getPlayer(0).setMoney(20);
		model.getPlayer(1).setMoney(50);
		model.getPlayer(2).setMoney(10);
		model.getPlayer(3).setMoney(0);

		int order[] = model.calcPlayerOrder();
		assertTrue(Arrays.equals(answer, order));
	}

}
