/**
*  GuitarString.java       Java Foundations
*  
*  Implements a class called GuitarString that models a vibrating 
*  guitar string.
*  
*  @author Yaxin(Annie) Liu
*  @version Oct 25, 2018
*/

import java.util.*;
import javafoundations.*;

public class GuitarString
{
    // instance variable
    private BoundedQueue<Double> q;
    private int N;
    private final double factor = 0.994;
    private final int samplingRate = 44100;
    
    /**
     * The constructor creates a guitar string of the given frequency,
     * initializes a bounded queue of the desired capacity N, and fills 
     * the bounded queue with N zeros to model a guitar string at rest.
     */
     public GuitarString(double frequency){
        N = (int)Math.round(samplingRate/frequency);
        q = new BoundedQueue<Double>(N);
        for( int i = 0; i < N; i++){
	q.enqueue(0.0);
       }
    }
    
    /**
     * Replaces the N samples in the bounded queue with N random values 
     * between -0.5 and +0.5.
     */
     public void pluck(){
        while(!(q.isEmpty())){
          q.dequeue();
        }
        
        for(int i = 0; i < N; i++){
          double random = (Math.random() -0.5);
          q.enqueue(random);
        }
    }
    
    /**
     * Returns the value of the item at the front of the bounded queue.
     */
     public double sample(){
        return q.first();
    }
    
    /**
     *  Applies the Karplus-Strong algorithm. It deletes the sample at 
     *  the front of the bounded queue and adds to the end of the bounded 
     *  queue the average of the deleted sample and the sample at the 
     *  front of the bounded queue, multiplied by the energy decay factor.
     */
     public void tic(){
        double first = q.dequeue();
        double second = q.first();
        double num = factor * 0.5 * (first + second);
        q.enqueue(num);
    }
}
