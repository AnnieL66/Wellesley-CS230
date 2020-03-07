/**
 * songNamesVector.java <br>
 * Implements a class called songNamesVector.
 * It contains instance data including the arrays of songs that each corresponds to a
 * leaf node in the LinkedTernaryTree. <br>
 * When the user has reached a leaf node, the corresponding array would be recognized 
 * and one song inside the array would be randomly generated. <br>
 *
 * @author Yaxin Liu and Vera Ye
 * @version v2, Dec 15 2018
 */

import java.util.*;
import javafoundations.*;

public class songNamesVector {
    // a vector that contains arrays of Strings
    private Vector<String[]> allSongs;

    /**
     * Constructor for class songNamesVector
     */
    public songNamesVector() {
        allSongs = new Vector<String[]>();

        String[] array0, array1, array2, array3, array4, array5, array6, 
        array7, array8, array9, array10, array11, array12, array13, array14,
        array15, array16, array17, array18, array19, array20, array21,
        array22, array23, array24, array25, array26;

        array0 = new String[] {"takitaki", "loveyourself", "notgoinganywhere"};
        array1 = new String[] {"takitaki", "strawberriesandcigarettes", "despacito"};
        array2 = new String[] {"takitaki", "loststars", "lullabylove"};
        array3 = new String[] {"takitaki", "leftrightleft", "loveyourself"};
        array4 = new String[] {"takitaki", "leftrightleft", "maskoff"};
        array5 = new String[] {"takitaki", "crazy", "despacito"};
        array6 = new String[] {"takitaki", "ilikeit", "crazy"};
        array7 = new String[] {"takitaki", "ilikeit", "mylove"};
        array8 = new String[] {"takitaki", "ilikeit", "californiadreaming"};

        array9 = new String[] {"jolene", "girlfromipanema", "californiadreaming"};
        array10 = new String[] {"lullabylove", "girlfromipanema", "californiadreaming"};
        array11 = new String[] {"mylove", "jolene", "girlfromipanema"};
        array12 = new String[] {"californiadreaming", "ilikeit", "highbythebeach"};
        array13 = new String[] {"ilikeit", "crazy", "notgoinganywhere"};
        array14 = new String[] {"mylove", "loststars", "despacito"};
        array15 = new String[] {"lullabylove", "leftrightleft", "mylove"};
        array16 = new String[] {"lullabylove", "doneforme", "ificouldpray"};
        array17 = new String[] {"lullabylove", "leftrightleft", "highbythebeach"};

        array18 = new String[] {"notgoinganywhere", "mylove", "loststars"};
        array19 = new String[] {"crazy", "strawberriesandcigarettes", "mylove"};
        array20 = new String[] {"despacito", "strawberriesandcigarettes", "mylove"};
        array21 = new String[] {"doneforme", "leftrightleft", "notgoinganywhere"};
        array22 = new String[] {"strawberriesandcigarettes","maskoff", "jolene"};
        array23 = new String[] {"maskoff", "ificouldpray", "loststars"};
        array24 = new String[] {"crazy", "leftrightleft", "mylove"};
        array25 = new String[] {"despacito", "maskoff", "strawberriesandcigarettes"};
        array26 = new String[] {"strawberriesandcigarettes", "crazy", "notgoinganywhere"};

        allSongs.add(array0);  
        allSongs.add(array1);  
        allSongs.add(array2);
        allSongs.add(array3);
        allSongs.add(array4);
        allSongs.add(array5);
        allSongs.add(array6);
        allSongs.add(array7);
        allSongs.add(array8);
        allSongs.add(array9);
        allSongs.add(array10);
        allSongs.add(array11);
        allSongs.add(array12);
        allSongs.add(array13);
        allSongs.add(array14);
        allSongs.add(array15);
        allSongs.add(array16);
        allSongs.add(array17);
        allSongs.add(array18);
        allSongs.add(array19);
        allSongs.add(array20);
        allSongs.add(array21);
        allSongs.add(array22);
        allSongs.add(array23);
        allSongs.add(array24);
        allSongs.add(array25);
        allSongs.add(array26);
    }

    /**
     * Returns one randomly generated song from the corresponding array given its index.
     * 
     * @param String arrayIndex which is a String passed from musicTernaryTree class
     * @return String songName
     */
    public String getOneSong(String arrayIndex) {
        int i = Integer.parseInt(arrayIndex);
        String[] array = allSongs.get(i);
        Random rand = new Random();
        String songName = array[rand.nextInt(3)];
        return songName;
    }

    // /**
    // * A main class used for testing purpose
    // */
    // public static void main (String[] args) {
    // songNamesVector test = new songNamesVector();
    // System.out.println(test.getOneSong("1"));
    // System.out.println(test.getOneSong("9"));
    // System.out.println(test.getOneSong("12"));
    // System.out.println(test.getOneSong("24"));
    // }
}
