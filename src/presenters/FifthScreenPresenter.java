package presenters;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import models.PlayerConfigModel;
import views.FifthScreenPanel;
import views.*;
import views.View;
/**
 * 
 * This class creates a panel object which takes in information from the GUI class (FifthScreenPanel.java)
 * and then gives it to its respective Model class.
 */
public class FifthScreenPresenter {

	    private FifthScreenPanel panel;
	    private PlayerConfigModel model;
	    View view;

	    /**
	     * 
	     * Constructor which initializes 
	     * 
	     * @param view
	     * @param model
	     */
	    public FifthScreenPresenter(View view ,PlayerConfigModel model) {
	    	this.model = model;
	    	this.view = view;
	    	this.panel = new FifthScreenPanel(model);
	    	this.view.setPanel(this.panel);
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
	    		model.increaseRound();
	    		System.out.println("round number " + model.getRound());
	    		ThirdScreenPresenter p = new ThirdScreenPresenter(this.view, this.model);
	    		
	    	}
	    	
	    
}

