/**
 * musicTernaryTree.java <br>
 * Implements a class called musicTernaryTree that uses a LinkedTernaryTree to represent
 * the questions and choices used in the program.
 *
 * @author Yaxin Liu
 * @version v4, Dec 15 2018
 */

import javafoundations.*; // for the LinkedTernaryTree and all

public class musicTernaryTree {
    private LinkedTernaryTree<String> musicTree;

    /**
     * Constructor for class musicTernaryTree
     */
    public musicTernaryTree(){
        // Questions
        String e1 = "<html><center>If you were to be put up for adoption, " + 
            "which parent would you choose?</center></html>";
        String e2 = "<html><center>What kind of weather do you enjoy " + 
            "more?</center></html>";
        String e3 = "<html><center>Do you consider yourself an older soul " + 
            "among your peers?</center></html>";
        String e4 = "<html><center>Which option describes your best friend " + 
            "the best?</center></html>";
        String e5 = "<html><center>If you are on an island alone, " +
            "finding what will make you the happiest?</center></html>";
        String e6 = "<html><center>Which of these options describe yourself " + 
            "the best?</center></html>";
        String e7 = "<html><center>If you were to be a creature in Harry Potter, " +
            "which one do you want to be?</center></html>";
        String e8 = "<html><center>Do you put milk and sugar in your coffee?";
        String e9 = "<html><center>If you were to choose one of these occupations, " +
            "which one do you choose?</center></html>";
        String e10 = "<html><center>Which of the following animals scare you " + 
            "the most?</center></html>";
        String e11 = "<html><center>If you were to have a super power, " + 
            "which one do you want to have?</center></html>";
        String e12 = "<html><center>If Zombie apocalypse were to come, " + 
            "which of the below weapons do you bring with you?</center></html>";
        String e13 = "<html><center>If you have to choose one of the below " + 
            "as your pet, which one do you choose?</center></html>";

        // Answers
        String answer1a = "Takis";
        String answer1b = "Stella";
        String answer1c = "Jean";
        String answer2a = "Heavy Snow";
        String answer2b = "Heavy Rain";
        String answer2c = "Hail";
        String answer3a = "Of course";
        String answer3b = "Ehhh, maybe";
        String answer3c = "No, I'm a baby";
        String answer4a = "So mean!";
        String answer4b = "An angel";
        String answer4c = "Idk, my friend is too versatile";
        String answer5a = "A knife and a lighter";
        String answer5b = "Booz and comfort food";
        String answer5c = "A puppy!";
        String answer6a = "A perfect soul";
        String answer6b = "An interesting mess";
        String answer6c = "A mysterious creature";
        String answer7a = "Pixie";
        String answer7b = "Sphix";
        String answer7c = "Giant";
        String answer8a = "One of them";
        String answer8b = "Both of them";
        String answer8c = "Neither of them";
        String answer9a = "Ben & Jerry’s \"Flavor Guru\"";
        String answer9b = "Video Game Tester";
        String answer9c = "Professional zombie";
        String answer10a = "A lady bug";
        String answer10b = "A Butterfly";
        String answer10c= "A gold fish";
        String answer11a = "Invisibility";
        String answer11b = "No need to sleep at all";
        String answer11c= "The abilitity to pick up any language instantly";
        String answer12a = "A lot of snow balls";
        String answer12b = "Your Brain";
        String answer12c= "A broom";
        String answer13a = "A cockroach";
        String answer13b = "A caterpillar";
        String answer13c= "A naked mole-rat";

        // array indices that will used in songNamesVector
        String arrayIndex0 = "0";
        String arrayIndex1 = "1";
        String arrayIndex2 = "2";
        String arrayIndex3 = "3";
        String arrayIndex4 = "4";
        String arrayIndex5 = "5";
        String arrayIndex6 = "6";
        String arrayIndex7 = "7";
        String arrayIndex8 = "8";
        String arrayIndex9 = "9";
        String arrayIndex10 = "10";
        String arrayIndex11 = "11";
        String arrayIndex12 = "12";
        String arrayIndex13 = "13";
        String arrayIndex14 = "14";
        String arrayIndex15 = "15";
        String arrayIndex16 = "16";
        String arrayIndex17 = "17";
        String arrayIndex18 = "18";
        String arrayIndex19 = "19";
        String arrayIndex20 = "20";
        String arrayIndex21 = "21";
        String arrayIndex22 = "22";
        String arrayIndex23 = "23";
        String arrayIndex24 = "24";
        String arrayIndex25 = "25";
        String arrayIndex26 = "26";

        LinkedTernaryTree<String> n2,n3,n4,n5,n6,n7,n8,n9,n10,n11,n12,n13;
        n13 = new LinkedTernaryTree<String>(e13, 
            new LinkedTernaryTree<String>(arrayIndex24), 
            new LinkedTernaryTree<String>(arrayIndex25),  
            new LinkedTernaryTree<String>(arrayIndex26),
            new LinkedTernaryTree<String>(answer13a), 
            new LinkedTernaryTree<String>(answer13b),
            new LinkedTernaryTree<String>(answer13c));
        n12 = new LinkedTernaryTree<String>(e12,
            new LinkedTernaryTree<String>(arrayIndex21), 
            new LinkedTernaryTree<String>(arrayIndex22),  
            new LinkedTernaryTree<String>(arrayIndex23), 
            new LinkedTernaryTree<String>(answer12a), 
            new LinkedTernaryTree<String>(answer12b),
            new LinkedTernaryTree<String>(answer12c));
        n11 = new LinkedTernaryTree<String>(e11, 
            new LinkedTernaryTree<String>(arrayIndex18), 
            new LinkedTernaryTree<String>(arrayIndex19),  
            new LinkedTernaryTree<String>(arrayIndex20),
            new LinkedTernaryTree<String>(answer11a), 
            new LinkedTernaryTree<String>(answer11b),
            new LinkedTernaryTree<String>(answer11c));
        n10 = new LinkedTernaryTree<String>(e10,
            new LinkedTernaryTree<String>(arrayIndex15), 
            new LinkedTernaryTree<String>(arrayIndex16),  
            new LinkedTernaryTree<String>(arrayIndex17),
            new LinkedTernaryTree<String>(answer10a), 
            new LinkedTernaryTree<String>(answer10b),
            new LinkedTernaryTree<String>(answer10c));
        n9 = new LinkedTernaryTree<String>(e9,
            new LinkedTernaryTree<String>(arrayIndex12), 
            new LinkedTernaryTree<String>(arrayIndex13),  
            new LinkedTernaryTree<String>(arrayIndex14),
            new LinkedTernaryTree<String>(answer9a), 
            new LinkedTernaryTree<String>(answer9b),
            new LinkedTernaryTree<String>(answer9c));
        n8 = new LinkedTernaryTree<String>(e8, 
            new LinkedTernaryTree<String>(arrayIndex9), 
            new LinkedTernaryTree<String>(arrayIndex10),  
            new LinkedTernaryTree<String>(arrayIndex11), 
            new LinkedTernaryTree<String>(answer8a), 
            new LinkedTernaryTree<String>(answer8b),
            new LinkedTernaryTree<String>(answer8c));
        n7 = new LinkedTernaryTree<String>(e7,
            new LinkedTernaryTree<String>(arrayIndex6), 
            new LinkedTernaryTree<String>(arrayIndex7),  
            new LinkedTernaryTree<String>(arrayIndex8),
            new LinkedTernaryTree<String>(answer7a), 
            new LinkedTernaryTree<String>(answer7b),
            new LinkedTernaryTree<String>(answer7c));
        n6 = new LinkedTernaryTree<String>(e6,
            new LinkedTernaryTree<String>(arrayIndex3), 
            new LinkedTernaryTree<String>(arrayIndex4),  
            new LinkedTernaryTree<String>(arrayIndex5),
            new LinkedTernaryTree<String>(answer6a), 
            new LinkedTernaryTree<String>(answer6b),
            new LinkedTernaryTree<String>(answer6c));
        n5 = new LinkedTernaryTree<String>(e5,
            new LinkedTernaryTree<String>(arrayIndex0), 
            new LinkedTernaryTree<String>(arrayIndex1),  
            new LinkedTernaryTree<String>(arrayIndex2),
            new LinkedTernaryTree<String>(answer5a), 
            new LinkedTernaryTree<String>(answer5b),
            new LinkedTernaryTree<String>(answer5c));
        n4 = new LinkedTernaryTree<String>(e4, n11, n12, n13, 
            new LinkedTernaryTree<String>(answer4a), 
            new LinkedTernaryTree<String>(answer4b),
            new LinkedTernaryTree<String>(answer4c));
        n3 = new LinkedTernaryTree<String>(e3, n8, n9, n10, 
            new LinkedTernaryTree<String>(answer3a), 
            new LinkedTernaryTree<String>(answer3b),
            new LinkedTernaryTree<String>(answer3c));
        n2 = new LinkedTernaryTree<String>(e2, n5, n6, n7, 
            new LinkedTernaryTree<String>(answer2a), 
            new LinkedTernaryTree<String>(answer2b),
            new LinkedTernaryTree<String>(answer2c));
        musicTree = new LinkedTernaryTree<String>(e1, n2, n3, n4, 
            new LinkedTernaryTree<String>(answer1a), 
            new LinkedTernaryTree<String>(answer1b),
            new LinkedTernaryTree<String>(answer1c));
    }

    /**
     * A getter that returns a musicTree.
     * @return LinkedTernaryTree musicTree
     */
    public LinkedTernaryTree getMusicTree() {
        return musicTree;
    }

    // /**
    // * A main class used for testing purpose
    // */
    // public static void main (String[] args) {
    // musicTernaryTree tree = new musicTernaryTree();
    // System.out.println(tree.getMusicTree());
    // } 
}