package bank.management.system;

import java.awt.*;
import java.awt.event.*;
import java.sql.ResultSet;
import javax.swing.*;
import java.util.*;

class BalanceEnquiry extends JFrame implements ActionListener {

    JButton back;
    JLabel checkBalance;
    String pin;

    BalanceEnquiry(String pin) {
        this.pin = pin;
        setTitle("Balance Enquiry");

        checkBalance = new JLabel();
        checkBalance.setFont(new Font("Helvetica", Font.BOLD, 16));

        back = new JButton("Back");

        setLayout(null);

        checkBalance.setBounds(300,350,500,30);
        add(checkBalance);

        back.setBounds(365, 400, 150, 35);
        back.setFocusPainted(false);
        add(back);
        int balance = 0;
        try{
            Conn c1 = new Conn();
            ResultSet rs = c1.s.executeQuery("select * from bank where pin = '"+pin+"'");
            while (rs.next()) {
                if (rs.getString("type").equals("Deposit")) {
                    balance += Integer.parseInt(rs.getString("amount"));
                } else {
                    balance -= Integer.parseInt(rs.getString("amount"));
                }
            }
        }catch(Exception e){}
        
        checkBalance.setText("Your Current Account Balance is Rs "+balance);

        back.addActionListener(this);

        setSize(900,900);
        setLocation(300,0);
        getContentPane().setBackground(Color.WHITE);
        setVisible(true);
    }

    @Override
    public void actionPerformed(ActionEvent ae) {
        setVisible(false);
        new Transactions(pin).setVisible(true);
    }

    public static void main(String[] args) {
        new BalanceEnquiry("").setVisible(true);
    }
}