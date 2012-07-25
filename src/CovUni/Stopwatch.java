/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package CovUni;

/**
 * A stopwatch class
 * @author mike
 */
public class Stopwatch
{
    long time, elapsed;
    Boolean running;
    
    /**
     * Makes a new stopwatch
     */
    public Stopwatch()
    {
        running = false;
        time = elapsed = 0;
    }
    
    /**
     * Starts the watch
     */
    public void start()
    {
        time = System.currentTimeMillis();
        running = true;
    }
    
    /**
     * Stops the watch (does not reset time to zero)
     * 
     * @return  The current time  
     */
    public long stop()
    {
         if(running)
        {
            elapsed += System.currentTimeMillis() - time;
            running = false;
        }
        return elapsed;
    }
    
    /**
     * Resets the time to zero
     */
    public void reset()
    {
        time  = elapsed = 0;
    }
    
    /**
     * Reads the current time from the watch, without stopping it
     * 
     * @return  the current time 
     */
    public long read()
    {
        if(running)
        {
            long now = System.currentTimeMillis();
            elapsed += now - time;
            time = now;
        }
        return elapsed;
    }
}
