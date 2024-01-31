
package bank.management.system;

import java.awt.Font;
import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.util.*;

public class Deposit extends JFrame implements ActionListener{

    JTextField amount;
    JButton deposit, back;
    String pin;
    public Deposit(String pin) {
        this.pin = pin;
        setLayout(null);
        setTitle("Deposit Amount");
        JLabel text = new JLabel("Enter the amount you want to deposit:");
        text.setFont(new Font("Helvetica", Font.BOLD, 16));
        text.setBounds(300,175,300,30);
        add(text);
        
        amount = new JTextField();
        amount.setFont(new Font("Helvetica", Font.BOLD, 20));
        amount.setBounds(300,225,300,30);
        add(amount);
        
        deposit = new JButton("Deposit");
        deposit.setBounds(355,300,200,30);
        deposit.setBackground(new Color(3,6,55));
        deposit.setForeground(Color.WHITE);
        deposit.setFocusPainted(false);
        deposit.addActionListener(this);
        add(deposit);
        
        back = new JButton("Back");
        back.setBounds(355,340,200,30);
        back.setBackground(new Color(3,6,55));
        back.setForeground(Color.WHITE);
        back.setFocusPainted(false);
        back.addActionListener(this);
        add(back);
        
        setSize(900,900);
        setLocation(300,0);
        getContentPane().setBackground(Color.WHITE);
        setVisible(true);
    }
    
    @Override
    public void actionPerformed(ActionEvent ae){
        try{
            String number = amount.getText();
            Date date = new Date();
            if(ae.getSource()==deposit){
                if(number.equals("")){
                    JOptionPane.showMessageDialog(null, "Please enter the Amount to you want to Deposit");
                }else{
                    Conn c1 = new Conn();
                    c1.s.executeUpdate("insert into bank values('"+pin+"', '"+date+"', 'Deposit', '"+number+"')");
                    JOptionPane.showMessageDialog(null, "Rs. "+number+" Deposited Successfully");
                    setVisible(false);
                    new Transactions(pin).setVisible(true);
                }
        }else if(ae.getSource()==back){
            setVisible(false);
            new Transactions(pin).setVisible(true);
            }
            
        }catch(Exception e){
                e.printStackTrace();
                }
    }
    
    public static void main(String[] args) {
        new Deposit("").setVisible(true);
    }
}
