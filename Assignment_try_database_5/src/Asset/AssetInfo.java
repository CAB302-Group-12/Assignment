package Asset;

import Asset.AssetFileDataSource;
import Asset.AssetInfoData;
import Asset.AssetInfoUI;

import javax.swing.SwingUtilities;

/**
 * Invokes the Address Book application.
 * @author Malcolm Corney
 * @version $Id:  Exp $
 */
public class AssetInfo {

    /**
     * Create the GUI.  For thread safety,
     * this method should be invoked from the
     * event-dispatching thread.
     */
    private static void createAndShowGUI() {
        new AssetInfoUI(new AssetInfoData(new AssetFileDataSource()));
    }

    /**
     * @param args
     */
    public static void main(String[] args) {
        //Schedule a job for the event-dispatching thread:
        //creating and showing this application's GUI.
        SwingUtilities.invokeLater(new Runnable() {
            public void run() {
                createAndShowGUI();
            }
        });
    }
}
