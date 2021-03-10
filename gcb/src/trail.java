/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author Sneha
 */
import java.sql.*;

public class trail {
    public static void main(String arg[])
    {
        
try
{
    
    Class.forName("oracle.jdbc.driver.OracleDriver");
    Connection con;
    
    con=DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:orcl","system","Pass1234");
    Statement stnt=con.createStatement();
   
    ResultSet rs=stnt.executeQuery("Select * from trails");
    
    while(rs.next())
    {
    System.out.println(rs.getInt(1)+" "+rs.getString(2));
    }
    con.close();
}
catch(ClassNotFoundException | SQLException e)
{
}
    }
}
