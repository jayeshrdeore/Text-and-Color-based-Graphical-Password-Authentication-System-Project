import java.awt.*;
import java.awt.event.*;
import java.sql.*;
import javax.swing.*;
import javax.swing.border.*;

public class form1 extends JFrame {

  JLabel l1, l2, l3, l4, l5, l6, l7, name;
  JTextField t1, t2;
  JPanel p1;
  JButton b1, b2, b3, b4, b5, b6, b7, b8, b9, b10, b11, b12;
  ResultSet rs;
  boolean flag = true;
  Connection con;
  
  Color selectedColor;
  int selectedColorIndex = 0;
  
  JLabel colorLabel;
  
  Color colorcodes[] = {
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
  
  String colorname[] = {
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

  public form1() {
    Container c1 = getContentPane();
    c1.setLayout(null);

    l6 = new JLabel(new ImageIcon("bg2.jpeg"));
    c1.add(l6);

    JPanel p = new JPanel();
    p.setBorder(new LineBorder(Color.RED, 5, true));
    p.setLayout(null);
    p.setBounds(30, 110, 500, 500);
    p.setBackground(Color.white);
    l6.add(p);
    
    try {
      Class.forName("com.mysql.jdbc.Driver");
      con = DriverManager.getConnection("jdbc:mysql://localhost:3306/Neha", "root", "92410");
           
      PreparedStatement st = con.prepareStatement(
    		  "select * from users",
    		  ResultSet.TYPE_SCROLL_SENSITIVE,
    		  ResultSet.CONCUR_UPDATABLE);
      rs = st.executeQuery();
      
      System.out.println("Database Connection successful!");
    } catch (Exception ee) {
    	
      System.out.println(ee);
      System.out.println("Database Connection Failed!");
    }
    Font f = new Font("Times New Roman", Font.BOLD, 30);

    l1 = new JLabel("Password Registration", JLabel.CENTER);
    l1.setFont(f);

    l2 = new JLabel("Enter Your Password");
    l3 = new JLabel("Select Color ");
    l4 = new JLabel("Selected Color");
    name = new JLabel(colorname[selectedColorIndex]);
    l5 = new JLabel("Email Address");
    l7 = new JLabel(new ImageIcon("icon5.jpeg"));
    t1 = new JPasswordField(20);
    t2 = new JTextField(20);
    
    JPanel panel = new JPanel();
    JComboBox<String> comboBox = new JComboBox<>(colorname);
    comboBox.setRenderer(new ColorComboBoxRenderer(colorcodes,colorname));
    
    comboBox.addActionListener(new ActionListener() {
        @Override
        public void actionPerformed(ActionEvent e) {
            JComboBox<String> combo = (JComboBox<String>) e.getSource();
            selectedColorIndex = combo.getSelectedIndex();
            selectedColor = colorcodes[selectedColorIndex];
            b9.setBackground(selectedColor);
            name.setText(colorname[selectedColorIndex]);
        }
    });

    
    panel.add(comboBox);
    
    b9 = new JButton("");
    b10 = new JButton("Save");
    b10.setBackground(Color.pink);
    b10.setForeground(Color.BLACK);
    b10.addActionListener(
      new ActionListener() {
        public void actionPerformed(ActionEvent tt) {
          try {
            flag = true;
            try {
              rs.first();
              do {
                if (rs.getString("email").equals(t2.getText().trim())) {
                  flag = false;
                  break;
                }
              } while (rs.next());
            } catch (Exception eeew333) {}
            if (flag == true) {
            	String password = t1.getText().trim();
            	String email = t2.getText().trim(); 
            	try {
            	      String q = "insert into users values('"+ password + "', '" + email + "', '" + colorname[selectedColorIndex] +"')";
            	      Statement st = con.createStatement();
            	      st.executeUpdate(q);
            	      rs = st.executeQuery("select * from users");
            	      
            	      System.out.println("Successful!");
            	    } catch (Exception ee) {
            	      System.out.println(ee);
            	      System.out.println("Failed!");
            	    }
              JOptionPane.showMessageDialog(null, "Saved", "Successful!", 3);
            } else {
              JOptionPane.showMessageDialog(null, "Already Exist", "Oops!", 3);
            }
          } catch (Exception ee) {
            System.out.println(ee);
          }
        }
      }
    );

    b11 = new JButton("Clear");
    b11.setBackground(Color.pink);
    b11.setForeground(Color.BLACK);

    b11.addActionListener(
      new ActionListener() {
        public void actionPerformed(ActionEvent tt) {
          t1.setText("");
          t2.setText("");
          b9.setBackground(Color.white);
        }
      }
    );
    b12 = new JButton("Exit");
    b12.setBackground(Color.red);
    b12.setForeground(Color.BLACK);

    b12.addActionListener(    
      new ActionListener() {
        public void actionPerformed(ActionEvent tt) {
          dispose();
        }
      }
    );
    l1.setBounds(30, 50, 600, 35);
    l2.setBounds(40, 140, 150, 30);
    l3.setBounds(40, 190, 150, 30);
    l4.setBounds(40, 220, 100, 30);
    name.setBounds(340, 215, 100, 30);
    l5.setBounds(40, 250, 100, 30);
    l6.setBounds(0, 0, 1500, 800);
    l7.setBounds(600, 30, 700, 700);
    t1.setBounds(300, 140, 130, 30);
    t2.setBounds(300, 250, 130, 30);
    panel.setBounds(300, 180, 120, 30);

    b9.setBounds(300, 220, 30, 20);
    b10.setBounds(35, 440, 100, 30);
    b11.setBounds(180, 440, 100, 30);
    b12.setBounds(420, 450, 60, 30);

    l6.add(l7);
    l6.add(l1);
    p.add(l2);
    p.add(l3);
    p.add(l4);
    p.add(name);
    p.add(l5);
    p.add(t1);
    p.add(t2);
    p.add(panel);

    p.add(b9);
    p.add(b10);
    p.add(b11);
    p.add(b12);
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

  public static void main(String[] args) {
    new form1();
  }
  
  class ColorComboBoxRenderer extends JPanel implements ListCellRenderer<Object> {
	    private Color[] color;
	    private String[] colorNames;
	    private JLabel colorLabel;

	    public ColorComboBoxRenderer(Color[] color, String[] colorNames) {
	        this.color = color;
	        this.colorNames = colorNames;
	        setOpaque(true);
	        setPreferredSize(new Dimension(100, 30));

	        colorLabel = new JLabel();
	        colorLabel.setOpaque(true);
	        colorLabel.setHorizontalAlignment(SwingConstants.LEFT);
	        colorLabel.setVerticalAlignment(SwingConstants.CENTER);
	        add(colorLabel);
	    }

	    public Component getListCellRendererComponent(JList<?> list, Object value, int index,
	                                                  boolean isSelected, boolean cellHasFocus) {
	        if (index >= 0 && index < color.length) {
	            String colorName = colorNames[index];
	            colorLabel.setText(colorName);
	            colorLabel.setBackground(color[index]);
	        }

	        return this;
	    }

	}


}
