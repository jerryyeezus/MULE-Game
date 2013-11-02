package presenters;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import views.*;
import models.*;

/**
 * @author yee
 * 
 */
public class PlayerConfigPresenter {

    private static final int[] goodsTable = { 8, 4,4 };
    private static final int[] drinkTable = {4, 2, 2};
    private static final int[] cageTable = {0,0,0};
    private View view;
    private PlayerConfigModel model;
    private GameConfigModel gameConfig;

    public GameConfigModel getGameConfig() {
	return gameConfig;
    }

    public void setGameConfig(GameConfigModel gameConfig) {
	this.gameConfig = gameConfig;
    }

    private PlayerConfigPanel panel;

    public int numPlayers;

    /**
     * Initalizes the model and view, changes the panel to PlayerConfigPanel
     * 
     * @param view
     * @param numPlayers
     */
    public PlayerConfigPresenter(View view, int numPlayers) {
	this.numPlayers = numPlayers;
	this.view = view;
	this.model = new PlayerConfigModel(numPlayers);
	this.panel = new PlayerConfigPanel(numPlayers);

	this.view.setPanel(this.panel);
	this.view.addActionListener(new ActionListener() {

	    @Override
	    public void actionPerformed(ActionEvent arg0) {
		onSubmit();
	    }
	});
    }

    public PlayerConfigPresenter(View view, int numPlayers,
	    GameConfigModel gameConfig) {
	this.numPlayers = numPlayers;
	this.view = view;
	this.model = new PlayerConfigModel(numPlayers);
	this.gameConfig = gameConfig;
	this.panel = new PlayerConfigPanel(numPlayers);

	this.view.setPanel(this.panel);
	this.view.addActionListener(new ActionListener() {

	    @Override
	    public void actionPerformed(ActionEvent arg0) {
		onSubmit();
	    }
	});
    }

    /**
     * Update the Player Models for names, races, colors
     */
    public void onSubmit() {
	// update names in model
	for (int i = 0; i < numPlayers; i++) {
	    model.getPlayer(i).setName(view.getPlayerNames()[i]);
	}

	// update races in model
	for (int i = 0; i < numPlayers; i++) {
	    model.getPlayer(i).setRace(view.getPlayerRaces()[i]);

	    if (view.getPlayerRaces()[i].equals("Lall")) {
		model.getPlayer(i).setMoney(600);
	    } else if (view.getPlayerRaces()[i].equals("Ponkshe")) {
		model.getPlayer(i).setMoney(700);
	    } else if (view.getPlayerRaces()[i].equals("Humanoid")) {
		model.getPlayer(i).setMoney(300);
	    } else
		model.getPlayer(i).setMoney(1000);
	    
	    // update goods (food)
	    model.getPlayer(i).setFood(goodsTable[gameConfig.getDifficulty()]);
	    
	    // update nicolasCage
	    model.getPlayer(i).setNicolasCage((cageTable[gameConfig.getDifficulty()]));
	    
	    // update drink
	    model.getPlayer(i).setDrink((drinkTable[gameConfig.getDifficulty()]));

	}

	// update color in model
	for (int i = 0; i < numPlayers; i++) {
	    model.getPlayer(i).setColor(view.getPlayerColors()[i]);
	}

	// create next screen
	ThirdScreenPresenter p = new ThirdScreenPresenter(this.view, this.model);
    }

}