
import java.sql.*;
import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

import java.util.ArrayList;
import java.util.ListIterator;
public class Login extends JFrame implements ActionListener
{
   JLabel ltitle,ltitle1,luname,lpwd,llogin;
   TextField tfuname;
   TextField tfpwd;
   Font f1,f2,f3,f4,f5;
   JButton blogin,bexit;
    public Login()
    {
      setBounds(0,0,1025,740);
      setVisible(true);
      setBackground(Color.pink);
      setTitle("Login Form");
      setLayout(null); 
      Container cp=getContentPane();
      f1=new Font("Algerian",Font.BOLD,30);
      f2=new Font("Calibri",Font.BOLD,20);
      f3=new Font("Candara",Font.BOLD,14);
      f4=new Font("Monotype Corsiva",Font.BOLD,30);
      f5=new Font("Times new Roman",Font.BOLD,30);
      ltitle=new JLabel("WEL COME TO");
      ltitle.setFont(f4);
      ltitle.setForeground(Color.yellow);
      ltitle1=new JLabel("FITNESS CLUB MANAGEMENT SYSTEM");
      ltitle1.setFont(f1);
      ltitle1.setForeground(Color.magenta);
      luname=new JLabel("Username");
      luname.setFont(f2);
      lpwd=new JLabel("Password");
      lpwd.setFont(f2);
      llogin=new JLabel("Login");
      llogin.setFont(f5);
      llogin.setForeground(Color.green);
      tfuname=new TextField();
      tfpwd=new TextField();
      tfpwd.setEchoChar('*');
      tfuname.setFont(f3);
      tfpwd.setFont(f3);
      blogin=new JButton("Login");
      blogin.setFont(f3);
      blogin.addActionListener(this);
      bexit=new JButton("Exit");
      bexit.setFont(f3);
      bexit .addActionListener(this);
       cp.add(ltitle);
      cp.add(ltitle1);
      cp.add(luname);
      cp.add(lpwd);
      cp.add(llogin);
      cp.add(tfuname);
      cp.add(tfpwd);
      cp.add(blogin);
      cp.add(bexit);
       ltitle.setBounds(250,50,300,30);
       ltitle1.setBounds(50,90,600,50);
       llogin.setBounds(300,140,80,30);
       JLabel jl=new JLabel(new ImageIcon("leaf.jpg"));
       cp.add(jl);
       jl.setBounds(0,0,1025,740);
       luname.setBounds(200,480,150,30);
       tfuname.setBounds(370,480,180,30);
       lpwd.setBounds(200,530,150,30);
       tfpwd.setBounds(370,530,180,30);
       blogin.setBounds(250,600,80,30);
       bexit.setBounds(350,600,80,30);
      JLabel jll=new JLabel(new ImageIcon("Copt of fitn.jpg"));
      cp.add(jll);
      jll.setBounds(0,0,1000,750);
    }   
    public void actionPerformed(ActionEvent ae)
    {
      if(ae.getSource()==blogin)
      {
          try
         {
           if((tfuname.getText().equals("admin"))&&(tfpwd.getText().equals("pallavi")))
            {
              JOptionPane.showMessageDialog(this,"Login Succcessfully,Welcome !!!");
               new MainFrame();
               dispose();
             }
         else
              JOptionPane.showMessageDialog(this,"You are Invalid User,Sorry !!!");
         }
          catch(Exception e) {
        		e.printStackTrace();
         }
      }
      else if(ae.getSource()==bexit)
       {
           dispose();
       }
    }
    public static void main(String args[])
    {
     Login log=new Login();
     log.addWindowListener
     (
        new WindowAdapter()
         {
            public void windowClosing(WindowEvent we)
            {
                  System.exit(0);
             }
          }
      );
    }
}
class InstructorReport extends JFrame
{
 public InstructorReport()
 { 
 Container contentpane=getContentPane();
contentpane.setLayout(new BorderLayout());
String[] colHeads={"Instructor ID","Instructor name","Address","Mobile No.","E-mail ID","Gender","Joining Date","Member ID","Member Salary"};
Connection con=null;
Statement stmt=null;
ResultSet rs=null;
ArrayList values=new ArrayList();
  try 
 {Class.forName("com.mysql.cj.jdbc.Driver");
	con=DriverManager.getConnection("jdbc:mysql://127.0.0.1:3306/fitnessclub","root","pallavi");
	
	stmt=con.createStatement();
rs=stmt.executeQuery("select * from Instructor order by instid");
while(rs.next())
{
values.add(rs.getString(1));
values.add(rs.getString(2));
values.add(rs.getString(3));
values.add(rs.getString(4));
values.add(rs.getString(5));
values.add(rs.getString(6));
values.add(rs.getString(7));
values.add(rs.getString(8));
values.add(rs.getString(9));
}
}
  catch(Exception e) {
		e.printStackTrace();
	}
finally
{
try
{
if(con!=null)
{
con.close();
}
}
catch(Exception e) {
	e.printStackTrace();
}
}
int noOfRows=(values.size())/colHeads.length;
int no=0;
Object[][]data=new Object[noOfRows][colHeads.length];
System.out.println("no of records:"+noOfRows);
for(int i=0;i<noOfRows;i++)
{
for(int j=0;j<colHeads.length;j++)
{
String s=(String)values.get(no++);
data[i][j]=s;
}
}
JTable table=new JTable(data,colHeads);
int v=ScrollPaneConstants.VERTICAL_SCROLLBAR_ALWAYS;
int h=ScrollPaneConstants.HORIZONTAL_SCROLLBAR_ALWAYS;
JScrollPane jsp=new JScrollPane(table,v,h);
contentpane.add(jsp,BorderLayout.CENTER);
setVisible(true);
setSize(1000,600);
setTitle("Instructor Report");
}
}

class LoginReport extends JFrame
{
 public LoginReport ()
 { 
 Container contentpane=getContentPane();
contentpane.setLayout(new BorderLayout());
String[] colHeads={"Username","Password","Login"};
Connection con=null;
Statement stmt=null;
ResultSet rs=null;
ArrayList values=new ArrayList();
  try 
 {
	  Class.forName("com.mysql.cj.jdbc.Driver");
		con=DriverManager.getConnection("jdbc:mysql://127.0.0.1:3306/fitnessclub","root","pallavi");
		stmt=con.createStatement();
//rs=stmt.executeQuery("select * from Cust order by cid");
while(rs.next())
{
values.add(rs.getString(1));
values.add(rs.getString(2));
values.add(rs.getString(3));

}
}
  catch(Exception e) {
		e.printStackTrace();
	}
finally
{
try
{
if(con!=null)
{
con.close();
}
}
catch(Exception e) {
	e.printStackTrace();
}
}
int noOfRows=(values.size())/colHeads.length;
int no=0;
Object[][]data=new Object[noOfRows][colHeads.length];
System.out.println("no of records:"+noOfRows);
for(int i=0;i<noOfRows;i++)
{
for(int j=0;j<colHeads.length;j++)
{
String s=(String)values.get(no++);
data[i][j]=s;
}
}
JTable table=new JTable(data,colHeads);
int v=ScrollPaneConstants.VERTICAL_SCROLLBAR_ALWAYS;
int h=ScrollPaneConstants.HORIZONTAL_SCROLLBAR_ALWAYS;
JScrollPane jsp=new JScrollPane(table,v,h);
contentpane.add(jsp,BorderLayout.CENTER);
setVisible(true);
setSize(1000,600);
setTitle("Login Report");
}
}

class Member extends JFrame implements ActionListener,ItemListener
{
    private JLabel ltitle,lid,lname,laddr,lmobno,lemail,lgender,liname,ljoindate,lbatch,lheight,lweight,lsub,lclubfees;
    private JTextField tfid,tfname,tfmobno,tfemail,tfheight,tfweight,tfclubfees,tfjdate;
    private boolean countingMale=true;
    private JTextArea taddr;
    private JComboBox combo,combod,combom,comboy,combob,combosub;
    JButton badd,bsave,bdelete,bmodify,bsearch,bclose;
    JRadioButton rbMale,rbFemale;
    Choice date1,month1,year1,gen,instructor,subs,batch;
    JPanel p;
    String m;
    Font f1,f2,f3;
    Connection con;
    Statement st;
    ResultSet rs;
     Statement st1;
    ResultSet rs1;
    char check='X';
   
