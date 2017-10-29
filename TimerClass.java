import java.awt.*;
import java.lang.*;
import hsa.Console;

public class TimerClass extends Thread
{
    private Console c;
    private boolean gameWon;
    private int time;

    public TimerClass (Console con, boolean gameWon)
    {
	c = con;
	gameWon = gameWon;
    }


    // outputs the timer - start from 00:00
    private void timer ()
    {
	int minute = 0, second = 0;
	while (!gameWon)
	{
	    c.setColor (new Color (35, 130, 50));
	    c.fillRect (750, 30, 70, 20);
	    c.setColor (Color.black);
	    c.drawString ("Time: " + minute + ":" + second, 750, 50);
	    try
	    {
		sleep (1000);
	    }
	    catch (InterruptedException e)
	    {
	    }
	    second++;
	    time++;
	    if (second == 60)
	    {
		second = 0;
		minute++;
	    }
	}
    }


    public int getTime ()
    {
	return time;
    }


    public void run ()
    {
	timer ();
    }
}
