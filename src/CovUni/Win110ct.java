/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package CovUni;

import java.awt.*;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.awt.geom.Rectangle2D;
import java.awt.image.BufferedImage;
import javax.swing.JFrame;
import javax.swing.JPanel;

/**
 *
 * @author mike
 */

/**
 * Console window class
 * Provides simple text I/O, 2D graphics and a 'Turtle'
 */
public class Win110ct extends JFrame{
    ConPanel consol;
    int width, height;
   
    /**
     * Constructor: builds a window with the given height, width and font pitch for text output
     * @param   w   The width of the window in pixels
     * @param   h   The height of the window in pixels
     * @param   fontPitch   The pitch of the font used for text I/O
     */
    public Win110ct(int w, int h, int fontPitch)
    {
        super("110ct Console");
        
        setSize(w,h);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setResizable(false);
        
        width = w;
        height = h;
        
        consol = new ConPanel(w,h,fontPitch, this);
        this.getContentPane().add(consol);
        
        //pack();
        setVisible(true);
    }
    
    /**
     * Sets the colour of the foreground text.
     * This does not alter the colour of text already displayed in the console
     * @param   c   The color of the text
     */
    public void setTextColour(Color c)
    {
        consol.setFore(c);
    }
    
    /**
     * Sets the background colour for outputted text.
     * This does not alter the background colour of text already displayed in the console
     * @param   c   The background colour
     */
    public void setBackColour(Color c)
    {
        consol.setBack(c);
    }
    
    /**
     * Controls console behaviour during input
     * 
     * @param   on   True if characters are to be echoes to the console, false otherwise
     */
    public void echo(Boolean on)
    {
        consol.setEcho(on);
    }
    /**
     * Checks to see if the user has typed a key - the first call to this method
     * will start the checking process and return false, while subsequent calls
     * will check for input. The most recent keystroke can be obtained with a 
     * call to nextCharacter()
     * @return true if the user has typed a key and false otherwise. 
     */
    public Boolean checkInput()
    {
        return consol.waiting();
    }
    
    /**
     * Writes a string to the console. Accommodates the formatting characters \n and \t for newline and tab
     * 
     * @param   str     The string to be written
     */
    public void write(String str)
    {
        /*for(int i=0; i<str.length(); ++i)
            consol.putchar(str.charAt(i));*/
        consol.puts(str);
    }
    
    /**
     * Writes a single character to the console. 
     * 
     * @param   c     The character to be written
     */
    public void write(char c)
    {
        consol.putchar(c);
    }
    
    /**
     * Writes an integer to the console. 
     * 
     * @param   n     The integer to be written
     */
    public void write(int n){
        String str = Integer.toString(n);
        write(str);
    }
    
    /**
     * Writes a double to the console. 
     * (an alternative with precision might be good here) 
     * 
     * @param   n     The double to be written
     */
    public void write(double n){
        String str = Double.toString(n);
        write(str);
    }
    
    /**
     * Reads a single character. Input is always unbuffered for this method  
     * 
     * @return  The character typed.     
     */
    public char nextChar()
    {
        return consol.getchar();
    }
    
    /**
     * Reads a string. 
     * 
     * @return  The complete string entered by the user (including spaces)
     */
    public String next()
    {
        return consol.gets();
    }
    
    /**
     * Reads an integer
     * 
     * @return  The integer entered by the user 
     */
    public int nextInt() throws NumberFormatException
    {
        return Integer.parseInt(consol.gets().trim());
    }
    
    /**
     * Reads a double
     * 
     * @return  The double entered by the user 
     */
    public double nextDouble() throws NumberFormatException
    {
        return Double.parseDouble(consol.gets().trim());
    }
    
    /**
     * Sets the cursor position (in character spaces, not pixels)
     * 
     * @param   x   The x coordinate 
     * @param   y   The y coordinate
     */
    public void setPosition(int x, int y)
    {
        consol.setPos(x, y);
    }
    
    /**
     * Returns the x coordinate of the current cursor position
     * 
     * @return  The x coordinate for the cursor
     */
    public int getx()
    {
        return 0;
    }
    
