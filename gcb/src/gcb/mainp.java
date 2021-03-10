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
import java.awt.event.*;
import java.io.*;
import java.sql.*;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.filechooser.FileNameExtensionFilter;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableColumnModel;
class mainp extends JFrame
{
          String ss = null;
	JButton b1,b2,b3,b4,b5,b6,b7,add1,brow;
	JLabel l1,ll1;
	JScrollBar vsb;
         JTextArea loc;
         static String newtext=null;
         static String arr[]=new String[5];
         static int cnt=0;
         final JTextArea chats=new JTextArea();
          final JTextArea msg=new JTextArea();
	mainp()
	{
                ImageIcon img;
                JScrollPane p;
                b5=new JButton(" Log-out ");
		b5.setBackground(Color.LIGHT_GRAY);
		b5.setBounds(1750,99,170,38);
		b5.setFont(new Font("Verdana",Font.BOLD,20));    
                add(b5);
                 b5.addActionListener(new ActionListener()
                {
                public void actionPerformed(ActionEvent ae)
                {
                   dispose();
                   type a=new type();
                   a.setVisible(true);
                }
        	});
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
                                //date time
                Date currentDate = new Date();  
                String dateToStr = DateFormat.getInstance().format(currentDate);
                JLabel l4=new JLabel(dateToStr);
                l4.setFont(new Font("Sitka Small",Font.BOLD,21));     
                l4.setBounds(1700,20,200,100);
                this.setLayout(null);
                b6=new JButton("Back");                                         //buttons on home
		b6.setBackground(Color.LIGHT_GRAY);
		b6.setBounds(1500,900,130,50);
		b6.setFont(new Font("Verdana",Font.BOLD,20));
		b6.addActionListener(new ActionListener()
                {
                public void actionPerformed(ActionEvent ae)
                {
                    String verify=JOptionPane.showInputDialog("Enter your ID:");
                     try{ 
                    Class.forName("oracle.jdbc.driver.OracleDriver");
                      Connection con;  
                      con = DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:orcl","scott","pass");
                      PreparedStatement pstmt=con.prepareStatement("select wno from worker where wno="+verify);
                       ResultSet rs=pstmt.executeQuery();
                    if(verify.equals("14394"))
                    {
                        dispose();
                        homea s1=new homea();
                        s1.setVisible(true);
                    }
                    else if(rs.next())
                     {
                                  
                        dispose();
                        homew t=new homew();
                        t.setVisible(true);
                    }
                    else
                    {
                         dispose();
                        type t1=new type();
                        t1.setVisible(true);
                    }
                }
                catch(ClassNotFoundException | SQLException e){} catch (IOException ex) {
                        Logger.getLogger(mainp.class.getName()).log(Level.SEVERE, null, ex);
                    }
                }
                });
                JPanel p1=new JPanel();
              //----------------------retrive img with location(home)-----------------
                JLabel j1=new JLabel();
                DefaultTableModel model=new DefaultTableModel();
               JTable jtb1=new JTable(model);
               jtb1.setAutoResizeMode(JTable.AUTO_RESIZE_OFF);
               //b1.setAutoResizeMode((int) JTable.CENTER_ALIGNMENT);
               jtb1.setGridColor(Color.gray);
               jtb1.setForeground(Color.blue);
              // jtb1.setBounds(0,0,1500,500);
               jtb1.setFont(new Font("Verdana",Font.BOLD,15));
               jtb1.setRowHeight(200);
               model.addColumn("<html><h1>Location</h1></html>");
               model.addColumn("<html><h1>Image</h1></html>");
               TableColumnModel Cmodel=jtb1.getColumnModel();
               Cmodel.getColumn(0).setPreferredWidth(800);
               Cmodel.getColumn(1).setPreferredWidth(650);
             try{
             byte[] imageBytes;
             Image img1,si;
             JLabel photol= new JLabel();
             JTextArea location;
             Class.forName("oracle.jdbc.driver.OracleDriver");
             Connection con;  
             ResultSet rs;    
            con = DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:orcl","scott","pass1");
            PreparedStatement pstmt=con.prepareStatement("select * from images");
            rs=pstmt.executeQuery();            //location=new JTextArea("Location:",100,100);

            //pane1=new JScrollPane(location);
            //pane1.setBounds(0,0,500,800);
            while(rs.next())
            {
                //Blob b=rs.getBlob(2);
                //imageBytes=b.getBytes(1,(int)b.length());
                //imageBytes=rs.getBytes(2);
                
                Blob b=rs.getBlob(2);
                imageBytes=b.getBytes(1,(int)b.length());
                img1=Toolkit.getDefaultToolkit().createImage(imageBytes);
                si=img1.getScaledInstance(300,300,Image.SCALE_FAST);
                photol.setIcon(new ImageIcon(si));
                
               setLayout(null);
                //System.out.println("6");
                            
                model.addRow(new Object[]{ rs.getString(1),rs.getBlob(2)});
            }
            }
             catch(ClassNotFoundException | SQLException e)
                 {}
        JScrollPane pg=new JScrollPane(jtb1,JScrollPane.VERTICAL_SCROLLBAR_ALWAYS,JScrollPane.HORIZONTAL_SCROLLBAR_NEVER);
                pg.setPreferredSize(new Dimension(1898,700));
               pg.setViewportView(jtb1);
              // pg.add(image);
               p1.add(pg); p1.add(b6);
          //image.add(b6); //image.add(b7);//image.add(pane1);
                             //---------------------------------------------------end home-----------------------------
                JPanel p2=new JPanel();
                JLabel im2=new JLabel();                                              //backgroundimg picture
                im2.setLayout(null);
                im2.setIcon(new javax.swing.ImageIcon("C:\\java pr\\gcbproj\\img\\bg2.jpg"));
                //-----------------------------------uploading picture--------------------------       
        add1=new JButton("ADD");
        add1.setBounds(1300,600,150,80);
        brow=new JButton("Browse");
        brow.setBounds(750,600,150,80);
        loc=new JTextArea("Location",100,100);
        JScrollPane pane=new JScrollPane(loc);
        pane.setBounds(950,600,300,100);
       
        ll1=new JLabel();
        ll1.setBounds(700,10,670,550);
        
        brow.addActionListener(new ActionListener()
        {
            @Override
            public void actionPerformed(ActionEvent e)
            {
                JFileChooser fc=new JFileChooser();
                fc.setCurrentDirectory(new File(System.getProperty("user.home")));
                FileNameExtensionFilter filter=new FileNameExtensionFilter("*.IMAGE","jpg","gif","png");
                fc.addChoosableFileFilter(filter);
                int result=fc.showSaveDialog(null);
              
                if(result==JFileChooser.APPROVE_OPTION)
                {
                File sf=fc.getSelectedFile();
                String path=sf.getAbsolutePath();
                ll1.setIcon(RsImg(path));
                ss=path;
                
                }
                else if(result==JFileChooser.CANCEL_OPTION)
                {
                System.out.println("No Data");
                }
                //throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
            }
        });
        add1.addActionListener(new ActionListener()
        {

            @Override
            public  void actionPerformed(ActionEvent e) {
                //To change body of generated methods, choose Tools | Templates.
            try{
             Class.forName("oracle.jdbc.driver.OracleDriver");
             Connection con;  
            con = DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:orcl","scott","pass1");
            PreparedStatement ps=con.prepareStatement("insert into images values(?,?)");
            FileInputStream is=new FileInputStream(new File(ss));
            ps.setString(1,loc.getText());
            ps.setBinaryStream(2,is,is.available());
           
            ps.executeUpdate();
            JOptionPane.showMessageDialog(null,"Data inserted");
            }
            catch(ClassNotFoundException | SQLException | FileNotFoundException | HeadlessException ec)
            {} catch (IOException ex) {
                    //Logger.getLogger(NewClass.class.getName()).log(Level.SEVERE, null, ex);
                }
            
            }
        });
         im2.add(ll1);im2.add(pane);im2.add(add1);im2.add(brow);
               im2.setBounds(0,0,2,100);
               p2.add(im2);
                //-------------------------upload end------------------------------
                JPanel p3=new JPanel();
  //--------------------------------------------feedback-------------------------------
                JLabel im3=new JLabel();                                              //backgroundimg
                im3.setLayout(null);
                im3.setIcon(new javax.swing.ImageIcon("C:\\java pr\\gcbproj\\img\\bg2.jpg"));
                im3.setBounds(0,0,2,100);
                b7=new JButton("Give Feedback");
		b7.setBackground(Color.LIGHT_GRAY);
		b7.setBounds(1050,700,250,80);
		b7.setFont(new Font("Verdana",Font.BOLD,20));
               
                chats.setFont(new Font("Verdana",Font.BOLD,30));
                chats.setBackground(Color.LIGHT_GRAY);
                JScrollPane pane2=new JScrollPane(chats);
                pane2.setBounds(30,30,800,650);
                im3.add(pane2);
                msg.setBounds(10,700,1000,80);
                msg.setFont(new Font("Verdana",Font.BOLD,20));
                 b7.addActionListener(new ActionListener()
                {
                 @Override
                 public void actionPerformed(ActionEvent ae)
                 {
                     newtext=msg.getText();
                     if(newtext.compareTo("end")!=0)
                     {
                         arr[cnt]=newtext;
                         cnt++;
                         if(cnt==arr.length)
                         {  incrArray();}
                     }
                    // String newtext="";
           //          listarr();
                     msg.selectAll();
                     msg.requestFocusInWindow();
                     chats.append("Citizen:");
                     chats.append(newtext); chats.append("\n");
                 }});
                im3.add(msg);
                im3.add(b7);
                JLabel ph1=new JLabel();                                              //backgroundimg
                ph1.setLayout(null);
                ph1.setIcon(new javax.swing.ImageIcon("C:\\java pr\\gcbproj\\img\\phh2.jpg"));
                ph1.setBounds(1000,20,800,600);
                im3.add(ph1);
                p3.add(im3);
                //-----------------------------end feedback-------------------------
                JPanel p4=new JPanel();
                //------------------------------contacts------------------
                JLabel im4=new JLabel();                                              //backgroundimg
                im4.setLayout(null);
                im4.setIcon(new javax.swing.ImageIcon("C:\\java pr\\gcbproj\\img\\bg2.jpg"));
                im4.setBounds(0,0,2,100);
                JLabel c1=new JLabel("CONTACTS");
                c1.setForeground(Color.black);
                c1.setFont(new Font("Arial Black",Font.BOLD,60));     
                c1.setBounds(750,-200,500,500);
                im4.add(c1);
                JLabel c2=new JLabel("Address      :");
                c2.setForeground(Color.red);
                c2.setFont(new Font("Arial Black",Font.BOLD,30));     
                c2.setBounds(550,100,500,200);
                im4.add(c2);
                JLabel c3=new JLabel("<html><p>PMC Main Building,<br> Near Mangla Theatre, Shivajinagar,<br> pune-411005</p></html>");
                c3.setForeground(Color.MAGENTA);
                c3.setFont(new Font("Arial Black",Font.BOLD,25));     
                c3.setBounds(850,100,500,200);
                im4.add(c3);
                JLabel c4=new JLabel("<html><p>PMC<br> Contact no. :</p></html>");
                c4.setForeground(Color.red);
                c4.setFont(new Font("Arial Black",Font.BOLD,30));     
                c4.setBounds(550,250,500,200);
                im4.add(c4);
                JLabel c5=new JLabel("020-25501000");
                c5.setForeground(Color.MAGENTA);
                c5.setFont(new Font("Arial Black",Font.BOLD,25));     
                c5.setBounds(850,260,500,200);
                im4.add(c5);
                JLabel c6=new JLabel("Email-id      :");
                c6.setForeground(Color.red);
                c6.setFont(new Font("Arial Black",Font.BOLD,30));     
                c6.setBounds(550,350,500,200);
                im4.add(c6);
                JLabel c7=new JLabel("info@punecooperation.org");
                c7.setForeground(Color.MAGENTA);
                c7.setFont(new Font("Arial Black",Font.BOLD,25));     
                c7.setBounds(850,350,500,200);
                im4.add(c7);
                JLabel c8=new JLabel("For more services visit:www.pmc.gov.in");
                c8.setForeground(Color.BLUE);
                c8.setFont(new Font("Arial Black",Font.BOLD,45));     
                c8.setBounds(450,550,1200,200);
                im4.add(c8);
                p4.add(im4);
                JPanel p5=new JPanel();
                //----------------------------About us---------------------------
                
                String abt="<html><p align=center color=red bgcolor=#9aff9a>This system is socially beneficial in order to eradicate the immense issues of waste management accross the city. "+"Any individual can access the site"
                        + " and be a part of system by uploading picture with proper location wherever there is considerable accumulation of waste. These pictures will"+""
                        + " be received by the worker's hired by admin who will be responsible to collectthis waste within particular time period.<br></p>"
                        + "<br><br><p align=center color=#68228b>'SPREAD HELPING HANDS TO BE A PART OF SOLUTION,<br>        NOT A PART OF POLLUTION.'</p></html>";
                JLabel about=new JLabel(abt);
                about.setFont(new Font("Sitka Small",Font.BOLD,40));     
                about.setBounds(200,0,1500,800);
                JLabel im5=new JLabel();                                              //backgroundimg
                im5.setLayout(null);
                im5.setIcon(new javax.swing.ImageIcon("C:\\java pr\\gcbproj\\img\\bg2.jpg"));
                im5.setBounds(0,0,2,100);
                im5.add(about);
                JLabel lb1=new JLabel("ABOUT US");
                lb1.setForeground(Color.black);
                lb1.setFont(new Font("Arial Black",Font.BOLD,60));     
                lb1.setBounds(750,-200,500,500);
                im5.add(lb1);
                p5.add(im5);
                JTabbedPane tp=new JTabbedPane();                               //tabbed
                tp.setBounds(2,100,1999,1000);
                tp.setFont(new Font("Verdana",Font.BOLD,25));
                 tp.add(" Home ",p1);
                tp.add(" Upload Picture ",p2);
                tp.add(" Feedbacks ",p3);
                tp.add(" Contacts ",p4);
                tp.add(" About Us ",p5);
                      	
            p.add(l4);
           
	    add(tp);
             
	setSize(1900,1000);
		setTitle("Garbage Collector Board-main-feeds-page");
		setVisible(true);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

	}
        public ImageIcon RsImg(String path) {
               // throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
                ImageIcon img=new ImageIcon(path);
                Image i=img.getImage();
                Image newImage;
        newImage = i.getScaledInstance(ll1.getWidth(),ll1.getHeight(),Image.SCALE_SMOOTH);
                ImageIcon image=new ImageIcon(newImage);
                 return image;
        }  
      
        /*public void listarr()
        {
        for(int x=0;x<arr.length;x++)
            chats.setText(msg.getText());
        }*/
        public void incrArray()
        {
        String temp[]=new String[arr.length*2];
        System.arraycopy(arr,0,temp,0,arr.length);
        arr=temp;
        }
	public static void main(String arg[])throws Exception
	{
              mainp mainp = new mainp();
	}

    
}

