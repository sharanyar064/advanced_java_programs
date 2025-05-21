// Q: Develop a Swing program in Java to create a Tabbed Pan of RED, BLUE and GREEN and display the concerned color whenever the specific tab is selected in the Pan.

package others;

import javax.swing.*;
import java.awt.*;

public class ColorTabbedPaneDemo extends JFrame {

    public ColorTabbedPaneDemo() {
        super("Color Tabbed Pane Demo");

        // Create the tabbed pane
        JTabbedPane tabbedPane = new JTabbedPane();

        // RED tab
        JPanel redPanel = new JPanel();
        redPanel.setBackground(Color.RED);
        tabbedPane.addTab("RED", redPanel);

        // BLUE tab
        JPanel bluePanel = new JPanel();
        bluePanel.setBackground(Color.BLUE);
        tabbedPane.addTab("BLUE", bluePanel);

        // GREEN tab
        JPanel greenPanel = new JPanel();
        greenPanel.setBackground(Color.GREEN);
        tabbedPane.addTab("GREEN", greenPanel);

        // Add tabbed pane to frame
        add(tabbedPane);

        // Frame settings
        setSize(400, 300);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLocationRelativeTo(null); // Center the window
        setVisible(true);
    }

    public static void main(String[] args) {
        new ColorTabbedPaneDemo();
    }
}