    /**
     * Returns the y coordinate of the current cursor position
     * 
     * @return  The y coordinate for the cursor
     */
    public int gety()
    {
        return 0;
    }
    
    
    /**
     * Clears all text from the console (retaining background image)
     *  
     */
    public void clear(){
        consol.clrscr();
    }
    
    /**
     * Clears the background image for the console (retaining text)
     *  
     */
    public void clearBack()
    {
        consol.clearBackRect(0, 0, width, height);
    }
    
    /**
     * Clears a rectangular portion of the background image
     * 
     * @param   x   The x coordinate of the top left hand corner (in pixels)
     * @param   y   The y coordinate of the top left hand corner (in pixels)
     * @param   width   The width of the rectangle
     * @param   height  The height of the rectangle
     */
    public void clearBack(int x, int y, int w, int h)
    {
        consol.clearBackRect(x, y, w, h);
    }
    
    /**
     * Clears the character at the current cursor position
     *  
     */
    public void clearChar()
    {
        consol.clearChars(1);
    }
    
    /**
     * Clears a number of characters, starting from the current cursor position
     *  
     * @param   nChars  the number of characters to be cleared.
     */
    public void clearChars(int nChars)
    {
        consol.clearChars(nChars);
    }
    
    /**
     * Returns the background image for the console (enables fun with graphics)
     *  
     * @return   The background image
     */
    public BufferedImage getBuffer()
    {
        return consol.getBuffer();
    }
     
    /**
     * Gets an MSW Logo style 'Turtle' for use in the console window.
     *  
     * @return  The turtle
     * @see     Turtle
     */
    public Turtle getTurtle()
    {
        return consol.getTurtle(); 
    }
    
    /**
     * Hides the turtle (retains anything the turtle has drawn)
     *  
     * @see     Turtle
     */
    public void hideTurtle()
    {
        consol.hideTurtle();
    }
    
    /**
     * Displays the turtle (turtle is displayed by default but this may be necessary following a call to hideTurtle()
     *  
     * @see     Turtle  hideTurtle
     * 
     */
    public void showTurtle()
    {
        consol.showTurtle();
    }
}

class FormattedChar
{
    char c;
    Color fg, bg;
    
    FormattedChar(){
        c = ' ';
        fg = Color.white;
        bg = Color.black;
    }
            
    public void set(char ch){
        c = ch;
    }
    public char get(){
        return c;
    }
    public void setFore(Color cl){
        fg = cl.brighter();
    }
    public Color getFore(){
        return fg;
    }
    public void setBack(Color cl){
        bg = cl.darker();
    }
    public Color getBack(){
        return bg;
    }
    public String asString(){
        return Character.toString(c);
    }
}

class ConPanel extends JPanel implements KeyListener{
    Win110ct wind;              
    FormattedChar text[][];     
    int nlines, ncols,              //window dimensions in character sized 'chunks'
            fontHeight, fontWidth,  //height and width of console font in pixels
            width, height,          //height and width of console window in pixels
            startx, starty,   //location of cursor when buffering started
            endbufx, endbufy;       //location of cursor when buffering finished
            
    int x,y;    //current cursor position
    
    Boolean got,    //State variables: got indicates whether input has finished
            echo, 
            reading,    //indicates whether we are currently awaiting input 
            buffering,  //indicates whether we are currently buffering input
            turtling;   //indicates whether the turtle should be displayed on repaint()   
            
    Font font;
    StringBuffer bfr;   //to store buffered input
    
    BufferedImage textImg, backg;
    Graphics2D textBuffer;          //enables rendering to bitmap, prior to repaint
    
    char last;          //stores the last 'meaningful' character read from the keyboard
    Color fg,bg;        //current foreground and background color
    Turtle turtle;
    
    static final int tabWidth = 8;
    
