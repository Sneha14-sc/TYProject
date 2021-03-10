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
import java.text.DateFormat;
import java.util.Date;
import java.util.logging.Level;
import java.util.logging.Logger;

class loga extends JFrame
{
	JButton b1,b2;
	JLabel l1,l2,l3;
	JTextField t1;
	JPasswordField pwd;
         ImageIcon img;
        JScrollPane p;
	loga()
	{
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
		l1=new JLabel("Admin's Log-in Page");
		l2=new JLabel("Enter Name        :");
		l3=new JLabel("Enter Password  :");
		t1=new JTextField(10);
		b1=new JButton("SUBMIT"); 
		b2=new JButton("BACK"); 
		t1.setFont(new Font("Verdana",Font.BOLD,15));
		
		t1.setBackground(Color.LIGHT_GRAY);
		t1.setBounds(900,290,200,40);
		pwd=new JPasswordField(10);
		pwd.setFont(new Font("Verdana",Font.BOLD,15));
		
		pwd.setBackground(Color.LIGHT_GRAY);
		pwd.setBounds(900,360,200,40);
		l1.setBounds(550,180,650,70);
		l1.setFont(new Font("Verdana",Font.BOLD,50));
		l2.setBounds(560,280,350,50);
		l2.setFont(new Font("Verdana",Font.BOLD,25));
		l3.setBounds(560,350,350,50);
		l3.setFont(new Font("Verdana",Font.BOLD,25));
		b1.setBounds(750,450,150,50);
		b2.setBounds(550,450,150,50);
		image.add(l1); image.add(l2); image.add(t1); image.add(l3); image.add(pwd); image.add(b1);image.add(b2);
	
	
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
	String un=t1.getText();
	String pswd=pwd.getText();
	if(un.equals("snehacc") && pswd.equals("sneha@123"))
	{
            try {
                
                JOptionPane.showMessageDialog(null,"Login Successfull!");
                dispose();
                homea a=new homea();
                a.setVisible(true);
            } catch (ClassNotFoundException ex) {
                Logger.getLogger(loga.class.getName()).log(Level.SEVERE, null, ex);
            }
	}
	else
	{
		JOptionPane.showMessageDialog(null,"Invalid username or password");
	}
	}
	});
	 setSize(2000,1000);
		setTitle("Garbage Collector Board-admin-login-page");
		setVisible(true);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	
	}
	public static void main(String arg[])
	{
		new loga();
		}
}

