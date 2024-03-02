import java.awt.*;
import java.awt.event.*;
import java.sql.*;
import javax.swing.*;
import javax.swing.border.*;
import java.util.Random;

public class form2 extends JFrame {

  JLabel l1, l2, l4, l3, l5;
  JPanel p;
  JTextField t1, t2;
  JButton b1, b2, b3, b4, b5, b6, b7, b8, b9;
  ResultSet rs;
  Graphics g;
  Connection con;
  static final BasicStroke ws = new BasicStroke(8.0f);
  boolean flag = true;
  int x[] = {0, 16, 31, 47, 63, 78, 94, 110, 125, 141, 157, 172, 188, 203, 219, 235, 250, 266, 282, 297, 313, 329, 344, 360};
  Color c[] = {
		  Color.decode("#7DF9FF"), // Electric Blue
		  Color.decode("#FF7F50"), // Coral
		  Color.decode("#702670"), // Midnight Purple
		  Color.decode("#40E0D0"), // Turquoise
		  Color.decode("#FFB900"), // Marigold
		  Color.decode("#0047AB"), // Cobalt
		  Color.decode("#FA8072"), // Salmon
		  Color.decode("#7FFF00"), // Chartreuse
		  Color.decode("#4B0082"), // Indigo
		  Color.decode("#FFA500"), // Tangerine
		  Color.decode("#008080"), // Teal
		  Color.decode("#DC143C"), // Crimson
		  Color.decode("#98FF98"), // Mint Green
		  Color.decode("#E6E6FA"), // Lavender
		  Color.decode("#FFBF00"), // Amber
		  Color.decode("#00FFFF"), // Cyan
		  Color.decode("#B57EDC"), // Mauve
		  Color.decode("#FFD700"), // Gold
		  Color.decode("#F0FFFF"), // Azure
		  Color.decode("#FF00FF"), // Fuchsia
		  Color.decode("#00A86B"), // Jade
		  Color.decode("#E34234"), // Vermilion
		  Color.decode("#DA70D6") // Orchid


  };
  char orbit1[] = { 'a', 'b', 'c', 'd', 'e', 'f', 'g', 'h', 'i', 'j', 'k', 'l', 'm', 'n', 'o', 'p', 'q', 'r', 's', 't', 'u', 'v', 'w' };
  char orbit2[] = { 'x', 'y', 'z', 'A', 'B', 'C', 'D', 'E', 'F', 'G', 'H', 'I', 'J', 'K', 'L', 'M', 'N', 'O', 'P', 'Q', 'R', 'S', 'T' };
  char orbit3[] = { 'U', 'V', 'W', 'X', 'Y', 'Z', '!', '@', '#', '$', '%', '|', '&', '*', '(', ')', '_', '+', '-', '=', '[', ']', '`' };
  char orbit4[] = { '{', '}', ';', '\'', ':', '"', ',', '.', '<', '>', '/', '?', '0', '1', '2', '3', '4', '5', '6', '7', '8', '9', '~' };

  int cc = 0;
  int colorcount = 0;
  int mycolor = -1;
  String pwd = "";
  
  private static Random rand = new Random();

