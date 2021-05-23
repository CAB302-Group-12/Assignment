package common;

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
        int windowWidth = getWidth(); //获得窗口宽
        int windowHeight = getHeight(); //获得窗口高
        Toolkit kit = Toolkit.getDefaultToolkit(); //定义工具包
        Dimension screenSize = kit.getScreenSize(); //获取屏幕的尺寸
        int screenWidth = screenSize.width; //获取屏幕的宽
        int screenHeight = screenSize.height; //获取屏幕的高
        setLocation(screenWidth/2-windowWidth/2, screenHeight/2-windowHeight/2);//设置窗口居中显示
    }
}
