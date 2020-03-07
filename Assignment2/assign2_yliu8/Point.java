
/**
 * This class asks the user for the coordinates of three points P1,P2 and P3.
 * Then, it calculates their distances and reports which of points P2 and P3 
 * is closer to P1.
 *
 * @author (Yaxin Liu)
 * @version (9/11/18)
 */

import java.util.Scanner;

public class Point
{
    // instance variables - replace the example below with your own
    private double x;
    private double y;
    final double TOLERANCE = 0.01;
    
    /**
     * Constructor for objects of class Point
     */
    public Point(double xCoord,double yCoord)
    {
        // initialise instance variables
        this.x = xCoord;
        this.y = yCoord;
    }
    
    public double getX(){
        return x;
    }
    
    public void setX(double newX){
        x = newX;
    }
    
    public double getY(){
        return y;
    }
    
    public void setY(double newY){
        y = newY;
    }
    
    public double findDistance(Point other){
        double x2 = other.getX();
        double y2 = other.getY();
        double distance = Math.sqrt(Math.pow((x2-x), 2) + Math.pow((y2-y),2));
        return distance;
    }
    
    public static Point readPoint(Scanner s){
        System.out.println("Enter x-coordinate: ");
        double x1 = s.nextDouble();
        System.out.println("Enter y-coordinate: ");
        double y1 = s.nextDouble();
        Point newPoint = new Point(x1, y1);
        return newPoint;
    }
    
    public boolean areEquidistant(Point p2,Point p3){
        double d1 = findDistance(p2);
        double d2 = findDistance(p3);
        if(d1 - d2 < TOLERANCE){
            return true;
        }else{
            return false;
        }
    }

    public String toString(){
        String point = "The point is (" + x + "," + y + ")";
        return point;
    }
    
    public static void main(String[] args){
        Point point = new Point(3.5, 9.4);
        Point point2 = new Point(5.9, 2.4);
        System.out.println(point.toString());
        //test getX
        System.out.println("The x-coordinate of second point is " + point2.getX());
        //test setY
        point.setY(2);
        //test getY
        System.out.println("The y-coordinate of second point is "+ point2.getY());
        System.out.println("The y-coordinate of first point after changing is "
        + point.getY());

        Scanner scan = new Scanner(System.in);
        Point newPoint = readPoint(scan);
        //test toString
        System.out.println(newPoint.toString());
        
        //test findDistance
        System.out.println("The distance between these two point is: " +
        newPoint.findDistance(point));
        
        //test areEquidistant
        System.out.println("Are the difference in distance from the current" + 
        " Point to each of those inputs is within TOLERANCE?" + 
        newPoint.areEquidistant(point,point2));
    }


}