  public form2() {
    Container c1 = getContentPane();
    c1.setLayout(null);
    l4 = new JLabel(new ImageIcon("bg2.jpeg"));
    c1.add(l4);

    JPanel p = new JPanel();
    p.setBorder(new LineBorder(Color.RED, 3, true));
    p.setLayout(null);
    p.setBounds(10, 10, 600, 700);
    p.setBackground(Color.white);
    l4.add(p);

    //c1.setBackground(Color.LIGHT_GRAY);
    try {
    	Class.forName("com.mysql.jdbc.Driver");
        con = DriverManager.getConnection("jdbc:mysql://localhost:3306/Neha", "root", "92410");
             
        PreparedStatement st = con.prepareStatement(
      		  "select * from users",
      		  ResultSet.TYPE_SCROLL_SENSITIVE,
      		  ResultSet.CONCUR_UPDATABLE);
        rs = st.executeQuery();
        
        System.out.println("Database Connection successful!");
    } catch (Exception ee) {}
    l1 = new JLabel("Enter E-mail Id");
    l2 = new JLabel("Password");
    Font f = new Font("Times New Roman", Font.BOLD, 30);
    l5 = new JLabel("Login");
    l5.setFont(f);
    l3 = new JLabel(new ImageIcon("icon3.jpeg"));
    t1 = new JTextField(20);
    t2 = new JPasswordField(20);
    b1 = new JButton("Verify");
    b1.setBackground(Color.pink);
    b1.setForeground(Color.BLACK);

    b2 = new JButton("Inner Most Orbit");
    b2.setBackground(Color.pink);
    b2.setForeground(Color.BLACK);

    b3 = new JButton("Inner Orbit");
    b3.setBackground(Color.pink);
    b3.setForeground(Color.BLACK);

    b4 = new JButton("Outer Orbit");
    b4.setBackground(Color.pink);
    b4.setForeground(Color.BLACK);

    b5 = new JButton("Outer Most Orbit");
    b5.setBackground(Color.pink);
    b5.setForeground(Color.BLACK);

    b2.addActionListener(
      new ActionListener() {
        public void actionPerformed(ActionEvent tt) {
         
          t2.setText((t2.getText() + orbit1[Math.abs(colorcount-22)]) + "");
          
        //Shuffle array
          shuffleArray(orbit1);
        //Shuffle array
          shuffleArray(orbit2);  
        //Shuffle array
          shuffleArray(orbit3);  
        //Shuffle array
          shuffleArray(orbit4); 
          
int j = colorcount;
          
          g.setColor(Color.white);
          g.fillRect(90, 90, 440, 440);
          g.setColor(Color.black);
          
          Graphics2D g2 = (Graphics2D) g;
          
          g2.setStroke(ws);

          for (int i = 0; i < x.length - 1; i++) {
        	  
            g2.setColor(c[j]);
            
            j++;
            
            if (j == 23) j = 0;
            
            g2.drawArc(100, 100, 400, 400, x[i], (x[i + 1] - x[i]));
          }
          
          Graphics2D lines = (Graphics2D) g;
          drawChars(lines);
          

        }
      }
    );
    
//    System.out.println(cc + '|' + mycolor + '|' + cc+mycolor);

    b3.addActionListener(
    		
      new ActionListener() {
    	  
        public void actionPerformed(ActionEvent tt) {
        	
          
          t2.setText((t2.getText() + orbit2[Math.abs(colorcount-22)]) + "");
          
        //Shuffle array
          shuffleArray(orbit1);
        //Shuffle array
          shuffleArray(orbit2);  
        //Shuffle array
          shuffleArray(orbit3);  
        //Shuffle array
          shuffleArray(orbit4);  
          
int j = colorcount;
          
          g.setColor(Color.white);
          g.fillRect(90, 90, 440, 440);
          g.setColor(Color.black);
          
          Graphics2D g2 = (Graphics2D) g;
          
          g2.setStroke(ws);

          for (int i = 0; i < x.length - 1; i++) {
        	  
            g2.setColor(c[j]);
            
            j++;
            
            if (j == 23) j = 0;
            
            g2.drawArc(100, 100, 400, 400, x[i], (x[i + 1] - x[i]));
          }
          
          Graphics2D lines = (Graphics2D) g;
          drawChars(lines);
          

        }
      }
    );

    b4.addActionListener(
      new ActionListener() {
        public void actionPerformed(ActionEvent tt) {
          

          t2.setText((t2.getText() + orbit3[Math.abs(colorcount-22)]) + "");
          
        //Shuffle array
          shuffleArray(orbit1);
        //Shuffle array
          shuffleArray(orbit2);  
        //Shuffle array
          shuffleArray(orbit3);  
        //Shuffle array
          shuffleArray(orbit4);  
          
int j = colorcount;
          
          g.setColor(Color.white);
          g.fillRect(90, 90, 440, 440);
          g.setColor(Color.black);
          
          Graphics2D g2 = (Graphics2D) g;
          
          g2.setStroke(ws);

          for (int i = 0; i < x.length - 1; i++) {
        	  
            g2.setColor(c[j]);
            
            j++;
            
            if (j == 23) j = 0;
            
            g2.drawArc(100, 100, 400, 400, x[i], (x[i + 1] - x[i]));
          }
          
          Graphics2D lines = (Graphics2D) g;
          drawChars(lines);
          
        }
      }
    );

    b5.addActionListener(
      new ActionListener() {
        public void actionPerformed(ActionEvent tt) {
          
          t2.setText((t2.getText() + orbit4[Math.abs(colorcount-22)]) + "");
          
        //Shuffle array
          shuffleArray(orbit1);
        //Shuffle array
          shuffleArray(orbit2);  
        //Shuffle array
          shuffleArray(orbit3);  
        //Shuffle array
          shuffleArray(orbit4);  
          
          int j = colorcount;
          
          g.setColor(Color.white);
          g.fillRect(90, 90, 440, 440);
          g.setColor(Color.black);
          
          Graphics2D g2 = (Graphics2D) g;
          
          g2.setStroke(ws);

          for (int i = 0; i < x.length - 1; i++) {
        	  
            g2.setColor(c[j]);
            
            j++;
            
            if (j == 23) j = 0;
            
            g2.drawArc(100, 100, 400, 400, x[i], (x[i + 1] - x[i]));
          }
          
          Graphics2D lines = (Graphics2D) g;
          drawChars(lines);
                    

        }
      }
    );

    ImageIcon ac = new ImageIcon("anti.png");
    b6 = new JButton(ac);
    
    b6.addActionListener(
    		
      new ActionListener() {
    	  
        public void actionPerformed(ActionEvent tt) {
        	
          cc++;
          colorcount--;
          
          if (colorcount == -1) colorcount = 22;

          int j = colorcount;
          
          g.setColor(Color.white);
          g.fillRect(90, 90, 440, 440);
          g.setColor(Color.black);
          
          Graphics2D g2 = (Graphics2D) g;
          
          g2.setStroke(ws);

          for (int i = 0; i < x.length - 1; i++) {
        	  
            g2.setColor(c[j]);
            
            j++;
            
            if (j == 23) j = 0;
            
            g2.drawArc(100, 100, 400, 400, x[i], (x[i + 1] - x[i]));
          }
          
          Graphics2D lines = (Graphics2D) g;
          drawChars(lines);
        }
      }
    );
    ImageIcon clock = new ImageIcon("clock.jpg");
    b7 = new JButton(clock);
    b7.setBackground(Color.cyan);
    //b7.setForeground(Color.BLACK);
    b7.addActionListener(
      new ActionListener() {
        public void actionPerformed(ActionEvent tt) {
        	
          cc--; 
          colorcount++;
          
          if (colorcount == 23) 
        	  colorcount = 0;
          
          System.out.println(orbit1[Math.abs(colorcount-22)]);
          System.out.println(Math.abs(colorcount-22));
          
//          System.out.println(c[colorcount] + " === " + colorcount);
          
          int j = colorcount;
          
          g.setColor(Color.white);
          g.fillRect(90, 90, 440, 440);
          g.setColor(Color.black);
          Graphics2D g2 = (Graphics2D) g;
          g2.setStroke(ws);

          for (int i = 0; i < x.length - 1; i++) {
            g2.setColor(c[j]);
            j++;
            if (j == 23) j = 0;
            g2.drawArc(100, 100, 400, 400, x[i], (x[i + 1] - x[i]));
          }
          
          Graphics2D lines = (Graphics2D) g;
          drawChars(lines);

        }
      }
    );

    b8 = new JButton("Exit");
    b8.setBackground(Color.red);
    b8.setForeground(Color.BLACK);

    b9 = new JButton("Submit");
    b9.setBackground(Color.pink);
    b9.setForeground(Color.BLACK);

    //l1.setBounds(30,50,600,35);
    l5.setBounds(700, 50, 600, 35);
    l1.setBounds(30, 20, 150, 30);
    l3.setBounds(600, 30, 700, 700);
    t1.setBounds(220, 20, 150, 30);

    b1.setBounds(410, 20, 100, 30);
    b2.setBounds(30, 500, 100, 30);
    b3.setBounds(150, 500, 100, 30);
    b4.setBounds(270, 500, 100, 30);
    b5.setBounds(390, 500, 100, 30);
    b6.setBounds(120, 560, 50, 50);
    b7.setBounds(330, 560, 50, 50);
    b8.setBounds(210, 670, 60, 30);
    b9.setBounds(360, 620, 100, 30);
    l2.setBounds(30, 620, 150, 30);
    t2.setBounds(150, 620, 150, 30);
    l4.setBounds(0, 0, 1500, 800);
    b9.addActionListener(
      new ActionListener() {
        public void actionPerformed(ActionEvent tt) {
        	System.out.println(t2.getText());
          if (t2.getText().trim().equals(pwd)) JOptionPane.showMessageDialog(
            null,
            "Login Successful",
            "Success",
            2
          ); else JOptionPane.showMessageDialog(
            null,
            "Login Unsuccessful",
            "Oops",
            2
          );
        }
      }
    );
    b8.addActionListener(
      new ActionListener() {
        public void actionPerformed(ActionEvent tt) {
          dispose();
        }
      }
    );

    b1.addActionListener(
      new ActionListener() {
        public void actionPerformed(ActionEvent tt) {
          try {
            flag = true;
            try {
              rs.first();
              do {
                if (rs.getString("email").equals(t1.getText().trim())) {
                  flag = false;
                  String pp1 = rs.getString("color");
                  pwd = rs.getString("password");
                  
                  String colors[] = {
                		  "Electric Blue",
                		  "Coral",
                		  "Midnight Purple",
                		  "Turquoise",
                		  "Teal",
                		  "Cobalt",
                		  "Salmon",
                		  "Chartreuse",
                		  "Indigo",
                		  "Tangerine",
                		  "Teal",
                		  "Crimson",
                		  "Mint Green",
                		  "Lavender",
                		  "Amber",
                		  "Cyan",
                		  "Mauve",
                		  "Gold",
                		  "Azure",
                		  "Fuchsia",
                		  "Jade",
                		  "Vermilion",
                		  "Orchid",
                  };
                  
                  for (int i = 0; i < colors.length; i++) {
//                	  System.out.println(colors[i] + " --- " + pp1);
                      if (colors[i].equalsIgnoreCase(pp1)) {
                          mycolor = i;
                          break;
                      }
                  }
                  break;
                }
              } while (rs.next());
              //colorcount=mycolor;
            } catch (Exception eeew333) {}
            if (flag == true) {
              JOptionPane.showMessageDialog(
                null,
                "Invalid E-mail",
                "User not found!",
                3
              );
            } else {
              g = getGraphics();
              Graphics2D g2 = (Graphics2D) g;
              g2.setStroke(ws);
              for (int i = 0; i < x.length - 1; i++) {
                g2.setColor(c[i]);
                g2.drawArc(100, 100, 400, 400, x[i], (x[i + 1] - x[i]));
              }
              
              System.out.println(cc + " ---- " + mycolor + " ---- " + (cc+mycolor));
              
              Graphics2D lines = (Graphics2D) g;
              
              drawChars(lines);


            }
          } catch (Exception e) {}
        }
      }
    );
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
    setSize(1500, 800);
    setVisible(true);
    addWindowListener(
      new WindowAdapter() {
        public void actionPerformed(ActionEvent tt) {
          dispose();
        }
      }
    );
  }
  
