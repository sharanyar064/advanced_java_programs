// Q: Develop a Swing program in Java to add the countries USA, India, Vietnam, Canada, Denmark, France, Great Britain, Japan, Africa, Greenland, Singapore into a JList and display the capital of the countries on console whenever the countries are selected on the list.

package others;

import javax.swing.*;
import javax.swing.event.*;
import java.awt.*;
import java.util.HashMap;
import java.util.Map;

public class CountryCapitalListDemo extends JFrame {

    private JList<String> countryList;
    private Map<String, String> capitalMap;

    public CountryCapitalListDemo() {
        super("Country-Capital JList Demo");

        // List of countries
        String[] countries = {
            "USA", "India", "Vietnam", "Canada", "Denmark",
            "France", "Great Britain", "Japan", "Africa",
            "Greenland", "Singapore"
        };

        // Create country-capital mapping
        capitalMap = new HashMap<>();
        capitalMap.put("USA", "Washington, D.C.");
        capitalMap.put("India", "New Delhi");
        capitalMap.put("Vietnam", "Hanoi");
        capitalMap.put("Canada", "Ottawa");
        capitalMap.put("Denmark", "Copenhagen");
        capitalMap.put("France", "Paris");
        capitalMap.put("Great Britain", "London");
        capitalMap.put("Japan", "Tokyo");
        capitalMap.put("Africa", "Varies by country");
        capitalMap.put("Greenland", "Nuuk");
        capitalMap.put("Singapore", "Singapore");

        // Create JList
        countryList = new JList<>(countries);
        countryList.setSelectionMode(ListSelectionModel.MULTIPLE_INTERVAL_SELECTION);
        countryList.setVisibleRowCount(6);
        JScrollPane scrollPane = new JScrollPane(countryList);

        // Add selection listener
        countryList.addListSelectionListener(new ListSelectionListener() {
            @Override
            public void valueChanged(ListSelectionEvent e) {
                if (!e.getValueIsAdjusting()) {
                    java.util.List<String> selectedCountries = countryList.getSelectedValuesList(); // fully qualified
                    for (String country : selectedCountries) {
                        String capital = capitalMap.getOrDefault(country, "Unknown");
                        System.out.println(country + " capital is " + capital);
                    }
                }
            }
        });

        // Add to frame
        add(scrollPane, BorderLayout.CENTER);

        // Frame settings
        setSize(350, 250);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLocationRelativeTo(null); // Center the window
        setVisible(true);
    }

    public static void main(String[] args) {
        new CountryCapitalListDemo();
    }
}
