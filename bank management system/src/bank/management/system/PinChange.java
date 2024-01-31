
package bank.management.system;

import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import java.sql.*;

public class PinChange extends JFrame implements ActionListener{
    String pinnumber;
    JLabel text, pinText,rePinText;
    JPasswordField pin, repin;
    JButton change, back;
    PinChange(String pinnumber){
        this.pinnumber = pinnumber;
        setLayout(null);
        setTitle("Pin Change");
        text = new JLabel("CHANGE YOUR PIN");
        text.setFont(new Font("Helvetica", Font.BOLD, 26));
        text.setBounds(350,150,700,30);
        add(text);
        
        pinText = new JLabel("New PIN:");
        pinText.setFont(new Font("Helvetica", Font.BOLD, 16));
        pinText.setBounds(240,250,200,30);
        add(pinText);
        
        pin = new JPasswordField();
        pin.setFont(new Font("Helvetica", Font.BOLD, 14));
        pin.setBounds(350,250,400,30);
        add(pin);
        
        rePinText = new JLabel("Re-Enter New PIN:");
        rePinText.setFont(new Font("Helvetica", Font.BOLD, 16));
        rePinText.setBounds(240,300,200,30);
        add(rePinText);
        
        repin = new JPasswordField();
        repin.setFont(new Font("Helvetica", Font.BOLD, 14));
        repin.setBounds(410,300,340,30);
        add(repin);   
        
        change = new JButton("Change");
        change.setBounds(400,380,200,30);
        change.setFocusPainted(false);
        change.setFont(new Font("Helvetica", Font.BOLD, 16));
        change.addActionListener(this);
        add(change);
        
        
        back = new JButton("Back");
        back.setBounds(400,419,200,30);
        back.setFocusPainted(false);
        back.setFont(new Font("Helvetica", Font.BOLD, 16));
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
            String npin = pin.getText();
            String rpin = repin.getText();
            
            if(!npin.equals(rpin)){
                JOptionPane.showMessageDialog(null, "Entered PIN does not match");
                return;
            }
            
            if(ae.getSource()==change){
                if (pin.getText().equals("")){
                    JOptionPane.showMessageDialog(null, "Enter New PIN");
                }
                if (repin.getText().equals("")){
                    JOptionPane.showMessageDialog(null, "Re-Enter new PIN");
                }
                
                Conn c1 = new Conn();
                String q1 = "update bank set pin = '"+rpin+"' where pin = '"+pinnumber+"' ";
                String q2 = "update login set pin = '"+rpin+"' where pin = '"+pinnumber+"' ";
                String q3 = "update signupThree set pin = '"+rpin+"' where pin = '"+pinnumber+"' ";

                c1.s.executeUpdate(q1);
                c1.s.executeUpdate(q2);
                c1.s.executeUpdate(q3);

                JOptionPane.showMessageDialog(null, "PIN changed successfully");
                setVisible(false);
                new Transactions(rpin).setVisible(true);
            
            }else if(ae.getSource()==back){
                new Transactions(pinnumber).setVisible(true);
                setVisible(false);
            }
        }catch(Exception e){
            e.printStackTrace();
        }
    }
    
    public static void main(String[] args){
        new PinChange("").setVisible(true);
    }
}