    public Member()
    {
       Container cp = getContentPane();
        f1=new Font("Arial",Font.BOLD,25);
        f2=new Font("Times New Roman",Font.BOLD,20);
        f3=new Font("Times New Roman",Font.BOLD,14);
       cp.setLayout(null);
       ltitle=new JLabel("Member Manipulation Form");
       ltitle.setFont(f1);
       ltitle.setForeground(Color.magenta);
       ltitle.setBackground(Color.red);
       lid=new JLabel("Member ID");
       lid.setFont(f2);
       lid.setForeground(Color.green);
       lname=new JLabel("Member Name");
       lname.setForeground(Color.green);
       lname.setFont(f2);
       laddr=new JLabel("Address");
       laddr.setForeground(Color.green);
       laddr.setFont(f2);
       lmobno=new JLabel("Mobile No.");
       lmobno.setForeground(Color.green);
       lmobno.setFont(f2);
       lemail=new JLabel("Email ID");
       lemail.setForeground(Color.green);
       lemail.setFont(f2);
       lgender=new JLabel("Gender");
       lgender.setForeground(Color.green);
       lgender.setFont(f2);
       liname=new JLabel("Instructor Name");
       liname.setForeground(Color.green);
       liname.setFont(f2);
       ljoindate=new JLabel("Joining date");
       ljoindate.setForeground(Color.green);
       ljoindate.setFont(f2);
       lbatch=new JLabel("Select Batch");
       lbatch.setForeground(Color.green);
       lbatch.setFont(f2);
       lheight=new JLabel("Member Height");
       lheight.setForeground(Color.green);
       lheight.setFont(f2);
       lweight=new JLabel("Member Weight");
       lweight.setForeground(Color.green);
       lweight.setFont(f2);
       lsub=new JLabel("Subscription");
       lsub.setForeground(Color.green);
       lsub.setFont(f2);
       lclubfees=new JLabel("Club fees");
       lclubfees.setForeground(Color.green);
       lclubfees.setFont(f2);
       tfjdate=new JTextField();
       tfid=new JTextField();
       tfname=new JTextField();
       tfmobno=new JTextField();
       tfemail=new JTextField();
       tfheight=new JTextField();
       tfweight=new JTextField();
       tfclubfees=new JTextField();
       taddr=new JTextArea(4,20);
       tfid.setFont(f3);
       tfjdate.setFont(f3);
       tfname.setFont(f3);
       tfmobno.setFont(f3);
       tfemail.setFont(f3);
       tfheight.setFont(f3);
       tfweight.setFont(f3);
       tfclubfees.setFont(f3);
       taddr.setFont(f3);
       JRadioButton rbMale = new JRadioButton("Male", true);
          //rbMale.setMnemonic(KeyEvent.VK_U);
        rbMale.setFont(f2);
       cp.add(rbMale);
       rbMale.addActionListener(new ActionListener()
       {
       public void actionPerformed(ActionEvent e) 
        {
       countingMale = true;
         }
       });
        JRadioButton rbFemale = new JRadioButton("Female", true);
       //rbFemale.setMnemonic(KeyEvent.VK_D);
         rbFemale.setFont(f2);
       cp.add(rbFemale);
       rbFemale.addActionListener(new ActionListener() 
      {
       public void actionPerformed(ActionEvent e) 
        {
       countingMale = false;
         }
      });
       ButtonGroup btnGp = new ButtonGroup();
       btnGp.add(rbMale);
       btnGp.add(rbFemale);

      date1=new Choice();
      //date1.setFont(f3);
     date1.add("");
     date1.add("1"); date1.add("2"); date1.add("3");date1.add("4"); date1.add("5"); date1.add("6");
     date1.add("7"); date1.add("8");date1.add("9");date1.add("10"); date1.add("11");date1.add("12");
     date1.add("13");date1.add("14");date1.add("15"); date1.add("16");date1.add("17");date1.add("18");
     date1.add("19");date1.add("20"); date1.add("21");date1.add("22");date1.add("23");date1.add("24");
     date1.add("25"); date1.add("26");date1.add("27");date1.add("28");date1.add("29");date1.add    ("30");date1.add("31");
     add(date1);
     date1.addItemListener(this);

     month1=new Choice();
     //month1.setFont(f3);
     month1.add("");
     month1.add("Jan"); month1.add("Feb"); month1.add("Mar");month1.add("Apr"); month1.add("May"); month1.add("Jun");
     month1.add("Jul"); month1.add("Aug");month1.add("Sep");month1.add("Oct"); month1.add("Nov");month1.add("Dec");
     add(month1);
     month1.addItemListener(this);
   
    year1=new Choice();
    //year1.setFont(f3);
    year1.add("");
    year1.add("2000"); year1.add("2001"); year1.add("2002");year1.add("2003"); year1.add("2004"); year1.add("2005");
    year1.add("2006"); year1.add("2007");year1.add("2008");year1.add("2009"); year1.add("2010");year1.add("2011");year1.add("2012");year1.add("2013");year1.add("2014");year1.add("2015");
    add(year1);
    year1.addItemListener(this);

    instructor=new Choice();
    //instructor.setFont(f3);
    instructor.add("Select");
    instructor.add("Mr.Prashant Kamble(Gends Instructor)"); instructor.add("Miss.Meghana Patel(Ladies Instructor)"); instructor.add("Mr.Alok Patil(Sport Instructor)");instructor.add("Miss.Shubhra Parab(Yoga Instuctor)");instructor.add("Mr.Amol Kanetkar(Weight Loss Instructor)");
    add(instructor);
    instructor.addItemListener(this);

    gen=new Choice();
    //gen.setFont(f3);
    gen.add("Select");
     gen.add("Male"); gen.add("Female"); gen.add("Trans-gender");
     add(gen);
     gen.addItemListener(this);
  
     subs=new Choice();
     //subs.setFont(f3);
     subs.add("Select"); subs.add("Monthly"); subs.add("Six Monthly"); subs.add("Yearly");       
      add(subs);
     subs.addItemListener(this);

      batch=new Choice();
      //batch.setFont(f3);
      batch.add("Select"); batch.add("A(5:30AM-6:30AM)"); batch.add("B(6:30AM-7:30AM)"); batch.add("C(5:30PM-6:30PM)"); batch.add("D(6:30PM-7:30PM)");
      add(batch);
      batch.addItemListener(this);

       badd=new JButton("Add");
       bdelete=new JButton("Detete");
       bsave=new JButton("Save");
       bmodify=new JButton("Modify");
       bsearch=new JButton("Search");
       bclose=new JButton("Close");
       badd.setFont(f3);
       bsave.setFont(f3);
       bdelete.setFont(f3);
       bmodify.setFont(f3);
       bsearch.setFont(f3);
       bclose.setFont(f3);
       badd.addActionListener(this);
       bsave.addActionListener(this);
       bdelete.addActionListener(this);
       bsearch.addActionListener(this);
       bmodify.addActionListener(this);
       bclose.addActionListener(this);
       cp.add(ltitle);
       cp.add(lid);
       cp.add(lname);
       cp.add(laddr);
       cp.add(lmobno);
       cp.add(lemail);
       cp.add(lgender);
       cp.add(liname);
       cp.add(ljoindate);
       cp.add(lbatch);
       cp.add(lheight);
       cp.add(lweight);
       cp.add(lsub);
       cp.add(lclubfees);
       cp.add(tfid);
       cp.add(tfname);
       cp.add(tfmobno);
       cp.add(tfemail);
       cp.add(tfheight);
       cp.add(tfweight);
       cp.add(tfclubfees);
       cp.add(tfjdate);
       cp.add(taddr);
       cp.add(badd);
       cp.add(bsave);
       cp.add(bdelete);
       cp.add(bmodify);
       cp.add(bsearch);
       cp.add(bclose);
       setBounds(0,0,1025,740);
       ltitle.setBounds(480,20,330,30);
       lid.setBounds(500,80,100,30);
       tfid.setBounds(650,80,100,25);
       lname.setBounds(500,115,150,30);
       tfname.setBounds(650,115,200,25);
       laddr.setBounds(500,150,150,30);
       taddr.setBounds(650,150,200,50);
       lmobno.setBounds(500,210,150,30);
       tfmobno.setBounds(650,210,200,25);
       lemail.setBounds(500,245,150,30);
       tfemail.setBounds(650,245,200,25);
       lgender.setBounds(500,280,150,30);
       gen.setBounds(650,280,200,30);
       //rbFemale.setBounds(650,330,100,30);
       liname.setBounds(500,320,150,30);
       instructor.setBounds(650,320,230,30);
       lbatch.setBounds(500,360,150,30);
       batch.setBounds(650,360,200,30);
       ljoindate.setBounds(500,400,120,30);
       tfjdate.setBounds(650,400,200,30);
       /**date1.setBounds(650,400,50,30);
       month1.setBounds(710,400,50,30);
       year1.setBounds(770,400,50,30);  */
       lheight.setBounds(500,440,150,30);
       tfheight.setBounds(650,440,200,30);
       lweight.setBounds(500,480,150,30);
       tfweight.setBounds(650,480,200,30);
       lsub.setBounds(500,520,150,30);
       subs.setBounds(650,520,200,30); 
       lclubfees.setBounds(500,560,180,30);
       tfclubfees.setBounds(650,560,200,30); 
       badd.setBounds(450,650,60,30);
       bsave.setBounds(520,650,70,30);
       bdelete.setBounds(600,650,80,30);
       bmodify.setBounds(690,650,80,30);
       bsearch.setBounds(780,650,80,30);
       bclose.setBounds(870,650,70,30);
      
       JLabel jl=new JLabel(new ImageIcon("nature_009.jpg"));
       cp.add(jl);
       jl.setBounds(0,0,1025,740);

       tfid.setEnabled(false);
       tfname.setEnabled(false);
       taddr.setEnabled(false);
       tfmobno.setEnabled(false);
       tfemail.setEnabled(false);
       tfheight.setEnabled(false);
       tfweight.setEnabled(false);
       tfclubfees.setEnabled(false);
        tfjdate.setEnabled(false);
       //rbMale.setEnabled(false);
       //rbFemale.setEnabled(false);
      instructor.setEnabled(false);
      /**date1.setEnabled(false);
      month1.setEnabled(false);
      year1.setEnabled(false);*/
      gen.setEnabled(false);
      batch.setEnabled(false);
      subs.setEnabled(false);
      
      setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
      setTitle("Member Form");
     // setSize(650,730);
      setVisible(true);
      setBackground(Color.pink);
     
      
    
   
    try
    {
  	  Class.forName("com.mysql.cj.jdbc.Driver");
			Connection con=DriverManager.getConnection("jdbc:mysql://127.0.0.1:3306/fitnessclub","root","pallavi");
			st=con.createStatement();
       rs=st.executeQuery("select * from Mem_ber");
    }
    catch(Exception e) {
  		e.printStackTrace();
  	}
    }
     public void itemStateChanged(ItemEvent ie)
      {
    	 try
    	    {
    	  	  Class.forName("com.mysql.cj.jdbc.Driver");
    				Connection con=DriverManager.getConnection("jdbc:mysql://127.0.0.1:3306/fitnessclub","root","pallavi");
    				st=con.createStatement();
    	       rs=st.executeQuery("select * from Mem_ber");
    	    }
    	    catch(Exception e) {
    	  		e.printStackTrace();
    	  	}
             if(ie.getSource()==subs && ie.getStateChange()==ItemEvent.SELECTED)
              {
              if(subs.getSelectedItem()=="Monthly")
              {
                    tfclubfees.setText("500");
              }
              else if(subs.getSelectedItem()=="Six Monthly")
              {
                          tfclubfees.setText("3000");
              }
              else if(subs.getSelectedItem()=="Yearly")
              {
                   tfclubfees.setText("6000");
              }
             else if(subs.getSelectedItem()=="Select")
              {
                   tfclubfees.setText("");
              }
       }
      }
     public void actionPerformed(ActionEvent ae)
     {
    	 try
    	    {
    	  	  Class.forName("com.mysql.cj.jdbc.Driver");
    				Connection con=DriverManager.getConnection("jdbc:mysql://127.0.0.1:3306/fitnessclub","root","pallavi");
    				st=con.createStatement();
    				System.out.println(con);
    	       rs=st.executeQuery("select * from Mem_ber");
    	   
            if(ae.getSource()==badd)
           {
             check='A';
            tfid.setEnabled(true);
            tfname.setEnabled(true);
            taddr.setEnabled(true);
            tfmobno.setEnabled(true);
            tfemail.setEnabled(true);
            tfheight.setEnabled(true);
            tfweight.setEnabled(true);
            tfclubfees.setEnabled(true);
            tfjdate.setEnabled(true);
           instructor.setEnabled(true);
         gen.setEnabled(true);
         batch.setEnabled(true);
         subs.setEnabled(true);
    
        try {
        	System.out.println(con);
                st1 = con.createStatement();
                rs1 = st1.executeQuery("select count(mid) as count, max(mid)+1 as m_mid from mem_ber");
                while (rs1.next()) {
                    if (rs1.getInt(1) == 0) {
                        tfid.setText("1");
                    } else {
                        tfid.setText(String.valueOf(rs1.getInt(2)));
                    }
                }
            }  catch(Exception e) {
            	e.printStackTrace();
            }
        }
     else if(ae.getSource()==bdelete)
     {
               check='D';
              String s =JOptionPane.showInputDialog(this,"Enter ID No. Of That Member,Whose Data You Want To Delete"); 
              int mid=Integer.parseInt(s);
              int chk=searching(mid);
              if(chk==1)
               {
           	JOptionPane.showMessageDialog(this,"To Delete Record Of This Member Permanently Click On SAVE Button");
               }
            else
              {
            	JOptionPane.showMessageDialog(this,"Record Of Such a Member Is Not Found,So Can't Delete Any Record");
              }
       }
      else if(ae.getSource()==bsave)
      {
              if(check=='A')
              {
                                
                                       int id=Integer.parseInt(tfid.getText());
		String name=tfname.getText();
		String addr=taddr.getText();
		String mobno=tfmobno.getText();
		String email=tfemail.getText();
                                       String g=gen.getSelectedItem();
                                       String i=instructor.getSelectedItem();
                                       String b=batch.getSelectedItem();
		String dt=tfjdate.getText();
		
                                        String height=tfheight.getText();
                                        String weight=tfweight.getText();
                                        String s=subs.getSelectedItem();
		 String sal=tfclubfees.getText();

                 try
                {
                	 System.out.println(id+"','"+name+"','"+addr+"','"+mobno+"','"+email+"','"+g+"','"+i+"','"+b+"','"+dt+"','"+height+"','"+weight+"','"+s+"','"+sal);
	String str="insert into mem_ber values('"+id+"','"+name+"','"+addr+"','"+mobno+"','"+email+"','"+g+"','"+i+"','"+b+"','"+dt+"','"+height+"','"+weight+"','"+s+"','"+sal+"')";
                 st = con.createStatement();
  //st=con.createStatement();
                   st.executeUpdate(str);
                   JOptionPane.showMessageDialog(this,"Record Is Added Successfully");            
                   rs=st.executeQuery("select * from mem_ber order by mid");
                   tfid.setText("");
                tfname.setText("");
                taddr.setText("");
                tfmobno.setText("");
                tfemail.setText("");
                tfheight.setText("");
                tfweight.setText("");
                tfclubfees.setText("");
                tfjdate.setText("");
               instructor.select("");
               gen.select("");
               batch.select("");
               subs.select("");con.setAutoCommit(true);
           }
                 catch(Exception e) {
                		e.printStackTrace();
                	}
          }
          else if(check=='D')
          {
               try
               {
                      PreparedStatement psdelete=con.prepareStatement("delete from mem_ber where mid=?");
                      psdelete.setInt(1,Integer.parseInt(tfid.getText()));
            	   psdelete.executeUpdate();
            	   JOptionPane.showMessageDialog(this," Record Is deleted Successfully");            
            	    rs=st.executeQuery("select * from mem_ber order by mid");

                      tfid.setText("");
                tfname.setText("");
                taddr.setText("");
                tfmobno.setText("");
                tfemail.setText("");
                tfheight.setText("");
                tfweight.setText("");
                tfclubfees.setText("");
                tfjdate.setText("");
                instructor.select("");
              gen.select("");
             batch.select("");
             subs.select("");		
               }
               catch(Exception e) {
            		e.printStackTrace();
            	}
         }
           else if(check=='M')
           {
             try
             {
            PreparedStatement psmodify=con.prepareStatement("Update mem_ber set mname=?,maddr=?,mobno=?,emailid=?,gender=?,iname=?,batch=?,jdate=?,height=?,weight=?,subscription=?,clubfees=? where mid=?");
            psmodify.setString(1,tfname.getText());
            psmodify.setString(2,taddr.getText());
            psmodify.setString(3,tfmobno.getText());
            psmodify.setString(4,tfemail.getText());
            psmodify.setString(5,gen.getSelectedItem());
            psmodify.setString(6,instructor.getSelectedItem());
            psmodify.setString(7,batch.getSelectedItem());
            psmodify.setString(8,tfjdate.getText());
            psmodify.setString(9,tfheight.getText());
            psmodify.setString(10,tfweight.getText());
            psmodify.setString(11,subs.getSelectedItem());
            psmodify.setString(12,tfclubfees.getText());
            psmodify.setInt(13,Integer.parseInt(tfid.getText()));
            psmodify.executeUpdate();
            JOptionPane.showMessageDialog(this," Record Is Modified Successfully");            
            rs=st.executeQuery("select * from mem_ber order by mid");

                tfid.setText("");
                tfname.setText("");
                taddr.setText("");
                tfmobno.setText("");
                tfemail.setText("");
                tfheight.setText("");
                tfweight.setText("");
                tfclubfees.setText("");
                tfjdate.setText("");
                 instructor.select("");
                 gen.select("");
                 batch.select("");
                subs.select("");
          }
             catch(Exception e) {
            		e.printStackTrace();
            	}
            tfid.setEnabled(false);
           tfname.setEnabled(false);
           taddr.setEnabled(false);
          tfmobno.setEnabled(false);
          tfemail.setEnabled(false);
          tfheight.setEnabled(false);
          tfweight.setEnabled(false);
          tfclubfees.setEnabled(false);
          tfjdate.setEnabled(false);
          instructor.setEnabled(false);
         gen.setEnabled(false);
         batch.setEnabled(false);
         subs.setEnabled(false);
           }
     }   
         else if(ae.getSource()==bsearch)
         {
              String s =JOptionPane.showInputDialog(this,"Enter ID No. Of That Member,Whose Data You Want To Search"); 
              int mid=Integer.parseInt(s);
              int chk=searching(mid);
              if(chk==0)
             {
               JOptionPane.showMessageDialog(this,"Record Of Such a Member Is Not Found");
             }
             
         }
        else if(ae.getSource()==bmodify)
         {
                    check='M';
	String s =JOptionPane.showInputDialog(this,"Enter ID No. Of That Member,Whose Data You Want To Modify"); 
        	int mid=Integer.parseInt(s);
        	int chk=searching(mid);
                   if(chk==1)
        	{
           	   JOptionPane.showMessageDialog(this,"Make The Changes And Then Click On SAVE Button");
          	  tfid.setEnabled(true);
                     tfname.setEnabled(true);
                    taddr.setEnabled(true);
                    tfmobno.setEnabled(true);
                    tfemail.setEnabled(true);
                    tfheight.setEnabled(true);
                    tfweight.setEnabled(true);
                   tfclubfees.setEnabled(true);
                   tfjdate.setEnabled(true);
                   instructor.setEnabled(true);
                   gen.setEnabled(true);
                 batch.setEnabled(true);
                 subs.setEnabled(true);
                      }
                    else
          	{
            	  JOptionPane.showMessageDialog(this,"Record Of Such a Member Is Not Found,So Can't Modify Any Record");
          	}
         }
        else if(ae.getSource()==bclose)
         {
             dispose();
         }
    	    }
 	    catch(Exception e) {
 	  		e.printStackTrace();
 	  	}
    }
    int searching(int mid)
    {
    	try
        {
      	  Class.forName("com.mysql.cj.jdbc.Driver");
    			Connection con=DriverManager.getConnection("jdbc:mysql://127.0.0.1:3306/fitnessclub","root","pallavi");
    			st=con.createStatement();
           rs=st.executeQuery("select * from Mem_ber");
        }
        catch(Exception e) {
      		e.printStackTrace();
      	}
     int chk=0;
        try
        {
          int v1=0;
          String v2="",v3="",v4="",v5="",v6="",v7="",v8="",v9="",v10="", v11="",v12="",v13="";
        
          while(rs.next())
          {
            v1=rs.getInt(1);
            v2=rs.getString(2);      
            v3=rs.getString(3);
            v4=rs.getString(4);
            v5=rs.getString(5);
           v6=rs.getString(6);      
           v7=rs.getString(7);
           v8=rs.getString(8);
          v9=rs.getString(9);
          v10=rs.getString(10);
          v11=rs.getString(11);
          v12=rs.getString(12);
          v13= rs.getString(13);


            if(v1==mid)
            {
              tfid.setText(String.valueOf(v1));
              tfname.setText(v2);
              taddr.setText(v3);
              tfmobno.setText(v4);
              tfemail.setText(v5);
              gen.select(v6);
              instructor.select(v7);
              batch.select(v8);
              tfjdate.setText(v9);
              tfheight.setText(v10);
              tfweight.setText(v11);
              subs.select(v12);
              tfclubfees.setText(v13);
              chk=1;
              break;
            }
          }          
          rs.first();
          rs.previous();
        }
        catch(Exception e) {
        	e.printStackTrace();
        }
        return(chk);
  }
}
class MemberReport extends JFrame
{
 public MemberReport ()
 { 
 Container contentpane=getContentPane();
contentpane.setLayout(new BorderLayout());
String[] colHeads={"Member ID","Member Name","Address","Mobile No","Email ID","Gender","Instructor Name","Joining date","Select Batch","Member Height","Member Weight","Subscription","Club fees"};
Connection con=null;
Statement stmt=null;
ResultSet rs=null;
ArrayList values=new ArrayList();
  try 
 {
	  Class.forName("com.mysql.cj.jdbc.Driver");
		con=DriverManager.getConnection("jdbc:mysql://127.0.0.1:3306/fitnessclub","root","pallavi");
		stmt=con.createStatement();
rs=stmt.executeQuery("select * from mem_ber order by mid");
while(rs.next())
{
values.add(rs.getString(1));
values.add(rs.getString(2));
values.add(rs.getString(3));
values.add(rs.getString(4));
values.add(rs.getString(5));
values.add(rs.getString(6));
values.add(rs.getString(7));
values.add(rs.getString(8));
values.add(rs.getString(9));
values.add(rs.getString(10));
values.add(rs.getString(11));
values.add(rs.getString(12));
values.add(rs.getString(13));
}
}
  catch(Exception e) {
		e.printStackTrace();
	}
finally
{
try
{
if(con!=null)
{
con.close();
}
}
catch(Exception e) {
	e.printStackTrace();
}
}
int noOfRows=(values.size())/colHeads.length;
int no=0;
Object[][]data=new Object[noOfRows][colHeads.length];
System.out.println("no of records:"+noOfRows);
for(int i=0;i<noOfRows;i++)
{
for(int j=0;j<colHeads.length;j++)
{
String s=(String)values.get(no++);
data[i][j]=s;
}
}
JTable table=new JTable(data,colHeads);
int v=ScrollPaneConstants.VERTICAL_SCROLLBAR_ALWAYS;
int h=ScrollPaneConstants.HORIZONTAL_SCROLLBAR_ALWAYS;
JScrollPane jsp=new JScrollPane(table,v,h);
contentpane.add(jsp,BorderLayout.CENTER);
setVisible(true);
setSize(1000,600);
setTitle("Member Report");
}
}class Product extends JFrame implements ActionListener,ItemListener
{
      JLabel ltitle,lpid,lmid,lpdate,lpname,lprice,lqty,ltprice;
      JTextField tfpid,tfmid,tfpdate,tfprice,tfqty,tftprice;
      JButton badd,bsave,bsearch,bmodify,bclose,bdelete,bshow;
      Choice pname;
      Font f1,f2,f3,f4;
      Container c;
      Connection con;
      Statement st;
      ResultSet rs;
      Statement st1;
      ResultSet rs1;
     char check='X';
      public Product()
      {
          c=getContentPane();
          f1=new Font("Arial",Font.BOLD,30);
          f2=new Font("Times New Roman",Font.BOLD,20);
          f3=new Font("Times New Roman",Font.BOLD,16);
          f4=new Font("Times New Roman",Font.BOLD,12);
          c.setLayout(null);
          ltitle=new JLabel("Product Manipulation Form");
          ltitle.setFont(f1);
          ltitle.setForeground(Color.green);       
          setBounds(0,0,1000,750);
          c.add(ltitle);
          ltitle.setBounds(350,50,400,30);

          lpid=new JLabel("Product ID");
          lpid.setFont(f2);
          lpid.setForeground(Color.magenta);
          c.add(lpid);
          lpid.setBounds(300,130,200,25);  
          tfpid=new JTextField();
          tfpid.setFont(f2);
          c.add(tfpid);
          tfpid.setBounds(500,130,200,25);  

          lmid=new JLabel("Member ID");
          lmid.setFont(f2);
          lmid.setForeground(Color.magenta);
          c.add(lmid);
          lmid.setBounds(300,175,200,25);  
          tfmid=new JTextField();
          tfmid.setFont(f3);
          c.add(tfmid);
          tfmid.setBounds(500,175,200,25);

          lpdate=new JLabel("Product Date");
          lpdate.setFont(f2);
          lpdate.setForeground(Color.magenta);
          c.add(lpdate);
          lpdate.setBounds(300,220,200,25);  
          tfpdate=new JTextField();
          tfpdate.setFont(f3);
          c.add(tfpdate);
          tfpdate.setBounds(500,220,200,25);

          lpname=new JLabel("Product Name");
          lpname.setFont(f2);
          lpname.setForeground(Color.magenta);
          c.add(lpname);
          lpname.setBounds(300,275,200,25);  
          pname=new Choice();
          c.add(pname);
          pname.add("Select");pname.add("Hydro Bike");pname.add("Dumb bell");pname.add("cycle");pname.add("Fitness Machine");pname.add("Weights");
          pname.addItemListener(this);
          pname.setBounds(500,275,200,25);

          lprice=new JLabel("Product Price");
          lprice.setFont(f2);
          lprice.setForeground(Color.magenta);
          c.add(lprice);lprice.setBounds(300,320,200,25);  
          tfprice=new JTextField();
          tfprice.setFont(f3);
          c.add(tfprice);
          tfprice.setBounds(500,320,200,25);
         
          
          lqty=new JLabel("Product Quantity");
          lqty.setFont(f2);
          lqty.setForeground(Color.magenta);
          c.add(lqty);
          lqty.setBounds(300,375,200,25);  
          tfqty=new JTextField();
          tfqty.setFont(f3);
          c.add(tfqty);
          tfqty.setBounds(500,375,200,25);

         ltprice=new JLabel("Total Price");
          ltprice.setFont(f2);
        ltprice.setForeground(Color.magenta);
          c.add(ltprice);
          ltprice.setBounds(300,420,200,25);  
          tftprice=new JTextField();
          tftprice.setFont(f3);
          c.add(tftprice);
          tftprice.setBounds(500,420,200,25);

             badd=new JButton("Add");
         // badd.setBackground(Color.orange);
        //  badd.setForeground(Color.white);
          bdelete=new JButton("Detete");
         // bdelete.setBackground(Color.green);
          bsave=new JButton("Save");
         //bsave.setBackground(Color.green);
          bmodify=new JButton("Modify");
         // bmodify.setBackground(Color.green);
          bsearch=new JButton("Search");
          //bsearch.setBackground(Color.green);
          bclose=new JButton("Close");
          //bclose.setBackground(Color.green);
         bshow=new JButton("Show Result");
          badd.setFont(f3);
          bsave.setFont(f3);
          bdelete.setFont(f3);
          bmodify.setFont(f3);
          bsearch.setFont(f3);
          bclose.setFont(f3);
          bshow.setFont(f3);
          badd.addActionListener(this);
          bsave.addActionListener(this);
          bdelete.addActionListener(this);
          bsearch.addActionListener(this);
          bmodify.addActionListener(this);
          bclose.addActionListener(this);    
          bshow.addActionListener(this);
         c.add(badd);
         c.add(bsave);
         c.add(bdelete);
         c.add(bmodify);
         c.add(bsearch);
         c.add(bclose);  
         c.add(bshow);
         badd.setBounds(250,520,70,30);
         bsave.setBounds(330,520,70,30);
         bdelete.setBounds(420,520,80,30);
         bmodify.setBounds(500,520,90,30);
         bsearch.setBounds(600,520,80,30);
         bclose.setBounds(690,520,80,30);
          bshow.setBounds(720,410,120,30);
            JLabel jl=new JLabel(new ImageIcon("leaf.jpg"));
        c.add(jl);
         jl.setBounds(0,0,1000,750);

         tfpid.setEnabled(false);
         tfmid.setEnabled(false);
         tfpdate.setEnabled(false);
         pname.setEnabled(false);
         tfprice.setEnabled(false);
         tfqty.setEnabled(false);
         tftprice.setEnabled(false);
         try
         {
        	 Class.forName("com.mysql.cj.jdbc.Driver");
     		con=DriverManager.getConnection("jdbc:mysql://127.0.0.1:3306/fitnessclub","root","pallavi");
     		st=con.createStatement(ResultSet.TYPE_SCROLL_SENSITIVE, ResultSet.CONCUR_UPDATABLE);
            rs=st.executeQuery("select * from Product order by pid");
        }
         catch(Exception e) {
        		e.printStackTrace();
        	}
    

           setTitle("Product Form");
           c.setLayout(null);
           setVisible(true);
           setBackground(Color.yellow);
           setBounds(0,0,1000,750);
      }
      public void actionPerformed(ActionEvent ae)
       {
           if(ae.getSource()==badd)
            {
                   check='A';
                   tfpid.setEnabled(true);
                  tfmid.setEnabled(true);
                  tfpdate.setEnabled(true);
                  pname.setEnabled(true);
                  tfprice.setEnabled(true);
                 tfqty.setEnabled(true);
                 tftprice.setEnabled(true);

                  try {
                     st1 = con.createStatement();
                    rs1 = st1.executeQuery("select count(pid) as count, max(pid)+1 as m_pid from Product");
                    while (rs1.next()) {
                    if (rs1.getInt(1) == 0) {
                        tfpid.setText("1");
                    } else {
                        tfpid.setText(String.valueOf(rs1.getInt(2)));
                    }
                }
            } catch(Exception e) {
            	e.printStackTrace();
            }			
             }
         else  if(ae.getSource()==bdelete)
            {
                  check='D';
                   String s =JOptionPane.showInputDialog(this,"Enter ID No. Of That Product,Whose Data You Want To Delete"); 
       	int pid=Integer.parseInt(s);
       	int chk=searching(pid);
      	if(chk==1)
       	{
           	   JOptionPane.showMessageDialog(this,"To Delete Record Of This Product Permanently Click On SAVE Button");
        	}
        	else
          	{
            	    JOptionPane.showMessageDialog(this,"Record Of Such a Product Is Not Found,So Can't Delete Any Record");
             	}
             }
          else  if(ae.getSource()==bmodify)
            {
                    check='M';
	String s =JOptionPane.showInputDialog(this,"Enter ID No. Of That Product,Whose Data You Want To Modify"); 
        	int pid=Integer.parseInt(s);
        	int chk=searching(pid);
                   if(chk==1)
        	{
           	   JOptionPane.showMessageDialog(this,"Make The Changes And Then Click On SAVE Button");
          	 tfpid.setEnabled(true);
                  tfmid.setEnabled(true);
                  tfpdate.setEnabled(true);
                  pname.setEnabled(true);
                  tfprice.setEnabled(true);
                 tfqty.setEnabled(true);
                 tftprice.setEnabled(true);
          
        	}
        	else
          	{
            	   JOptionPane.showMessageDialog(this,"Record Of Such aProduct Is Not Found,So Can't Modify Any Record");
          	}        
             }
             else  if(ae.getSource()==bsearch)
            {
                     String s =JOptionPane.showInputDialog(this,"Enter ID No. Of That Product,Whose Data You Want To Search"); 
                     int pid=Integer.parseInt(s);
                     int chk=searching(pid);
                     if(chk==0)
                     {
                           JOptionPane.showMessageDialog(this,"Record Of Such a Product Is Not Found");
                     }
             }
           else  if(ae.getSource()==bsave)
            {
                       if(check=='A')
                   {
                    String id=tfpid.getText();
                    String mid=tfmid.getText();
                    String date=tfpdate.getText();
	String name=pname.getSelectedItem();
	String pr=tfprice.getText();
                    String qty=tfqty.getText();
                   	String tp=tftprice.getText();
	
                     try
	 {
	    String str="insert into Product values('"+id+"','"+mid+"','"+date+"','"+name+"','"+pr+"','"+qty+"','"+tp+"')";
                       st = con.createStatement();
//st=con.createStatement();
	    st.executeUpdate(str);
                       JOptionPane.showMessageDialog(this,"Record Is Added Successfully");            
                       rs=st.executeQuery("select * from Product order by pid");
                       tfpid.setText("");
                       tfmid.setText("");
                       tfpdate.setText("");
                       pname.select("");
                       tfprice.setText("");
                       tfqty.setText("");
                       tftprice.setText("");        				
                   }
                     catch(Exception e) {
                    		e.printStackTrace();
                    	}
                }
                   else if(check=='D')
                    {
                        try
          	    {
            	        PreparedStatement psdelete=con.prepareStatement("delete from Product where pid=?");
            	        psdelete.setInt(1,Integer.parseInt(tfpid.getText()));
                            //psdelete.setInt(2,Integer.parseInt(tfmid.getText()));
                             //psdelete.setInt(5,Integer.parseInt(tfprice.getText()));
                          // psdelete.setInt(6,Integer.parseInt(tfqty.getText()));
                              //psdelete.setInt(7,Integer.parseInt(tftprice.getText()));
            	        psdelete.executeUpdate();
            	        JOptionPane.showMessageDialog(this," Record Is deleted Successfully");            
            	        rs=st.executeQuery("select * from Product order by pid");
         	 }
                        catch(Exception e) {
                        	e.printStackTrace();
                        }
                	     tfpid.setText("");
                       tfmid.setText("");
                       tfpdate.setText("");
                       pname.select("");
                       tfprice.setText("");
                       tfqty.setText("");
                       tftprice.setText(""); 				
                    }
                   else if(check=='M')
                    {
                                   try
                                   {
                                     PreparedStatement psmodify=con.prepareStatement("Update Product set mid=?,pdate=?,pname=?,price=?,qty=?,tprice=? where pid=?");
                                     psmodify.setString(1,tfmid.getText());
                                     psmodify.setString(2,tfpdate.getText());
                                     psmodify.setString(3,pname.getSelectedItem());
                                     psmodify.setString(4,tfprice.getText());
                                     psmodify.setString(5,tfqty.getText());
                                     psmodify.setString(6,tftprice.getText());
                                     psmodify.setInt(7,Integer.parseInt(tfpid.getText()));
                                    psmodify.executeUpdate();
                                    JOptionPane.showMessageDialog(this," Record Is Modified Successfully");            
                                    rs=st.executeQuery("select * from Product order by pid");
                                  }
                                   catch(Exception e) {
                                		e.printStackTrace();
                                	}
                        tfpid.setText("");
                       tfmid.setText("");
                       tfpdate.setText("");
                       pname.select("");
                       tfprice.setText("");
                       tfqty.setText("");
                       tftprice.setText("");	
                      tfpid.setEnabled(false);
                     tfmid.setEnabled(false);
                     tfpdate.setEnabled(false);
                     pname.setEnabled(false);
                     tfprice.setEnabled(false);
                      tfqty.setEnabled(false);
                     tftprice.setEnabled(false);
         
                     }
             }
            else if(ae.getSource()==bclose)
            {
                     dispose();
             }

              else if(ae.getSource()==bshow)
               {
                     try
                      {
                            int n1=Integer.parseInt(tfprice.getText());
                             int n2=Integer.parseInt(tfqty.getText());
                             int n3=n1*n2;
                             tftprice.setText(String.valueOf(n3));
                       }
                     catch(Exception e) {
                    		e.printStackTrace();
                    	}
                }
        }
 int searching(int pid)
    {
     int chk=0;
        try
        {
          int v1=0;
          String v3="",v4="",v2="",v5="",v6="",v7="";
        
          while(rs.next())
          {
            v1=rs.getInt(1);
            v2=rs.getString(2);      
            v3=rs.getString(3);
            v4=rs.getString(4);
            v5=rs.getString(5);
           v6=rs.getString(6);      
           v7=rs.getString(7);
                     
            if(v1==pid)
            {
              tfpid.setText(String.valueOf(v1));
              tfmid.setText(v2);
              tfpdate.setText(v3);
              pname.select(v4);
              tfprice.setText(v5);
              tfqty.setText(v6);
              tftprice.setText(v7);
               
              chk=1;
              break;
            }
          }          
          rs.first();
          rs.previous();
        }
        catch(Exception e) {
        	e.printStackTrace();
        }
        return(chk);
  }
      public void itemStateChanged(ItemEvent ie)
      {
              
               if(ie.getSource()==pname && ie.getStateChange()==ItemEvent.SELECTED)
                {   
                 if(pname.getSelectedItem()=="Hydro Bike")
                     {
                         tfprice.setText("2000");
                     }
                    else if(pname.getSelectedItem()=="Dumb bell")
                   {
                       tfprice.setText("500");
                   }           
                   else if(pname.getSelectedItem()=="cycle")
                   {
                       tfprice.setText("1500");
                   }           
                   else if(pname.getSelectedItem()=="Fitness Machine")
                   {
                       tfprice.setText("8000");
                   }
                    else if(pname.getSelectedItem()=="Weights")
                   {
                       tfprice.setText("5000");
                   }           
                 else if(pname.getSelectedItem()=="Select")
                   {
                       tfprice.setText("");
                   }           
         }
             
      }
}
 class ProductReport extends JFrame
{
 public ProductReport()
 { 
 Container contentpane=getContentPane();
contentpane.setLayout(new BorderLayout());
String[] colHeads={"Product ID","Member ID","Product Date","Product Name","Product Price","Product Quantity","Total Price"};
Connection con=null;
Statement stmt=null;
ResultSet rs=null;
ArrayList values=new ArrayList();
  try 
 {Class.forName("com.mysql.cj.jdbc.Driver");
	con=DriverManager.getConnection("jdbc:mysql://127.0.0.1:3306/fitnessclub","root","pallavi");
	stmt=con.createStatement();
rs=stmt.executeQuery("select * from Product order by pid");
while(rs.next())
{
values.add(rs.getString(1));
values.add(rs.getString(2));
values.add(rs.getString(3));
values.add(rs.getString(4));
values.add(rs.getString(5));
values.add(rs.getString(6));
values.add(rs.getString(7));

}
}
  catch(Exception e) {
		e.printStackTrace();
	}
finally
{
try
{
if(con!=null)
{
con.close();
}
}
catch(Exception e) {
	e.printStackTrace();
}
}
int noOfRows=(values.size())/colHeads.length;
int no=0;
Object[][]data=new Object[noOfRows][colHeads.length];
System.out.println("no of records:"+noOfRows);
for(int i=0;i<noOfRows;i++)
{
for(int j=0;j<colHeads.length;j++)
{
String s=(String)values.get(no++);
data[i][j]=s;
}
}
JTable table=new JTable(data,colHeads);
int v=ScrollPaneConstants.VERTICAL_SCROLLBAR_ALWAYS;
int h=ScrollPaneConstants.HORIZONTAL_SCROLLBAR_ALWAYS;
JScrollPane jsp=new JScrollPane(table,v,h);
contentpane.add(jsp,BorderLayout.CENTER);
setVisible(true);
setSize(1000,600);
setTitle("Product Report");
}
}class Services extends JFrame implements ActionListener,ItemListener
{
      JLabel ltitle,lsid,lmid,lsdate,lsname,lsamt;
      JTextField tfsid,tfmid,tfsdate,tfsamt;
      JButton badd,bsave,bsearch,bmodify,bclose,bdelete;
      Choice sname;
      Font f1,f2,f3,f4;
      Container c;
      Connection con;
      Statement st;
      ResultSet rs;
        Statement st1;
      ResultSet rs1;
     char check='X';
      public Services()
      {
          c=getContentPane();
          f1=new Font("Arial",Font.BOLD,30);
          f2=new Font("Times New Roman",Font.BOLD,20);
          f3=new Font("Times New Roman",Font.BOLD,16);
          f4=new Font("Times New Roman",Font.BOLD,12);
          c.setLayout(null);
          ltitle=new JLabel("Services Manipulation Form");
          ltitle.setFont(f1);
          ltitle.setForeground(Color.green);       
          setBounds(100,50,800,650);
          c.add(ltitle);
          ltitle.setBounds(250,60,450,30);

          lsid=new JLabel("Services ID");
          lsid.setFont(f2);
          lsid.setForeground(Color.blue);
          c.add(lsid);
          lsid.setBounds(200,130,200,25);  
          tfsid=new JTextField();
          tfsid.setFont(f2);
          c.add(tfsid);
          tfsid.setBounds(400,130,200,25);  

          lmid=new JLabel("Member ID");
          lmid.setFont(f2);
            lmid.setForeground(Color.blue);
          c.add(lmid);
          lmid.setBounds(200,175,200,25);  
          tfmid=new JTextField();
          tfmid.setFont(f3);
          c.add(tfmid);
          tfmid.setBounds(400,175,200,25);

          lsdate=new JLabel("Services Date");
          lsdate.setFont(f2);
           lsdate.setForeground(Color.blue);
          c.add(lsdate);
          lsdate.setBounds(200,220,200,25);  
          tfsdate=new JTextField();
          tfsdate.setFont(f3);
          c.add(tfsdate);
          tfsdate.setBounds(400,220,200,25);

          lsname=new JLabel("Services Name");
          lsname.setFont(f2);
           lsname.setForeground(Color.blue);
          c.add(lsname);
          lsname.setBounds(200,275,200,25);  
          sname=new Choice();
          c.add(sname);
          sname.add("Select");sname.add("Using Hydro Bike");sname.add("Using Dumb bell");sname.add("Using cycle");sname.add("Using Fitness Machine");sname.add("Using Weights");
          sname.addItemListener(this);
          sname.setBounds(400,275,200,25);

          lsamt=new JLabel("Service Ammount");
          lsamt.setFont(f2);
           lsamt.setForeground(Color.blue);
          c.add(lsamt);
          lsamt.setBounds(200,320,200,25);  
          tfsamt=new JTextField();
          tfsamt.setFont(f3);
          c.add(tfsamt);
          tfsamt.setBounds(400,320,200,25);
         
          
              badd=new JButton("Add");
         // badd.setBackground(Color.orange);
        //  badd.setForeground(Color.white);
          bdelete=new JButton("Detete");
         // bdelete.setBackground(Color.green);
          bsave=new JButton("Save");
         //bsave.setBackground(Color.green);
          bmodify=new JButton("Modify");
         // bmodify.setBackground(Color.green);
          bsearch=new JButton("Search");
          //bsearch.setBackground(Color.green);
          bclose=new JButton("Close");
          //bclose.setBackground(Color.green);
          badd.setFont(f3);
          bsave.setFont(f3);
          bdelete.setFont(f3);
          bmodify.setFont(f3);
          bsearch.setFont(f3);
          bclose.setFont(f3);
          badd.addActionListener(this);
          bsave.addActionListener(this);
          bdelete.addActionListener(this);
          bsearch.addActionListener(this);
          bmodify.addActionListener(this);
          bclose.addActionListener(this);    

         c.add(badd);
         c.add(bsave);
         c.add(bdelete);
         c.add(bmodify);
         c.add(bsearch);
         c.add(bclose);  

         badd.setBounds(180,450,70,30);
         bsave.setBounds(260,450,70,30);
         bdelete.setBounds(340,450,80,30);
         bmodify.setBounds(430,450,90,30);
         bsearch.setBounds(530,450,80,30);
         bclose.setBounds(620,450,80,30);

         JLabel jl=new JLabel(new ImageIcon("s.jpg"));
         c.add(jl);
         jl.setBounds(0,0,800,650);

         tfsid.setEnabled(false);
         tfmid.setEnabled(false);
         tfsdate.setEnabled(false);
         sname.setEnabled(false);
         tfsamt.setEnabled(false);
         
         try
         {
        	 Class.forName("com.mysql.cj.jdbc.Driver");
     		con=DriverManager.getConnection("jdbc:mysql://127.0.0.1:3306/fitnessclub","root","pallavi");
     		st=con.createStatement(ResultSet.TYPE_SCROLL_SENSITIVE, ResultSet.CONCUR_UPDATABLE);
            rs=st.executeQuery("select * from Services order by sid");
        }
         catch(Exception e) {
        		e.printStackTrace();
        	}
            setTitle("Services Form");
           c.setLayout(null);
           setVisible(true);
           setBackground(Color.yellow);
          // setBounds(0,0,1000,750);
      }

         public void itemStateChanged(ItemEvent ie)
      {
              
               if(ie.getSource()==sname && ie.getStateChange()==ItemEvent.SELECTED)
              {   
               if(sname.getSelectedItem()=="Using Hydro Bike")
                     {
                         tfsamt.setText("100");
                     }
                    else if(sname.getSelectedItem()=="Using Dumb bell")
                   {
                       tfsamt.setText("100");
                   }           
                   else if(sname.getSelectedItem()=="Using cycle")
                   {
                       tfsamt.setText("200");
                   }           
                   else if(sname.getSelectedItem()=="Using Fitness Machine")
                   {
                       tfsamt.setText("300");
                   }
                    else if(sname.getSelectedItem()=="Using Weights")
                   {
                       tfsamt.setText("100");
                   }  
                  else if(sname.getSelectedItem()=="Select")
                   {
                       tfsamt.setText("");
                   }           
         
          
           }    
      }         
      public void actionPerformed(ActionEvent ae)
       {
           if(ae.getSource()==badd)
            {
                   check='A';
                   tfsid.setEnabled(true);
                  tfmid.setEnabled(true);
                  tfsdate.setEnabled(true);
                  sname.setEnabled(true);
                  tfsamt.setEnabled(true);
                   try {
                st1 = con.createStatement();
                rs1 = st1.executeQuery("select count(sid) as count, max(sid)+1 as m_sid from Services");
                while (rs1.next()) {
                    if (rs1.getInt(1) == 0) {
                        tfsid.setText("1");
                    } else {
                        tfsid.setText(String.valueOf(rs1.getInt(2)));
                    }
                }
            }  catch(Exception e) {
            	e.printStackTrace();
            }
             }
         else  if(ae.getSource()==bdelete)
            {
                  check='D';
                   String s =JOptionPane.showInputDialog(this,"Enter ID No. Of That Service,Whose Data You Want To Delete"); 
       	int sid=Integer.parseInt(s);
       	int chk=searching(sid);
      	if(chk==1)
       	{
           	   JOptionPane.showMessageDialog(this,"To Delete Record Of This Service Permanently Click On SAVE Button");
        	}
        	else
          	{
            	    JOptionPane.showMessageDialog(this,"Record Of Such a Service Is Not Found,So Can't Delete Any Record");
             	}
             }
          else  if(ae.getSource()==bmodify)
            {
                    check='M';
	String s =JOptionPane.showInputDialog(this,"Enter ID No. Of That Service,Whose Data You Want To Modify"); 
        	int sid=Integer.parseInt(s);
        	int chk=searching(sid);
                   if(chk==1)
        	{
           	   JOptionPane.showMessageDialog(this,"Make The Changes And Then Click On SAVE Button");
          	tfsid.setEnabled(true);
                  tfmid.setEnabled(true);
                  tfsdate.setEnabled(true);
                  sname.setEnabled(true);
                  tfsamt.setEnabled(true);
          
        	}
        	else
          	{
            	   JOptionPane.showMessageDialog(this,"Record Of Such a Service Is Not Found,So Can't Modify Any Record");
          	}        
             }
             else  if(ae.getSource()==bsearch)
            {
                     String s =JOptionPane.showInputDialog(this,"Enter ID No. Of That Service,Whose Data You Want To Search"); 
                     int sid=Integer.parseInt(s);
                     int chk=searching(sid);
                     if(chk==0)
                     {
                           JOptionPane.showMessageDialog(this,"Record Of Such a Service Is Not Found");
                     }
             }
           else  if(ae.getSource()==bsave)
            {
                       if(check=='A')
                   {
                    String id=tfsid.getText();
                    String mid=tfmid.getText();
                    String date=tfsdate.getText();
	String name=sname.getSelectedItem();
	String pr=tfsamt.getText();
                     try
	 {
	    String str="insert into Services values('"+id+"','"+mid+"','"+date+"','"+name+"','"+pr+"')";
                       st = con.createStatement();
//st=con.createStatement();
	    st.executeUpdate(str);
                       JOptionPane.showMessageDialog(this,"Record Is Added Successfully");            
                       rs=st.executeQuery("select * from Services order by sid");
                       tfsid.setText("");
                       tfmid.setText("");
                       tfsdate.setText("");
                       sname.select("");
                       tfsamt.setText("");
                  }
                     catch(Exception e) {
                    		e.printStackTrace();
                    	}
                }
                   else if(check=='D')
                    {
                        try
          	    {
            	        PreparedStatement psdelete=con.prepareStatement("delete from Services where sid=?");
            	        psdelete.setInt(1,Integer.parseInt(tfsid.getText()));
                            //psdelete.setInt(2,Integer.parseInt(tfmid.getText()));
                             //psdelete.setInt(5,Integer.parseInt(tfsamt.getText()));
                              psdelete.executeUpdate();
            	        JOptionPane.showMessageDialog(this," Record Is deleted Successfully");            
            	        rs=st.executeQuery("select * from Services order by sid");
         	 }
                        catch(Exception e) {
                        	e.printStackTrace();
                        }
                	    tfsid.setText("");
                       tfmid.setText("");
                       tfsdate.setText("");
                       sname.select("");
                       tfsamt.setText("");				
                    }
                   else if(check=='M')
                    {
                                   try
                                   {
                                     PreparedStatement psmodify=con.prepareStatement("Update services set mid=?,sdate=?,sname=?,samt=? where sid=?");
                                     psmodify.setString(1,tfmid.getText());
                                     psmodify.setString(2,tfsdate.getText());
                                     psmodify.setString(3,sname.getSelectedItem());
                                     psmodify.setString(4,tfsamt.getText());
                                    psmodify.setInt(5,Integer.parseInt(tfsid.getText()));
                                    psmodify.executeUpdate();
                                    JOptionPane.showMessageDialog(this," Record Is Modified Successfully");            
                                    rs=st.executeQuery("select * from Services order by sid");
                                  }
                                   catch(Exception e) {
                                		e.printStackTrace();
                                	}
                        tfsid.setText("");
                       tfmid.setText("");
                       tfsdate.setText("");
                       sname.select("");
                       tfsamt.setText("");	
                       tfsid.setEnabled(false);
                       tfmid.setEnabled(false);
                       tfsdate.setEnabled(false);
                       sname.setEnabled(false);
                       tfsamt.setEnabled(false);
         
                     }
             }
            else if(ae.getSource()==bclose)
            {
                     dispose();
             }

        }
 int searching(int sid)
    {
     int chk=0;
        try
        {
          int v1=0;
          String v3="",v4="",v2="",v5="";
        
          while(rs.next())
          {
            v1=rs.getInt(1);
            v2=rs.getString(2);      
            v3=rs.getString(3);
            v4=rs.getString(4);
            v5=rs.getString(5);
                               
            if(v1==sid)
            {
              tfsid.setText(String.valueOf(v1));
              tfmid.setText(v2);
              tfsdate.setText(v3);
              sname.select(v4);
              tfsamt.setText(v5);
                            
              chk=1;
              break;
            }
          }          
          rs.first();
          rs.previous();
        }
        catch(Exception e) {
        	e.printStackTrace();
        }
        return(chk);
  }
      
}
class ServicesReport extends JFrame
{
 public ServicesReport ()
 { 
 Container contentpane=getContentPane();
contentpane.setLayout(new BorderLayout());
String[] colHeads={"Services ID","Member ID","Services Date","Services Name","Service Ammount"};
Connection con=null;
Statement stmt=null;
ResultSet rs=null;
ArrayList values=new ArrayList();
  try 
 {
	  Class.forName("com.mysql.cj.jdbc.Driver");
		con=DriverManager.getConnection("jdbc:mysql://127.0.0.1:3306/fitnessclub","root","pallavi");
		stmt=con.createStatement();
rs=stmt.executeQuery("select * from Services order by sid");
while(rs.next())
{
values.add(rs.getString(1));
values.add(rs.getString(2));
values.add(rs.getString(3));
values.add(rs.getString(4));
values.add(rs.getString(5));

}
}
  catch(Exception e) {
		e.printStackTrace();
	}
finally
{
try
{
if(con!=null)
{
con.close();
}
}
catch(Exception e) {
	e.printStackTrace();
}
}
int noOfRows=(values.size())/colHeads.length;
int no=0;
Object[][]data=new Object[noOfRows][colHeads.length];
System.out.println("no of records:"+noOfRows);
for(int i=0;i<noOfRows;i++)
{
for(int j=0;j<colHeads.length;j++)
{
String s=(String)values.get(no++);
data[i][j]=s;
}
}
JTable table=new JTable(data,colHeads);
int v=ScrollPaneConstants.VERTICAL_SCROLLBAR_ALWAYS;
int h=ScrollPaneConstants.HORIZONTAL_SCROLLBAR_ALWAYS;
JScrollPane jsp=new JScrollPane(table,v,h);
contentpane.add(jsp,BorderLayout.CENTER);
setVisible(true);
setSize(1000,600);
setTitle("Services Report");
}
}class Update extends JFrame implements ActionListener,ItemListener
{
    JComboBox jcb;
    JLabel l,name,per;
    JTextField t1,t2;
    JButton up,fetch;
    Connection con=null;
    Statement stmt=null;
    ResultSet rs=null;
    Container c;
    Update()
    {
       setSize(1000,400);
       setVisible(true);
       setTitle("Form");
       jcb=new JComboBox();
       name=new JLabel("Name :");
       per=new JLabel("Perentege :");
       t1=new JTextField(20);
       t2=new JTextField(20);
       c=getContentPane();
       c.setLayout(new FlowLayout());
       l=new JLabel("Roll No :");
       c.add(l);
       c.add(jcb);
       fetch=new JButton("Fetch");
       fetch.addActionListener(this);
       c.add(fetch);
       c.add(name);
       c.add(t1);
       c.add(per);
       c.add(t2);
       try
       {
          Class.forName("sun.jdbc.odbc.JdbcOdbcDriver");
          con=DriverManager.getConnection("jdbc:odbc:sale");
          String str="select * from Student";
          stmt=con.createStatement();
          rs=stmt.executeQuery(str); 
          while(rs.next())
           {
             jcb.addItem(rs.getInt(1));
             rs.close();
            }
            }
       catch(Exception e) {
    		e.printStackTrace();
    	}
            up=new JButton("Update");
            up.addActionListener(this);
            c.add(up);
     }
    public void actionPerformed(ActionEvent ae)
    {
        if(ae.getSource()==up)
         {
             Integer i=(Integer)jcb.getSelectedItem();
             String name=t1.getText();
             if(name.equals(""))
              {
                 JOptionPane.showMessageDialog(this,"Enter Your Name");
                 return;
               }
              float per=0;
              try
              {
                 per=Float.parseFloat(t2.getText());
                  if(per<=0)
                  {
                       JOptionPane.showMessageDialog(this,"Enter Your Percentage");
                  }  
              }
              catch(Exception e) {
            		e.printStackTrace();
            	}
              int r;
              try
              {
                  r=stmt.executeUpdate("Update Student set name='"+name+"',per="+per+" where roll="+i.intValue());
                  if(r==1)
                  {
                     JOptionPane.showMessageDialog(this,"Update Successfully");
                  }
              }
              catch(Exception e) {
            		e.printStackTrace();
            	}
          }
         else if(ae.getSource()==fetch)
         {
             Integer i=(Integer)jcb.getSelectedItem();
              try
              {
                   String str="select * from Student where roll="+i.intValue();
                   rs=stmt.executeQuery(str);
                   if(rs.next())
                    {
                        t1.setText(rs.getString(2));
                        t2.setText(rs.getString(3));
                     } 
                       rs.close();
               }
              catch(Exception e) {
            		e.printStackTrace();
            	}
         }
     }
     public void itemStateChanged(ItemEvent ie)
     {
      }
}class BillForm extends JFrame implements ActionListener,ItemListener
{
   JLabel ltitle,lbno,lbdate,lmid,lmname,lpname,lpcost,lsname,lsamt,lclubfees,ltotal;
   JTextField tfbno,tfbdate,tfmid,tfmname,tfpname,tfpcost,tfsname,tfsamt,tfclubfees,tftotal;
   JButton bdelete,bprint,bsearch,bsave,bclose,badd,bshow;
   Font f1,f2,f3,f4;
   Container c;
   Connection con;
    Statement st;
    ResultSet rs;
    Statement st1;
    ResultSet rs1;
    char check='X';
   public BillForm()
   {
        f1=new Font("Arial",Font.BOLD,25);
        f2=new Font("Times New Roman",Font.BOLD,20);
        f3=new Font("Times New Roman",Font.BOLD,14);
        c=getContentPane();
        c.setLayout(null);

        ltitle=new JLabel("Bill Generation");
        ltitle.setFont(f1);
        ltitle.setForeground(Color.yellow);
        c.add(ltitle);
        setBounds(0,0,1020,730);
        ltitle.setBounds(450,50,200,30);

        lbno=new JLabel("Bill No.");
        lbno.setFont(f2);
       c.add(lbno);
        lbno.setBounds(300,110,200,25);
        tfbno=new JTextField();
        lbno.setForeground(Color.magenta);
        tfbno.setFont(f2);
       c.add(tfbno);
        tfbno.setBounds(500,110,200,25);

        lbdate=new JLabel("Bill Date");
        lbdate.setFont(f2);
        lbdate.setForeground(Color.magenta);
       c.add(lbdate);
        lbdate.setBounds(300,155,200,25);
        tfbdate=new JTextField();
        tfbdate.setFont(f2);
       c.add(tfbdate);
        tfbdate.setBounds(500,155,200,25);

        lmid=new JLabel("Member ID");
        lmid.setForeground(Color.magenta);
        lmid.setFont(f2);
       c.add(lmid);
        lmid.setBounds(300,200,200,25);
        tfmid=new JTextField();
        tfmid.setFont(f2);
         
       c.add(tfmid);
        tfmid.setBounds(500,200,200,25);
        try{
        int m=Integer.parseInt(tfmid.getText());
         if(m<=0)
         {
              JOptionPane.showMessageDialog(this,"You Enter Invalid Data,Please enter correct data");
         }}catch(Exception e){e.printStackTrace();}
        lmname=new JLabel("Member Name");
        lmname.setFont(f2);
        lmname.setForeground(Color.magenta);
       c.add(lmname);
        lmname.setBounds(300,245,200,25);
        tfmname=new JTextField();
        tfmname.setFont(f2);
       c.add(tfmname);
        tfmname.setBounds(500,245,200,25);
 
        lpname=new JLabel("Product Name");
        lpname.setFont(f2);
        lpname.setForeground(Color.magenta);
       c.add(lpname);
        lpname.setBounds(300,290,200,25);
        tfpname=new JTextField();
        tfpname.setFont(f2);
       c.add(tfpname);
        tfpname.setBounds(500,290,200,25);

         lpcost=new JLabel("Product Total Cost");
        lpcost.setFont(f2);
       lpcost.setForeground(Color.magenta);
       c.add(lpcost);
        lpcost.setBounds(300,335,200,25);
        tfpcost=new JTextField();
        tfpcost.setFont(f2);
       c.add(tfpcost);
        tfpcost.setBounds(500,335,200,25);

        lsname=new JLabel("Services Name");
        lsname.setFont(f2);
         lsname.setForeground(Color.magenta);
       c.add(lsname);
        lsname.setBounds(300,380,200,25);
        tfsname=new JTextField();
        tfsname.setFont(f2);
       c.add(tfsname);
        tfsname.setBounds(500,380,200,25);

        lsamt=new JLabel("Services Amount");
        lsamt.setFont(f2);
        lsamt.setForeground(Color.magenta);
       c.add(lsamt);
        lsamt.setBounds(300,425,200,25);
        tfsamt=new JTextField();
        tfsamt.setFont(f2);
       c.add(tfsamt);
        tfsamt.setBounds(500,425,200,25);

         lclubfees=new JLabel("Clubfees");
        lclubfees.setFont(f2);
        lclubfees.setForeground(Color.magenta);
       c.add(lclubfees);
        lclubfees.setBounds(300,470,200,25);
        tfclubfees=new JTextField();
        tfclubfees.setFont(f2);
       c.add(tfclubfees);
        tfclubfees.setBounds(500,470,200,25);

        ltotal=new JLabel("Total");
        ltotal.setForeground(Color.magenta);
        ltotal.setFont(f2);
       c.add(ltotal);
        ltotal.setBounds(300,515,200,25);
        tftotal=new JTextField();
        tftotal.setFont(f2);
       c.add(tftotal);
        tftotal.setBounds(500,515,200,25);

        bprint=new JButton("Print");
        bdelete=new JButton("Detete");
        bsave=new JButton("Save");
        badd=new JButton("Add");
       bsearch=new JButton("Search");
       bclose=new JButton("Close");
       bshow=new JButton("Show Result");
       bprint.setFont(f3);
       bsave.setFont(f3);
       bdelete.setFont(f3);
       bshow.setFont(f3);
       bsearch.setFont(f3);
       bclose.setFont(f3);
       badd.setFont(f3);
       bprint.addActionListener(this);
       bsave.addActionListener(this);
       bdelete.addActionListener(this);
       bsearch.addActionListener(this);
       bshow.addActionListener(this);
       bclose.addActionListener(this);
       badd.addActionListener(this);
 
         c.add(bprint);
        c.add(bsave);
        c.add(bdelete);
        c.add(bsearch);
        c.add(bclose);
        c.add(badd); 
        c.add(bshow);      

        bprint.setBounds(280,600,80,25);
        bsave.setBounds(370,600,80,25);
        bdelete.setBounds(460,600,80,25);
        bsearch.setBounds(550,600,80,25);
        bclose.setBounds(640,600,80,25);
        badd.setBounds(730,600,80,25);
        bshow.setBounds(720,505,120,30);
        tfbno.setEnabled(false);
        tfbdate.setEnabled(false);
        tfmid.setEnabled(false);
        tfmname.setEnabled(false);
        tfpname.setEnabled(false);
        tfpcost.setEnabled(false);
        tfsname.setEnabled(false);
        tfsamt.setEnabled(false);
        tfclubfees.setEnabled(false);
        tftotal.setEnabled(false);
          
        JLabel jl=new JLabel(new ImageIcon("background.jpg"));
         c.add(jl);
         jl.setBounds(0,0,1020,730);

        try
        {
        	Class.forName("com.mysql.cj.jdbc.Driver");
     		con=DriverManager.getConnection("jdbc:mysql://127.0.0.1:3306/fitnessclub","root","pallavi");
     		st=con.createStatement(ResultSet.TYPE_SCROLL_SENSITIVE, ResultSet.CONCUR_UPDATABLE);
            rs=st.executeQuery("select * from BillInfo order by bno");
        }
        catch(Exception e)
         {e.printStackTrace();}

        setTitle("Bill Generation");
        setVisible(true);
        setDefaultCloseOperation(DISPOSE_ON_CLOSE);
   }
public void actionPerformed(ActionEvent ae)
{
     if(ae.getSource()==bprint)
      {

       }
      else if(ae.getSource()==badd)
     {
         check='A';

        

        tfbno.setEnabled(true);
        tfbdate.setEnabled(true);
        tfmid.setEnabled(true);
        tfmname.setEnabled(true);
        tfpname.setEnabled(true);
        tfpcost.setEnabled(true);
        tfsname.setEnabled(true);
        tfsamt.setEnabled(true);
        tfclubfees.setEnabled(true);
        tftotal.setEnabled(true);

          try {
                     st1 = con.createStatement();
                    rs1 = st1.executeQuery("select count(bno) as count, max(bno)+1 as m_bno from BillInfo");
                    while (rs1.next()) {
                    if (rs1.getInt(1) == 0) {
                        tfbno.setText("1");
                    } else {
                        tfbno.setText(String.valueOf(rs1.getInt(2)));
                    }
                }
            } catch (Exception e) {e.printStackTrace();
            }
         
     }
     else if(ae.getSource()==bsave)
      {
                   if(check=='A')
                 {
                    String id=tfbno.getText();
	String date=tfbdate.getText();
	String m=tfmid.getText();
	String mn=tfmname.getText();
	String pn=tfpname.getText();
                    String pc=tfpcost.getText();
                   	String sn=tfsname.getText();
                    String samt=tfsamt.getText();
 	String cf=tfclubfees.getText();
                    String tot=tftotal.getText();
 	
                     try
	 {
	    String str="insert into BillInfo values('"+id+"','"+date+"','"+m+"','"+mn+"','"+pn+"','"+pc+"','"+sn+"','"+samt+"','"+cf+"','"+tot+"')";
                        st = con.createStatement(rs.TYPE_SCROLL_SENSITIVE, rs.CONCUR_UPDATABLE);
//st=con.createStatement();
	    st.executeUpdate(str);
                       JOptionPane.showMessageDialog(this,"Record Is Added Successfully");            
                       rs=st.executeQuery("select * from BillInfo order by bno");
                       tfbno.setText("");
                       tfbdate.setText("");
                       tfmid.setText("");
                       tfmname.setText("");
                      tfpname.setText("");
                      tfpcost.setText("");
                     tfsname.setText("");
                     tfsamt.setText("");             
                     tfclubfees.setText("");
                     tftotal.setText("");         				
                   }
                  catch(Exception se)
         	{se.printStackTrace();}
            }
           else if(check=='D')
          {
                   try
               {
                      PreparedStatement psdelete=con.prepareStatement("delete from BillInfo where bno=?");
                      psdelete.setInt(1,Integer.parseInt(tfbno.getText()));
            	   psdelete.executeUpdate();
            	   JOptionPane.showMessageDialog(this," Record Is deleted Successfully");            
            	    rs=st.executeQuery("select * from BillInfo order by bno");

                      tfbno.setText("");
                       tfbdate.setText("");
                       tfmid.setText("");
                       tfmname.setText("");
                      tfpname.setText("");
                      tfpcost.setText("");
                     tfsname.setText("");
                     tfsamt.setText("");             
                     tfclubfees.setText("");
                     tftotal.setText("");   	
               }
           catch(Exception ac)
               {ac.printStackTrace();}
          }
     }
    else if(ae.getSource()==bdelete)
      {
                   check='D';
                   String s =JOptionPane.showInputDialog(this,"Enter ID No. Of That Member,Whose Data You Want To Delete"); 
       	int bid=Integer.parseInt(s);
       	int chk=searching(bid);
      	if(chk==1)
       	{
           	   JOptionPane.showMessageDialog(this,"To Delete Record Of This Member Permanently Click On SAVE Button");
        	}
        	else
          	{
            	    JOptionPane.showMessageDialog(this,"Record Of Such a Member Is Not Found,So Can't Delete Any Record");
             	}
       }
     if(ae.getSource()==bsearch)
      {
           String s =JOptionPane.showInputDialog(this,"Enter ID No. Of That Member,Whose Data You Want To Search"); 
              int bid=Integer.parseInt(s);
              int chk=searching(bid);
              if(chk==0)
             {
               JOptionPane.showMessageDialog(this,"Record Of Such a Member Is Not Found");
             }      
       }
    else if(ae.getSource()==bclose)
      {
           dispose();
       }
     else if(ae.getSource()==bshow)
      {
         try
         {
          int n1=Integer.parseInt(tfpcost.getText());
          int n2=Integer.parseInt(tfsamt.getText());
          int n3=Integer.parseInt(tfclubfees.getText());
          int num=n1+n2+n3;
          tftotal.setText(String.valueOf(num));  
         }
        catch(Exception e)
       {e.printStackTrace(); }
       }
}
 int searching(int bid)
    {
     int chk=0;
        try
        {
          int v1=0;
          String v2="",v3="",v4="",v5="",v6="",v7="",v8="",v9="",v10="";
        
          while(rs.next())
          {
            v1=rs.getInt(1);
            v2=rs.getString(2);      
            v3=rs.getString(3);
            v4=rs.getString(4);
            v5=rs.getString(5);
           v6=rs.getString(6);      
           v7=rs.getString(7);
           v8=rs.getString(8);
           v9=rs.getString(9);
           v10=rs.getString(10);
          
            if(v1==bid)
            {
              tfbno.setText(String.valueOf(v1));
              tfbdate.setText(v2);
              tfmid.setText(v3);
              tfmname.setText(v4);
              tfpname.setText(v5);
               tfpcost.setText(v6);
               tfsname.setText(v7);
               tfsamt.setText(v8);
               tfclubfees.setText(v9);
               tftotal.setText(v10);
              chk=1;
              break;
            }
          }          
          rs.first();
          rs.previous();
        }
        catch(Exception se)
        {se.printStackTrace();}
        return(chk);
  }
public void itemStateChanged(ItemEvent ie)
{
              
}
}
class BillReport1 extends JFrame
{
 public BillReport1()
 { 
 Container contentpane=getContentPane();
contentpane.setLayout(new BorderLayout());
String[] colHeads={"Bill No.","Bill Date","Member ID","Member Name","Product Name","Product Price","Service Name","Service Amont","Club Fees","Total"};
Connection con=null;
Statement stmt=null;
ResultSet rs=null;
ArrayList values=new ArrayList();
  try 
 {
	  Class.forName("com.mysql.cj.jdbc.Driver");
		con=DriverManager.getConnection("jdbc:mysql://127.0.0.1:3306/fitnessclub","root","pallavi");
		stmt=con.createStatement();
rs=stmt.executeQuery("select * from BillInfo order by bno");
while(rs.next())
{
values.add(rs.getString(1));
values.add(rs.getString(2));
values.add(rs.getString(3));
values.add(rs.getString(4));
values.add(rs.getString(5));
values.add(rs.getString(6));
values.add(rs.getString(7));
values.add(rs.getString(8));
values.add(rs.getString(9));
values.add(rs.getString(10));
}
}
  catch(Exception e) {
		e.printStackTrace();
	}
finally
{
try
{
if(con!=null)
{
con.close();
}
}
catch(Exception e) {
	e.printStackTrace();
}
}
int noOfRows=(values.size())/colHeads.length;
int no=0;
Object[][]data=new Object[noOfRows][colHeads.length];
System.out.println("no of records:"+noOfRows);
for(int i=0;i<noOfRows;i++)
{
for(int j=0;j<colHeads.length;j++)
{
String s=(String)values.get(no++);
data[i][j]=s;
}
}
JTable table=new JTable(data,colHeads);
int v=ScrollPaneConstants.VERTICAL_SCROLLBAR_ALWAYS;
int h=ScrollPaneConstants.HORIZONTAL_SCROLLBAR_ALWAYS;
JScrollPane jsp=new JScrollPane(table,v,h);
contentpane.add(jsp,BorderLayout.CENTER);
setVisible(true);
setSize(1000,600);
setTitle("BillReport1");
}
}
class Employee extends Frame implements ActionListener,ItemListener
{
Label ltitle,lid,lname,laddr,lmobno,ldeptproj,ldob,lgen,lqual,lsal,ldesign;
TextField tfid1,tfname,tfmobno,tfdept,tfprojname,tfsal,tfdob;
TextArea taaddr;
Choice date1,month1,year1,gen,qual,design;
JPanel p;
Button badd,bdelete,bmodify,bsave,bsearch,bclose;
Font f1,f2,f3;
Connection con;
Statement st;
ResultSet rs;
char check='X';

