
package bank.management.system;

import javax.swing.*;
import java.awt.Color;
import java.awt.Font;
import java.util.*;
import com.toedter.calendar.JDateChooser;
import java.awt.event.*;

public class SignUpOne extends JFrame implements ActionListener{
    long random;
    JTextField nameTextField, fatherTextField, motherTextField, emailTextField, addressTextField, cityTextField, stateTextField;
    JButton next;
    JRadioButton maleRadioButton, femaleRadioButton, otherRadioButton, marriedRadioButton, unmarriedRadioButton;
    JDateChooser dateChooser;
    //constructor
    SignUpOne() {
        setLayout(null);
        setTitle("Sign Up page 1");
        Random ran = new Random();
        random = Math.abs(ran.nextLong() % 9000L + 1000L); //generates 4 digit random number
        
        JLabel formNumber = new JLabel("APPLICATION FORM NUMBER- "+random);
        formNumber.setFont(new Font("Helvetica", Font.BOLD, 30));
        formNumber.setBounds(140,20,650,40);
        add(formNumber);
        
        JLabel personalDetails = new JLabel("Page 1 :- PERSONAL DETAILS");
        personalDetails.setFont(new Font("Helvetica", Font.BOLD, 20));
        personalDetails.setBounds(280,80,400,24);
        add(personalDetails);
        
        JLabel name = new JLabel("Name: ");
        name.setFont(new Font("Helvetica", Font.BOLD, 20));
        name.setBounds(100,140,100,30);
        add(name);
        
        nameTextField = new JTextField();
        nameTextField.setFont(new Font("Helvetica",Font.BOLD,14));
        nameTextField.setBounds(300,140,400,30);
        add(nameTextField);
        
        JLabel fatherName = new JLabel("Father Name: ");
        fatherName.setFont(new Font("Helvetica", Font.BOLD, 20));
        fatherName.setBounds(100,190,200,30);
        add(fatherName);
        
        fatherTextField = new JTextField();
        fatherTextField.setFont(new Font("Helvetica",Font.BOLD,14));
        fatherTextField.setBounds(300,190,400,30);
        add(fatherTextField);
        
        JLabel motherName = new JLabel("Mother Name: ");
        motherName.setFont(new Font("Helvetica", Font.BOLD, 20));
        motherName.setBounds(100,240,200,30);
        add(motherName);
        
        motherTextField = new JTextField();
        motherTextField.setFont(new Font("Helvetica",Font.BOLD,14));
        motherTextField.setBounds(300,240,400,30);
        add(motherTextField);
        
        JLabel dob = new JLabel("Date Of Birth: ");
        dob.setFont(new Font("Helvetica", Font.BOLD, 20));
        dob.setBounds(100,290,200,30);
        add(dob);
        
        dateChooser = new JDateChooser();
        dateChooser.setBounds(300,290,400,30);
        dateChooser.setForeground(new Color(105,105,105));
        add(dateChooser);
        
        JLabel gender = new JLabel("Gender: ");
        gender.setFont(new Font("Helvetica", Font.BOLD, 20));
        gender.setBounds(100,340,200,30);
        add(gender);
        
        maleRadioButton = new JRadioButton("Male ");
        maleRadioButton.setBounds(300,340,60,30);
        maleRadioButton.setBackground(Color.WHITE);
        add(maleRadioButton);
        
        femaleRadioButton = new JRadioButton("Female ");
        femaleRadioButton.setBounds(450,340,120,30);
        femaleRadioButton.setBackground(Color.WHITE);
        add(femaleRadioButton);
        
        //button group to make sure only one option chosen
        ButtonGroup groupGender = new ButtonGroup();
        groupGender.add(maleRadioButton);
        groupGender.add(femaleRadioButton);
        
        JLabel email = new JLabel("Email Address: ");
        email.setFont(new Font("Helvetica", Font.BOLD, 20));
        email.setBounds(100,390,200,30);
        add(email);
        
        emailTextField = new JTextField();
        emailTextField.setFont(new Font("Helvetica",Font.BOLD,14));
        emailTextField.setBounds(300,390,400,30);
        add(emailTextField);
        
        JLabel maritalStatus = new JLabel("Marital Status: ");
        maritalStatus.setFont(new Font("Helvetica", Font.BOLD, 20));
        maritalStatus.setBounds(100,440,200,30);
        add(maritalStatus);
        
        marriedRadioButton = new JRadioButton("Married ");
        marriedRadioButton.setBounds(300,440,100,30);
        marriedRadioButton.setBackground(Color.WHITE);
        add(marriedRadioButton);
        
        unmarriedRadioButton = new JRadioButton("Unmarried ");
        unmarriedRadioButton.setBounds(450,440,100,30);
        unmarriedRadioButton.setBackground(Color.WHITE);
        add(unmarriedRadioButton);
        
        otherRadioButton = new JRadioButton("Other ");
        otherRadioButton.setBounds(630,440,100,30);
        otherRadioButton.setBackground(Color.WHITE);
        add(otherRadioButton);
        
        //button group to make sure only one option chosen
        ButtonGroup maritalGroup = new ButtonGroup();
        maritalGroup.add(marriedRadioButton);
        maritalGroup.add(unmarriedRadioButton);
        maritalGroup.add(otherRadioButton);
        
        JLabel address = new JLabel("Address: ");
        address.setFont(new Font("Helvetica", Font.BOLD, 20));
        address.setBounds(100,490,200,30);
        add(address);
        
        addressTextField = new JTextField();
        addressTextField.setFont(new Font("Helvetica",Font.BOLD,14));
        addressTextField.setBounds(300,490,400,30);
        add(addressTextField);
        
        JLabel city = new JLabel("City: ");
        city.setFont(new Font("Helvetica", Font.BOLD, 20));
        city.setBounds(100,540,200,30);
        add(city);
        
        cityTextField = new JTextField();
        cityTextField.setFont(new Font("Helvetica",Font.BOLD,14));
        cityTextField.setBounds(300,540,400,30);
        add(cityTextField);
       
        JLabel state = new JLabel("State: ");
        state.setFont(new Font("Helvetica", Font.BOLD, 20));
        state.setBounds(100,590,200,30);
        add(state);
        
        stateTextField = new JTextField();
        stateTextField.setFont(new Font("Helvetica",Font.BOLD,14));
        stateTextField.setBounds(300,590,400,30);
        add(stateTextField);
              
        next = new JButton("Next");
        next.setBackground(Color.BLACK);
        next.setForeground(Color.WHITE);
        next.setBounds(620,640,80,30);
        next.setFocusPainted(false);
        next.addActionListener(this);
        add(next);
        
        //create frame
        setSize(850,720);
        setLocation(300,20);
        setVisible(true);
        getContentPane().setBackground(Color.WHITE);
        
    }

