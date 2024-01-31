
package bank.management.system;
import java.awt.event.ActionListener;
import javax.swing.JFrame;
import java.awt.event.*;
import javax.swing.JLabel;
import java.awt.Color;
import java.awt.Font;
import java.awt.*;
import java.awt.color.ColorSpace;
import javax.swing.ButtonGroup;
import javax.swing.JButton;
import javax.swing.JCheckBox;
import javax.swing.JRadioButton;
import javax.swing.JOptionPane;
import java.util.*;
import javax.swing.ImageIcon;

public class Transactions extends JFrame implements ActionListener{

    JButton deposit,cashWithdrawal,fastCash,miniStatement,pinChange,balanceEnquiry,exit;
    JLabel text;
    String pin;
    public Transactions(String pin) {
        this.pin=pin;
        setLayout(null);
        setTitle("Transactions");

        text = new JLabel("Please select your choice: ");
        text.setBounds(300,175,700,30);
        text.setFont(new Font("Helvetica", Font.BOLD, 24));
        add(text);
        
        deposit = new JButton("Deposit");
        deposit.setFont(new Font("Helvetica", Font.BOLD, 16));
        deposit.setBounds(240,250,200,30);
        deposit.setFocusPainted(false);
        add(deposit);
        
        cashWithdrawal = new JButton("Cash Withdrawal");
        cashWithdrawal.setFont(new Font("Helvetica", Font.BOLD, 16));
        cashWithdrawal.setBounds(470,250,200,30);
        cashWithdrawal.setFocusPainted(false);
        add(cashWithdrawal);
        
        fastCash = new JButton("Fast cash");
        fastCash.setFont(new Font("Helvetica", Font.BOLD, 16));
        fastCash.setBounds(240,300,200,30);
        fastCash.setFocusPainted(false);
        add(fastCash);
        
        miniStatement = new JButton("Mini statement");
        miniStatement.setFont(new Font("Helvetica", Font.BOLD, 16));
        miniStatement.setBounds(470,300,200,30);
        miniStatement.setFocusPainted(false);
        add(miniStatement);
        
        pinChange = new JButton("Pin change");
        pinChange.setFont(new Font("Helvetica", Font.BOLD, 16));
        pinChange.setBounds(240,350,200,30);
        pinChange.setFocusPainted(false);
        add(pinChange);
        
        balanceEnquiry = new JButton("Balance enquiry");
        balanceEnquiry.setFont(new Font("Helvetica", Font.BOLD, 16));
        balanceEnquiry.setBounds(470,350,200,30);
        balanceEnquiry.setFocusPainted(false);
        add(balanceEnquiry);

        exit = new JButton("EXIT");
        exit.setFont(new Font("Helvetica", Font.BOLD, 16));
        exit.setBounds(370,400,200,30);
        exit.setFocusPainted(false);
        add(exit);
        
        setSize(900,600);
        setLocation(300,0);
        setVisible(true);
        getContentPane().setBackground(Color.WHITE);
        
        deposit.addActionListener(this);
        cashWithdrawal.addActionListener(this);
        fastCash.addActionListener(this);
        miniStatement.addActionListener(this);
        pinChange.addActionListener(this);
        balanceEnquiry.addActionListener(this);
        exit.addActionListener(this);
    }
    
    
    @Override
    public void actionPerformed(ActionEvent ae){
        if(ae.getSource()==exit){
            System.exit(0);
        }else if(ae.getSource()== deposit){
            setVisible(false);
            new Deposit(pin).setVisible(true);
        }else if(ae.getSource()== cashWithdrawal){
            setVisible(false);
            new Withdrawal(pin).setVisible(true);
        }else if(ae.getSource()== fastCash){
            setVisible(false);
            new FastCash(pin).setVisible(true);
        }else if(ae.getSource()== pinChange){
            setVisible(false);
            new PinChange(pin).setVisible(true);
        }else if(ae.getSource()== balanceEnquiry){
            setVisible(false);
            new BalanceEnquiry(pin).setVisible(true);
        }
        else if(ae.getSource()== miniStatement){
            setVisible(false);
            new MiniStatement(pin).setVisible(true);
        }
    }
    
    
    public static void main(String[] args) {
        new Transactions("");
    }
    
    
}