    public Employee()
    {
      setSize(1000,750);
      setVisible(true);
      setBackground(Color.magenta);
      setLayout(null);
      f1=new Font("Arial Black",Font.BOLD,35);
      f2=new Font("Arial",Font.BOLD,21);
      f3=new Font("Arial",Font.BOLD,16);
      setTitle("Employee Details");
      ltitle=new Label("Employee Information Forms");
      add(ltitle);
      ltitle.setFont(f1);
      ltitle.setBackground(Color.blue);
      ltitle.setForeground(Color.yellow);

      lid=new Label("Employee ID");
      add(lid);
      lid.setFont(f2);

      lname=new Label("Employee Name");
      add(lname);
      lname.setFont(f2);

      laddr=new Label("Employee Address");
      add(laddr);
      laddr.setFont(f2);

      lmobno=new Label("Employee Mobile Number");
      add(lmobno);
      lmobno.setFont(f2);
       
      ldeptproj=new Label("Employee Dept. ID and Project Name");
      add(ldeptproj);
      ldeptproj.setFont(f2);

      ldob=new Label("Employee Date-Of-Birth  ");
      add(ldob);
      ldob.setFont(f2);

      lgen=new Label("Employee Gender");
      add(lgen);
      lgen.setFont(f2);

      lqual=new Label("Employee Qualification ");
      add(lqual);
      lqual.setFont(f2);

    /*  ltoe=new Label("Type-Of-Employee");
      add(ltoe);
      ltoe.setFont(f2); */

      lsal=new Label("Employee Monthly Salary"); 
      add(lsal);
      lsal.setFont(f2);

    ldesign=new Label("Employee Designation"); 
      add(ldesign);
      ldesign.setFont(f2);

   /*    date1=new Choice();
    date1.add("Select");
     date1.add("1"); date1.add("2"); date1.add("3");date1.add("4"); date1.add("5"); date1.add("6");
     date1.add("7"); date1.add("8");date1.add("9");date1.add("10"); date1.add("11");date1.add("12");
     date1.add("13");date1.add("14");date1.add("15"); date1.add("16");date1.add("17");date1.add("18");
     date1.add("19");date1.add("20"); date1.add("21");date1.add("22");date1.add("23");date1.add("24");
     date1.add("25"); date1.add("26");date1.add("27");date1.add("28");date1.add("29");date1.add    ("30");date1.add("31");
    add(date1);
     date1.addItemListener(this);

   month1=new Choice();
   month1.add("Select");
     month1.add("Jan"); month1.add("Feb"); month1.add("Mar");month1.add("April"); month1.add("May"); month1.add("June");
     month1.add("Jully"); month1.add("Aug");month1.add("Sept");month1.add("Oct"); month1.add("Nov");month1.add("Dec");
    add(month1);
     month1.addItemListener(this);
   
 year1=new Choice();
  year1.add("Select");
     year1.add("1983"); year1.add("1984"); year1.add("1985");year1.add("1986"); year1.add("1987"); year1.add("1988");
     year1.add("1989"); year1.add("1990");year1.add("1991");year1.add("1992"); year1.add("1993");year1.add("1994");year1.add("1995");
    add(year1);
     year1.addItemListener(this);*/

    qual=new Choice();
    qual.add("Select");
     qual.add("B.E.(Computer)"); qual.add("MCM(Master Of Computer  Management"); qual.add("M.Sc(Computer Science)");
   add(qual);
     qual.addItemListener(this);

 gen=new Choice();
    gen.add("Select");
     gen.add("Male"); gen.add("Female"); gen.add("Trans-gender");
   add(gen);
     gen.addItemListener(this);



     design=new Choice();
    design.add("Select");
     design.add("Software Analyzer"); design.add("Software Designer");design.add("Software Developer");design.add("Software Tester");design.add("Trainee");
   add(design);
     design.addItemListener(this);

     tfid1=new TextField();
      add(tfid1);
      tfid1.setFont(f3);

      tfname=new TextField();
      add(tfname);
      tfname.setFont(f3);

      taaddr=new TextArea();
      add(taaddr);
      taaddr.setFont(f3);

      //tfmobinit=new TextField();
       //add(tfmobinit);
      //tfmobinit.setFont(f3);

      tfmobno=new TextField();
      add(tfmobno);
      tfmobno.setFont(f3);

      tfdept=new TextField();
      add(tfdept);
      tfdept.setFont(f3);

      tfprojname=new TextField();
      add(tfprojname);
      tfprojname.setFont(f3);

     tfsal=new TextField();
      add(tfsal);
      tfsal.setFont(f3);

    tfdob=new TextField();
      add(tfdob);
      tfdob.setFont(f3);

    /*  tfgen=new TextField();
      add(tfgen);
      tfgen.setFont(f3);

     tfqual=new TextField();
      add(tfqual);
      tfqual.setFont(f3);


    tfdesign=new TextField();
      add(tfdesign);
      tfdesign.setFont(f3);*/

     badd=new Button("Add");
      bdelete=new Button("Delete");
      bmodify=new Button("Modify");
      bsave=new Button("Save Form");
      bsearch=new Button("Search");
      bclose=new Button("Close Form");
      
      
      
add(badd);
badd.setFont(f3);
badd.setForeground(Color.white);
badd.setBackground(Color.blue);
      
add(bdelete);
bdelete.setFont(f3);
bdelete.setForeground(Color.white);
bdelete.setBackground(Color.blue);
      
add(bmodify);
bmodify.setFont(f3);
bmodify.setForeground(Color.white);
bmodify.setBackground(Color.blue);
      
add(bsave);
bsave.setFont(f3);
bsave.setForeground(Color.white);
bsave.setBackground(Color.blue);
      
add(bsearch);
bsearch.setFont(f3);
bsearch.setForeground(Color.white);
bsearch.setBackground(Color.blue);
     
add(bclose);
bclose.setFont(f3);
bclose.setForeground(Color.white);
bclose.setBackground(Color.blue);

      
       badd.addActionListener(this);
      bdelete.addActionListener(this);
      bmodify.addActionListener(this);
      bsearch.addActionListener(this);
      bclose.addActionListener(this);
      bsave.addActionListener(this);
      
      ltitle.setBounds(250,70,500,50);
      lid.setBounds(120,150,280,30);
      tfid1.setBounds(500,150,300,30);
      lname.setBounds(120,200,250,30);
      tfname.setBounds(500,200,300,30);
      laddr.setBounds(120,250,250,30);
      taaddr.setBounds(500,250,300,90);
      lmobno.setBounds(120,350,270,30);
      //tfmobinit.setBounds(500,350,40,30);
      tfmobno.setBounds(500,350,300,30);
      ldeptproj.setBounds(120,400,370,30);
      tfdept.setBounds(500,400,80,30);
      tfprojname.setBounds(600,400,200,30);
      ldob.setBounds(120,450,250,30);
      /*  date1.setBounds(500,450,60,30);
      month1.setBounds(590,450,90,30);
       year1.setBounds(710,450,90,30);*/
    tfdob.setBounds(500,450,200,30);
      lgen.setBounds(120,500,300,30);
       gen.setBounds(500,500,150,30);
       //tfgen.setBounds(830,500,90,30);
       lqual.setBounds(120,550,250,30);
      qual.setBounds(500,550,300,30);
       //tfqual.setBounds(830,550,150,30);
      lsal.setBounds(120,600,270,30);
      tfsal.setBounds(500,600,300,30);
       //ltoe.setBounds(120,650,270,30);
      //toe.setBounds(500,650,300,30);
       ldesign.setBounds(120,650,270,30);
       design.setBounds(500,650,300,30);
       //tfdesign.setBounds(830,650,150,30);
       badd.setBounds(40,700,140,30);
      bdelete.setBounds(210,700,140,30);
      bmodify.setBounds(380,700,140,30);
      bsave.setBounds(550,700,140,30);
      bsearch.setBounds(720,700,120,30);
      bclose.setBounds(870,700,110,30);


  tfid1.setEnabled(false);
tfname.setEnabled(false);
 taaddr.setEnabled(false);
tfmobno.setEnabled(false);
tfdept.setEnabled(false);
tfprojname.setEnabled(false);
  /*date1.setEnabled(false);
month1.setEnabled(false);
year1.setEnabled(false);*/
gen.setEnabled(false);
qual.setEnabled(false);
design.setEnabled(false);
tfdob.setEnabled(false);
//tfgen.setEnabled(false);
//tfqual.setEnabled(false);
tfsal.setEnabled(false);
//tfdesign.setEnabled(false);
      
    try
    {
    	Class.forName("com.mysql.cj.jdbc.Driver");
		con=DriverManager.getConnection("jdbc:mysql://127.0.0.1:3306/fitnessclub","root","pallavi");
		 rs=st.executeQuery("select * from EmpInfo order by empid");
      JOptionPane.showMessageDialog(this,"Connection Made Successfully");
    }
    catch(Exception e) {
    	e.printStackTrace();
    }
  }
    
public void itemStateChanged(ItemEvent ie)
{
   
}