    public ConPanel(int width, int height, int fontpitch, Win110ct wind){
        this.setSize(width, height);
        this.width = width;
        this.height = height;
        this.wind = wind;
        this.setBackground(Color.black);
        textImg = new BufferedImage(width, height, BufferedImage.TYPE_INT_ARGB);
        backg = new BufferedImage(width, height, BufferedImage.TYPE_INT_ARGB);
        
        textBuffer = (Graphics2D) textImg.getGraphics();
        font = new Font("monospaced", Font.PLAIN, fontpitch);
        textBuffer.setFont(font);
        textBuffer.setRenderingHint(RenderingHints.KEY_TEXT_ANTIALIASING,
                                    RenderingHints.VALUE_TEXT_ANTIALIAS_ON);
        Rectangle2D charRect = font.getMaxCharBounds(textBuffer.getFontRenderContext());
        fontHeight = (int) (charRect.getHeight());
        fontWidth = (int) (charRect.getWidth());
        if(fontWidth > fontHeight) fontWidth /= 2;
        nlines = height/fontHeight;
        ncols = width/fontWidth - 1;
        bfr = new StringBuffer();
        text = new FormattedChar[nlines][ncols];
        for(int i=0; i<nlines; ++i)
            for(int j=0; j<ncols; ++j)
                text[i][j] = new FormattedChar();
        x=y=0;
        fg = Color.white;
        bg = Color.black;
        echo = true;
        reading = turtling = buffering = false;
        last = ' ';
        got = false;
        this.setFocusable(true);
        this.setDoubleBuffered(true);
        this.addKeyListener(this);
        
    }
    
    @Override
    public void paintComponent(Graphics g){
        super.paintComponent(g);
        
        Graphics2D g2d = (Graphics2D) g;
        
        g2d.setColor(Color.black);
        g2d.fillRect(0, 0, width, height);
        g2d.setComposite(AlphaComposite.getInstance(AlphaComposite.SRC_OVER, 0.75f));
        g2d.drawImage(backg,0,0,null); 
        g2d.setComposite(AlphaComposite.getInstance(AlphaComposite.SRC_OVER, 0.75f));
        g2d.drawImage(textImg,0,0,null);
        //g2d.drawImage(combined, 0, 0, null);
        if(turtling)
        {
            g2d.setColor(turtle.getColor());
            g2d.fillOval( (int) Math.round(turtle.getx()-8), (int) Math.round(turtle.gety()-10), 16, 16);
            double dir = turtle.getDirection();
            double x1 = turtle.getx()+ (8.0 * Math.sin(dir));
            double y1 = turtle.gety()+ (8.0 * Math.cos(dir));
            g2d.setStroke(new BasicStroke(3));
            g2d.drawLine((int) Math.round(turtle.getx()), (int) Math.round(turtle.gety()), (int) Math.round(x1), (int) Math.round(y1));
        }
    }
    
    public void render()
    {
        if(y>=nlines || x>=ncols) return;
        textBuffer.setColor(text[y][x].getBack());
        textBuffer.setComposite(AlphaComposite.getInstance(AlphaComposite.SRC_OVER, 1.0f));
        textBuffer.fillRect(x*fontWidth, y*fontHeight, fontWidth, fontHeight);
        
        textBuffer.setColor(text[y][x].getFore());
        textBuffer.drawString(text[y][x].asString() ,x*fontWidth, (fontHeight - fontHeight/6) + fontHeight*y);
    }
    
    public void setFore(Color c)
    {
        fg = c;
    }
    
    public void setBack(Color c)
    {
        bg = c;
    }
    
    public void setPos(int xpos, int ypos)
    {
        x = Math.abs(xpos % ncols);
        y = Math.abs(ypos % nlines);
    }
    
    public void setEcho(Boolean b)
    {
        echo = b;
    }
    
    
    
    public void puts(String s)
    {
        for(int i=0; i< s.length(); ++i)
        {
            addchar(s.charAt(i));
            if(s.charAt(i) != '\n' && s.charAt(i) != '\t')
            {
                render();
                movecursor();
            }
        }
        repaint();
    }
    
    public String gets()
    {
        startx = x;
        starty = y;
        bfr =  new StringBuffer();
        reading = buffering = true;
        synchronized(this){
            try
            {
                this.wait();
            }
            catch(Exception e) {}
        }
        reading = buffering = false;
        return bfr.toString();
    }
    
