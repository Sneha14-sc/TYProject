/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package gcb;

/**
 *
 * @author Sneha
 */
import java.awt.*;
import javax.swing.*;
import java.awt.event.*;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.text.DateFormat;
import java.util.Date;
import java.util.regex.Pattern;

class logc extends JFrame
{
	JButton b1,b2;
	JLabel l1,l2,l3;
	JTextField t1,t2;
	logc()
	{
                ImageIcon img;
                JScrollPane p;
                 String txt="<html><p color=blue>Garbage Collector Board</p></html>";
        p=new JScrollPane();                                                    //header
        p.setLayout(null);
        p.setBackground(Color.white);
        add(p);
           JLabel image1=new JLabel();                                              //backgroundimg
                image1.setLayout(null);
                image1.setIcon(new javax.swing.ImageIcon("C:\\java pr\\gcbproj\\img\\logo11.jpg"));
                image1.setBounds(440,2,130,95);      
                p.add(image1);
        JLabel l=new JLabel(txt);                                                  //headerlabel
        l.setFont(new Font("Sitka Small",Font.BOLD,48)); 
        l.setLayout(null);
        l.setBounds(570,-10,1200,100);
        p.add(l);
        p.setBounds(0,0,2000,100);
        
       // JLabel l3=new JLabel();
                                                        //date time
        Date currentDate = new Date();  
        String dateToStr = DateFormat.getInstance().format(currentDate);
        JLabel l4=new JLabel(dateToStr);
        l4.setFont(new Font("Sitka Small",Font.BOLD,22));     
        l4.setBounds(1700,20,200,100);

        p.add(l4);
                JLabel image=new JLabel();                                              //backgroundimg
                image.setLayout(null);
                image.setIcon(new javax.swing.ImageIcon("C:\\java pr\\gcbproj\\img\\bg2.jpg"));
                image.setBounds(0,0,2,100);
        add(image); 
		l1=new JLabel("Citizen's Log-in Page");
		l2=new JLabel("Enter Your Name        :");
		l3=new JLabel("Enter Your Mobile-no  :");
		t1=new JTextField(10);
		b1=new JButton("SUBMIT"); 
		b2=new JButton("BACK"); 
		t1.setFont(new Font("Verdana",Font.BOLD,15));
		
		t1.setBackground(Color.LIGHT_GRAY);
		t1.setBounds(900,290,200,40);
		t2=new JTextField(10);
		t2.setFont(new Font("Verdana",Font.BOLD,15));
		
		t2.setBackground(Color.LIGHT_GRAY);
		t2.setBounds(900,360,200,40);
		l1.setBounds(550,180,650,70);
		l1.setFont(new Font("Verdana",Font.BOLD,50));
		l2.setBounds(560,280,350,50);
		l2.setFont(new Font("Verdana",Font.BOLD,25));
		l3.setBounds(560,350,350,50);
		l3.setFont(new Font("Verdana",Font.BOLD,25));
		b1.setBounds(750,450,150,50);
		b2.setBounds(550,450,150,50);
	
	 b2.addActionListener(new ActionListener()
	 {
	public void actionPerformed(ActionEvent ae)
	{
                dispose();
		type t=new type();
		t.setVisible(true);
	}
	});
	b1.addActionListener(new ActionListener()
	{
	public void actionPerformed(ActionEvent ae)
	{
	String uname=t1.getText();
	String mobno=t2.getText();
        //System.out.println("hi1"); 
        if(Pattern.matches("[789]\\d{9}",mobno))
        {
        try
        {
            Class.forName("oracle.jdbc.driver.OracleDriver");
                 Connection con;  
            con = DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:orcl ","system","Pass1234");
            System.out.println("hi1"); 
            Statement stmt=con.createStatement();  
           
            ResultSet rs=stmt.executeQuery("select * from citizen where phno='"+mobno+"'");
            if(rs.next())
            {
                System.out.println(stmt);
                dispose();
                mainp a=new mainp();
                a.setLocationRelativeTo(null);
                a.setVisible(true);
            }
            else 
            {
                PreparedStatement ps=con.prepareStatement("insert into citizen values(?,?)");
                ps.setString(1,uname);
                ps.setString(2,mobno);
                int j=ps.executeUpdate();
                System.out.println(j+" records affected");
                           
                dispose();
                mainp a=new mainp();
                 a.setLocationRelativeTo(null);
                a.setVisible(true);
              }
               
        }
        catch(ClassNotFoundException | SQLException e){}
        }
        else
        {
            JOptionPane.showMessageDialog(null,"Invalid username or phone number");
        }
       
	}
	});
	
		image.add(l1); image.add(l2); image.add(t1); image.add(l3); image.add(t2); image.add(b1);image.add(b2);
	setSize(2000,1000);
		setTitle("Garbage Collector Board-citizen-login-page");
		setVisible(true);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
	}
	public static void main(String arg[])
	{
		new logc();
	}
}