     public void actionPerformed(ActionEvent ae)
    {
         if(ae.getSource()==badd)
        {
             check='A';
            tfid1.setEnabled(true);
         			                  tfname.setEnabled(true);
          				taaddr.setEnabled(true);
          				tfmobno.setEnabled(true);
          				tfdept.setEnabled(true);
                                                                        tfprojname.setEnabled(true);
           				/*date1.setEnabled(true);
           				month1.setEnabled(true);*/
           				tfdob.setEnabled(true);
				qual.setEnabled(true);
                                                                       gen.setEnabled(true);
           				//year1.setEnabled(true);
          				tfsal.setEnabled(true);
                                                                        design.setEnabled(true);
       }
    	else if(ae.getSource()==bdelete)
   	{
   	check='D';
                   String s =JOptionPane.showInputDialog(this,"Enter ID No. Of That Employee,Whose Data You Want To Delete"); 
       			 int eid=Integer.parseInt(s);
       			 int chk=searching(eid);
      			  	if(chk==1)
       			 	{
           				JOptionPane.showMessageDialog(this,"To Delete Record Of This Employee Permanently Click On SAVE Button");
        				}
        				else
          				{
            				JOptionPane.showMessageDialog(this,"Record Of Such a Employee Is Not Found,So Can't Delete Any Record");
          				}
                			 }

  
        			else if(ae.getSource()==bmodify)
        			{
          			 check='M';
			String s =JOptionPane.showInputDialog(this,"Enter ID No. Of That Employee,Whose Data You Want To Modify"); 
        			int eid=Integer.parseInt(s);
        			int chk=searching(eid);
      				  if(chk==1)
        				{
           				JOptionPane.showMessageDialog(this,"Make The Changes And Then Click On SAVE Button");
          				tfid1.setEnabled(true);
         			                  tfname.setEnabled(true);
          				taaddr.setEnabled(true);
          				tfmobno.setEnabled(true);
          				tfdept.setEnabled(true);
                                                                        tfprojname.setEnabled(true);
           				tfdob.setEnabled(true);
           				gen.setEnabled(true);
           				qual.setEnabled(true);
          				tfsal.setEnabled(true);
                                                                        design.setEnabled(true);
          
        				}
        				else
          				{
            				JOptionPane.showMessageDialog(this,"Record Of Such a Employee Is Not Found,So Can't Modify Any Record");
          				}
                 }

  
    
else if(ae.getSource()==bsearch)
     			{
        String s =JOptionPane.showInputDialog(this,"Enter ID No. Of That Employee,Whose Data You Want To Search"); 
        int eid=Integer.parseInt(s);
        int chk=searching(eid);
        if(chk==0)
          {
            JOptionPane.showMessageDialog(this,"Record Of Such a Employee Is Not Found");
          }
      }
          
   	
                else if(ae.getSource()==bsave)
  	 {
     		if(check=='A')
     		{
         		String id=tfid1.getText();
		String name=tfname.getText();
		String addr=taaddr.getText();
		String mobno=tfmobno.getText();
                                    String d=tfdept.getText();
		String p=tfprojname.getText();
                                    String edate=tfdob.getText();
		/*String dt=date1.getSelectedItem();
		String mt=month1.getSelectedItem();
		String yr=year1.getSelectedItem();
                                    String edate=dt+'/'+mt+'/'+yr;*/
                                    String q=qual.getSelectedItem();
		String g=gen.getSelectedItem();
		String sal=tfsal.getText();
                                    String des=design.getSelectedItem();
                                         
                                     try
		{
		String str="insert into EmpInfo values("+id+",'"+name+"','"+addr+"','"+mobno+"','"+d+"','"+p+"','"+edate+"','"+g+"','"+q+"','"+sal+"','"+des+"')";
                                    st=con.createStatement();
		st.executeUpdate(str);
         JOptionPane.showMessageDialog(this,"Record Is Added Successfully");            
            rs=st.executeQuery("select * from EmpInfo order by empid");
                                 				tfid1.setText("");
            					tfname.setText("");
            					taaddr.setText("");
            					tfmobno.setText("");
            					tfdept.setText("");
                                                                                          tfprojname.setText("");
           					tfdob.setText("");
           					gen.select("");
           					qual.select("");
          					 tfsal.setText("");
                                                                                           design.select("");
          

                                    }
                                     catch(Exception e) {
                                    		e.printStackTrace();
                                    	}
     
     		}

                        else if(check=='D')
       				{  
          					try
          					{
            					PreparedStatement
psdelete=con.prepareStatement("delete from EmpInfo where empid=?");
            				psdelete.setInt(1,Integer.parseInt(tfid1.getText()));
            				psdelete.executeUpdate();
            				JOptionPane.showMessageDialog(this," Record Is deleted Successfully");            
            			rs=st.executeQuery("select * from EmpInfo order by empid");
         					 }
          					
          					catch(Exception e) {
          						e.printStackTrace();
          					}
                					tfid1.setText("");
            					tfname.setText("");
            					taaddr.setText("");
            					tfmobno.setText("");
            					tfdept.setText("");
                                                                                          tfprojname.setText("");
           					tfdob.setText("");
           					gen.select("");
           					qual.select("");
          					 tfsal.setText("");
                                                                                           design.select("");
        				}

         
				else if(check=='M')
        				{     try
          {
            PreparedStatement psmodify=con.prepareStatement("Update EmpInfo set empname=?,address=?,mobileno=?,deptID=?,projectname=?,empdob=?,gender=?,qualification=?,salary=?,Designation=? where empid=?");
            psmodify.setString(1,tfname.getText());
            psmodify.setString(2,taaddr.getText());
            psmodify.setString(3,tfmobno.getText());
            psmodify.setString(4,tfdept.getText());
           psmodify.setString(5,tfprojname.getText());
            psmodify.setString(6,tfdob.getText());
            psmodify.setString(7,gen.getSelectedItem());
            psmodify.setString(8,qual.getSelectedItem());
            psmodify.setString(9,tfsal.getText());
             psmodify.setString(10,design.getSelectedItem());
            psmodify.setInt(11,Integer.parseInt(tfid1.getText()));
            psmodify.executeUpdate();
            JOptionPane.showMessageDialog(this," Record Is Modified Successfully");            
            rs=st.executeQuery("select * from EmpInfo order by empid");
          }
        				catch(Exception e) {
        					e.printStackTrace();
        				}
                                                                        tfid1.setText("");
            				tfname.setText("");
            				taaddr.setText("");
            				tfmobno.setText("");
            				tfdept.setText("");
                                                                        tfprojname.setText("");
            				tfdob.setText("");
            				qual.select("");
            				gen.select("");
            				tfsal.setText("");
                                                                        design.select("");

            tfid1.setEnabled(false);
            tfname.setEnabled(false);
            taaddr.setEnabled(false);
            tfmobno.setEnabled(false);
            tfdept.setEnabled(false);
            tfprojname.setEnabled(false);
            tfdob.setEnabled(false);
            qual.setEnabled(false);
            gen.setEnabled(false);
            tfsal.setEnabled(false);
            design.setEnabled(false);
           
         }
         			
            				
  }
                           else if(ae.getSource()==bclose)
    			{
      			dispose();
     			}
   

	  

  }   

int searching(int eid)
  {
     int chk=0;
        try
        {
          int v1=0;
          String v2="",v3="",v4="",v5="",v6="",v7="",v8="",v9="",v10="", v11="";
        
          while(rs.next())
          {
            v1=rs.getInt(1);
            v2=rs.getString(2);      
            v3=rs.getString(3);
            v4=rs.getString(4);
            v5=rs.getString(5);
           v6=rs.getString(6);      
           v7=rs.getString(7);
           v8=rs.getString(8);
          v9=rs.getString(9);
          v10=rs.getString(10);
           v11=rs.getString(11);


            if(v1==eid)
            {
              tfid1.setText(String.valueOf(v1));
              tfname.setText(v2);
              taaddr.setText(v3);
              tfmobno.setText(v4);
              tfdept.setText(v5);
              tfprojname.setText(v6);
              tfdob.setText(v7);
               //tfgen.setText(v8);
 gen.select(v8);
               qual.select(v9);
               tfsal.setText(v10);
               design.select(v11);
              chk=1;
              break;
            }
          }          
          rs.first();
          rs.previous();
        }
        catch(Exception e) {
        	e.printStackTrace();
        }
        return(chk);
  }

}class IcardInstructor extends JFrame implements ActionListener,ItemListener
{
      JLabel ltitle,lid,lname,laddr,lmobno,lemail,lbatch;
     JTextField tfid,tfname,tfmobno,tfemail;
     JTextArea taddr;
      JButton bprint,badd,bsave,bclose,bsearch;
     Choice batch;
     Font f1,f2,f3;
    Connection con;
    Statement st;
    ResultSet rs;
    char check='X';
     public IcardInstructor()
      {
         //setSize(900,740);
         setVisible(true);
         Container cp = getContentPane();
        f1=new Font("Arial Narrow",Font.BOLD,25);
        f2=new Font("Times New Roman",Font.BOLD,20);
        f3=new Font("Times New Roman",Font.BOLD,14);
       cp.setLayout(null);

       ltitle=new JLabel("I-card For Instructor");
       ltitle.setFont(f1);
       ltitle.setForeground(Color.magenta);
       ltitle.setBackground(Color.blue);
       setBounds(100,50,800,650);
       cp.add(ltitle);
       ltitle.setBounds(270,50,300,30);
       
       lid=new JLabel("Instructor ID");
       lid.setFont(f2);
       lid.setForeground(Color.green);
       cp.add(lid);
       lid.setBounds(200,150,200,25);
       tfid=new JTextField();
       tfid.setFont(f3);
       cp.add(tfid);
       tfid.setBounds(450,150,200,25);        
       
       
       lname=new JLabel("Instructor Name");
       lname.setForeground(Color.green);
       lname.setFont(f2);
       cp.add(lname);
       lname.setBounds(200,195,200,25);
       tfname=new JTextField();
       tfname.setFont(f3);
       cp.add(tfname);
       tfname.setBounds(450,195,200,25);

       laddr=new JLabel("Address");
       laddr.setForeground(Color.green);
       laddr.setFont(f2);
       cp.add(laddr);
       laddr.setBounds(200,240,200,25);
       taddr=new JTextArea(4,20);
       taddr.setFont(f3);
       cp.add(taddr);
       taddr.setBounds(450,240,200,80);

       lmobno=new JLabel("Mobile No.");
       lmobno.setForeground(Color.green);
       lmobno.setFont(f2);
       cp.add(lmobno);
       lmobno.setBounds(200,340,200,25);
       tfmobno=new JTextField();    
       tfmobno.setFont(f3);
       cp.add(tfmobno);
       tfmobno.setBounds(450,340,200,25);

       lemail=new JLabel("Email ID");
       lemail.setForeground(Color.green);
       lemail.setFont(f2);
       cp.add(lemail);
       lemail.setBounds(200,385,200,25);
       tfemail=new JTextField();
       tfemail.setFont(f3);
       cp.add(tfemail);
       tfemail.setBounds(450,385,200,25);
       

       lbatch=new JLabel("Member Batch");
       lbatch.setForeground(Color.green);
       lbatch.setFont(f2);
       cp.add(lbatch);
       lbatch.setBounds(200,430,200,25);
       batch=new Choice();
      batch.setFont(f3);
      batch.add(""); batch.add("A(5:30AM-6:30AM)"); batch.add("B(6:30AM-7:30AM)"); batch.add("C(5:30PM-6:30PM)"); batch.add("D(6:30PM-7:30PM)");
      add(batch);
      batch.addItemListener(this);
      batch.setBounds(450,430,200,25);

       badd=new JButton("Add");
       bsave=new JButton("Save");
       bprint=new JButton("Print");
       bsearch=new JButton("Search");
       bclose=new JButton("Close");
       badd.setFont(f3);
       bsave.setFont(f3);
       bprint.setFont(f3);
       bsearch.setFont(f3);
       bclose.setFont(f3);
       badd.addActionListener(this);
       bsave.addActionListener(this);
       bsearch.addActionListener(this);
       bprint.addActionListener(this);
       bclose.addActionListener(this);

       cp.add(bprint);
       cp.add(badd);
       cp.add(bclose);
       cp.add(bsearch);
       cp.add(bsave);
 
       bprint.setBounds(150,520,80,30);
       badd.setBounds(240,520,80,30);
       bsave.setBounds(330,520,80,30);
       bsearch.setBounds(420,520,80,30);
       bclose.setBounds(510,520,80,30);

        JLabel jl=new JLabel(new ImageIcon("b.jpg"));
        cp.add(jl);
         jl.setBounds(0,0,1020,730);

                   tfid.setEnabled(false);
                   tfname.setEnabled(false);
          	taddr.setEnabled(false);
          	tfmobno.setEnabled(false);
          	tfemail.setEnabled(false);
                    //iname.setEnabled(false);
                    batch.setEnabled(false);
       try
       {
    	   Class.forName("com.mysql.cj.jdbc.Driver");
   		con=DriverManager.getConnection("jdbc:mysql://127.0.0.1:3306/fitnessclub","root","pallavi");
   		st=con.createStatement(ResultSet.TYPE_SCROLL_SENSITIVE, ResultSet.CONCUR_UPDATABLE);
         rs=st.executeQuery("select * from IcardInstructor order by instid");
        }
       catch(Exception e) {
    		e.printStackTrace();
    	}
       }
       public void actionPerformed(ActionEvent ae)
       {
                if(ae.getSource()==bprint)
                {

                 }
                 else if(ae.getSource()==badd)
                 {
                     check='A';
              
                    String s = JOptionPane.showInputDialog(this, "Enter ID No. Of  Instructor,Whose Icard you want to Show");
                   int mid = Integer.parseInt(s);
                   int chk = searching(mid);
                   if (chk == 1) 
                  {
                     JOptionPane.showMessageDialog(this, "To Show Record Of This  Instructor Successfully");
                  } 
                else 
                 {
                     JOptionPane.showMessageDialog(this, "Record Of Such a  Instructor Is Not Found,So Can't Show Any Record");
                  }

                    tfid.setEnabled(false);
                   tfname.setEnabled(false);
          	taddr.setEnabled(false);
          	tfmobno.setEnabled(false);
          	tfemail.setEnabled(false);
                   //tfiname.setEnabled(true);
                   batch.setEnabled(false);       
                  }
                  else if(ae.getSource()==bsave)
                  {
                     if(check=='A')
                      {
                   int id=Integer.parseInt(tfid.getText());
	String name=tfname.getText();
	String addr=taddr.getText();
	String mobno=tfmobno.getText();
	String email=tfemail.getText();
           	String b=batch.getSelectedItem();
                   //String iname=tfiname.getText();
                     try
	 {
	    String str="insert into IcardInstructor values("+id+",'"+name+"','"+addr+"','"+mobno+"','"+email+"','"+b+"' )";
                        st = con.createStatement(rs.TYPE_SCROLL_SENSITIVE, rs.CONCUR_UPDATABLE);
//st=con.createStatement();
	    st.executeUpdate(str);
                       JOptionPane.showMessageDialog(this,"Record Is Added Successfully");            
                       rs=st.executeQuery("select * from IcardInstructor order by instid");
                       tfid.setText("");
                       tfname.setText("");
          	   taddr.setText("");
          	   tfmobno.setText("");
          	   tfemail.setText("");
                      //tfiname.setText("");
                      batch.select("");           				
                   }
                     catch(Exception e) {
                    		e.printStackTrace();
                    	}
           }

                  }
                   else if(ae.getSource()==bsearch)
                   {
                          
                     String s =JOptionPane.showInputDialog(this,"Enter ID No. Of That IcardInstructor,Whose Data You Want To Search"); 
                     int iid=Integer.parseInt(s);
                     int chk=searching(iid);
                     if(chk==0)
                     {
                           JOptionPane.showMessageDialog(this,"Record Of Such a IcardInstructor Is Not Found");
                     }
                   }
                  else if(ae.getSource()==bclose)
                   {
                           dispose();
                    }
  
       }
   int searching(int iid)
    {
     int chk=0;
        try
        {
          int v1=0;
          String v2="",v3="",v4="",v5="",v6="";
        
          while(rs.next())
          {
            v1=rs.getInt(1);
            v2=rs.getString(2);      
            v3=rs.getString(3);
            v4=rs.getString(4);
            v5=rs.getString(5);
           v6=rs.getString(6);      
           
          
            if(v1==iid)
            {
              tfid.setText(String.valueOf(v1));
              tfname.setText(v2);
              taddr.setText(v3);
              tfmobno.setText(v4);
              tfemail.setText(v5);
               batch.select(v6);
               
              chk=1;
              break;
            }
          }          
          rs.first();
          rs.previous();
        }
        catch(Exception e) {
        	e.printStackTrace();
        }
        return(chk);
  }
       public void itemStateChanged(ItemEvent ie)
       {

        }
} class IcardInstructorReport extends JFrame
{
 public IcardInstructorReport ()
 { 
 Container contentpane=getContentPane();
contentpane.setLayout(new BorderLayout());
String[] colHeads={"Instructor ID","Instructor Name","Address","Mobileno","Email ID","Member Batch"};
Connection con=null;
Statement stmt=null;
ResultSet rs=null;
ArrayList values=new ArrayList();
  try 
 {
	  Class.forName("com.mysql.cj.jdbc.Driver");
		con=DriverManager.getConnection("jdbc:mysql://127.0.0.1:3306/fitnessclub","root","pallavi");
		stmt=con.createStatement();
rs=stmt.executeQuery("select * from IcardInstructor order by instid");
while(rs.next())
{
values.add(rs.getString(1));
values.add(rs.getString(2));
values.add(rs.getString(3));
values.add(rs.getString(4));
values.add(rs.getString(5));
values.add(rs.getString(6));
}
}
  catch(Exception e) {
		e.printStackTrace();
	}
finally
{
try
{
if(con!=null)
{
con.close();
}
}
catch(Exception e) {
	e.printStackTrace();
}
}
int noOfRows=(values.size())/colHeads.length;
int no=0;
Object[][]data=new Object[noOfRows][colHeads.length];
System.out.println("no of records:"+noOfRows);
for(int i=0;i<noOfRows;i++)
{
for(int j=0;j<colHeads.length;j++)
{
String s=(String)values.get(no++);
data[i][j]=s;
}
}
JTable table=new JTable(data,colHeads);
int v=ScrollPaneConstants.VERTICAL_SCROLLBAR_ALWAYS;
int h=ScrollPaneConstants.HORIZONTAL_SCROLLBAR_ALWAYS;
JScrollPane jsp=new JScrollPane(table,v,h);
contentpane.add(jsp,BorderLayout.CENTER);
setVisible(true);
setSize(1000,600);
setTitle("IcardInstructor Report");
}
}

