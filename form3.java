import java.sql.*;
import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import javax.swing.border.*;
public class form3 extends JFrame 
{
JLabel l1,l2,l3,l4;
JTextField t1,t2;                                                                                                              
JButton b1,b2,b3;	

public form3()
{
Container d=getContentPane();
d.setLayout(null);
ImageIcon icon=new ImageIcon("bg2.jpeg");
l3=new JLabel(icon);
d.add(l3);

Font f = new Font("Times New Roman",Font.BOLD,30);
l1=new JLabel(" Minimizing shoulder surfing attack using ",JLabel.CENTER);
l2=new JLabel("Text and color Based Graphical Password Scheme",JLabel.CENTER);
l1.setFont(f);
l2.setFont(f);
l4=new JLabel(new ImageIcon("icon1.jpeg"));
b1=new JButton("Registration");

b1.setBackground(Color.pink);
b1.setForeground(Color.black);

b2=new JButton("Login");
b2.setBackground(Color.pink);
b2.setForeground(Color.BLACK);

b3=new JButton("Exit");
b3.setBackground(Color.red);
b3.setForeground(Color.BLACK);

l1.setBounds(250,20,600,30);
l2.setBounds(250,65,650,30);
l3.setBounds(0,0,1500,800);
b1.setBounds(230,550,120,40);
b2.setBounds(430,550,120,40);
b3.setBounds(660,550,120,40);
l4.setBounds(290,125,500,400);
l3.add(l1);
l3.add(l2);
l3.add(l4);
l3.add(b1);
l3.add(b2);
l3.add(b3);
b2.addActionListener(new ActionListener(){
public void actionPerformed(ActionEvent tt){
new form2();
}});

b1.addActionListener(new ActionListener(){
public void actionPerformed(ActionEvent tt){
new form1();
}});


b3.addActionListener(new ActionListener(){
public void actionPerformed(ActionEvent tt){
dispose();
}});

setSize(1500,800);
setVisible(true);
addWindowListener(new WindowAdapter(){
public void actionPerformed(ActionEvent tt){
dispose();
}});

}
public static void main(String[] args)
{
new form3();
}
}
