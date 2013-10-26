package presenters;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JOptionPane;

import models.GameConfigModel;
import views.GameConfigPanel;
import views.View;

/**
 * @author yee update game config model with view values
 */
public class GameConfigPresenter {

	private View view;
	private GameConfigModel model;

	/**
	 * init view and model instances, set listener to next
	 * 
	 * @param view
	 *            gameconfig view
	 * @param model
	 *            gameconfig model
	 */
	public GameConfigPresenter(View view, GameConfigModel model) {
		this.view = view;
		this.model = model;

		this.view.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				onSubmit();
			}
		});
	}

	/**
	 * Called when hit next button, updates the model
	 */
	public void onSubmit() {
		// update diff, num, and map
		model.setDifficulty(view.getDifficultyValue());
		model.setNumberOfPlayers(view.getNumPlayers());
		model.setMapType(view.getMapType());

		System.out.println("Model.difficulty = " + model.getDifficulty());
		System.out.println("model.num = " + model.getNumberOfPlayers());
		System.out.println("model.mapType = " + model.getMapType());

		// check if 0 entered -- bad!
		if (view.getNumPlayers() == 0) {
			JOptionPane.showMessageDialog(null, "num players cant be 0 dummy");
		} else {
			PlayerConfigPresenter p = new PlayerConfigPresenter(view,
					view.getNumPlayers());
		}
	}

	public static void main(String[] args) {
		GameConfigPanel panel = new GameConfigPanel();
		View view = new View(panel);
		GameConfigModel model = new GameConfigModel();

		// Make presenter
		GameConfigPresenter p = new GameConfigPresenter(view, model);
	}

}