  public void drawChars(Graphics2D lines) {
	  
      int centerX = 300;
      int centerY = 301;
      lines.setColor(Color.black);
      lines.setStroke(new BasicStroke(2));

      for (int i = 0; i < x.length - 1; i++) {
          double radians = Math.toRadians(x[i])-0.018;
          int endX = (int) (centerX + 200 * Math.cos(radians));
          int endY = (int) (centerY - 200 * Math.sin(radians));

          lines.drawLine(centerX, centerY, endX, endY);
          
          Font f = new Font("Times New Roman", Font.BOLD, 15);
          lines.setFont(f);

          // Draw the character at the position
          double angle1 = x[i];
          double angle2 = x[i + 1];

          double radians1 = Math.toRadians(angle1)-0.014;
          double radians2 = Math.toRadians(angle2)-0.016;

          int outermostX = (int) (centerX + 180 * Math.cos(radians1));
          int outermostY = (int) (centerY - 180 * Math.sin(radians1));
          int omchendX = (int) (centerX + 180 * Math.cos(radians2));
          int omchendY = (int) (centerY - 180 * Math.sin(radians2));
          
          int omcharX = (outermostX + omchendX) / 2;
          int omcharY = (outermostY + omchendY) / 2;
          
          lines.drawString(Character.toString(orbit4[i]), omcharX, omcharY);
          
          int outerX = (int) (centerX + 155 * Math.cos(radians1));
          int outerY = (int) (centerY - 155 * Math.sin(radians1));
          int ochendX = (int) (centerX + 155 * Math.cos(radians2));
          int ochendY = (int) (centerY - 155 * Math.sin(radians2));
          
          int ocharX = (outerX + ochendX) / 2;
          int ocharY = (outerY + ochendY) / 2;
          
          lines.drawString(Character.toString(orbit3[i]), ocharX, ocharY);
          
          int innerX = (int) (centerX + 130 * Math.cos(radians1));
          int innerY = (int) (centerY - 130 * Math.sin(radians1));
          int ichendX = (int) (centerX + 130 * Math.cos(radians2));
          int ichendY = (int) (centerY - 130 * Math.sin(radians2));
          
          int icharX = (innerX + ichendX) / 2;
          int icharY = (innerY + ichendY) / 2;
          
          lines.drawString(Character.toString(orbit2[i]), icharX, icharY);
          
          int innermostX = (int) (centerX + 105 * Math.cos(radians1-0.02));
          int innermostY = (int) (centerY - 105 * Math.sin(radians1+0.02));
          int imchendX = (int) (centerX + 105 * Math.cos(radians2+0.02));
          int imchendY = (int) (centerY - 105 * Math.sin(radians2+0.02));
          
          int imcharX = (innermostX + imchendX) / 2;
          int imcharY = (innermostY + imchendY) / 2;
          
          lines.drawString(Character.toString(orbit1[i]), imcharX, imcharY);
      }
	  
  }
  
  public static void shuffleArray(char[] arr) {
      int n = arr.length;
      for (int i = n - 1; i > 0; i--) {
          int j = rand.nextInt(i + 1);
          char temp = arr[i];
          arr[i] = arr[j];
          arr[j] = temp;
      }
  }

  public static void main(String[] args) {
    new form2();
  }
}
