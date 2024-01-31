
package bank.management.system;

import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import java.sql.*;

class MiniStatement extends JFrame implements ActionListener{

    MiniStatement(String pinnumber){
        
        setLayout(null);
        setTitle("Mini Statement");
        JLabel mini = new JLabel();
        add(mini);
        
        JLabel bank = new JLabel("Bank Of India");
        bank.setBounds(150,20,300,20);
        bank.setFont(new Font("Helvetica", Font.BOLD, 16));
        add(bank);
        
        JLabel card = new JLabel();
        card.setBounds(20,120,300,20);
        card.setFont(new Font("Helvetica", Font.BOLD, 12));
        add(card);
        
        JLabel balance = new JLabel();
        balance.setBounds(95,450,300,20);
        balance.setFont(new Font("Helvetica", Font.BOLD, 14));
        add(balance);
        
        try{
            Conn c = new Conn();
            ResultSet rs = c.s.executeQuery("select * from login where pin = '"+pinnumber+"'");
            while(rs.next()){
                card.setText("Card Number: " + rs.getString("cardNumber").substring(0, 4) + "XXXXXXXX" + rs.getString("cardNumber").substring(12));
            }
        }catch(Exception e){
            System.out.println(e);
        }
        
        try{
            int baln = 0;
            Conn c1  = new Conn();
            ResultSet rs = c1.s.executeQuery("select * from bank where pin = '"+pinnumber+"'");
            while(rs.next()){
                mini.setText(mini.getText() + "<html>"+rs.getString("date")+ "&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;" + rs.getString("type") + "&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;" + rs.getString("amount") + "<br><br><html>");
                if(rs.getString("type").equals("Deposit")){
                    baln += Integer.parseInt(rs.getString("amount"));
                }else{
                    baln -= Integer.parseInt(rs.getString("amount"));
                }
            }
            balance.setText("Your total Balance is Rs "+baln);
        }catch(Exception e){
            e.printStackTrace();
        }
        
        mini.setBounds(20,160,400,260);
        
        setSize(400,600);
        setLocation(20,20);
        getContentPane().setBackground(Color.WHITE);
        setVisible(true);
    }
    
    
    @Override
    public void actionPerformed(ActionEvent ae) {
      
    }
    
    public static void main(String[] args) {
        new MiniStatement("").setVisible(true);
    }
}