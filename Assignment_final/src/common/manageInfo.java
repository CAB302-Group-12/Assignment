package common;

import common.Asset.AssetFileDataSource;
import common.Asset.AssetInfoData;
import common.GUI.manageUI;

import javax.swing.*;

public class manageInfo {

    /**
     * Create the GUI.  For thread safety,
     * this method should be invoked from the
     * event-dispatching thread.
     */
    private static void createAndShowGUI() {
        new manageUI(new AssetInfoData(new AssetFileDataSource()),null);
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
