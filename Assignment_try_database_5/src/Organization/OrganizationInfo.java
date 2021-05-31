package Organization;

import Organization.OrganizationFileDataSource;
import Organization.OrganizationInfoData;
import Organization.OrganizationInfoUI;

import javax.swing.SwingUtilities;

/**
 * Invokes the Address Book application.
 * @author Malcolm Corney
 * @version $Id:  Exp $
 */
public class OrganizationInfo {

    /**
     * Create the GUI.  For thread safety,
     * this method should be invoked from the
     * event-dispatching thread.
     */
    private static void createAndShowGUI() {
        new OrganizationInfoUI(new OrganizationInfoData(new OrganizationFileDataSource()));
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
