// Q: Develop a Swing program in Java to create a Tabbed Pan of Cyan, Magenta and Yellow and display the concerned color whenever the specific tab is selected in the Pan

package others;

import javax.swing.*;
import java.awt.*;

public class ColorTabbedPane extends JFrame {

    public ColorTabbedPane() {
        super("Color Tabbed Pane");

        // Create TabbedPane
        JTabbedPane tabbedPane = new JTabbedPane();

        // Cyan Panel
        JPanel cyanPanel = new JPanel();
        cyanPanel.setBackground(Color.CYAN);
        tabbedPane.addTab("Cyan", cyanPanel);

        // Magenta Panel
        JPanel magentaPanel = new JPanel();
        magentaPanel.setBackground(Color.MAGENTA);
        tabbedPane.addTab("Magenta", magentaPanel);

        // Yellow Panel
        JPanel yellowPanel = new JPanel();
        yellowPanel.setBackground(Color.YELLOW);
        tabbedPane.addTab("Yellow", yellowPanel);

        // Add to frame
        add(tabbedPane);

        // Frame settings
        setSize(400, 300);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLocationRelativeTo(null); // Center the window
        setVisible(true);
    }

    public static void main(String[] args) {
        new ColorTabbedPane();
    }
}
