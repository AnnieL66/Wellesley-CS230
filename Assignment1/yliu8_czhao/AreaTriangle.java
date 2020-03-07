
/**
 * Makes correct change for a specified amount of money using loop
 *
 * @author (Yaxin Liu)
 * @version (9/8/18)
 */

import java.util.Scanner;

public class AreaTriangle
{

    public static void main(String[] args)
    {
        Scanner scan = new Scanner(System.in);
        System.out.println("Please enter the length of the first side of a triangle:");
        double length1 = scan.nextDouble();
        System.out.println("Please enter the length of the second side of a triangle:");
        double length2 = scan.nextDouble();
        System.out.println("Please enter the length of the third side of a triangle:");
        double length3 = scan.nextDouble();
       
         if (length1 + length2 <= length3 || length1 + length3 <= length2 || 
         length2 + length3 <= length3){
             System.out.println("Invalid input.");
    }else{
        boolean result = Isoceles(length1, length2, length3);
        if(result == true){
            System.out.println("Triangle is an isoceles.");
            double Area = Area(length1, length2, length3);
            System.out.println("The area of the triangle is " + Area);
        }else{
            System.out.println("Triangle is NOT an isoceles.");
        }
    }
}
    
    public static boolean Isoceles(double length1, double length2, double length3){
        if(length1 == length2 || length1 == length3 || length2 == length3){
            return true;
        }else{
            return false;
        }
    }
    
    public static double Area(double length1, double length2, double length3){
        double s = (length1 + length2 + length3)/2.0;
        double Area = Math.sqrt((s*(s-length1)*(s-length2)*(s-length3)));
        return Area;
}
}
