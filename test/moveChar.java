import CovUni.Win110ct;
import java.awt.Color;

public class JavaApplication1 {

    public static void main(String[] args) {
        Win110ct win = new Win110ct(800,600,16);
    int x = 40;
    int y = 20;
    char input = ' ';
    win.echo(false);
    win.setTextColour(Color.green);
    win.setPosition(10,4);
    win.write("Press w, a, s, or d to move the character around the screen (or x to exit)");

    while(input != 'x')
    {
        input = win.nextChar();
        win.setPosition(x,y);
        win.clearChar();

        switch(input)
        {
            case 'w': --y; break;
            case 'a': --x; break;
            case 's': ++y; break;
            case 'd': ++x; break;
        }
        win.setPosition(x,y);
        win.write("#");
    }

    win.dispose();
    }
}

