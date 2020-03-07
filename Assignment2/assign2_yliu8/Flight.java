
/**
 * This class represent airplane flight information.
 *
 * @author (Yaxin Liu)
 * @version (9/12/18)
 */

import java.util.Scanner;

public class Flight
{
    // instance variables - replace the example below with your own
    private String airline;
    private int FlyNumber;
    private String fromPlace;
    private String toPlace;

    /**
     * Constructor for objects of class Flight
     */
    public Flight(String line, int flNum, String from, String to) 
    {
        // initialise instance variables
        airline = line;
        FlyNumber = flNum;
        fromPlace = from;
        toPlace = to;
    }
    
    public static void main(String[] args){
        Scanner scan = new Scanner(System.in);
        Flight newFlight = readFlight(scan);
        System.out.println(newFlight.toString());
        
        System.out.println(newFlight.getAirline());
        newFlight.setFlightNumber(123456);
        System.out.println(newFlight.toString());
        
        Flight flight2 = new Flight("Delta", 736289, "Seattle", "Boston");
        
        System.out.println("Does the flight stop over? "+ stopOver(flight2, newFlight));
    }
    
    //Getter for airline instance variable
    public String getAirline(){
        return airline;
    }
    
    //Getter for destination instance variable
    public String getDestination(){
        return toPlace;
    }
          
    // Getter for flightNum instance variable
    public int getFlightNumber(){
        return FlyNumber;
    }
    
    //Getter for origin instance variable
    public String getOrigin(){
        return fromPlace;
    }
    
    public static Flight readFlight(Scanner s){
        System.out.println("Name of the airline:");
        String airLine = s.nextLine();
        System.out.println("From:");
        String origin = s.nextLine();
        System.out.println("To:");
        String to = s.nextLine();
        System.out.println("Flight number:");
        int fly = s.nextInt();
        Flight newFlight = new Flight(airLine, fly, origin, to);
        return newFlight;
    }
    
    //Setter for airline instance variable
    public void	setAirline(String airline){
        this.airline = airline;
    }
    
    //Setter for destination instance variable.
    public void	setDestination(String toCity){
        toPlace = toCity;
    }
    
    //Setter for flightNum instance variable
    public void	setFlightNumber(int flNum){
        FlyNumber = flNum;
    }
    
    //Setter for fromCity instance variable
    public void	setOrigin(String fromCity){
        fromPlace = fromCity;
    }
    
    public static boolean stopOver(Flight f1, Flight f2){
        String n = f1.getOrigin();
        String n1 = f2.getDestination();
        if(n.equals(n1)){
            return true;
        }else{
            return false;
        }
    }
    
    public String toString(){
        String flight = "Your flight " + airline + " " + FlyNumber + " are from " + 
        fromPlace + " to " + toPlace;
        return flight;
    }
    
}
