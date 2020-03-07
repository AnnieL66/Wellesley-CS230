/**
 * musicWizardPanel.java <br>
 * Implements a panel called musicWizardPanel for the musicWizard program.
 * It contains instance data including JButtons, JRadioButtons, ImageIcons, JLabels, 
 * JTextField, JPanels, and AudioClips as GUI interactive components in the program. <br>
 * It represents an expert system that prompts the user to choose answers from an 
 * underlying LinkedTernaryTree and asks him/her to guess about the name of the song 
 * while having the choice to play/stop that piece of music. No matter the user make
 * the right guess or not, eventually after three rounds of guessing, the result song 
 * will be revealed. <br>
 *
 * @author Vera Ye, Yaxin Liu, Lizao Wang
 * @version v7, Dec 15 2018
 */

import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import java.awt.image.BufferedImage;
import javax.imageio.ImageIO;
import java.applet.AudioClip;
import java.net.URL;

import javafoundations.*;
import java.util.*;

public class musicWizardPanel extends JPanel {
    private JButton playGame, quitButton, playMusicButton, checkAnswerButton, 
    stopMusicButton;
    private JRadioButton buttonA, buttonB, buttonC;
    private ImageIcon landingImage, finalImage;
    private JLabel landingImageLabel, questionLabel, guessLabel, finalImageLabel;
    private JPanel questionPanel, eastPanel, westPanel, guessPanel, controlPanel;
    private JTextField userInput;
    private AudioClip[] music;
    private AudioClip current;

    private musicTernaryTree ternaryTree;
    private LinkedTernaryTree musicTree;
    private String songName, text;
    private int songIndex = -1;
    private usersGuess input, song;
    private encryptedNamesQueue encryption;
    private ArrayQueue<String> hintQueue;
    private int checkAnswerCount = 0;

    private URL url1, url2, url3, url4, url5, url6, url7, url8, url9, url10, 
    url11, url12, url13, url14, url15, url16, url17, url18;

    /**
     * Constructor for objects of class musicWizardPanel
     */ 
    public musicWizardPanel(musicTernaryTree myTernaryTree) {
        this.ternaryTree = myTernaryTree;
        this.musicTree = ternaryTree.getMusicTree();

        // default layout, color, and dimension
        setLayout (new BorderLayout());
        setBackground (new Color (38, 38, 38));
        setPreferredSize (new Dimension (1000, 550));

        // landingPage
        playGame = new JButton ("Play Game");
        playGame.setFont (new Font ("Britannic Bold", Font.BOLD, 25));
        playGame.setBackground (new Color (197, 24, 104));
        playGame.setOpaque (true);
        playGame.setBorderPainted (false);
        playGame.setForeground (new Color (240, 185, 224));

        landingImage = new ImageIcon ("Music Wizard.png");
        landingImageLabel = new JLabel (landingImage);

        eastPanel = new JPanel();
        eastPanel.setBackground(new Color (38, 38, 38));
        westPanel = new JPanel();
        westPanel.setBackground(new Color (38, 38, 38));

        add (landingImageLabel, BorderLayout.CENTER);
        add (playGame, BorderLayout.SOUTH);
        add (eastPanel, BorderLayout.EAST);
        add (westPanel, BorderLayout.WEST);
        
        // create a new listener
        playGame.addActionListener (new ButtonListenerOne());
    }

