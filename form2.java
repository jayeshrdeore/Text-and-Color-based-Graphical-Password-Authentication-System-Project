import java.sql.*;
import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import javax.swing.border.*;
public class form2 extends JFrame 
{
JLabel l1,l2,l4,l3,l5;
JPanel p;
JTextField t1,t2;
JButton b1,b2,b3,b4,b5,b6,b7,b8,b9;		
ResultSet rs;
Graphics g;
final static BasicStroke ws=new BasicStroke(8.0f);
boolean flag=true;
int x[]={0,45,90,135,180,225,270,315,360};
Color c[]={Color.red,Color.green,Color.blue,Color.yellow,Color.black,Color.orange,Color.magenta,Color.pink};
char orbit1[]={'A','/','2','a','g','i','3','G'};
char orbit2[]={'7','B','J','.','4','E','f','8'};
char orbit3[]={'0','F','b','e','5','D','I','c'};
char orbit4[]={'H','h','6','1','C','d','9','j'};
int cc=0;
 int colorcount=0;
int mycolor=-1;
String pwd="";
public form2()
{
Container c1=getContentPane();
c1.setLayout(null);
l4=new JLabel(new ImageIcon("bg2.jpeg"));
c1.add(l4);

JPanel p=new JPanel();
p.setBorder(new LineBorder(Color.RED,3,true));
p.setLayout(null);
p.setBounds(10,10,600,700);
p.setBackground(Color.white);
l4.add(p);

//c1.setBackground(Color.LIGHT_GRAY);
try
{
Class.forName("sun.jdbc.odbc.JdbcOdbcDriver");
Connection con=DriverManager.getConnection("Jdbc:Odbc:capston","","");
Statement st=con.createStatement(ResultSet.TYPE_SCROLL_SENSITIVE,ResultSet.CONCUR_UPDATABLE);
rs=st.executeQuery("select * from information");
}catch(Exception ee){}
l1=new JLabel("Enter E-mail Id");
l2=new JLabel("Password");
Font f = new Font("Times New Roman",Font.BOLD,30);
l5=new JLabel("Login");
l5.setFont(f);		
l3=new JLabel(new ImageIcon("icon3.jpeg"));
t1=new JTextField(20);
t2=new JPasswordField(20);
b1=new JButton("Verify");
b1.setBackground(Color.pink);
b1.setForeground(Color.BLACK);

b2=new JButton("Inner most orbit");
b2.setBackground(Color.pink);
b2.setForeground(Color.BLACK);

b3=new JButton("Inner Orbit");
b3.setBackground(Color.pink);
b3.setForeground(Color.BLACK);

b4=new JButton("outer orbit");
b4.setBackground(Color.pink);
b4.setForeground(Color.BLACK);

b5=new JButton("Outer most Orbit");
b5.setBackground(Color.pink);
b5.setForeground(Color.BLACK);


b2.addActionListener(new ActionListener(){
public void actionPerformed(ActionEvent tt){
int ii=mycolor+cc;

if(ii<0)
{
switch(ii)
{
case -1:ii=7;break;
case -2:ii=6;break;
case -3:ii=5;break;
case -4:ii=4;break;
case -5:ii=3;break;
case -6:ii=2;break;
case -7:ii=1;break;
}
}
else
if(ii>7)
{
switch(ii)
{
case 8:ii=0;break;
case 9:ii=1;break;
case 10:ii=2;break;
case 11:ii=3;break;
case 12:ii=4;break;
case 13:ii=5;break;
case 14:ii=6;break;
}
}


t2.setText((t2.getText()+orbit1[ii])+"");

//System.out.println("Color count="+cc);
//System.out.println("Mycolor="+mycolor);
//System.out.println("II"+ii);

}});

b3.addActionListener(new ActionListener(){
public void actionPerformed(ActionEvent tt){
int ii=mycolor+cc;

if(ii<0)
{
switch(ii)
{
case -1:ii=7;break;
case -2:ii=6;break;
case -3:ii=5;break;
case -4:ii=4;break;
case -5:ii=3;break;
case -6:ii=2;break;
case -7:ii=1;break;
}
}
else
if(ii>7)
{
switch(ii)
{
case 8:ii=0;break;
case 9:ii=1;break;
case 10:ii=2;break;
case 11:ii=3;break;
case 12:ii=4;break;
case 13:ii=5;break;
case 14:ii=6;break;
}
}


t2.setText((t2.getText()+orbit2[ii])+"");

//System.out.println("Color count="+cc);
//System.out.println("Mycolor="+mycolor);
//System.out.println("II"+ii);

}});

b4.addActionListener(new ActionListener(){
public void actionPerformed(ActionEvent tt){
int ii=mycolor+cc;

if(ii<0)
{
switch(ii)
{
case -1:ii=7;break;
case -2:ii=6;break;
case -3:ii=5;break;
case -4:ii=4;break;
case -5:ii=3;break;
case -6:ii=2;break;
case -7:ii=1;break;
}
}
else
if(ii>7)
{
switch(ii)
{
case 8:ii=0;break;
case 9:ii=1;break;
case 10:ii=2;break;
case 11:ii=3;break;
case 12:ii=4;break;
case 13:ii=5;break;
case 14:ii=6;break;
}
}


t2.setText((t2.getText()+orbit3[ii])+"");

//System.out.println("Color count="+cc);
//System.out.println("Mycolor="+mycolor);
//System.out.println("II"+ii);

}});

b5.addActionListener(new ActionListener(){
public void actionPerformed(ActionEvent tt){
int ii=mycolor+cc;

if(ii<0)
{
switch(ii)
{
case -1:ii=7;break;
case -2:ii=6;break;
case -3:ii=5;break;
case -4:ii=4;break;
case -5:ii=3;break;
case -6:ii=2;break;
case -7:ii=1;break;
}
}
else
if(ii>7)
{
switch(ii)
{
case 8:ii=0;break;
case 9:ii=1;break;
case 10:ii=2;break;
case 11:ii=3;break;
case 12:ii=4;break;
case 13:ii=5;break;
case 14:ii=6;break;
}
}


t2.setText((t2.getText()+orbit4[ii])+"");

//System.out.println("Color count="+cc);
//System.out.println("Mycolor="+mycolor);
//System.out.println("II"+ii);

}});


ImageIcon ac=new ImageIcon("anti.PNG");
b6=new JButton(ac);
b6.addActionListener(new ActionListener(){
public void actionPerformed(ActionEvent tt){
cc++;
colorcount--;
if(colorcount==-1)
colorcount=7;
int j=colorcount;
g.setColor(Color.white);
g.fillRect(90,90,440,440);
g.setColor(Color.black);
Graphics2D g2=(Graphics2D) g;
g2.setStroke(ws);

for(int i=0;i<x.length-1;i++)
{
g2.setColor(c[j]);
j++;
if(j==8)
j=0;
g2.drawArc(100,100,400,400,x[i],(x[i+1]-x[i]));
}

g.setColor(Color.black);
g.drawLine(100,295,500,295);
g.drawLine(300,100,300,500);
g.drawLine(165,155,440,440);
g.drawLine(154,440,440,160);
Font f = new Font("Times New Roman",Font.BOLD,15);
g.setFont(f);
g.drawString("A",335,286);
g.drawString("7",368,277);
g.drawString("0",407,254);
g.drawString("H",440,234);

g.drawString("/",313,262);
g.drawString("B",324,231);
g.drawString("F",343,190);
g.drawString("h",358,153);

g.drawString("2",281,264);
g.drawString("J",272,232);
g.drawString("b",261,187);
g.drawString("6",240,153);

g.drawString("a",263,289);
g.drawString(".",233,267);
g.drawString("e",191,243);
g.drawString("1",155,234);

g.drawString("g",265,311);
g.drawString("4",224,322);
g.drawString("5",186,342);
g.drawString("C",151,362);

g.drawString("i",280,333);
g.drawString("E",267,371);
g.drawString("D",247,406);
g.drawString("d",234,442);

g.drawString("3",313,331);
g.drawString("f",326,374);
g.drawString("I",342,411);
g.drawString("9",358,447);

g.drawString("G",335,311);
g.drawString("8",375,327);
g.drawString("c",410,344);
g.drawString("j",448,361);

//System.out.println("Color count="+colorcount);
//System.out.println("Mycolor="+mycolor);


}});
ImageIcon clock=new ImageIcon("clock.jpg");
b7=new JButton(clock);
b7.setBackground(Color.cyan);
//b7.setForeground(Color.BLACK);

b7.addActionListener(new ActionListener(){
public void actionPerformed(ActionEvent tt){
cc--;
colorcount++;
if(colorcount==8)
colorcount=0;
int j=colorcount;
g.setColor(Color.white);
g.fillRect(90,90,440,440);
g.setColor(Color.black);
Graphics2D g2=(Graphics2D) g;
g2.setStroke(ws);

for(int i=0;i<x.length-1;i++)
{
g2.setColor(c[j]);
j++;
if(j==8)
j=0;
g2.drawArc(100,100,400,400,x[i],(x[i+1]-x[i]));
}

g.setColor(Color.black);
g.drawLine(100,295,500,295);
g.drawLine(300,100,300,500);
g.drawLine(165,155,440,440);
g.drawLine(154,440,440,160);
Font f = new Font("Times New Roman",Font.BOLD,15);
g.setFont(f);

g.drawString("A",335,286);
g.drawString("7",368,277);
g.drawString("0",407,254);
g.drawString("H",440,234);

g.drawString("/",313,262);
g.drawString("B",324,231);
g.drawString("F",343,190);
g.drawString("h",358,153);

g.drawString("2",281,264);
g.drawString("J",272,232);
g.drawString("b",261,187);
g.drawString("6",240,153);

g.drawString("a",263,289);
g.drawString(".",233,267);
g.drawString("e",191,243);
g.drawString("1",155,234);

g.drawString("g",265,311);
g.drawString("4",224,322);
g.drawString("5",186,342);
g.drawString("C",151,362);

g.drawString("i",280,333);
g.drawString("E",267,371);
g.drawString("D",247,406);
g.drawString("d",234,442);

g.drawString("3",313,331);
g.drawString("f",326,374);
g.drawString("I",342,411);
g.drawString("9",358,447);

g.drawString("G",335,311);
g.drawString("8",375,327);
g.drawString("c",410,344);
g.drawString("j",448,361);

//System.out.println("Color count="+colorcount);
//System.out.println("Mycolor="+mycolor);


}});


b8=new JButton("Exit");
b8.setBackground(Color.red);
b8.setForeground(Color.BLACK);

b9=new JButton("Submit");
b9.setBackground(Color.pink);
b9.setForeground(Color.BLACK);

//l1.setBounds(30,50,600,35);
l5.setBounds(700,50,600,35);
l1.setBounds(30,20,150,30);
l3.setBounds(600,30,700,700);
t1.setBounds(220,20,150,30);

b1.setBounds(410,20,100,30);
b2.setBounds(30,500,100,30);
b3.setBounds(150,500,100,30);
b4.setBounds(270,500,100,30);
b5.setBounds(390,500,100,30);
b6.setBounds(120,560,50,50);
b7.setBounds(330,560,50,50);
b8.setBounds(210,670,60,30);
b9.setBounds(360,620,100,30);
l2.setBounds(30,620,150,30);
t2.setBounds(150,620,150,30);
l4.setBounds(0,0,1500,800);
b9.addActionListener(new ActionListener(){
public void actionPerformed(ActionEvent tt){
if(t2.getText().trim().equals(pwd))
JOptionPane.showMessageDialog(null,"Login Successful","MyProj",2);
else
JOptionPane.showMessageDialog(null,"Login UnSuccessful","MyProj",2);

}
});
b8.addActionListener(new ActionListener(){
public void actionPerformed(ActionEvent tt){
dispose();
}});

b1.addActionListener(new ActionListener(){
public void actionPerformed(ActionEvent tt){
try
{
flag=true;
	try
	{
	rs.first();
	do
	{
	if(rs.getString("emailid").equals(t1.getText().trim()))
	{
	flag=false;
	String pp1=rs.getString("color");
	pwd=rs.getString("password");
	if(pp1.equalsIgnoreCase("red"))
	mycolor=0;
	else
	if(pp1.equalsIgnoreCase("green"))
	mycolor=1;
	else
	if(pp1.equalsIgnoreCase("blue"))
	mycolor=2;
	else
	if(pp1.equalsIgnoreCase("yellow"))
	mycolor=3;
	else
	if(pp1.equalsIgnoreCase("black"))
	mycolor=4;
	else
	if(pp1.equalsIgnoreCase("orange"))
	mycolor=5;
	else
	if(pp1.equalsIgnoreCase("magenta"))
	mycolor=6;
	else
	mycolor=7;
	break;
	}
	}while(rs.next());
//colorcount=mycolor;
}catch(Exception eeew333){}
if(flag==true)
{

	JOptionPane.showMessageDialog(null,"Invalid E-mail","MyProj",3);			
}
else{
g=getGraphics();
Graphics2D g2=(Graphics2D) g;
g2.setStroke(ws);
for(int i=0;i<x.length-1;i++)
{
g2.setColor(c[i]);
g2.drawArc(100,100,400,400,x[i],(x[i+1]-x[i]));
}
g.setColor(Color.black);
g.drawLine(100,295,500,295);
g.drawLine(300,100,300,500);
g.drawLine(165,155,440,440);
g.drawLine(154,440,440,160);
Font f = new Font("Times New Roman",Font.BOLD,15);
g.setFont(f);

g.drawString("A",335,286);
g.drawString("7",368,277);
g.drawString("0",407,254);
g.drawString("H",440,234);

g.drawString("/",313,262);
g.drawString("B",324,231);
g.drawString("F",343,190);
g.drawString("h",358,153);

g.drawString("2",281,264);
g.drawString("J",272,232);
g.drawString("b",261,187);
g.drawString("6",240,153);

g.drawString("a",263,289);
g.drawString(".",233,267);
g.drawString("e",191,243);
g.drawString("1",155,234);

g.drawString("g",265,311);
g.drawString("4",224,322);
g.drawString("5",186,342);
g.drawString("C",151,362);

g.drawString("i",280,333);
g.drawString("E",267,371);
g.drawString("D",247,406);
g.drawString("d",234,442);

g.drawString("3",313,331);
g.drawString("f",326,374);
g.drawString("I",342,411);
g.drawString("9",358,447);

g.drawString("G",335,311);
g.drawString("8",375,327);
g.drawString("c",410,344);
g.drawString("j",448,361);
}
}catch(Exception e){}
}});
l4.add(l5);
p.add(l1);
p.add(l2);
l4.add(l3);
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
setSize(1500,800);
setVisible(true);
addWindowListener(new WindowAdapter(){
public void actionPerformed(ActionEvent tt){
dispose();
}});

}
public static void main(String[] args)
{
new form2();
}
}




