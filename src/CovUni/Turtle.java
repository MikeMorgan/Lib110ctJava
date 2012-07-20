/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package CovUni;

import java.awt.AlphaComposite;
import java.awt.BasicStroke;
import java.awt.Color;
import java.awt.Graphics2D;

/**
 * An MSW Logo style 'Turtle' class for use in a Win110ct console
 * 
 * @author mike
 * @see    Win110ct
 */
public class Turtle{
    float direction; 
    int x, y;
    Win110ct win;
    Graphics2D graph;
    Color cl;
    BasicStroke stroke;
    Boolean drawing;
    
    public static final double LEFT_TURN = 90;
    public static final double RIGHT_TURN = 270;
    
    /**
     * Constructs a turtle (this is carried out automatically during calls to getTurtle() from Win110ct)
     * @param win   The console window for turtle related antics
     */
    public Turtle(Win110ct win){
        this.win = win;
        direction = 0;
        drawing = false;
        graph = (Graphics2D) win.getBuffer().getGraphics();
        cl = Color.white;
        x = win.getWidth()/2; 
        y = win.getHeight()/2;
        stroke = new BasicStroke(1.0f);
    }
    
    /**
     * Moves the turtle forward
     * 
     * @param x     The distance (in pixels) for the turtle to move.  
     */
    public void moveForward(double x)
    {
        int x1 = this.x + (int) (Math.sin(direction) * x);
        int y1 = this.y + (int) (Math.cos(direction) * x);
        
        if(drawing)
        {
            graph.setComposite(AlphaComposite.getInstance(AlphaComposite.SRC_OVER, 0.8f));
            graph.setColor(cl);
            graph.setStroke(stroke);
            graph.drawLine(this.x, this.y, x1, y1);
        }
        this.x = x1;
        this.y = y1;
        win.repaint();
    }
    
    /**
     * Rotates the turtle
     * 
     * @param degrees   The angle to turn  
     */
    public void turn(double degrees)
    {        
        direction += Math.toRadians(degrees);
        win.repaint();
    }
    
    /**
     * Lifts the pen (stops the turtle drawing when it moves)
     */
    public void penUp()
    {
        drawing = false;
    }
    
    /**
     * Puts the pen down (starts the turtle drawing when in motion)
     */
    public void penDown()
    {
        drawing = true;
    }
    
    /**
     * Sets the pen color for the turtle
     * 
     * @param c the color 
     * @see     Color
     */
    public void setColor(Color c)
    {
        cl = c;
    }
    
    /**
     * Gets the current pen colour
     * 
     * @return  The colour 
     */
    public Color getColor()
    {
        return cl;
    }
    
    /**
     * Gets the current turtle direction (in radians - this is used by Win110ct when rendering the turtle)
     * 
     * @return  The direction of the turtle
     */
    public double getDirection()
    {
        return direction;
    }
    
    /**
     * Sets the width of the line drawn by the turtle
     * 
     * @param width The line width 
     */
    public void setPenWidth(double width)
    {
        stroke = new BasicStroke( (float) width);
    }
    
    /**
     * Gets the turtle's current x coordinate (in pixels) 
     * @return  the x coordinate 
     */
    public int getx()
    {
        return x;
    }
    
    /**
     * Gets the turtle's current y coordinate (in pixels)
     * @return  the y coordinate 
     */
    public int gety()
    {
        return y;
    }
}