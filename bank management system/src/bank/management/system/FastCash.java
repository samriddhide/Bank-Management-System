
package bank.management.system;
import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import java.sql.*;
import java.util.Date;

public class FastCash extends JFrame implements ActionListener{

    JButton hundred,fiveHundred,thousand,twoThousand,fiveThousand,tenThousand,exit;
    JLabel text;
    String pin;
    public FastCash(String pin) {
        this.pin=pin;
        setLayout(null);
        setTitle("Fast Cash");
        text = new JLabel("Select withdrawal amount: ");
        text.setBounds(300,180,700,30);
        text.setFont(new Font("Helvetica", Font.BOLD, 24));
        add(text);
        
        hundred = new JButton("Rs.100");
        hundred.setFont(new Font("Helvetica", Font.BOLD, 16));
        hundred.setBounds(240,250,200,30);
        hundred.setFocusPainted(false);
        hundred.setForeground(Color.BLACK);
        add(hundred);
        
        fiveHundred = new JButton("Rs.500");
        fiveHundred.setFont(new Font("Helvetica", Font.BOLD, 16));
        fiveHundred.setBounds(470,250,200,30);
        fiveHundred.setForeground(Color.BLACK);
        fiveHundred.setFocusPainted(false);
        add(fiveHundred);
        
        thousand = new JButton("Rs.1000");
        thousand.setFont(new Font("Helvetica", Font.BOLD, 16));
        thousand.setBounds(240,300,200,30);
        thousand.setFocusPainted(false);
        thousand.setForeground(Color.BLACK);
        add(thousand);
        
        twoThousand = new JButton("Rs.2000");
        twoThousand.setFont(new Font("Helvetica", Font.BOLD, 16));
        twoThousand.setBounds(470,300,200,30);
        twoThousand.setFocusPainted(false);
        twoThousand.setForeground(Color.BLACK);
        add(twoThousand);
        
        fiveThousand = new JButton("Rs.5000");
        fiveThousand.setFont(new Font("Helvetica", Font.BOLD, 16));
        fiveThousand.setBounds(240,350,200,30);
        fiveThousand.setFocusPainted(false);
        fiveThousand.setForeground(Color.BLACK);
        add(fiveThousand);
        
        tenThousand = new JButton("Rs.10000");
        tenThousand.setFont(new Font("Helvetica", Font.BOLD, 16));
        tenThousand.setBounds(470,350,200,30);
        tenThousand.setFocusPainted(false);
        tenThousand.setForeground(Color.BLACK);
        add(tenThousand);

        exit = new JButton("BACK");
        exit.setFont(new Font("Helvetica", Font.BOLD, 16));
        exit.setBounds(370,400,200,30);
        exit.setFocusPainted(false);
        exit.setForeground(Color.BLACK);
        add(exit);
        
        setSize(900,600);
        setLocation(300,0);
        setVisible(true);
        getContentPane().setBackground(Color.WHITE);
        
        hundred.addActionListener(this);
        fiveHundred.addActionListener(this);
        thousand.addActionListener(this);
        twoThousand.addActionListener(this);
        fiveThousand.addActionListener(this);
        tenThousand.addActionListener(this);
        exit.addActionListener(this);
    }
    
    
    @Override
    public void actionPerformed(ActionEvent ae) {
        try {
            String amount = ((JButton)ae.getSource()).getText().substring(3); //k
            Conn c = new Conn();
            ResultSet rs = c.s.executeQuery("select * from bank where pin = '"+pin+"'");
            int balance = 0;
            while (rs.next()) {
                if (rs.getString("type").equals("Deposit")) {
                    balance += Integer.parseInt(rs.getString("amount"));
                } else {
                    balance -= Integer.parseInt(rs.getString("amount"));
                }
            } String num = "17";
            if (ae.getSource() != exit && balance < Integer.parseInt(amount)) {
                JOptionPane.showMessageDialog(null, "Insuffient Balance");
                return;
            }

            if (ae.getSource() == exit) {
                this.setVisible(false);
                new Transactions(pin).setVisible(true);
            }else{
                Date date = new Date();
                c.s.executeUpdate("insert into bank values('"+pin+"', '"+date+"', 'Withdrawl', '"+amount+"')");
                JOptionPane.showMessageDialog(null, "Rs. "+amount+" Debited Successfully");
                    
                setVisible(false);
                new Transactions(pin).setVisible(true);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }

    }
    
    
    public static void main(String[] args) {
        new FastCash("");
    }
    
    
}
