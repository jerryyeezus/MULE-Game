package presenters;

import java.awt.event.*;

import models.PlayerConfigModel;
import views.ThirdScreenPanel;
import views.View;

/**
 * 
 * @author Tanay
 * 
 *         This class creates a panel object which takes in information from the
 *         GUI class (ThirdScreenPanel.java) and then gives it to its respective
 *         Model class.
 * 
 */
public class ThirdScreenPresenter {

	private ThirdScreenPanel panel;
	private PlayerConfigModel model;
	private View view;

	public ThirdScreenPresenter(View view, PlayerConfigModel model) {
		this.model = model;
		this.view = view;
		this.panel = new ThirdScreenPanel(model);
		this.view.setPanel(this.panel);
		this.view.invalidate();
		this.view.repaint();
		this.view.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent arg0) {
				onSubmit();
			}
		});
	}

	/**
	 * Method which takes the data from view class to model class.
	 */
	public void onSubmit() {
		// TODO set player base on score, timer based on shit

		int[] calculatedOrder = this.model.calcPlayerOrder();
		if(model.getCurPlayer() == -1)
			this.model.setCurPlayer(calculatedOrder[0]);
		else {
			this.model.setCurPlayer(model.getCurPlayer());
			// TODO JERRRYYYY YEEZUS
		}
		this.model.setTimer(40);
		FourthScreenPresenter p = new FourthScreenPresenter(this.view,
				this.model);
	}

}
