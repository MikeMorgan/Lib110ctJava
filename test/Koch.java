
import CovUni.Stopwatch;
import CovUni.Turtle;
import CovUni.Win110ct;
import java.awt.Color;

public class Koch {

    public static void main(String[] args) {
        Win110ct win = new Win110ct(1000,700,14);
        win.setPosition(20,5);
        win.setTextColour(Color.ORANGE);
        win.write("Please enter the fractal depth: ");
        int depth = win.nextInt();

        Turtle t = win.getTurtle();
        t.penDown();
        t.setColor(Color.green);
        t.setPosition(100, 150);
        t.turn(90);
        t.setSpeed(1);

        Stopwatch s = new Stopwatch();

        for(int i=1; i<=depth; ++i)
        {
            win.clearBack();
            kochFlake(t, i, 600);
            t.setPosition(100,150);
            //t.turn(120);
            for(s.start(); s.read() < 1000; );
            s.reset();
        }

        win.setPosition(45,24);
        win.write("\nPress any key to exit");
        win.nextChar();
        win.dispose();
    }


    public static void kochFlake(Turtle t, int depth, double length)
    {
        for(int i=0; i<3; ++i)
        {
            koch(t, depth, length);
            t.turn(-120);
        }
    }

    public static void koch(Turtle t, int depth, double length)
    {
        if(depth == 0) t.moveForward(length);
        else
        {
            koch(t, depth-1, length/3);
            t.turn(60);

            koch(t, depth-1, length/3);
            t.turn(-120);

            koch(t, depth-1, length/3);
            t.turn(60);

            koch(t, depth-1, length/3);
        }
    }
}

