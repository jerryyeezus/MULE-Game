package views;

import java.awt.CardLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectOutputStream;
import java.io.Serializable;
import java.util.logging.Logger;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JPanel;
import javax.swing.SwingUtilities;

import models.GameConfigModel;
import models.PlayerConfigModel;

/**
 * 
 * This class contains the Town this which contains different buttons which
 * trigger different events.
 * 
 * @author Tanay
 * 
 */
public class TownPanel extends JPanel implements Serializable {
    // Pub, Buy MULES, Go to Map,
    private PlayerConfigModel model;
    JButton btnLand;
    JButton btnPub;
    private JPanel mulePanel;
    private GameConfigModel gameConfig;
    private JPanel storePanel;
    private JPanel panel; // panel for Town
    private CardLayout layout;
    private JPanel pubPanel;
    private JPanel mulePlacementPanel;
    private JButton saveButton;

    private static final long serialVersionUID = 1L;
    /**
     * Create the application.
     */
    public TownPanel(PlayerConfigModel model) {
	layout = new CardLayout();
	pubPanel = new Pub(model);
	this.setLayout(layout);
	this.storePanel = new StorePanel(model);
	this.model = model;
	this.mulePanel = new MuleSelectionPanel(this, model);
	this.mulePlacementPanel = new MulePlacementPanel(model, this);
	this.initialize();
    }

   // private static Logger log = Logger.getLogger(PlayerConfigModel.class.getClass());

    public void save(String filename) {
	try {
	    ObjectOutputStream out = new ObjectOutputStream(
		    new FileOutputStream(filename));
	    
	    out.writeObject(this.model);
	} catch (FileNotFoundException e) {
	    // TODO Auto-generated catch block
	    e.printStackTrace();
	} catch (IOException e) {
	    // TODO Auto-generated catch block
	    e.printStackTrace();
	}
    }

    /**
     * Initialize the contents of the this.
     */
    private void initialize() {
	panel = new JPanel();
	panel.setBounds(10, 118, 850, 550);

	btnPub = new JButton("");

	saveButton = new JButton("Save");
	saveButton.setBounds(550, 460, 70, 20);
	saveButton.addActionListener(new ActionListener() {

	    @Override
	    public void actionPerformed(ActionEvent e) {
	    	SwingUtilities.invokeLater(new Runnable() {
	    		public void run() {
	    			save("game.dat");
	    		}
	    	});
	    }
	});
	panel.add(saveButton);

	btnPub.setIcon(new ImageIcon("src/temp/miniPub.jpg"));
	btnPub.setBounds(10, 174, 304, 128);
	btnPub.addActionListener(new CardUpdater(this, "Pub", pubPanel));
	panel.add(btnPub);
	panel.setLayout(null);

	JButton btnAssay = new JButton("slickdeals");
	// btnAssay.setIcon(new
	// btnAssay.setIcon(new ImageIcon("src/temp/miniLand.jpg"));
	btnAssay.setBounds(10, 11, 304, 128);
	panel.add(btnAssay);

	btnLand = new JButton("");
	btnLand.setIcon(new ImageIcon("src/temp/miniLand.jpg"));
	btnLand.setBounds(501, 11, 304, 128);
	panel.add(btnLand);

	JButton btnStore = new JButton("");
	btnStore.setIcon(new ImageIcon("src/temp/mule.jpg"));
	btnStore.setBounds(501, 174, 304, 128);
	btnStore.addActionListener(new CardUpdater(this, "Mule", mulePanel));
	panel.add(btnStore);

	this.add("Town", panel);
	this.add("Store", storePanel);
	this.add("Pub", pubPanel);

	this.add("MulePlacement", mulePlacementPanel);
	add("Mule", mulePanel);
	btnAssay.addActionListener(new CardUpdater(this, "Store", storePanel));

    }

    /**
     * Add an action listener for the Exit button.
     * 
     */

    public void addListener(ActionListener l) {
	btnLand.addActionListener(l);
    }

    public void gotoMulePlacement(int muleType) {
	this.layout.show(this, "MulePlacement");
	((MulePlacementPanel) this.mulePlacementPanel)
		.doMuleSelection(muleType);
    }

    public void resetView() {
	layout.show(this, "Town");
    }

    /*
     * public void setInvisible(){ setVisible(false); }
     */

    public void clickTheLandButton() {
	btnLand.doClick();

    }
}