class IcardMem extends JFrame implements ActionListener, ItemListener
   {

   JLabel ltitle,lid,lname,laddr,lmobno,lemail,liname,lbatch;
   JTextField tfid,tfname,tfmobno,tfemail,tfiname;
   JTextArea taddr;
   JButton bprint,badd,bsave,bclose,bsearch,bdelete;
     Choice instructor,batch;
     JPanel p;
    String m;
     Font f1,f2,f3;
    Connection con;
    //Container cp;
    Statement st,st1;
    ResultSet rs,rs1;
    char check='X';
   public IcardMem()
      {
         Container cp = getContentPane();
        f1=new Font("Arial Narrow",Font.BOLD,25);
        f2=new Font("Times New Roman",Font.BOLD,20);
        f3=new Font("Times New Roman",Font.BOLD,14);
       cp.setLayout(null);
        
       ltitle=new JLabel("I-card For Member");
       ltitle.setFont(f1);
       ltitle.setForeground(Color.red);
       ltitle.setBackground(Color.blue);
       setBounds(100,50,800,650);
       cp.add(ltitle);
       ltitle.setBounds(270,50,300,30);
       
       lid=new JLabel("Member ID");
       lid.setFont(f2);
       lid.setForeground(Color.blue);
       cp.add(lid);
       lid.setBounds(200,150,200,25);
       tfid=new JTextField();
       tfid.setFont(f3);
       cp.add(tfid);
       tfid.setBounds(450,150,200,25);        
       
       
       lname=new JLabel("Member Name");
       lname.setForeground(Color.blue);
       lname.setFont(f2);
       cp.add(lname);
       lname.setBounds(200,195,200,25);
       tfname=new JTextField();
       tfname.setFont(f3);
       cp.add(tfname);
       tfname.setBounds(450,195,200,25);

       laddr=new JLabel("Address");
       laddr.setForeground(Color.blue);
       laddr.setFont(f2);
       cp.add(laddr);
       laddr.setBounds(200,240,200,25);
       taddr=new JTextArea(4,20);
       taddr.setFont(f3);
       cp.add(taddr);
       taddr.setBounds(450,240,200,80);

       lmobno=new JLabel("Mobile No.");
       lmobno.setForeground(Color.blue);
       lmobno.setFont(f2);
       cp.add(lmobno);
       lmobno.setBounds(200,340,200,25);
       tfmobno=new JTextField();    
       tfmobno.setFont(f3);
       cp.add(tfmobno);
       tfmobno.setBounds(450,340,200,25);

       lemail=new JLabel("Email ID");
       lemail.setForeground(Color.blue);
       lemail.setFont(f2);
       cp.add(lemail);
       lemail.setBounds(200,385,200,25);
       tfemail=new JTextField();
       tfemail.setFont(f3);
       cp.add(tfemail);
       tfemail.setBounds(450,385,200,25);

        liname=new JLabel("Instructor Name");
       liname.setFont(f2);
       cp.add(liname);
       liname.setForeground(Color.blue);
       liname.setBounds(200,430,200,25);
        instructor=new Choice();
      //instructor.setFont(f3);
       instructor.add("");
       instructor.add("Mr.Prashant Kamble(Gends Instructor)"); instructor.add("Miss.Meghana Patel(Ladies Instructor)"); instructor.add("Mr.Alok Patil(Sport Instructor)");instructor.add("Miss.Shubhra Parab(Yoga Instuctor)");instructor.add("Mr.Amol Kanetkar(Weight Loss Instructor)");
       add(instructor);
       instructor.addItemListener(this);
       instructor.setBounds(450,430,200,25);

       lbatch=new JLabel("Member Batch");
       lbatch.setForeground(Color.blue);
       lbatch.setFont(f2);
       cp.add(lbatch);
       lbatch.setBounds(200,475,200,25);
       batch=new Choice();
      //batch.setFont(f3);
      batch.add(""); batch.add("A(5:30AM-6:30AM)"); batch.add("B(6:30AM-7:30AM)"); batch.add("C(5:30PM-6:30PM)"); batch.add("D(6:30PM-7:30PM)");
      add(batch);
      batch.addItemListener(this);
      batch.setBounds(450,475,200,25);

       badd=new JButton("Add");
       bsave=new JButton("Save");
       bprint=new JButton("Print");
       bsearch=new JButton("Search");
       bclose=new JButton("Close");
       bdelete=new JButton("Delete");
       
       badd.setFont(f3);
       bsave.setFont(f3);
       bprint.setFont(f3);
       bsearch.setFont(f3);
       bclose.setFont(f3);
       bdelete.setFont(f3);
     
       badd.addActionListener(this);
       bsave.addActionListener(this);
       bsearch.addActionListener(this);
       bprint.addActionListener(this);
       bclose.addActionListener(this);
       bdelete.addActionListener(this);
       //bmodify.addActionListener(this);
       cp.add(bprint);
       cp.add(badd);
       cp.add(bclose);
       cp.add(bsearch);
       cp.add(bsave);
       cp.add(bdelete);
      // cp.add(bmodify);
       bprint.setBounds(150,550,80,30);
       badd.setBounds(240,550,80,30);
       bsave.setBounds(330,550,80,30);
       bsearch.setBounds(420,550,80,30);
       bclose.setBounds(510,550,80,30);
       bdelete.setBounds(600,550,80,30);
      // bmodify.setBounds(680,550,80,30);
          JLabel jl=new JLabel(new ImageIcon("greenp.jpg"));
        cp.add(jl);
         jl.setBounds(0,0,1000,750);

                   tfid.setEnabled(false);
                   tfname.setEnabled(false);
          	taddr.setEnabled(false);
          	tfmobno.setEnabled(false);
          	tfemail.setEnabled(false);
                    instructor.setEnabled(false);
                   batch.setEnabled(false);
                    setVisible(true);
                    //setDefaultCloseOperation(DISPOSE_ON_CLOSE);

       
        try
          {
        	Class.forName("com.mysql.cj.jdbc.Driver");
    		con=DriverManager.getConnection("jdbc:mysql://127.0.0.1:3306/fitnessclub","root","pallavi");
    		st = con.createStatement(rs.TYPE_SCROLL_SENSITIVE, rs.CONCUR_UPDATABLE);
            rs = st.executeQuery("select * from IcardMember order by mid ");
            
            JOptionPane.showMessageDialog(this, "Connection Made Successfully");
           } 
        catch(Exception e) {
        	e.printStackTrace();
        }
         
       }

    public void actionPerformed(ActionEvent ae) 
     {
         if(ae.getSource()==bprint)
              {

                 }
                 else if(ae.getSource()==badd)
                 {
                    //String s=JOptionPane.showMessageDialog(this,"Enter Number");
                     check='A';
                   String s = JOptionPane.showInputDialog(this, "Enter ID No. Of  Member,Whose Icard you want to Show");
                   int mid = Integer.parseInt(s);
                   int chk = searching(mid);
                   if (chk == 1) 
                  {
                     JOptionPane.showMessageDialog(this, "To Show Record Of This  Member Successfully");
                  } 
                else 
                 {
                     JOptionPane.showMessageDialog(this, "Record Of Such a  Member Is Not Found,So Can't Show Any Record");
                  }
                 
                    tfid.setEnabled(false);
                   tfname.setEnabled(false);
          	taddr.setEnabled(false);
          	tfmobno.setEnabled(false);
          	tfemail.setEnabled(false);
                    instructor.setEnabled(false);
                   batch.setEnabled(false);           
       }
 else if (ae.getSource() == bdelete)
           {
            check = 'D';
            String s = JOptionPane.showInputDialog(this, "Enter ID No. Of That Member,Whose Data You Want To Delete");
            int mid = Integer.parseInt(s);
            int chk = searching(mid);
            if (chk == 1) 
            {
                JOptionPane.showMessageDialog(this, "To Delete Record Of This  Member Permanently Click On SAVE Button");
            } 
        else 
             {
                JOptionPane.showMessageDialog(this, "Record Of Such a  Member Is Not Found,So Can't Delete Any Record");
            }
        } 
            
        
 else if (ae.getSource() == bsearch) 
       {
            String s = JOptionPane.showInputDialog(this, "Enter ID No. Of That  Member,Whose Data You Want To Search");
            int mid = Integer.parseInt(s);
            int chk = searching(mid);
            if (chk == 0) 
            {
                JOptionPane.showMessageDialog(this, "Record Of Such a  Member Is Not Found");
            }
       }
else if (ae.getSource() == bsave) 
             {
            if (check == 'A') 
                {
               String id=tfid.getText();
	String name=tfname.getText();
	String addr=taddr.getText();
	String mobno=tfmobno.getText();
	String email=tfemail.getText();
                   String i=instructor.getSelectedItem();
                   	String b=batch.getSelectedItem();
                     try
	 {
	    String str="insert into IcardMember values("+id+",'"+name+"','"+addr+"','"+mobno+"','"+email+"','"+i+"','"+b+"')";
                      st = con.createStatement(rs.TYPE_SCROLL_SENSITIVE, rs.CONCUR_UPDATABLE);
                      // st=con.createStatement();
	    st.executeUpdate(str);
                       JOptionPane.showMessageDialog(this,"Record Is Added Successfully");            
                       rs=st.executeQuery("select * from IcardMember order by mid");
                       tfid.setText("");
                       tfname.setText("");
          	   taddr.setText("");
          	   tfmobno.setText("");
          	   tfemail.setText("");
                      instructor.select("");
                      batch.select("");           				
                    }
                     catch(Exception e) {
                    		e.printStackTrace();
                    	}
            }

                 else if (check == 'D') 
                {
                try
                  {
                    PreparedStatement psdelete = con.prepareStatement("delete from IcardMember where mid=?");
                    psdelete.setInt(1, Integer.parseInt(tfid.getText()));
                    psdelete.executeUpdate();
                    JOptionPane.showMessageDialog(this, " Record Is deleted Successfully");
                    rs = st.executeQuery("select * from IcardMember");
                     tfid.setText("");
                      tfname.setText("");
          	   taddr.setText("");
          	   tfmobno.setText("");
          	   tfemail.setText("");
                      instructor.select("");
                      batch.select("");
                 }
                catch(Exception e) {
                	e.printStackTrace();
                }
                     
              }
 
            
             
            }


        
            else if (ae.getSource() == bclose) 
            {
            dispose();
            }




    }

     int searching(int mid)
    {
     int chk=0;
        try
        {
          int v1=0;
          String v2="",v3="",v4="",v5="",v6="",v7="";
        
          while(rs.next())
          {
            v1=rs.getInt(1);
            v2=rs.getString(2);      
            v3=rs.getString(3);
            v4=rs.getString(4);
            v5=rs.getString(5);
           v6=rs.getString(6);      
           v7=rs.getString(7);
          
          
            if(v1==mid)
            {
              tfid.setText(String.valueOf(v1));
              tfname.setText(v2);
              taddr.setText(v3);
              tfmobno.setText(v4);
              tfemail.setText(v5);
               instructor.select(v6);
               batch.select(v7);
               
              chk=1;
              break;
            }
          }          
         rs.first();
          rs.previous();
        }
        catch(Exception e) {
        	e.printStackTrace();
        }
        return(chk);
       }
       public void itemStateChanged(ItemEvent ie)
       {

        }
}

