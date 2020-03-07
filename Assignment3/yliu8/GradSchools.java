/**
 * This class stores information about a 
 * collection of School objects
 *
 * @author (Yaxin Liu and Yiran Chen)
 * @version (9/23/18)
 */
import java.util.Arrays;

public class GradSchools {
    private School[] collection;

    public GradSchools(int size) {
        collection = new School[size];
    }

    public GradSchools() {
        collection = new School[1];
    }

    public void addSchool(String name, int academics, int research, int pubs) {
        School newSchool = new School(name, academics, research, pubs);

        for (int i = 0; i < collection.length; i++) {
            // handling the case of updating existing school info in the collection
            if ((collection[i] != null && collection[i].getName().equals(name))) {
                collection[i] = newSchool;
                break;
            }

            // handle the case when the collection array is completely filled
            if (collection[collection.length - 1] != null) {
                School[] temp = new School[collection.length * 2];
                for (int j = 0; j < collection.length; j ++) {
                    temp[j] = collection[j];
                }

                temp[collection.length] = newSchool;
                collection = temp;
                break;
            }

            //handle the case where there is empty spot in collection array
            if (collection[i] == null) {
                collection[i] = newSchool;
                break;
            }
        }
    }

    public String toString() {
        String strings = "";
        // print each element in the array
        for (int i = 0; i < collection.length; i ++) {
            if (collection[i] != null) {
                // call toString method from Class School
                strings += "\n" + collection[i].toString() + "\n";
            } else {
                break;
            }
        }
        return strings;
    }

    // Computes overallRating for each School object.
    public void computeRatings(int weightAcademics, int weightResearch, int weightPubs) {
        for (int i = 0; i < collection.length; i++) {
            if (collection[i] != null) {
                collection[i].computeRating(weightAcademics, weightResearch, weightPubs);
            } else {
                break;
            }
        }
    }

    private static void swap(School[] arrayA, int i, int j) {
        School temp = arrayA[i];
        arrayA[i] = arrayA[j];
        arrayA[j] = temp;
    }

    // sort school array in decreasing order
    public static void sortSchoolArray(School[] arrayA, String factor) {
        
        int maxNum =0; // maximum integer so far
        int maxIndex; // index of maximum integer
        int i, j;
        int limit = 0;

        for (int index = 0; index < arrayA.length; index ++) {
            if (arrayA[index] == null) {
                limit = index;
                break;
            }
        }
        
        // copy arrayA from indext 0 to limit to arrayB
        School[] arrayB = Arrays.copyOfRange(arrayA, 0, limit);

        for (j = arrayB.length - 1; j > 0; j--) {
            maxIndex = 0;
            
            // set maxNum to values in different cases
            if (factor.equals("Academics")){
                maxNum = arrayB[0].getPograms();
            }else if (factor.equals("Effectiveness")){
                maxNum = arrayB[0].getEffect();
            }else if (factor.equals("Publications")){
                maxNum = arrayB[0].getImpact();
            }else if (factor.equals("Overall")){
                maxNum = arrayB[0].getOverallRating();
            }

            int compare = 0;
            for (i = 1; i <= j; i++){
                if (factor.equals("Academics")) {
                    compare = arrayB[i].getPograms();
                } else if (factor.equals("Effectiveness")) {
                    compare = arrayB[i].getEffect();
                } else if (factor.equals("Publications")) {
                    compare = arrayB[i].getImpact();
                } else if (factor.equals("Overall")) {
                    compare = arrayB[i].getOverallRating();
                }
                
                if (compare > maxNum) {
                    maxNum = compare;
                    maxIndex = i;
                }
            }
                
            swap(arrayB, maxIndex, j);
            swap(arrayA, maxIndex, j);
        }
    }

    // Rank orders the School objects in the schools array, 
    public void rankSchools(String factor) {
        System.out.println("\nRanking of schools from highest to lowest using " + factor + " as a factor:");
        sortSchoolArray(collection, factor);
        for(int i = collection.length - 1; i >= 0; i--){
            if (collection[i] != null) {
                System.out.println(collection[i].getName());
                collection[i].setRank(collection.length - i - 1);
            }
        }
    }
    
    public static void main(String[] args) {
        GradSchools myGradSchools = new GradSchools(3); 
        // testing edge case for addschool
        
        myGradSchools.addSchool("MIT", 10, 10, 7);
        myGradSchools.addSchool("Stanford", 8, 10, 9);
        myGradSchools.addSchool("CMU", 7, 8, 6);
        myGradSchools.addSchool("UC Berkeley", 9, 9, 9);
        myGradSchools.addSchool("Penguin University", 2, 2, 2);

        // compute ratings
        myGradSchools.computeRatings(2, 3, 4);
        
        System.out.println(myGradSchools.toString());

        myGradSchools.rankSchools("Academics");
        myGradSchools.rankSchools("Effectiveness");
        myGradSchools.rankSchools("Publications");
        myGradSchools.rankSchools("Overall");

        // displaying the modified ranks
        System.out.println(myGradSchools.toString());

    }


}