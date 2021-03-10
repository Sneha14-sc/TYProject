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
import java.awt.event.*;
import java.sql.*;
import java.util.regex.Pattern;
import javax.swing.*;

class regis extends JFrame
{
	JButton b1,b2,b3;
	JLabel l1,l2,l3,l4,l5,l6,l7,l8,l9,l10,l11;
	JTextField t1,t2,t3,t4,t5,t6,t7,t8,t9,t10; 
	
	regis()
	{
                  ImageIcon img;
      
         JLabel image=new JLabel();                                              //backgroundimg
         image.setLayout(null);
        image.setBounds(0,0,2000,1000);
        image.setIcon(new javax.swing.ImageIcon("C:\\java pr\\gcbproj\\img\\bak12.jpg"));
        add(image);
		this.setLayout(null);
		l1=new JLabel("    Registration Of Worker  ");
		l1.setFont(new Font("Verdana",Font.BOLD,45));
		l1.setBounds(560,5,700,100);
		
		l2=new JLabel("Number:");
		l2.setFont(new Font("Verdana",Font.BOLD,30));
		l2.setBounds(600,230,200,50);
		t1=new JTextField(10);
		t1.setFont(new Font("Verdana",Font.ITALIC,20));
		t1.setBounds(950,230,400,40);
		l3=new JLabel("Name:");
		l3.setFont(new Font("Verdana",Font.BOLD,30));
		l3.setBounds(600,280,300,50);
		t2=new JTextField(10);
		t2.setFont(new Font("Verdana",Font.ITALIC,20));
		t2.setBounds(950,280,400,40);
		l4=new JLabel("Address:");
		l4.setFont(new Font("Verdana",Font.BOLD,30));
		l4.setBounds(600,330,300,50);
		t3=new JTextField(10);
		t3.setFont(new Font("Verdana",Font.ITALIC,20));
		t3.setBounds(950,330,400,40);
		l5=new JLabel("Mobile.no:");
		l5.setFont(new Font("Verdana",Font.BOLD,30));
		l5.setBounds(600,380,300,50);
		t4=new JTextField(10);
		t4.setFont(new Font("Verdana",Font.ITALIC,20));
		t4.setBounds(950,380,400,40);
		l6=new JLabel("Vehicle Type:");
		l6.setFont(new Font("Verdana",Font.BOLD,30));
		l6.setBounds(600,430,300,50);
		t5=new JTextField(10);
		t5.setFont(new Font("Verdana",Font.ITALIC,20));
		t5.setBounds(950,430,400,40);
		l7=new JLabel("Locality:");
		l7.setFont(new Font("Verdana",Font.BOLD,30));
		l7.setBounds(600,480,300,50);
		t6=new JTextField(10);
		t6.setFont(new Font("Verdana",Font.ITALIC,20));
		t6.setBounds(950,480,400,40);
		l8=new JLabel("Salary:");
		l8.setFont(new Font("Verdana",Font.BOLD,30));
		l8.setBounds(600,530,300,50);
		t7=new JTextField(10);
		t7.setFont(new Font("Verdana",Font.ITALIC,20));
		t7.setBounds(950,530,400,40);
		l9=new JLabel("Bonus:");
		l9.setFont(new Font("Verdana",Font.BOLD,30));
		l9.setBounds(600,580,300,50);
		t8=new JTextField(10);
		t8.setFont(new Font("Verdana",Font.ITALIC,20));
		t8.setBounds(950,580,400,40);
		l10=new JLabel("Total_salary:");
		l10.setFont(new Font("Verdana",Font.BOLD,30));
		l10.setBounds(600,630,300,50);
		t9=new JTextField(10);
		t9.setFont(new Font("Verdana",Font.ITALIC,20));
		t9.setBounds(950,630,400,40);
		l11=new JLabel("Admin-name:");
		l11.setFont(new Font("Verdana",Font.BOLD,30));
		l11.setBounds(600,680,300,50);
		t10=new JTextField(10);
		t10.setFont(new Font("Verdana",Font.ITALIC,20));
		t10.setBounds(950,680,400,40);

		b1=new JButton("Reset");
		b1.setBackground(Color.LIGHT_GRAY);
		b1.setBounds(630,850,150,40);
		b1.setFont(new Font("Verdana",Font.BOLD,24));
		b2=new JButton("Submit");
		b2.setBackground(Color.LIGHT_GRAY);
		b2.setBounds(800,850,150,40);
		b2.setFont(new Font("Verdana",Font.BOLD,24));
		b3=new JButton("Back");
		b3.setBackground(Color.LIGHT_GRAY);
		b3.setBounds(980,850,150,40);
		b3.setFont(new Font("Verdana",Font.BOLD,24));
		
		image.add(l1);
		image.add(l2);image.add(t1);image.add(l3);image.add(t2);image.add(l4);image.add(t3);image.add(l5);image.add(t4);
		image.add(l6);image.add(t5);image.add(l7);image.add(t6);image.add(l8);image.add(t7);image.add(l9);image.add(t8);
		image.add(l10);image.add(t9);image.add(l11);image.add(t10);
		image.add(b1); image.add(b2); image.add(b3);
        b3.addActionListener(new ActionListener()
	 {
	public void actionPerformed(ActionEvent ae)
	{
		type t=new type();
		t.setVisible(true);
	}
	});         
        b2.addActionListener(new ActionListener()
	{
	public void actionPerformed(ActionEvent ae)
	{
	int no=Integer.parseInt(t1.getText());
	String name=t2.getText();
        String addr=t3.getText();
        String mobno=t4.getText();
        String veh=t5.getText();
        String loca=t6.getText();
        int sal=Integer.parseInt(t7.getText());
        int bonous=Integer.parseInt(t8.getText());
        int tot_sal=sal+bonous;//Integer.parseInt(t9.getText());
        String aname=t10.getText();
        if(Pattern.matches("[789]\\d{9}",mobno))
        {
        try
        {
            Class.forName("oracle.jdbc.driver.OracleDriver");
            Connection con;  
            con = DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:orcl","scott","pass");
            //Statement stmt=con.createStatement();  
            PreparedStatement ps=con.prepareStatement("insert into worker values(?,?,?,?,?,?,?,?,?,?)");
                ps.setInt(1,no);
                ps.setString(2,name);
                ps.setString(3,addr);
                ps.setString(4,mobno);
                ps.setString(5,veh);
                ps.setString(6,loca);
                ps.setInt(7,sal);
                ps.setInt(8,bonous);
                ps.setInt(9,tot_sal);
                ps.setString(10,aname);
                int j=ps.executeUpdate();
                System.out.println(j+" records affected");
             }
        catch(ClassNotFoundException | SQLException e){}
        }
        }
        });
		setSize(1700,700);
		setTitle("Garbage Collector Board-Registration-page");
		setVisible(true);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

	}
	public static void main(String arg[])
	{
		new regis();
	}
}