class IcardMemberReport extends JFrame
{
 public IcardMemberReport ()
 { 
 Container contentpane=getContentPane();
contentpane.setLayout(new BorderLayout());
String[] colHeads={"Member ID","Member Name","Address","Mobileno","Email ID","Instructor Name","Member Batch"};
Connection con=null;
Statement stmt=null;
ResultSet rs=null;
ArrayList values=new ArrayList();
  try 
 {
	  Class.forName("com.mysql.cj.jdbc.Driver");
		con=DriverManager.getConnection("jdbc:mysql://127.0.0.1:3306/fitnessclub","root","pallavi");
		stmt=con.createStatement();
rs=stmt.executeQuery("select * from IcardMember order by mid");
while(rs.next())
{
values.add(rs.getString(1));
values.add(rs.getString(2));
values.add(rs.getString(3));
values.add(rs.getString(4));
values.add(rs.getString(5));
values.add(rs.getString(6));
values.add(rs.getString(7));
}
}
  catch(Exception e) {
		e.printStackTrace();
	}
finally
{
try
{
if(con!=null)
{
con.close();
}
}catch(Exception e) {
	e.printStackTrace();
}
}
int noOfRows=(values.size())/colHeads.length;
int no=0;
Object[][]data=new Object[noOfRows][colHeads.length];
System.out.println("no of records:"+noOfRows);
for(int i=0;i<noOfRows;i++)
{
for(int j=0;j<colHeads.length;j++)
{
String s=(String)values.get(no++);
data[i][j]=s;
}
}
JTable table=new JTable(data,colHeads);
int v=ScrollPaneConstants.VERTICAL_SCROLLBAR_ALWAYS;
int h=ScrollPaneConstants.HORIZONTAL_SCROLLBAR_ALWAYS;
JScrollPane jsp=new JScrollPane(table,v,h);
contentpane.add(jsp,BorderLayout.CENTER);
setVisible(true);
setSize(1000,600);
setTitle("IcardMember Report");
}
}
class Instructor extends JFrame implements ActionListener,ItemListener
{
      JLabel ltitle,lid,lname,laddr,lmobno,lemail,lgender,lmid,lsal,lphoto,ljdate,ldate;
      JTextField tfid,tfname,tfmobno,tfemail,tfmid,tfsal,tfphoto,tfjdate;
      TextArea taddr;
      JButton badd,bsave,bsearch,bmodify,bclose,bdelete;
      Choice gen,batch,date1,month1,year1;
      Font f1,f2,f3,f4;
      Container c;
      Connection con;
      Statement st;
      ResultSet rs;
      Statement st1;
      ResultSet rs1;
     char check='X';
      
