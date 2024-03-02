import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Random;

public class ColorCircleGUI extends JFrame implements ActionListener {
    private static final String[] COLORS = {
            "Red", "Blue", "Green", "Yellow", "Orange", "Purple", "Pink", "Brown", "Gray", "Black",
            "White", "Cyan", "Magenta", "Teal", "Indigo", "Turquoise", "Gold", "Silver", "Maroon",
            "Olive", "Coral", "Lavender", "Chartreuse"
    };

    private static final char[][] CHARACTER_ARRAYS = {
            {'a', 'b', 'c', 'd', 'e', 'f', 'g', 'h', 'i', 'j', 'k', 'l', 'm', 'n', 'o', 'p', 'q', 'r', 's', 't', 'u', 'v', 'w'},
            {'1', '2', '3', '4', '5', '6', '7', '8', '9', '0', '!', '@', '#', '$', '%', '^', '&', '*', '(', ')', '-', '_'},
            {'A', 'B', 'C', 'D', 'E', 'F', 'G', 'H', 'I', 'J', 'K', 'L', 'M', 'N', 'O', 'P', 'Q', 'R', 'S', 'T', 'U', 'V', 'W'},
            {'x', 'y', 'z', 'X', 'Y', 'Z', '[', ']', '{', '}', '|', '<', '>', '.', ',', '?', '/', '\\', ':', ';', '+', '='}
    };

    private static final int CIRCLE_RADIUS = 370;
    private static final int INNERMOST_CIRCLE_RADIUS = 250;
    private static final int INNER_CIRCLE_RADIUS = 280;
    private static final int OUTER_CIRCLE_RADIUS = 310;
    private static final int OUTERMOST_CIRCLE_RADIUS = 340;

    private JPanel mainPanel;
    private JTextField textBox;
    private JButton submitButton;
    private JButton clockwiseButton;
    private JButton anticlockwiseButton;
    private JButton outermostButton;
    private JButton outerButton;
    private JButton innerButton;
    private JButton innermostButton;
    private Color currentColor;

    public ColorCircleGUI() {
        setTitle("Color Circle");
        setSize(800, 600);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLocationRelativeTo(null);

        mainPanel = new JPanel() {
            @Override
            protected void paintComponent(Graphics g) {
                super.paintComponent(g);
                int centerX = getWidth() / 2;
                int centerY = getHeight() / 2;

                // Draw main circle
                g.setColor(Color.BLACK);
                g.drawOval(centerX - CIRCLE_RADIUS, centerY - CIRCLE_RADIUS, CIRCLE_RADIUS * 2, CIRCLE_RADIUS * 2);

                // Draw color spokes
                double angle = 2 * Math.PI / COLORS.length;
                for (int i = 0; i < COLORS.length; i++) {
                    double x = centerX + CIRCLE_RADIUS * Math.cos(i * angle);
                    double y = centerY + CIRCLE_RADIUS * Math.sin(i * angle);

                    g.setColor(getColorFromString(COLORS[i]));
                    g.drawLine(centerX, centerY, (int) x, (int) y);
                }

                // Draw comment character circles
                drawCharacterCircle(g, centerX, centerY, INNERMOST_CIRCLE_RADIUS, CHARACTER_ARRAYS[0]);
                drawCharacterCircle(g, centerX, centerY, INNER_CIRCLE_RADIUS, CHARACTER_ARRAYS[1]);
                drawCharacterCircle(g, centerX, centerY, OUTER_CIRCLE_RADIUS, CHARACTER_ARRAYS[2]);
                drawCharacterCircle(g, centerX, centerY, OUTERMOST_CIRCLE_RADIUS, CHARACTER_ARRAYS[3]);
            }

            private void drawCharacterCircle(Graphics g, int centerX, int centerY, int radius, char[] characters) {
                double angle = 2 * Math.PI / characters.length;
                for (int i = 0; i < characters.length; i++) {
                    double x = centerX + radius * Math.cos(i * angle);
                    double y = centerY + radius * Math.sin(i * angle);

                    g.setColor(Color.LIGHT_GRAY);
                    g.fillOval((int) x - 10, (int) y - 10, 20, 20);

                    g.setColor(Color.BLACK);
                    g.drawString(String.valueOf(characters[i]), (int) x - 4, (int) y + 5);
                }
            }
        };

        clockwiseButton = new JButton();
        clockwiseButton.setIcon(new ImageIcon("clockwise_icon.png"));
        clockwiseButton.addActionListener(this);

        anticlockwiseButton = new JButton();
        anticlockwiseButton.setIcon(new ImageIcon("anticlockwise_icon.png"));
        anticlockwiseButton.addActionListener(this);

        outermostButton = new JButton("Outermost");
        outermostButton.addActionListener(this);

        outerButton = new JButton("Outer");
        outerButton.addActionListener(this);

        innerButton = new JButton("Inner");
        innerButton.addActionListener(this);

        innermostButton = new JButton("Innermost");
        innermostButton.addActionListener(this);

        textBox = new JTextField();
        textBox.setEditable(false);

        submitButton = new JButton("Submit");
        submitButton.addActionListener(this);

        JPanel controlPanel = new JPanel(new GridLayout(8, 1));
        controlPanel.add(clockwiseButton);
        controlPanel.add(anticlockwiseButton);
        controlPanel.add(outermostButton);
        controlPanel.add(outerButton);
        controlPanel.add(innerButton);
        controlPanel.add(innermostButton);
        controlPanel.add(textBox);
        controlPanel.add(submitButton);

        setLayout(new BorderLayout());
        add(mainPanel, BorderLayout.CENTER);
        add(controlPanel, BorderLayout.EAST);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == clockwiseButton) {
            rotateCircle(true);
        } else if (e.getSource() == anticlockwiseButton) {
            rotateCircle(false);
        } else if (e.getSource() == outermostButton) {
            setTextFromCharacterArray(CHARACTER_ARRAYS[3]);
        } else if (e.getSource() == outerButton) {
            setTextFromCharacterArray(CHARACTER_ARRAYS[2]);
        } else if (e.getSource() == innerButton) {
            setTextFromCharacterArray(CHARACTER_ARRAYS[1]);
        } else if (e.getSource() == innermostButton) {
            setTextFromCharacterArray(CHARACTER_ARRAYS[0]);
        } else if (e.getSource() == submitButton) {
            // Submit button action
        }
    }

    private void rotateCircle(boolean clockwise) {
        // Rotate the circle
        // Adjust the angle and redraw the main panel
        mainPanel.repaint();
    }

    private void setTextFromCharacterArray(char[] characters) {
        // Set text in the text box based on the selected character array
        // Use the current color variable
        // Update the text box
    }

    private Color getColorFromString(String colorName) {
        try {
            return (Color) Color.class.getField(colorName.toUpperCase()).get(null);
        } catch (Exception e) {
            return Color.BLACK;
        }
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> {
            ColorCircleGUI gui = new ColorCircleGUI();
            gui.setVisible(true);
        });
    }
}
