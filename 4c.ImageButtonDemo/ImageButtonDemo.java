// Q: Develop a Swing program in Java to display a message “Digital Clock is pressed” or “Hour Glass is pressed” depending upon the JButton with image either Digital Clock or Hour Glass is pressed by implementing the event handling mechanism with addActionListener().

package others;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class ImageButtonDemo extends JFrame implements ActionListener {

    private JLabel messageLabel;
    private JButton digitalClockButton;
    private JButton hourGlassButton;

    public ImageButtonDemo() {
        super("Image Button Event Demo");

        setLayout(new FlowLayout());

        // Load images
        ImageIcon clockIcon = new ImageIcon("digital_clock.png");
        ImageIcon hourGlassIcon = new ImageIcon("hourglass.png");

        // Create buttons with images
        digitalClockButton = new JButton("Digital Clock", clockIcon);
        hourGlassButton = new JButton("Hour Glass", hourGlassIcon);

        // Add action listeners
        digitalClockButton.addActionListener(this);
        hourGlassButton.addActionListener(this);

        // Label to display message
        messageLabel = new JLabel("Click a button");
        messageLabel.setFont(new Font("Arial", Font.BOLD, 18));

        // Add components
        add(digitalClockButton);
        add(hourGlassButton);
        add(messageLabel);

        // Frame settings
        setSize(500, 200);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLocationRelativeTo(null);
        setVisible(true);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == digitalClockButton) {
            messageLabel.setText("Digital Clock is pressed");
        } else if (e.getSource() == hourGlassButton) {
            messageLabel.setText("Hour Glass is pressed");
        }
    }

    public static void main(String[] args) {
        new ImageButtonDemo();
    }
}
