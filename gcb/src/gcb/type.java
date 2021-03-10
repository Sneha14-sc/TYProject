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

class type extends JFrame
{
	//JFrame t;	
	JRadioButton jb1,jb2,jb3;
	JButton b1;
	ButtonGroup g1;
	JLabel l1;
        JScrollPane p;
        public type()
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
        JLabel l3=new JLabel(dateToStr);
        l3.setFont(new Font("Sitka Small",Font.BOLD,22));     
        l3.setBounds(1700,20,200,100);

        p.add(l3);
         JLabel image=new JLabel();                                              //backgroundimg
                image.setLayout(null);
                image.setIcon(new javax.swing.ImageIcon("C:\\java pr\\gcbproj\\img\\bg2.jpg"));
                image.setBounds(0,0,2000,1000);
        add(image); 
		 this.setLayout(null);
		 jb1=new JRadioButton();
		 jb2=new JRadioButton();
		 jb3=new JRadioButton();
		 b1=new JButton(" OK ");
	 	 g1=new ButtonGroup();
		 l1=new JLabel("Login as: ");
		 jb1.setText(" Citizen ");
		 jb2.setText(" Worker ");
		 jb3.setText("  Admin ");
		 jb1.setBounds(800,250,250,50);
		 jb1.setFont(new Font("Verdana",Font.BOLD,40));
		 jb2.setBounds(800,310,250,60);
		 jb2.setFont(new Font("Verdana",Font.BOLD,40));
		 jb3.setBounds(800,380,250,70);
		 jb3.setFont(new Font("Verdana",Font.BOLD,40));
		 b1.setBounds(745,490,100,30);
		 l1.setBounds(600,250,150,50);
		 l1.setFont(new Font("Verdana",Font.BOLD,25));
		 image.add(jb1); image.add(jb2); image.add(jb3);
		 image.add(b1); image.add(l1);
		 g1.add(jb1); g1.add(jb2); g1.add(jb3);
  		 setSize(2000,1000);
		 setTitle("Garbage Collector Board-first page");
		 setVisible(true);
		 setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	
		 b1.addActionListener(new ActionListener()
		 {
		 public void actionPerformed(ActionEvent e)
		 {
		 if(jb1.isSelected())
		 {	
                        dispose();
			logc c=new logc();
			c.setVisible(true);
		 } 
		 else if(jb2.isSelected())
		 {	
                        dispose();
			logw c=new logw();
			c.setVisible(true);
	  	 }
		 else if(jb3.isSelected())
		 {	
                        dispose();
			loga c=new loga();
			c.setVisible(true);
		 }
				
		 }
		});
	 	}
	public static void main(String arg[])
	{
	new type();
	}
}