    private class ButtonListenerOne implements ActionListener {
        //--------------------------------------------------------------
        //  initial questionPage
        //--------------------------------------------------------------
        public void actionPerformed (ActionEvent event) {
            if (event.getSource() == playGame) {
                // switch from landing page to the initial question page
                playGame.setEnabled(false);
                playGame.setVisible(false);
                landingImageLabel.setVisible(false);

                // initial question page
                quitButton = new JButton ("Quit");
                quitButton.setFont (new Font ("Britannic Bold", Font.BOLD, 25));
                quitButton.addActionListener (new ButtonListenerTwo());
                quitButton.setBackground (new Color (197, 24, 104));
                quitButton.setOpaque (true);
                quitButton.setBorderPainted (false);
                quitButton.setForeground (new Color (240, 185, 224));

                //// questionLabel
                questionLabel = new JLabel (musicTree.getRootElement().toString());
                questionLabel.setAlignmentX (Component.CENTER_ALIGNMENT);
                questionLabel.setFont (new Font ("Britannic Bold", Font.BOLD, 35));
                questionLabel.setForeground (new Color (197, 24, 104));

                //// radioButtonA
                buttonA = new JRadioButton ("A: " + musicTree.getChoiceA());
                buttonA.setFont (new Font ("Britannic Bold", Font.BOLD, 25));
                buttonA.setBackground (new Color (38, 38, 38));
                buttonA.setForeground (new Color (197, 24, 104));
                buttonA.setOpaque (true);
                buttonA.setBorderPainted (false);
                buttonA.setAlignmentX (Component.CENTER_ALIGNMENT);

                //// radioButtonB
                buttonB = new JRadioButton ("B: " + musicTree.getChoiceB());
                buttonB.setFont (new Font ("Britannic Bold", Font.BOLD, 25));
                buttonB.setBackground (new Color (38, 38, 38));
                buttonB.setForeground (new Color (197, 24, 104));
                buttonB.setOpaque (true);
                buttonB.setBorderPainted (false);
                buttonB.setAlignmentX (Component.CENTER_ALIGNMENT);

                //// radioButtonC
                buttonC = new JRadioButton ("C: " + musicTree.getChoiceC());
                buttonC.setFont (new Font ("Britannic Bold", Font.BOLD, 25));
                buttonC.setBackground (new Color (38, 38, 38));
                buttonC.setForeground (new Color (197, 24, 104));
                buttonC.setOpaque (true);
                buttonC.setBorderPainted (false);
                buttonC.setAlignmentX (Component.CENTER_ALIGNMENT);

                //// questionPanel
                questionPanel = new JPanel();
                questionPanel.setBackground (new Color (38, 38, 38));
                BoxLayout layout = new BoxLayout (questionPanel, BoxLayout.Y_AXIS);
                questionPanel.setLayout (layout);
                questionPanel.add (Box.createRigidArea (new Dimension (60, 100)));
                questionPanel.add (questionLabel);
                questionPanel.add (Box.createRigidArea (new Dimension (0, 70)));
                questionPanel.add (buttonA);
                questionPanel.add (Box.createRigidArea (new Dimension (0, 20)));
                questionPanel.add (buttonB);
                questionPanel.add (Box.createRigidArea (new Dimension (0, 20)));
                questionPanel.add (buttonC);
                questionPanel.setAlignmentX (Component.CENTER_ALIGNMENT);

                // create a new listener
                ButtonListenerTwo listener = new ButtonListenerTwo();

                quitButton.addActionListener (listener);
                buttonA.addActionListener (listener);
                buttonB.addActionListener (listener);
                buttonC.addActionListener (listener);

                add (quitButton, BorderLayout.NORTH);
                add (questionPanel, BorderLayout.CENTER);
            }
        }
    }

