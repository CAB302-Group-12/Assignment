package common;

import utils.MD5Utils;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class RegisterUI extends BaseFrame {

    private JTextField emailField;
    private JLabel emaliLabel;
    private JTextField organField;
    private JLabel organLabel;
    private JTextField pwdField;
    private JLabel pwdLabel;
    private JButton registerBtn;
    private JLabel titleJlabel;
    private JTextField typeField;
    private JLabel typeLabel;
    private JTextField usernameField;
    private JLabel usernameLabel;

    UserInfoData data;

    public RegisterUI(UserInfoData data) {
        this.data = data;
        initComponents();
        clearFields();
        addButtonListeners(new ButtonListener());
        setTitle("Register");

        showCenter();
        setVisible(true);
    }



    /**
     * Sets the text in the address text fields to the empty string.
     */
    private void clearFields() {
        usernameField.setText("");
        emailField.setText("");
        pwdField.setText("");
        typeField.setText("");
        organField.setText("");
    }


    private void initComponents() {

        titleJlabel = new JLabel();
        usernameLabel = new JLabel();
        usernameField = new JTextField();
        pwdLabel = new JLabel();
        pwdField = new JTextField();
        organLabel = new JLabel();
        organField = new JTextField();
        registerBtn = new JButton();
        typeLabel = new JLabel();
        typeField = new JTextField("normal");
        emailField = new JTextField();
        emaliLabel = new JLabel();

        titleJlabel.setFont(new Font("Microsoft JhengHei", 1, 18));
        titleJlabel.setText("Register");

        usernameLabel.setFont(new Font("Microsoft JhengHei", 0, 18));
        usernameLabel.setText("Username");

        pwdLabel.setFont(new Font("Microsoft JhengHei", 0, 18));
        pwdLabel.setText("Password");

        organLabel.setFont(new Font("Microsoft JhengHei", 0, 18));
        organLabel.setText("Organization");

        registerBtn.setBackground(new Color(153, 204, 255));
        registerBtn.setText("Register!");

        typeLabel.setFont(new Font("Microsoft JhengHei", 0, 18));
        typeLabel.setText("UserType:normal");

        emaliLabel.setFont(new Font("Microsoft JhengHei", 0, 18));
        emaliLabel.setText("Email");

        GroupLayout layout = new GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
                layout.createParallelGroup(GroupLayout.Alignment.LEADING)
                        .addGroup(layout.createSequentialGroup()
                                .addGroup(layout.createParallelGroup(GroupLayout.Alignment.LEADING)
                                        .addGroup(layout.createSequentialGroup()
                                                .addGap(152, 152, 152)
                                                .addComponent(titleJlabel))
                                        .addGroup(layout.createSequentialGroup()
                                                .addGap(123, 123, 123)
                                                .addComponent(registerBtn, GroupLayout.PREFERRED_SIZE, 107, GroupLayout.PREFERRED_SIZE)))
                                .addContainerGap(GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                        .addGroup(GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                                .addGap(0, 71, Short.MAX_VALUE)
                                .addGroup(layout.createParallelGroup(GroupLayout.Alignment.LEADING, false)
                                        .addComponent(usernameLabel)
                                        .addComponent(pwdLabel)
                                        .addComponent(organLabel)
                                        .addComponent(usernameField)
                                        .addComponent(pwdField)
                                        .addComponent(organField)
                                        .addComponent(emaliLabel)
                                        .addComponent(emailField, GroupLayout.PREFERRED_SIZE, 270, GroupLayout.PREFERRED_SIZE)
                                        .addComponent(typeLabel))
                                .addGap(59, 59, 59))
        );
        layout.setVerticalGroup(
                layout.createParallelGroup(GroupLayout.Alignment.LEADING)
                        .addGroup(layout.createSequentialGroup()
                                .addContainerGap()
                                .addComponent(titleJlabel)
                                .addGap(41, 41, 41)
                                .addComponent(usernameLabel)
                                .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(usernameField, GroupLayout.PREFERRED_SIZE, 33, GroupLayout.PREFERRED_SIZE)
                                .addGap(18, 18, 18)
                                .addComponent(pwdLabel)
                                .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(pwdField, GroupLayout.PREFERRED_SIZE, 33, GroupLayout.PREFERRED_SIZE)
                                .addGap(18, 18, 18)
                                .addComponent(emaliLabel)
                                .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(emailField, GroupLayout.PREFERRED_SIZE, 33, GroupLayout.PREFERRED_SIZE)
                                .addGap(18, 18, 18)
                                .addComponent(typeLabel)
                                .addPreferredGap(LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(organLabel)
                                .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(organField, GroupLayout.PREFERRED_SIZE, 33, GroupLayout.PREFERRED_SIZE)
                                .addGap(31, 31, 31)
                                .addComponent(registerBtn, GroupLayout.PREFERRED_SIZE, 32, GroupLayout.PREFERRED_SIZE)
                                .addContainerGap(101, Short.MAX_VALUE))
        );

        pack();
    }

    /**
     * Adds a listener to the login
     */
    private void addButtonListeners(ActionListener listener) {
        registerBtn.addActionListener(listener);
    }

    private class ButtonListener implements ActionListener {

        /**
         * @see ActionListener#actionPerformed(ActionEvent)
         */
        public void actionPerformed(ActionEvent e) {

            JButton source = (JButton) e.getSource();
            if (source == registerBtn) {
                toLogin(source);
            }
        }

        private void toLogin(Component component) {
            if (checkNull(usernameField.getText())){
                alertMsg(component,"please enter name");
                return;
            }
            if (checkNull(pwdField.getText())){
                alertMsg(component,"please enter password");
                return;
            }
            if (checkNull(emailField.getText())){
                alertMsg(component,"please enter email");
                return;
            }
            if (checkNull(organField.getText())){
                alertMsg(component,"please enter organization");
                return;
            }
            User user = data.get(usernameField.getText());
            if (user != null){
                alertMsg(component,"name is exists");
                return;
            }
            User p = new User(usernameField.getText(), emailField.getText(), MD5Utils.stringToMD5(pwdField
                    .getText()) , "normal", organField.getText());
            data.add(p);
            alertMsg(component,"register success");
            setVisible(false);
        }
    }
}
