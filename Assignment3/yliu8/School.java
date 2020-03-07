
/**
 * This class store information about a single graduate school program
 *
 * @author (Yaxin Liu and Yiran Chen)
 * @version (9/20/18)
 */
import java.util.Scanner;
public class School
{
    // instance variables - replace the example below with your own
    private String name;
    private int programs;
    private int effect;
    private int impact;

    protected int rating; // overall rating
    protected int rank; 

    private final int MIN = 0;
    private final int MAX = 10; 
    
    public School(String n, int p, int e, int i){
        name = n;
        rank = 0; // rank is initialized to 0 at first.

        // check if any of the inputs are invalid
        if (MIN <= p && p <= MAX){
            programs = p;
        } else {
            System.out.println("Initiation for " + n + " failed. Invalid academics rating.");
        }
        if (MIN <= e && e <= MAX) {
         effect = e;
        } else {
            System.out.println("Initiation for " + n + " failed. Invalid education research schoolars rating.");
        }
        if (MIN <= i && i <= MAX) {
            impact = i;
        } else {
            System.out.println("Initiation for " + n + " failed. Invalid impact of faculty publications rating.");
        }
    }
    
    public String toString(){
        String str = "Name: " + name + "\nAcademics: " + programs
        + "\nResearch: " + effect + "\nPublications: " + impact 
        + "\nOverall rating: " + rating + "\nCurrent rank: " + rank;
        return str;
     }
    
    public void setName(String n){
        name = n;
    }
        
    public String getName(){
        return name;
    }
    
    public void setPrograms(int p){
        programs = p;
    }
        
    public int getPograms(){
        return programs;
    }
    
    public void setEffect(int e){
        effect = e;
    }
        
    public int getEffect(){
        return effect;
    }
    
    public void setImpact(int i){
        impact = i;
    }
        
    public int getImpact(){
        return impact;
    }

    public int getOverallRating(){
        return rating;
    }

    public void setRank(int newRank) {
        rank = newRank;
    }

    // Gets the overall rating of the school.
    public void setOverallRating(int weightAca, int weightRes, int weightPubs){
        if(1 <= weightAca && weightAca<=5 && 1 <= weightRes && weightRes <= 5 && 1 <= weightPubs && weightPubs <= 5){
            rating = weightAca * programs + weightRes * effect + weightPubs * impact;
        }else{
            System.out.println("Invalid Input. Set Overall Rating failed.");
        }
    }
    
    public void computeRating(int weightAca, int weightRes, int weightPubs){
        setOverallRating(weightAca, weightRes, weightPubs);
    }
    
    public static void main(String[] args){
        // initializing schools
        School school1 = new School("MIT", 10, 10, 7);
        School school2 = new School("Stanford", 8, 10, 9);
        School school3 = new School("CMU", 7, 8, 6);
        School school4 = new School("UC Berkeley", 9, 9, 9);

        Scanner scan = new Scanner(System.in);
        System.out.println("Please provide 3 weights (1..5) for " + "Academics, Research and Publications, eg. '2 3 5'");
        String str = scan.nextLine();
        String[] strs = str.split(" ");
        int[] a = new int[strs.length];
        for (int i = 0; i < strs.length; i++) {
            a[i] = Integer.parseInt(strs[i]);
        }

        // making sure that the weight inputs are valid
        while (a[0] > 5 || a[0] < 0 || a[1] > 5 || a[1] < 0|| a[2] > 5 || a[2] < 0) {
            System.out.println("Invalid weights input. Please try again.");
            System.out.println(
                    "Please provide 3 weights (1..5) for " + "Academics, Research and Publications, eg. '2 3 5'");
            str = scan.nextLine();
            strs = str.split(" ");
            a = new int[strs.length];
            for (int i = 0; i < strs.length; i++) {
                a[i] = Integer.parseInt(strs[i]);
            }
        }

        school1.computeRating(a[0], a[1], a[2]);
        school2.computeRating(a[0], a[1], a[2]);
        school3.computeRating(a[0], a[1], a[2]);
        school4.computeRating(a[0], a[1], a[2]);
        System.out.println("\n" + school1.toString()+"\n\n"+school2.toString());
        System.out.println("\n" + school3.toString()+"\n\n"+school4.toString());
    }
}