   public Instructor()
     {
          c=getContentPane();
          f1=new Font("Arial",Font.BOLD,30);
          f2=new Font("Times New Roman",Font.BOLD,20);
          f3=new Font("Times New Roman",Font.BOLD,16);
          f4=new Font("Times New Roman",Font.BOLD,12);
          c.setLayout(null);
          ltitle=new JLabel("Instructor Information");
          ltitle.setFont(f1);
          ltitle.setForeground(Color.green);

          tfphoto=new JTextField();
          c.add(tfphoto);
          //tfphoto.setBounds(700,90,100,100);
          lphoto=new JLabel("Stick Photo");
          c.add(lphoto);
          lphoto.setFont(f4);
          //lphoto.setBounds(720,70,100,25);
          
          c.add(ltitle);
          setBounds(0,0,1000,750);
          ltitle.setBounds(200,40,320,30);

          lid=new JLabel("Instructor ID");
         // lid.setForeground(Color.magenta);
          lid.setFont(f2);
          c.add(lid);
          lid.setBounds(150,150,200,25);
          tfid=new JTextField();
          //tfid.setForeground(Color.blue);
          tfid.setFont(f3);
          c.add(tfid);
          tfid.setBounds(380,150,200,25);

          lname=new JLabel("Instructor name");
         //lname.setForeground(Color.magenta);
          lname.setFont(f2);
          c.add(lname);
          lname.setBounds(150,195,200,25);
          tfname=new JTextField();
          tfname.setFont(f3);
          c.add(tfname);
          tfname.setBounds(380,195,200,25);
         
          laddr=new JLabel("Address");
          //laddr.setForeground(Color.magenta);
          laddr.setFont(f2);
          c.add(laddr);
          laddr.setBounds(150,240,200,25);
          taddr=new TextArea();
          taddr.setFont(f3);
          c.add(taddr);
          taddr.setBounds(380,240,200,80);

          lmobno=new JLabel("Mobile No.");
         // lmobno.setForeground(Color.magenta);
          lmobno.setFont(f2);
          c.add(lmobno);
          lmobno.setBounds(150,340,200,25);
          tfmobno=new JTextField();
          tfmobno.setFont(f3);
          c.add(tfmobno);
          tfmobno.setBounds(380,340,200,25);

          lemail=new JLabel("E-mail ID");
         // lemail.setForeground(Color.magenta);
          lemail.setFont(f2);
          c.add(lemail);
          lemail.setBounds(150,385,200,25);
          tfemail=new JTextField();
          tfemail.setFont(f3);
          c.add(tfemail);
          tfemail.setBounds(380,385,200,25);
        
          lgender=new JLabel("Gender");
         // lgender.setForeground(Color.magenta);
          lgender.setFont(f2);
          c.add(lgender);
          lgender.setBounds(150,430,200,25);
           gen=new Choice();
         //gen.setFont(f3);
          gen.add("");
          gen.add("Male"); gen.add("Female"); gen.add("Trans-gender");
          add(gen);
          gen.addItemListener(this);
          gen.setBounds(380,430,200,30);
 
          ljdate=new JLabel("Joining Date");
          ljdate.setFont(f2);        
          c.add(ljdate);
          ljdate.setBounds(150,475,200,25);
          tfjdate=new JTextField();
          tfjdate.setFont(f3);
          c.add(tfjdate);
         tfjdate.setBounds(380,475,200,25);
          
      /** date1=new Choice();
      //date1.setFont(f3);
     date1.add("");
     date1.add("1"); date1.add("2"); date1.add("3");date1.add("4"); date1.add("5"); date1.add("6");
     date1.add("7"); date1.add("8");date1.add("9");date1.add("10"); date1.add("11");date1.add("12");
     date1.add("13");date1.add("14");date1.add("15"); date1.add("16");date1.add("17");date1.add("18");
     date1.add("19");date1.add("20"); date1.add("21");date1.add("22");date1.add("23");date1.add("24");
     date1.add("25"); date1.add("26");date1.add("27");date1.add("28");date1.add("29");date1.add    ("30");date1.add("31");
     add(date1);
     date1.addItemListener(this);
     date1.setBounds(380,475,50,25);

     month1=new Choice();
     //month1.setFont(f3);
     month1.add("");
     month1.add("Jan"); month1.add("Feb"); month1.add("Mar");month1.add("Apr"); month1.add("May"); month1.add("Jun");
     month1.add("Jul"); month1.add("Aug");month1.add("Sep");month1.add("Oct"); month1.add("Nov");month1.add("Dec");
     add(month1);
     month1.addItemListener(this);
     month1.setBounds(450,475,50,25);     
   
    year1=new Choice();
    //year1.setFont(f3);
    year1.add("");
    year1.add("2000"); year1.add("2001"); year1.add("2002");year1.add("2003"); year1.add("2004"); year1.add("2005");
    year1.add("2006"); year1.add("2007");year1.add("2008");year1.add("2009"); year1.add("2010");year1.add("2011");year1.add("2012");year1.add("2013");year1.add("2014");year1.add("2015");
    add(year1);
    year1.addItemListener(this);
    year1.setBounds(520,475,50,25);*/

    
          lmid=new JLabel("Member ID");
          //lmid.setForeground(Color.magenta);
          lmid.setFont(f2);
          c.add(lmid);
          lmid.setBounds(150,520,200,25);
          tfmid=new JTextField();
          tfmid.setFont(f3);
          c.add(tfmid);
          tfmid.setBounds(380,520,200,25);         

          lsal=new JLabel("Instructor Salary");
         // lsal.setForeground(Color.magenta);
          lsal.setFont(f2);
          c.add(lsal);
          lsal.setBounds(150,565,200,25);
          tfsal=new JTextField();
          tfsal.setFont(f3);
          c.add(tfsal);
          tfsal.setBounds(380,565,200,25);         

          badd=new JButton("Add");
         // badd.setBackground(Color.orange);
        //  badd.setForeground(Color.white);
          bdelete=new JButton("Detete");
         // bdelete.setBackground(Color.green);
          bsave=new JButton("Save");
         //bsave.setBackground(Color.green);
          bmodify=new JButton("Modify");
         // bmodify.setBackground(Color.green);
          bsearch=new JButton("Search");
          //bsearch.setBackground(Color.green);
          bclose=new JButton("Close");
          //bclose.setBackground(Color.green);
          badd.setFont(f3);
          bsave.setFont(f3);
          bdelete.setFont(f3);
          bmodify.setFont(f3);
          bsearch.setFont(f3);
          bclose.setFont(f3);
          badd.addActionListener(this);
          bsave.addActionListener(this);
          bdelete.addActionListener(this);
          bsearch.addActionListener(this);
          bmodify.addActionListener(this);
          bclose.addActionListener(this);    

         c.add(badd);
         c.add(bsave);
         c.add(bdelete);
         c.add(bmodify);
         c.add(bsearch);
         c.add(bclose);  

         badd.setBounds(100,620,70,30);
         bsave.setBounds(180,620,70,30);
         bdelete.setBounds(260,620,80,30);
         bmodify.setBounds(350,620,90,30);
         bsearch.setBounds(450,620,80,30);
         bclose.setBounds(540,620,80,30);
        
         JLabel jl=new JLabel(new ImageIcon("red.jpg"));
         c.add(jl);
        jl.setBounds(0,0,1000,750);
                   tfid.setEnabled(false);
                   tfname.setEnabled(false);
          	taddr.setEnabled(false);
          	tfmobno.setEnabled(false);
          	tfemail.setEnabled(false);
                   gen.setEnabled(false);
                   tfjdate.setEnabled(false);                                                     
                    tfmid.setEnabled(false);
                    tfsal.setEnabled(false);	
       
          try
           {
        	  Class.forName("com.mysql.cj.jdbc.Driver");
      		con=DriverManager.getConnection("jdbc:mysql://127.0.0.1:3306/fitnessclub","root","pallavi");
      		st=con.createStatement(ResultSet.TYPE_SCROLL_SENSITIVE, ResultSet.CONCUR_UPDATABLE);
            rs=st.executeQuery("select * from Instructor order by instid");
            }
          catch(Exception e) {
        		e.printStackTrace();
        	}  
 
          setVisible(true);
          setTitle("Instructor Form");
          setDefaultCloseOperation(DISPOSE_ON_CLOSE);
      }