    public void addchar(char c)
    {
        if(c == 10 || c == 13)
        {
            y++;
            x=0;
        }
        else if(c == '\t')
        {
            x = (x+tabWidth) - x%tabWidth;
            if(x >= ncols)
            {
                x=0;
                ++y;
            }
        }
       
        else if(x<ncols && y < nlines)
        {
            text[y][x].set(c);
            text[y][x].setFore(fg);
            text[y][x].setBack(bg);
        }
    }
    
    public void movecursor()
    {
        if(++x >= ncols)
        {
            y++;
            x=0;
        }
    }
    
    public void putchar(char c)
    {
        addchar(c);
        if(c != 13 && c != 10 && c != '\t')
        {
            render();
            repaint(x*fontWidth, y*fontHeight, fontWidth, fontHeight);
            movecursor();
        }
    }
    
    public Boolean waiting()
    {
        if(!reading) 
            reading = true;
        else if(got) 
        {
            reading = got = false;
            return true;
        }
        return false;
    }
    
    public char getchar()
    {
        reading = true;
        synchronized(this){
            try
            {
                this.wait();
            }
            catch(Exception e) {}
        }
        
        reading = false;
        return last;
    }
    
    public void clrscr(){
        for(int i=0; i<nlines; ++i)
            for(int j=0; j<ncols; ++j)
            {
                text[i][j].set(' ');
                text[i][j].setFore(fg);
                text[i][j].setBack(bg);
                //render();
            }
        for(int j=0; j<width; j++)
            for(int k=0; k<height; k++)
                    textImg.setRGB(j, k, 0x00000000);
        repaint();
    }
    
    public void clearChars(int nChars)
    {
        int _x = x;
        int _y = y;
        for(int i=0; i<nChars; ++i)
        {
            for(int j=0; j<fontWidth; j++)
                for(int k=0; k<fontHeight; k++)
                    textImg.setRGB(_x*fontWidth+j, _y*fontHeight+k, 0x00000000);
                    
            if(++_x >= ncols)
            {
                ++_y;
                if(_y >= nlines)
                    break;
                _x=0;
            }          
        }
        repaint();
    }

    public void clearBackRect(int x, int y, int w, int h)
    {
        for(int j=x; j<x+w; j++)
            for(int k=y; k<y+h; k++)
                backg.setRGB(j, k, 0x00000000);
        repaint(x,y,w,h);
    }
    
    @Override
    public void keyPressed(KeyEvent e)
    {
        
    }
    
    @Override
    public void keyReleased(KeyEvent e)
    {
         
    }
    
    @Override
    public void keyTyped(KeyEvent e)
    {
        if(!reading) return;
        
        if(e.getKeyChar() == 8)
        {   
            if(x > startx || y > starty)
            {
                if(buffering) bfr.deleteCharAt(bfr.length()-1);   
                if(x>0)
                    --x;
                else if(y>0)
                {
                    --y;
                    x=ncols-1;
                }
                if(y < nlines && x < ncols)
                {
                    text[y][x].set(' ');
                }
                render();
                repaint(x*fontWidth, y*fontHeight, fontWidth, fontHeight);  
            }
        }
        else
        {
            last = e.getKeyChar();
            if(!buffering) 
            {
                got = true;
                synchronized(this)
                {
                    this.notify();
                }
            }
            if(buffering && (last == 10 || last == 13))
            {
                endbufx = x;
                endbufy = y;
                synchronized(this)
                {
                    this.notify();
                }
            }
            if(echo) putchar(last);
            if(buffering) bfr.append(last);                    
        }
    }
    
    public BufferedImage getBuffer()
    {
        return backg;
    }
    
    public Turtle getTurtle()
    {
        turtle = new Turtle(wind);
        turtling = true;
        return turtle;
    }
    
    public void hideTurtle()
    {
        turtling = false;    
    }
    
    public void showTurtle()
    {
        turtling = true;
    }
}
