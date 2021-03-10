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
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.net.Socket;
import java.text.DateFormat;
import java.util.Date;
import javax.swing.*;
import java.io.*;
class homew extends JFrame
{
	JButton b1,b2,b3,b4,b5;
	JLabel l1;
        //static ServerSocket ss;
        static Socket s;  
        static DataInputStream din; 
        static DataOutputStream dout;  
        static  JTextArea chats;        

        homew() throws IOException
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
        b2=new JButton("Main Feeds Page");
		b2.setBackground(Color.LIGHT_GRAY);
		b2.setBounds(263,100,370,38);
		b2.setFont(new Font("Verdana",Font.BOLD,20));
		b3=new JButton("Log - Out");
		b3.setBackground(Color.LIGHT_GRAY);
		b3.setBounds(635,100,370,38);
		b3.setFont(new Font("Verdana",Font.BOLD,20));
                add(b2); add(b3);
                 b3.addActionListener(new ActionListener()
                {
                public void actionPerformed(ActionEvent ae)
                {
                    dispose();
                   type a=new type();
                   a.setVisible(true);
                }
        	});
                 b2.addActionListener(new ActionListener()
                {
                public void actionPerformed(ActionEvent ae)
                {
                  dispose();
		  mainp t=new mainp();
		  t.setVisible(true);
        	}
        	});                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                         ;
                // JLabel l3=new JLabel();
                                                        //date time
        Date currentDate = new Date();  
        String dateToStr = DateFormat.getInstance().format(currentDate);
        JLabel l4=new JLabel(dateToStr);
        l4.setFont(new Font("Sitka Small",Font.BOLD,22));     
        l4.setBounds(1700,20,220,100);

        p.add(l4);
         JLabel image2=new JLabel();                                              //backgroundimg
                image2.setLayout(null);
                image2.setIcon(new javax.swing.ImageIcon("C:\\java pr\\gcbproj\\img\\bg2.jpg"));
                image2.setBounds(0,0,2000,1000);
                add(image2);
		this.setLayout(null);
                 JPanel p1=new JPanel();  
                //image2.add(b6); image2.add(b7);
                 //-------------------------------------------------------messaging---------------
                chats=new JTextArea();
                chats.setFont(new Font("Verdana",Font.BOLD,30));
                chats.setBackground(Color.LIGHT_GRAY);
                JScrollPane pane=new JScrollPane(chats);
                pane.setBounds(30,30,1000,650);
                image2.add(pane);
                 final JTextArea msg=new JTextArea();
                msg.setBounds(10,700,1700,80);
                msg.setFont(new Font("Verdana",Font.BOLD,20));
                image2.add(msg);
                JButton send=new JButton("Send");
                send.setBounds(1720,700,150,80);
                send.setFont(new Font("Verdana",Font.BOLD,20));
                image2.add(send);
                send.addActionListener(new ActionListener()
                {
                public void actionPerformed(ActionEvent ae)
                {
                   try{
                   String msgout="";
                   msgout=msg.getText().trim();
                   dout.writeUTF(msgout);
                    //dout.flush();
                   }
                   catch(IOException e)
                   {}
                }
                });
                JLabel im4=new JLabel();                                              //backgroundimg
                im4.setLayout(null);
                im4.setIcon(new javax.swing.ImageIcon("C:\\java pr\\gcbproj\\img\\phh3.jpg"));
                im4.setBounds(1120,0,700,600);
                image2.add(im4);
                p1.add(image2);       
                JTabbedPane tp=new JTabbedPane();                               //tabbed
                tp.setBounds(2,100,1999,1000);
                tp.setFont(new Font("Verdana",Font.BOLD,25));
                tp.add("Message admin  ",p1);
     
		add(tp);
		 //image2.add(b1);image2.add(b2); image2.add(b3); 
		setSize(2000,1000);
		setTitle("Garbage Collector Board-Worker's-home-page");
		setVisible(true);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

	}
	public static void main(String arg[]) throws IOException
	{
		new homew();
        
                try{
                s=new Socket("localhost",3333);
                din=new DataInputStream(s.getInputStream());
                dout=new DataOutputStream(s.getOutputStream());
                String msgin="";
                while(!msgin.equals("exit"))
                {
                msgin=din.readUTF();
                chats.setText(chats.getText().trim()+"\n Admin:\n"+msgin);
                }
                }
                catch(IOException e)
                {}
         }
        
}
