// Q: Develop a Swing program in Java to add the countries USA, India, Vietnam, Canada, Denmark, France, Great Britain, Japan, Africa, Greenland, Singapore into a JList and display them on console whenever the countries are selected on the list.

package others;

import javax.swing.*;
import javax.swing.event.*;
import java.awt.*;

public class CountryListDemo extends JFrame {

    private JList<String> countryList;

    public CountryListDemo() {
        super("Country List Demo");

        // Country names
        String[] countries = {
            "USA", "India", "Vietnam", "Canada", "Denmark",
            "France", "Great Britain", "Japan", "Africa",
            "Greenland", "Singapore"
        };

        // Create the JList and allow multiple selection
        countryList = new JList<>(countries);
        countryList.setSelectionMode(ListSelectionModel.MULTIPLE_INTERVAL_SELECTION);
        countryList.setVisibleRowCount(6);
        JScrollPane scrollPane = new JScrollPane(countryList);

        // Add listener to detect selection
        countryList.addListSelectionListener(new ListSelectionListener() {
            @Override
            public void valueChanged(ListSelectionEvent e) {
                if (!e.getValueIsAdjusting()) {
                    java.util.List<String> selected = countryList.getSelectedValuesList();
                    System.out.println("Selected countries:");
                    for (String country : selected) {
                        System.out.println(country);
                    }
                    System.out.println("--------------------");
                }
            }
        });

        // Add components to frame
        add(scrollPane, BorderLayout.CENTER);

        setSize(300, 250);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLocationRelativeTo(null); // Center on screen
        setVisible(true);
    }

    public static void main(String[] args) {
        new CountryListDemo();
    }
}
