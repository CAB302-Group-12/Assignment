package Run_to_start;

import common.GUI.LoginUI;
import common.User.UserFileDataSource;
import common.User.UserInfoData;

import javax.swing.*;

public class LoginInfo {

    /**
     * Create the GUI.  For thread safety,
     * this method should be invoked from the
     * event-dispatching thread.
     */
    private static void createAndShowGUI() {
        new LoginUI(new UserInfoData(new UserFileDataSource()));
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
