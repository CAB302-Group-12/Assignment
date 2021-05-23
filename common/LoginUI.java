package common;

import serialisationExercise.AssetFileDataSource;
import serialisationExercise.UserFileDataSource;
import utils.MD5Utils;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

public class LoginUI extends BaseFrame {

    private JTextField emailField;
    private JLabel emaliText;
    private JButton loginBtn;
    private JPasswordField pwdField;
    private JLabel pwdText;
    private JLabel signInLabel;
    private JLabel signText;
    private JLabel subTitleLabel;
    private JPanel mainPanel;

    UserInfoData data;

    public LoginUI(UserInfoData data) {
        this.data = data;

        initComponents();

        addButtonListeners(new ButtonListener());

        // decorate the frame and make it visible
        showCenter();
        setTitle("Login");
        setVisible(true);
    }

    private void initComponents() {

        mainPanel = new JPanel();
        signInLabel = new JLabel();
        subTitleLabel = new JLabel();
        emaliText = new JLabel();
        emailField = new JTextField();
        pwdText = new JLabel();
        pwdField = new JPasswordField();
        loginBtn = new JButton();
        signText = new JLabel();

        setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        setPreferredSize(new Dimension(550, 400));

        this.add(mainPanel);
        signInLabel.setFont(new Font("Microsoft JhengHei", 1, 24));
        signInLabel.setText("Sign in");

        subTitleLabel.setFont(new Font("Microsoft JhengHei", 0, 14));
        subTitleLabel.setText("Welcome to the trading platform");

        emaliText.setFont(new Font("Microsoft JhengHei", 0, 24));
        emaliText.setText("Name:");

        pwdText.setFont(new Font("Microsoft JhengHei", 0, 24));
        pwdText.setText("Password:");

        loginBtn.setFont(new Font("Microsoft JhengHei", 0, 14));
        loginBtn.setText("Login in");

        signText.setFont(new Font("Microsoft JhengHei", 0, 14));
        signText.setText("Creat an new account");

        GroupLayout layout = new GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
                layout.createParallelGroup(GroupLayout.Alignment.LEADING)
                        .addGroup(GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                                .addContainerGap(GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(signInLabel, GroupLayout.PREFERRED_SIZE, 97, GroupLayout.PREFERRED_SIZE)
                                .addGap(223))
                        .addGroup(layout.createSequentialGroup()
                                .addGroup(layout.createParallelGroup(GroupLayout.Alignment.LEADING)
                                        .addGroup(layout.createSequentialGroup()
                                                .addGap(156)
                                                .addComponent(subTitleLabel, GroupLayout.PREFERRED_SIZE, 225, GroupLayout.PREFERRED_SIZE))
                                        .addGroup(layout.createSequentialGroup()
                                                .addGap(53)
                                                .addGroup(layout.createParallelGroup(GroupLayout.Alignment.LEADING, false)
                                                        .addGroup(layout.createSequentialGroup()
                                                                .addComponent(emaliText, GroupLayout.PREFERRED_SIZE, 82, GroupLayout.PREFERRED_SIZE)
                                                                .addGap(44)
                                                                .addComponent(emailField, GroupLayout.PREFERRED_SIZE, 284, GroupLayout.PREFERRED_SIZE))
                                                        .addGroup(GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                                                                .addComponent(pwdText, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                                                .addPreferredGap(LayoutStyle.ComponentPlacement.UNRELATED)
                                                                .addGroup(layout.createParallelGroup(GroupLayout.Alignment.LEADING)
                                                                        .addComponent(pwdField, GroupLayout.PREFERRED_SIZE, 284, GroupLayout.PREFERRED_SIZE)
                                                                        .addComponent(loginBtn, GroupLayout.PREFERRED_SIZE, 102, GroupLayout.PREFERRED_SIZE)
                                                                        .addComponent(signText))))))
                                .addContainerGap(86, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
                layout.createParallelGroup(GroupLayout.Alignment.LEADING)
                        .addGroup(layout.createSequentialGroup()
                                .addContainerGap()
                                .addComponent(signInLabel, GroupLayout.PREFERRED_SIZE, 25, GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(subTitleLabel, GroupLayout.PREFERRED_SIZE, 31, GroupLayout.PREFERRED_SIZE)
                                .addGap(34)
                                .addGroup(layout.createParallelGroup(GroupLayout.Alignment.BASELINE)
                                        .addComponent(emaliText)
                                        .addComponent(emailField, GroupLayout.PREFERRED_SIZE, 29, GroupLayout.PREFERRED_SIZE))
                                .addPreferredGap(LayoutStyle.ComponentPlacement.UNRELATED)
                                .addGroup(layout.createParallelGroup(GroupLayout.Alignment.LEADING)
                                        .addComponent(pwdText)
                                        .addComponent(pwdField, GroupLayout.PREFERRED_SIZE, 29, GroupLayout.PREFERRED_SIZE))
                                .addGap(29)
                                .addComponent(loginBtn)
                                .addGap(32)
                                .addComponent(signText)
                                .addContainerGap(109, Short.MAX_VALUE))
        );

        pack();
    }

    /**
     * Adds a listener to the login
     */
    private void addButtonListeners(ActionListener listener) {
        loginBtn.addActionListener(listener);
        signText.addMouseListener(new MouseListener() {
            @Override
            public void mouseClicked(MouseEvent e) {
                new RegisterUI(data);
            }

            @Override
            public void mousePressed(MouseEvent e) {

            }

            @Override
            public void mouseReleased(MouseEvent e) {

            }

            @Override
            public void mouseEntered(MouseEvent e) {

            }

            @Override
            public void mouseExited(MouseEvent e) {

            }
        });
    }

    private class ButtonListener implements ActionListener {

        /**
         * @see ActionListener#actionPerformed(ActionEvent)
         */
        public void actionPerformed(ActionEvent e) {

            JButton source = (JButton) e.getSource();
            if (source == loginBtn) {
                toLogin(source);
            }
        }

        private void toLogin(Component component) {
            if (checkNull(emailField.getText())){
                alertMsg(component,"please enter name");
                return;
            }
            if (checkNull(new String(pwdField.getPassword()))){
                alertMsg(component,"please enter password");
                return;
            }
            User user = data.get(emailField.getText());
            if (user == null){
                alertMsg(component,"name not exists");
                return;
            }
            if (user.getPassword().equals(MD5Utils.stringToMD5(new String(pwdField.getPassword())))){
                alertMsg(component,"Login success");
                new TradeUI(new AssetInfoData(new AssetFileDataSource()),user);
            }else{
                alertMsg(component,"password ERROR!");
            }
        }
    }

    public static void main(String args[]) {
        new LoginUI(new UserInfoData(new UserFileDataSource()));
    }

}