      public void itemStateChanged(ItemEvent ie)
      {

      }
      public void actionPerformed(ActionEvent ae)
       {
           if(ae.getSource()==badd)
            {
                   check='A';
                   tfid.setEnabled(true);
                   tfname.setEnabled(true);
          	taddr.setEnabled(true);
          	tfmobno.setEnabled(true);
          	tfemail.setEnabled(true);
                   gen.setEnabled(true);                                                     
           	tfjdate.setEnabled(true);
                    tfmid.setEnabled(true);
                    tfsal.setEnabled(true);			
	
                      try {
                     st1 = con.createStatement();
                    rs1 = st1.executeQuery("select count(instid) as count, max(instid)+1 as m_instid from Instructor");
                    while (rs1.next()) {
                    if (rs1.getInt(1) == 0) {
                        tfid.setText("1");
                    } else {
                        tfid.setText(String.valueOf(rs1.getInt(2)));
                    }
                }
            }catch(Exception e) {
            	e.printStackTrace();
            }			
              }
         else if(ae.getSource()==bdelete)
            {
                   check='D';
                   String s =JOptionPane.showInputDialog(this,"Enter ID No. Of That Instructor,Whose Data You Want To Delete"); 
       	int iid=Integer.parseInt(s);
       	int chk=searching(iid);
      	if(chk==1)
       	{
           	   JOptionPane.showMessageDialog(this,"To Delete Record Of This Instructor Permanently Click On SAVE Button");
        	}
        	else
          	{
            	    JOptionPane.showMessageDialog(this,"Record Of Such a Instructor Is Not Found,So Can't Delete Any Record");
             	}
             }
          else if(ae.getSource()==bmodify)
            {
                   check='M';
	String s =JOptionPane.showInputDialog(this,"Enter ID No. Of That Instructor,Whose Data You Want To Modify"); 
        	int iid=Integer.parseInt(s);
        	int chk=searching(iid);
                   if(chk==1)
        	{
           	   JOptionPane.showMessageDialog(this,"Make The Changes And Then Click On SAVE Button");
          	   tfid.setEnabled(true);
                   tfname.setEnabled(true);
          	taddr.setEnabled(true);
          	tfmobno.setEnabled(true);
          	tfemail.setEnabled(true);
                   gen.setEnabled(true);                                                     
           	tfjdate.setEnabled(true);
                    tfmid.setEnabled(true);
                    tfsal.setEnabled(true);	
                    }
        	else
          	{
            	   JOptionPane.showMessageDialog(this,"Record Of Such a Instructor Is Not Found,So Can't Modify Any Record");
          	}        
             }
             else if(ae.getSource()==bsearch)
            {
                     String s =JOptionPane.showInputDialog(this,"Enter ID No. Of That Instructor,Whose Data You Want To Search"); 
                     int iid=Integer.parseInt(s);
                     int chk=searching(iid);
                     if(chk==0)
                     {
                           JOptionPane.showMessageDialog(this,"Record Of Such a Instructor Is Not Found");
                     }
             }
           else if(ae.getSource()==bsave)
            {
                   if(check=='A')
                   {
                    String id=tfid.getText();
	String name=tfname.getText();
	String addr=taddr.getText();
	String mobno=tfmobno.getText();
	String email=tfemail.getText();
                    String g=gen.getSelectedItem();
                   	String dt=tfjdate.getText();
	String mid=tfmid.getText();
 	String sal=tfsal.getText();
                     try
	 {
	    String str="insert into Instructor values('"+id+"','"+name+"','"+addr+"','"+mobno+"','"+email+"','"+gen+"','"+dt+"','"+mid+"','"+sal+"')";
                     st = con.createStatement(rs.TYPE_SCROLL_SENSITIVE, rs.CONCUR_UPDATABLE);  
//st=con.createStatement();
	    st.executeUpdate(str);
                       JOptionPane.showMessageDialog(this,"Record Is Added Successfully");            
                       rs=st.executeQuery("select * from Instructor order by instid");
                       tfid.setText("");
            	    tfname.setText("");
            	    taddr.setText("");
                       tfmobno.setText("");
            	    tfemail.setText("");
                       gen.select("");
                       tfjdate.setText("");
                       tfmid.setText("");
                       tfsal.setText("");          				
                   }
                     catch(Exception e) {
                    		e.printStackTrace();
                    	}
                }
                   else if(check=='D')
                    {
                        try
          	    {
            	        PreparedStatement psdelete=con.prepareStatement("delete from Instructor where instid=?");
            	        psdelete.setInt(1,Integer.parseInt(tfid.getText()));
                          //  psdelete.setInt(8,Integer.parseInt(tfmid.getText()));
            	        psdelete.executeUpdate();
            	        JOptionPane.showMessageDialog(this," Record Is deleted Successfully");            
            	        rs=st.executeQuery("select * from Instructor order by instid");
        
                         tfid.setText("");
            	    tfname.setText("");
            	    taddr.setText("");
                       tfmobno.setText("");
            	    tfemail.setText("");
                       gen.select("");
                       tfjdate.setText("");
                       tfmid.setText("");
                       tfsal.setText(""); 
         	 }
                        catch(Exception e) {
                        	e.printStackTrace();
                        }
            }
                   else if(check=='M')
                    {
                                   try
                                   {
                                     PreparedStatement psmodify=con.prepareStatement("Update Instructor set instname=?,instaddr=?,instmobno=?,instemailid=?,instgender=?,instjdate=?,mid=?,instsal=? where instid=?");
                                     psmodify.setString(1,tfname.getText());
                                     psmodify.setString(2,taddr.getText());
                                     psmodify.setString(3,tfmobno.getText());
                                     psmodify.setString(4,tfemail.getText());
                                     psmodify.setString(5,gen.getSelectedItem());
                                     psmodify.setString(6,tfjdate.getText());
                                     psmodify.setString(7,tfmid.getText());
                                     psmodify.setString(8,tfsal.getText());
                                     psmodify.setInt(9,Integer.parseInt(tfid.getText()));
                                    psmodify.executeUpdate();
                                    JOptionPane.showMessageDialog(this," Record Is Modified Successfully");            
                                    rs=st.executeQuery("select * from Instructor order by instid");
 
                        tfid.setText("");
            	    tfname.setText("");
            	    taddr.setText("");
                       tfmobno.setText("");
            	    tfemail.setText("");
                       gen.select("");
                       tfjdate.setText("");
                      tfmid.setText("");
                       tfsal.setText(""); 	
                                  }
                                   catch(Exception e) {
                                		e.printStackTrace();
                                	}
                        	
                   tfid.setEnabled(false);
                   tfname.setEnabled(false);
          	taddr.setEnabled(false);
          	tfmobno.setEnabled(false);
          	tfemail.setEnabled(false);
                   gen.setEnabled(false);
                   tfjdate.setEnabled(false);                                                     
                   tfmid.setEnabled(false);
                   tfsal.setEnabled(false);           
         
                     }
             }
            else  if(ae.getSource()==bclose)
            {
                     dispose();
             }

        }
     int searching(int iid)
    {
     int chk=0;
        try
        {
          int v1=0;
          String v2="",v3="",v4="",v5="",v6="",v7="",v8="",v9="";
        
          while(rs.next())
          {
            v1=rs.getInt(1);
            v2=rs.getString(2);      
            v3=rs.getString(3);
            v4=rs.getString(4);
            v5=rs.getString(5);
           v6=rs.getString(6);      
           v7=rs.getString(7);
           v8=rs.getString(8);
           v9=rs.getString(9);
          
            if(v1==iid)
            {
              tfid.setText(String.valueOf(v1));
              tfname.setText(v2);
              taddr.setText(v3);
              tfmobno.setText(v4);
              tfemail.setText(v5);
               gen.select(v6);
               tfjdate.setText(v7);
               tfmid.setText(v8);
               tfsal.setText(v9);
               chk=1;
              break;
            }
          }    
           rs.first();
          rs.previous();
        }
        catch(Exception e) {
        	e.printStackTrace();
        }
         return(chk);
  }
      
}


class MainFrame extends JFrame implements ActionListener
{
     JMenuBar bar;
     JMenu  form,report,bill,ic;
     JMenuItem member,instructor,services,product,icardm,icardi,member1,instructor1,services1,product1,icardm1,icardi1,icardm2,icardi2,allbill,bill1;
     public MainFrame()
     {
         Container c=getContentPane();
         bar=new JMenuBar();
         form=new JMenu("Form");
         member=new JMenuItem("Member Form");
         instructor=new JMenuItem("Instructor Form");
         services=new JMenuItem("Services Form");
         product=new JMenuItem("Product Form");
         icardm=new JMenuItem("I-card for Member");
         icardi=new JMenuItem("I-card for Instructor");

         report=new JMenu("Report");
         member1=new JMenuItem("MemberReport");
         instructor1=new JMenuItem("InstructorReport");
         services1=new JMenuItem("ServicesReport");
         product1=new JMenuItem("ProductReport");
         icardm1=new JMenuItem("IcardMemberReport");
         icardi1=new JMenuItem("IcardInstructorReport");
         bill1=new JMenuItem("BillReport");
         bill=new JMenu("Bill Generation");
        ic=new JMenu("I-card Generation");
        icardm2=new JMenuItem("IcardMember");
        icardi2=new JMenuItem("IcardInstructor");
        icardm2.addActionListener(this);
        icardi2.addActionListener(this);
        ic.add(icardm2);
        ic.add(icardi2);
       member.addActionListener(this);
       instructor.addActionListener(this);
       services.addActionListener(this);
      product.addActionListener(this);
      icardm.addActionListener(this);
      icardi.addActionListener(this);
      
      form.add(member);
      form.add(instructor);
      form.add(services);
      form.add(product);
      form.add(icardm);
      form.add(icardi); 
      
      report.add(member1);
      report.add(instructor1);
      report.add(services1);
      report.add(product1);
      report.add(icardm1);
      report.add(icardi1); 
      report.add(bill1);
      
      member1.addActionListener(this);
      instructor1.addActionListener(this);
      services1.addActionListener(this);
      product1.addActionListener(this);
      icardm1.addActionListener(this);
      icardi1.addActionListener(this);
      bill1.addActionListener(this);
     allbill=new JMenuItem("Final Bill Generation");
     allbill.addActionListener(this);
     bill.add(allbill);
     bar.add(form);
     bar.add(report);
     bar.add(ic);
     bar.add(bill);
     setJMenuBar(bar);
     setDefaultCloseOperation(EXIT_ON_CLOSE);
     setBounds(0,0,1025,740);
     JLabel jl=new JLabel(new ImageIcon("inst.jpg"));
     c.add(jl);
     jl.setBounds(0,0,1025,740);
     setVisible(true);
      }
      public void actionPerformed(ActionEvent ae)
       {
          if(ae.getSource()==member)
           {
               new Member();
            }
          else if(ae.getSource()==instructor)
           {
                 new Instructor();
            }
            else if(ae.getSource()==services)
           {
                   new Services();
            }
            else if(ae.getSource()==product)
           {
                 new Product();
            }
           else if(ae.getSource()==icardm2)
           {
                  new IcardMem();
            }
            else if(ae.getSource()==icardi2)
           {
                   new IcardInstructor();
            }
           else if(ae.getSource()==allbill)
           {
                       new BillForm();
           }
       else if(ae.getSource()==member1)
           {
                   new MemberReport();
           }
        else if(ae.getSource()==instructor1)
           {
                  new InstructorReport();
           }
            else if(ae.getSource()==services1)
           {
                  new ServicesReport();
           }
            else if(ae.getSource()==product1)
           {
                  new ProductReport();
           }
        else if(ae.getSource()==icardm1)
           {
                   new IcardMemberReport();
           }
           else if(ae.getSource()==icardi1)
           {
                   new IcardInstructorReport();
           }
         else if(ae.getSource()==bill1)
          {
                new BillReport1();
          }

        }
}





   