    private class ButtonListenerTwo implements ActionListener {
        //--------------------------------------------------------------
        //  the following questionPages and initial guessingPage
        //--------------------------------------------------------------
        public void actionPerformed (ActionEvent event) {
            Object source = event.getSource();

            if (source == quitButton) {
                current = null;
                System.exit(0); // exit the program when clicked
            }
            
            // based on the button that user clicked,
            // enter into the chosen path and perform corresponding actions 
            if (source == buttonA) {
                musicTree = musicTree.getLeft();
                questionLabel.setText(musicTree.getRootElement().toString());
                questionLabel.setHorizontalAlignment (JLabel.CENTER);
                buttonA.setText("A: " + musicTree.getChoiceA().toString());
                buttonB.setText("B: " + musicTree.getChoiceB().toString());
                buttonC.setText("C: " + musicTree.getChoiceC().toString());
                buttonA.setSelected(false);
                buttonA.setAlignmentX (Component.CENTER_ALIGNMENT);
                buttonB.setAlignmentX (Component.CENTER_ALIGNMENT);
                buttonC.setAlignmentX (Component.CENTER_ALIGNMENT);
            } else if (source == buttonB) {
                musicTree = musicTree.getMiddle();
                questionLabel.setText(musicTree.getRootElement().toString());
                questionLabel.setHorizontalAlignment (JLabel.CENTER);
                buttonA.setText("A: " + musicTree.getChoiceA().toString());
                buttonB.setText("B: " + musicTree.getChoiceB().toString());
                buttonC.setText("C: " + musicTree.getChoiceC().toString());
                buttonB.setSelected(false);
                buttonA.setAlignmentX (Component.CENTER_ALIGNMENT);
                buttonB.setAlignmentX (Component.CENTER_ALIGNMENT);
                buttonC.setAlignmentX (Component.CENTER_ALIGNMENT);
            } else {
                musicTree = musicTree.getRight();
                questionLabel.setText(musicTree.getRootElement().toString());
                questionLabel.setHorizontalAlignment (JLabel.CENTER);
                buttonA.setText("A: " + musicTree.getChoiceA().toString());
                buttonB.setText("B: " + musicTree.getChoiceB().toString());
                buttonC.setText("C: " + musicTree.getChoiceC().toString());
                buttonC.setSelected(false);
                buttonA.setAlignmentX (Component.CENTER_ALIGNMENT);
                buttonB.setAlignmentX (Component.CENTER_ALIGNMENT);
                buttonC.setAlignmentX (Component.CENTER_ALIGNMENT);
            }
            
            // when the user has reached the leaf node of the tree
            if (musicTree.size() == 1) {
                // get a randomly generated song based on user's path in musicTree
                songNamesVector songs = new songNamesVector();
                String arrayIndex = musicTree.getRootElement().toString();
                songName = songs.getOneSong(arrayIndex);
                
                // set BoxLayout
                BoxLayout layout = new BoxLayout (questionPanel, BoxLayout.Y_AXIS);
                questionLabel.setText("Ha! The wizard will not reveal " 
                    + "your favorite song that easily!");
                questionLabel.setFont (new Font ("Britannic Bold", Font.BOLD, 28));
                questionLabel.setAlignmentX (Component.CENTER_ALIGNMENT);
                questionPanel.add(questionLabel);
                
                // set buttonA, buttonB, buttonC to invisible and 'disable' them
                buttonA.setEnabled(false);
                buttonA.setVisible(false);
                buttonB.setEnabled(false);
                buttonB.setVisible(false);
                buttonC.setEnabled(false);
                buttonC.setVisible(false);

                // create guessing instruction label
                guessLabel = new JLabel("Take a guess of the song's name: ");
                guessLabel.setFont (new Font ("Britannic Bold", Font.BOLD, 28));
                guessLabel.setForeground (new Color (197, 24, 104));

                // create userInput text field
                userInput = new JTextField(20);
                userInput.addActionListener (new ButtonListenerThree());

                // create a new panel to contain guessLabel and userInput
                guessPanel = new JPanel();
                guessPanel.setBackground (new Color (38, 38, 38));

                guessPanel.add (guessLabel);
                guessPanel.add (userInput);

                // create three new JButtons: 'Play', 'Check Answer', 'Stop'
                playMusicButton = new JButton ("Play");
                playMusicButton.setFont (new Font ("Britannic Bold", Font.BOLD, 25));
                playMusicButton.setBackground (new Color (197, 24, 104));
                playMusicButton.setOpaque (true);
                playMusicButton.setBorderPainted (false);
                playMusicButton.setForeground (new Color (240, 185, 224));

                checkAnswerButton = new JButton ("Check Answer");
                checkAnswerButton.setFont (new Font ("Britannic Bold", Font.BOLD, 25));
                checkAnswerButton.setBackground (new Color (197, 24, 104));
                checkAnswerButton.setOpaque (true);
                checkAnswerButton.setBorderPainted (false);
                checkAnswerButton.setForeground (new Color (240, 185, 224));

                stopMusicButton = new JButton ("Stop");
                stopMusicButton.setFont (new Font ("Britannic Bold", Font.BOLD, 25));
                stopMusicButton.setBackground (new Color (197, 24, 104));
                stopMusicButton.setOpaque (true);
                stopMusicButton.setBorderPainted (false);
                stopMusicButton.setForeground (new Color (240, 185, 224));

                // add the three buttons to control panel
                controlPanel = new JPanel();
                controlPanel.setBackground (new Color (38, 38, 38));
                controlPanel.setLayout (new BoxLayout (controlPanel, BoxLayout.X_AXIS));
                controlPanel.setBorder(BorderFactory.createEmptyBorder (40, 0, 0, 0));

                controlPanel.add (playMusicButton);
                controlPanel.add (Box.createRigidArea (new Dimension (40, 0)));
                controlPanel.add (checkAnswerButton);
                controlPanel.add (Box.createRigidArea (new Dimension (40, 0)));
                controlPanel.add (stopMusicButton);

                // add control panel to guess panel
                guessPanel.add (controlPanel);

                // add the small panel to the larger questionPanel
                questionPanel.add (guessPanel);

                // import and set up music url files
                url1 = url2 = url3 = url4 = url5 = url6 = url7 = url8 = url9 = url10 = 
                url11 = url12 = url13 = url14 = url15= url16 = url17 = url18 = null;

                try {
                    url1 = new URL ("file", "localhost", "californiadreaming.wav");
                    url2 = new URL ("file", "localhost", "notgoinganywhere.wav");
                    url3 = new URL ("file", "localhost", "crazy.wav");
                    url4 = new URL ("file", "localhost", "despacito.wav");
                    url5 = new URL ("file", "localhost", "doneforme.wav");
                    url6 = new URL ("file", "localhost", "takitaki.wav");
                    url7 = new URL ("file", "localhost", "girlfromipanema.wav");
                    url8 = new URL ("file", "localhost", "highbythebeach.wav");
                    url9 = new URL ("file", "localhost", "ificouldpray.wav");
                    url10 = new URL ("file", "localhost", "ilikeit.wav");
                    url11 = new URL ("file", "localhost", "jolene.wav");
                    url12 = new URL ("file", "localhost", "leftrightleft.wav");
                    url13 = new URL ("file", "localhost", "loststars.wav");
                    url14 = new URL ("file", "localhost", "loveyourself.wav");
                    url15 = new URL ("file", "localhost", "lullabylove.wav");
                    url16 = new URL ("file", "localhost", "strawberriesandcigarettes.wav");
                    url17 = new URL ("file", "localhost", "maskoff.wav");
                    url18 = new URL ("file", "localhost", "mylove.wav");
                }
                catch (Exception exception) {}

                music = new AudioClip[18];
                music[0] = JApplet.newAudioClip (url1);
                music[1] = JApplet.newAudioClip (url2);
                music[2] = JApplet.newAudioClip (url3);
                music[3] = JApplet.newAudioClip (url4);
                music[4] = JApplet.newAudioClip (url5);
                music[5] = JApplet.newAudioClip (url6);
                music[6] = JApplet.newAudioClip (url7);
                music[7] = JApplet.newAudioClip (url8);
                music[8] = JApplet.newAudioClip (url9);
                music[9] = JApplet.newAudioClip (url10);
                music[10] = JApplet.newAudioClip (url11);
                music[11] = JApplet.newAudioClip (url12);
                music[12] = JApplet.newAudioClip (url13);
                music[13] = JApplet.newAudioClip (url14);
                music[14] = JApplet.newAudioClip (url15);
                music[15] = JApplet.newAudioClip (url16);
                music[16] = JApplet.newAudioClip (url17);
                music[17] = JApplet.newAudioClip (url18);

                String[] songNames = {"californiadreaming","notgoinganywhere", "crazy",
                        "despacito", "doneforme", "takitaki", "girlfromipanema", 
                        "highbythebeach",  "ificouldpray", "ilikeit", "jolene", 
                        "leftrightleft", "loststars",  "loveyourself", "lullabylove", 
                        "strawberriesandcigarettes",  "maskoff", "mylove"};

                // find the songIndex in songNames array that matches the 
                // randomly generated song
                for (int i = 0; i < songNames.length; i++) {
                    if (songNames[i].equals(songName)) {
                        songIndex = i;
                        break;
                    }
                }
                
                playMusicButton.addActionListener (new ButtonListenerThree());
                checkAnswerButton.addActionListener (new ButtonListenerThree());
                stopMusicButton.addActionListener (new ButtonListenerThree());
            }
        }
    }