    //function to extract the values from text field
    @Override
    public void actionPerformed(ActionEvent ae){
        String formno = "" + random;//random is long so concatenating with "" to convert it to string
        String name = nameTextField.getText(); //extract values from text field
        String fname = fatherTextField.getText();
        String mname = motherTextField.getText();
        String dobirth = ((JTextField) dateChooser.getDateEditor().getUiComponent()).getText();
        String gender = null;
        if(maleRadioButton.isSelected()){
            gender = "Male";
        }else if(femaleRadioButton.isSelected()){
            gender = "Female";
        }
        
        String email = emailTextField.getText();
        String marital = null;
        if(unmarriedRadioButton.isSelected()){
            marital = "Unmarried";
        }else if(marriedRadioButton.isSelected()){
            marital = "Married";
        }else if(otherRadioButton.isSelected()){
            marital = "Other";
        }
        
        String address = addressTextField.getText();
        String city = cityTextField.getText();
        String state = stateTextField.getText();
        
        //establish connection with database
        try{
            if(name.equals("")){
                JOptionPane.showMessageDialog(null, "Name cannot be empty!");
                return;
            }else{
                Conn c = new Conn();
                String query = "insert into signup values('"+formno+"','"+name+"','"+fname+"','"+mname+"','"+dobirth+"','"+gender+"','"+email+"','"+marital+"','"+address+"','"+city+"','"+state+"')";
                c.s.executeUpdate(query);
                
                setVisible(false);
                //signupTwo object
                new SignUpTwo(formno).setVisible(true);
            }
        }catch(Exception e){
            System.out.println(e);
        }
    }
    
    public static void main(String[] args) {
        new SignUpOne();
    }
}
