import java.sql.*;
import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import javax.swing.border.*;
public class form1 extends JFrame
{
JLabel l1,l2,l3,l4,l5,l6,l7;
JTextField t1,t2;
JPanel p1;
JButton b1,b2,b3,b4,b5,b6,b7,b8,b9,b10,b11,b12;
ResultSet rs;
String str="";
boolean flag=true;
public form1()
{
Container c1=getContentPane();
c1.setLayout(null);

//Container d=getContentPane();
//d.setLayout(null);
l6=new JLabel(new ImageIcon("bg2.jpeg"));
c1.add(l6);


JPanel p=new JPanel();
p.setBorder(new LineBorder(Color.RED,5,true));
p.setLayout(null);
p.setBounds(30,110,500,500);
p.setBackground(Color.white);
l6.add(p);
try
{
Class.forName("sun.jdbc.odbc.JdbcOdbcDriver");
Connection con=DriverManager.getConnection("Jdbc:Odbc:capston","","");
Statement st=con.createStatement(ResultSet.TYPE_SCROLL_SENSITIVE,ResultSet.CONCUR_UPDATABLE);
rs=st.executeQuery("select * from information");
}catch(Exception ee){}
Font f = new Font("Times New Roman",Font.BOLD,30);
		
l1=new JLabel("Password Registration",JLabel.CENTER);
l1.setFont(f);

l2=new JLabel("Enter Your Password");
l3=new JLabel("Select Color ");
l4=new JLabel("Selected Color");
l5=new JLabel("Email Address");
l7=new JLabel(new ImageIcon("icon5.jpeg"));
t1=new JPasswordField(20);
t2=new JTextField(20);

b1=new JButton("");
b1.setBackground(Color.red);
b2=new JButton("");
b2.setBackground(Color.green);
b3=new JButton("");
b3.setBackground(Color.blue);
b4=new JButton("");
b4.setBackground(Color.yellow);
b5=new JButton("");
b5.setBackground(Color.black);
b6=new JButton("");
b6.setBackground(Color.orange);
b7=new JButton("");
b7.setBackground(Color.magenta);
b8=new JButton("");
b8.setBackground(Color.pink);
b9=new JButton("");
b10=new JButton("Save");
b10.setBackground(Color.pink);
b10.setForeground(Color.BLACK);
b10.addActionListener(new ActionListener(){
public void actionPerformed(ActionEvent tt){
try
{
flag=true;
	try
	{
	rs.first();
	do
	{
	if(rs.getString("emailid").equals(t2.getText().trim()))
	{
	flag=false;
	break;
	}
	}while(rs.next());
	}catch(Exception eeew333){}
if(flag==true)
{
rs.moveToInsertRow();
rs.updateString("Password",t1.getText().trim());
rs.updateString("emailid",t2.getText().trim());
rs.updateString("color",str);
rs.insertRow();
JOptionPane.showMessageDialog(null,"Saved","MyProj",3);
}
else
{
JOptionPane.showMessageDialog(null,"Already Exist","MyProj",3);
}
}catch(Exception ee){}
}});

b11=new JButton("Clear");
b11.setBackground(Color.pink);
b11.setForeground(Color.BLACK);

b11.addActionListener(new ActionListener(){
public void actionPerformed(ActionEvent tt){
t1.setText("");
t2.setText("");
b9.setBackground(Color.white);
}});
b12=new JButton("Exit");
b12.setBackground(Color.red);
b12.setForeground(Color.BLACK);

b12.addActionListener(new ActionListener(){
public void actionPerformed(ActionEvent tt){
dispose();
}});
l1.setBounds(30,50,600,35);
l2.setBounds(40,140,150,30);
l3.setBounds(40,190,150,30);
l4.setBounds(40,250,100,30);
l5.setBounds(40,280,100,30);
l6.setBounds(0,0,1500,800);
l7.setBounds(600,30,700,700);
t1.setBounds(300,140,130,30);
t2.setBounds(300,280,130,30);

b1.setBounds(300,180,15,15);
b2.setBounds(330,180,15,15);
b3.setBounds(360,180,15,15);
b4.setBounds(390,180,15,15);
b5.setBounds(300,205,15,15);
b6.setBounds(330,205,15,15);
b7.setBounds(360,205,15,15);
b8.setBounds(390,205,15,15);
b9.setBounds(300,250,15,15);
b10.setBounds(35,440,100,30);
b11.setBounds(180,440,100,30);
b12.setBounds(420,450,60,30);

l6.add(l7);
l6.add(l1);
p.add(l2);
p.add(l3);
p.add(l4);
p.add(l5);
p.add(t1);
p.add(t2);
p.add(b1);
p.add(b2);
p.add(b3);
p.add(b4);
p.add(b5);
p.add(b6);
p.add(b7);
p.add(b8);
p.add(b9);
p.add(b10);
p.add(b11);
p.add(b12);
setSize(1500,800);
setVisible(true);
addWindowListener(new WindowAdapter(){
public void actionPerformed(ActionEvent tt){
dispose();
}});
b1.addActionListener(new ActionListener(){
public void actionPerformed(ActionEvent Event)
{
b9.setBackground(Color.red);
str="red";
}
});
b2.addActionListener(new ActionListener(){
public void actionPerformed(ActionEvent Event)
{
b9.setBackground(Color.green);
str="green";
}
});
b3.addActionListener(new ActionListener(){
public void actionPerformed(ActionEvent Event)
{
b9.setBackground(Color.blue);
str="blue";
}
});
b4.addActionListener(new ActionListener(){
public void actionPerformed(ActionEvent Event)
{
b9.setBackground(Color.yellow);
str="yellow";
}
});
b5.addActionListener(new ActionListener(){
public void actionPerformed(ActionEvent Event)
{
b9.setBackground(Color.black);
str="black";
}
});
b6.addActionListener(new ActionListener(){
public void actionPerformed(ActionEvent Event)
{
b9.setBackground(Color.orange);
str="orange";
}
});
b7.addActionListener(new ActionListener(){
public void actionPerformed(ActionEvent Event)
{
b9.setBackground(Color.magenta);
str="magenta";
}
});
b8.addActionListener(new ActionListener(){
public void actionPerformed(ActionEvent Event)
{
b9.setBackground(Color.pink);
str="pink";
}
});
t2.addKeyListener(new KeyAdapter(){
public void keyTyped(KeyEvent e)
{
char c=e.getKeyChar();
if(!((Character.isLowerCase(c))||(c=='@')||(c=='.')||(Character.isDigit(c))))
{
e.consume();	
}
}});
t1.addKeyListener(new KeyAdapter(){
public void keyTyped(KeyEvent e)
{
char c=e.getKeyChar();
if(!((Character.isDigit(c))||(c=='a')||(c=='b')||(c=='c')||(c=='d')||(c=='e')||(c=='f')||(c=='g')||(c=='h')||(c=='i')||(c=='j')||(c=='A')||(c=='B')||(c=='C')||(c=='D')||(c=='E')||(c=='F')||(c=='G')||(c=='H')||(c=='I')||(c=='J')||(c=='.')||(c=='/')))
{
e.consume();	
}

}});
}
public static void main(String[] args)
{
new form1();
}
} 