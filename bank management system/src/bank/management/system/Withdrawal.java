
package bank.management.system;

import java.awt.Font;
import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.util.*;

public class Withdrawal extends JFrame implements ActionListener{

    JTextField amount;
    JButton withdraw, back;
    String pin;
    public Withdrawal(String pin) {
        this.pin = pin;
        setLayout(null);
        setTitle("Withdrawal");
        JLabel text = new JLabel("Enter the amount you want to withdraw:");
        text.setFont(new Font("Helvetica", Font.BOLD, 16));
        text.setBounds(300,150,400,30);
        add(text);
        
        amount = new JTextField();
        amount.setFont(new Font("Helvetica", Font.BOLD, 20));
        amount.setBounds(300,200,300,30);
        add(amount);
        
        withdraw = new JButton("Withdraw");
        withdraw.setBounds(355,275,200,30);
        withdraw.setBackground(new Color(3,6,55));
        withdraw.setForeground(Color.WHITE);
        withdraw.setFont(new Font("Helvetica", Font.BOLD, 16));
        withdraw.setFocusPainted(false);
        withdraw.addActionListener(this);
        add(withdraw);
        
        back = new JButton("Back");
        back.setBounds(355,315,200,30);
        back.setBackground(new Color(3,6,55));
        back.setForeground(Color.WHITE);
        back.setFont(new Font("Helvetica", Font.BOLD, 16));
        back.setFocusPainted(false);
        back.addActionListener(this);
        add(back);
        
        setSize(900,500);
        setLocation(300,0);
        getContentPane().setBackground(Color.WHITE);
        setVisible(true);
    }
    
    @Override
    public void actionPerformed(ActionEvent ae){
        try{
            String number = amount.getText();
            Date date = new Date();
            if(ae.getSource()==withdraw){
                if(number.equals("")){
                    JOptionPane.showMessageDialog(null, "Please enter the Amount to you want to Deposit");
                }else{
                    Conn c1 = new Conn();
                    c1.s.executeUpdate("insert into bank values('"+pin+"', '"+date+"', 'Withdrawal', '"+number+"')");
                    JOptionPane.showMessageDialog(null, "Rs. "+number+" withdrawn Successfully");
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
        new Withdrawal("").setVisible(true);;
    }
}
