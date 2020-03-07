/**
 * AddSchoolPanel.java
 * Represents a panel for the user to enter a school and select three numbers 
 * from pull-down menus that correspond to the perceived rates of the school 
 * in these three areas.
 * When the user clicks the "Add School" button, the information is entered 
 * and a message appears at the bottom panel announcing what the program read.
 *
 * @author Vera Ye and Yaxin(Annie) Liu
 * @version Nov 25, 2018
 */

import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

public class AddSchoolPanel extends JPanel {
    
    private JLabel inputLabel, academics, research, pubs, defaultInfo;
    private JTextArea info;
    private JPanel infoPanel, schoolPanel, resultPanel;
    private JTextField school;
    private JButton addSchool;
    private JComboBox selection1, selection2, selection3;
    
    private GradSchools gradSchools;
    
    public AddSchoolPanel(GradSchools myGradSchools) {
        
        this.gradSchools = myGradSchools;
        setLayout (new BorderLayout());
      
        // upper section
        info = new JTextArea ("Fill in the information to add a school, "
                            + "then click \"Add School\".");
        System.out.println("Fill in the information to add a school, "
                            + "then click \"Add School\".");
        info.setBackground(Color.cyan);
      
        infoPanel = new JPanel();
        infoPanel.setPreferredSize (new Dimension(200, 40));
        infoPanel.setBackground (Color.cyan);
        infoPanel.add(info);
      
        // middle section
        inputLabel = new JLabel ("School:");
        school = new JTextField (15);
        String[] rating = {"...", "1", "2", "3", "4", "5"};
        academics = new JLabel ("Academics:");
        selection1 = new JComboBox (rating);
        research = new JLabel ("Research:");
        selection2 = new JComboBox (rating);
        pubs = new JLabel ("Pubs:");
        selection3 = new JComboBox (rating);
        addSchool = new JButton("Add School");
        addSchool.addActionListener (new ButtonListener());
      
        schoolPanel = new JPanel();
        schoolPanel.setPreferredSize (new Dimension(200, 10));
        schoolPanel.setBackground (Color.green);
        schoolPanel.setBorder(BorderFactory.createMatteBorder
                                (10, 0, 10, 0, Color.yellow));
      
        schoolPanel.add (inputLabel);
        schoolPanel.add (school);
        schoolPanel.add (academics);
        schoolPanel.add (selection1);
        schoolPanel.add (research);
        schoolPanel.add (selection2);
        schoolPanel.add (pubs);
        schoolPanel.add (selection3);
        schoolPanel.add (addSchool);
      
        // lower section
        defaultInfo = new JLabel ("Information on the new school will appear here.");
      
        resultPanel = new JPanel();
        resultPanel.setPreferredSize (new Dimension(200, 100));
        resultPanel.setBackground (Color.white);
      
        resultPanel.add (defaultInfo);
      
        // general layout and setting
        add (infoPanel, BorderLayout.NORTH);
        add (schoolPanel, BorderLayout.CENTER);
        add (resultPanel, BorderLayout.SOUTH);
        setBackground (Color.yellow);
        setPreferredSize (new Dimension(200, 180));
    }
    
    private class ButtonListener implements ActionListener {
        /**
         * The user could click on the tab to Add Schools by entering the 
         * name of a school and select three numbers from pull-down menus that 
         * correspond to the perceived rates of the school in these three areas.
         * When the user clicks the "Add School" button, the information is 
         * entered and a message appears at the bottom panel announcing what 
         * the program read.
         * 
         * @param ActionEvent event is the event which causes an action 
         * to be performed
         */
        public void actionPerformed (ActionEvent event) {
            String schoolName = school.getText();
            int academics = selection1.getSelectedIndex();
            int research = selection2.getSelectedIndex();
            int publications = selection3.getSelectedIndex();
          
            if (event.getSource() == addSchool) {
                if (schoolName == null || academics == 0 || 
                    research == 0 || publications == 0) {
                    defaultInfo.setText("You have not provide all the data"
                    +" needed to Add a School. Please double check your input.");
                    System.out.println("You have not provide all the data"
                    +" needed to Add a School. Please double check your input.");
                } else {
                    gradSchools.addSchool(schoolName, academics, 
                                          research, publications);
                    defaultInfo.setText(gradSchools.toString());
                    System.out.println("School: " + schoolName + " Academics: " 
                    + academics + " Research: " + research + " Publications: "
                    + publications + " Overall: 0" + " Current rank: 0");
                }
            } 
        }
    }
}
