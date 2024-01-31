
package bank.management.system;

import javax.swing.*;
import java.awt.Color;
import java.awt.Font;
import java.util.*;
import com.toedter.calendar.JDateChooser;
import java.awt.event.*;

public class SignUpTwo extends JFrame implements ActionListener{
    JTextField panTextField, aadharTextField;
    JButton next;
    JRadioButton scitizenYes, scitizenNo, existingYes, existingNo;
    String formno;
    
    JComboBox religionBox,categoryBox,incomeBox, educationBox,occupationBox;
    //constructor
    SignUpTwo(String formno) {
        this.formno = formno;
        setLayout(null);
        
        setTitle("NEW ACCOUNT APPLICATION FORM - Page 2");
        
        JLabel additionalDetails = new JLabel("Page 2 :- ADDITIONAL DETAILS");
        additionalDetails.setFont(new Font("Helvetica", Font.BOLD, 20));
        additionalDetails.setBounds(280,80,400,24);
        add(additionalDetails);
        
        JLabel religion = new JLabel("Religion: ");
        religion.setFont(new Font("Helvetica", Font.BOLD, 20));
        religion.setBounds(100,140,100,30);
        add(religion);
        
        String[] valReligion = {"Hindu", "Muslim", "Sikh", "Christian", "Other"};
        religionBox = new JComboBox(valReligion);
        religionBox.setFont(new Font("Arial",Font.BOLD,14));
        religionBox.setBounds(300,140,400,30);
        add(religionBox);
        
        JLabel category = new JLabel("Category: ");
        category.setFont(new Font("Helvetica", Font.BOLD, 20));
        category.setBounds(100,190,200,30);
        add(category);
        
        String[] valCategory = {"General", "SC", "ST", "OBC", "Other"};
        categoryBox = new JComboBox(valCategory);
        categoryBox.setFont(new Font("Arial",Font.BOLD,14));
        categoryBox.setBounds(300,190,400,30);
        add(categoryBox);
        
        JLabel income = new JLabel("Income: ");
        income.setFont(new Font("Helvetica", Font.BOLD, 20));
        income.setBounds(100,240,200,30);
        add(income);
        
        String[] incomeCategory = {"NA", "<1.5L", "<2.5L", "<5L", "upto 10L",">10L"};
        incomeBox = new JComboBox(incomeCategory);
        incomeBox.setFont(new Font("Arial",Font.BOLD,14));
        incomeBox.setBounds(300,240,400,30);
        add(incomeBox);
        
        JLabel dob = new JLabel("Educational: ");
        dob.setFont(new Font("Helvetica", Font.BOLD, 20));
        dob.setBounds(100,290,200,30);
        add(dob);
        
        JLabel gender = new JLabel("Qualification: ");
        gender.setFont(new Font("Helvetica", Font.BOLD, 20));
        gender.setBounds(100,315,200,30);
        add(gender);
        
        String[] educationCategory = {"Non-Graduate", "Graduate", "Post-Graduate", "Doctrate", "Other"};
        educationBox = new JComboBox(educationCategory);
        educationBox.setFont(new Font("Arial",Font.BOLD,14));
        educationBox.setBounds(300,315,400,30);
        add(educationBox);
        
        JLabel email = new JLabel("Occupation: ");
        email.setFont(new Font("Helvetica", Font.BOLD, 20));
        email.setBounds(100,390,200,30);
        add(email);
        
        String[] occupationCategory = {"Non-Salaried", "Salaried", "Self-Employed", "Businessman", "Student","Retired","Other"};
        occupationBox = new JComboBox(occupationCategory);
        occupationBox.setFont(new Font("Arial",Font.BOLD,14));
        occupationBox.setBounds(300,390,400,30);
        add(occupationBox);
        
        JLabel pan = new JLabel("PAN number: ");
        pan.setFont(new Font("Helvetica", Font.BOLD, 20));
        pan.setBounds(100,440,200,30);
        add(pan);
        
        panTextField = new JTextField();
        panTextField.setFont(new Font("Arial",Font.BOLD,14));
        panTextField.setBounds(300,440,400,30);
        add(panTextField);
        
        JLabel aadhar = new JLabel("Aadhar number: ");
        aadhar.setFont(new Font("Helvetica", Font.BOLD, 20));
        aadhar.setBounds(100,490,200,30);
        add(aadhar);
        
        aadharTextField = new JTextField();
        aadharTextField.setFont(new Font("Arial",Font.BOLD,14));
        aadharTextField.setBounds(300,490,400,30);
        add(aadharTextField);
        
        JLabel seniorCitizen = new JLabel("Senior Citizen: ");
        seniorCitizen.setFont(new Font("Helvetica", Font.BOLD, 20));
        seniorCitizen.setBounds(100,540,200,30);
        add(seniorCitizen);
        
        scitizenYes = new JRadioButton("Yes");
        scitizenYes.setBounds(300,540,100,30);
        scitizenYes.setBackground(Color.WHITE);
        add(scitizenYes);
       
        scitizenNo = new JRadioButton("No");
        scitizenNo.setBounds(450,540,100,30);
        scitizenNo.setBackground(Color.WHITE);
        add(scitizenNo);
        
        ButtonGroup citizenGroup = new ButtonGroup();
        citizenGroup.add(scitizenYes);
        citizenGroup.add(scitizenNo);
        
        JLabel state = new JLabel("Existing Account: ");
        state.setFont(new Font("Helvetica", Font.BOLD, 20));
        state.setBounds(100,590,200,30);
        add(state);
        
        existingYes = new JRadioButton("Yes");
        existingYes.setBounds(300,590,100,30);
        existingYes.setBackground(Color.WHITE);
        add(existingYes);
       
        existingNo = new JRadioButton("No");
        existingNo.setBounds(450,590,100,30);
        existingNo.setBackground(Color.WHITE);
        add(existingNo);
        
        ButtonGroup existingAccountGroup = new ButtonGroup();
        existingAccountGroup.add(existingYes);
        existingAccountGroup.add(existingNo);     
        
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
        String religion = (String)religionBox.getSelectedItem();
        String category = (String)categoryBox.getSelectedItem();
        String income = (String)incomeBox.getSelectedItem();
        String education = (String)educationBox.getSelectedItem();
        String occupation = (String)occupationBox.getSelectedItem();
        String seniorCitizen = null;
        if(scitizenYes.isSelected()){
            seniorCitizen = "Yes";
        }else if(scitizenNo.isSelected()){
            seniorCitizen = "No";
        }
        
        String existingAccount = null;
        if(existingYes.isSelected()){
            existingAccount = "Yes";
        }else if(existingNo.isSelected()){
            existingAccount = "No";
        }
        
        String pan = panTextField.getText();
        String aadhar = aadharTextField.getText();
        
        //establish connection with database
        try{          
            Conn c = new Conn();
            String query = "insert into signupTwo values('"+formno+"','"+religion+"','"+category+"','"+income+"','"+education+"','"+occupation+"','"+pan+"','"+aadhar+"','"+seniorCitizen+"','"+existingAccount+"')";
            c.s.executeUpdate(query);
            setVisible(false);
            new SignUpThree(formno).setVisible(true);
        }catch(Exception e){
            System.out.println(e);
        }
    }
    
    public static void main(String[] args) {
        new SignUpTwo("");
    }
}
