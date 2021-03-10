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
import java.text.DateFormat;
import java.util.Date;
import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.awt.event.*;
import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;
import java.sql.*;
import java.util.logging.Level;
import java.util.logging.Logger;
import java.util.regex.Pattern;
import javax.swing.event.TableModelEvent;
import javax.swing.table.TableColumnModel;


class homea extends JFrame
{
         JButton b1,b2,b3,bb5,bb6,bb7,bb8,br1,bs1;
	JLabel l1,l2,l3,l4,l5,l6,l7,l8,l9,l10,l11,idlb,sallb,bolb,gen;
	JTextField t1,t2,t3,t4,t5,t6,t7,t8,t9,t10,tt1,tt2,tt3;    
	//	JLabel ll1,ll2;
        Connection con;  
        Statement s;
        ResultSet rs;
        static JTextArea chats;
        static ServerSocket ss;
        static Socket so;  
        static DataInputStream din; 
        static DataOutputStream dout;  
        homea() throws ClassNotFoundException
	{
                ImageIcon img;
                JScrollPane p;
                String txt="<html><p color=#66cd00>Garbage Collector Board</p></html>";
                p=new JScrollPane();                                                    //header
                p.setLayout(null);
                p.setBackground(Color.white);
                add(p);
                JLabel image1=new JLabel();                                              //backgroundimg
                image1.setLayout(null);
                image1.setIcon(new javax.swing.ImageIcon("C:\\java pr\\gcbproj\\img\\logo11.jpg"));
                image1.setBounds(440,2,130,95);      
                JLabel l=new JLabel(txt);                                                  //headerlabel
                l.setFont(new Font("Sitka Small",Font.BOLD,48)); 
                l.setLayout(null);
                l.setBounds(570,-10,1200,100);
                p.add(l);
                p.add(image1);
                p.setBounds(0,0,2000,100);
                 bb5=new JButton(" Log-out ");
		bb5.setBackground(Color.LIGHT_GRAY);
		bb5.setBounds(0,909,300,38);
		bb5.setFont(new Font("Verdana",Font.BOLD,20));    
                add(bb5);
                bb5.addActionListener(new ActionListener()
                {
                public void actionPerformed(ActionEvent ae)
                {
		  dispose();
                   type a=new type();
                   a.setVisible(true);
        	}
        	});                                        //date time
              Date currentDate = new Date();  
              String dateToStr = DateFormat.getInstance().format(currentDate);
              JLabel ll4=new JLabel(dateToStr);
             ll4.setFont(new Font("Sitka Small",Font.BOLD,21));     
             ll4.setBounds(1700,20,200,100);p.add(ll4);
             JLabel image=new JLabel();                                              //backgroundimg
                image.setLayout(null);
                image.setIcon(new javax.swing.ImageIcon("C:\\java pr\\gcbproj\\img\\bg3.jpg"));
                image.setBounds(56,-600,2,100);                                            //date time
               this.setLayout(null);
               JLabel img1=new JLabel();                                              //backgroundimg
                img1.setLayout(null);
                img1.setIcon(new javax.swing.ImageIcon("C:\\java pr\\gcbproj\\img\\bg3.jpg"));
               JPanel p1=new JPanel();
//----------------------------------------home-------------------------------------------
              JLabel image3=new JLabel();                                              //backgroundimg
                image3.setLayout(null);
                image3.setIcon(new javax.swing.ImageIcon("C:\\java pr\\gcbproj\\img\\sol22.png"));
                image3.setBounds(600,0,600,450);
             String sol="<html><p align=center>We love our Country <br>but in words not from heart...<br>We have to prove it with Cleanliness and <br>greenery Environment.</p></html>";  
             JLabel ll5=new JLabel(sol);
             ll5.setFont(new Font("Sitka Small",Font.BOLD,42));     
             ll5.setBounds(400,300,800,600);
             img1.add(image3);
             img1.add(ll5); 
                p1.add(img1);                                          //panel
                JPanel p2=new JPanel();
                //-----------------------Registration-----------------------------
                this.setLayout(null);
		l1=new JLabel("    Registration Of Worker  ");
		l1.setFont(new Font("Verdana",Font.BOLD,45));
		l1.setBounds(560,5,700,100);
		
		l2=new JLabel("Worker's ID:");
		l2.setFont(new Font("Verdana",Font.BOLD,30));
		l2.setBounds(600,130,200,50);
		t1=new JTextField(10);
		t1.setFont(new Font("Verdana",Font.ITALIC,20));
		t1.setBounds(950,130,400,40);
		l3=new JLabel("Name:");
		l3.setFont(new Font("Verdana",Font.BOLD,30));
		l3.setBounds(600,180,300,50);
		t2=new JTextField(10);
		t2.setFont(new Font("Verdana",Font.ITALIC,20));
		t2.setBounds(950,180,400,40);
		l4=new JLabel("Address:");
		l4.setFont(new Font("Verdana",Font.BOLD,30));
		l4.setBounds(600,230,300,50);
		t3=new JTextField(10);
		t3.setFont(new Font("Verdana",Font.ITALIC,20));
		t3.setBounds(950,230,400,40);
		l5=new JLabel("Mobile.no:");
		l5.setFont(new Font("Verdana",Font.BOLD,30));
		l5.setBounds(600,280,300,50);
		t4=new JTextField(10);
		t4.setFont(new Font("Verdana",Font.ITALIC,20));
		t4.setBounds(950,280,400,40);
		l6=new JLabel("Vehicle Type:");
		l6.setFont(new Font("Verdana",Font.BOLD,30));
		l6.setBounds(600,330,300,50);
		t5=new JTextField(10);
		t5.setFont(new Font("Verdana",Font.ITALIC,20));
		t5.setBounds(950,330,400,40);
		l7=new JLabel("Locality:");
		l7.setFont(new Font("Verdana",Font.BOLD,30));
		l7.setBounds(600,380,300,50);
		t6=new JTextField(10);
		t6.setFont(new Font("Verdana",Font.ITALIC,20));
		t6.setBounds(950,380,400,40);
		l8=new JLabel("Salary:");
		l8.setFont(new Font("Verdana",Font.BOLD,30));
		l8.setBounds(600,430,300,50);
		t7=new JTextField(10);
		t7.setFont(new Font("Verdana",Font.ITALIC,20));
		t7.setBounds(950,430,400,40);
		l9=new JLabel("Bonus:");
		l9.setFont(new Font("Verdana",Font.BOLD,30));
		l9.setBounds(600,480,300,50);
		t8=new JTextField(10);
		t8.setFont(new Font("Verdana",Font.ITALIC,20));
		t8.setBounds(950,480,400,40);
                l11=new JLabel("Admin-name:");
		l11.setFont(new Font("Verdana",Font.BOLD,30));
		l11.setBounds(600,530,300,50);
		t10=new JTextField(10);
		t10.setFont(new Font("Verdana",Font.ITALIC,20));
		t10.setBounds(950,530,400,40);
                if(t10.getText()!="snehacc")
                {}
                b1=new JButton("Reset");
		b1.setBackground(Color.LIGHT_GRAY);
		b1.setBounds(630,650,150,40);
		b1.setFont(new Font("Verdana",Font.BOLD,24));
		b2=new JButton("Submit");
		b2.setBackground(Color.LIGHT_GRAY);
		b2.setBounds(800,650,150,40);
		b2.setFont(new Font("Verdana",Font.BOLD,24));
                
                b1.addActionListener(new ActionListener()                       //reset button imple......
                {
                  public void actionPerformed(ActionEvent ae)
                  {
                        t1.setText(" "); 
                        t2.setText(" "); 
                        t3.setText(" "); 
                        t4.setText(" "); 
                        t5.setText(" "); 
                        t6.setText(" "); 
                        t7.setText(" ");
                        t8.setText(" ");
                        t10.setText(" "); 
                   }
                });
        b2.addActionListener(new ActionListener()                               //submit button imple..
	{
	public void actionPerformed(ActionEvent ae)
	{
	 int no=Integer.parseInt(t1.getText());
             String name=t2.getText();
             String addr=t3.getText();
             String veh=t5.getText();
             String loca=t6.getText();
             int sal=Integer.parseInt(t7.getText());
             int bonous=Integer.parseInt(t8.getText());
             int tot_sal=sal+bonous;
             String aname=t10.getText();
        String mobno=t4.getText();
        if(Pattern.matches("[789]\\d{9}",mobno))
        {
        //    System.out.println("Hello1");
            if(" ".equals(no))
            {
              JOptionPane.showMessageDialog(null,"ID number cannot be blank.");
              t1.requestFocus();
              return;
            }
            if(t2.getText().equals(" "))
            {
              JOptionPane.showMessageDialog(null,"Worker name cannot be blank.");
              t2.requestFocus();
              return;
            }
            if(t3.getText().equals(" "))
            {
              JOptionPane.showMessageDialog(null,"Address field cannot be blank.");
              t3.requestFocus();
              return;
            }
            if(t5.getText().equals(" "))
            {
              JOptionPane.showMessageDialog(null,"Vehicle field cannot be blank.");
              t5.requestFocus();
              return;
            }
            if(t6.getText().equals(" "))
            {
              JOptionPane.showMessageDialog(null,"Locality field cannot be blank.");
              t6.requestFocus();
              return;
            }
            if(t7.getText().equals(" "))
            {
              JOptionPane.showMessageDialog(null,"Salary field cannot be blank.");
              t7.requestFocus();
              return;
            }
            if(t10.getText().equals("snehacc"))
            {
              JOptionPane.showMessageDialog(null,"Invalid admin name.");
              t10.requestFocus();
              return;
            }
            try
             {   
                 Class.forName("oracle.jdbc.driver.OracleDriver");
            Connection con;  
            con = DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:orcl","scott","pass1");
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
                JOptionPane.showMessageDialog(null,"Details recorded successfully!");
                /*t1.setText(" "); 
                        t2.setText(" "); 
                        t3.setText(" "); 
                        t4.setText(" "); 
                        t5.setText(" "); 
                        t6.setText(" "); 
                        t7.setText(" ");
                        t8.setText(" ");
                        t10.setText(" "); */
             }
        catch(ClassNotFoundException | SQLException e){}
        }
        else
        {
            JOptionPane.showMessageDialog(null,"Invalid Mobile number!");}
        }
        });
		image.add(l1);
		image.add(l2);image.add(t1);image.add(l3);image.add(t2);image.add(l4);image.add(t3);image.add(l5);image.add(t4);
		image.add(l6);image.add(t5);image.add(l7);image.add(t6);image.add(l8);image.add(t7);image.add(l9);image.add(t8);
		image.add(l11);image.add(t10);
		image.add(b1); image.add(b2);
     
                
                p2.add(image);
                //-------------------------Registration complete--------------
	        JPanel p3=new JPanel();
                JLabel img2=new JLabel();                                              //backgroundimg
                img2.setLayout(null);
                img2.setIcon(new javax.swing.ImageIcon("C:\\java pr\\gcbproj\\img\\bg3.jpg"));
                 //---------------------------------chats---------------------
                chats=new JTextArea();
                chats.setFont(new Font("Verdana",Font.BOLD,30));
                chats.setBackground(Color.LIGHT_GRAY);
                JScrollPane pane=new JScrollPane(chats);
                pane.setBounds(20,20,700,720);
                img2.add(pane);
                 final JTextArea msg1=new JTextArea();
                msg1.setBounds(10,750,1400,80);
                msg1.setFont(new Font("Verdana",Font.BOLD,20));
                img2.add(msg1);
                JButton send=new JButton("Send");
                send.setBounds(1420,750,150,80);
                send.setFont(new Font("Verdana",Font.BOLD,20));
                img2.add(send);
                
                send.addActionListener(new ActionListener()                       //reset button imple......
                {
                  public void actionPerformed(ActionEvent ae)
                  {
                    try{
                    String msgout="";
                    msgout=msg1.getText().trim();
                    dout.writeUTF(msgout);
                    //chats.add(dout);
                    //dout.flush();
                    }
                    catch(Exception e)
                    {}
                  }
                  });
                JLabel im4=new JLabel();                                              //backgroundimg
                im4.setLayout(null);
                im4.setIcon(new javax.swing.ImageIcon("C:\\java pr\\gcbproj\\img\\phh4.jpg"));
                im4.setBounds(1000,-10,400,400);
                JLabel im5=new JLabel();                                              //backgroundimg
                im5.setLayout(null);
                im5.setIcon(new javax.swing.ImageIcon("C:\\java pr\\gcbproj\\img\\phh5.jpg"));
                im5.setBounds(800,320,800,400);
                img2.add(im4); img2.add(im5);
                p3.add(img2);
                JPanel p4=new JPanel();
                //------------------------------access to mainp-----------------------
                JLabel img3=new JLabel();                                              //backgroundimg
                img3.setLayout(null);
                img3.setIcon(new javax.swing.ImageIcon("C:\\java pr\\gcbproj\\img\\bg3.jpg"));
                JLabel msg=new JLabel("Click here..");                                                  //headerlabel
                msg.setFont(new Font("Sitka Small",Font.BOLD,68)); 
                msg.setLayout(null);
                msg.setBounds(580,350,1400,100);
                b3=new JButton("View Main Page");
		b3.setBackground(Color.LIGHT_GRAY);
		b3.setBounds(580,450,450,100);
		b3.setFont(new Font("Arial",Font.BOLD,24));
                
                b3.addActionListener(new ActionListener()                       //reset button imple......
                {
                  public void actionPerformed(ActionEvent ae)
                  {
                        mainp mp=new mainp();
                        dispose();
                        mp.setVisible(true);
                  }
                  });
                img3.add(msg); img3.add(b3);
                p4.add(img3);
                JPanel p5=new JPanel();
                JLabel img4=new JLabel();                                              //backgroundimg
                img4.setLayout(null);
                img4.setIcon(new javax.swing.ImageIcon("C:\\java pr\\gcbproj\\img\\bg3.jpg"));
                //---------------------------------salary Generation---------------
                this.setLayout(null);
                String sal="<html><p align=center color=blue>Salary & Insentives Generation</p></html>";
		gen=new JLabel(sal);
		gen.setFont(new Font("Verdana",Font.BOLD,45));
		gen.setBounds(440,-180,700,500);
		
		idlb=new JLabel("Worker's ID:");
		idlb.setFont(new Font("Verdana",Font.BOLD,30));
		idlb.setBounds(450,250,300,50);
		tt1=new JTextField(10);
                tt1.setFont(new Font("Verdana",Font.ITALIC,20));
		tt1.setBounds(850,250,400,40);
                sallb=new JLabel("Salary:");
		sallb.setFont(new Font("Verdana",Font.BOLD,30));
		sallb.setBounds(450,300,200,50);
		tt2=new JTextField(10);
		tt2.setFont(new Font("Verdana",Font.ITALIC,20));
		tt2.setBounds(850,300,400,40);
                bolb=new JLabel("Bonous:");
		bolb.setFont(new Font("Verdana",Font.BOLD,30));
		bolb.setBounds(450,350,200,50);
		tt3=new JTextField(10);
		tt3.setFont(new Font("Verdana",Font.ITALIC,20));
		tt3.setBounds(850,350,400,40);
                br1=new JButton("Reset");
		br1.setBackground(Color.LIGHT_GRAY);
		br1.setBounds(630,650,150,40);
		br1.setFont(new Font("Verdana",Font.BOLD,24));
		bs1=new JButton("Submit");
		bs1.setBackground(Color.LIGHT_GRAY);
		bs1.setBounds(800,650,150,40);
		bs1.setFont(new Font("Verdana",Font.BOLD,24));
                
                br1.addActionListener(new ActionListener()                       //reset button imple......
                {
                  public void actionPerformed(ActionEvent ae)
                  {
                        tt1.setText(" "); 
                        tt2.setText(" "); 
                        tt3.setText(" "); 
                  }
                });
                 bs1.addActionListener(new ActionListener()                               //submit button imple..
                {
                	public void actionPerformed(ActionEvent ae)
                	{
                             int no=Integer.parseInt(tt1.getText());
                             int sal=Integer.parseInt(tt2.getText());
                             int bonous=Integer.parseInt(tt3.getText()); 
                             int totsal=sal+bonous;
                            try
                            {
                                Class.forName("oracle.jdbc.driver.OracleDriver");     
                                Connection con = DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:orcl","scott","pass1");
                                String query="update worker set sal="+sal+" ,bonous="+bonous+" ,totsal="+totsal+" where wno="+no;
                                PreparedStatement ps=con.prepareStatement(query);
                                System.out.println(" records affected");                               

                                ps.execute();
                                JOptionPane.showMessageDialog(null,"Salary updated successfully..!");                           
                            } catch (ClassNotFoundException | SQLException ex) {
                                Logger.getLogger(homea.class.getName()).log(Level.SEVERE, null, ex);
                            }
                        }
                });
                 img4.add(gen);  img4.add(idlb); img4.add(tt1); img4.add(sallb); img4.add(tt2); img4.add(bolb); img4.add(tt3); img4.add(br1);
                img4.add(bs1); p5.add(img4);
                JPanel p6=new JPanel();
 //----------------------------------------reports in table form---------------------
               JButton ref=new JButton("Refresh");
               ref.setBackground(Color.LIGHT_GRAY);
	       ref.setBounds(10,500,160,50);
	       ref.setFont(new Font("Verdana",Font.BOLD,24));
               JButton update=new JButton("Update");
               update.setBackground(Color.LIGHT_GRAY);
               update.setBounds(10,650,150,40);
               update.setFont(new Font("Verdana",Font.BOLD,24));
	       JButton delet=new JButton("Delete");
	       delet.setBackground(Color.LIGHT_GRAY);
	       delet.setBounds(10,750,150,40);
	       delet.setFont(new Font("Verdana",Font.BOLD,24));
                
               DefaultTableModel model=new DefaultTableModel();
               final JTable jtb1=new JTable(model);
               jtb1.setAutoResizeMode(JTable.AUTO_RESIZE_OFF);
               //b1.setAutoResizeMode((int) JTable.CENTER_ALIGNMENT); 
               jtb1.setForeground(Color.blue);
              // jtb1.setBounds(0,0,1500,500);
               jtb1.setFont(new Font("Verdana",Font.BOLD,15));
               jtb1.setRowHeight(70);
               
               model.addColumn("<html><h1>H_no</h1></html>");
               model.addColumn("<html><h1>H_name</h1></html>");
               model.addColumn("<html><h1>H_address</h1></html>");
               model.addColumn("<html><h1>H_mobno</h1></html>");
               model.addColumn("<html><h1>H_vehicle</h1></html>");
               model.addColumn("<html><h1>H_locality</h1></html>");
               model.addColumn("<html><h1>H_salary</h1></html>");
               model.addColumn("<html><h1>H_bonous</h1></html>");
               model.addColumn("<html><h1>H_total_sal</h1></html>");
               TableColumnModel Cmodel=jtb1.getColumnModel();
               Cmodel.getColumn(0).setPreferredWidth(70);
               Cmodel.getColumn(1).setPreferredWidth(200);
               Cmodel.getColumn(2).setPreferredWidth(300);
               Cmodel.getColumn(3).setPreferredWidth(200);
               Cmodel.getColumn(4).setPreferredWidth(200);
               Cmodel.getColumn(5).setPreferredWidth(200);
               Cmodel.getColumn(6).setPreferredWidth(200);
               Cmodel.getColumn(7).setPreferredWidth(200);
               Cmodel.getColumn(8).setPreferredWidth(200);
               try
                {
                    Class.forName("oracle.jdbc.driver.OracleDriver");     
                    Connection conn = DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:orcl","scott","pass1");
                    PreparedStatement pstm=conn.prepareStatement("select * from worker");
                    rs=pstm.executeQuery();
                while(rs.next())
                {  
                  model.addRow(new Object[]{ rs.getInt(1),rs.getString(2),rs.getString(3),rs.getString(4),rs.getString(5),rs.getString(6),rs.getInt(7),rs.getInt(8),rs.getInt(9)});
                  
                }           
               }
                catch(SQLException e){ JOptionPane.showMessageDialog(null,e);}
                  ref.addActionListener(new ActionListener()                       //reset button imple......
                {
                  public void actionPerformed(ActionEvent ae)
                  {
                      
                  }
                });
               JScrollPane pg=new JScrollPane(jtb1);
               pg.setViewportView(jtb1);
               p6.add(pg);p6.add(ref);p6.add(update); p6.add(delet);
               //img6.add(ref); img6.add(update); img6.add(delet); img6.getBackground(); img6.add(pg);
               //p6.add(img6); 
               //  ---------------------report end-----------------------------------
                JTabbedPane tp=new JTabbedPane(JTabbedPane.LEFT,JTabbedPane.WRAP_TAB_LAYOUT);                               //tabbed
                tp.setBounds(2,100,1999,1000);
                tp.setFont(new Font("Verdana",Font.BOLD,25));
                tp.add(" Home ",p1);
                tp.add(" Add Worker  ",p2);
                tp.add(" Message Worker  ",p3);
                tp.add(" Main Page  ",p4);
                tp.add(" Salary Generation  ",p5);
                tp.add(" Reports  ",p6);  
                add(tp);
                setSize(2000,1000);
		setTitle("Garbage Collector Board-Admin-home-page");
		setVisible(true);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

	}
        public static void main(String arg[]) throws ClassNotFoundException, IOException
	{
		new homea();
	
                String msging="";
                try{
                        ss=new ServerSocket(3333);
                        so=ss.accept();
                        din=new DataInputStream(so.getInputStream());
                        dout=new DataOutputStream(so.getOutputStream());
                        while(true)
                        {
                            msging=din.readUTF();
                            if(msging.equals("end")||msging.equals("END"))
                            {
                                JOptionPane.showMessageDialog(null,"Chatting Terminated");
                                break;
                             }
                            
                            chats.setText(chats.getText().trim()+"\nWorker:\n"+msging);
                        }
                }
                catch(Exception e)
                {
                }
             
        }
}
