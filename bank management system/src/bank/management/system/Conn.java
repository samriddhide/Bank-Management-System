package bank.management.system;

import java.sql.*;

public class Conn {

    Connection c;
    Statement s;
    public Conn() {
        try{
            Class.forName("com.mysql.cj.jdbc.Driver"); //load and register driver
            c = DriverManager.getConnection("jdbc:mysql://localhost:3306/bankmanagementsystem?autoReconnect=true&useSSL=false", "root", "SQL@113800");//create connection
            s = c.createStatement();
        }catch(Exception e){
            System.out.println(e);
        }
    }
    
}
