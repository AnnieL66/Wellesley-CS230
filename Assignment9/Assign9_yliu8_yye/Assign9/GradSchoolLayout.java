/**
 * GradSchoolLayout.java
 * Demonstrates the use of a tabbed layout with three tabs to rank Grad Schools 
 * entered by the user: 
 * one with the credits, 
 * one to add schools in the collection to be evaluated (tab "Add School"), 
 * one to rank the schools based on weights provided by the user (tab "Evaluate").
 *
 * @author Vera Ye and Yaxin(Annie) Liu
 * @version Nov 25, 2018
 */

import javax.swing.*;

public class GradSchoolLayout {
   
   public static void main (String[] args) {
      
      JFrame frame = new JFrame ("Grad Schools");
      frame.setDefaultCloseOperation (JFrame.EXIT_ON_CLOSE);
      
      GradSchools myGradSchools = new GradSchools(); 
      
      JTabbedPane tp = new JTabbedPane();
      tp.addTab ("About", new IntroPanel());
      tp.addTab ("Add", new AddSchoolPanel(myGradSchools));
      tp.addTab ("Evaluate", new EvaluatePanel(myGradSchools));

      frame.getContentPane().add(tp);

      frame.pack();
      frame.setVisible(true);
   }
}