    private class ButtonListenerThree implements ActionListener {
        //--------------------------------------------------------------
        //  the following guessingPages and finalPage
        //--------------------------------------------------------------
        public void actionPerformed (ActionEvent event) {
            Object source = event.getSource();

            // if user presses 'Play' button, play the music
            if (source == playMusicButton) {
                current = music[songIndex];
                current.play();
            }

            // if user presses 'Stop' button, stop the music
            if (source == stopMusicButton) {
                current.stop();
            }

            // get user's input and compare it with the generated songName
            text = userInput.getText().toLowerCase().replaceAll(" ", "");;
            System.out.println(text);
            input = new usersGuess(text);
            song = new usersGuess(songName);

            // if user clicks 'Check Answer' button, compare it with songName string
            if (source == checkAnswerButton) {
                if ((input.compareTo(song)) != 0 && checkAnswerCount == 0) {
                    questionLabel.setText("<html><center>Oops! You didn't guess it right." +
                        " Let the wizard give you a hint.</center></html>");
                    questionLabel.setAlignmentX (Component.CENTER_ALIGNMENT);
                    encryption = new encryptedNamesQueue(songName);
                    hintQueue = encryption.buildArray();
                    guessLabel.setText("Encrypted title: \"" + hintQueue.dequeue() 
                    + "\"");

                    checkAnswerButton.removeActionListener (new ButtonListenerThree());
                    // increment count
                    checkAnswerCount++;
                } else if ((input.compareTo(song)) != 0 && checkAnswerCount == 1) {
                    questionLabel.setText("<html><center>Oh no! This is your last "
                        + "chance to guess, and here's another hint.</center></html>");
                    questionLabel.setAlignmentX (Component.CENTER_ALIGNMENT);
                    guessLabel.setText("Backward title: \"" + hintQueue.dequeue() + "\"");

                    checkAnswerButton.removeActionListener (new ButtonListenerThree());
                    // increment count
                    checkAnswerCount++; 
                } else { 
                    // either the user has made two wrong guess or immediately makes 
                    // the right guess, the program will directly jump to finalPage
                    questionLabel.setEnabled(false);
                    questionLabel.setVisible(false);
                    guessLabel.setEnabled(false);
                    guessLabel.setVisible(false);
                    userInput.setEnabled(false);
                    userInput.setVisible(false);
                    checkAnswerButton.setEnabled(false);
                    checkAnswerButton.setVisible(false);

                    // display final image
                    finalImage = new ImageIcon (songName + ".png");
                    Image img = finalImage.getImage();
                    Image newimg = img.getScaledInstance(1000, 151, 
                                                        java.awt.Image.SCALE_SMOOTH);
                    finalImage = new ImageIcon(newimg);
                    finalImageLabel = new JLabel (finalImage);
                    finalImageLabel.setBorder(BorderFactory.createEmptyBorder 
                                                        (150, 0, 0, 0));
                    controlPanel.add (Box.createRigidArea (new Dimension (80, 0)));

                    // remove previous button layout
                    controlPanel.remove (playMusicButton);
                    controlPanel.remove (Box.createRigidArea (new Dimension (40, 0)));
                    controlPanel.remove (stopMusicButton);
                    controlPanel.remove (Box.createRigidArea (new Dimension (40, 0)));

                    // add new layout to the buttons
                    controlPanel.add (Box.createRigidArea (new Dimension (30, 0)));
                    controlPanel.add (playMusicButton);
                    controlPanel.add (Box.createRigidArea (new Dimension (150, 0)));
                    controlPanel.add (stopMusicButton);
                    controlPanel.add (Box.createRigidArea (new Dimension (150, 0)));
                    controlPanel.add (quitButton);
                    controlPanel.setBorder(BorderFactory.createEmptyBorder 
                                                        (0, 0, 100, 0));

                    guessPanel.remove (controlPanel);
                    guessPanel.add (finalImageLabel);

                    add (guessPanel, BorderLayout.NORTH);
                    add (controlPanel,BorderLayout.SOUTH);
                }
            }
        }
    }
}
