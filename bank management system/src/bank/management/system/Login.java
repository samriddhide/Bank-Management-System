package bank.management.system;

import javax.swing.*;
import java.awt.*;
import java.awt.color.ColorSpace;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.*;

public class Login extends JFrame implements ActionListener{
    JButton login, clear, signup;//globally declaring burron so that they can be used in other functions
    JTextField cardTextField; //globally declaring as these will be required in another function to define logic
    JPasswordField pinTextField;
    //constructor
    Login(){
        setLayout(null);//so that we can customize our project icon location and tell java we dont want to use default layout
        setTitle("Banking Management System");
        ImageIcon logo = new ImageIcon(ClassLoader.getSystemResource("images/projectlogo.png"));
        Image image = logo.getImage().getScaledInstance(100, 100, Image.SCALE_DEFAULT);//scaling the image
        ImageIcon scaledImage = new ImageIcon(image);
        
        JLabel label = new JLabel(scaledImage);
        label.setBounds(70, 20, 100, 100);//aligns our logo properly 
        add(label);
        
        JLabel text = new JLabel("Online Banking Portal");
        text.setFont(new Font("Helvetica", Font.BOLD,38));
        text.setBounds(200, 40, 700, 60);
        add(text);
        
        //card number
        JLabel cardNumber = new JLabel("Card Number: ");
        cardNumber.setFont(new Font("Helvetica", Font.BOLD,25));
        cardNumber.setBounds(125,150,375,30);
        add(cardNumber);
        
        //box to take input of card number
        cardTextField = new JTextField();
        cardTextField.setBounds(300,150,230,30);
        cardTextField.setFont(new Font("Arial", Font.BOLD, 14));
        add(cardTextField);
        
        //pin
        JLabel pin = new JLabel("Pin: ");
        pin.setFont(new Font("Helvetica", Font.BOLD,25));
        pin.setBounds(125,220,375,30);
        add(pin);
        
        //box to take input of pin number
        pinTextField = new JPasswordField();
        pinTextField.setBounds(300,220,230,30);
        pinTextField.setFont(new Font("Arial", Font.BOLD, 14));
        add(pinTextField);
        
        //login button
        login = new JButton("Sign in");
        login.setBounds(300,300,100,30);
        login.setBackground(new Color(3,6,55));
        login.setForeground(Color.WHITE);
        login.setFont(new Font("Helvetica", Font.BOLD,14));
        login.setFocusPainted(false);
        login.addActionListener(this);
        add(login);
        
        //clear button
        clear = new JButton("Clear");
        clear.setBounds(430,300,100,30);
        clear.setBackground(new Color(3,6,55));
        clear.setForeground(Color.WHITE);
        clear.setFont(new Font("Helvetica", Font.BOLD,14));
        clear.addActionListener(this);
        clear.setFocusPainted(false);
        add(clear);
        
        //signup button
        signup = new JButton("SIGN UP");
        signup.setBounds(300,350,230,30);
        signup.setBackground(new Color(3,6,55));
        signup.setForeground(Color.WHITE);
        signup.setFont(new Font("Helvetica", Font.BOLD,14));
        signup.setFocusPainted(false);
        signup.addActionListener(this);
        add(signup);
        
        setSize(800,480);
        setVisible(true);
        setLocation(350, 150);
        getContentPane().setBackground(Color.WHITE);
        
    }
    
    //override abstract method of ActionListener
    @Override
    public void actionPerformed(ActionEvent ae){
        //defining the logic as to what will happen upon clicking a button
        if(ae.getSource() == login){
            Conn c = new Conn();
            String cardNumber = cardTextField.getText();
            String pinNumber = pinTextField.getText();
            String query = "select * from login where cardNumber = '"+cardNumber+"' and pin = '"+pinNumber+"'";
            try{
                ResultSet rs = c.s.executeQuery(query);
                if(rs.next()){
                    setVisible(false);//close login frame as login successful
                    new Transactions(pinNumber).setVisible(true);//open transactions frame
                }else{
                    JOptionPane.showMessageDialog(null, "Incorrect Card Number or PIN");
                }
            }catch(Exception e){
                System.out.println(e);
            }
        }else if(ae.getSource() == clear){
            cardTextField.setText("");//clears data upon clicking clear.
            pinTextField.setText("");
            
        }else if(ae.getSource() == signup){
            setVisible(false);
            new SignUpOne().setVisible(true);
        }
    }

    public static void main(String[] args) {
        new Login();
    }
}
