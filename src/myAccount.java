package common;
import serialisationExercise.AssetFileDataSource;

import javax.swing.*;
import java.awt.*;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;

public class myAccount extends BaseFrame{

    private JButton historyBtn;
    private JButton manageBtn;
    private JButton changeBtn;
    UserInfoData data;
    OrgBalanceInfoData orgBalanceInfoData;

    public myAccount(UserInfoData data, User loginUser)
    {
        this.data = data;
        this.orgBalanceInfoData = new OrgBalanceInfoData(new OrgBalanceFileDataSource());
        super.loginUser = loginUser;

        initComponents();

        addWindowListener(new WindowAdapter() {
            public void windowClosing(WindowEvent e) {
                closeFrame();
            }

        });

        addButtonListeners_history();
        addButtonListeners_manageUI();


        setTitle("My Account");
        setLocationRelativeTo(null);
        setVisible(true);
    }

    private void closeFrame() {
        this.dispose();
    }

    private void initComponents(){

        historyBtn = new JButton();
        manageBtn = new JButton();
        changeBtn = new JButton();

        /**
         *  Create a label 1 and a label 2 on panel
         */
        JLabel label1 = new JLabel("Account Name: " + loginUser.getName());
        JLabel label2 = new JLabel("Credit Balance: " + orgBalanceInfoData.get(loginUser.getOrganization()).getCredit());


        /**
         * Create the button and button 2 on panel
         */
        //JButton button1 = new JButton("Manage Products");
        //JButton button2 = new JButton("Change Password");
        //JButton button3 = new JButton("History");



        manageBtn.setFont(new Font("Microsoft JhengHei", 0, 14));
        manageBtn.setText("Manage Products");

        changeBtn.setFont(new Font("Microsoft JhengHei", 0, 14));
        changeBtn.setText("Change Password");

        historyBtn.setFont(new Font("Microsoft JhengHei", 0, 14));
        historyBtn.setText("History");

        GroupLayout layout = new GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setAutoCreateGaps(true);
        layout.setAutoCreateContainerGaps(true);

        layout.setHorizontalGroup(
                layout.createParallelGroup(GroupLayout.Alignment.LEADING)
                        .addGroup(layout.createSequentialGroup()

                                .addComponent(manageBtn)
                                .addGap(10)
                                .addComponent(changeBtn)
                                .addGap(10)
                                .addComponent(historyBtn))

                        .addGroup(layout.createSequentialGroup()
                                .addGap(50)
                                .addComponent(label1, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addGap(50)
                                .addComponent(label2, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)

        ));
        layout.setVerticalGroup(layout.createSequentialGroup()
                .addGap(50)
                .addGroup(layout.createParallelGroup(GroupLayout.Alignment.BASELINE).addComponent(label1).addComponent(label2))
                .addGap(50)
                .addGroup(layout.createParallelGroup(GroupLayout.Alignment.BASELINE).addComponent(manageBtn).addComponent(changeBtn).addComponent(historyBtn))
                .addContainerGap());
        pack();
    }
    /** public static void main(String[] args) {
        new myAccount();
    }
     **/




    private void addButtonListeners_history() {
        historyBtn.addMouseListener(new MouseListener() {
            @Override
            public void mouseClicked(MouseEvent e) {

                new HistoryUI(new HistoryInfoData(new HistoryFileDataSource(),loginUser), loginUser);

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




    private void addButtonListeners_manageUI() {
        manageBtn.addMouseListener(new MouseListener() {
            @Override
            public void mouseClicked(MouseEvent e) {

                new manageUI(new AssetInfoData(new AssetFileDataSource()),loginUser);

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










}
