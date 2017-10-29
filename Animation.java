/*  Name: Angela Zhu
    Teacher: Ms. Dyke
    Date: Dec. 12, 2014
    Assignment: Animation for Mahjong game.

    *** Variable chart -- instance & class variables
    Name        |    Type           |    Purpose
    ------------|-------------------|----------------------------------------------------------------------------
    c           |    reference      |    This is the reference variable associated with the class,
		|    variable       |    it gives access to all the methods already written in the Console file.
    ------------|-------------------|----------------------------------------------------------------------------
    tilePic     |    String[]       |    The file names of the pictures needed for the animation.
    ------------|-------------------|----------------------------------------------------------------------------
    picture     |    Image[]        |    The 16 pictures of mahjong tiles needed for the animation.
*/
import java.awt.*;
import java.lang.*;
import hsa.Console;

public class Animation extends Thread
{
    private Console c;
    private String[] tilePic = new String [16];
    private Image[] picture = new Image [16];

    // animation1 - the animation of the title
    public void animation1 ()
    {
	c.setColor (new Color (64, 0, 128));
	c.setFont (new Font ("Bradley Hand ITC", Font.BOLD, 90));
	// loop used to animate the title
	for (int x = 0 ; x < 600 ; x++) // x - int - loop variable
	{
	    c.setColor (new Color (170, 145, 190));
	    c.fillRect (-400 + x, 150, 370, 105);
	    c.fillRect (880 - x, 275, 200, 70);
	    c.fillRect (-200 + x, 390, 270, 70);
	    c.setColor (new Color (64, 0, 128));
	    c.drawString ("Mahjong", -400 + x, 220);
	    c.drawString ("Tiles", 880 - x, 340);
	    c.drawString ("Game!", -200 + x, 440);
	    try     //try block for animation, catches InterruptedException
	    {
		sleep (3);
	    }
	    catch (InterruptedException e) // e - exception variable - for the exception
	    {
	    }
	}
    }


    // animation2 - the animation of the tiles
    public void animation2 ()
    {
	MediaTracker tracker = new MediaTracker (new Frame ());
	// loop used to load the 16 mahjong tile pictures
	for (int x = 0 ; x < 4 ; x++) // x - int -  loop variable
	{
	    tilePic [x] = "Tile" + (x * 9 + 1) + ".jpg";
	    picture [x] = Toolkit.getDefaultToolkit ().getImage (tilePic [x]);
	    tracker.addImage (picture [x], x);

	    tilePic [x + 4] = "Tile" + (x + 35) + ".jpg";
	    picture [x + 4] = Toolkit.getDefaultToolkit ().getImage (tilePic [x + 4]);
	    tracker.addImage (picture [x + 4], x + 4);

	    tilePic [x + 8] = "Tile" + (x + 39) + ".jpg";
	    picture [x + 8] = Toolkit.getDefaultToolkit ().getImage (tilePic [x + 8]);
	    tracker.addImage (picture [x + 8], x + 8);

	    tilePic [x + 12] = "Tile" + (x + 29) + ".jpg";
	    picture [x + 12] = Toolkit.getDefaultToolkit ().getImage (tilePic [x + 12]);
	    tracker.addImage (picture [x + 12], x + 12);
	}
	try // try block for loading the pictures, catches InterrptedException
	{
	    tracker.waitForAll ();
	}
	catch (InterruptedException e) // e - exception variable - for the exception
	{
	}
	for (int y = 0 ; y <= 305 ; y++)    // loop for animating the tiles.
	{
	    for (int x = 0 ; x < 4 ; x++)   // loop for drawing the 16 pictures.
	    {
		c.drawImage (picture [x], -109 + x * 61 + y, -229 + (3 - x) * 61 + y, null);
		c.drawImage (picture [x + 4], 928 - x * 61 - y, -229 + (3 - x) * 61 + y, null);
		c.drawImage (picture [x + 8], -109 + x * 61 + y, 824 - (3 - x) * 61 - y, null);
		c.drawImage (picture [x + 12], 928 - x * 61 - y, 824 - (3 - x) * 61 - y, null);
	    }
	    try // try block for animation, catches InterruptedException
	    {
		sleep (8);
	    }
	    catch (InterruptedException e)
	    {
	    }
	}
    }


    public Animation (Console con)
    {
	c = con;
    }


    public void run ()
    {
	animation1 ();
	animation2 ();
    }
}
