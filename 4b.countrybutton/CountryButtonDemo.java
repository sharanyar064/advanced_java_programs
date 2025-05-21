// Q: Develop a Swing program in Java to display a message “Srilanka is pressed” or “India is pressed” depending upon the JButton either Srilanka or India is pressed by implementing the event handling mechanism with addActionListener().

package others;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class CountryButtonDemo extends JFrame implements ActionListener {

    private JLabel messageLabel;
    private JButton indiaButton;
    private JButton srilankaButton;

    public CountryButtonDemo() {
        super("Country Button Demo");

        setLayout(new FlowLayout());

        indiaButton = new JButton("India");
        srilankaButton = new JButton("Srilanka");

        indiaButton.addActionListener(this);
        srilankaButton.addActionListener(this);

        messageLabel = new JLabel("Press a button");
        messageLabel.setFont(new Font("Arial", Font.BOLD, 20));

        add(indiaButton);
        add(srilankaButton);
        add(messageLabel);

        setSize(400, 150);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLocationRelativeTo(null);
        setVisible(true);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == indiaButton) {
            messageLabel.setText("India is pressed");
        } else if (e.getSource() == srilankaButton) {
            messageLabel.setText("Srilanka is pressed");
        }
    }

    public static void main(String[] args) {
        new CountryButtonDemo();
    }
}
