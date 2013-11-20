import models.PlayerConfigModel;
import static org.junit.Assert.*;
import org.junit.Before;
import org.junit.Test;

import views.FourthScreenPanel;

/**
 * @author Ishaan
 * Test if round gets incremented when timer becomes 0 and it is the last players turn.
 * Else, round number should remain the same.
 */
public class MoreTests {

	PlayerConfigModel model;
	FourthScreenPanel panel;

	@Before
	public void setUp() throws Exception {
		model = new PlayerConfigModel(4);
		int a[] = {0,1,2,3};
		model.setCurRoundOrder(a);
	}

	/**
	 * 4 players
	 * If it is the last player's turn and timer becomes 0. Round should get incremented.
	 */
	@Test
	public void testTimer1() {
		model.setCurPlayer(3);
		model.setTimer(0);
		model.setRound(4);
		model.updateTimer();
		assertEquals(5, model.getRound());	
	}	
	
	/**
	 * 4 players
	 * If it is 3rd player's turn and timer becomes 0. Round should not get incremented.
	 */
	@Test
	public void testTimer2() {
		model.setCurPlayer(2);
		model.setTimer(0);
		model.setRound(4);
		model.updateTimer();
		assertEquals(4, model.getRound());	
	}	
	
	/**
	 * 4 players
	 * If it is 3rd player's turn and timer is 5 seconds. Round should not get incremented.
	 */
	@Test
	public void testTimer3() {
		model.setCurPlayer(3);
		model.setTimer(5);
		model.setRound(3);
		model.updateTimer();
		assertEquals(3, model.getRound());	
	}	
	
	/**
	 * 4 players
	 * If it is 1st player's turn and timer is 1 second. Round should not get incremented.
	 */
	@Test
	public void testTimer4() {
		model.setCurPlayer(1);
		model.setTimer(1);
		model.setRound(3);
		model.updateTimer();
		assertEquals(3, model.getRound());	
	}	
	
}