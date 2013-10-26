package presenters;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import models.PlayerConfigModel;
import views.FourthScreenPanel;
import views.View;

/**
 * 
 * @author Tanay
 *
 * This class creates a panel object which takes in information from the GUI class (FourthScreenPanel.java)
 * and then gives it to its respective Model class.
 */
public class FourthScreenPresenter {

	    private FourthScreenPanel panel;
	    private PlayerConfigModel model;
	    View view;
	    
	    public FourthScreenPresenter(View view ,PlayerConfigModel model) {
	    	this.model = model;
	    	this.view = view;
	    	this.panel = new FourthScreenPanel(model);
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
	    		FifthScreenPresenter p = new FifthScreenPresenter(this.view, this.model);
	    	}
	    }    


