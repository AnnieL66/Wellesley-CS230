/**
 * musicWizard.java <br>
 * Demonstrates the use of an interactive music game with an expert system that is
 * built based on the LinkedTernaryTree class. <br>
 *
 * @author Vera Ye, Lizao Wang, Annie Liu
 * @version v2, Dec 15 2018
 */

import javax.swing.*;

public class musicWizard { 
    public static void main (String[] args) {

        JFrame frame = new JFrame ("Music Wizard"); // name of the game
        frame.setDefaultCloseOperation (JFrame.EXIT_ON_CLOSE); 

        musicTernaryTree ternaryTree = new musicTernaryTree();
        musicWizardPanel panel = new musicWizardPanel(ternaryTree);

        frame.getContentPane().add(panel);

        frame.pack();
        frame.setVisible(true);
    }
}