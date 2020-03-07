/**
 * EvaluatePanel.java
 * Represents a panel for the user to evaluate the schools in the overall 
 * category based on the GradSchools implementation.
 *
 * @author Vera Ye and Yaxin(Annie) Liu
 * @version Nov 25, 2018
 */

import java.awt.*;
import javax.swing.*;
import javax.swing.event.*;

public class EvaluatePanel extends JPanel {
   
   private JPanel controlPanel, infoPanel;
   private JSlider aSlider, rSlider, pSlider;
   private JLabel aLabel, rLabel, pLabel;
   private JLabel defaultInfo;
   
   private GradSchools gradSchools;

   public EvaluatePanel(GradSchools myGradSchools) {
      
      this.gradSchools = myGradSchools;
      setLayout (new BorderLayout());
      
      // slider section
      aSlider = new JSlider (JSlider.HORIZONTAL, 0, 5, 0);
      aSlider.setMajorTickSpacing (5);
      aSlider.setMinorTickSpacing (1);
      aSlider.setPaintTicks (true);
      aSlider.setPaintLabels (true);
      aSlider.setAlignmentX (Component.LEFT_ALIGNMENT);

      rSlider = new JSlider (JSlider.HORIZONTAL, 0, 5, 0);
      rSlider.setMajorTickSpacing (5);
      rSlider.setMinorTickSpacing (1);
      rSlider.setPaintTicks (true);
      rSlider.setPaintLabels (true);
      rSlider.setAlignmentX (Component.LEFT_ALIGNMENT);

      pSlider = new JSlider (JSlider.HORIZONTAL, 0, 5, 0);
      pSlider.setMajorTickSpacing (5);
      pSlider.setMinorTickSpacing (1);
      pSlider.setPaintTicks (true);
      pSlider.setPaintLabels (true);
      pSlider.setAlignmentX (Component.LEFT_ALIGNMENT);

      SliderListener listener = new SliderListener();
      aSlider.addChangeListener (listener);
      rSlider.addChangeListener (listener);
      pSlider.addChangeListener (listener);

      aLabel = new JLabel ("Academics: 0");
      aLabel.setAlignmentX (Component.LEFT_ALIGNMENT);
      rLabel = new JLabel ("Research: 0");
      rLabel.setAlignmentX (Component.LEFT_ALIGNMENT);
      pLabel = new JLabel ("Publications: 0");
      pLabel.setAlignmentX (Component.LEFT_ALIGNMENT);

      controlPanel = new JPanel();
      BoxLayout layout = new BoxLayout (controlPanel, BoxLayout.X_AXIS);
      controlPanel.setLayout (layout);
      controlPanel.add (aLabel);
      controlPanel.add (aSlider);
      controlPanel.add (Box.createRigidArea (new Dimension (0, 20)));
      controlPanel.add (rLabel);
      controlPanel.add (rSlider);
      controlPanel.add (Box.createRigidArea (new Dimension (0, 20)));
      controlPanel.add (pLabel);
      controlPanel.add (pSlider);
      
      // information section
      defaultInfo = new JLabel ("<html><br/>Use the sliders to assign weights in each" 
                              + " category. You will then see the top school.</html>");
      System.out.println("Use the sliders to assign weights in each category."
                              + " You will then see the top school.");
      infoPanel = new JPanel();
      infoPanel.add (defaultInfo);
      
      // general layout
      add (controlPanel, BorderLayout.NORTH);
      add (infoPanel, BorderLayout.CENTER);
   }

   private class SliderListener implements ChangeListener {
      private int academics, research, publications;
      /**
       * When the user is done entering (some of) the schools, the user could
       * move on to the second tab to evaluate the schools in the overall 
       * category.
       * @param ChangeEvent event is the event which causes a change 
       * to be performed
       */
      public void stateChanged (ChangeEvent event) {
         academics = aSlider.getValue();
         research = rSlider.getValue();
         publications = pSlider.getValue();

         aLabel.setText ("Academics: " + academics);
         rLabel.setText ("Research: " + research);
         pLabel.setText ("Publications: " + publications);
         
         gradSchools.computeRatings(academics, research, publications);
         gradSchools.rankSchools("Overall");
         
         defaultInfo.setText(gradSchools.getTop().toString());
         System.out.println(gradSchools.getTop().toString());
      }
   }
}
