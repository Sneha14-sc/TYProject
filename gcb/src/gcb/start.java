/*
 *8[n  j    To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package gcb;

/**
 *
 * @author Sneha
 */
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.text.DateFormat;
import java.util.Date;
public class start extends JFrame
{
        ImageIcon img;
        JScrollPane p;
       // public static final String DATE_FORMAT_NOW="HH:mm:ss";
        //public static String dt;
	public start()throws Exception
	{

        String txt="<html><p color=#66cd00>Garbage Collector Board</p></html>";
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
        JLabel l3=new JLabel(dateToStr);
        l3.setFont(new Font("Sitka Small",Font.BOLD,22));     
        l3.setBounds(1700,20,200,100);

        p.add(l3);
        JLabel image=new JLabel();                                              //backgroundimg
        image.setLayout(null);
        image.setBounds(0,0,2000,1000);
        image.setIcon(new javax.swing.ImageIcon("C:\\java pr\\gcbproj\\img\\back12.jpg"));
        add(image); 
        //JFrame f=new JFrame();
	
        String lab="<html><body color=#00fa9a><p align=center ><br><b>'Cleanliness will be<br>"+"nationwide,<br>but first you start from<br> your "+"side.'</b></p><br></body></html>";
	JLabel  l1=new JLabel(lab,JLabel.CENTER);                               //slogan
       	l1.setFont(new Font("Sitka Small",Font.BOLD,78)); 
        l1.setLayout(null);
        JButton b=new JButton("START");                                         //start
	b.addActionListener(new ActionListener() 
	{
	public void actionPerformed(ActionEvent ae)
	{
                dispose();
		type t=new type();
		t.setVisible(true);
	}
	});
        l1.setBounds(370,50,1200,800);
        
	b.setBounds(900,700,90,50);
        b.setLayout(null);
        image.add(l1);
	image.add(b);
	
	this.setSize(2000,1000);                                                //frame setting
	this.setLayout(null);
	this.setTitle("Garbage Collector Board-citizen-login-page");
	this.setVisible(true);
	this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	}
	public static void main(String arg[])throws Exception
	{
	 new start();
	}

}
