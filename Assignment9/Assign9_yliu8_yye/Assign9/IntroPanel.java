/**
 * IntroPanel.java
 * Represents the introduction panel for the GradSchoolLayout program.
 *
 * @author Vera Ye and Yaxin(Annie) Liu
 * @version Nov 25, 2018
 */

import java.awt.*;
import javax.swing.*;

public class IntroPanel extends JPanel {
   
   public IntroPanel() {
      setBackground (Color.green);

      JLabel l1 = new JLabel ("<html>Choose the Grad school that fits you " 
      + "the best.<br/>Designed by Annie and Vera.<br/>------<br/>Select the " 
      + "Schools tab to add Schools. Then select the Evaluate tab to evaluate "
      + "them.<br/>Have fun choosing your Grad Schools :)</html>"); 
      
      System.out.println("Choose the Grad school that fits you " 
      + "the best.\nDesigned by Annie and Vera.\n------\nSelect the " 
      + "Schools tab to add Schools. Then select the Evaluate tab to evaluate "
      + "them.\nHave fun choosing your Grad Schools :)\n"); 
      
      add (l1);
   }
}
