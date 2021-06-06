package common;

import common.User.User;

import javax.swing.*;
import java.awt.*;

public class BaseFrame extends JFrame {

    /**
     * current login user
     */
    protected User loginUser;

    protected boolean checkNull(String txt){
        return txt == null || txt.equals("");
    }

    protected void alertMsg(Component component, String msg){
        JOptionPane.showMessageDialog(component,msg,"info", JOptionPane.INFORMATION_MESSAGE);
    }

    protected void showCenter(){
        int windowWidth = getWidth();
        int windowHeight = getHeight();
        Toolkit kit = Toolkit.getDefaultToolkit();
        Dimension screenSize = kit.getScreenSize();
        int screenWidth = screenSize.width;
        int screenHeight = screenSize.height;
        setLocation(screenWidth/2-windowWidth/2, screenHeight/2-windowHeight/2);
    }
}
