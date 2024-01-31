package bank.management.system;

import java.awt.event.ActionListener;
import javax.swing.JFrame;
import java.awt.event.*;
import javax.swing.JLabel;
import java.awt.Color;
import java.awt.Font;
import javax.swing.ButtonGroup;
import javax.swing.JButton;
import javax.swing.JCheckBox;
import javax.swing.JRadioButton;
import javax.swing.JOptionPane;
import java.util.*;



public class SignUpThree extends JFrame implements ActionListener{

    JRadioButton r1,r2,r3,r4;
    JCheckBox c1,c2,c3,c4,c5,c6,c7;
    JButton submit, cancel;
    String formno;
    SignUpThree(String formno) {
        this.formno = formno;
        setLayout(null);
        setTitle("Select Services Page");
        
        JLabel l1 = new JLabel("ACCOUNT DETAILS - Page 3");
        l1.setFont(new Font("Helvetica", Font.BOLD, 20));
        l1.setBounds(280,40,400,40);
        add(l1);
        
        JLabel accountType = new JLabel("Account type: ");
        accountType.setFont(new Font("Helvetica", Font.BOLD, 20));
        accountType.setBounds(100,140,200,30);
        add(accountType);
        
        r1 = new JRadioButton(" Saving Account");
        r1.setFont(new Font("Helvetica", Font.BOLD, 16));
        r1.setBounds(100,180,150,20);
        r1.setBackground(Color.WHITE);
        add(r1);
        
        r2 = new JRadioButton(" Fixed Deposit Account");
        r2.setFont(new Font("Helvetica", Font.BOLD, 16));
        r2.setBounds(350,180,200,20);
        r2.setBackground(Color.WHITE);
        add(r2);
        
        r3 = new JRadioButton(" Current Account");
        r3.setFont(new Font("Helvetica", Font.BOLD, 16));
        r3.setBounds(100,220,250,20);
        r3.setBackground(Color.WHITE);
        add(r3);
        
        r4 = new JRadioButton(" Recurring Deposit Account");
        r4.setFont(new Font("Helvetica", Font.BOLD, 16));
        r4.setBounds(350,220,250,20);
        r4.setBackground(Color.WHITE);
        add(r4);
        
        ButtonGroup groupAccount = new ButtonGroup();
        groupAccount.add(r1);
        groupAccount.add(r2);
        groupAccount.add(r3);
        groupAccount.add(r4);
        
        JLabel card = new JLabel("Card Number: ");
        card.setFont(new Font("Helvetica", Font.BOLD, 20));
        card.setBounds(100,265,200,30);
        add(card);
        
        JLabel number = new JLabel("XXXX-XXXX-XXXX-4144");
        number.setFont(new Font("Helvetica", Font.BOLD, 20));
        number.setBounds(330,265,300,30);
        add(number);
        
        JLabel carddetail = new JLabel("Your 16 digit card number");
        carddetail.setFont(new Font("Helvetica", Font.BOLD, 12));
        carddetail.setBounds(100,295,300,20);
        add(carddetail);
        
        JLabel pin = new JLabel("PIN: ");
        pin.setFont(new Font("Helvetica", Font.BOLD, 20));
        pin.setBounds(100,335,200,30);
        add(pin);
        
        JLabel pnumber = new JLabel("XXXX");
        pnumber.setFont(new Font("Helvetica", Font.BOLD, 20));
        pnumber.setBounds(330,335,300,30);
        add(pnumber);
        
        JLabel pindetail = new JLabel("Your 4 digit pin number");
        pindetail.setFont(new Font("Helvetica", Font.BOLD, 12));
        pindetail.setBounds(100,365,300,20);
        add(pindetail);
        
        JLabel services = new JLabel("Services required: ");
        services.setFont(new Font("Helvetica", Font.BOLD, 20));
        services.setBounds(100,405,400,30);
        add(services);
        
        c1 = new JCheckBox(" ATM CARD");
        c1.setFont(new Font("Helvetica", Font.BOLD, 16));
        c1.setBounds(100,455,200,30);
        c1.setBackground(Color.WHITE);
        add(c1);

        
        c2 = new JCheckBox(" Internet Banking");
        c2.setFont(new Font("Helvetica", Font.BOLD, 16));
        c2.setBounds(350,455,200,30);
        c2.setBackground(Color.WHITE);
        add(c2);
        
        c3 = new JCheckBox(" Mobile Banking");
        c3.setFont(new Font("Helvetica", Font.BOLD, 16));
        c3.setBounds(100,505,200,30);
        c3.setBackground(Color.WHITE);
        add(c3);
        
        c4 = new JCheckBox(" EMAIL/SMS Alerts");
        c4.setFont(new Font("Helvetica", Font.BOLD, 16));
        c4.setBounds(350,505,200,30);
        c4.setBackground(Color.WHITE);
        add(c4);
        
        c5 = new JCheckBox(" Cheque Book");
        c5.setFont(new Font("Helvetica", Font.BOLD, 16));
        c5.setBounds(100,555,200,30);
        c5.setBackground(Color.WHITE);
        add(c5);
        
        c6 = new JCheckBox(" E-Statement");
        c6.setFont(new Font("Helvetica", Font.BOLD, 16));
        c6.setBounds(350,555,200,30);
        c6.setBackground(Color.WHITE);
        add(c6);
        
        c7 = new JCheckBox(" I HEREBY DECLARE THAT THE ABOVE ENTERED DETAILS ARE CORRECT TO THE BEST OF MY KNOWLEDGE.");
        c7.setFont(new Font("Helvetica", Font.BOLD, 13));
        c7.setBounds(100,605,800,30);
        c7.setBackground(Color.WHITE);
        add(c7);
        
        submit = new JButton("Submit");
        submit.setBackground(Color.BLACK);
        submit.setForeground(Color.WHITE);
        submit.setFont(new Font("Helvetica", Font.BOLD, 14));
        submit.setFocusPainted(false);
        submit.setBounds(250,655,100,30);
        add(submit);
        
        cancel = new JButton("Cancel");
        cancel.setBackground(Color.BLACK);
        cancel.setForeground(Color.WHITE);
        cancel.setFont(new Font("Helvetica", Font.BOLD, 14));
        cancel.setFocusPainted(false);
        cancel.setBounds(420,655,100,30);
        add(cancel);
        
        setSize(850,880);
        setLocation(350,0);
        setVisible(true);
        submit.addActionListener(this);
        cancel.addActionListener(this);
        getContentPane().setBackground(Color.WHITE);
    }
    
    
    @Override
    public void actionPerformed(ActionEvent ae){
        String accounttype = null;
        if(r1.isSelected()){ 
            accounttype = "Saving Account";
        }
        else if(r2.isSelected()){ 
            accounttype = "Fixed Deposit Account";
        }
        else if(r3.isSelected()){ 
            accounttype = "Current Account";
        }else if(r4.isSelected()){ 
            accounttype = "Recurring Deposit Account";
        }
        
        Random ran = new Random();
        long first7 = (ran.nextLong() % 90000000L) + 5040936000000000L;
        String cardnumber = "" + Math.abs(first7);
        
        long first3 = (ran.nextLong() % 9000L) + 1000L;
        String pinnumber = "" + Math.abs(first3);
        
        String facility = "";
        if(c1.isSelected()){ 
            facility = facility + " ATM Card";
        }
        if(c2.isSelected()){ 
            facility = facility + " Internet Banking";
        }
        if(c3.isSelected()){ 
            facility = facility + " Mobile Banking";
        }
        if(c4.isSelected()){ 
            facility = facility + " EMAIL/SMS Alerts";
        }
        if(c5.isSelected()){ 
            facility = facility + " Cheque Book";
        }
        if(c6.isSelected()){ 
            facility = facility + " E-Statement";
        }
        
        try{
            if(ae.getSource()==submit){
                
                if(accounttype.equals("")){
                    JOptionPane.showMessageDialog(null, "Fill all the required fields");
                }else{
                    Conn c = new Conn();
                    String q1 = "insert into signupThree values('"+formno+"','"+accounttype+"','"+cardnumber+"','"+pinnumber+"','"+facility+"')";  
                    String q2 = "insert into login values('"+formno+"','"+cardnumber+"','"+pinnumber+"')";
                    c.s.executeUpdate(q1);
                    c.s.executeUpdate(q2);
                    JOptionPane.showMessageDialog(null, "Card Number: " + cardnumber + "\n Pin:"+ pinnumber);
                    
                }
                setVisible(false);
                new Deposit(pinnumber).setVisible(false);
            
            }else if(ae.getSource()==cancel){
                setVisible(false);
                new Login().setVisible(true);
            }
            
        }catch(Exception ex){
            ex.printStackTrace();
        }
        
        
        
    }
    
    public static void main(String[] args) {
        new SignUpThree("").setVisible(true);
    }
}
